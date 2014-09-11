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

import com.hp.hponeview.data.settings.UpgradeInfo;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgFirmwarePending {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/firmware/pending/";
	public static final Integer requiredParms() { return ReqStgFirmwarePending.requiredParms; };
	public static final Integer optionalParms() { return ReqStgFirmwarePending.optionalParms; };
	/**
	 * Implements /rest/appliance/firmware/pending/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/appliance-firmware.html#d4e71
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.UpgradeInfo
	 */
	public static class ReqStgFirmwarePending extends HPOneViewRestRequest<ReqStgFirmwarePending> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgFirmwarePending( Connection conn ) {
			super( conn, _URI, ReqStgFirmwarePending.class, requiredParms, optionalParms );
		}

		public UpgradeInfo get() throws Exception { 
			return super.get(UpgradeInfo.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UpgradeInfo.class.
     */
    public static Class<UpgradeInfo> retType() { return UpgradeInfo.class; }

    /**
	 * Convert a string containing JSON into an instance of UpgradeInfo.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.UpgradeInfo.
	 */
	public static UpgradeInfo fromJsonString( String json ) {
		return util.fromJsonString( UpgradeInfo.class, json );
	}

	/**
	 * Returns a new instance of ReqStgFirmwarePending
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgFirmwarePending
	 */
	public static ReqStgFirmwarePending instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgFirmwarePending( conn );
		throw new HPOneViewApiVersionException( StgFirmwarePending.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
