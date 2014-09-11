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

import com.hp.hponeview.data.servers.ConnectionInformationCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvConnectionList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvConnectionList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvConnectionList.optionalParms; };
	public static final String  _URI = "connections/";

	/**
	 * Implements /rest/connections/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/connections
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.ConnectionInformationCollection
	 */
	public static class ReqSrvConnectionList extends HPOneViewRestRequest<ReqSrvConnectionList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqSrvConnectionList( Connection conn ) {
			super( conn, _URI, ReqSrvConnectionList.class, requiredParms, optionalParms );
		}
		
		public ConnectionInformationCollection get() throws Exception { 
			return super.get(ConnectionInformationCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ConnectionInformationCollection.class.
     */
    public static Class<ConnectionInformationCollection> retType() { return ConnectionInformationCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of ConnectionInformationCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ConnectionInformationCollection.
	 */
	public static ConnectionInformationCollection fromJsonString( String json ) {
		return util.fromJsonString( ConnectionInformationCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvConnectionList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvConnectionList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvConnectionList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvConnectionList( conn );
		throw new HPOneViewApiVersionException( SrvConnectionList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
