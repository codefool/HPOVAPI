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

public class LogicalDownlink {
	public String  category;
	public String  created;
	public String  description;
	public String [] downlinkCapabilities;
	public String  eTag;
	public Integer maxNetworks;
	public String  maxSpeed;
	public Integer minNetworks;
	public String  modified;
	public String  name;
	public String [] networkUris;
	public String [] permittedSpeedRange;	// Auto | Speed0M | Speed100M | Speed10G | Speed10M | ...
	public String  state;
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public String  type;		// 'logical-downlink'
	public String  uri;
}
