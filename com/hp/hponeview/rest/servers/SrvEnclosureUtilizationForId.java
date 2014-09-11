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

import com.hp.hponeview.data.facilities.UtilizationData;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureUtilizationForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureUtilizationForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureUtilizationForId.optionalParms; };
	public static final String  _URI = "enclosures/%s/utilization/";
	
	/**
	 * Implements /rest/enclosures/{id}/utilization/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosures
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the enclosure id of interest.
	 * @return com.hp.hponeview.data.facilities.UtilizationData
	 */
	public static class ReqSrvEnclosureUtilizationForId extends HPOneViewRestRequest<ReqSrvEnclosureUtilizationForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PREFRESH | PVIEW | PFIELDS | PFILTER;
		private ReqSrvEnclosureUtilizationForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvEnclosureUtilizationForId.class, requiredParms, optionalParms );
		}

		public UtilizationData get() throws Exception { 
			return super.get(UtilizationData.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return UtilizationData.class.
     */
    public static Class<UtilizationData> retType() { return UtilizationData.class; }

    /**
	 * Convert a string containing JSON into an instance of UtilizationData.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.UtilizationData.
	 */
	public static UtilizationData fromJsonString( String json ) {
		return util.fromJsonString( UtilizationData.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureUtilizationForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureUtilizationForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvEnclosureUtilizationForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureUtilizationForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureUtilizationForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
