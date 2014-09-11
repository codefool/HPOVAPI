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

import com.hp.hponeview.data.network.interconnects.PortCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectPortListForId {
	public static final Integer _MINAPIVERSION = 1;
	public static final Integer requiredParms() { return ReqNetInterconnectPortListForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectPortListForId.optionalParms; };
	public static final String  _URI = "interconnects/%s/ports/";

	/**
	 * Implements /rest/interconnects/{id}/ports/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e169
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @return com.hp.hponeview.data.network.interconnects.PortCollection
	 *
	 */
	public static class ReqNetInterconnectPortListForId extends HPOneViewRestRequest<ReqNetInterconnectPortListForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSTART | PCOUNT;
		private ReqNetInterconnectPortListForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetInterconnectPortListForId.class, requiredParms, optionalParms );
		}

		public PortCollection get() throws Exception { 
			return super.get(PortCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return PortCollection.class.
     */
    public static Class<PortCollection> retType() { return PortCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of PortCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.interconnects.PortCollection.
	 */
	public static PortCollection fromJsonString( String json ) {
		return util.fromJsonString( PortCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectPortListForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectPortListForId
	 */
	public static ReqNetInterconnectPortListForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectPortListForId( conn, id );
		throw new HPOneViewApiVersionException( NetInterconnectPortListForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
