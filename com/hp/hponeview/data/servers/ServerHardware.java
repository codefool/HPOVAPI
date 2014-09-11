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

public class ServerHardware {
	public class ServerFabricVirtualPort {
		public String  mac;
		public String  portFunction;
		public Integer portNumber;
		public String  wwnn;
		public String  wwpn;
	}
	
	public class ServerFabricPhysicalPortV3 {
		public Integer interconnectPort;
		public String  interconnectUri;
		public String  mac;
		public Integer portNumber;
		public String  type;				// Ethernet | FibreChannel
		public ServerFabricVirtualPort [] virtualPorts;
		public String  wwn;
	}

	public class ServerFabricDeviceV3 {
		public String  deviceName;
		public String  location;		// Flb | Lom | Mezz
		public Integer oaSlotNumber;
		public ServerFabricPhysicalPortV3 [] pysicalPorts;
		public Integer slotNumber;
	}
	
	public class ServerFabricMapV3 {
		public ServerFabricDeviceV3 [] deviceSlots;
	}

	public class ServerSignature {
		public Integer personalityChecksum;
		public Integer serverHwChecksum;
	}

	public String  assetTag;
	public String  category;
	public String  created;
	public String  description;
	public String  eTag;
	public String  formFactor;
	public String  licensingIntent;	// OneView | OneViewNoiLO
	public String  locationUri;
	public Integer memoryMb;
	public String  model;
	public String  modified;
	public String  mpDnsName;
	public String  mpFirmwareVersion;
	public String  mpIpAddress;
	public String  mpModel;
	public String  name;
	public String  partNumber;
	public ServerFabricMapV3 portMap;
	public Integer position;
	public Boolean powerLock;
	public String  powerState;		// Off | On || PoweringOff | PoweringOn | Resetting | Unknown
	public Integer processorCoreCount;	
	public Integer processorCount;
	public Integer processorSpeedMhz;
	public String  processorType;
	public Object  profileNetworkSettingsState;
	public String  refreshState;	// NotRefreshing | RefreshFailed | RefreshPending | Refreshing
	public String  romVersion;
	public String  seraialNumber;
	public String  serverGroupUri;
	public String  serverHardwareTypeUri;
	public String  serverProfileUri;
	public String  shortModel;
	public ServerSignature signature;
	public String  state;			// Unknown | Adding | NoProfileApplied | Unmanaged | ...
	public String  stateReason;
	public String  status;			// OK | Disabled | Warning | Critical | Unknown
	public String  type;			// 'server-hardware-3'
	public String  uri;
	public String  uuid;
	public String  virtualSerialNumber;
	public String  virtualUuid;
}
