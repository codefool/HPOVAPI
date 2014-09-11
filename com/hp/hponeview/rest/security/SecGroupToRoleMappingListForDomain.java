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

import com.hp.hponeview.data.security.Group2RolesMappingList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecGroupToRoleMappingListForDomain {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecGroupToRoleMappingListForDomain.requiredParms; };
	public static final Integer optionalParms() { return ReqSecGroupToRoleMappingListForDomain.optionalParms; };
	public static final String  _URI = "logindomains/grouptorolemapping/%s/";

	/**
	 * Implements /rest/logindomains/grouptorolemapping/{loginDomain}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains-grouptorolemapping.html#d4e192
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param domain - String containing the login domain name of interest.
	 * @return com.hp.hponeview.data.security.Group2RolesMappingList
	 */
	public static class ReqSecGroupToRoleMappingListForDomain extends HPOneViewRestRequest<ReqSecGroupToRoleMappingListForDomain> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecGroupToRoleMappingListForDomain( Connection conn, String domain ) {
			super( conn, String.format( _URI, domain ), ReqSecGroupToRoleMappingListForDomain.class, requiredParms, optionalParms );
		}

		public Group2RolesMappingList get() throws Exception { 
			return super.get(Group2RolesMappingList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Group2RolesMappingList.class.
     */
    public static Class<Group2RolesMappingList> retType() { return Group2RolesMappingList.class; }

    /**
	 * Convert a string containing JSON into an instance of Group2RolesMappingList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.Group2RolesMappingList.
	 */
	public static Group2RolesMappingList fromJsonString( String json ) {
		return util.fromJsonString( Group2RolesMappingList.class, json );
	}

	/**
	 * Returns a new instance of ReqSecGroupToRoleMappingListForDomain
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param domain - String containing the login domain of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecGroupToRoleMappingListForDomain
	 */
	public static ReqSecGroupToRoleMappingListForDomain instance( Connection conn, String domain )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecGroupToRoleMappingListForDomain( conn, domain );
		throw new HPOneViewApiVersionException( SecGroupToRoleMappingListForDomain.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
