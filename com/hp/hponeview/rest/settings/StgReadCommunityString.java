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

import com.hp.hponeview.data.settings.DeviceCommunityStringDto;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgReadCommunityString {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/device-read-community-string/";
	public static final Integer requiredParms() { return ReqStgReadCommunityString.requiredParms; };
	public static final Integer optionalParms() { return ReqStgReadCommunityString.optionalParms; };
	/**
	 * Implements /rest/appliance/device-read-community-string/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/device-read-community-string
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.DeviceCommunityStringDto
	 */
	public static class ReqStgReadCommunityString extends HPOneViewRestRequest<ReqStgReadCommunityString> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgReadCommunityString( Connection conn ) {
			super( conn, _URI, ReqStgReadCommunityString.class, requiredParms, optionalParms );
		}

		public DeviceCommunityStringDto get() throws Exception { 
			return super.get(DeviceCommunityStringDto.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return DeviceCommunityString.class.
     */
    public static Class<DeviceCommunityStringDto> retType() { return DeviceCommunityStringDto.class; }

    /**
	 * Convert a string containing JSON into an instance of DeviceCommunityString.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.DeviceCommunityStringDto.
	 */
	public static DeviceCommunityStringDto fromJsonString( String json ) {
		return util.fromJsonString( DeviceCommunityStringDto.class, json );
	}

	/**
	 * Returns a new instance of ReqStgReadCommunityString
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgReadCommunityString
	 */
	public static ReqStgReadCommunityString instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgReadCommunityString( conn );
		throw new HPOneViewApiVersionException( StgReadCommunityString.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
