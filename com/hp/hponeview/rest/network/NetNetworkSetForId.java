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
package com.hp.hponeview.rest.network;

import com.hp.hponeview.data.network.NetworkSet;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetNetworkSetForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetNetworkSetForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetNetworkSetForId.optionalParms; };
	public static final String  _URI = "network-sets/%s/";
	
	/**
	 * Implements /rest/network-sets/{id}/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/network-sets.html#d4e206
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the network set of interest.
	 * @return com.hp.hponeview.data.network.NetworkSet
	 *
	 */
	public static class ReqNetNetworkSetForId extends HPOneViewRestRequest<ReqNetNetworkSetForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetNetworkSetForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetNetworkSetForId.class, requiredParms, optionalParms  );
		}

		public NetworkSet get() throws Exception { 
			return super.get(NetworkSet.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NetworkSet.class.
     */
    public static Class<NetworkSet> retType() { return NetworkSet.class; }

    /**
	 * Convert a string containing JSON into an instance of NetworkSet.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.NetworkSet.
	 */
	public static NetworkSet fromJsonString( String json ) {
		return util.fromJsonString( NetworkSet.class, json );
	}

	/**
	 * Returns a new instance of ReqNetNetworkSetForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the network set of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetNetworkSetForId
	 */
	public static ReqNetNetworkSetForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetNetworkSetForId( conn, id );
		throw new HPOneViewApiVersionException( NetNetworkSetForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
