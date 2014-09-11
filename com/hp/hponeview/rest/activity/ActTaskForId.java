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

import com.hp.hponeview.data.activity.TaskResourceV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActTaskForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActTaskForId.requiredParms; };
	public static final Integer optionalParms() { return ReqActTaskForId.optionalParms; };
	public static final String  _URI = "tasks/%s/";

	/**
	 * Implements /rest/tasks/{id}. Note that if view is set to "tree", this will return
	 * a TaskTreeV2 object rather than the (expected) TaskResourceV2 and will cause
	 * unexpected results. Use ActTaskTreeForId for this purpose.
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/tasks.html#d4e85
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id string containing the URI of the task to retrieve.
	 * @return com.hp.hponeview.data.activity.TaskResourceV2
	 *
	 */
	public static class ReqActTaskForId extends HPOneViewRestRequest<ReqActTaskForId> {
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PVIEW | PFIELDS ;
		private ReqActTaskForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqActTaskForId.class, requiredParms, optionalParms );
		}

		public TaskResourceV2 get() throws Exception { 
			return super.get(TaskResourceV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return TaskResourceV2.class.
     */
    public static Class<TaskResourceV2> retType() { return TaskResourceV2.class; }

    /**
	 * Convert a string containing JSON into an instance of TaskResourceV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.TaskResourceV2.
	 */
	public static TaskResourceV2 fromJsonString( String json ) {
		return util.fromJsonString( TaskResourceV2.class, json );
	}

	/**
	 * Returns a new instance of ReqActTaskForId
	 * @param conn Connection object to HP OneView server
	 * @param id String containing URI of the task to retrieve.
	 * @return com.hp.hponeview.rest.activity.ActTaskForId.ReqActTaskForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActTaskForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqActTaskForId( conn, id );
		throw new HPOneViewApiVersionException( ActTaskForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
