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
package com.hp.hponeview.rest.servers;

import com.hp.hponeview.data.servers.SsoUrlData;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureStandbyOaSsoUrlForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureStandbyOaSsoUrlForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureStandbyOaSsoUrlForId.optionalParms; };
	public static final String  _URI = "enclosures/%s/standbyOaSsoUrl/";

	/**
	 * Implements /rest/enclosures/{id}/standbyOaSsoUrl/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosures
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the enclosure id of interest.
	 * @return com.hp.hponeview.data.servers.SsoUrlData
	 */
	public static class ReqSrvEnclosureStandbyOaSsoUrlForId extends HPOneViewRestRequest<ReqSrvEnclosureStandbyOaSsoUrlForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvEnclosureStandbyOaSsoUrlForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvEnclosureStandbyOaSsoUrlForId.class, requiredParms, optionalParms );
		}

		public SsoUrlData get() throws Exception { 
			return super.get(SsoUrlData.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SsoUrlData.class.
     */
    public static Class<SsoUrlData> retType() { return SsoUrlData.class; }

    /**
	 * Convert a string containing JSON into an instance of SsoUrlData.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.SsoUrlData.
	 */
	public static SsoUrlData fromJsonString( String json ) {
		return util.fromJsonString( SsoUrlData.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureStandbyOaSsoUrlForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureStandbyOaSsoUrlForId
	 * @throws HPOneViewApiVersionException 
	 */
	public static ReqSrvEnclosureStandbyOaSsoUrlForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureStandbyOaSsoUrlForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureStandbyOaSsoUrlForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
