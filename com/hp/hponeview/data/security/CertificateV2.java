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

public class CertificateV2 {
	public String alternativeName;
	public String base64Data;
	public String category;
	public String challengePassword;
	public String commonName;
	public String contactPerson;
	public String country;
	public String created;
	public String description;
	public String dnQualifier;
	public String eTag;
	public String email;
	public String expiresInDays;
	public String givenName;
	public String initials;
	public String issuer;
	public String locality;
	public String md5Fingerprint;
	public String modified;
	public String name;
	public String organization;
	public String organizationUnit;
	public String serialNumber;
	public String sha1Fingerprint;
	public String state;
	public String status;	// OK | Disabled | Warning | Critical | Unknown
	public String surname;
	public String type;		// 'CertificateDtoV2'
	public String unstructuredName;
	public String uri;
	public String validFrom;
	public String validUntil;
	public String version;
}
