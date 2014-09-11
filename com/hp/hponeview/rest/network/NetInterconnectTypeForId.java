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

import com.hp.hponeview.data.network.interconnects.InterconnectTypeV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectTypeForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectTypeForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectTypeForId.optionalParms; };
	public static final String  _URI = "interconnect-types/%s/";

	/**
	 * Implements /rest/interconnect-types/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnect-types.html#d4e97
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect type of interest.
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectTypeV2
	 *
	 */
	public static class ReqNetInterconnectTypeForId extends HPOneViewRestRequest<ReqNetInterconnectTypeForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetInterconnectTypeForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetInterconnectTypeForId.class, requiredParms, optionalParms  );
		}

		public InterconnectTypeV2 get() throws Exception { 
			return super.get(InterconnectTypeV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return InterconnectTypeV2.class.
     */
    public static Class<InterconnectTypeV2> retType() { return InterconnectTypeV2.class; }

    /**
	 * Convert a string containing JSON into an instance of InterconnectTypeV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectTypeV2.
	 */
	public static InterconnectTypeV2 fromJsonString( String json ) {
		return util.fromJsonString( InterconnectTypeV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectTypeForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect type of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectTypeForId
	 */
	public static ReqNetInterconnectTypeForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectTypeForId( conn, id );
		throw new HPOneViewApiVersionException( NetInterconnectTypeForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
