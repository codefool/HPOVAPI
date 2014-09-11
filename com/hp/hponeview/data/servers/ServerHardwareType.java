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

public class ServerHardwareType {
	public class BiosSettingOptionLink {
		public String action;		// Avoid | Composes
		public String optionId;
		public String settingId;
	}
	
	public class BiosSettingOption {
		public String id;
		public String name;
		public BiosSettingOptionLink [] optionLinks;
	}

	public class BiosSetting {
		public String  category;
		public String  defaultValue;
		public String  helpText;
		public String  id;
		public String  name;
		public BiosSettingOption [] options;
		public Integer stringMaxLength;
		public String  type;		// Number | Option
	}

	public class AdapterPort {
		public Integer mapping;
		public Integer maxSpeedMbps;
		public Integer number;
		public Integer physicalFunctionCount;
		public String  type;		// Ethernet | PXE | FibreChannel
	}
	
	public class Adapter {
		public String [] capabilities;
		public String  location;	// Flb | Lom | Mezz
		public String  model;
		public Integer oaSlotNumber;
		public AdapterPort [] ports;
		public Integer slot;
	}
	
	public Adapter [] adapters;
	public BiosSetting [] biosSettings;
	public String [] bootCapabilities;
	public String [] capabilities;
	public String category;
	public String created;
	public String description;
	public String eTag;
	public String formFactor;
	public Object id;
	public String model;
	public String modified;
	public String name;
	public String [] storageCapabilities;
	public String type;	// 'server-hardware-type-2'
	public String uri;
}
