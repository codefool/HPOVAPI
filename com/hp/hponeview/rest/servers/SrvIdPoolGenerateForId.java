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

import com.hp.hponeview.data.servers.Fragment;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvIdPoolGenerateForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvIdPoolGenerateForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvIdPoolGenerateForId.optionalParms; };
	public static final String  _URI = "id-pools/%s/generate/";

	/**
	 * Implements /rest/id-pools/{id}/generate/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/id-pools
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the pool id of interest.
	 * @return com.hp.hponeview.data.servers.Fragment
	 */
	public static class ReqSrvIdPoolGenerateForId extends HPOneViewRestRequest<ReqSrvIdPoolGenerateForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvIdPoolGenerateForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvIdPoolGenerateForId.class, requiredParms, optionalParms );
		}
		
		public Fragment get() throws Exception { 
			return super.get(Fragment.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Fragment.class.
     */
    public static Class<Fragment> retType() { return Fragment.class; }

    /**
	 * Convert a string containing JSON into an instance of Fragment.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.Fragment.
	 */
	public static Fragment fromJsonString( String json ) {
		return util.fromJsonString( Fragment.class, json );
	}

	/**
	 * Returns a new instance of ReqIdPoolGenerateForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id-pool id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqIdPoolGenerateForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvIdPoolGenerateForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvIdPoolGenerateForId( conn, id );
		throw new HPOneViewApiVersionException( SrvIdPoolGenerateForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
