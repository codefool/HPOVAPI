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

import com.hp.hponeview.data.activity.EventResourceV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActEventForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActEventForId.requiredParms; };
	public static final Integer optionalParms() { return ReqActEventForId.optionalParms; };
	public static final String  _URI = "events/%s/";

	/**
	 * Implements /rest/events/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/events
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id string containing the URI for the event to retrieve.
	 * @return com.hp.hponeview.data.activity.EventResourceV2
	 */
	public static class ReqActEventForId extends HPOneViewRestRequest<ReqActEventForId>	{
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqActEventForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqActEventForId.class, requiredParms, optionalParms );
		}

		public EventResourceV2 get() throws Exception { 
			return super.get(EventResourceV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EventResourceV2.class.
     */
    public static Class<EventResourceV2> retType() { return EventResourceV2.class; }

    /**
	 * Convert a string containing JSON into an instance of EventResourceV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.EventResourceV2.
	 */
	public static EventResourceV2 fromJsonString( String json ) {
		return util.fromJsonString( EventResourceV2.class, json );
	}

	/**
	 * Returns a new instance of ReqActEventForId
	 * @param conn Connection object to HP OneView server
	 * @param id String containing URI of the event to retrieve.
	 * @return com.hp.hponeview.rest.activity.ActEventForId.ReqActEventForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActEventForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqActEventForId( conn, id );
		throw new HPOneViewApiVersionException( ActEventForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
