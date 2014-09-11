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
package com.hp.hponeview.data.servers;

public class ConnectionInstance {
	public class ConnectionBandwidth {
		public Integer maximum;
		public Integer typical;
	}
	
	public Object  IPAddress;
	public Object  MACAddress;
	public String  category;
	public ConnectionBandwidth connectionBandwidth;
	public String  connectionInstanceId;
	public String  connectionInstanceStatus;	// Active | Deployed | Enforcing | Failed | Released | Reserved
	public String  connectionInstanceType;	// Ethernet | Fcoe | FibreChannel | NetworkSet
	public String  containerId;
	public String  created;
	public String  description;
	public String  eTag;
	public String  fcPortOpSpeed;		// Auto | Speed0M | Speed100M | ...
	public Integer interconnectPort;
	public Integer interconnectSubPort;
	public String  interconnectUri;
	public String  ipaddress;
	public String  macAssignment;	// Physical | Virtual | UserDefined
	public String  macaddress;
	public String  modified;
	public String  name;
	public String  networkResourceUri;
	public Integer sTag;
	public String  state;
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public String  type;	// 'ConnectionInstance'
	public String  uri;
	public String  wwnAssignment;	// Physical | Virtual | UserDefined
	public String  wwnn;
	public String  wwpn;
}
