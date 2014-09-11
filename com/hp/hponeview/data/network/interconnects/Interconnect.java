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

public class Interconnect {
	public Integer portCount;
	public String  logicalInterconnectUri;
	public SnmpConfiguration snmpConfiguration;
	public Integer igmpIdleTimeoutInterval;
	public InterconnectPort [] ports;
	public String  interconnectTypeUri;
	public String  powerStatus;		// On | Off | Unknown
	public String  partNumber;
	public String  enclosureName;
	public String  firmwareVersion;
	public String  enclosureUri;
	public String  interconnectIP;
	public String  productName;
	public String  model;
	public Location interconnectLocation;
	public String  maxBandwidth;
	public Integer subPortCount;
	public Boolean edgeVirtualBridgingAvailable;
	public Boolean enableIgmpSnooping;
	public Integer networkLoopProtectionInterval;
	public Boolean enableNetworkLoopProtection;
	public Boolean enableFastMacCacheFailover;
	public String  serialNumber;
	public String  category;
	public String  state;
	public String  type; //'interconnect'
	public String  status;
	public String  description;
	public String  name;
	public String  created;
	public String  modified;
	public String  eTag;
	public String  uri;
}
