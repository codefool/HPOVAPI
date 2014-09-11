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
package com.hp.hponeview.rest.servers;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureScriptForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureScriptForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureScriptForId.optionalParms; };
	public static final String  _URI = "enclosures/%s/script/";

	/**
	 * Implements /rest/enclosures/{id}/script
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosures
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the enclosure id of interest.
	 * @return String
	 */
	public static class ReqSrvEnclosureScriptForId extends HPOneViewRestRequest<ReqSrvEnclosureScriptForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvEnclosureScriptForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvEnclosureScriptForId.class, requiredParms, optionalParms );
		}

		public String get() throws Exception { 
			return super.get( String.class ); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return String.class.
     */
    public static Class<String> retType() { return String.class; }

    /**
	 * Convert a string containing JSON into an instance of String.
	 * @param json - String containing JSON
	 * @return String.
	 */
	public static String fromJsonString( String json ) {
		return util.fromJsonString( String.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureScriptForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id-pool id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureScriptForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvEnclosureScriptForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureScriptForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureScriptForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
