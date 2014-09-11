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
package com.hp.hponeview.data.network.logical_interconnects;

import com.hp.hponeview.data.network.Location;
import com.hp.hponeview.data.network.SnmpConfiguration;

public class LogicalInterconnectV2 {
	public class InterconnectMapEntry {
		public String   interconnectUri;
		public Location location;
		public String   logicalDownlinkUri;
		public String   permittedInterconnectTypeUri;
	}
	
	public class InterconnectMap {
		public InterconnectMapEntry [] interconnectMapEntries;
	}
	
	public String  category;
	public String  consistencyStatus;	// CONSISTENT | NOT_CONSISTENT
	public String  created;
	public String  description;
	public String  domainUri;
	public String [] enclosureUris;
	public String  eTag;
	public EthernetInterconnectSettings ethernetSettings;
	public InterconnectMap interconnectMap;
	public String [] interconnects;
	public String  logicalInterconnectGroupUri;
	public String  modified;
	public String  name;
	public PortMonitor portMonitor;
	public SnmpConfiguration snmpConfiguration;
	public String  stackingHealth;	// BiConnected | Connected | Disconnected | Unknown
	public String  state;
	public String  status;			// OK | Disabled | Warning | Critical | Unknown
	public TelemetryConfiguration telemetryConfiguration;
	public String  type; 			//'logical-interconnectV2'
	public String  uri;
}
