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

import com.hp.hponeview.data.search.AssociationPaginatedCollectionV4;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchAssociationResourceList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchAssociationResourceList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchAssociationResourceList.optionalParms; };
	public static final String  _URI = "index/associations/resources/";

	/**
	 * Implements /rest/index/associations/resources
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/index/associations
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.AssociationPaginatedCollectionV4
	 */
	public static class ReqSrchAssociationResourceList extends HPOneViewRestRequest<ReqSrchAssociationResourceList> {
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PSCTL | PQUERY | PCATEGORY | PREFURI | PPADDING | PCHILDURI | PPARENTURI | PNAME;
		private ReqSrchAssociationResourceList(Connection conn ) {
			super( conn, _URI, ReqSrchAssociationResourceList.class, requiredParms, optionalParms );
		}
		
		public AssociationPaginatedCollectionV4 get() throws Exception { 
			return super.get(AssociationPaginatedCollectionV4.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AssociationPaginatedCollectionV4.class.
     */
    public static Class<AssociationPaginatedCollectionV4> retType() {
        return AssociationPaginatedCollectionV4.class;
    }


    /**
	 * Convert a string containing JSON into an instance of AssociationPaginatedCollectionV4.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.AssociationPaginatedCollectionV4.
	 */
	public static AssociationPaginatedCollectionV4 fromJsonString( String json ) {
		return util.fromJsonString( AssociationPaginatedCollectionV4.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchAssociationResourceList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.search.ReqSrchAssociationResourceList
	 */
	public static ReqSrchAssociationResourceList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchAssociationResourceList( conn );
		throw new HPOneViewApiVersionException( SrchAssociationResourceList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
