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

import com.hp.hponeview.data.security.CategoryActionList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SecCategoryActionsList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSecCategoryActionsList.requiredParms; };
	public static final Integer optionalParms() { return ReqSecCategoryActionsList.optionalParms; };
	public static final String  _URI = "authz/category-actions/";

	/**
	 * Implements /rest/authz/category-actions/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/authz.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.security.CategoryActionBaseList
	 */
	public static class ReqSecCategoryActionsList extends HPOneViewRestRequest<ReqSecCategoryActionsList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSecCategoryActionsList( Connection conn ) {
			super( conn, _URI, ReqSecCategoryActionsList.class, requiredParms, optionalParms );
		}

		public CategoryActionList get() throws Exception { 
			return super.get(CategoryActionList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return CategoryActionBaseList.class.
     */
    public static Class<CategoryActionList> retType() { return CategoryActionList.class; }

    /**
	 * Convert a string containing JSON into an instance of CategoryActionBaseList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.security.CategoryActionBaseList.
	 */
	public static CategoryActionList fromJsonString( String json ) {
		return util.fromJsonString( CategoryActionList.class, json );
	}

	/**
	 * Returns a new instance of ReqCategoryActions
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Security.ReqCategoryActions
	 */
	public static ReqSecCategoryActionsList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSecCategoryActionsList( conn );
		throw new HPOneViewApiVersionException( SecCategoryActionsList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
