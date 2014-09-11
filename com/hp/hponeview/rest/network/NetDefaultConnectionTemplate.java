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

public class NetDefaultConnectionTemplate {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetDefaultConnectionTemplate.requiredParms; };
	public static final Integer optionalParms() { return ReqNetDefaultConnectionTemplate.optionalParms; };
	public static final String  _URI = "connection-templates/defaultConnectionTemplate/";

	/**
	 * Implements /rest/connection-templates/defaultConnectionTemplate/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/connection-templates
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.ConnectionTemplate
	 *
	 */
	public static class ReqNetDefaultConnectionTemplate extends HPOneViewRestRequest<ReqNetDefaultConnectionTemplate> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetDefaultConnectionTemplate( Connection conn ) {
			super( conn, _URI, ReqNetDefaultConnectionTemplate.class, requiredParms, optionalParms  );
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
	 * Returns a new instance of ReqNetDefaultConnectionTemplate
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Network.ReqNetDefaultConnectionTemplate
	 */
	public static ReqNetDefaultConnectionTemplate instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetDefaultConnectionTemplate( conn );
		throw new HPOneViewApiVersionException( NetDefaultConnectionTemplate.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
