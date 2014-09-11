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

import com.hp.hponeview.data.network.ConnectionTemplate;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetConnectionTemplateForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetConnectionTemplateForId.requiredParms; };
	public static final Integer optionalParms() { return ReqNetConnectionTemplateForId.optionalParms; };
	public static final String  _URI = "connection-templates/%s/";

	/**
	 * Implements /rest/connection-templates/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/connection-templates
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the connection template of interest.
	 * @return com.hp.hponeview.data.network.ConnectionTemplate
	 *
	 */
	public static class ReqNetConnectionTemplateForId extends HPOneViewRestRequest<ReqNetConnectionTemplateForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqNetConnectionTemplateForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqNetConnectionTemplateForId.class, requiredParms, optionalParms );
		}

		public ConnectionTemplate get() throws Exception { 
			return super.get(ConnectionTemplate.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ConnectionTemplate.class.
     */
    public static Class<ConnectionTemplate> retType() { return ConnectionTemplate.class; }

    /**
	 * Convert a string containing JSON into an instance of ConnectionTemplate.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.network.ConnectionTemplate.
	 */
	public static ConnectionTemplate fromJsonString( String json ) {
		return util.fromJsonString( ConnectionTemplate.class, json );
	}

	/**
	 * Returns a new instance of ReqNetConnectionTemplateForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the connection template of interest.
	 * @returns com.hp.hponeview.rest.Network.ReqNetConnectionTemplateForId
	 */
	public static ReqNetConnectionTemplateForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetConnectionTemplateForId( conn, id );
		throw new HPOneViewApiVersionException( NetConnectionTemplateForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
