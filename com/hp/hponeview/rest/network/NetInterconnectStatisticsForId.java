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

import com.hp.hponeview.data.network.interconnects.InterconnectsStatistics;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectStatisticsForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectStatisticsForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectStatisticsForId.optionalParms; };
	public static final String  _URI = "interconnects/%s/statistics/";

	/**
	 * Implements /rest/interconnects/{id}/statistics/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e263
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectStatistics
	 *
	 */
	public static class ReqNetInterconnectStatisticsForId extends HPOneViewRestRequest<ReqNetInterconnectStatisticsForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetInterconnectStatisticsForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetInterconnectStatisticsForId.class, requiredParms, optionalParms  );
		}

		public InterconnectsStatistics get() throws Exception { 
			return super.get(InterconnectsStatistics.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return InterconnectStatistics.class.
     */
    public static Class<InterconnectsStatistics> retType() { return InterconnectsStatistics.class; }

    /**
	 * Convert a string containing JSON into an instance of InterconnectStatistics.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectStatistics.
	 */
	public static InterconnectsStatistics fromJsonString( String json ) {
		return util.fromJsonString( InterconnectsStatistics.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectStatisticsForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectStatisticsForId
	 */
	public static ReqNetInterconnectStatisticsForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectStatisticsForId( conn, id );
		throw new HPOneViewApiVersionException( NetInterconnectStatisticsForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
