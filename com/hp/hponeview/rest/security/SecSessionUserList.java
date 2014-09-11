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

import com.hp.hponeview.data.security.SessionUserList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecSessionUserList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecSessionUserList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecSessionUserList.optionalParms; };
	public static final String  _URI = "sessions/users/";

	/**
	 * Implements /rest/sessions/users/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/sessions.html#d4e32
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.SessionUserList
	 */
	public static class ReqSecSessionUserList extends HPOneViewRestRequest<ReqSecSessionUserList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecSessionUserList( Connection conn ) {
			super( conn, _URI, ReqSecSessionUserList.class, requiredParms, optionalParms );
		}

		public SessionUserList get() throws Exception { 
			return super.get(SessionUserList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SessionUserList.class.
     */
    public static Class<SessionUserList> retType() { return SessionUserList.class; }

    /**
	 * Convert a string containing JSON into an instance of SessionUserList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.SessionUserList.
	 */
	public static SessionUserList fromJsonString( String json ) {
		return util.fromJsonString( SessionUserList.class, json );
	}

	/**
	 * Returns a new instance of ReqSecSessionUserList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecSessionUserList
	 */
	public static ReqSecSessionUserList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecSessionUserList( conn );
		throw new HPOneViewApiVersionException( SecSessionUserList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
