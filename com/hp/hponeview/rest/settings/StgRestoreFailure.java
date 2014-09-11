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

import com.hp.hponeview.data.settings.RestoreResult;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgRestoreFailure {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "restores/failure/";
	public static final Integer requiredParms() { return ReqStgRestoreFailure.requiredParms; };
	public static final Integer optionalParms() { return ReqStgRestoreFailure.optionalParms; };
	/**
	 * Implements /rest/restores/failure
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/restores
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.RestoreResult
	 */
	public static class ReqStgRestoreFailure extends HPOneViewRestRequest<ReqStgRestoreFailure> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqStgRestoreFailure( Connection conn ) {
			super( conn, _URI, ReqStgRestoreFailure.class, requiredParms, optionalParms );
		}

		public RestoreResult get() throws Exception { 
			return super.get(RestoreResult.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return RestoreResult.class.
     */
    public static Class<RestoreResult> retType() { return RestoreResult.class; }

    /**
	 * Convert a string containing JSON into an instance of RestoreResult.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.RestoreResult.
	 */
	public static RestoreResult fromJsonString( String json ) {
		return util.fromJsonString( RestoreResult.class, json );
	}

	/**
	 * Returns a new instance of ReqStgRestoreFailure
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgRestoreFailure
	 */
	public static ReqStgRestoreFailure instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgRestoreFailure( conn );
		throw new HPOneViewApiVersionException( StgRestoreFailure.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
