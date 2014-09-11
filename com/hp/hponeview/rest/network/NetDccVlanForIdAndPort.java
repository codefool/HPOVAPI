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

import com.hp.hponeview.data.network.DCCVlanInformation;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetDccVlanForIdAndPort {
	public static final Integer _MINAPIVERSION = 100;
	public static final Integer requiredParms() { return ReqNetDccVlanForIdAndPort.requiredParms; };
	public static final Integer optionalParms() { return ReqNetDccVlanForIdAndPort.optionalParms; };
	public static final String  _URI = "modules/DCCVlan/%s/%s/";

	/**
	 * Implements /rest/modules/DCCVlan/{switchId}/{switchPort}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/network-sets.html#d4e206
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param switchId - String containing the id of the switch of interest.
	 * @param switchPort - Integer specifying the id port of the switch port of interest.
	 * @return com.hp.hponeview.data.network.DCCVlanInformation
	 *
	 */
	public static class ReqNetDccVlanForIdAndPort extends HPOneViewRestRequest<ReqNetDccVlanForIdAndPort> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetDccVlanForIdAndPort( Connection conn, String switchId, Integer switchPort ) {
			super( conn, String.format( _URI, switchId, switchPort ), ReqNetDccVlanForIdAndPort.class, requiredParms, optionalParms  );
		}

		public DCCVlanInformation get() throws Exception { 
			return super.get(DCCVlanInformation.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return DCCVlanInformation.class.
     */
    public static Class<DCCVlanInformation> retType() { return DCCVlanInformation.class; }

    /**
	 * Convert a string containing JSON into an instance of DCCVlanInformation.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.DCCVlanInformation.
	 */
	public static DCCVlanInformation fromJsonString( String json ) {
		return util.fromJsonString( DCCVlanInformation.class, json );
	}

	/**
	 * Returns a new instance of ReqNetDccVlanForIdAndPort
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param switchId - String containing the id of the switch of interest.
	 * @param switchPort - Integer specifying the id port of the switch port of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetDccVlanForIdAndPort
	 */
	public static ReqNetDccVlanForIdAndPort instance( Connection conn, String switchId, Integer switchPort )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetDccVlanForIdAndPort( conn, switchId, switchPort );
		throw new HPOneViewApiVersionException( NetDccVlanForIdAndPort.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
