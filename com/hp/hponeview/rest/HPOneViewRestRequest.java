/*****************************************************************************
*
* copyright.txt
*
* Copyright 2014 Hewlett-Packard Development Company, L.P.
*
* Hewlett-Packard and the Hewlett-Packard logo are trademarks of
* Hewlett-Packard Development Company, L.P. in the U.S. and/or other countries.
*
* Confidential computer software. Valid license from Hewlett-Packard required
* for possession, use or copying. Consistent with FAR 12.211 and 12.212,
* Commercial Computer Software, Computer Software Documentation, and Technical
* Data for Commercial Items are licensed to the U.S. Government under
* vendor's standard commercial license.
*
* Author:
* 	Gary Hester
* 
* Description:
*
*****************************************************************************/

package com.hp.hponeview.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.hp.hponeview.data.OneViewError;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewRestException;

/**
 * An abstract class upon which all HP OneView API classes are derived. It is intended to
 * provide a simple framework for providing logins, handling API parameters, allow chaining of 
 * calls from instantiation through execution, and provide basic error and exception handling.
 *  
 * @author hesterg
 *
 * @param <T> Type of the derived class. e.g., HPOneViewRestRequest<DerivedClassName>
 */
public abstract class HPOneViewRestRequest<T> {
	/*******************************************************************************************/
	/*																						   */
	/* Class members and methods 															   */
	/*																						   */
	/*******************************************************************************************/
	protected static Logger logger = null;

	/**
	 * Bitmap values for parameters. These are bit positions, so duplicates will confuse things.
	 * Since java does not have an unsigned type, reserve the high bit (0x80000000) as that bit
	 * would turn things negative, and sign extension will get real confusing.
	 * <p>
	 * These values should be binary OR'd together in the ctor call to indicate which parameters
	 * are allowed.
	 */
	public static final Integer PNONE        = 0;
	public static final Integer PCOUNT       = 0x00000001;
	public static final Integer PSTART       = 0x00000002;
	public static final Integer PSORT        = 0x00000004;
	public static final Integer PQUERY       = 0x00000008;
	public static final Integer PVIEW        = 0x00000010;
	public static final Integer PFILTER      = 0x00000020;
	public static final Integer PFIELDS      = 0x00000040;
	public static final Integer PSRVHWURI    = 0x00000080;		// Server Hardware URI
	public static final Integer PSRVHWTYPURI = 0x00000100;		// Server Hardware Type URI
	public static final Integer PENCGRPURI   = 0x00000200;		// Enclosure Group URI
	public static final Integer PFORCE       = 0x00000400;
	public static final Integer PUSERQUERY   = 0x00000800;
	public static final Integer PCATEGORY    = 0x00001000;
	public static final Integer PPADDING     = 0x00002000;
	public static final Integer PREFURI      = 0x00004000;		// Reference URI
	public static final Integer PPARENTURI   = 0x00008000;
	public static final Integer PCHILDURI    = 0x00010000;
	public static final Integer PNAME        = 0x00020000;
	public static final Integer PMETRIC      = 0x00040000;
	public static final Integer PREFRESH     = 0x00080000;
	public static final Integer PURI         = 0x00100000;
	public static final Integer PCHILDDEPTH  = 0x00200000;
	public static final Integer PPARDEPTH    = 0x00400000; 		// parent depth
	public static final Integer PDETAILS     = 0x00800000;
	public static final Integer PCHILDLIM    = 0x01000000;		// childLimit
	public static final Integer PTREELIMIT   = 0x02000000;
	public static final Integer PNAMEPFIX    = 0x04000000;		// name prefix
	public static final Integer PFORMAT      = 0x08000000;		// format
	public static final Integer PALL         = 0x0fffffff;		// ALL parameters
	
	// since Java doesn't support unsigned, make sure high bit is never used.
	public static final Integer PDONOTUSE    = 0x80000000;

