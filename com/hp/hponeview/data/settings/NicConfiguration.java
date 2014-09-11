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
package com.hp.hponeview.data.settings;

/**
 * NicConfiguration
 * @author hesterg
 *
 */
public class NicConfiguration {
	public Integer activeNode;
	public Boolean aliasDisabled;
	public String  app1Ipv4Addr;
	public String  app1Ipv4Alias;
	public String  app1Ipv6Addr;
	public String  app1Ipv6Alias;
	public String  app2Ipv4Alias;
	public String  app2Ipv4Addr;
	public String  app2Ipv6Addr;
	public String  app2Ipv6Alias;
	public String  bondedTo;
	public Boolean confOneNode;
	public Boolean configurePostgresSslListener;
	public Boolean configureRabbitMqSslListener;
	public String  created;
	public String  device;
	public String  domainName;
	public String  hostname;
	public String  interfaceName;
	public String  ipv4Gateway;
	public String [] ipv4NameServers;
	public String  ipv4Subnet;
	public String  ipv4Type;		// DHCP | STATIC | UNCONFIGURE
	public String  ipv6Gateway;
	public String [] ipv6NameServers;
	public String  ipv6Subnet;
	public String  ipv6Type;		// DHCP | STATIC | UNCONFIGURE
	public String  macAddress;
	public Boolean overrideIpv4DhcpDnsServers;
	public Boolean overrideIpv6DhcpDnsServers;
	public String [] searchDomains;
	public Boolean unconfigure;
	public String  virtIpv4Addr;
	public String  virtIpv6Addr;
	public String  webServerCertificate;
	public String  webServerCertificateChain;
	public String  webServerCertificateKey;
}
