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

import com.hp.hponeview.data.security.LoginDomainConfigVersion2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecLoginDomainConfigForDomainName {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecLoginDomainConfigForDomainName.requiredParms; };
	public static final Integer optionalParms() { return ReqSecLoginDomainConfigForDomainName.optionalParms; };
	public static final String  _URI = "logindomains/%s/";
	
	/**
	 * Implements /rest/logindomains/{loginDomain}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains.html#d4e195
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param loginDomain - String containing login domain name of interest.
	 * @return com.hp.hponeview.data.security.LoginDomainConfigVersion2
	 */
	public static class ReqSecLoginDomainConfigForDomainName extends HPOneViewRestRequest<ReqSecLoginDomainConfigForDomainName> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecLoginDomainConfigForDomainName( Connection conn, String loginDomain ) {
			super( conn, String.format( _URI, loginDomain ), ReqSecLoginDomainConfigForDomainName.class, requiredParms, optionalParms );
		}

		public LoginDomainConfigVersion2 get() throws Exception { 
			return super.get(LoginDomainConfigVersion2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LoginDomainConfigVersion2.class.
     */
    public static Class<LoginDomainConfigVersion2> retType() { return LoginDomainConfigVersion2.class; }

    /**
	 * Convert a string containing JSON into an instance of LoginDomainConfigVersion2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.LoginDomainConfigVersion2.
	 */
	public static LoginDomainConfigVersion2 fromJsonString( String json ) {
		return util.fromJsonString( LoginDomainConfigVersion2.class, json );
	}

	/**
	 * Returns a new instance of ReqLoginDomainForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param loginDomain - String containing the login domain of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqLoginDomainForId
	 */
	public static ReqSecLoginDomainConfigForDomainName instance( Connection conn, String loginDomain )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecLoginDomainConfigForDomainName( conn, loginDomain );
		throw new HPOneViewApiVersionException( SecLoginDomainConfigForDomainName.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
