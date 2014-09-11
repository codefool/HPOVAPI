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

import com.hp.hponeview.data.security.Session;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecUserSessionList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecUserSession.requiredParms; };
	public static final Integer optionalParms() { return ReqSecUserSession.optionalParms; };
	public static final String  _URI = "sessions/";
	
	/**
	 * Implements /rest/sessions/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/sessions.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.Session
	 */
	public static class ReqSecUserSession extends HPOneViewRestRequest<ReqSecUserSession> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecUserSession( Connection conn ) {
			super( conn, _URI, ReqSecUserSession.class, requiredParms, optionalParms );
		}

		public Session get() throws Exception { 
			return super.get(Session.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return Session.class.
     */
    public static Class<Session> retType() { return Session.class; }

    /**
	 * Convert a string containing JSON into an instance of Session.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.Session.
	 */
	public static Session fromJsonString( String json ) {
		return util.fromJsonString( Session.class, json );
	}

	/**
	 * Returns a new instance of ReqSecUserSession
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecUserSession
	 */
	public static ReqSecUserSession instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecUserSession( conn );
		throw new HPOneViewApiVersionException( SecUserSessionList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
