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

public class SnmpConfiguration {
	public class TrapDestination {
		public String communityString;			// 'public'
		public String [] enetTrapCategories;	// Other | PortStatus | PortThresholds
		public String [] fcTrapCategories;		// Other | PortStatus
		public String trapDestination;
		public String trapFormat;				// SNMPv1 | SNMPv2
		public String [] trapSeverities;		// Critical | Info | Major | Minor | Normal | Unknown | Warning
		public String [] vcmTrapCategories;		// Legacy
	}
	
	public String  category;
	public String  created;
	public String  description;
	public String  eTag;
	public Boolean enabled;
	public String  modified;
	public String  name;
	public String  readCommunity;	// 'public'
	public String [] snmpAccess;
	public String  state;
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public String  systemContact;
	public TrapDestination [] trapDestinations;
	public String  type;		// 'snmp-configuration'
	public String  uri;
}
