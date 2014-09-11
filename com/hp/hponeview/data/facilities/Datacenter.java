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
package com.hp.hponeview.data.facilities;

public class Datacenter {
	public class PhysicalLocation {
		public String resourceUri;
		public Number rotation;
		public Number x;
		public Number y;
	}
	
	public String  category;
	public PhysicalLocation [] contents;
	public Integer coolingCapacity;
	public Number  coolingMultiplier;
	public Number  costPerKilowattHour;
	public String  created;
	public String  currency;
	public Integer defaultPowerLineVoltage;
	public Integer depth;
	public Number  deratingPercentage;
	public String  deratingType;		// Custom | NaJp | eTag | None
	public String  eTag;
	public String  id;
	public String  modified;
	public String  name;
	public String  state;	// Adding | AddError | Configured | CredentialError | Refreshing | ...
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public String  type; 	//'Datacenter'
	public String  uri;
	public String  uuid;
	public Integer width;
}
