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

public class SecLoginDomainList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecLoginDomainList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecLoginDomainList.optionalParms; };
	public static final String  _URI = "logindomains/";

	/**
	 * Implements /rest/logindomains/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.LoginDomainConfigInfo[]
	 */
	public static class ReqSecLoginDomainList extends HPOneViewRestRequest<ReqSecLoginDomainList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecLoginDomainList( Connection conn ) {
			super( conn, _URI, ReqSecLoginDomainList.class, requiredParms, optionalParms );
		}

		public LoginDomainConfigInfo[] get() throws Exception { 
			return super.get(LoginDomainConfigInfo[].class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LoginDomainConfigInfo[].class.
     */
    public static Class<LoginDomainConfigInfo[]> retType() { return LoginDomainConfigInfo[].class; }

    /**
	 * Convert a string containing JSON into an instance of LoginDomainConfigInfo[].
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.LoginDomainConfigInfo[].
	 */
	public static LoginDomainConfigInfo[] fromJsonString( String json ) {
		return util.fromJsonString( LoginDomainConfigInfo[].class, json );
	}

	/**
	 * Returns a new instance of ReqLoginDomainsList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqLoginDomainsList
	 */
	public static ReqSecLoginDomainList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecLoginDomainList( conn );
		throw new HPOneViewApiVersionException( SecLoginDomainList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
