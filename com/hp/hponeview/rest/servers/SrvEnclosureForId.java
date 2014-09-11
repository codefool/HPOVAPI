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

import com.hp.hponeview.data.servers.EnclosureV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureForId.optionalParms; };
	public static final String  _URI = "enclosures/%s/";

	/**
	 * Implements /rest/enclosures/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosures
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the enclosure id of interest.
	 * @return com.hp.hponeview.data.servers.EnclosureV2
	 */
	public static class ReqSrvEnclosureForId extends HPOneViewRestRequest<ReqSrvEnclosureForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvEnclosureForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvEnclosureForId.class, requiredParms, optionalParms );
		}

		public EnclosureV2 get() throws Exception { 
			return super.get(EnclosureV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnclosureV2.class.
     */
    public static Class<EnclosureV2> retType() { return EnclosureV2.class; }

    /**
	 * Convert a string containing JSON into an instance of Enclosure.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.EnclosureV2.
	 */
	public static EnclosureV2 fromJsonString( String json ) {
		return util.fromJsonString( EnclosureV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureForId
	 */
	public static ReqSrvEnclosureForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
