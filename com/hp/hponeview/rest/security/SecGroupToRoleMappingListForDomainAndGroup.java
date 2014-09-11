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

import com.hp.hponeview.data.security.Group2RolesMappingPerGroupVersion2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecGroupToRoleMappingListForDomainAndGroup {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecGroupToRoleMappingListForDomainAndGroup.requiredParms; };
	public static final Integer optionalParms() { return ReqSecGroupToRoleMappingListForDomainAndGroup.optionalParms; };
	public static final String  _URI = "logindomains/grouptorolemapping/%s/%s/";

	/**
	 * Implements /rest/logindomains/grouptorolemapping/{loginDomain}/{groupName}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logindomains-grouptorolemapping.html#d4e251
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param domain - String containing the login domain name of interest.
	 * @param group - String containing the group name of interest.
	 * @return com.hp.hponeview.data.security.Group2RolesMappingPerGroupVersion2
	 */
	public static class ReqSecGroupToRoleMappingListForDomainAndGroup extends HPOneViewRestRequest<ReqSecGroupToRoleMappingListForDomainAndGroup> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecGroupToRoleMappingListForDomainAndGroup( Connection conn, String domain, String group ) {
			super( conn, String.format( _URI, domain, group ), ReqSecGroupToRoleMappingListForDomainAndGroup.class, requiredParms, optionalParms );
		}

		public Group2RolesMappingPerGroupVersion2 get() throws Exception { 
			return super.get(Group2RolesMappingPerGroupVersion2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Group2RolesMappingPerGroupVersion2.class.
     */
    public static Class<Group2RolesMappingPerGroupVersion2> retType() { return Group2RolesMappingPerGroupVersion2.class; }

    /**
	 * Convert a string containing JSON into an instance of Group2RolesMappingPerGroupVersion2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.Group2RolesMappingPerGroupVersion2.
	 */
	public static Group2RolesMappingPerGroupVersion2 fromJsonString( String json ) {
		return util.fromJsonString( Group2RolesMappingPerGroupVersion2.class, json );
	}

	/**
	 * Returns a new instance of ReqSecGroupToRoleMappingListForDomainAndGroup
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param domain - String containing the login domain of interest.
	 * @param group - String containing the group of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqSecGroupToRoleMappingListForDomainAndGroup
	 */
	public static ReqSecGroupToRoleMappingListForDomainAndGroup instance( Connection conn, String domain, String group )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecGroupToRoleMappingListForDomainAndGroup( conn, domain, group );
		throw new HPOneViewApiVersionException( SecGroupToRoleMappingListForDomainAndGroup.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
