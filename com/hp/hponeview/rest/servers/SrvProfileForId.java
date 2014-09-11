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

import com.hp.hponeview.data.servers.ServerProfileV3;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvProfileForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvProfileForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvProfileForId.optionalParms; };
	public static final String  _URI = "server-profiles/%s/";
	
	/**
	 * Implements /rest/server-profiles/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-profiles
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server profile of interest.
	 * @return com.hp.hponeview.data.servers.ServerProfileV3
	 */
	public static class ReqSrvProfileForId extends HPOneViewRestRequest<ReqSrvProfileForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqSrvProfileForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvProfileForId.class, requiredParms, optionalParms );
		}
		
		public ServerProfileV3 get() throws Exception { 
			return super.get(ServerProfileV3.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerProfileV3.class.
     */
    public static Class<ServerProfileV3> retType() { return ServerProfileV3.class; }

    /**
	 * Convert a string containing JSON into an instance of ServerProfileV3.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerProfileV3.
	 */
	public static ServerProfileV3 fromJsonString( String json ) {
		return util.fromJsonString( ServerProfileV3.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvProfileForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSrvProfileForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvProfileForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvProfileForId( conn, id );
		throw new HPOneViewApiVersionException( SrvProfileForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
