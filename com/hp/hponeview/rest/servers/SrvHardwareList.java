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

import com.hp.hponeview.data.servers.ServerHardwareList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvHardwareList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvHardwareList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareList.optionalParms; };
	public static final String  _URI = "server-hardware/";

	/**
	 * Implements /rest/server-hardware/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-hardware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.ServerHardwareList
	 */
	public static class ReqSrvHardwareList extends HPOneViewRestRequest<ReqSrvHardwareList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSrvHardwareList( Connection conn ) {
			super( conn, _URI, ReqSrvHardwareList.class, requiredParms, optionalParms );
		}

		public ServerHardwareList get() throws Exception { 
			return super.get(ServerHardwareList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerHardwareList.class.
     */
    public static Class<ServerHardwareList> retType() { return ServerHardwareList.class; }

	/**
	 * Convert a string containing JSON into an instance of ServerHardwareList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerHardwareList
	 */
	public static ServerHardwareList fromJsonString( String json ) {
		return util.fromJsonString(ServerHardwareList.class, json);
	}
	
	/**
	 * Returns a new instance of ReqSrvHardwareList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvHardwareList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareList( conn );
		throw new HPOneViewApiVersionException( SrvHardwareList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
