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

import com.hp.hponeview.data.security.SSLCertificate;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecSslCertificateForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecSslCertificateForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSecSslCertificateForId.optionalParms; };
	public static final String  _URI = "certificates/%s/";
	
	/**
	 * Implements /rest/certificates/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/certificates.html#d4e457
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @return com.hp.hponeview.data.security.SSLCertificate
	 */
	public static class ReqSecSslCertificateForId extends HPOneViewRestRequest<ReqSecSslCertificateForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqSecSslCertificateForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSecSslCertificateForId.class, requiredParms, optionalParms );
		}

		public SSLCertificate get() throws Exception { 
			return super.get(SSLCertificate.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SSLCertificate.class.
     */
    public static Class<SSLCertificate> retType() { return SSLCertificate.class; }

    /**
	 * Convert a string containing JSON into an instance of SSLCertificate.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.SSLCertificate.
	 */
	public static SSLCertificate fromJsonString( String json ) {
		return util.fromJsonString( SSLCertificate.class, json );
	}

	/**
	 * Returns a new instance of ReqSecSslCertificateForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecSslCertificateForId
	 */
	public static ReqSecSslCertificateForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecSslCertificateForId( conn, id );
		throw new HPOneViewApiVersionException( SecSslCertificateForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
