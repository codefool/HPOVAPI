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

public class EnclosureGroupV2 {
	public class InterconnectBayMapping {
		public Integer interconnectBay;
		public String  logicalInterconnectGroupUri;
	}

	public class PortMapping {
		public Integer interconnectBay;
		public Integer midplanePort;
	}
	
	public String  category;
	public String  configurationScript;	// API doc says 'unknown type' but schema says string.
	public String  configurationScriptUri;
	public String  created;
	public String  description;
	public String  eTag;
	public Integer interconnectBayMappingCount;
	public InterconnectBayMapping [] interconnectBayMappings;
	public String  modified;
	public String  name;
	public Integer portMappingCount;
	public PortMapping [] portMappings;
	public String  stackingMode;	// Enclosure | MultiEnclosure | None | SwitchPairs
	public String  state;
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public String  type; 	//'EnclosureGroupV2'
	public String  uri;
}
