/*****************************************************************************
*
* copyright.txt
*
* Copyright 2014 Hewlett-Packard Development Company, L.P.
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
*
*****************************************************************************/
package com.hp.hponeview.data.activity;


/**
 * @author hesterg
 * @link http://xmldocs.fc.hp.com/rest/doc/alerts.html#AlertResourceCollectionV2
 */
public class AlertResourceV2 {
	public class AlertChangeLog	{
		public String  created;
		public String  notes;
		public String  uri;							// HPOV API > 100
		public Boolean userEntered;
		public String  username;
	}
	public String 			  activityUri;
	public String 			  alertState;			// Active | Cleared | Locked
	public String 			  alertTypeID;
	public String 			  assignedToUser;
	public String [] 		  associatedEventUris;
	public AssociatedResource associatedResource;
	public String 			  category;
	public AlertChangeLog []  changeLog;
	public String 			  clearedByUser;
	public String 			  clearedTime;
	public String 			  correctiveAction;
	public String  			  created;
	public String  			  description;
	public String  			  eTag;
	public String  			  healthCategory;
	public Boolean  		  lifeCycle;
	public String  			  modified;
	public String  			  physicalResourceType;
	public String  			  resourceID;
	public String  			  resourceUri;
	public String  			  severity;				// Critical | Disabled | OK | Unknown
	public String  			  type;
	public String  			  urgency;				// Deferrable | High | Immediate | Medium | None | Unknown
	public String  			  uri;
}
