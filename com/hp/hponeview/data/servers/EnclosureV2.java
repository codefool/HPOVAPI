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

public class EnclosureV2 {
	public class PowerSupply {
		public Integer bayNumber;
		public String  devicePresence;		// Absent | PresenceNoOp | PresenceUnknown | Present | Subsumed\
		public String  model;
		public String  partNumber;
		public String  serialNumber;
		public String  sparePartNumber;
		public String  status;	// Critical | Disabled | OK | Unknown | Warning
	}
	
	public class OaIpv6Address {
		public String address;
		public String type;	// LinkLocal | NotSet | RouterAdv | Static | Unknown
	}

	public class OnboardAdministrator {
		public Integer bayNumber;
		public Boolean dhcpEnable;
		public Boolean dhcpIpv6Enable;
		public String  fqdnHostName;
		public String  fwBuildDate;
		public String  fwVersion;
		public String  ipAddress;
		public OaIpv6Address [] ipv6Addresses;
		public String  role;	// Active | OaAbsent | Standby | Transition | Unknown
		public String  state;	// Offline | Online
	}

	public class InterconnectBay {
		public Integer bayNumber;
		public String  interconnectUri;
		public String  logicalInterconnectUri;
	}
	
	public class Fan {
		public Integer bayNumber;
		public String  devicePresence;	// Absent | PresenceNoOp | PresenceUnknown | Present | Subsumed
		public Boolean deviceRequired;
		public String  model;
		public String  partNumber;
		public String  sparePartNumber;
		public String  state;	// Degraded | Failed | Misplaced | Missing | OK
		public String  status;	// Critical | Disabled | OK | Unknown | Warning
	}
	
	public class DeviceBay {
		public Boolean availableForFullHeightProfile;
		public Boolean availableForHalfHeightProfile;
		public Integer bayNumber;
		public String  category;
		public String  coveredByDevice;
		public String  coveredByProfile;
		public String  created;
		public String  devicePresence;
		public String  deviceUri;
		public String  eTag;
		public String  enclosureUri;
		public String  model;
		public String  modified;
		public String  profileUri;
		public String  type;		// 'DeviceBay'
		public String  uri;
	}

	public String  activeOaPreferredIP;
	public String  assetTag;
	public String  category;
	public String  configurationScript;
	public String  configurationScriptUri;
	public Boolean consistentWithGroup;
	public String  created;
	public String  description;
	public Integer deviceBayCount;
	public DeviceBay [] deviceBays;
	public String  eTag;
	public String  enclosureGroupUri;
	public String  enclosureType;
	public Integer fanBayCount;
	public Fan []  fanBays;
	public String  fwBaselineName;
	public String  fwBaselineUri;
	public Integer interconnectBayCount;
	public InterconnectBay [] interconnectBays;
	public Boolean isFwManaged;
	public String  licensingIntent;		// OneView | OneViewNoiLO
	public String  modified;
	public String  name;
	public OnboardAdministrator [] oa;
	public Integer oaBayCount;
	public String  partNumber;
	public Integer powerSupplyBayCount;
	public PowerSupply [] powerSupplyBays;
	public String  rackName;
	public String  reconfigurationState;
	public String  refreshState;	// NotRefreshing | RefreshFailed | RefreshPending | Refreshing
	public String  serialNumber;
	public String  standbyOaPreferredIP;
	public String  state;
	public String  stateReason;
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public String  type; 	//'EnclosureV2'
	public String  uri;
	public String  uuid;
	public String  vcmDomainId;
	public String  vcmDomainName;
	public Boolean vcmMode;
	public String  vcmUrl;
}
