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

import com.hp.hponeview.data.search.Tree;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchTreeForUri {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchTreeForUri.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchTreeForUri.optionalParms; };
	public static final String  _URI = "index/trees/%s/";

	/**
	 * Implements /rest/index/trees/{uri}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/index/trees
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.Tree
	 */
	public static class ReqSrchTreeForUri extends HPOneViewRestRequest<ReqSrchTreeForUri> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCHILDDEPTH | PPARDEPTH | PDETAILS | PVIEW | PFIELDS;
		private ReqSrchTreeForUri(Connection conn, String uri ) {
			super( conn, String.format( _URI, uri ), ReqSrchTreeForUri.class, requiredParms, optionalParms );
		}
		
		public Tree get() throws Exception {
			return super.get( Tree.class );
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Tree.class.
     */
    public static Class<Tree> retType() { return Tree.class; }

    /**
	 * Convert a string containing JSON into an instance of Tree.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.Tree.
	 */
	public static Tree fromJsonString( String json ) {
		return util.fromJsonString( Tree.class, json );
	}

	/**
	 * Returns a new instance of ReqTreesForUri
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param uri - String containing the URI of the resource of interest
	 * @returns com.hp.hponeview.rest.Search.ReqTreesForUri
	 */
	public static ReqSrchTreeForUri instance( Connection conn, String uri )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchTreeForUri( conn, uri );
		throw new HPOneViewApiVersionException( SrchTreeForUri.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
