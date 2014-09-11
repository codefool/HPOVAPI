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

import com.hp.hponeview.data.settings.ProgressStatus;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class StgStartupProgress {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/progress/";
	public static final Integer requiredParms() { return ReqStgStartupProgress.requiredParms; };
	public static final Integer optionalParms() { return ReqStgStartupProgress.optionalParms; };
	/**
	 * Implements /rest/appliance/progress/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/progress
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.ProgressStatus
	 */
	public static class ReqStgStartupProgress extends HPOneViewRestRequest<ReqStgStartupProgress> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgStartupProgress( Connection conn ) {
			super( conn, _URI, ReqStgStartupProgress.class, requiredParms, optionalParms );
		}

		public ProgressStatus get() throws Exception { 
			return super.get(ProgressStatus.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ProgressStatus.class.
     */
    public static Class<ProgressStatus> retType() { return ProgressStatus.class; }

    /**
	 * Convert a string containing JSON into an instance of ProgressStatus.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.ProgressStatus.
	 */
	public static ProgressStatus fromJsonString( String json ) {
		return util.fromJsonString( ProgressStatus.class, json );
	}

	/**
	 * Returns a new instance of ReqStgStartupProgress
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgStartupProgress
	 */
	public static ReqStgStartupProgress instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgStartupProgress( conn );
		throw new HPOneViewApiVersionException( StgStartupProgress.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
