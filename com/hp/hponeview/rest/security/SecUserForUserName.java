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

import com.hp.hponeview.data.security.UserAndRoles;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecUserForUserName {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecUserForUserName.requiredParms; };
	public static final Integer optionalParms() { return ReqSecUserForUserName.optionalParms; };
	public static final String  _URI = "users/%s/";
	
	/**
	 * Implements /rest/users/{userName}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/users.html#d4e502
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param userName - String containing user name of interest.
	 * @return com.hp.hponeview.data.security.UserAndRoles
	 *
	 */
	public static class ReqSecUserForUserName extends HPOneViewRestRequest<ReqSecUserForUserName> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqSecUserForUserName( Connection conn, String userName ) {
			super( conn, String.format( _URI, userName ), ReqSecUserForUserName.class, requiredParms, optionalParms );
		}

		public UserAndRoles get() throws Exception { 
			return super.get(UserAndRoles.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UserAndRoles.class.
     */
    public static Class<UserAndRoles> retType() { return UserAndRoles.class; }

    /**
	 * Convert a string containing JSON into an instance of UserAndRoles.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.UserAndRoles.
	 */
	public static UserAndRoles fromJsonString( String json ) {
		return util.fromJsonString( UserAndRoles.class, json );
	}

	/**
	 * Returns a new instance of ReqSecUserForUserName
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param userName - String containing the user name of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecUserForUserName
	 */
	public static ReqSecUserForUserName instance( Connection conn, String userName )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecUserForUserName( conn, userName );
		throw new HPOneViewApiVersionException( SecUserForUserName.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
