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

import com.hp.hponeview.data.servers.ConnectionInstance;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvConnectionForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvConnectionForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvConnectionForId.optionalParms; };
	public static final String  _URI = "connections/%s/";

	/**
	 * Implements /rest/connections/{id}
	 * @author hesterg
	 * @link http:http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/connections
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the connection id of interest.
	 * @return com.hp.hponeview.data.servers.ConnectionInstance
	 */
	public static class ReqSrvConnectionForId extends HPOneViewRestRequest<ReqSrvConnectionForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvConnectionForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvConnectionForId.class, requiredParms, optionalParms );
		}
		
		public ConnectionInstance get() throws Exception { 
			return super.get(ConnectionInstance.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ConnectionInstance.class.
     */
    public static Class<ConnectionInstance> retType() { return ConnectionInstance.class; }

    /**
	 * Convert a string containing JSON into an instance of ConnectionInstance.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ConnectionInstance.
	 */
	public static ConnectionInstance fromJsonString( String json ) {
		return util.fromJsonString( ConnectionInstance.class, json );
	}

	/**
	 * Returns a new instance of ReqConnectionForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the connection id of interest.
	 * @returns com.hp.hponeview.rest.Security.ReqConnectionForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvConnectionForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvConnectionForId( conn, id );
		throw new HPOneViewApiVersionException( SrvConnectionForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
