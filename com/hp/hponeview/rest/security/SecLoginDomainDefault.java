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

import com.hp.hponeview.data.security.LoginDomainConfigInfo;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecLoginDomainDefault {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecLoginDomainDefault.requiredParms; };
	public static final Integer optionalParms() { return ReqSecLoginDomainDefault.optionalParms; };
	public static final String  _URI = "loglogindomains/global-settings/default-login-domain/";

	/**
	 * Implements /rest/logindomains/global-settings/default-login-domain/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains-global-settings.html#d4e103
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.LoginDomainConfigInfo
	 */
	public static class ReqSecLoginDomainDefault extends HPOneViewRestRequest<ReqSecLoginDomainDefault> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecLoginDomainDefault( Connection conn ) {
			super( conn, _URI, ReqSecLoginDomainDefault.class, requiredParms, optionalParms );
		}

		public LoginDomainConfigInfo get() throws Exception { 
			return super.get(LoginDomainConfigInfo.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LoginDomainConfigInfo.class.
     */
    public static Class<LoginDomainConfigInfo> retType() { return LoginDomainConfigInfo.class; }

    /**
	 * Convert a string containing JSON into an instance of LoginDomainConfigInfo.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.LoginDomainConfigInfo.
	 */
	public static LoginDomainConfigInfo fromJsonString( String json ) {
		return util.fromJsonString( LoginDomainConfigInfo.class, json );
	}

	/**
	 * Returns a new instance of ReqSecLoginDomainDefault
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecLoginDomainDefault
	 */
	public static ReqSecLoginDomainDefault instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecLoginDomainDefault( conn );
		throw new HPOneViewApiVersionException( SecLoginDomainDefault.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
