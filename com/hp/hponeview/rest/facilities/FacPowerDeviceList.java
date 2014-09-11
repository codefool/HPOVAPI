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

import com.hp.hponeview.data.facilities.PowerDeliveryDeviceList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacPowerDeviceList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacPowerDevicesList.requiredParms; };
	public static final Integer optionalParms() { return ReqFacPowerDevicesList.optionalParms; };
	public static final String  _URI = "power-devices/";

	/**
	 * Implements /rest/power-devices/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/power-devices
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.facilities.PowerDeliveryDeviceList
	 *
	 */
	public static class ReqFacPowerDevicesList extends HPOneViewRestRequest<ReqFacPowerDevicesList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL; 
		private ReqFacPowerDevicesList( Connection conn ) {
			super( conn, _URI, ReqFacPowerDevicesList.class, requiredParms, optionalParms );
		}

		public PowerDeliveryDeviceList get() throws Exception { 
			return super.get(PowerDeliveryDeviceList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return PowerDeliveryDeviceList.class.
     */
    public static Class<PowerDeliveryDeviceList> retType() { return PowerDeliveryDeviceList.class; }

    /**
	 * Convert a string containing JSON into an instance of PowerDeliveryDeviceList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.PowerDeliveryDeviceList.
	 */
	public static PowerDeliveryDeviceList fromJsonString( String json ) {
		return util.fromJsonString( PowerDeliveryDeviceList.class, json );
	}

	/**
	 * Returns a new instance of ReqFacPowerDevicesList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return hp.oneview.rest.Facilities.ReqFacPowerDevicesList
	 */
	public static ReqFacPowerDevicesList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacPowerDevicesList( conn );
		throw new HPOneViewApiVersionException( FacPowerDeviceList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
