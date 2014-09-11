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

import com.hp.hponeview.data.servers.EnclosureGroupV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureGroupForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureGroupForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureGroupForId.optionalParms; };
	public static final String  _URI = "enclosure-groups/%s/";

	/**
	 * Implements /rest/enclosure-groups/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosure-groups
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the enclosure group id of interest.
	 * @return com.hp.hponeview.data.servers.EnclosureGroupV2
	 */
	public static class ReqSrvEnclosureGroupForId extends HPOneViewRestRequest<ReqSrvEnclosureGroupForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvEnclosureGroupForId( Connection conn, String id ) {
			super( conn, String.format( _URI,  id ), ReqSrvEnclosureGroupForId.class, requiredParms, optionalParms );
		}

		public EnclosureGroupV2 get() throws Exception { 
			return super.get(EnclosureGroupV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnclosureGroupV2.class.
     */
    public static Class<EnclosureGroupV2> retType() { return EnclosureGroupV2.class; }

    /**
	 * Convert a string containing JSON into an instance of EnclosureGroupV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.EnclosureGroupV2.
	 */
	public static EnclosureGroupV2 fromJsonString( String json ) {
		return util.fromJsonString( EnclosureGroupV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureGroupForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id-pool id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureGroupForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvEnclosureGroupForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureGroupForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureGroupForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
