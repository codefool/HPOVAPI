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
package com.hp.hponeview.rest.sans;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.data.sans.DeviceManagerResponse;

public class SansDeviceManagerForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSansDeviceManagerForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSansDeviceManagerForId.optionalParms; };
	public static final String  _URI = "fc-sans/device-managers/%s/";
	
	/**
	 * Implements /rest/fc-sans/device-managers/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-sans/device-managers
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the device manager of interest.
	 * @return com.hp.hponeview.data.sans.DeviceManagerResponse
	 *
	 */
	public static class ReqSansDeviceManagerForId extends HPOneViewRestRequest<ReqSansDeviceManagerForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSansDeviceManagerForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSansDeviceManagerForId.class, requiredParms, optionalParms  );
		}

		public DeviceManagerResponse get() throws Exception { 
			return super.get(DeviceManagerResponse.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return DeviceManagerResponse.class.
     */
    public static Class<DeviceManagerResponse> retType() { return DeviceManagerResponse.class; }

    /**
	 * Convert a string containing JSON into an instance of DeviceManagerResponse.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.sans.DeviceManagerResponse.
	 */
	public static DeviceManagerResponse fromJsonString( String json ) {
		return util.fromJsonString( DeviceManagerResponse.class, json );
	}

	/**
	 * Returns a new instance of ReqSansDeviceManagerForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the device manager of interest.
	 * @returns com.hp.hponeview.rest.sans.ReqSansDeviceManagerForId
	 */
	public static ReqSansDeviceManagerForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqSansDeviceManagerForId( conn, id );
		throw new HPOneViewApiVersionException( SansDeviceManagerForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
