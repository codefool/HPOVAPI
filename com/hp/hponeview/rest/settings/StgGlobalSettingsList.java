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

import com.hp.hponeview.data.settings.SettingsPaginatedCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgGlobalSettingsList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "global-settings/";
	public static final Integer requiredParms() { return ReqGlobalSettingsList.requiredParms; };
	public static final Integer optionalParms() { return ReqGlobalSettingsList.optionalParms; };
	/**
	 * Implements /rest/global-settings/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/global-settings
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.SettingsPaginatedCollection
	 */
	public static class ReqGlobalSettingsList extends HPOneViewRestRequest<ReqGlobalSettingsList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCOUNT | PFILTER | PSORT | PSTART | PVIEW;
		private ReqGlobalSettingsList( Connection conn ) {
			super( conn, _URI, ReqGlobalSettingsList.class, requiredParms, optionalParms );
		}

		public SettingsPaginatedCollection get() throws Exception { 
			return super.get(SettingsPaginatedCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SettingsPaginatedCollection.class.
     */
    public static Class<SettingsPaginatedCollection> retType() { return SettingsPaginatedCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of SettingsPaginatedCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.SettingsPaginatedCollection.
	 */
	public static SettingsPaginatedCollection fromJsonString( String json ) {
		return util.fromJsonString( SettingsPaginatedCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqGlobalSettingsList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqGlobalSettingsList
	 */
	public static ReqGlobalSettingsList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqGlobalSettingsList( conn );
		throw new HPOneViewApiVersionException( StgGlobalSettingsList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
