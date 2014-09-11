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
package com.hp.hponeview.rest.search;

import com.hp.hponeview.data.search.IndexResource;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchResourceForUri {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchResourceForUri.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchResourceForUri.optionalParms; };
	public static final String  _URI = "index/resources/%s/";

	/**
	 * Implements /rest/index/resources/{uri}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/index-resources.html#d4e96
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param uri - String of resource URI of interest.
	 * @returns com.hp.hponeview.data.search.IndexResource
	 */
	public static class ReqSrchResourceForUri extends HPOneViewRestRequest<ReqSrchResourceForUri> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqSrchResourceForUri(Connection conn, String uri ) {
			super( conn, String.format( _URI, uri ), ReqSrchResourceForUri.class, requiredParms, optionalParms );
		}
		
		public IndexResource get() throws Exception { 
			return super.get(IndexResource.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return IndexResource.class.
     */
    public static Class<IndexResource> retType() { return IndexResource.class; }

    /**
	 * Convert a string containing JSON into an instance of IndexResource.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.IndexResource.
	 */
	public static IndexResource fromJsonString( String json ) {
		return util.fromJsonString( IndexResource.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchResourceForUri
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect type of interest.
	 * @param uri - String of resource URI of interest.
	 * @returns com.hp.hponeview.rest.Search.ReqSrchResourceForUri
	 */
	public static ReqSrchResourceForUri instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchResourceForUri( conn, id );
		throw new HPOneViewApiVersionException( SrchResourceForUri.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
