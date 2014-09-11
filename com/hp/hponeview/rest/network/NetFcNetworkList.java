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
import com.hp.hponeview.data.network.FcNetworkCollectionV2;

public class NetFcNetworkList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetFcNetworkList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetFcNetworkList.optionalParms; };
	public static final String  _URI = "fc-networks/";

	/**
	 * Implements /rest/fc-networks/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-networks
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.FcNetworkCollectionV2
	 *
	 */
	public static class ReqNetFcNetworkList extends HPOneViewRestRequest<ReqNetFcNetworkList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetFcNetworkList( Connection conn ) {
			super( conn, _URI, ReqNetFcNetworkList.class, requiredParms, optionalParms  );
		}

		public FcNetworkCollectionV2 get() throws Exception { 
			return super.get(FcNetworkCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return FcNetworkCollectionV2.class.
     */
    public static Class<FcNetworkCollectionV2> retType() { return FcNetworkCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of FcNetworkCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.FcNetworkCollectionV2.
	 */
	public static FcNetworkCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( FcNetworkCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetFcNetworkList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetFcNetworkList
	 */
	public static ReqNetFcNetworkList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetFcNetworkList( conn );
		throw new HPOneViewApiVersionException( NetFcNetworkList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
