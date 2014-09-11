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

import com.hp.hponeview.data.network.interconnects.Port;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectPortForIdAndPortId {
	public static final Integer _MINAPIVERSION = 1;
	public static final Integer requiredParms() { return ReqNetInterconnectPortForIdAndPortId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectPortForIdAndPortId.optionalParms; };
	public static final String  _URI = "interconnects/%s/ports/%s/";

	/**
	 * Implements /rest/interconnects/{id}/ports/{portId}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnects.html#d4e234
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @param portId - String containing the URI of the port of interest.
	 * @return com.hp.hponeview.data.network.interconnects.Port
	 *
	 */
	public static class ReqNetInterconnectPortForIdAndPortId extends HPOneViewRestRequest<ReqNetInterconnectPortForIdAndPortId> {
    public static final Integer requiredParms = PNONE;
    public static final Integer optionalParms = PNONE;
		private ReqNetInterconnectPortForIdAndPortId( Connection conn, String id, String portId ) {
			super( conn, String.format( _URI, id, portId ), ReqNetInterconnectPortForIdAndPortId.class, requiredParms, optionalParms  );
		}

		public Port get() throws Exception { 
			return super.get(Port.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Port.class.
     */
    public static Class<Port> retType() { return Port.class; }

    /**
	 * Convert a string containing JSON into an instance of Port.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.interconnects.Port.
	 */
	public static Port fromJsonString( String json ) {
		return util.fromJsonString( Port.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectPortForIdAndPortId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect of interest.
	 * @param portId - String containing the URI of the port of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectPortForIdAndPortId
	 */
	public static ReqNetInterconnectPortForIdAndPortId instance( Connection conn, String id, String portId )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectPortForIdAndPortId( conn, id, portId );
		throw new HPOneViewApiVersionException( NetInterconnectPortForIdAndPortId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
