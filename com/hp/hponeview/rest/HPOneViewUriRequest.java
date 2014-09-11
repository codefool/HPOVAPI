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
package com.hp.hponeview.rest;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class HPOneViewUriRequest {
	public static final Integer _MINAPIVERSION = 101;
	public static       String  _URI = "";
	public static final Integer requiredParms() { return ReqHPOneViewUriRequest.requiredParms; }
	public static final Integer optionalParms() { return ReqHPOneViewUriRequest.optionalParms; }
	/**
	 * Implements /rest/alerts/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/alerts.html#d4e170
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id string containing the URI of the alert.
	 * @return com.hp.hponeview.data.activity.AlertResourceV2.
	 */
	public static class ReqHPOneViewUriRequest extends HPOneViewRestRequest<ReqHPOneViewUriRequest> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PALL;
		private Class<?> retType;
		private ReqHPOneViewUriRequest(Connection conn, String uri, Class<?> type ) {
			super( conn, uri, ReqHPOneViewUriRequest.class, requiredParms, optionalParms );
			retType = type;
			_URI = uri;
		}
		
		public Object get() throws Exception { 
			return retType.cast(super.get(retType)); 
		}
	}
	
    /**
     * Return the Class object for the return type for this REST call.
     * @return Object.class.
     */
    public static Class<Object> retType() { return Object.class; }

    /**
	 * Convert a string containing JSON into an instance of Object.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.Object.
	 */
	public static Object fromJsonString( String json ) {
		return util.fromJsonString(Object.class, json);
	}

	/**
	 * Returns a new instance of an ReqHPOneViewUriRequest
	 * @param conn - Connection object to HP OneView server
	 * @param uri - String containing the URI of the request to make.
	 * @return com.hp.hponeview.rest.HPOneViewUriRequest.ReqHPOneViewUriRequest
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqHPOneViewUriRequest instance( Connection conn, String uri, Class<?> type ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqHPOneViewUriRequest( conn, uri, type );
		throw new HPOneViewApiVersionException( HPOneViewUriRequest.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
