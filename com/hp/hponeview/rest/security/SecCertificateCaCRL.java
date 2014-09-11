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

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecCertificateCaCRL {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecCertificateCaCRL.requiredParms; };
	public static final Integer optionalParms() { return ReqSecCertificateCaCRL.optionalParms; };
	public static final String  _URI = "certificates/ca/crl/";

	/**
	 * Implements /rest/certificates/ca/crl
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/certificates.html#d4e273
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return String
	 */
	public static class ReqSecCertificateCaCRL extends HPOneViewRestRequest<ReqSecCertificateCaCRL> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecCertificateCaCRL( Connection conn ) {
			super( conn, _URI, ReqSecCertificateCaCRL.class, requiredParms, optionalParms );
		}

		public String get() throws Exception { 
			return super.get(String.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return Object.class.
     */
    public static Class<String> retType() { return String.class; }

    /**
	 * Convert the JSON encoded string into an instance of String.
	 * @param json - String containing JSON.
	 * @return String
	 */
	public static String fromJsonString( String json ) {
		return util.fromJsonString( String.class, json );
	}

	/**
	 * Returns a new instance of ReqSecCertificateCaCRL
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecCertificateCaCRL
	 */
	public static ReqSecCertificateCaCRL instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecCertificateCaCRL( conn );
		throw new HPOneViewApiVersionException( SecCertificateCaCRL.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
