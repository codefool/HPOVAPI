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

import com.hp.hponeview.data.network.LogicalDownlink;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalDownlinkWithoutEthernetForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalDownlinkWithoutEthernetForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalDownlinkWithoutEthernetForId.optionalParms; };
	public static final String  _URI = "logical-downlinks/%s/withoutEthernet/";

	/**
	 * Implements /rest/logical-downlinks/{id}/withoutEthernet/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-downlinks.html#d4e218
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical downlink of interest.
	 * @return com.hp.hponeview.data.network.LogicalDownlink
	 *
	 */
	public static class ReqNetLogicalDownlinkWithoutEthernetForId extends HPOneViewRestRequest<ReqNetLogicalDownlinkWithoutEthernetForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetLogicalDownlinkWithoutEthernetForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetLogicalDownlinkWithoutEthernetForId.class, requiredParms, optionalParms  );
		}

		public LogicalDownlink get() throws Exception { 
			return super.get(LogicalDownlink.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LogicalDownlink.class.
     */
    public static Class<LogicalDownlink> retType() { return LogicalDownlink.class; }

    /**
	 * Convert a string containing JSON into an instance of LogicalDownlink.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.LogicalDownlink.
	 */
	public static LogicalDownlink fromJsonString( String json ) {
		return util.fromJsonString( LogicalDownlink.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalDownlinkWithoutEthernetForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical downlink of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalDownlinkWithoutEthernetForId
	 */
	public static ReqNetLogicalDownlinkWithoutEthernetForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalDownlinkWithoutEthernetForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalDownlinkWithoutEthernetForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
