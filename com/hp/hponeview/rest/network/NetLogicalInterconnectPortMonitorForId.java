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

import com.hp.hponeview.data.network.logical_interconnects.PortMonitor;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectPortMonitorForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectPortMonitorForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectPortMonitorForId.optionalParms; };
	public static final String  _URI = "logical-interconnects/%s/port-monitor/";

	/**
	 * Implements /rest/logical-interconnects/{id}/port-monitor/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e559
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @return com.hp.hponeview.data.network.logical_interconnects.PortMonitor
	 *
	 */
	public static class ReqNetLogicalInterconnectPortMonitorForId extends HPOneViewRestRequest<ReqNetLogicalInterconnectPortMonitorForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetLogicalInterconnectPortMonitorForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetLogicalInterconnectPortMonitorForId.class, requiredParms, optionalParms  );
		}

		public PortMonitor get() throws Exception { 
			return super.get(PortMonitor.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return PortMonitor.class.
     */
    public static Class<PortMonitor> retType() { return PortMonitor.class; }

    /**
	 * Convert a string containing JSON into an instance of PortMonitor.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.logical_interconnects.PortMonitor.
	 */
	public static PortMonitor fromJsonString( String json ) {
		return util.fromJsonString( PortMonitor.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectPortMonitorForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalInterconnectPortMonitorForId
	 */
	public static ReqNetLogicalInterconnectPortMonitorForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectPortMonitorForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectPortMonitorForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
