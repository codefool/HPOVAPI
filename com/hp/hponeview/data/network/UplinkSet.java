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


public class UplinkSet {
	public class PortConfigInfo {
		public String desiredSpeed;
		public Location logicalLocation;
	}
	
	public String [] networkUris;
	public String status;
	public String name;
	public String description;
	public String logicalInterconnectUri;
	public String connectionMode;
	public String nativeNetworkUri;
	public String created;
	public String uri;
	public String manualLoginRedistributionState;
	public String [] fcNetworkUris;
	public String reachability;
	public String state;
	public String eTag;
	public String modified;
	public String networkType;
	public PortConfigInfo [] portConfigInfos;
	public String category;
	public String type; //'uplink-set'
	public Location primaryPortLocation;
}
