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

import com.hp.hponeview.data.servers.Pool;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvIdPoolForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvIdPoolForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvIdPoolForId.optionalParms; };
	public static final String  _URI = "id-pools/%s/";

	/**
	 * Implements /rest/id-pools/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/id-pools
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the pool id of interest.
	 * @return com.hp.hponeview.data.servers.Pool
	 */
	public static class ReqSrvIdPoolForId extends HPOneViewRestRequest<ReqSrvIdPoolForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqSrvIdPoolForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvIdPoolForId.class, requiredParms, optionalParms );
		}
		
		public Pool get() throws Exception { 
			return super.get(Pool.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Pool.class.
     */
    public static Class<Pool> retType() { return Pool.class; }

    /**
	 * Convert a string containing JSON into an instance of Pool.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.Pool.
	 */
	public static Pool fromJsonString( String json ) {
		return util.fromJsonString( Pool.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvIdPoolForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id-pool id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvIdPoolForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvIdPoolForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvIdPoolForId( conn, id );
		throw new HPOneViewApiVersionException( SrvIdPoolForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
