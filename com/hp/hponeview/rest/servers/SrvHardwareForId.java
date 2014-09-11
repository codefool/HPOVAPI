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

import com.hp.hponeview.data.servers.ServerHardware;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;

public class SrvHardwareForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvHardwareForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareForId.optionalParms; };
	public static final String  _URI = "server-hardware/%s/";

	/**
	 * Implements /rest/server-hardware/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-hardware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server resource id of interest.
	 * @return com.hp.hponeview.data.servers.ServerHardware
	 */
	public static class ReqSrvHardwareForId extends HPOneViewRestRequest<ReqSrvHardwareForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqSrvHardwareForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvHardwareForId.class, requiredParms, optionalParms );
		}

		public ServerHardware get() throws Exception { 
			return super.get(ServerHardware.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerHardware.class.
     */
    public static Class<ServerHardware> retType() { return ServerHardware.class; }

    /**
	 * Convert a string containing JSON into an instance of ServerHardware.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerHardware.
	 */
	public static ServerHardware fromJsonString( String json ) {
		return util.fromJsonString( ServerHardware.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvHardwareForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvHardwareForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareForId( conn, id );
		throw new HPOneViewApiVersionException( SrvHardwareForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
