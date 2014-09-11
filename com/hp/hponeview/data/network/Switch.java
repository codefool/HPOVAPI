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
package com.hp.hponeview.data.network;

import com.hp.hponeview.data.EnvironmentalConfigurationV2;

public class Switch {
	public class ExtendedProperty {
		public String  propertyName;
		public String  value;
		public String  valueFormat;	// SecuritySensitive | Uknown
		public String  valueType;	// Boolean | Double | Float | Integer | String | Uknown
	}
	
	public class SwitchManagementConnection {
		public ExtendedProperty [] connectionProperties;
	}
	
	public String  category;
	public String  chassisId;
	public String  created;
	public String  description;
	public String  eTag;
	public EnvironmentalConfigurationV2 environmentalConfiguration;
	public String  firmwareVersion;
	public String  modelName;
	public String  modified;
	public String  name;
	public String  [] roles;	// Access | Aggregation | Core | Interconnect | Unknown
	public String  serialNumber;
	public String  state;
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public SwitchManagementConnection switchManagementConnection;
	public String  type;	// 'switch'
	public String  uri;
}
