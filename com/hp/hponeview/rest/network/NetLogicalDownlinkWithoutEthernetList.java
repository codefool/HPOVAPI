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

import com.hp.hponeview.data.network.LogicalDownlinkCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalDownlinkWithoutEthernetList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalDownlinkWithoutEthernetList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalDownlinkWithoutEthernetList.optionalParms; };
	public static final String  _URI = "logical-downlinks/withoutEthernet/";

	/**
	 * Implements /rest/logical-downlinks/withoutEthernet/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-downlinks.html#d4e97
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.logical_interconnects.LogicalDownlinkCollection
	 *
	 */
	public static class ReqNetLogicalDownlinkWithoutEthernetList extends HPOneViewRestRequest<ReqNetLogicalDownlinkWithoutEthernetList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetLogicalDownlinkWithoutEthernetList( Connection conn ) {
			super( conn, _URI, ReqNetLogicalDownlinkWithoutEthernetList.class, requiredParms, optionalParms  );
		}

		public LogicalDownlinkCollection get() throws Exception { 
			return super.get(LogicalDownlinkCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LogicalDownlinkCollection.class.
     */
    public static Class<LogicalDownlinkCollection> retType() { return LogicalDownlinkCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of LogicalDownlinkCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.LogicalDownlinkCollection.
	 */
	public static LogicalDownlinkCollection fromJsonString( String json ) {
		return util.fromJsonString( LogicalDownlinkCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalDownlinkWithoutEthernetList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalDownlinkWithoutEthernetList
	 */
	public static ReqNetLogicalDownlinkWithoutEthernetList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalDownlinkWithoutEthernetList( conn );
		throw new HPOneViewApiVersionException( NetLogicalDownlinkWithoutEthernetList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
