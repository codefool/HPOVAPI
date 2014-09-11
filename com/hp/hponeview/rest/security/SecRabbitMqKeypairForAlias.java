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

import com.hp.hponeview.data.security.RabbitMqClientCertV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecRabbitMqKeypairForAlias {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecRabbitMqKeypairForAlias.requiredParms; };
	public static final Integer optionalParms() { return ReqSecRabbitMqKeypairForAlias.optionalParms; };
	public static final String  _URI = "certificates/client/rabbitmq/keypair/%s/";

	/**
	 * Implements /rest/certificates/client/rabbitmq/keypair/{aliasName}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/certificates.html#d4e273
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param aliasName - String containing the RabbitMq user of interest.
	 * @return com.hp.hponeview.data.security.RabbitMqClientCert
	 */
	public static class ReqSecRabbitMqKeypairForAlias extends HPOneViewRestRequest<ReqSecRabbitMqKeypairForAlias> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecRabbitMqKeypairForAlias( Connection conn, String aliasName ) {
			super( conn, String.format( _URI, aliasName ), ReqSecRabbitMqKeypairForAlias.class, requiredParms, optionalParms );
		}

		public RabbitMqClientCertV2 get() throws Exception { 
			return super.get(RabbitMqClientCertV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return RabbitMqClientCert.class.
     */
    public static Class<RabbitMqClientCertV2> retType() { return RabbitMqClientCertV2.class; }

    /**
	 * Convert a string containing JSON into an instance of RabbitMqClientCert.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.RabbitMqClientCert.
	 */
	public static RabbitMqClientCertV2 fromJsonString( String json ) {
		return util.fromJsonString( RabbitMqClientCertV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSecRabbitMqKeypairForAlias
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param aliasName - String containing the alias name of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecRabbitMqKeypairForAlias
	 */
	public static ReqSecRabbitMqKeypairForAlias instance( Connection conn, String aliasName )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecRabbitMqKeypairForAlias( conn, aliasName );
		throw new HPOneViewApiVersionException( SecRabbitMqKeypairForAlias.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
