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
package com.hp.hponeview.rest.network;

import com.hp.hponeview.data.EnvironmentalConfigurationV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetSwitchEnvConfigForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetSwitchEnvConfigForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetSwitchEnvConfigForId.optionalParms; };
	public static final String  _URI = "switches/%s/environmentalConfiguration/";

	/**
	 * Implements /rest/switches/{id}/environmentalConfiguration
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/uplink-sets.html#d4e131
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the switch of interest.
	 * @return com.hp.hponeview.data.EnvironmentalConfigurationV2
	 *
	 */
	public static class ReqNetSwitchEnvConfigForId extends HPOneViewRestRequest<ReqNetSwitchEnvConfigForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetSwitchEnvConfigForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetSwitchEnvConfigForId.class, requiredParms, optionalParms  );
		}

		public EnvironmentalConfigurationV2 get() throws Exception { 
			return super.get(EnvironmentalConfigurationV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnvironmentalConfigurationV2.class.
     */
    public static Class<EnvironmentalConfigurationV2> retType() { return EnvironmentalConfigurationV2.class; }

    /**
	 * Convert a string containing JSON into an instance of Switch.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.Switch.
	 */
	public static EnvironmentalConfigurationV2 fromJsonString( String json ) {
		return util.fromJsonString( EnvironmentalConfigurationV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetSwitchEnvConfigForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the switch of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetSwitchEnvConfigForId
	 */
	public static ReqNetSwitchEnvConfigForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetSwitchEnvConfigForId( conn, id );
		throw new HPOneViewApiVersionException( NetSwitchEnvConfigForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
