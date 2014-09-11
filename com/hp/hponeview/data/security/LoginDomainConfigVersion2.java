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

public class LoginDomainConfigVersion2 {
	public class DirectoryServer {
		public String category;
		public String created;
		public String directoryServerCertificateBase64Data;
		public String directoryServerCertificateStatus;
		public String directoryServerIpAddress;
		public String directoryServerSSLPortNumber;
		public String eTag;
		public String modified;
		public String serverStatus;
		public String type;	// 'LoginDomainDirectoryServerInfoDto'
		public String uri;
	}
	
	public String  authProtocol;
	public String  category;
	public String  created;
	public Credential credential;
	public DirectoryServer [] directoryServers;
	public String  eTag;
	public String  loginDomain;
	public String  modified;
	public String  name;
	public String  org;
	public String  top;
	public String  type; //'LoginDomainConfigVersion2Dto'
	public String  uri;
	public Boolean useSsl;
	public String  userNameField;
}
