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
import com.hp.hponeview.data.sans.DeviceManagerResponseList;

public class SansDeviceManagerList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSansDeviceManagerList.requiredParms; };
	public static final Integer optionalParms() { return ReqSansDeviceManagerList.optionalParms; };
	public static final String  _URI = "fc-sans/device-managers/";

	/**
	 * Implements /rest/fc-sans/device-managers
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-sans/device-managers
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.sans.DeviceManagerResponseList
	 *
	 */
	public static class ReqSansDeviceManagerList extends HPOneViewRestRequest<ReqSansDeviceManagerList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCOUNT | PQUERY | PSORT | PSTART;
		private ReqSansDeviceManagerList( Connection conn ) {
			super( conn, _URI, ReqSansDeviceManagerList.class, requiredParms, optionalParms  );
		}

		public DeviceManagerResponseList get() throws Exception { 
			return super.get(DeviceManagerResponseList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return DeviceManagerResponseList.class.
     */
    public static Class<DeviceManagerResponseList> retType() { return DeviceManagerResponseList.class; }

    /**
	 * Convert a string containing JSON into an instance of DeviceManagerResponseList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.sans.DeviceManagerResponseList.
	 */
	public static DeviceManagerResponseList fromJsonString( String json ) {
		return util.fromJsonString( DeviceManagerResponseList.class, json );
	}

	/**
	 * Returns a new instance of ReqSansDeviceManagerList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.sans.ReqSansDeviceManagerList
	 */
	public static ReqSansDeviceManagerList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqSansDeviceManagerList( conn );
		throw new HPOneViewApiVersionException( SansDeviceManagerList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
