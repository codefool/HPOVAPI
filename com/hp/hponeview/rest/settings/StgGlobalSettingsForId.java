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

import com.hp.hponeview.data.settings.Setting;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgGlobalSettingsForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "global-settings/%s/";
	public static final Integer requiredParms() { return ReqGlobalSettingForId.requiredParms; };
	public static final Integer optionalParms() { return ReqGlobalSettingForId.optionalParms; };
	/**
	 * Implements /rest/global-settings/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/global-settings.html#d4e213
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the setting id of interest.
	 * @return com.hp.hponeview.data.settings.Setting
	 */
	public static class ReqGlobalSettingForId extends HPOneViewRestRequest<ReqGlobalSettingForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqGlobalSettingForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqGlobalSettingForId.class, requiredParms, optionalParms );
		}

		public Setting get() throws Exception { 
			return super.get(Setting.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Setting.class.
     */
    public static Class<Setting> retType() { return Setting.class; }

    /**
	 * Convert a string containing JSON into an instance of Setting.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.Setting.
	 */
	public static Setting fromJsonString( String json ) {
		return util.fromJsonString( Setting.class, json );
	}

	/**
	 * Returns a new instance of ReqGlobalSettingForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the setting id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqGlobalSettingForId
	 */
	public static ReqGlobalSettingForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqGlobalSettingForId( conn, id );
		throw new HPOneViewApiVersionException( StgGlobalSettingsForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
