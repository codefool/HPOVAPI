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
package com.hp.hponeview.rest.network;

import com.hp.hponeview.data.network.Switch;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetSwitchForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetSwitchForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetSwitchForId.optionalParms; };
	public static final String  _URI = "switches/%s/";

	/**
	 * Implements /rest/switches/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/uplink-sets.html#d4e131
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the switch of interest.
	 * @return com.hp.hponeview.data.network.Switch
	 *
	 */
	public static class ReqNetSwitchForId extends HPOneViewRestRequest<ReqNetSwitchForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetSwitchForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetSwitchForId.class, requiredParms, optionalParms  );
		}

		public Switch get() throws Exception { 
			return super.get(Switch.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Switch.class.
     */
    public static Class<Switch> retType() { return Switch.class; }

    /**
	 * Convert a string containing JSON into an instance of Switch.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.Switch.
	 */
	public static Switch fromJsonString( String json ) {
		return util.fromJsonString( Switch.class, json );
	}

	/**
	 * Returns a new instance of ReqNetSwitchForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the switch of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetSwitchForId
	 */
	public static ReqNetSwitchForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetSwitchForId( conn, id );
		throw new HPOneViewApiVersionException( NetSwitchForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
