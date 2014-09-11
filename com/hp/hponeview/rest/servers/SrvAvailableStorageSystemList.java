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

import com.hp.hponeview.data.servers.AvailableStorageSystems;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvAvailableStorageSystemList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvAvailableStorageSystemList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvAvailableStorageSystemList.optionalParms; };
	public static final String  _URI = "server-profiles/available-storage-systems/";

	/**
	 * Implements /rest/server-profiles/available-storage-systems/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-profiles
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.AvailableStorageSystems
	 */
	public static class ReqSrvAvailableStorageSystemList extends HPOneViewRestRequest<ReqSrvAvailableStorageSystemList>	{
		public static final Integer requiredParms = PENCGRPURI | PSRVHWTYPURI;
		public static final Integer optionalParms = PCOUNT | PFILTER | PQUERY | PSORT | PSTART;
		private ReqSrvAvailableStorageSystemList( Connection conn ) {
			super( conn, _URI, ReqSrvAvailableStorageSystemList.class, requiredParms, optionalParms );
		}

		public AvailableStorageSystems get() throws Exception { 
			return super.get(AvailableStorageSystems.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AvailableStorageSystems.class.
     */
    public static Class<AvailableStorageSystems> retType() { return AvailableStorageSystems.class; }

	/**
	 * Convert a string containing JSON into an instance of AvailableStorageSystems.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.AvailableStorageSystems.
	 */
	public static AvailableStorageSystems fromJsonString( String json ) {
		return util.fromJsonString(AvailableStorageSystems.class, json);
	}

	/**
	 * Returns a new instance of ReqSrvAvailableStorageSystemList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvAvailableStorageSystemList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvAvailableStorageSystemList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvAvailableStorageSystemList( conn );
		throw new HPOneViewApiVersionException( SrvAvailableStorageSystemList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
