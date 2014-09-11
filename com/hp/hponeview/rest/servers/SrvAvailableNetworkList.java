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

import com.hp.hponeview.data.servers.AvailableNetworksV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvAvailableNetworkList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvAvailableNetworkList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvAvailableNetworkList.optionalParms; };
	public static final String  _URI = "server-profiles/available-networks/";

	/**
	 * Implements /rest/server-profiles/available-networks/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/server-profiles.html#d4e160
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.AvailableNetworksV2
	 */
	public static class ReqSrvAvailableNetworkList extends HPOneViewRestRequest<ReqSrvAvailableNetworkList> {
		public static final Integer requiredParms = PSRVHWURI | PSRVHWTYPURI | PENCGRPURI;
		public static final Integer optionalParms = PNONE;
		private ReqSrvAvailableNetworkList( Connection conn ) {
			super( conn, _URI, ReqSrvAvailableNetworkList.class, requiredParms, optionalParms );
		}

		public AvailableNetworksV2 get() throws Exception { 
			return super.get(AvailableNetworksV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AvailableNetworksV2.class.
     */
    public static Class<AvailableNetworksV2> retType() { return AvailableNetworksV2.class; }

	/**
	 * Convert a string containing JSON into an instance of AvailableNetworksV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.AvailableNetworksV2
	 */
	public static AvailableNetworksV2 fromJsonString( String json ) {
		return util.fromJsonString(AvailableNetworksV2.class, json);
	}

	/**
	 * Returns a new instance of ReqRoleList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqRoleList
	 */
	public static ReqSrvAvailableNetworkList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvAvailableNetworkList( conn );
		throw new HPOneViewApiVersionException( SrvAvailableNetworkList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
