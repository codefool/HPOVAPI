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

import com.hp.hponeview.data.servers.JavaRemoteConsoleUrlResult;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvHardwareJavaRemoteConsoleUrlForId {
	public static final Integer _MINAPIVERSION = 1;
	public static final Integer requiredParms() { return ReqSrvHardwareJavaRemoteConsoleUrlForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareJavaRemoteConsoleUrlForId.optionalParms; };
	public static final String  _URI = "server-hardware/%s/javaRemoteConsoleUrl/";

	/**
	 * Implements /rest/server-hardware/{id}/javaRemoteConsoleUrl/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/server-hardware.html#d4e263
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server resource id of interest.
	 * @return com.hp.hponeview.data.servers.JavaRemoteConsoleUrlResult
	 */
	public static class ReqSrvHardwareJavaRemoteConsoleUrlForId extends HPOneViewRestRequest<ReqSrvHardwareJavaRemoteConsoleUrlForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvHardwareJavaRemoteConsoleUrlForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvHardwareJavaRemoteConsoleUrlForId.class, requiredParms, optionalParms );
		}

		public JavaRemoteConsoleUrlResult get() throws Exception { 
			return super.get(JavaRemoteConsoleUrlResult.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return JavaRemoteConsoleUrlResult.class.
     */
    public static Class<JavaRemoteConsoleUrlResult> retType() { return JavaRemoteConsoleUrlResult.class; }

    /**
	 * Convert a string containing JSON into an instance of JavaRemoteConsoleUrlResult.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.JavaRemoteConsoleUrlResult.
	 */
	public static JavaRemoteConsoleUrlResult fromJsonString( String json ) {
		return util.fromJsonString( JavaRemoteConsoleUrlResult.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvHardwareJavaRemoteConsoleUrlForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the hardware id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvHardwareJavaRemoteConsoleUrlForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareJavaRemoteConsoleUrlForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareJavaRemoteConsoleUrlForId( conn, id );
		throw new HPOneViewApiVersionException( SrvHardwareJavaRemoteConsoleUrlForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
