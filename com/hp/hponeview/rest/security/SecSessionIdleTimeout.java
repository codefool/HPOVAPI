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

import com.hp.hponeview.data.security.SessionIdleTimeout;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecSessionIdleTimeout {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecSessionIdleTimeout.requiredParms; };
	public static final Integer optionalParms() { return ReqSecSessionIdleTimeout.optionalParms; };
	public static final String  _URI = "sessions/idle-timeout/";
	
	/**
	 * Implements /rest/sessions/idle-timeout/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/sessions.html#d4e32
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.SessionIdleTimeout
	 */
	public static class ReqSecSessionIdleTimeout extends HPOneViewRestRequest<ReqSecSessionIdleTimeout> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSecSessionIdleTimeout( Connection conn ) {
			super( conn, _URI, ReqSecSessionIdleTimeout.class, requiredParms, optionalParms );
		}

		public SessionIdleTimeout get() throws Exception { 
			return super.get(SessionIdleTimeout.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SessionIdleTimeout.class.
     */
    public static Class<SessionIdleTimeout> retType() { return SessionIdleTimeout.class; }

    /**
	 * Convert a string containing JSON into an instance of SessionIdleTimeout.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.SessionIdleTimeout.
	 */
	public static SessionIdleTimeout fromJsonString( String json ) {
		return util.fromJsonString( SessionIdleTimeout.class, json );
	}

	/**
	 * Returns a new instance of ReqSecSessionIdleTimeout
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecSessionIdleTimeout
	 */
	public static ReqSecSessionIdleTimeout instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecSessionIdleTimeout( conn );
		throw new HPOneViewApiVersionException( SecSessionIdleTimeout.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
