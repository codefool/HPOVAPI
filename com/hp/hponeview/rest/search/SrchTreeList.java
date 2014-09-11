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

import com.hp.hponeview.data.search.TreesPaginatedCollectionV4;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchTreeList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchTreeList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchTreeList.optionalParms; };
	public static final String  _URI = "index/trees/";

	/**
	 * Implements /rest/index/trees
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/rest/api/index-trees.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.TreesPaginatedCollectionV4
	 */
	public static class ReqSrchTreeList extends HPOneViewRestRequest<ReqSrchTreeList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL | PUSERQUERY | PCATEGORY | PCHILDDEPTH 
										          | PPARDEPTH | PDETAILS | PPADDING | PREFURI;  
		private ReqSrchTreeList(Connection conn ) {
			super( conn, _URI, ReqSrchTreeList.class, requiredParms, optionalParms );
		}
		
		public TreesPaginatedCollectionV4 get() throws Exception { 
			return super.get(TreesPaginatedCollectionV4.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return TreesPaginatedCollectionV4.class.
     */
    public static Class<TreesPaginatedCollectionV4> retType() { return TreesPaginatedCollectionV4.class; }

    /**
	 * Convert a string containing JSON into an instance of TreesPaginatedCollectionV4.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.TreesPaginatedCollectionV4.
	 */
	public static TreesPaginatedCollectionV4 fromJsonString( String json ) {
		return util.fromJsonString( TreesPaginatedCollectionV4.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchTreeList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Search.ReqSrchTreeList
	 */
	public static ReqSrchTreeList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchTreeList( conn );
		throw new HPOneViewApiVersionException( SrchTreeList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
