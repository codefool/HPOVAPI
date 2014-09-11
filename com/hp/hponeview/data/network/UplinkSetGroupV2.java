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


public class UplinkSetGroupV2 {
	public class LogicalPortConfigInfo {
		public String   	   desiredSpeed;	// Auto | Speed0M | Speed100M | Speed10M | ...
		public LogicalLocation logicalLocation;
	}

	public String ethernetNetworkType;	// NotApplicable | Tagged | Tunnel | Unknown | Untagged 
	public String lacpTimer;			// Long | Short
	public LogicalPortConfigInfo [] logicalPortConfigInfos;
	public String mode;					// Auto | Failover
	public String name;
	public String nativeNetworkUri;
	public String networkType;			// Ethernet | FibreChannel
	public String [] networkUris;
	public LogicalLocation primaryPort;
	public String reachability;			// NotReachable | Reachable | RedundantlyReachable | Unknown
	public String type; //'UplinkSetGroupV2'
}
