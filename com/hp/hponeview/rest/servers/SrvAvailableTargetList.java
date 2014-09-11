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

import com.hp.hponeview.data.servers.AvailableTargetsV1;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvAvailableTargetList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvAvailableTargetList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvAvailableTargetList.optionalParms; };
	public static final String  _URI = "server-profiles/available-targets/";

	/**
	 * Implements /rest/server-profiles/available-targets/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-profiles
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.AvailableTargetsV1
	 */
	public static class ReqSrvAvailableTargetList extends HPOneViewRestRequest<ReqSrvAvailableTargetList>	{
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PENCGRPURI | PQUERY | PSRVHWTYPURI;
		private ReqSrvAvailableTargetList( Connection conn ) {
			super( conn, _URI, ReqSrvAvailableTargetList.class, requiredParms, optionalParms );
		}

		public AvailableTargetsV1 get() throws Exception { 
			return super.get(AvailableTargetsV1.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AvailableTargetsV1.class.
     */
    public static Class<AvailableTargetsV1> retType() { return AvailableTargetsV1.class; }

    /**
	 * Convert a string containing JSON into an instance of AvailableTargetsV1.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.AvailableTargetsV1.
	 */
	public static AvailableTargetsV1 fromJsonString( String json ) {
		return util.fromJsonString( AvailableTargetsV1.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvAvailableTargetList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvAvailableTargetList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvAvailableTargetList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvAvailableTargetList( conn );
		throw new HPOneViewApiVersionException( SrvAvailableTargetList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
