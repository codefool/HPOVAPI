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

public class SrvEnclosureGroupScriptForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureGroupScriptForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureGroupScriptForId.optionalParms; };
	public static final String  _URI = "enclosure-groups/%s/script/";

	/**
	 * Implements /rest/enclosure-groups/{id}/script
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosure-groups
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the configuration script for the provided enclosure group id
	 * @return String
	 */
	public static class ReqSrvEnclosureGroupScriptForId extends HPOneViewRestRequest<ReqSrvEnclosureGroupScriptForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvEnclosureGroupScriptForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvEnclosureGroupScriptForId.class, requiredParms, optionalParms );
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
	 * Convert a string in JSON format to an instance of String.
	 * @param json - String containing JSON.
	 * @return String
	 */
	public static Object fromJsonString( String json ) {
		return util.fromJsonString( Object.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureGroupScriptForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id-pool id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureGroupForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvEnclosureGroupScriptForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureGroupScriptForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureGroupScriptForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
