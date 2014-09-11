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

import com.hp.hponeview.data.network.logical_interconnects.InterconnectFibData;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectFibListForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectFibListForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectFibListForId.optionalParms; };
	public static final String  _URI = "logical-interconnects/%s/fowarding-information-base/";

	/**
	 * Implements /rest/logical-interconnects/{id}/forwarding-information-base
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the logical interconnect id of interest
	 * @return com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectCollection
	 *
	 */
	public static class ReqNetLogicalInterconnectFibListForId extends HPOneViewRestRequest<ReqNetLogicalInterconnectFibListForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFILTER;
		private ReqNetLogicalInterconnectFibListForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetLogicalInterconnectFibListForId.class, requiredParms, optionalParms );
		}

		public InterconnectFibData get() throws Exception { 
			return super.get(InterconnectFibData.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return InterconnectFibData.class.
     */
    public static Class<InterconnectFibData> retType() { return InterconnectFibData.class; }

    /**
	 * Convert a string containing JSON into an instance of InterconnectFibData.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.logical_interconnects.InterconnectFibData.
	 */
	public static InterconnectFibData fromJsonString( String json ) {
		return util.fromJsonString( InterconnectFibData.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectFibListForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the logical interconnect id of interest
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalInterconnectFibListForId
	 */
	public static ReqNetLogicalInterconnectFibListForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectFibListForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectFibListForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
