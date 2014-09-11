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

import com.hp.hponeview.data.servers.ServerProfileListV3;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvProfileList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvProfileList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvProfileList.optionalParms; };
	public static final String  _URI = "server-profiles/";

	/**
	 * Implements /rest/server-profiles/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/server-profiles.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.ServerProfileListV3
	 */
	public static class ReqSrvProfileList extends HPOneViewRestRequest<ReqSrvProfileList>	{
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSrvProfileList( Connection conn ) {
			super( conn, _URI, ReqSrvProfileList.class, requiredParms, optionalParms );
		}
		
		public ServerProfileListV3 get() throws Exception { 
			return super.get(ServerProfileListV3.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ServerProfileListV3.class.
     */
    public static Class<ServerProfileListV3> retType() { return ServerProfileListV3.class; }

    /**
	 * Convert a string containing JSON into an instance of ServerProfileListV1.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ServerProfileListV3.
	 */
	public static ServerProfileListV3 fromJsonString( String json ) {
		return util.fromJsonString( ServerProfileListV3.class, json );
	}

	/**
	 * Returns a new instance of ReqRoleList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqRoleList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvProfileList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvProfileList( conn );
		throw new HPOneViewApiVersionException( SrvProfileList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