	// set of parameters supported by *most* collection types
	// S - start
	// C - count
	// T - sort
	// Q - query
	// F - fields
	// V - view
	// L - filter
	protected static Integer PSCTQVFL = PCOUNT | PFIELDS | PFILTER | PQUERY | PSORT | PSTART | PVIEW;
	protected static Integer PSCTQVL  = PSTART | PCOUNT | PSORT | PQUERY | PVIEW | PFILTER;
	protected static Integer PSCTL    = PSTART | PCOUNT | PSORT | PFILTER;

	/**
	 * Information about a specific parameter.
	 * @author hesterg
	 * @param verb - String with human-readable name of the parameter - e.g. "view"
	 * @param bit - the bit value assigned to this verb
	 * @param type - Class of value type - e.g. Integer.class
	 */
	public static final class ParameterInfo {
		public String   verb;
		public Integer	bit;
		public Class<?> type;
		public ParameterInfo(String verb, Integer bit, Class<?> type )
		{
			this.verb = verb;
			this.bit  = bit;
			this.type = type;
		}
	}

	// verb2bit - maps the parameter verb to its parameter info
	// bit2verb - maps the parameter bit value to its verb
	// allValidParms - a bitmap that contains all allocated bits. If you want to add a new
	//				   parameter programatically, it cannot be set in this map.
	protected static final Map<String,ParameterInfo> verb2bit;
	protected static final Map<Integer,String>       bit2verb;
	protected static Integer 						 allValidParms = 0;

	static {
		verb2bit = new HashMap<String,ParameterInfo>();
		bit2verb = new HashMap<Integer,String>();
		try {
			//                 Verb                     Bit           Type
			addValidParameter( "count"                , PCOUNT      , Integer.class );
			addValidParameter( "start" 		          , PSTART      , Integer.class );
			addValidParameter( "sort"  		          , PSORT       , String .class );
			addValidParameter( "query" 		          , PQUERY      , String .class );
			addValidParameter( "view"  			      , PVIEW       , String .class );
			addValidParameter( "filter"			      , PFILTER     , String .class );
			addValidParameter( "fields"			      , PFIELDS     , String .class );
			addValidParameter( "force" 			      , PFORCE      , Boolean.class );
			addValidParameter( "userQuery"			  , PUSERQUERY  , String .class );
			addValidParameter( "category"			  , PCATEGORY   , String .class );
			addValidParameter( "padding"			  , PPADDING    , Integer.class );
			addValidParameter( "referenceUri"		  , PREFURI     , String .class );
			addValidParameter( "parentUri"			  , PPARENTURI  , String .class );
			addValidParameter( "childUri" 			  , PCHILDURI   , String .class );
			addValidParameter( "name"     			  , PNAME       , String .class );
			addValidParameter( "serverHardwareUri"	  , PSRVHWURI   , String .class );
			addValidParameter( "serverHardwareTypeUri", PSRVHWTYPURI, String .class );
			addValidParameter( "enclosureGroupUri"    , PENCGRPURI  , String .class );
			addValidParameter( "metric"    			  , PMETRIC     , String .class );
			addValidParameter( "refresh"    		  , PREFRESH	, String .class );
			addValidParameter( "uri"    		      , PURI		, String .class );
			addValidParameter( "childDepth"           , PCHILDDEPTH , Integer.class );
			addValidParameter( "parentDepth"          , PPARDEPTH   , Integer.class );
			addValidParameter( "details"              , PDETAILS    , Boolean.class );
			addValidParameter( "childLimit"           , PCHILDLIM   , Integer.class );
			addValidParameter( "treeLimit"            , PTREELIMIT  , Integer.class );
			addValidParameter( "namePrefix"           , PNAMEPFIX   , String .class );
			addValidParameter( "format"               , PFORMAT     , String .class );
		}
		catch (Exception e ) {
		}
	}

	/**
	 * Add an allowed parameter to the global allowed parameters map. After it is defined, the bit may be used
	 * as part of the map in the ctor.
	 * @param verb - String containing verb. Must be unique.
	 * @param bit  - Bit to assigned to the verb. Must be unique.
	 * @param ptype - Class of parameter - e.g. Integer.class
	 * @throws Exception - If verb or bit is already used.
	 */
	public static void addValidParameter(String verb, Integer bit, Class<?> ptype) throws Exception
	{
		if( verb2bit.containsKey(verb) ) 
			throw new Exception( "Parameter '" + verb +"' already exists." );
		if( ( bit & allValidParms ) != 0 ) 
			throw new Exception( "Bit " + bit.toString() + " already used." );
		allValidParms |= bit;
		verb2bit.put( verb, new ParameterInfo( verb, bit, ptype ) );
		bit2verb.put( bit,  verb );
	}

