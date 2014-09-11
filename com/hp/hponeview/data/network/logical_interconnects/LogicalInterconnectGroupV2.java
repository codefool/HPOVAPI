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

import com.hp.hponeview.data.network.LogicalLocation;
import com.hp.hponeview.data.network.SnmpConfiguration;
import com.hp.hponeview.data.network.UplinkSetGroupV2;

public class LogicalInterconnectGroupV2 {
	public class InterconnectMapEntryTemplate {
		public String   	   logicalDownlinkUri;
		public LogicalLocation logicalLocation;
		public String   	   permittedInterconnectTypeUri;
	}

	public class InterconnectMapTemplate {
		public InterconnectMapEntryTemplate [] interconnectMapEntryTemplates;
	}
	
	public String category;
	public String created;
	public String description;
	public String eTag;
	public EthernetInterconnectSettingsV2 ethernetSettings;
	public InterconnectMapTemplate interconnectMapTemplate;
	public String modified;
	public String name;
	public SnmpConfiguration snmpConfiguration;
	public String stackingHealth;	// BiConnected | Connected | Disconnected | Unknown
	public String stackingMode;		// Enclosure | MultiEnclosure | None | SwitchPairs
	public String state;
	public String status;			// OK | Disabled | Warning | Critical | Unknown
	public TelemetryConfiguration telemetryConfiguration;
	public String type;				//'logical-interconnect-groupV2'
	public UplinkSetGroupV2 [] uplinkSets;
	public String uri;
}
