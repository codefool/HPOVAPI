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
package com.hp.hponeview.data.security;

public class CertificateInfo {
	public class CertificateStatus {
		public String  chainStatus;
		public Boolean selfsigned;
		public String  status;	// OK | Disabled | Warning | Critical | Unknown
		public Boolean trusted;
	}
	public class CertificateDetail {
		public String alternativeName;
		public String base64Data;
		public String basicConstraints;
		public String commonName;
		public String contactPerson;
		public String country;
		public String [] crlDistributionPoints;
		public String dnQualifier;
		public String email;
		public String enhancedKeyUsage;
		public String expiresInDays;
		public String givenName;
		public String initials;
		public String issuer;
		public String locality;
		public String md5Fingerprint;
		public String organization;
		public String organizationalUnit;
		public String publicKey;
		public String serialNumber;
		public String shaFingerprint;
		public String signatureAlgorithm;
		public String state;
		public String surname;
		public String validFrom;
		public String validUntil;
		public String version;
	}
	public String  base64Data;
	public String  category;
	public CertificateDetail [] certificateDetails;
	public CertificateStatus certificateStatus;
	public String  created;
	public String  description;
	public String  eTag;
	public String  modified;
	public String  name;
	public String  state;
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public String  type;	// 'CertificateInfo'
	public String  uri;
}