	/**
	 * Retrieve the map of all currently used parameter bits. This is useful only in determining
	 * which bits are not currently in use for adding user-defined parameters.
	 * @return The bitmap of all valid parameters.
	 */
	public static Integer getAllValidParmsMap() {
		return allValidParms;
	}
	
	/**
	 * Return the list of parameters corresponding to the given bitmap
	 * @param bitmap - an Integer bitmap of options to decode.
	 * @return List<BasicRestRequest.ParameterInfo>
	 */
	public static List<ParameterInfo> getParameterList( Integer bitmap ) {
		List<ParameterInfo> ret = new ArrayList<ParameterInfo>();
		for( ParameterInfo entry : verb2bit.values() ) {
			if( ( entry.bit & bitmap ) != 0 )
				ret.add( entry );
		}
		return ret;
	}


	/*******************************************************************************************/
	/*																						   */
	/* Instance members and methods															   */
	/*																						   */
	/*******************************************************************************************/
	protected URIBuilder uriBuilder  = null;
	protected Connection conn;
	protected Class<T>   type;
	protected HashMap<String,String> headers;		// list of HTTP headers to include in call
	private Integer 	 reqParms = 0;			// bitmap of required parameters
	private Integer 	 optParms = 0;			// bitmap of optional parameters
	private Integer 	 setParms = 0;			// bitmap of parameters actually set. setParms & reqParms == setParms or fail! 
	
	/**
	 * Constructor.
	 * @param conn com.hp.hponeview.rest.Connection object to the HP OneView server
	 * @param path String containing the URI to send to the HP OneView server. If path does
	 * not begin with /rest/, then it is added. 
	 * @param type A Class object containing the type of the derived class.
	 * @param reqParms Integer bitmap that contains which parameters are REQUIRED for this REST call. 
	 *                 If no parameters are required, use PNONE.
	 * @param optParms Integer bitmap that contains which parameters are OPTIONAL for this REST call. 
	 *                 If no parameters are required, use PNONE.
	 */
	protected HPOneViewRestRequest( Connection conn, String path, Class<T> type, Integer reqParms, Integer optParms )	{
		if( logger == null ) {
			logger = Logger.getLogger(type);
			logger.setLevel(Level.DEBUG);
		}
		this.conn = conn;
		this.type = type;
		this.reqParms = reqParms;
		this.optParms = optParms;
		this.setParms = PNONE;
		this.headers  = new HashMap<String,String>();
		try {
			if( !path.startsWith("/rest/") )
				path = "/rest/" + path;
			uriBuilder  = new URIBuilder( "https://" + conn.serverAddr() + path );
		}
		catch( URISyntaxException e ) {
			logger.error( e );
		}
	}
	
	/**
	 * Set the Connection object.
	 * @param conn - Connection object to the HP OneView server.
	 * @return The prior Connection object.
	 */
	public Connection setConnection( Connection conn ) {
		Connection ret = this.conn;
		this.conn = conn;
		return ret;
	}
	
	/**
	 * Get the Connection object.
	 * @return The Connection object for this request.
	 */
	public Connection conn() {
		return this.conn;
	}
	
	/**
	 * Set the URIBuilder path with the given path.
	 * @param path - String containing the new path. This will be built into the URI 
	 *               https://<server addr>/rest/<path>
	 */
	public final void setPath( String path )	{
		uriBuilder.setPath( "https://" + conn.serverAddr() + "/rest/" + path );
	}

	/**
	 * Return the URIBuilder instance for this REST command.
	 * @return Instance of URIBuilder
	 */
	public final URIBuilder getBuilder() {
		return uriBuilder;
	}
	
