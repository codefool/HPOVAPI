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

import com.hp.hponeview.data.servers.ServerHardwareTypeList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvHardwareTypeList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvHardwareTypeList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareTypeList.optionalParms; };
	public static final String  _URI = "server-hardware-types/";

	/**
	 * Implements /rest/server-hardware-types/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-hardware-types
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server resource id of interest.
	 * @return com.hp.hponeview.data.servers.ServerHardwareTypeList
	 */
	public static class ReqSrvHardwareTypeList extends HPOneViewRestRequest<ReqSrvHardwareTypeList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSrvHardwareTypeList( Connection conn ) {
			super( conn, _URI, ReqSrvHardwareTypeList.class, requiredParms, optionalParms );
		}

		public ServerHardwareTypeList get() throws Exception { 
			return super.get(ServerHardwareTypeList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerHardwareTypeList.class.
     */
    public static Class<ServerHardwareTypeList> retType() { return ServerHardwareTypeList.class; }

    /**
	 * Convert a string containing JSON into an instance of ServerHardwareTypeList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerHardwareTypeList.
	 */
	public static ServerHardwareTypeList fromJsonString( String json ) {
		return util.fromJsonString( ServerHardwareTypeList.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvHardwareTypeList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSrvHardwareTypeList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareTypeList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareTypeList( conn );
		throw new HPOneViewApiVersionException( SrvHardwareTypeList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
