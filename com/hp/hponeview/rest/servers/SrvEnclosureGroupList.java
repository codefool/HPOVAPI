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

import com.hp.hponeview.data.servers.EnclosureGroupListV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureGroupList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureGroupList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureGroupList.optionalParms; };
	public static final String  _URI = "enclosure-groups/";

	/**
	 * Implements /rest/enclosure-groups/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/enclosure-groups
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.EnclosureGroupListV2
	 */
	public static class ReqSrvEnclosureGroupList extends HPOneViewRestRequest<ReqSrvEnclosureGroupList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSTART | PCOUNT | PSORT | PFILTER;
		private ReqSrvEnclosureGroupList( Connection conn ) {
			super( conn, _URI, ReqSrvEnclosureGroupList.class, requiredParms, optionalParms );
		}

		public EnclosureGroupListV2 get() throws Exception { 
			return super.get(EnclosureGroupListV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnclosureGroupListV2.class.
     */
    public static Class<EnclosureGroupListV2> retType() { return EnclosureGroupListV2.class; }

    /**
	 * Convert a string containing JSON into an instance of EnclosureGroupListV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.EnclosureGroupListV2.
	 */
	public static EnclosureGroupListV2 fromJsonString( String json ) {
		return util.fromJsonString( EnclosureGroupListV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvEnclosureGroupList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id-pool id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvEnclosureGroupList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvEnclosureGroupList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureGroupList( conn );
		throw new HPOneViewApiVersionException( SrvEnclosureGroupList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
