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

public class LogicalInterconnect {
	public class InterconnectMapEntry {
		public String interconnectUri;
		public String logicalDownlinkUri;
		public Location location;
		public String permittedInterconnectTypeUri;
	}
	
	public class InterconnectMap {
		public InterconnectMapEntry [] interconnectMapEntries;
	}
	
	public String status;
	public String category;
	public String stackingHealth;
	public String logicalInterconnectGroupUri;
	public InterconnectMap interconnectMap;
	public String [] interconnects;
	public String created;
	public String [] enclosureUris;
	public String fusionDomainUri;
	public String consistencyStatus;
	public PortMonitor portMonitor;
	public TelemetryConfiguration telemetryConfiguration;
	public String name;
	public String state;
	public String eTag;
	public SnmpConfiguration snmpConfiguration;
	public String modified;
	public EthernetInterconnectSettings ethernetSettings;
	public String uri;
	public String type; //'logical-interconnect'
	public String description;
}
