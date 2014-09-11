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

import com.hp.hponeview.data.network.logical_interconnects.PortMonitorUplinkPortCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId.optionalParms; };
	public static final String  _URI = "logical-interconnects/%s/unassignedUplinkPortsForPortMonitor/";

	
	/**
	 * Implements /rest/logical-interconnects/{id}/unassignedUplinkPortsForPortMonitor/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e494
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @return com.hp.hponeview.data.network.logical_interconnects.PortMonitorUplinkPortCollection
	 *
	 */
	public static class ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId extends HPOneViewRestRequest<ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId( Connection conn, String id ) {
			super( conn, String.format( _URI,  id ), ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId.class, requiredParms, optionalParms );
		}

		public PortMonitorUplinkPortCollection get() throws Exception { 
			return super.get(PortMonitorUplinkPortCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return PortMonitorUplinkPortCollection.class.
     */
    public static Class<PortMonitorUplinkPortCollection> retType() { return PortMonitorUplinkPortCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of PortMonitorUplinkPortCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.logical_interconnects.PortMonitorUplinkPortCollection.
	 */
	public static PortMonitorUplinkPortCollection fromJsonString( String json ) {
		return util.fromJsonString( PortMonitorUplinkPortCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqLogicalInterconnectUnassUplinkPortsForPortMonitorForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqLogicalInterconnectUnassUplinkPortsForPortMonitorForId
	 */
	public static ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
