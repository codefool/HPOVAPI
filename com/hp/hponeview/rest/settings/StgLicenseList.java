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
import com.hp.hponeview.data.settings.LicenseList;

public class StgLicenseList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "licenses/";
	public static final Integer requiredParms() { return ReqStgLicenseList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgLicenseList.optionalParms; };
	/**
	 * Implements /rest/licenses/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/licenses
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.LicenseList
	 */
	public static class ReqStgLicenseList extends HPOneViewRestRequest<ReqStgLicenseList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStgLicenseList( Connection conn ) {
			super( conn, _URI, ReqStgLicenseList.class, requiredParms, optionalParms );
		}

		public LicenseList get() throws Exception { 
			return super.get(LicenseList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LicenseList.class.
     */
    public static Class<LicenseList> retType() { return LicenseList.class; }

    /**
	 * Convert a string containing JSON into an instance of LicenseList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.LicenseList.
	 */
	public static LicenseList fromJsonString( String json ) {
		return util.fromJsonString( LicenseList.class, json );
	}

	/**
	 * Returns a new instance of ReqStgLicenseList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgLicenseList
	 */
	public static ReqStgLicenseList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgLicenseList( conn );
		throw new HPOneViewApiVersionException( StgLicenseList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
