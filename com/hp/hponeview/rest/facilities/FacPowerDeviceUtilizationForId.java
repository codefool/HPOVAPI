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

import com.hp.hponeview.data.facilities.UtilizationDataV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacPowerDeviceUtilizationForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacPowerDeviceUtilizationForId.requiredParms; };
	public static final Integer optionalParms() { return ReqFacPowerDeviceUtilizationForId.optionalParms; };
	public static final String  _URI = "power-devices/%s/utilization/";

	/**
	 * Implements /rest/power-devices/{id}/utilization/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/power-devices
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String id of the power device
	 * @return com.hp.hponeview.data.facilities.UtilizationDataV2
	 *
	 */
	public static class ReqFacPowerDeviceUtilizationForId extends HPOneViewRestRequest<ReqFacPowerDeviceUtilizationForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PREFRESH | PVIEW | PFIELDS | PFILTER;
		private ReqFacPowerDeviceUtilizationForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqFacPowerDeviceUtilizationForId.class, requiredParms, optionalParms );
		}

		public UtilizationDataV2 get() throws Exception { 
			return super.get(UtilizationDataV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UtilizationDataV2.class.
     */
    public static Class<UtilizationDataV2> retType() { return UtilizationDataV2.class; }

    /**
	 * Convert a string containing JSON into an instance of UtilizationDataV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.UtilizationDataV2.
	 */
	public static UtilizationDataV2 fromJsonString( String json ) {
		return util.fromJsonString( UtilizationDataV2.class, json );
	}

	/**
	 * Returns a new instance of ReqFacPowerDeviceUtilizationForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the power device of interest.
	 * @return hp.oneview.rest.Facilities.ReqFacPowerDeviceUtilizationForId
	 */
	public static ReqFacPowerDeviceUtilizationForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacPowerDeviceUtilizationForId( conn, id );
		throw new HPOneViewApiVersionException( FacPowerDeviceUtilizationForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
