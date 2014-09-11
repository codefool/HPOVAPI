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

import com.hp.hponeview.data.search.IndexPaginatedCollectionV4;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchResourcesList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchResourcesList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchResourcesList.optionalParms; };
	public static final String  _URI = "index/resources/";

	/**
	 * Implements /rest/index/resources/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/index-resources.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.IndexPaginatedCollectionV4
	 */
	public static class ReqSrchResourcesList extends HPOneViewRestRequest<ReqSrchResourcesList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL | PUSERQUERY | PCATEGORY | PPADDING | PREFURI;
		private ReqSrchResourcesList(Connection conn ) {
			super( conn, _URI, ReqSrchResourcesList.class, requiredParms, optionalParms );
		}
		
		public IndexPaginatedCollectionV4 get() throws Exception { 
			return super.get(IndexPaginatedCollectionV4.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return IndexPaginatedCollectionV4.class.
     */
    public static Class<IndexPaginatedCollectionV4> retType() {
        return IndexPaginatedCollectionV4.class;
    }


    /**
	 * Convert a string containing JSON into an instance of IndexPaginatedCollectionV4.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.IndexPaginatedCollectionV4.
	 */
	public static IndexPaginatedCollectionV4 fromJsonString( String json ) {
		return util.fromJsonString( IndexPaginatedCollectionV4.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchResourcesList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the interconnect type of interest.
	 * @returns com.hp.hponeview.rest.Search.ReqSrchResourcesList
	 */
	public static ReqSrchResourcesList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchResourcesList( conn );
		throw new HPOneViewApiVersionException( SrchResourcesList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
