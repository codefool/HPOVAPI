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

public class AvailableNetworksV2 {
	public class NetworkInfoV2 {
		public String  accessType;		// DirectAttach | FabricAttach
		public String  connectionTemplateUri;
		public String [] limitedToPorts;
		public String  name;
		public String  type;	// Ethernet | EthernetSet | FibreChannel
		public String  uri;
		public Integer vlan;
		public String  vlanType;	// Tagged | Untagged | Tunnel | Unknown | NotApplicable
	}
	
	public NetworkInfoV2 [] ethernetNetworks;
	public NetworkInfoV2 [] fcNetworks;
	public NetworkInfoV2 [] networkSets;
}