	/**
	 * Set the required parameter bitmap.
	 * @param requiredOptions - Integer containing the map of required parameters.
	 * @return The prior required options bitmap.
	 */
	public Integer setRequiredParmsMap( Integer reqParmsMap ) {
		Integer tmp = reqParms;
		reqParms = reqParmsMap;
		return tmp;
	}

	/**
	 * Set the optional parameter bitmap.
	 * @param optionalOptions - Integer containing the map of optional parameters.
	 * @return The prior optional options bitmap.
	 */
	public Integer setOptionalParmsMap( Integer optParmsMap ) {
		Integer tmp = optParms;
		optParms = optParmsMap;
		return tmp;
	}

	/**
	 * Retrieve the current required parameters bitmap.
	 * @return The bitmap of the currently allowed parameters.
	 */
	public Integer getRequiredParmsMap() {
		return reqParms;
	}

	/**
	 * Retrieve the current optional parameters bitmap.
	 * @return The bitmap of the currently allowed parameters.
	 */
	public Integer getOptionalParmsMap() {
		return optParms;
	}
	
	/**
	 * Retrieve a list of allowed parameters for this REST call.
	 * @return List<BasicRestRequest.ParameterInfo>
	 */
	public List<ParameterInfo> getAllowedParmsList() {
		List<ParameterInfo> ret = new ArrayList<ParameterInfo>();
		for( ParameterInfo entry : verb2bit.values() ) {
			if( isParmAllowed( entry.bit ) )
				ret.add( entry );
		}
		return ret;
	}

	/** 
	 * Test to see if a given parameter is allowed for this REST call.
	 * @param parmBit - The bit value to test 
	 * @return True if the parameter is allowed, False otherwise.
	 */
	public Boolean isParmAllowed( Integer parmBit ) {
		return ( parmBit & ( reqParms | optParms ) ) != 0;
	}
	
