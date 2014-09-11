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
package com.hp.hponeview.rest.sans;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.data.sans.SanResponse;

public class SansManagedSanForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSansManagedSanForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSansManagedSanForId.optionalParms; };
	public static final String  _URI = "fc-sans/managed-sans/%s/";

	/**
	 * Implements /rest/fc-sans/managed-sans/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-sans/managed-sans
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the device manager of interest.
	 * @return com.hp.hponeview.data.sans.SanResponse
	 *
	 */
	public static class ReqSansManagedSanForId extends HPOneViewRestRequest<ReqSansManagedSanForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSansManagedSanForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSansManagedSanForId.class, requiredParms, optionalParms  );
		}

		public SanResponse get() throws Exception { 
			return super.get(SanResponse.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SanResponse.class.
     */
    public static Class<SanResponse> retType() { return SanResponse.class; }

    /**
	 * Convert a string containing JSON into an instance of SanResponse.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.sans.SanResponse.
	 */
	public static SanResponse fromJsonString( String json ) {
		return util.fromJsonString( SanResponse.class, json );
	}

	/**
	 * Returns a new instance of ReqSansManagedSanForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the device manager of interest.
	 * @returns com.hp.hponeview.rest.sans.ReqSansManagedSanForId
	 */
	public static ReqSansManagedSanForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqSansManagedSanForId( conn, id );
		throw new HPOneViewApiVersionException( SansManagedSanForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
