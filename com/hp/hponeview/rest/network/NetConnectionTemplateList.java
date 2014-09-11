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

import com.hp.hponeview.data.network.ConnectionTemplateCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetConnectionTemplateList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetConnectionTemplateList.requiredParms; };
	public static final Integer optionalParms() { return ReqNetConnectionTemplateList.optionalParms; };
	public static final String  _URI = "connection-templates/";

	/**
	 * Implements /rest/connection-templates/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/connection-templates
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.ConnectionTemplateCollection
	 *
	 */
	public static class ReqNetConnectionTemplateList extends HPOneViewRestRequest<ReqNetConnectionTemplateList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqNetConnectionTemplateList( Connection conn ) {
			super( conn, _URI, ReqNetConnectionTemplateList.class, requiredParms, optionalParms );
		}

		public ConnectionTemplateCollection get() throws Exception { 
			return super.get(ConnectionTemplateCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ConnectionTemplateCollection.class.
     */
    public static Class<ConnectionTemplateCollection> retType() { return ConnectionTemplateCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of ConnectionTemplateCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.ConnectionTemplateCollection.
	 */
	public static ConnectionTemplateCollection fromJsonString( String json ) {
		return util.fromJsonString( ConnectionTemplateCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqNetConnectionTemplateList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetConnectionTemplateList
	 */
	public static ReqNetConnectionTemplateList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetConnectionTemplateList( conn );
		throw new HPOneViewApiVersionException( NetConnectionTemplateList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
