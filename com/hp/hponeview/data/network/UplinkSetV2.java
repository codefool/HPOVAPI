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


public class UplinkSetV2 {
	public class PortConfigInfo {
		public String   desiredSpeed;
		public Location location;
		public String   portUri;
	}
	
	public String category;
	public String connectionMode;		// Auto | Failover
	public String created;
	public String description;
	public String eTag;
	public String ethernetNetworkType;	// NotApplicable | Tagged | Tunnel | Unknown | Untagged
	public String [] fcNetworkUris;
	public String lacpTimer;			// Long Short
	public String logicalInterconnectUri;
	public String manualLoginRedistributionState;	// Distributed | Distributing | DistributionFailed | NotSupported | Supported
	public String modified;
	public String name;
	public String nativeNetworkUri;
	public String networkType;			// Ethernet | FibreChannel 
	public String [] networkUris;
	public PortConfigInfo [] portConfigInfos;
	public Location primaryPortLocation;
	public String reachability;			// NotReachable | Reachable | RedundantlyReachable | Unknown
	public String state;
	public String status;				// OK | Disabled | Warning | Critical | Unknown
	public String type; 		//'uplink-setV2'
	public String uri;
}
