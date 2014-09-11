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
package com.hp.hponeview.data.network.interconnects;

import com.hp.hponeview.data.network.Location;
import com.hp.hponeview.data.network.SnmpConfiguration;

public class InterconnectV2 {
	public class InterconnectIpAddress {
		public String ipAddress;
		public String ipAddressType; // Ipv4 | Ipv6Dchp | Ipv6LinkLocal | Ipv6Slaac | Ipv6Static | Unknown;
	}
	
	public String  category;
	public String  created;
	public String  description;
	public String  eTag;
	public Boolean edgeVirtualBridgingAvailable;
	public Boolean enableFastMacCacheFailover;
	public Boolean enableIgmpSnooping;
	public Boolean enableNetworkLoopProtection;
	public Boolean enablePauseFloodProtection;
	public String  enclosureName;
	public String  enclosureUri;
	public String  firmwareVersion;
	public Integer igmpIdleTimeoutInterval;
	public String  interconnectIP;
	public Location interconnectLocation;
	public String  interconnectTypeUri;
	public InterconnectIpAddress [] ipAddressList;
	public String  logicalInterconnectUri;
	public String  maxBandwidth; 	// AutoSpeed_100G | Speed_100M | Speed_10G | Speed_10M | Speed_12G | Speed_13G 
  								    // Speed_1G | Speed_1M | Speed_20G | Speed_24G | Speed_2G | Speed_2_5G | Speed_30G
								    // Speed_5G | Speed_8G | Speed_15G | Speed_16G | Speed_40G | Speed_4G
	public String  model;
	public String  modified;
	public String  name;
	public Integer networkLoopProtectionInterval;
	public String  partNumber;
	public Integer portCount;
	public PortV2 [] ports;
	public String  powerStatus;
	public String  productName;
	public String [] roles;
	public String  serialNumber;
	public SnmpConfiguration snmpConfiguration;
	public String  state;
	public String  status;
	public Integer subPortCount;
	public String  type; //'interconnectV2'
	public String [] unsupportedCapabilities;	// BladeSystem_C7000_G1 | Unknown
	public String  uri;
}
