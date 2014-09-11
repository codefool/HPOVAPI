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

import com.hp.hponeview.data.servers.ServerProfileHealth;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvProfileMessagesForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvProfileMessagesForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvProfileMessagesForId.optionalParms; };
	public static final String  _URI = "server-profiles/%s/messages/";
	
	/**
	 * Implements /rest/server-profiles/{id}/messages/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-profiles
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server profile id of interest.
	 * @return com.hp.hponeview.data.servers.ServerProfileHealth
	 */
	public static class ReqSrvProfileMessagesForId extends HPOneViewRestRequest<ReqSrvProfileMessagesForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvProfileMessagesForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvProfileMessagesForId.class, requiredParms, optionalParms );
		}
		
		public ServerProfileHealth get() throws Exception { 
			return super.get(ServerProfileHealth.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerProfileHealth.class.
     */
    public static Class<ServerProfileHealth> retType() { return ServerProfileHealth.class; }

    /**
	 * Convert a string containing JSON into an instance of ServerProfileHealth.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerProfileHealth.
	 */
	public static ServerProfileHealth fromJsonString( String json ) {
		return util.fromJsonString( ServerProfileHealth.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvProfileMessagesForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvProfileMessagesForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvProfileMessagesForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvProfileMessagesForId( conn, id );
		throw new HPOneViewApiVersionException( SrvProfileMessagesForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
