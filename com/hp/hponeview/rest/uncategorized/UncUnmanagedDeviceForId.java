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
package com.hp.hponeview.rest.uncategorized;

import com.hp.hponeview.data.uncategorized.UnmanagedDevice;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class UncUnmanagedDeviceForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "unmanaged-devices/%s/";
	public static final Integer requiredParms() { return ReqUncUnmanagedDeviceForId.requiredParms; };
	public static final Integer optionalParms() { return ReqUncUnmanagedDeviceForId.optionalParms; };
	/**
	 * Implements /rest/unmanaged-devices/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the unmanaged device of interest.
	 * @return com.hp.hponeview.data.uncategorized.UnmanagedDevice
	 */
	public static class ReqUncUnmanagedDeviceForId extends HPOneViewRestRequest<ReqUncUnmanagedDeviceForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqUncUnmanagedDeviceForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqUncUnmanagedDeviceForId.class, requiredParms, optionalParms );
		}

		public UnmanagedDevice get() throws Exception { 
			return super.get(UnmanagedDevice.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return UnmanagedDevice.class.
     */
    public static Class<UnmanagedDevice> retType() { return UnmanagedDevice.class; }

    /**
	 * Convert a string containing JSON into an instance of UnmanagedDevice.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.uncategorized.UnmanagedDevice.
	 */
	public static UnmanagedDevice fromJsonString( String json ) {
		return util.fromJsonString( UnmanagedDevice.class, json );
	}

	/**
	 * Returns a new instance of ReqUncUnmanagedDeviceForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the unmanaged device of interest.
	 * @returns com.hp.hponeview.rest.uncategorized.ReqUncUnmanagedDeviceForId
	 */
	public static ReqUncUnmanagedDeviceForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqUncUnmanagedDeviceForId( conn, id );
		throw new HPOneViewApiVersionException( UncUnmanagedDeviceForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
