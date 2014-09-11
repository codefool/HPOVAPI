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

import com.hp.hponeview.data.security.CertificateV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecHttpsCertificate {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecHttpsCertificate.requiredParms; };
	public static final Integer optionalParms() { return ReqSecHttpsCertificate.optionalParms; };
	public static final String  _URI = "certificates/https/";

	/**
	 * Implements /rest/certificates/https/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/certificates/https
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.RabbitMqClientCert
	 */
	public static class ReqSecHttpsCertificate extends HPOneViewRestRequest<ReqSecHttpsCertificate> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecHttpsCertificate( Connection conn ) {
			super( conn, _URI, ReqSecHttpsCertificate.class, requiredParms, optionalParms );
		}

		public CertificateV2 get() throws Exception { 
			return super.get(CertificateV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return CertificateV2.class.
     */
    public static Class<CertificateV2> retType() { return CertificateV2.class; }

    /**
	 * Convert a string containing JSON into an instance of CertificateV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.CertificateV2.
	 */
	public static CertificateV2 fromJsonString( String json ) {
		return util.fromJsonString( CertificateV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSecHttpsCertificate
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecHttpsCertificate
	 */
	public static ReqSecHttpsCertificate instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecHttpsCertificate( conn );
			throw new HPOneViewApiVersionException( SecHttpsCertificate.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
