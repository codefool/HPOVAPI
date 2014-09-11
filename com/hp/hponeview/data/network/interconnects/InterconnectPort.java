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

public class InterconnectPort {
	public String  associatedUplinkSetObjectId;
	public Integer bayNumber;
	public String [] capability;
	public String  category;
	public String [] configPortTypes;
	public String  connectorType;
	public String  created;
	public String  description;
	public Boolean enabled;
	public String  eTag;
	public FcPortProperties fcPortProperties;
	public String  interconnectName;
	public Integer lagId;
	public String  modified;
	public String  name;
	public Neighbor neighbor;
	public String  operationalSpeed;
	public String  portHealthStatus;	// Normal | Warning | Error | Disabled
	public String  portId;
	public String  portMonitorConfigInfo; // NotMonitored | MonitoredToServer | MonitoredFromServer | MonitoredBoth | AnalyzerPort
	public String  portName;
	public String  portType;	// Uplink | Downlink | Stacking | Auto
	public String  portStatus;			// Linked | Unlinked | Unknown
	public String  portStatusReason;
	public String  portTypeExtended;	// Internal | External | Unknown
	public SubPort [] subports;
	public String  state;
	public String  status;
	public String  type; 	// 'port'
	public String  uri;
}
