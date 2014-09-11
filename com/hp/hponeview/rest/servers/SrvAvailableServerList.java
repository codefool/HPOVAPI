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

import com.hp.hponeview.data.servers.AvailableServer;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvAvailableServerList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvAvailableServerList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvAvailableServerList.optionalParms; };
	public static final String  _URI = "server-profiles/available-servers/";

	/**
	 * Implements /rest/server-profiles/available-servers/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-profiles
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return Array of com.hp.hponeview.data.servers.AvailableServer
	 */
	public static class ReqSrvAvailableServerList extends HPOneViewRestRequest<ReqSrvAvailableServerList>	{
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSRVHWURI | PSRVHWTYPURI | PENCGRPURI;
		private ReqSrvAvailableServerList( Connection conn ) {
			super( conn, _URI, ReqSrvAvailableServerList.class, requiredParms, optionalParms );
		}

		public AvailableServer[] get() throws Exception { 
			return super.get(AvailableServer[].class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AvailableServer[].class.
     */
    public static Class<AvailableServer[]> retType() { return AvailableServer[].class; }

	/**
	 * Convert a string containing JSON into an instance of AvailableServer[].
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.AvailableServer[]
	 */
	public static AvailableServer[] fromJsonString( String json ) {
		return util.fromJsonString(AvailableServer[].class, json);
	}

	/**
	 * Returns a new instance of ReqRoleList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqRoleList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvAvailableServerList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvAvailableServerList( conn );
		throw new HPOneViewApiVersionException( SrvAvailableServerList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
