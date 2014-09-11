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
package com.hp.hponeview.rest.servers;

import com.hp.hponeview.data.EnvironmentalConfiguration;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvHardwareEnvConfigForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvHardwareEnvConfigForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareEnvConfigForId.optionalParms; };
	public static final String  _URI = "server-hardware/%s/environmentalConfiguraton/";

	/**
	 * Implements /rest/server-hardware/{id}/environmentalConfiguraton/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-hardware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the server resource id of interest.
	 * @return com.hp.hponeview.data.servers.EnvironmentalConfiguration
	 */
	public static class ReqSrvHardwareEnvConfigForId extends HPOneViewRestRequest<ReqSrvHardwareEnvConfigForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvHardwareEnvConfigForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvHardwareEnvConfigForId.class, requiredParms, optionalParms );
		}

		public EnvironmentalConfiguration get() throws Exception { 
			return super.get(EnvironmentalConfiguration.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnvironmentalConfiguration.class.
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
	 * Returns a new instance of ReqSrvHardwareEnvConfigForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the hardware id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvHardwareEnvConfigForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareEnvConfigForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareEnvConfigForId( conn, id );
		throw new HPOneViewApiVersionException( SrvHardwareEnvConfigForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
