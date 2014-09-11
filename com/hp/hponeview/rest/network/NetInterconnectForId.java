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

import com.hp.hponeview.data.network.interconnects.InterconnectV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectForId.optionalParms; };
	public static final String  _URI = "interconnects/%s/";

	/**
	 * Implements /rest/interconnects/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e93
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectV2
	 *
	 */
	public static class ReqNetInterconnectForId extends HPOneViewRestRequest<ReqNetInterconnectForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetInterconnectForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetInterconnectForId.class, requiredParms, optionalParms  );
		}

		public InterconnectV2 get() throws Exception { 
			return super.get(InterconnectV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return InterconnectTypeV2.class.
     */
    public static Class<InterconnectV2> retType() { return InterconnectV2.class; }

    /**
	 * Convert a string containing JSON into an instance of InterconnectV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.interconnects.InterconnectV2.
	 */
	public static InterconnectV2 fromJsonString( String json ) {
		return util.fromJsonString( InterconnectV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectForId
	 */
	public static ReqNetInterconnectForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectForId( conn, id );
		throw new HPOneViewApiVersionException( NetInterconnectForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
