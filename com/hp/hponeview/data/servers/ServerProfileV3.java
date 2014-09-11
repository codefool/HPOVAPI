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

public class ServerProfileV3 {
	public class StoragePath {
		public Integer connectionId;
		public Boolean isEnabled;
		public String  status;
		public String [] storageTargets;
	}
	
	public class VolumeAttachment {
		public Integer id;
		public String  lun;
		public String  lunType;
		public String  state;
		public String  status;
		public StoragePath [] storagePaths;
		public String  volumeDescription;
		public String  volumeName;
		public String  volumeProvisionType;
		public String  volumeProvisionedCapacityBytes;
		public Boolean volumeSharable;
		public String  volumeStoragePoolUri;
		public String  volumeStorageSystemUri;
		public String  volumeUri;
	}
	
	public class SanStorage {
		public String  hostOSType;
		public Boolean manageSanStorage;
		public VolumeAttachment [] volumeAttachments;
	}
	
	public class LogicalDriveV2{
		public Boolean bootable;
		public String  raidLevel;
	}
	
	public class LocalStorageSettingsV2 {
		public Boolean initialize;
		public LogicalDriveV2 [] logicalDrives;
		public Boolean manageLocalStorage;
	}
	
	public class BootTarget {
		public String  arrayWwpn;
		public String  lun;
	}
	
	public class ConnectionBoot {
		public String  priority;	// NotBootable | Primary | Secondary
		public BootTarget [] targets;
	}
	
	public class ProfileConnectionV2 {
		public Integer allocatedMbps;
		public ConnectionBoot boot;
		public String  deploymentStatus;	// Deployed | Reserved | Undefined
		public String  functionType;		// Ethernet | FibreChannel
		public Integer id;
		public String  interconnectUri;
		public String  mac;
		public String  macType;				// Physical | UserDefined | Virtual
		public Integer maximumMbps;
		public String  networkType;
		public String  networkUri;
		public String  portId;
		public String  requestedMbps;		// Can be "Auto"
		public String  wwnn;
		public String  wwpn;
		public String  wwpnType;			// Physical | UserDefined | Virtual
	}
	
	public class FirmwareSettingsV2 {
		public String  firmwareBaselineUri;
		public Boolean forceInstallFirmware;
		public Boolean manageFirmware;
	}
	
	public class BootSettings {
		public Boolean manageBoot;
		public String [] order;		// CD | Floppy | USB | HardDisk | PXE
	}

	public class OverriddenSetting {
		public String id;
		public String value;
	}
	
	public class BiosSettings {
		public Boolean  manageBios;
		public OverriddenSetting [] overriddenSettings;
	}
	
	public String  affinity;		// Bay | BayAndServer
	public String  associatedServer;
	public BiosSettings bios;
	public BootSettings boot;
	public String  category;		// 'server-profiles'
	public ProfileConnectionV2 [] connections;
	public String  created;
	public String  description;
	public String  eTag;
	public Integer enclosureBay;
	public String  enclosureGroupUri;
	public String  enclosureUri;
	public FirmwareSettingsV2 firmware;
	public Boolean inProgress;
	public LocalStorageSettingsV2 localStorage;
	public String  macType;			// Physical | UserDefined | Virtual
	public String  modified;
	public String  name;
	public SanStorage sanStorage;
	public String  serialNumber;
	public String  serialNumberType;	// Physical | UserDefined | Virtual
	public String  serverHardwareTypeUri;
	public String  serverHardwareUri;
	public String  state;
	public String  status;
	public String  taskUri;
	public String  type; 		// 'ServerProfileV3'
	public String  uri;
	public String  uuid;
	public String  wwnType;		// Physical | UserDefined | Virtual
}
