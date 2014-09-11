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

import java.util.Map;

public class TaskResourceV2 {
	public class TaskError {
		public Map<String,String> data;
		public String details;
		public String errorCode;
		public String errorSource;
		public String message;
		public Object nestedError;
		public String [] recommendedActions;
	}

	public class TaskProgress {
		public Integer id;
		public String  statusUpdate;
		public String  timestamp;
	}
	
	public AssociatedResource associatedResource;
	public String  associatedTaskUri;
	public String  category;
	public Integer completedSteps;
	public Integer computedPercentComplete;
	public String  created;
	public Map<String,Object> data;
	public String  eTag;
	public Integer expectedDuration;
	public Boolean hidden;
	public String  modified;
	public String  name;
	public String  owner;
	public String  parentTaskUri;
	public Integer percentCompleted;
	public TaskProgress [] progressUpdates;
	public String  stateReason;
	public TaskError [] taskErrors;
	public String [] taskOutput;
	public String  taskState;		// Unknown, New, Running, Suspended, Terminated, Killed, Completed, Error, Warning, Interrupted, Starting, Stopping, Pending 
	public String  taskStatus;
	public String  taskType;		// User | Appliance | Background
	public Integer totalSteps;
	public String  type;			// must be set to 'TaskResourceV2'
	public String  uri;
	public Boolean userInitiated;
}
