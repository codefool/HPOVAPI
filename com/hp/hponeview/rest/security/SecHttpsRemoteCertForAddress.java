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

import com.hp.hponeview.data.security.CertificateInfo;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class SecHttpsRemoteCertForAddress {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecHttpsRemoteCertForAddress.requiredParms; };
	public static final Integer optionalParms() { return ReqSecHttpsRemoteCertForAddress.optionalParms; };
	public static final String  _URI = "certificates/https/remote/%s/";

	/**
	 * Implements /rest/certificates/https/remote/{address}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/certificates/https
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param addr - address of remote appliance web server
	 * @return com.hp.hponeview.data.security.RabbitMqClientCert
	 */
	public static class ReqSecHttpsRemoteCertForAddress extends HPOneViewRestRequest<ReqSecHttpsRemoteCertForAddress> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecHttpsRemoteCertForAddress( Connection conn, String addr ) {
			super( conn, String.format( _URI, addr ), ReqSecHttpsRemoteCertForAddress.class, requiredParms, optionalParms );
		}

		public CertificateInfo get() throws Exception { 
			return super.get(CertificateInfo.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return CertificateInfo.class.
     */
    public static Class<CertificateInfo> retType() { return CertificateInfo.class; }

    /**
	 * Convert a string containing JSON into an instance of CertificateInfo.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.CertificateInfo.
	 */
	public static CertificateInfo fromJsonString( String json ) {
		return util.fromJsonString( CertificateInfo.class, json );
	}

	/**
	 * Returns a new instance of ReqSecHttpsRemoteCertForAddress
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param addr - address of remote appliance web server
	 * @returns com.hp.hponeview.rest.Security.ReqSecHttpsRemoteCertForAddress
	 */
	public static ReqSecHttpsRemoteCertForAddress instance( Connection conn, String addr )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecHttpsRemoteCertForAddress( conn, addr );
		throw new HPOneViewApiVersionException( SecHttpsRemoteCertForAddress.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
