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

import com.hp.hponeview.data.network.SnmpConfiguration;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectSnmpConfigForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectSnmpConfigForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectSnmpConfigForId.optionalParms; };
	public static final String  _URI = "logical-interconnects/%s/snmp-configuration/";

	/**
	 * Implements /rest/logical-interconnects/{id}/snmp-configuration/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnects.html#d4e375
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @return com.hp.hponeview.data.network.SnmpConfiguration
	 *
	 */
	public static class ReqNetLogicalInterconnectSnmpConfigForId extends HPOneViewRestRequest<ReqNetLogicalInterconnectSnmpConfigForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqNetLogicalInterconnectSnmpConfigForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetLogicalInterconnectSnmpConfigForId.class, requiredParms, optionalParms );
		}

		public SnmpConfiguration get() throws Exception { 
			return super.get(SnmpConfiguration.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SnmpConfiguration.class.
     */
    public static Class<SnmpConfiguration> retType() { return SnmpConfiguration.class; }

    /**
	 * Convert a string containing JSON into an instance of SnmpConfiguration.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.SnmpConfiguration.
	 */
	public static SnmpConfiguration fromJsonString( String json ) {
		return util.fromJsonString( SnmpConfiguration.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectSnmpConfigForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the logical interconnect of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetLogicalInterconnectSnmpConfigForId
	 */
	public static ReqNetLogicalInterconnectSnmpConfigForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectSnmpConfigForId( conn, id );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectSnmpConfigForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
