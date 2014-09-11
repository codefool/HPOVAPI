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

import com.hp.hponeview.data.settings.FwBaseline;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgFirmwareDriverForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "firmware-drivers/%s/";
	public static final Integer requiredParms() { return ReqStgFirmwareDriverForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgFirmwareDriverForId.optionalParms; };
	/**
	 * Implements /rest/firmware-drivers/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/firmware-drivers
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing firmware baseline resource of interest.
	 * @return com.hp.hponeview.data.settings.FwBaseline
	 */
	public static class ReqStgFirmwareDriverForId extends HPOneViewRestRequest<ReqStgFirmwareDriverForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStgFirmwareDriverForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgFirmwareDriverForId.class, requiredParms, optionalParms );
		}

		public FwBaseline get() throws Exception { 
			return super.get(FwBaseline.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return FwBaseline.class.
     */
    public static Class<FwBaseline> retType() { return FwBaseline.class; }

    /**
	 * Convert a string containing JSON into an instance of FwBaseline.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.FwBaseline.
	 */
	public static FwBaseline fromJsonString( String json ) {
		return util.fromJsonString( FwBaseline.class, json );
	}

	/**
	 * Returns a new instance of ReqStgFirmwareDriverForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing firmware driver id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgFirmwareDriverForId
	 */
	public static ReqStgFirmwareDriverForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgFirmwareDriverForId( conn, id );
		throw new HPOneViewApiVersionException( StgFirmwareDriverForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
