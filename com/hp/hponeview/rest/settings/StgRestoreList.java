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
package com.hp.hponeview.rest.settings;

import com.hp.hponeview.data.settings.RestoreList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgRestoreList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "restores/";
	public static final Integer requiredParms() { return ReqStgRestoreList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgRestoreList.optionalParms; };
	/**
	 * Implements /rest/restores/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/restores
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.RestoreResourceList
	 */
	public static class ReqStgRestoreList extends HPOneViewRestRequest<ReqStgRestoreList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgRestoreList( Connection conn ) {
			super( conn, _URI, ReqStgRestoreList.class, requiredParms, optionalParms );
		}

		public RestoreList get() throws Exception { 
			return super.get(RestoreList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return RestoreResourceList.class.
     */
    public static Class<RestoreList> retType() { return RestoreList.class; }

    /**
	 * Convert a string containing JSON into an instance of RestoreResourceList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.RestoreResourceList.
	 */
	public static RestoreList fromJsonString( String json ) {
		return util.fromJsonString( RestoreList.class, json );
	}

	/**
	 * Returns a new instance of ReqStgRestoreList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgRestoreList
	 */
	public static ReqStgRestoreList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgRestoreList( conn );
		throw new HPOneViewApiVersionException( StgRestoreList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
