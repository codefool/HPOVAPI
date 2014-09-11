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

import com.hp.hponeview.data.security.RoleNameListV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecRoleListForUser {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecRoleListForUser.requiredParms; };
	public static final Integer optionalParms() { return ReqSecRoleListForUser.optionalParms; };
	public static final String  _URI = "users/role/%s/";
	/**
	 * Implements /rest/users/role/{userName}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/users.html#d4e261
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param userName - String containing user name of interest.
	 * @return com.hp.hponeview.data.security.RoleNameListV2
	 *
	 */
	public static class ReqSecRoleListForUser extends HPOneViewRestRequest<ReqSecRoleListForUser> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecRoleListForUser( Connection conn, String userName ) {
			super( conn, String.format( _URI, userName ), ReqSecRoleListForUser.class, requiredParms, optionalParms );
		}

		public RoleNameListV2 get() throws Exception { 
			return super.get(RoleNameListV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return RoleNameListV2.class.
     */
    public static Class<RoleNameListV2> retType() { return RoleNameListV2.class; }

    /**
	 * Convert a string containing JSON into an instance of RoleNameListV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.RoleNameListV2.
	 */
	public static RoleNameListV2 fromJsonString( String json ) {
		return util.fromJsonString( RoleNameListV2.class, json );
	}

	/**
	 * Returns a new instance of ReqReqSecRoleListForUser
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param userName - String containing the user name of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqReqSecRoleListForUser
	 */
	public static ReqSecRoleListForUser instance( Connection conn, String userName )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecRoleListForUser( conn, userName );
		throw new HPOneViewApiVersionException( SecRoleListForUser.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
