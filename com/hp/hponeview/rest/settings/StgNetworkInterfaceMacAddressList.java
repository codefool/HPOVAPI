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
package com.hp.hponeview.rest.settings;

import com.hp.hponeview.data.settings.MacInterfaceCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgNetworkInterfaceMacAddressList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/network-interfaces/mac-addresses/";
	public static final Integer requiredParms() { return ReqStgNetworkInterfaceMacAddressList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgNetworkInterfaceMacAddressList.optionalParms; };
	/**
	 * Implements /rest/appliance/network-interfaces/mac-addresses/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/appliance-network-interfaces.html#d4e100
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.MacInterfaceCollection
	 */
	public static class ReqStgNetworkInterfaceMacAddressList extends HPOneViewRestRequest<ReqStgNetworkInterfaceMacAddressList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgNetworkInterfaceMacAddressList( Connection conn ) {
			super( conn, _URI, ReqStgNetworkInterfaceMacAddressList.class, requiredParms, optionalParms );
		}

		public MacInterfaceCollection get() throws Exception { 
			return super.get(MacInterfaceCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return MacInterfaceCollection.class.
     */
    public static Class<MacInterfaceCollection> retType() { return MacInterfaceCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of MacInterfaceCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.MacInterfaceCollection.
	 */
	public static MacInterfaceCollection fromJsonString( String json ) {
		return util.fromJsonString( MacInterfaceCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqStgNetworkInterfaceMacAddressList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgNetworkInterfaceMacAddressList
	 */
	public static ReqStgNetworkInterfaceMacAddressList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgNetworkInterfaceMacAddressList( conn );
		throw new HPOneViewApiVersionException( StgNetworkInterfaceMacAddressList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
