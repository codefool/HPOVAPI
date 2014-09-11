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

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacPowerDevicePowerStateForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacPowerDevicePowerStateForId.requiredParms; };
	public static final Integer optionalParms() { return ReqFacPowerDevicePowerStateForId.optionalParms; };
	public static final String  _URI = "power-devices/%s/powerState/";

	/**
	 * Implements /rest/power-devices/{id}/powerState/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/power-devices
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String id of the power device
	 * @return String
	 *
	 */
	public static class ReqFacPowerDevicePowerStateForId extends HPOneViewRestRequest<ReqFacPowerDevicePowerStateForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE ;
		private ReqFacPowerDevicePowerStateForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqFacPowerDevicePowerStateForId.class, requiredParms, optionalParms );
		}

		public String get() throws Exception { 
			return super.get(String.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return String.class.
     */
    public static Class<String> retType() { return String.class; }

    /**
	 * Convert a string containing JSON into an instance of String.
	 * @param json - String containing JSON
	 * @return String.
	 */
	public static String fromJsonString( String json ) {
		return util.fromJsonString( String.class, json );
	}

	/**
	 * Returns a new instance of ReqFacPowerDevicePowerStateForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the power device of interest.
	 * @return hp.oneview.rest.Facilities.ReqFacPowerDevicePowerStateForId
	 */
	public static ReqFacPowerDevicePowerStateForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacPowerDevicePowerStateForId( conn, id );
		throw new HPOneViewApiVersionException( FacPowerDevicePowerStateForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
