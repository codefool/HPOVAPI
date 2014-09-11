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

import com.hp.hponeview.data.activity.TaskTreeV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActTaskTreeForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActTaskTreeForId.requiredParms; };
	public static final Integer optionalParms() { return ReqActTaskTreeForId.optionalParms; };
	public static final String  _URI = "tasks/%s/";

	/**
	 * Implements /rest/tasks/{id} with view set to "tree" to return a TaskTreeV2
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/tasks.html#d4e85
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id string containing the URI of the task to retrieve.
	 * @return com.hp.hponeview.data.activity.TaskTreeV2
	 *
	 */
	public static class ReqActTaskTreeForId extends HPOneViewRestRequest<ReqActTaskTreeForId> {
	    public static final Integer requiredParms = PVIEW;
	    public static final Integer optionalParms = PNONE;
		private ReqActTaskTreeForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqActTaskTreeForId.class, requiredParms, optionalParms );
			try { setView( "tree" ); } catch( Exception e ) {}
		}

		public TaskTreeV2 get() throws Exception { 
			return super.get(TaskTreeV2.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return TaskTreeV2.class.
     */
    public static Class<TaskTreeV2> retType() { return TaskTreeV2.class; }

    /**
	 * Convert a string containing JSON into an instance of TaskTreeV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.TaskTreeV2.
	 */
	public static TaskTreeV2 fromJsonString( String json ) {
		return util.fromJsonString( TaskTreeV2.class, json );
	}

	/**
	 * Returns a new instance of ReqActTaskTreeForId
	 * @param conn Connection object to HP OneView server
	 * @param id String containing URI of the task to retrieve.
	 * @return com.hp.hponeview.rest.activity.ActTaskForId.ReqActTaskTreeForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActTaskTreeForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqActTaskTreeForId( conn, id );
		throw new HPOneViewApiVersionException( ActTaskTreeForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