	// The following are convenience methods that can be chained.
	// e.g. class.instance(conn).setCount(1).setStart(1).get();
	/**
	 * Sets the "count" parameter for the REST request.
	 * @param val - the Integer count value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setCount(Integer val) throws Exception { 
		setParameter( PCOUNT, val );     
		return type.cast(this); 
	}
	/**
	 * Sets the "start" parameter for the REST request.
	 * @param val - the Integer start value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setStart(Integer val) throws Exception { 
		setParameter( PSTART, val );     			 
		return type.cast(this); 
	}
	/**
	 * Sets the "sort" parameter for the REST request.
	 * @param val - the String sort value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setSort(String val) throws Exception { 
		setParameter( PSORT, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "query" parameter for the REST request.
	 * @param val - the String query value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setQuery(String val) throws Exception { 
		setParameter( PQUERY, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "view" parameter for the REST request.
	 * @param val - the String view value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setView(String val) throws Exception { 
		setParameter( PVIEW, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "filter" parameter for the REST request.
	 * @param val - the String filter value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setFilter(String val) throws Exception { 
		setParameter( PFILTER, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "force" parameter for the REST request.
	 * @param val - the Boolean force value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setForce(Boolean val) throws Exception { 
		setParameter( PFORCE, val ); 
		return type.cast(this); 
	}
	/**
	 * Sets the "userQuery" parameter for the REST request.
	 * @param val - the String userQuery value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setUserQuery(String val) throws Exception { 
		setParameter( PUSERQUERY, val );			 
		return type.cast(this); 
	}
	/**
	 * Sets the "category" parameter for the REST request.
	 * @param val - the String category value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setCategory(String val) throws Exception { 
		setParameter( PCATEGORY, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "padding" parameter for the REST request.
	 * @param val - the Integer padding value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setPadding(Integer val) throws Exception { 
		setParameter( PPADDING, val );    
		return type.cast(this); 
	}
	/**
	 * Sets the "referenceUri" parameter for the REST request.
	 * @param val - the String referenceUri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setReferenceUri(String val) throws Exception { 
		setParameter( PREFURI, val ); 	         	 
		return type.cast(this); 
	}
	/**
	 * Sets the "parentUri" parameter for the REST request.
	 * @param val - the String parentUri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setParentUri(String val) throws Exception { 
		setParameter( PPARENTURI, val ); 			 
		return type.cast(this); 
	}
	/**
	 * Sets the "childUri" parameter for the REST request.
	 * @param val - the String childUri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setChildUri(String val) throws Exception { 
		setParameter( PCHILDURI, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "name" parameter for the REST request.
	 * @param val - the String name value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setName(String val) throws Exception { 
		setParameter( PNAME, val );				     
		return type.cast(this); 
	}
	/**
	 * Sets the "serverHardwareUri" parameter for the REST request.
	 * @param val - the String serverHardwareUri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setServerHardwareUri(String val) throws Exception { 
		setParameter( PSRVHWURI, val ); 			 
		return type.cast(this); 
	}
	/**
	 * Sets the "serverHardwareTypeUri" parameter for the REST request.
	 * @param val - the String serverHardwareTypeUri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setServerHardwareTypeUri(String val) throws Exception { 
		setParameter( PSRVHWTYPURI, val ); 		 
		return type.cast(this); 
	}
	/**
	 * Sets the "enclosureGroupUri" parameter for the REST request.
	 * @param val - the String enclosureGroupUri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setEnclosureGroupUri(String val) throws Exception { 
		setParameter( PENCGRPURI, val ); 			 
		return type.cast(this); 
	}
	/**
	 * Sets the "metric" parameter for the REST request.
	 * @param val - the String metric value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setMetric(String val) throws Exception { 
		setParameter( PMETRIC, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "refresh" parameter for the REST request.
	 * @param val - the String refresh value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setRefresh(String val) throws Exception { 
		setParameter( PREFRESH, val );				 
		return type.cast(this); 
	}
	/**
	 * Sets the "uri" parameter for the REST request.
	 * @param val - the String uri value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setUri(String val) throws Exception { 
		setParameter( PURI, val );				     
		return type.cast(this); 
	}
	/**
	 * Sets the "childDepth" parameter for the REST request.
	 * @param val - the Integer childDepth value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setChildDepth( Integer val ) throws Exception { 
		setParameter( PCHILDDEPTH, val );           
		return type.cast(this); 
	}
	/**
	 * Sets the "parentDepth" parameter for the REST request.
	 * @param val - the Integer parentDepth value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setParentDepth(Integer val) throws Exception { 
		setParameter( PPARDEPTH, val );             
		return type.cast(this); 
	}
	/**
	 * Sets the "details" parameter for the REST request.
	 * @param val - the Boolean details value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setDetails(Boolean val) throws Exception { 
		setParameter( PDETAILS, val );              
		return type.cast(this); 
	}
	/**
	 * Sets the "childLimit" parameter for the REST request.
	 * @param val - the Integer childLimit value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setChildLimit(Integer val) throws Exception { 
		setParameter( PCHILDLIM, val );             
		return type.cast(this); 
	}
	/**
	 * Sets the "treeLimit" parameter for the REST request.
	 * @param val - the Integer treeLimit value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setTreeLimit(Integer val) throws Exception { 
		setParameter( PTREELIMIT, val );            
		return type.cast(this); 
	}

	/**
	 * Sets the "namePrefix" parameter for the REST request.
	 * @param val - the String name prefix value in context with the particular call.
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setNamePrefix(String val) throws Exception { 
		setParameter( PNAMEPFIX, val );            
		return type.cast(this); 
	}

	/**
	 * Sets the "format" parameter for the REST request.
	 * @param val - String containing the format code
	 * @return this
	 * @throws Exception if parameter cannot be set.
	 */
	public T setFormat(String val) throws Exception { 
		setParameter( PFORMAT, val );            
		return type.cast(this); 
	}

