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

import com.hp.hponeview.data.network.logical_interconnects.TelemetryConfiguration;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectTelemetryConfigForIdAndTcid {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid.optionalParms; };
	public static final String  _URI = "logical-interconnects/%s/telemetry-configurations/%s/";

	/**
	 * Implements /rest/logical-interconnects/{id}/telemetry-configurations/{tcld}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e651
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @param tcid - String containing the URI of the logical interconnect of interest.
	 * @return com.hp.hponeview.data.network.logical_interconnects.TelemetryConfiguration
	 *
	 */
	public static class ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid extends HPOneViewRestRequest<ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid( Connection conn, String id, String tcid ) {
			super( conn, String.format( _URI, id, tcid ), ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid.class, requiredParms, optionalParms  );
		}

		public TelemetryConfiguration get() throws Exception { 
			return super.get(TelemetryConfiguration.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return TelemetryConfiguration.class.
     */
    public static Class<TelemetryConfiguration> retType() { return TelemetryConfiguration.class; }

    /**
	 * Convert a string containing JSON into an instance of TelemetryConfiguration.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.logical_interconnects.TelemetryConfiguration.
	 */
	public static TelemetryConfiguration fromJsonString( String json ) {
		return util.fromJsonString( TelemetryConfiguration.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @param tcld - String containing the URI of the logical interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid
	 */
	public static ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid instance( Connection conn, String id, String tcid )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectTelemetryConfigForIdAndTcid( conn, id, tcid );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectTelemetryConfigForIdAndTcid.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
