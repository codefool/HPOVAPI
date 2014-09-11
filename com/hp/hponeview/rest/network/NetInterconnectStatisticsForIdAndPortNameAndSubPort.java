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

import com.hp.hponeview.data.network.interconnects.SubportStatistics;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectStatisticsForIdAndPortNameAndSubPort {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort.optionalParms; };
	public static final String  _URI = "interconnects/%s/statistics/%s/subport/%s/";

	/**
	 * Implements /rest/interconnects/{id}/statistics/{portName}/subport/{subPortNumber}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e367
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @param portName - String containing the name of the port of interest.
	 * @param subPortNumber- String containing the number of the sub-port of interest.
	 * @return com.hp.hponeview.data.network.interconnects.SubportStatistics
	 *
	 */
	public static class ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort extends HPOneViewRestRequest<ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort( Connection conn, String id, String portName, String subPortNumber ) {
			super( conn, String.format( _URI, id, portName, subPortNumber ), ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort.class, requiredParms, optionalParms  );
		}

		public SubportStatistics get() throws Exception { 
			return super.get(SubportStatistics.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SubportStatistics.class.
     */
    public static Class<SubportStatistics> retType() { return SubportStatistics.class; }

    /**
	 * Convert a string containing JSON into an instance of SubportStatistics.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.interconnects.SubportStatistics.
	 */
	public static SubportStatistics fromJsonString( String json ) {
		return util.fromJsonString( SubportStatistics.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @param portName - String containing the name of the port of interest.
	 * @param subPortNumber- String containing the number of the sub-port of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort
	 */
	public static ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort instance( Connection conn, String id, String portId, String subPortNumber )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectStatisticsForIdAndPortNameAndSubPort( conn, id, portId, subPortNumber );
		throw new HPOneViewApiVersionException( NetInterconnectStatisticsForIdAndPortNameAndSubPort.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
