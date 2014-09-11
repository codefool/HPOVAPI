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

import com.hp.hponeview.data.settings.NetworkLimits;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgFcNetworkLimitsForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "domains/%s/fcNetworkLimits/";
	public static final Integer requiredParms() { return ReqStgFcNetworkLimitsForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgFcNetworkLimitsForId.optionalParms; };
	/**
	 * Implements /rest/domains/{id}/fcNetworkLimits/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/domains.html#d4e138
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.NetworkLimits
	 */
	public static class ReqStgFcNetworkLimitsForId extends HPOneViewRestRequest<ReqStgFcNetworkLimitsForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgFcNetworkLimitsForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgFcNetworkLimitsForId.class, requiredParms, optionalParms );
		}

		public NetworkLimits get() throws Exception { 
			return super.get(NetworkLimits.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NetworkLimits.class.
     */
    public static Class<NetworkLimits> retType() { return NetworkLimits.class; }

    /**
	 * Convert a string containing JSON into an instance of NetworkLimits.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.NetworkLimits.
	 */
	public static NetworkLimits fromJsonString( String json ) {
		return util.fromJsonString( NetworkLimits.class, json );
	}

	/**
	 * Returns a new instance of ReqStgFcNetworkLimitsForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the domain id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgFcNetworkLimitsForId
	 */
	public static ReqStgFcNetworkLimitsForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgFcNetworkLimitsForId( conn, id );
		throw new HPOneViewApiVersionException( StgFcNetworkLimitsForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
