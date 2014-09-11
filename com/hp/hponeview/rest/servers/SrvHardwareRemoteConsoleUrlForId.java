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

import com.hp.hponeview.data.servers.RemoteConsoleUrlResult;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvHardwareRemoteConsoleUrlForId {
	public static final Integer _MINAPIVERSION = 1;
	public static final Integer requiredParms() { return ReqSrvHardwareRemoteConsoleUrlForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareRemoteConsoleUrlForId.optionalParms; };
	public static final String  _URI = "server-hardware/%s/remoteConsoleUrl/";

	/**
	 * Implements /rest/server-hardware/{id}/remoteConsoleUrl/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/server-hardware.html#d4e263
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server resource id of interest.
	 * @return com.hp.hponeview.data.servers.RemoteConsoleUrlResult
	 */
	public static class ReqSrvHardwareRemoteConsoleUrlForId extends HPOneViewRestRequest<ReqSrvHardwareRemoteConsoleUrlForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvHardwareRemoteConsoleUrlForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvHardwareRemoteConsoleUrlForId.class, requiredParms, optionalParms );
		}

		public RemoteConsoleUrlResult get() throws Exception { 
			return super.get(RemoteConsoleUrlResult.class); 
		}
	 }
    /**
     * Return the Class object for the return type for this REST call.
     * @return RemoteConsoleUrlResult.class.
     */
    public static Class<RemoteConsoleUrlResult> retType() { return RemoteConsoleUrlResult.class; }

    /**
	 * Convert a string containing JSON into an instance of RemoteConsoleUrlResult.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.RemoteConsoleUrlResult.
	 */
	public static RemoteConsoleUrlResult fromJsonString( String json ) {
		return util.fromJsonString( RemoteConsoleUrlResult.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvHardwareRemoteConsoleUrlForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the hardware id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvHardwareRemoteConsoleUrlForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareRemoteConsoleUrlForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareRemoteConsoleUrlForId( conn, id );
		throw new HPOneViewApiVersionException( SrvHardwareRemoteConsoleUrlForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
