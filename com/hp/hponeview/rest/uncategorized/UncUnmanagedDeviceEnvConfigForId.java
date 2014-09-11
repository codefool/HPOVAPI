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

import com.hp.hponeview.data.EnvironmentalConfiguration;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class UncUnmanagedDeviceEnvConfigForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "unmanaged-devices/%s/environmentalConfiguration/";
	public static final Integer requiredParms() { return ReqUncUnmanagedDeviceEnvConfigForId.requiredParms; };
	public static final Integer optionalParms() { return ReqUncUnmanagedDeviceEnvConfigForId.optionalParms; };
	/**
	 * Implements /rest/unmanaged-devices/{id}/environmentalConfiguration/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the unmanaged device of interest.
	 * @return com.hp.hponeview.data.EnvironmentalConfiguration
	 */
	public static class ReqUncUnmanagedDeviceEnvConfigForId extends HPOneViewRestRequest<ReqUncUnmanagedDeviceEnvConfigForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqUncUnmanagedDeviceEnvConfigForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqUncUnmanagedDeviceEnvConfigForId.class, requiredParms, optionalParms );
		}

		public EnvironmentalConfiguration get() throws Exception { 
			return super.get(EnvironmentalConfiguration.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return UnmanagedDeviceList.class.
     */
    public static Class<EnvironmentalConfiguration> retType() { return EnvironmentalConfiguration.class; }

    /**
	 * Convert a string containing JSON into an instance of EnvironmentalConfiguration.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.data.EnvironmentalConfiguration.
	 */
	public static EnvironmentalConfiguration fromJsonString( String json ) {
		return util.fromJsonString( EnvironmentalConfiguration.class, json );
	}

	/**
	 * Returns a new instance of ReqUncUnmanagedDeviceEnvConfigForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the unmanaged device of interest.
	 * @returns com.hp.hponeview.rest.uncategorized.ReqUncUnmanagedDeviceEnvConfigForId
	 */
	public static ReqUncUnmanagedDeviceEnvConfigForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqUncUnmanagedDeviceEnvConfigForId( conn, id );
		throw new HPOneViewApiVersionException( UncUnmanagedDeviceEnvConfigForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
