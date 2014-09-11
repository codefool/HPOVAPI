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

public class EnvironmentalAnalysis {
	public class ERMResource {
		public String category;
		public String created;
		public String eTag;
		public String id;
		public String modified;
		public String name;
		public String state;	// Adding | AddError | Configured | CredentialError | ...
		public String status;	// OK | Disabled | Warning | Critical | Unknown
		public String uri;
		public String uuid;
	}
	
	public Integer capacity;
	public ERMResource device;
	public Boolean inferredPosition;
	public Integer max;
	public Integer peakTemp;
	public Number  peakTempTime;
}
