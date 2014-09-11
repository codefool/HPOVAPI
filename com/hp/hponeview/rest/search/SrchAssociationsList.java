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

import com.hp.hponeview.data.search.Associations;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchAssociationsList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchAssociationsList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchAssociationsList.optionalParms; };
	public static final String  _URI = "index/associations/";

	/**
	 * Implements /rest/index/associations/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/index/associations
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.Associations
	 */
	public static class ReqSrchAssociationsList extends HPOneViewRestRequest<ReqSrchAssociationsList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCHILDURI | PPARENTURI | PNAME;
		private ReqSrchAssociationsList(Connection conn ) {
			super( conn, _URI, ReqSrchAssociationsList.class, requiredParms, optionalParms );
		}
		
		public Associations get() throws Exception { 
			return super.get(Associations.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Associations.class.
     */
    public static Class<Associations> retType() { return Associations.class; }

    /**
	 * Convert a string containing JSON into an instance of Associations.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.Associations.
	 */
	public static Associations fromJsonString( String json ) {
		return util.fromJsonString( Associations.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchAssociationsList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect type of interest.
	 * @returns com.hp.hponeview.rest.Search.ReqSrchAssociationsList
	 */
	public static ReqSrchAssociationsList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchAssociationsList( conn );
		throw new HPOneViewApiVersionException( SrchAssociationsList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
