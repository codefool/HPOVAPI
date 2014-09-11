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

import com.hp.hponeview.data.settings.VerificationKeyInfo;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgFirmwareVerificationKey {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/firmware/verificationKey/";
	public static final Integer requiredParms() { return ReqStgFirmwareVerificationKey.requiredParms; };
	public static final Integer optionalParms() { return ReqStgFirmwareVerificationKey.optionalParms; };
	/**
	 * Implements /rest/appliance/firmware/verificationKey/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/firmware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.VerificationKeyInfo
	 */
	public static class ReqStgFirmwareVerificationKey extends HPOneViewRestRequest<ReqStgFirmwareVerificationKey> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgFirmwareVerificationKey( Connection conn ) {
			super( conn, _URI, ReqStgFirmwareVerificationKey.class, requiredParms, optionalParms );
		}

		public VerificationKeyInfo get() throws Exception { 
			return super.get(VerificationKeyInfo.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return VerificationKeyInfo.class.
     */
    public static Class<VerificationKeyInfo> retType() { return VerificationKeyInfo.class; }

    /**
	 * Convert a string containing JSON into an instance of VerificationKeyInfo.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.VerificationKeyInfo.
	 */
	public static VerificationKeyInfo fromJsonString( String json ) {
		return util.fromJsonString( VerificationKeyInfo.class, json );
	}

	/**
	 * Returns a new instance of ReqStgFirmwareVerificationKey
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgFirmwareVerificationKey
	 */
	public static ReqStgFirmwareVerificationKey instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgFirmwareVerificationKey( conn );
		throw new HPOneViewApiVersionException( StgFirmwareVerificationKey.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
