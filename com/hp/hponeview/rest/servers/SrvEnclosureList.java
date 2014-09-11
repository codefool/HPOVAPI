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

import com.hp.hponeview.data.servers.EnclosureListV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureList.optionalParms; };
	public static final String  _URI = "enclosures/";

	/**
	 * Implements /rest/enclosures/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosures
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.EnclosureListV2
	 */
	public static class ReqSrvEnclosureList extends HPOneViewRestRequest<ReqSrvEnclosureList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSTART | PCOUNT | PSORT | PFILTER;
		private ReqSrvEnclosureList( Connection conn ) {
			super( conn, _URI, ReqSrvEnclosureList.class, requiredParms, optionalParms );
		}

		public EnclosureListV2 get() throws Exception { 
			return super.get(EnclosureListV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnclosureListV2.class.
     */
    public static Class<EnclosureListV2> retType() { return EnclosureListV2.class; }

    /**
	 * Convert a string containing JSON into an instance of EnclosureList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.EnclosureList.
	 */
	public static EnclosureListV2 fromJsonString( String json ) {
		return util.fromJsonString( EnclosureListV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureList
	 * @throws HPOneViewApiVersionException 
	 */
	public static ReqSrvEnclosureList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureList( conn );
		throw new HPOneViewApiVersionException( SrvEnclosureList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
