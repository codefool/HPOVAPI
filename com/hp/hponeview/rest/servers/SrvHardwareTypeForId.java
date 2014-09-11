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

import com.hp.hponeview.data.servers.ServerHardwareType;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;

public class SrvHardwareTypeForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvHardwareTypeForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareTypeForId.optionalParms; };
	public static final String  _URI = "server-hardware-types/%s/";

	/**
	 * Implements /rest/server-hardware-types/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-hardware-types
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server resource id of interest.
	 * @return com.hp.hponeview.data.servers.ServerHardwareType
	 */
	public static class ReqSrvHardwareTypeForId extends HPOneViewRestRequest<ReqSrvHardwareTypeForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqSrvHardwareTypeForId( Connection conn, String id ) {
			super( conn, String.format( _URI,  id ), ReqSrvHardwareTypeForId.class, requiredParms, optionalParms );
		}

		public ServerHardwareType get() throws Exception { 
			return super.get(ServerHardwareType.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerHardwareType.class.
     */
    public static Class<ServerHardwareType> retType() { return ServerHardwareType.class; }

    /**
	 * Convert a string containing JSON into an instance of ServerHardwareType.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerHardwareType.
	 */
	public static ServerHardwareType fromJsonString( String json ) {
		return util.fromJsonString( ServerHardwareType.class, json );
	}

	/**
	 * Returns a new instance of ReqSslCertificateForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSslCertificateForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareTypeForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareTypeForId( conn, id );
		throw new HPOneViewApiVersionException( SrvHardwareTypeForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
