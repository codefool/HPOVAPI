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

public class Port {
	public String  portHealthStatus; //	Normal | Warning | Error | Disabled	
	public String  modiefied;
	public Integer lagId;
	public String  connectorType;
	public String  operationalSpeed;
	public String  description;
	public String  category;
	public String  associatedUplinkSetObjectId;
	public FcPortProperties fcPortProperties;
	public String  portId;
	public String  portTypeExtended;
	public String  state;
	public SubPort [] subports;
	public String  portType; // 	Uplink | Downlink | Stacking | Auto	
	public String  type;
	public String  status;
	public String  portStatus; //	Linked | Unlinked | Unknown	
	public String  portMonitorConfigInfo; // NotMonitored | MonitoredToServer | MonitoredFromServer | MonitoredBoth | AnalyzerPort	
	public String [] configPortTypes;
	public String  eTag;
	public String  portName;
	public String  interconnectName;
	public String  portStatusReason; //	None |	Active | StandBy | LoggedIn | NotLoggedIn |	Unknown
									 // AdminHidden | LoopDetected | PauseFloodDetected | AdminDisabled
									 //	EkeyMismatch | Unpopulated | ModuleUnrecognized | FailedValidation
									 //	ModuleUnsupported | ModuleIncompatible | SmartLink | SmartLinkButNoDCC
									 //	OkUncertified | OkNonHP | UnsupportedStorage | FabricTypeMismatch
									 // Ok | Unavailable | PortPairMisMatchSfpType | PortPairMismatchEnetSpeed	
	public String  name;
	public String  created;
	public Boolean enabled;
	public String  uri;
	public String [] capability;
	public Neighbor neighbor;
	public Integer  bayNumber;
}
