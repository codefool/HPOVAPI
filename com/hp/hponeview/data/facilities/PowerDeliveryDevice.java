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
package com.hp.hponeview.data.facilities;

public class PowerDeliveryDevice {
	public class ManagementModule {
		public String firmwareVersion;
		public String hostName;
		public String id;
		public String ipv4Address;
		public String ipv6Address;
		public String model;
		public String name;
		public String partNumber;
		public String serialNumber;
		public String state;	// ConfigError | Configured | CredentialError
	}
	
	public class PowerConnection {
		public String  connectionUri;
		public Integer deviceConnection;
		public Integer sourceConnection;
	}
	
	public String  category;
	public Integer coreId;
	public String  created;
	public String  deviceType;	// BranchCircuit | BreakerPanel | HPIpduAcModule | ...
	public String  eTag;
	public String  feedIdentifier;
	public String  id;
	public Integer lineVoltage;
	public Integer loadSegmentId;
	public ManagementModule managedBy;
	public String  model;
	public String  modified;
	public String  name;
	public Integer outletId;
	public String  partNumber;
	public String  phaseType;	// SinglePhase | SinglePhaseIntl | ThreePhaseDelta | ThreePhaseUnknown | ...
	public PowerConnection [] powerConnections;
	public Integer ratedCapacity;
	public String  serialNumber;
	public String  state;		// Adding | AddError | Configured | CredentialError | Refreshing | ...
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public String  type;
	public String  uri;
	public String  uuid;
}
