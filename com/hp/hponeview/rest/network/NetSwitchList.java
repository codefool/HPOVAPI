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

import com.hp.hponeview.data.network.SwitchCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetSwitchList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetSwitchList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetSwitchList.optionalParms; };
	public static final String  _URI = "switches/";

	/**
	 * Implements /rest/switches/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/switches
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.SwitchCollection
	 *
	 */
	public static class ReqNetSwitchList extends HPOneViewRestRequest<ReqNetSwitchList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetSwitchList( Connection conn ) {
			super( conn, _URI, ReqNetSwitchList.class, requiredParms, optionalParms );
		}

		public SwitchCollection get() throws Exception { 
			return super.get(SwitchCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SwitchCollection.class.
     */
    public static Class<SwitchCollection> retType() { return SwitchCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of SwitchCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.SwitchCollection.
	 */
	public static SwitchCollection fromJsonString( String json ) {
		return util.fromJsonString( SwitchCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqNetSwitchList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetSwitchList
	 */
	public static ReqNetSwitchList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetSwitchList( conn );
		throw new HPOneViewApiVersionException( NetSwitchList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
