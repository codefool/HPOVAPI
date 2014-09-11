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

import com.hp.hponeview.data.network.interconnects.NameServer;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectNameServerListForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectNameServerListForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectNameServerListForId.optionalParms; };
	public static final String  _URI = "interconnects/%s/nameServers/";

	/**
	 * Implements /rest/interconnects/{id}/nameServers/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e367
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @return com.hp.hponeview.data.network.interconnects.NameServer[]
	 *
	 */
	public static class ReqNetInterconnectNameServerListForId extends HPOneViewRestRequest<ReqNetInterconnectNameServerListForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetInterconnectNameServerListForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetInterconnectNameServerListForId.class, requiredParms, optionalParms  );
		}

		public NameServer[] get() throws Exception { 
			return super.get(NameServer[].class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NameServer.class.
     */
    public static Class<NameServer> retType() { return NameServer.class; }

    /**
	 * Convert a string containing JSON into an instance of NameServer.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.interconnects.NameServer.
	 */
	public static NameServer fromJsonString( String json ) {
		return util.fromJsonString( NameServer.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectNameServerListForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectNameServerListForId
	 */
	public static ReqNetInterconnectNameServerListForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectNameServerListForId( conn, id );
		throw new HPOneViewApiVersionException( NetInterconnectNameServerListForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
