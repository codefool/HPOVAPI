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

import com.hp.hponeview.data.network.UplinkSetV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetUplinkSetForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetUplinkSetForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetUplinkSetForId.optionalParms; };
	public static final String  _URI = "uplink-sets/%s/";

	/**
	 * Implements /rest/uplink-sets/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/uplink-sets.html#d4e131
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the uplink set of interest.
	 * @return com.hp.hponeview.data.network.UplinkSetV2
	 *
	 */
	public static class ReqNetUplinkSetForId extends HPOneViewRestRequest<ReqNetUplinkSetForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetUplinkSetForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetUplinkSetForId.class, requiredParms, optionalParms  );
		}

		public UplinkSetV2 get() throws Exception { 
			return super.get(UplinkSetV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UplinkSetV2.class.
     */
    public static Class<UplinkSetV2> retType() { return UplinkSetV2.class; }

    /**
	 * Convert a string containing JSON into an instance of UplinkSetV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.UplinkSetV2.
	 */
	public static UplinkSetV2 fromJsonString( String json ) {
		return util.fromJsonString( UplinkSetV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetUplinkSetForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the uplink set of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetUplinkSetForId
	 */
	public static ReqNetUplinkSetForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetUplinkSetForId( conn, id );
		throw new HPOneViewApiVersionException( NetUplinkSetForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
