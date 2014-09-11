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

import com.hp.hponeview.data.activity.AlertResourceV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActAlertForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActAlertForId.requiredParms; }
	public static final Integer optionalParms() { return ReqActAlertForId.optionalParms; }
	public static final String  _URI = "alerts/%s/";

	/**
	 * Implements /rest/alerts/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/alerts.html#d4e170
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id string containing the URI of the alert.
	 * @return com.hp.hponeview.data.activity.AlertResourceV2.
	 */
	public static class ReqActAlertForId extends HPOneViewRestRequest<ReqActAlertForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqActAlertForId(Connection conn, String id) {
			super( conn, String.format( _URI, id ), ReqActAlertForId.class, requiredParms, optionalParms );
		}
		
		public AlertResourceV2 get() throws Exception { 
			return super.get(AlertResourceV2.class); 
		}
	}
	
    /**
     * Return the Class object for the return type for this REST call.
     * @return AlertResourceV2.class.
     */
    public static Class<AlertResourceV2> retType() { return AlertResourceV2.class; }

    /**
	 * Convert a string containing JSON into an instance of AlertResourceV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.AlertResourceV2.
	 */
	public static AlertResourceV2 fromJsonString( String json ) {
		return util.fromJsonString(AlertResourceV2.class, json);
	}

	/**
	 * Returns a new instance of an ReqActAlertForId
	 * @param conn Connection object to HP OneView server
	 * @param id String containing the URI of the alert to retrieve.
	 * @return com.hp.hponeview.rest.activity.ActAlertForId.ReqActAlertForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActAlertForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqActAlertForId( conn, id );
		throw new HPOneViewApiVersionException( ActAlertForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
