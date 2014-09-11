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
package com.hp.hponeview.rest.facilities;

import com.hp.hponeview.data.facilities.EnvironmentalAnalysis;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacRackDeviceTopologyForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacRackDeviceTopologyForId.requiredParms; };
	public static final Integer optionalParms() { return ReqFacRackDeviceTopologyForId.optionalParms; };
	public static final String  _URI = "racks/%s/deviceTopology/";

	/**
	 * Implements /rest/racks/{id}/deviceTopology/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/racks
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String rack id 
	 * @return com.hp.hponeview.data.facilities.EnvironmentalAnalysis
	 *
	 */
	public static class ReqFacRackDeviceTopologyForId extends HPOneViewRestRequest<ReqFacRackDeviceTopologyForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE ;
		private ReqFacRackDeviceTopologyForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqFacRackDeviceTopologyForId.class, requiredParms, optionalParms );
		}

		public EnvironmentalAnalysis get() throws Exception { 
			return super.get(EnvironmentalAnalysis.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnvironmentalAnalysis.class.
     */
    public static Class<EnvironmentalAnalysis> retType() { return EnvironmentalAnalysis.class; }

    /**
	 * Convert a string containing JSON into an instance of EnvironmentalAnalysis.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.EnvironmentalAnalysis.
	 */
	public static EnvironmentalAnalysis fromJsonString( String json ) {
		return util.fromJsonString( EnvironmentalAnalysis.class, json );
	}

	/**
	 * Returns a new instance of ReqFacRackDeviceTopologyForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the rack of interest.
	 * @return hp.oneview.rest.Facilities.ReqFacRackDeviceTopologyForId
	 */
	public static ReqFacRackDeviceTopologyForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacRackDeviceTopologyForId( conn, id );
		throw new HPOneViewApiVersionException( FacRackDeviceTopologyForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
