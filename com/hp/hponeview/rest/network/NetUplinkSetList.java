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

import com.hp.hponeview.data.network.UplinkSetCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetUplinkSetList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetUplinkSetList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetUplinkSetList.optionalParms; };
	public static final String  _URI = "uplink-sets/";

	/**
	 * Implements /rest/uplink-sets/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/uplink-sets.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.UplinkSetCollectionV2
	 *
	 */
	public static class ReqNetUplinkSetList extends HPOneViewRestRequest<ReqNetUplinkSetList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetUplinkSetList( Connection conn ) {
			super( conn, _URI, ReqNetUplinkSetList.class, requiredParms, optionalParms );
		}

		public UplinkSetCollectionV2 get() throws Exception { 
			return super.get(UplinkSetCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UplinkSetCollectionV2.class.
     */
    public static Class<UplinkSetCollectionV2> retType() { return UplinkSetCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of UplinkSetCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.UplinkSetCollectionV2.
	 */
	public static UplinkSetCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( UplinkSetCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetUplinkSetList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetUplinkSetList
	 */
	public static ReqNetUplinkSetList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetUplinkSetList( conn );
		throw new HPOneViewApiVersionException( NetUplinkSetList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
