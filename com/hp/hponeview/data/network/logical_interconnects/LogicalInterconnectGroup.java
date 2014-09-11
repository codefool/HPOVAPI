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
import com.hp.hponeview.data.network.UplinkSet;

public class LogicalInterconnectGroup {
	public class InterconnectMapEntryTemplate {
		public String logicalDownlinkUri;
		public Location logicalLocation;
		public String permittedInterconnectTypeUri;
	}

	public class InterconnectMapTemplate {
		public InterconnectMapEntryTemplate [] interconnectMapEntryTemplates;
	}
	
	public String status;
	public String category;
	public String name;
	public TelemetryConfiguration telemetryConfiguration;
	public String created;
	public String stackingHealth;
	public String uri;
	public UplinkSet [] uplinkSets;
	public String modified;
	public String state;
	public String eTag;
	public InterconnectMapTemplate interconnectMapTemplate;
	public EthernetInterconnectSettings ethernetSettings;
	public SnmpConfiguration snmpConfiguration;
	public String type;
	public String stackingMode;
	public String description;
}
