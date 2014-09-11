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
package com.hp.hponeview.rest.security;

import com.hp.hponeview.data.security.GlobalSettings;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecLoginDomainGlobalSettings {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecLoginDomainGlobalSettings.requiredParms; };
	public static final Integer optionalParms() { return ReqSecLoginDomainGlobalSettings.optionalParms; };
	public static final String  _URI = "logindomains/global-settings/";

	/**
	 * Implements /rest/logindomains/global-settings/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains-global-settings.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.GlobalSettings
	 */
	public static class ReqSecLoginDomainGlobalSettings extends HPOneViewRestRequest<ReqSecLoginDomainGlobalSettings> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecLoginDomainGlobalSettings( Connection conn ) {
			super( conn, _URI, ReqSecLoginDomainGlobalSettings.class, requiredParms, optionalParms );
		}

		public GlobalSettings get() throws Exception { 
			return super.get(GlobalSettings.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return GlobalSettings.class.
     */
    public static Class<GlobalSettings> retType() { return GlobalSettings.class; }

    /**
	 * Convert a string containing JSON into an instance of GlobalSettings.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.GlobalSettings.
	 */
	public static GlobalSettings fromJsonString( String json ) {
		return util.fromJsonString( GlobalSettings.class, json );
	}

	/**
	 * Returns a new instance of ReqSecLoginDomainGlobalSettings
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecLoginDomainGlobalSettings
	 */
	public static ReqSecLoginDomainGlobalSettings instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecLoginDomainGlobalSettings( conn );
		throw new HPOneViewApiVersionException( SecLoginDomainGlobalSettings.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
