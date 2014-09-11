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

public class Rack {
	public class RackMount {
		public String  location;	// Centerack | CenterFront | Left | Right	
		public String  mountUri;
		public Integer relativeOrder;
		public Integer TopUSlot;
		public Integer uHeight;
	}
	
	public String  category;
	public String  created;
	public Integer depth;
	public String  eTag;
	public Integer height;
	public String  id;
	public String  model;
	public String  modified;
	public String  name;
	public String  partNumber;
	public RackMount [] rackMounts;
	public String  serialNumber;
	public String  state;	// Adding | AddError | Configured | CredentialError | Refreshing | RefreshError | ...
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public Integer thermalLimit;
	public String  type; 	//'Rack'
	public Integer uHeight;
	public String  uri;
	public String  uuid;
	public Integer width;
}
