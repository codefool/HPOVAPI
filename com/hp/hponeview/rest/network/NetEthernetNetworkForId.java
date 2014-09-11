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

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.data.network.NetworkV2;

public class NetEthernetNetworkForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetEthernetNetworkForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetEthernetNetworkForId.optionalParms; };
	public static final String  _URI = "ethernet-networks/%s/";
	
	/**
	 * Implements /rest/ethernet-networks/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/ethernet-networks
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the ethernet network of interest.
	 * @return com.hp.hponeview.data.network.NetworkV2
	 *
	 */
	public static class ReqNetEthernetNetworkForId extends HPOneViewRestRequest<ReqNetEthernetNetworkForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetEthernetNetworkForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetEthernetNetworkForId.class, requiredParms, optionalParms  );
		}

		public NetworkV2 get() throws Exception { 
			return super.get(NetworkV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Network.class.
     */
    public static Class<NetworkV2> retType() { return NetworkV2.class; }

    /**
	 * Convert a string containing JSON into an instance of NetworkV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.NetworkV2.
	 */
	public static NetworkV2 fromJsonString( String json ) {
		return util.fromJsonString( NetworkV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetEthernetNetworkForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the ethernet network of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetEthernetNetworkForId
	 */
	public static ReqNetEthernetNetworkForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetEthernetNetworkForId( conn, id );
		throw new HPOneViewApiVersionException( NetEthernetNetworkForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
