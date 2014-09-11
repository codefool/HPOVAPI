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

import com.hp.hponeview.data.settings.UpgradeNotification;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgFirmwareNotification {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/firmware/notification/";
	public static final Integer requiredParms() { return ReqStgFirmwareNotification.requiredParms; };
	public static final Integer optionalParms() { return ReqStgFirmwareNotification.optionalParms; };
	/**
	 * Implements /rest/appliance/firmware/notification/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/firmware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.UpgradeNotification
	 */
	public static class ReqStgFirmwareNotification extends HPOneViewRestRequest<ReqStgFirmwareNotification> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgFirmwareNotification( Connection conn ) {
			super( conn, _URI, ReqStgFirmwareNotification.class, requiredParms, optionalParms );
		}

		public UpgradeNotification get() throws Exception { 
			return super.get(UpgradeNotification.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UpgradeNotification.class.
     */
    public static Class<UpgradeNotification> retType() { return UpgradeNotification.class; }

    /**
	 * Convert a string containing JSON into an instance of UpgradeNotification.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.UpgradeNotification.
	 */
	public static UpgradeNotification fromJsonString( String json ) {
		return util.fromJsonString( UpgradeNotification.class, json );
	}

	/**
	 * Returns a new instance of ReqStgFirmwareNotification
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgFirmwareNotification
	 */
	public static ReqStgFirmwareNotification instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgFirmwareNotification( conn );
		throw new HPOneViewApiVersionException( StgFirmwareNotification.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
