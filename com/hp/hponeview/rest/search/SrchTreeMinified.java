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
*	Implementation of the activity REST calls for HP OneView.
*****************************************************************************/
package com.hp.hponeview.rest.search;

import com.hp.hponeview.data.search.UriTrees;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchTreeMinified {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchTreeMinified.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchTreeMinified.optionalParms; };
	public static final String  _URI = "index/trees/minified/";

	/**
	 * Implements /rest/index/trees/minified
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/index/trees
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.UriTrees
	 */
	public static class ReqSrchTreeMinified extends HPOneViewRestRequest<ReqSrchTreeMinified> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL | PUSERQUERY | PCATEGORY | PCHILDDEPTH 
				                                  | PPARDEPTH | PTREELIMIT | PDETAILS;
		private ReqSrchTreeMinified(Connection conn ) {
			super( conn, _URI, ReqSrchTreeMinified.class, requiredParms, optionalParms );
		}
		
		public UriTrees get() throws Exception { 
			return super.get(UriTrees.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UriTrees.class.
     */
    public static Class<UriTrees> retType() { return UriTrees.class; }

    /**
	 * Convert a string containing JSON into an instance of UriTrees.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.UriTrees.
	 */
	public static UriTrees fromJsonString( String json ) {
		return util.fromJsonString( UriTrees.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchTreeMinified
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Search.ReqSrchTreeMinified
	 */
	public static ReqSrchTreeMinified instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchTreeMinified( conn );
		throw new HPOneViewApiVersionException( SrchTreeMinified.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
