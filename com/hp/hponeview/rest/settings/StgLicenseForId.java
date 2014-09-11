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

import com.hp.hponeview.data.settings.License;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgLicenseForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "licenses/%s/";
	public static final Integer requiredParms() { return ReqStgLicenseForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgLicenseForId.optionalParms; };
	/**
	 * Implements /rest/licenses/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/licenses
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing license id of interest.
	 * @return com.hp.hponeview.data.settings.License
	 */
	public static class ReqStgLicenseForId extends HPOneViewRestRequest<ReqStgLicenseForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStgLicenseForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgLicenseForId.class, requiredParms, optionalParms );
		}

		public License get() throws Exception { 
			return super.get(License.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return License.class.
     */
    public static Class<License> retType() { return License.class; }

    /**
	 * Convert a string containing JSON into an instance of License.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.License.
	 */
	public static License fromJsonString( String json ) {
		return util.fromJsonString( License.class, json );
	}

	/**
	 * Returns a new instance of ReqStgLicenseForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the license id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgLicenseForId
	 */
	public static ReqStgLicenseForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgLicenseForId( conn, id );
		throw new HPOneViewApiVersionException( StgLicenseForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
