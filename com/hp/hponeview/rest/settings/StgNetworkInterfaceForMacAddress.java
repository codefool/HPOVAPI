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
package com.hp.hponeview.rest.settings;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.data.settings.ApplianceNicConfiguration;

public class StgNetworkInterfaceForMacAddress {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/network-interfaces/%s/";
	public static final Integer requiredParms() { return ReqStgNetworkInterfacesForMacAddress.requiredParms; };
	public static final Integer optionalParms() { return ReqStgNetworkInterfacesForMacAddress.optionalParms; };
	/**
	 * Implements /rest/appliance/network-interfaces/{macAddress}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/network-interfaces
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param macAddress - String containing the MAC address of interest.
	 * @return com.hp.hponeview.data.settings.ApplianceNicConfiguration
	 */
	public static class ReqStgNetworkInterfacesForMacAddress extends HPOneViewRestRequest<ReqStgNetworkInterfacesForMacAddress> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStgNetworkInterfacesForMacAddress( Connection conn, String macAddress ) {
			super( conn, String.format( _URI, macAddress ), ReqStgNetworkInterfacesForMacAddress.class, requiredParms, optionalParms );
		}

		public ApplianceNicConfiguration get() throws Exception { 
			return super.get( ApplianceNicConfiguration.class ); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ApplianceNicConfiguration.class.
     */
    public static Class<ApplianceNicConfiguration> retType() { return ApplianceNicConfiguration.class; }

    /**
	 * Convert a string containing JSON into an instance of ApplianceNicConfiguration.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.ApplianceNicConfiguration.
	 */
	public static ApplianceNicConfiguration fromJsonString( String json ) {
		return util.fromJsonString( ApplianceNicConfiguration.class, json );
	}

	/**
	 * Returns a new instance of ReqStgNetworkInterfacesForMacAddress
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param macAddress - String containing the MAC address of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgNetworkInterfacesForMacAddress
	 */
	public static ReqStgNetworkInterfacesForMacAddress instance( Connection conn, String macAddress )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgNetworkInterfacesForMacAddress( conn, macAddress );
		throw new HPOneViewApiVersionException( StgNetworkInterfaceForMacAddress.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
