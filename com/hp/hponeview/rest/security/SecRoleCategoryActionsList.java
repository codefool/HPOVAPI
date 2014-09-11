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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecRoleCategoryActionsList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecRoleCategoryActionsList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecRoleCategoryActionsList.optionalParms; };
	public static final String  _URI = "authz/role-category-actions/";

	/**
	 * Implements /rest/authz/role-category-actions/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/authz.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return Map<String,Map<String,List<String>>>
	 */
	public static class ReqSecRoleCategoryActionsList extends HPOneViewRestRequest<ReqSecRoleCategoryActionsList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		// instantiate this monstrosity so that we can get a Class() object to pass to super.get(). Messy, messy.
		private static final Map<String,Map<String,List<String>>> retType = new HashMap<String, Map<String, List<String>>>();
		private ReqSecRoleCategoryActionsList( Connection conn ) {
			super( conn, _URI, ReqSecRoleCategoryActionsList.class, requiredParms, optionalParms );
		}

		@SuppressWarnings("unchecked")
		public Map<String,Map<String,List<String>>> get() throws Exception {
			return super.get(retType.getClass()); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return Map<String,Map<String,List<String>>>.class.
     */
    public static Class<?> retType() { return ReqSecRoleCategoryActionsList.retType.getClass(); }

    /**
	 * Convert a string containing JSON into an instance of Map<String,Map<String,List<String>>>.
	 * @param json - String containing JSON
	 * @return Map<String,Map<String,List<String>>>.
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Map<String,List<String>>> fromJsonString( String json ) {
		return util.fromJsonString(ReqSecRoleCategoryActionsList.retType.getClass(), json);
	}

	/**
	 * Returns a new instance of ReqSecRoleCategoryActionsList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqSecRoleCategoryActionsList
	 */
	public static ReqSecRoleCategoryActionsList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecRoleCategoryActionsList( conn );
		throw new HPOneViewApiVersionException( SecRoleCategoryActionsList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
