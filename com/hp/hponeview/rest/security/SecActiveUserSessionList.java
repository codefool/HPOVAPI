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
package com.hp.hponeview.rest.security;

import com.hp.hponeview.data.security.SessionUserListV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecActiveUserSessionList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecActiveUserSessionList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecActiveUserSessionList.optionalParms; };
	public static final String  _URI = "active-user-sessions/";

	/**
	 * Implements /rest/active-user-sessions/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/active-user-sessions.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.SessionUserListV2
	 */
	public static class ReqSecActiveUserSessionList extends HPOneViewRestRequest<ReqSecActiveUserSessionList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCOUNT | PFILTER | PSORT | PSTART;
		private ReqSecActiveUserSessionList( Connection conn ) {
			super( conn, _URI, ReqSecActiveUserSessionList.class, requiredParms, optionalParms );
		}

		public SessionUserListV2 get() throws Exception { 
			return super.get(SessionUserListV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SessionUserListV2.class.
     */
    public static Class<SessionUserListV2> retType() { return SessionUserListV2.class; }

    /**
	 * Convert a string containing JSON into an instance of SessionUserListV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.SessionUserListV2.
	 */
	public static SessionUserListV2 fromJsonString( String json ) {
		return util.fromJsonString( SessionUserListV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSecActiveUserSessionList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecActiveUserSessionList
	 */
	public static ReqSecActiveUserSessionList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecActiveUserSessionList( conn );
		throw new HPOneViewApiVersionException( SecActiveUserSessionList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
