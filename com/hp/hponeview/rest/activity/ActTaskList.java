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
*	Implementation of the activity REST calls for HP OneView.
*****************************************************************************/
package com.hp.hponeview.rest.activity;

import com.hp.hponeview.data.activity.TaskResourcePaginatedCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActTaskList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActTaskList.requiredParms; };
	public static final Integer optionalParms() { return ReqActTaskList.optionalParms; };
	public static final String  _URI = "tasks/";

	/**
	 * Implements /rest/tasks
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/tasks.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.activity.TaskResourcePaginatedCollectionV2
	 */
	public static class ReqActTaskList extends HPOneViewRestRequest<ReqActTaskList> {
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PSCTQVFL;
		private ReqActTaskList( Connection conn )	{
			super( conn, _URI, ReqActTaskList.class, requiredParms, optionalParms );
		}
		
		public TaskResourcePaginatedCollectionV2 get() throws Exception { 
			return super.get(TaskResourcePaginatedCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return TaskResourcePaginatedCollectionV2.class.
     */
    public static Class<TaskResourcePaginatedCollectionV2> retType() { return TaskResourcePaginatedCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of TaskResourcePaginatedCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.TaskResourcePaginatedCollectionV2.
	 */
	public static TaskResourcePaginatedCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( TaskResourcePaginatedCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqActTaskList
	 * @param conn Connection object to HP OneView server
	 * @return com.hp.hponeview.rest.activity.ActTaskList.ReqActTaskList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActTaskList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqActTaskList( conn );
		throw new HPOneViewApiVersionException( ActTaskList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
