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
import com.hp.hponeview.data.security.SSLCertificatesList;

public class SecSslCertificatesList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecSslCertificatesList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecSslCertificatesList.optionalParms; };
	public static final String  _URI = "certificates/";

	/**
	 * Implements /rest/certificates/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/certificates.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.ReqSecSslCertificatesList
	 */
	public static class ReqSecSslCertificatesList extends HPOneViewRestRequest<ReqSecSslCertificatesList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecSslCertificatesList( Connection conn ) {
			super( conn, _URI, ReqSecSslCertificatesList.class, requiredParms, optionalParms );
		}

		public SSLCertificatesList get() throws Exception { 
			return super.get(SSLCertificatesList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SSLCertificatesList.class.
     */
    public static Class<SSLCertificatesList> retType() { return SSLCertificatesList.class; }

    /**
	 * Convert a string containing JSON into an instance of SSLCertificatesList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.SSLCertificatesList.
	 */
	public static SSLCertificatesList fromJsonString( String json ) {
		return util.fromJsonString( SSLCertificatesList.class, json );
	}

	/**
	 * Returns a new instance of ReqSecSslCertificatesList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecSslCertificatesList
	 */
	public static ReqSecSslCertificatesList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecSslCertificatesList( conn );
		throw new HPOneViewApiVersionException( SecSslCertificatesList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
