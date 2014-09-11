/*****************************************************************************
*
* copyright.txt
*
* Copyright 2013 Hewlett-Packard Development Company, L.P.
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
*
*****************************************************************************/
package com.hp.hponeview.data.security;

public class RabbitMqClientCertV2 {
	public String  aliasName;
	public String  base64SSLCertData;	// -----BEGIN CERTIFICATE----- encoded ssl certificate data -----END CERTIFICATE-----
	public String  base64SSLKeyData;	// -----BEGIN RSA PRIVATE KEY----- encoded private key data -----END RSA PRIVATE KEY-----
	public String  category;
	public String  commonName;
	public String  countryName;
	public String  created;
	public String  description;
	public String  eTag;
	public String  emailAddress;
	public String  expiresInDays;
	public String  keysize;
	public String  locality;
	public String  modified;
	public String  name;
	public String  organizationName;
	public String  organizationUnitName;
	public String  pkcs12KeyPair;
	public Boolean signedCert;
	public String  state;
	public String  stateOrProvinceName;
	public String  status;		// OK | Disabled | Warning | Critical
	public String  type; 		//'RabbitMqClientCertV2'
	public String  uri;
}
