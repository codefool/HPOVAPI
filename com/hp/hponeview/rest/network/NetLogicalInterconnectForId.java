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

import com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectForId.optionalParms; };
	public static final String  _URI = "logical-interconnects/%s/";

	/**
	 * Implements /rest/logical-interconnects/{id}/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e165
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @return com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectV2
	 *
	 */
	public static class ReqNetLogicalInterconnectForId extends HPOneViewRestRequest<ReqNetLogicalInterconnectForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetLogicalInterconnectForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetLogicalInterconnectForId.class, requiredParms, optionalParms  );
		}

		public LogicalInterconnectV2 get() throws Exception { 
			return super.get(LogicalInterconnectV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LogicalInterconnectV2.class.
     */
    public static Class<LogicalInterconnectV2> retType() { return LogicalInterconnectV2.class; }

    /**
	 * Convert a string containing JSON into an instance of LogicalInterconnectV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.logical_interconnects.LogicalInterconnectV2.
	 */
	public static LogicalInterconnectV2 fromJsonString( String json ) {
		return util.fromJsonString( LogicalInterconnectV2.class, json );
	}

	/**
	 * Returns a new instance of ReqLogicalReqInterconnectForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqLogicalReqInterconnectForId
	 */
	public static ReqNetLogicalInterconnectForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
