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

import com.hp.hponeview.data.network.NetworkSetCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetNetworkSetWithoutEthernetList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetNetworkSetWithoutEthernetList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetNetworkSetWithoutEthernetList.optionalParms; };
	public static final String  _URI = "network-sets/withoutEthernet/";

	/**
	 * Implements /rest/network-sets/withoutEthernet/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/network-sets.html#d4e131
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.NetworkSetCollection
	 *
	 */
	public static class ReqNetNetworkSetWithoutEthernetList extends HPOneViewRestRequest<ReqNetNetworkSetWithoutEthernetList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTL;
		private ReqNetNetworkSetWithoutEthernetList( Connection conn ) {
			super( conn, _URI, ReqNetNetworkSetWithoutEthernetList.class, requiredParms, optionalParms  );
		}

		public NetworkSetCollection get() throws Exception { 
			return super.get(NetworkSetCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NetworkSetCollection.class.
     */
    public static Class<NetworkSetCollection> retType() { return NetworkSetCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of NetworkSetCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.NetworkSetCollection.
	 */
	public static NetworkSetCollection fromJsonString( String json ) {
		return util.fromJsonString( NetworkSetCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqNetNetworkSetWithoutEthernetList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetNetworkSetWithoutEthernetList
	 */
	public static ReqNetNetworkSetWithoutEthernetList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetNetworkSetWithoutEthernetList( conn );
		throw new HPOneViewApiVersionException( NetNetworkSetWithoutEthernetList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
