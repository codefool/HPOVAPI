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

import com.hp.hponeview.data.security.RoleNameV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecRoleForRoleName {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecRoleForRoleName.requiredParms; };
	public static final Integer optionalParms() { return ReqSecRoleForRoleName.optionalParms; };
	public static final String  _URI = "roles/%s/";
	
	/**
	 * Implements /rest/roles/{roleName}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/roles.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param roleName - String containing role name of interest.
	 * @return com.hp.hponeview.data.security.RoleNameV2
	 */
	public static class ReqSecRoleForRoleName extends HPOneViewRestRequest<ReqSecRoleForRoleName> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqSecRoleForRoleName( Connection conn, String roleName ) {
			super( conn, String.format( _URI, roleName ), ReqSecRoleForRoleName.class, requiredParms, optionalParms| PFIELDS );
		}

		public RoleNameV2 get() throws Exception { 
			return super.get(RoleNameV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return RoleNameV2.class.
     */
    public static Class<RoleNameV2> retType() { return RoleNameV2.class; }

    /**
	 * Convert a string containing JSON into an instance of RoleNameV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.RoleNameV2.
	 */
	public static RoleNameV2 fromJsonString( String json ) {
		return util.fromJsonString( RoleNameV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSecRoleForRoleName
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param roleName - String containing the role name of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecRoleForRoleName
	 */
	public static ReqSecRoleForRoleName instance( Connection conn, String roleName )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecRoleForRoleName( conn, roleName );
		throw new HPOneViewApiVersionException( SecRoleForRoleName.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
