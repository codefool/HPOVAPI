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

import com.hp.hponeview.data.security.UserAndRolesList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecUserList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecUserList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecUserList.optionalParms; };
	public static final String  _URI = "users/";

	/**
	 * Implements /rest/users/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/users.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.UserAndRolesList
	 *
	 */
	public static class ReqSecUserList extends HPOneViewRestRequest<ReqSecUserList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecUserList( Connection conn ) {
			super( conn, _URI, ReqSecUserList.class, requiredParms, optionalParms );
		}

		public UserAndRolesList get() throws Exception { 
			return super.get(UserAndRolesList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UserAndRolesList.class.
     */
    public static Class<UserAndRolesList> retType() { return UserAndRolesList.class; }

    /**
	 * Convert a string containing JSON into an instance of UserAndRolesList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.UserAndRolesList.
	 */
	public static UserAndRolesList fromJsonString( String json ) {
		return util.fromJsonString( UserAndRolesList.class, json );
	}

	/**
	 * Returns a new instance of ReqSecUserList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecUserList
	 */
	public static ReqSecUserList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecUserList( conn );
		throw new HPOneViewApiVersionException( SecUserList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
