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

import com.hp.hponeview.data.activity.EventResourceCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActEventList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActEventList.requiredParms; };
	public static final Integer optionalParms() { return ReqActEventList.optionalParms; };
	public static final String  _URI = "events/";

	/**
	 * Implements /rest/events
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/events
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.activity.EventResourceCollectionV2
	 */
	public static class ReqActEventList extends HPOneViewRestRequest<ReqActEventList> {
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PSCTQVFL;
		private ReqActEventList( Connection conn ) {
			super( conn, _URI, ReqActEventList.class, requiredParms, optionalParms );
		}

		public EventResourceCollectionV2 get() throws Exception { 
			return super.get(EventResourceCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EventResourceCollectionV2.class.
     */
    public static Class<EventResourceCollectionV2> retType() { return EventResourceCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of EventResourceCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.EventResourceCollectionV2.
	 */
	public static EventResourceCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( EventResourceCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqActEventList
	 * @param conn Connection object to HP OneView server
	 * @return com.hp.hponeview.rest.activity.ActEventList.ReqActEventList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActEventList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqActEventList( conn );
		throw new HPOneViewApiVersionException( ActEventList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
