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

import com.hp.hponeview.data.search.AggregatedTree;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchAggTreeForUri {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchAggTreeForUri.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchAggTreeForUri.optionalParms; };
	public static final String  _URI = "index/trees/aggregated/%s/";

	/**
	 * Implements /rest/index/trees/aggregated/{uri}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/rest/api/index-trees.html#d4e158
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.TreeNode
	 */
	public static class ReqSrchAggTreeForUri extends HPOneViewRestRequest<ReqSrchAggTreeForUri> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCHILDDEPTH | PPARDEPTH | PCHILDLIM | PDETAILS | PVIEW | PFIELDS;
		private ReqSrchAggTreeForUri(Connection conn, String uri ) {
			super( conn, String.format( _URI, uri ), ReqSrchAggTreeForUri.class, requiredParms, optionalParms );
		}
		
		public AggregatedTree get() throws Exception {
			return super.get( AggregatedTree.class );
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AggregatedTree.class.
     */
    public static Class<AggregatedTree> retType() { return AggregatedTree.class; }

    /**
	 * Convert a string containing JSON into an instance of AggregatedTree.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.AggregatedTree.
	 */
	public static AggregatedTree fromJsonString( String json ) {
		return util.fromJsonString( AggregatedTree.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchAggTreeForUri
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param uri - String containing the URI of the resource of interest
	 * @returns com.hp.hponeview.rest.Search.ReqSrchAggTreeForUri
	 */
	public static ReqSrchAggTreeForUri instance( Connection conn, String uri )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchAggTreeForUri( conn, uri );
		throw new HPOneViewApiVersionException( SrchAggTreeForUri.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
