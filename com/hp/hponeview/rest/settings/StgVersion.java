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

import com.hp.hponeview.data.settings.ApiVersion;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgVersion {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "version/";
	public static final Integer requiredParms() { return ReqStgVersion.requiredParms; };
	public static final Integer optionalParms() { return ReqStgVersion.optionalParms; };
	/**
	 * Implements /rest/version/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/appliance.html#d4e32
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.ApiVersion
	 */
	public static class ReqStgVersion extends HPOneViewRestRequest<ReqStgVersion> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgVersion( Connection conn ) {
			super( conn, _URI, ReqStgVersion.class, requiredParms, optionalParms );
		}

		public ApiVersion get() throws Exception { 
			return super.get(ApiVersion.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return ApiVersion.class.
     */
    public static Class<ApiVersion> retType() { return ApiVersion.class; }

    /**
	 * Convert a string containing JSON into an instance of VersionInfo.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.ApiVersion.
	 */
	public static ApiVersion fromJsonString( String json ) {
		return util.fromJsonString( ApiVersion.class, json );
	}

	/**
	 * Returns a new instance of ReqStgVersion
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgVersion
	 */
	public static ReqStgVersion instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgVersion( conn );
		throw new HPOneViewApiVersionException( StgVersion.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
