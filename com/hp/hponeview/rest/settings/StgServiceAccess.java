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

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgServiceAccess {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/settings/serviceaccess/";
	public static final Integer requiredParms() { return ReqStgServiceAccess.requiredParms; };
	public static final Integer optionalParms() { return ReqStgServiceAccess.optionalParms; };
	/**
	 * Implements /rest/appliance/settings/serviceaccess/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/settings
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return Boolean
	 */
	public static class ReqStgServiceAccess extends HPOneViewRestRequest<ReqStgServiceAccess> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgServiceAccess( Connection conn ) {
			super( conn, _URI, ReqStgServiceAccess.class, requiredParms, optionalParms );
		}

		public Boolean get() throws Exception { 
			return super.get( Boolean.class );
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Object.class.
     */
    public static Class<Boolean> retType() { return Boolean.class; }

    /**
	 * Convert a boolean in JSON format to an instance of Boolean.
	 * @param json - String containing JSON.
	 * @return Boolean
	 */
	public static Boolean fromJsonString( String json ) {
		return util.fromJsonString( Boolean.class, json );
	}

	/**
	 * Returns a new instance of ReqStgServiceAccess
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgServiceAccess
	 */
	public static ReqStgServiceAccess instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgServiceAccess( conn );
		throw new HPOneViewApiVersionException( StgServiceAccess.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
