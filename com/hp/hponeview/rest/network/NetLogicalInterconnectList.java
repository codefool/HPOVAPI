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

import com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectList.optionalParms; };
	public static final String  _URI = "logical-interconnects/";

	/**
	 * Implements /rest/logical-interconnects/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectCollectionV2
	 *
	 */
	public static class ReqNetLogicalInterconnectList extends HPOneViewRestRequest<ReqNetLogicalInterconnectList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetLogicalInterconnectList( Connection conn ) {
			super( conn, _URI, ReqNetLogicalInterconnectList.class, requiredParms, optionalParms );
		}

		public LogicalInterconnectCollectionV2 get() throws Exception { 
			return super.get(LogicalInterconnectCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LogicalInterconnectCollectionV2.class.
     */
    public static Class<LogicalInterconnectCollectionV2> retType() { return LogicalInterconnectCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of LogicalInterconnectCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.logical_interconnects.LogicalInterconnectCollectionV2.
	 */
	public static LogicalInterconnectCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( LogicalInterconnectCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalInterconnectList
	 */
	public static ReqNetLogicalInterconnectList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectList( conn );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
