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

import com.hp.hponeview.data.network.interconnects.PortStatistics;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectStatisticsForIdAndPortName {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectStatisticsForIdAndPortName.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectStatisticsForIdAndPortName.optionalParms; };
	public static final String  _URI = "interconnects/%s/statistics/%s/";

	/**
	 * Implements /rest/interconnects/{id}/statistics/{portName}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e263
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @param portName - String containing the name of the port of interest.
	 * @return com.hp.hponeview.data.network.interconnects.PortStatistics
	 */
	public static class ReqNetInterconnectStatisticsForIdAndPortName extends HPOneViewRestRequest<ReqNetInterconnectStatisticsForIdAndPortName> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetInterconnectStatisticsForIdAndPortName( Connection conn, String id, String portName ) {
			super( conn, String.format( _URI, id, portName ), ReqNetInterconnectStatisticsForIdAndPortName.class, requiredParms, optionalParms  );
		}

		public PortStatistics get() throws Exception { 
			return super.get(PortStatistics.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return PortStatistics.class.
     */
    public static Class<PortStatistics> retType() { return PortStatistics.class; }

    /**
	 * Convert a string containing JSON into an instance of PortStatistics.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.interconnects.PortStatistics.
	 */
	public static PortStatistics fromJsonString( String json ) {
		return util.fromJsonString( PortStatistics.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectStatisticsForIdAndPortName
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @param portName - String containing the name of the port of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectStatisticsForIdAndPortName
	 */
	public static ReqNetInterconnectStatisticsForIdAndPortName instance( Connection conn, String id, String portName )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectStatisticsForIdAndPortName( conn, id, portName );
		throw new HPOneViewApiVersionException( NetInterconnectStatisticsForIdAndPortName.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