	/**
	 * Set a parameter value through a name/value pair.
	 * @param verb - String containing the verb
	 * @param val - Object containing the value. Type must be appropriate for parameter.
	 * @return this.
	 * @throws HPOneViewApiParmException - If verb is not known, 
	 *                     				   or verb is not allowed for this REST call, 
	 *                     				   or type of val is not valid for parameter.
	 */
	public T setParameter(String verb, Object val) throws HPOneViewApiParmException	{
		if( !verb2bit.containsKey(verb) ) 
			throw new HPOneViewApiParmException( HPOneViewApiParmException.Reason.UNKNOWN_PARM, type.getCanonicalName(), verb, "Unknown parameter '" + verb + "'" );
		ParameterInfo pinfo = verb2bit.get(verb);
		if( !isParmAllowed( pinfo.bit ) ) 
			throw new HPOneViewApiParmException( HPOneViewApiParmException.Reason.INVALID_PARM, type.getCanonicalName(), verb, "'" + verb + "' is not a valid parameter for " + type.getCanonicalName() );
		if( !( val.getClass().equals( pinfo.type ) ) ) 
			throw new HPOneViewApiParmException( HPOneViewApiParmException.Reason.BAD_PARM_TYPE, type.getCanonicalName(), verb, 
			    "Call " + type.getCanonicalName() + " for parameter '" + verb + "' was passed " + val.getClass().getCanonicalName() + " but expected " + pinfo.type.getCanonicalName() 
		);
		String sVal = "";
		if( val instanceof String )
			sVal = (String)val;
		else if( val instanceof Integer )
			sVal = val.toString();
		else if( val instanceof Boolean )
			sVal = val.toString(); 
			
		uriBuilder.addParameter(verb, sVal);
		setParms |= pinfo.bit;
		return type.cast(this);
	}
	
	/**
	 * Set a parameter value through a bit/value pair.
	 * @param bit - Integer containing ordinal of the parameter being set.
	 * @param val - Object containing the value. Type must be appropriate for parameter.
	 * @return this.
	 * @throws Exception - If bit is not known, or any exception by setParameter(verb,val) above. 
	 */
	public T setParameter(Integer bit, Object val ) throws Exception {
		if( !bit2verb.containsKey( bit ) )
			throw new Exception( "Unknown parameter ordinal '" + bit.toString() + "'" );
		setParameter( bit2verb.get(bit), val );
		return type.cast(this);
	}
	
	/**
	 * Bulk set parameters for this REST call through a list of name/value pairs.
	 * @param parms - Map<String,String> of name/value pairs.
	 * @return this.
	 * @throws Exception() - If any parameter is unknown or not allowed for this REST call.
	 */
	public T addParameters( Map<String,String> parms ) throws Exception {
		for( Map.Entry<String,String> entry : parms.entrySet() )
			setParameter(entry.getKey(), entry.getValue() );
		return type.cast(this);
	}

	/**
	 * Bulk set parameters for this REST call through a list of bit/value pairs.
	 * @param parms - Map<Integer,String> of name/value pairs.
	 * @return this.
	 * @throws Exception() - If any parameter is unknown or not allowed for this REST call.
	 */
	public T addBitParameters( Map<Integer,String> parms ) throws Exception {
		for( Map.Entry<Integer,String> entry : parms.entrySet() )
			setParameter(entry.getKey(), entry.getValue() );
		return type.cast(this);
	}
	
	/**
	 * Set's the (optional) If-None-Match header of the HP OneView request.
	 * @param etag - String containing the value of the If-None-Match parameter.
	 * @return this.
	 */
	public T setIfNoneMatch( String etag ) {
		return type.cast( setHeader( "If-None-Match", etag ) );
	}
	
	/**
	 * Set a header key/value pair for use in the HTTP call
	 * @param key - String containing the header name
	 * @param value - String containing the header value.
	 */
	public T setHeader( String key, String val ) {
		headers.put( key, val );
		return type.cast( this );
	}
	

	/**
	 * Validate that all required parameters are supplied for the given call.
	 * @return true if all required parameters are provided.
	 * @throws HPOneViewApiParmException
	 */
	public Boolean validate() throws HPOneViewApiParmException {
		if( reqParms != 0 && ( setParms ^ reqParms ) != 0 ) {
			Integer needParms = ~setParms & reqParms;
			String error = "";
			for( ParameterInfo pinfo : verb2bit.values() ) {
				if( ( pinfo.bit & needParms ) != 0 ) {
					if( error.length() != 0 )
						error += ", ";
					error += pinfo.verb;
				}
			}
			throw new HPOneViewApiParmException( HPOneViewApiParmException.Reason.MISSING_PARM, type.getCanonicalName(), error,
					"Call to " + type.getCanonicalName() + " is missing parameter(s):" + error
			);
		}
		return true;
	}
	
