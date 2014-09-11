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

public class EthernetInterconnectSettingsV2 {
	public String  category;
	public String  created;
	public String  dependentResourceUri;
	public String  description;
	public Boolean enableFastMacCacheFailover;
	public Boolean enableIgmpSnooping;
	public Boolean enableNetworkLoopProtection;
	public Boolean enablePauseFloodProtection;
	public String  eTag;
	public String  id;
	public Integer igmpIdleTimeoutInterval;
	public String  interconnectType;	// Ethernet | FibreChannel
	public Integer macRefreshInterval;
	public String  modified;
	public String  name;
	public String  state;
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public String  type;		// 'EthernetInterconnectSettingsV2'
	public String  uri;
}
