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

public class PortV2 {
	public String  associatedUplinkSetObjectId;
	public String  associatedUplinkSetUri;
	public Integer bayNumber;
	public String [] capability;	  // EnetFcoe | Ethernet | FibreChannel | Unknown
	public String  category;
	public String [] configPortTypes; // EnetFcoe | Ethernet | FibreChannel | Unknown 
	public String  connectorType;
	public String  created;
	public String  description;
	public String  eTag;
	public Boolean enabled;
	public FcPortProperties fcPortProperties;
	public String  interconnectName;
	public Integer lagId;
	public String  modified;
	public String  name;
	public Neighbor neighbor;
	public String  operationalSpeed;
	public String  pairedPortName;
	public String  portHealthStatus;	// Disabled | Error | Normal | Warning
	public String  portId;
	public String  portMonitorConfigInfo; // AnalyzerPort | MonitoredBoth | MonitoredFromServer | MonitoredToServer | NotMonitored
	public String  portName;
	public String  portStatus;	// Linked | Unlinked | Unknown
	public String  portStatusReason; //	Active | AdminDisabled | AdminHidden | EkeyMismatch | FabricTypeMismatch 
									 // FailedValidation | LoggedIn | LoopDetected | ModuleIncompatible | ModuleUnrecognized 
									 // ModuleUnsupported | None | NotLoggedIn | Ok | OkNonHP | OkUncertified 
									 // PauseFloodDetected | PortPairMisMatchSfpType | PortPairMismatchEnetSpeed | SmartLink 
									 // SmartLinkButNoDCC | StandBy | Unavailable | Unknown | Unpopulated | UnsupportedStorage
	public String  portType;
	public String  portTypeExtended;
	public String  state;
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public SubPort [] subports;
	public String  type;
	public String  uri;
}