	/**
	 * Send the built REST command to the HP OneView server. If any required parameter is
	 * not set, then fail the call.
	 * @param S - Class object of the return data type.
	 * @return An instant of class S, filled in by GSON.
	 * @throws HPOneViewApiParmException if a required parameter is not set. 
	 * @throws HPOneViewRestException if HP OneView rejects the call.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public <S> S get(Class<S> type)	throws HPOneViewNotConnectedException, HPOneViewApiParmException, HPOneViewRestException {
		validate();
		try {
			URI uri = uriBuilder.build();
			JsonElement json = conn.get( uri, headers );
			if( logger.isDebugEnabled() ) {
				logger.debug("Request:" + uri );
				logger.debug("Response:" + json);
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			if( json.isJsonObject() )
			{
				JsonObject jobj = json.getAsJsonObject();
				if( jobj.entrySet().size() == 7 && jobj.has( "errorSource" ) && jobj.has( "errorCode" ) )
				{
					throw new HPOneViewRestException( gson.fromJson( json, OneViewError.class ) );
				}
			}
			return gson.fromJson(json, type);
		}
		catch( JsonSyntaxException e) {
			logger.debug( e );
		}
		catch( java.lang.NullPointerException e) {
		}
		catch( URISyntaxException e ) {
		}
		return null;
	}
	
	/**
	 * Send the built REST command to the HP OneView server, and return the
	 * response as a JSON string with pretty-print turned OFF.
	 * @return String containing non-pretty-print the JSON of the response.
	 * @throws HPOneViewApiParmException if a required parameter is not set. 
	 * @throws HPOneViewRestException if HP OneView rejects the call.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView.
	 */
	public String getAsJsonString() throws HPOneViewNotConnectedException, HPOneViewApiParmException, HPOneViewRestException {
		return this.getAsJsonString( false );
	}
	
	/**
	 * Send the built REST command to the HP OneView server, and return the
	 * response as a JSON string.
	 * @parm prettyPrint - Boolean to set the prettyPrinting attribute for the GsonBuiler. 
	 * @return String containing the JSON of the response.
	 * @throws HPOneViewApiParmException if a required parameter is not set. 
	 * @throws HPOneViewRestException if HP OneView rejects the call.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public String getAsJsonString( Boolean prettyPrint ) throws HPOneViewNotConnectedException, HPOneViewApiParmException, HPOneViewRestException {
		validate();
		try {
			URI uri = uriBuilder.build();
			JsonElement json = conn.get( uri );
			if( logger.isDebugEnabled() ) {
				logger.debug("Request:" + uri );
				logger.debug("Response:" + json);
			}
			GsonBuilder gsonb = new GsonBuilder();
			if( prettyPrint )
				gsonb.setPrettyPrinting();
			Gson gson = gsonb.create();
			if( json.isJsonObject() )
			{
				JsonObject jobj = json.getAsJsonObject();
				if( jobj.entrySet().size() == 7 && jobj.has( "errorSource" ) && jobj.has( "errorCode" ) )
				{
					throw new HPOneViewRestException( gson.fromJson( json, OneViewError.class ) );
				}
			}
			return gson.toJson( json );
		}
		catch( JsonSyntaxException e) {
		}
		catch( java.lang.NullPointerException e) {
		}
		catch( URISyntaxException e ) {
		}
		return null;
	}
	
	/**
	 * Interpret a string containing JSON into its target object indicated by type.
	 * @param type - Class object of the return data type - e.g. String.class
	 * @param json - String containing the JSON to decode.
	 * @return An instant of class S, filled in by GSON.
	 */
	public static <S> S fromJsonString(Class<S> type, String json) {
		return util.fromJsonString( type, json );
	}

	// In this version of the REST interface, we do not support PUT, POST, or DELETE verbs.
	public <S> S put(Class<S> type) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public <S> S post(Class<S> type) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public <S> S delete(Class<S> type) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
