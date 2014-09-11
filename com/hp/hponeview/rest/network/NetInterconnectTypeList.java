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

import com.hp.hponeview.data.network.interconnects.InterconnectTypeCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetInterconnectTypeList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetInterconnectTypeList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetInterconnectTypeList.optionalParms; };
	public static final String  _URI = "interconnect-types/";

	/**
	 * Implements /rest/interconnect-types/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/interconnect-types.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectTypeCollectionV2
	 *
	 */
	public static class ReqNetInterconnectTypeList extends HPOneViewRestRequest<ReqNetInterconnectTypeList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTL;
		private ReqNetInterconnectTypeList( Connection conn ) {
			super( conn, _URI, ReqNetInterconnectTypeList.class, requiredParms, optionalParms  );
		}

		public InterconnectTypeCollectionV2 get() throws Exception { 
			return super.get(InterconnectTypeCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return InterconnectTypeCollection.class.
     */
    public static Class<InterconnectTypeCollectionV2> retType() { return InterconnectTypeCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of InterconnectTypeCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.interconnects.InterconnectTypeCollectionV2.
	 */
	public static InterconnectTypeCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( InterconnectTypeCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetInterconnectTypeList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetInterconnectTypeList
	 */
	public static ReqNetInterconnectTypeList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetInterconnectTypeList( conn );
		throw new HPOneViewApiVersionException( NetInterconnectTypeList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
