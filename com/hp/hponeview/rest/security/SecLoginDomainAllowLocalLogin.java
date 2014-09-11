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

import com.hp.hponeview.data.security.AllowLocalLogin;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecLoginDomainAllowLocalLogin {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecLoginDomainAllowLocalLogin.requiredParms; };
	public static final Integer optionalParms() { return ReqSecLoginDomainAllowLocalLogin.optionalParms; };
	public static final String  _URI = "logindomains/global-settings/allow-local-login/";

	/**
	 * Implements /rest/logindomains/global-settings/allow-local-login/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains-global-settings.html#d4e47
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.AllowLocalLogin
	 */
	public static class ReqSecLoginDomainAllowLocalLogin extends HPOneViewRestRequest<ReqSecLoginDomainAllowLocalLogin> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecLoginDomainAllowLocalLogin( Connection conn ) {
			super( conn, _URI, ReqSecLoginDomainAllowLocalLogin.class, requiredParms, optionalParms );
		}

		public AllowLocalLogin get() throws Exception { 
			return super.get(AllowLocalLogin.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AllowLocalLogin.class.
     */
    public static Class<AllowLocalLogin> retType() { return AllowLocalLogin.class; }

    /**
	 * Convert a string containing JSON into an instance of AllowLocalLogin.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.AllowLocalLogin.
	 */
	public static AllowLocalLogin fromJsonString( String json ) {
		return util.fromJsonString( AllowLocalLogin.class, json );
	}

	/**
	 * Returns a new instance of ReqLoginDomainsAllowLocalLogin
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqLoginDomainsAllowLocalLogin
	 */
	public static ReqSecLoginDomainAllowLocalLogin instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecLoginDomainAllowLocalLogin( conn );
    throw new HPOneViewApiVersionException( SecLoginDomainAllowLocalLogin.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
