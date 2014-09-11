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

import com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectGroupV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectGroupForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectGroupForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectGroupForId.optionalParms; };
	public static final String  _URI = "logical-interconnect-groups/%s/";

	/**
	 * Implements /rest/logical-interconnect-groups/{id}/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnect-groups.html#d4e152
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect group of interest.
	 * @return com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectGroupV2
	 *
	 */
	public static class ReqNetLogicalInterconnectGroupForId extends HPOneViewRestRequest<ReqNetLogicalInterconnectGroupForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetLogicalInterconnectGroupForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetLogicalInterconnectGroupForId.class, requiredParms, optionalParms  );
		}

		public LogicalInterconnectGroupV2 get() throws Exception { 
			return super.get(LogicalInterconnectGroupV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LogicalInterconnectGroupV2.class.
     */
    public static Class<LogicalInterconnectGroupV2> retType() { return LogicalInterconnectGroupV2.class; }

    /**
	 * Convert a string containing JSON into an instance of LogicalInterconnectGroupV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.logical_interconnects.LogicalInterconnectGroupV2.
	 */
	public static LogicalInterconnectGroupV2 fromJsonString( String json ) {
		return util.fromJsonString( LogicalInterconnectGroupV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectGroupForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect group of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalInterconnectGroupForId
	 */
	public static ReqNetLogicalInterconnectGroupForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectGroupForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectGroupForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
