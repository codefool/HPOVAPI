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

import com.hp.hponeview.data.security.UserNameList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecUserListForRole {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecUserListForRole.requiredParms; };
	public static final Integer optionalParms() { return ReqSecUserListForRole.optionalParms; };
	public static final String  _URI = "users/roles/users/%s/";

	/**
	 * Implements /rest/users/role/users/{role}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/users.html#d4e261
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param role - String containing role name of interest.
	 * @return com.hp.hponeview.data.security.UserNameList
	 *
	 */
	public static class ReqSecUserListForRole extends HPOneViewRestRequest<ReqSecUserListForRole> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecUserListForRole( Connection conn, String role ) {
			super( conn, String.format( _URI, role ), ReqSecUserListForRole.class, requiredParms, optionalParms );
		}

		public UserNameList get() throws Exception { 
			return super.get(UserNameList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UserNameList.class.
     */
    public static Class<UserNameList> retType() { return UserNameList.class; }

    /**
	 * Convert a string containing JSON into an instance of UserNameList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.UserNameList.
	 */
	public static UserNameList fromJsonString( String json ) {
		return util.fromJsonString( UserNameList.class, json );
	}

	/**
	 * Returns a new instance of ReqSecUserListForRole
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param role - String containing the role name of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecUserListForRole
	 */
	public static ReqSecUserListForRole instance( Connection conn, String role )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecUserListForRole( conn, role );
		throw new HPOneViewApiVersionException( SecUserListForRole.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
