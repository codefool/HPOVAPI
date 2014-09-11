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

import com.hp.hponeview.data.network.FcNetworkV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetFcNetworkForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetFcNetworkForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetFcNetworkForId.optionalParms; };
	public static final String  _URI = "fc-networks/%s/";

	/**
	 * Implements /rest/fc-networks/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/fc-networks.html#d4e1
	 * @param conn - http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-networks
	 * @param id - String containing the URI of the fc network set of interest.
	 * @return com.hp.hponeview.data.network.FcNetwork
	 *
	 */
	public static class ReqNetFcNetworkForId extends HPOneViewRestRequest<ReqNetFcNetworkForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqNetFcNetworkForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetFcNetworkForId.class, requiredParms, optionalParms );
		}

		public FcNetworkV2 get() throws Exception { 
			return super.get(FcNetworkV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return FcNetwork.class.
     */
    public static Class<FcNetworkV2> retType() { return FcNetworkV2.class; }

    /**
	 * Convert a string containing JSON into an instance of FcNetworkV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.FcNetworkV2.
	 */
	public static FcNetworkV2 fromJsonString( String json ) {
		return util.fromJsonString( FcNetworkV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetFcNetworkForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the fc network set of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetFcNetworkForId
	 */
	public static ReqNetFcNetworkForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetFcNetworkForId( conn, id );
		throw new HPOneViewApiVersionException( NetFcNetworkForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
