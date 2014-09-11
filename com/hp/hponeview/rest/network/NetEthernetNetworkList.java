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

import com.hp.hponeview.data.network.NetworkCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetEthernetNetworkList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetEthernetNetworkList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetEthernetNetworkList.optionalParms; };
	public static final String  _URI = "ethernet-networks/";

	/**
	 * Implements /rest/ethernet-networks/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/ethernet-networks.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.NetworkCollectionV2
	 *
	 */
	public static class ReqNetEthernetNetworkList extends HPOneViewRestRequest<ReqNetEthernetNetworkList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetEthernetNetworkList( Connection conn ) {
			super( conn, _URI, ReqNetEthernetNetworkList.class, requiredParms, optionalParms  );
		}

		public NetworkCollectionV2 get() throws Exception { 
			return super.get(NetworkCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NetworkCollectionV2.class.
     */
    public static Class<NetworkCollectionV2> retType() { return NetworkCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of NetworkCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.NetworkCollectionV2.
	 */
	public static NetworkCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( NetworkCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetEthernetNetworkList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.network.ReqNetEthernetNetworkList
	 */
	public static ReqNetEthernetNetworkList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetEthernetNetworkList( conn );
		throw new HPOneViewApiVersionException( NetEthernetNetworkList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
