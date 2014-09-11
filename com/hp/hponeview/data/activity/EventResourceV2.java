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
package com.hp.hponeview.data.activity;

public class EventResourceV2 {
	public class EventDetail {
		public String  eventItemDescription;
		public String  eventItemName;
		public String  eventItemSnmpOid;
		public String  eventItemValue;
		public Boolean isThisVarbindData;
		public Integer varBindOrderIndex;
	}
	
	public String  category;
	public String  created;
	public String  description;
	public String  eTag;
	public EventDetail [] eventDetails;
	public String  eventTypeID;
	public String  healthCategory;
	public String  modified;
	public Boolean processed;
	public String  rxTime;
	public String  severity;	// Deferrable | High | Immediate | None | Unknown
	public String  type; 		// 'EventResourceV2'
	public String  urgency;
	public String  uri;
}
