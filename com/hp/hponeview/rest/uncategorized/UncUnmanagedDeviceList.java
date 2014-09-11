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

import com.hp.hponeview.data.uncategorized.UnmanagedDeviceList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class UncUnmanagedDeviceList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "unmanaged-devices/";
	public static final Integer requiredParms() { return ReqUncUnmanagedDeviceList.requiredParms; };
	public static final Integer optionalParms() { return ReqUncUnmanagedDeviceList.optionalParms; };
	/**
	 * Implements /rest/unmanaged-devices
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.uncategorized.UnmanagedDeviceList
	 */
	public static class ReqUncUnmanagedDeviceList extends HPOneViewRestRequest<ReqUncUnmanagedDeviceList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqUncUnmanagedDeviceList( Connection conn ) {
			super( conn, _URI, ReqUncUnmanagedDeviceList.class, requiredParms, optionalParms );
		}

		public UnmanagedDeviceList get() throws Exception { 
			return super.get(UnmanagedDeviceList.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return UnmanagedDeviceList.class.
     */
    public static Class<UnmanagedDeviceList> retType() { return UnmanagedDeviceList.class; }

    /**
	 * Convert a string containing JSON into an instance of UnmanagedDeviceList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.uncategorized.UnmanagedDeviceList.
	 */
	public static UnmanagedDeviceList fromJsonString( String json ) {
		return util.fromJsonString( UnmanagedDeviceList.class, json );
	}

	/**
	 * Returns a new instance of ReqUncUnmanagedDeviceList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.uncategorized.ReqUncUnmanagedDeviceList
	 */
	public static ReqUncUnmanagedDeviceList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqUncUnmanagedDeviceList( conn );
		throw new HPOneViewApiVersionException( UncUnmanagedDeviceList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
