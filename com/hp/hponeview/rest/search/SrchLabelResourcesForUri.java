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
*
*****************************************************************************/
package com.hp.hponeview.rest.search;

import com.hp.hponeview.data.search.ResourceLabels;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class SrchLabelResourcesForUri {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchLabelResourcesForUri.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchLabelResourcesForUri.optionalParms; };
	public static final String  _URI = "labels/resources/%s/";

	/**
	 * Implements /rest/labels/resources/{uri}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/labels
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.BackupDetail
	 */
	public static class ReqSrchLabelResourcesForUri extends HPOneViewRestRequest<ReqSrchLabelResourcesForUri> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PSORT | PVIEW;
		private ReqSrchLabelResourcesForUri( Connection conn, String uri ) {
			super( conn, String.format( _URI, uri ), ReqSrchLabelResourcesForUri.class, requiredParms, optionalParms );
		}

		public ResourceLabels get() throws Exception { 
			return super.get(ResourceLabels.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ResourceLabels.class.
     */
    public static Class<ResourceLabels> retType() { return ResourceLabels.class; }

    /**
	 * Convert a string containing JSON into an instance of ResourceLabels.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.ResourceLabels.
	 */
	public static ResourceLabels fromJsonString( String json ) {
		return util.fromJsonString( ResourceLabels.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchLabelResourcesForUri
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Search.ReqSrchLabelResourcesForUri
	 */
	public static ReqSrchLabelResourcesForUri instance( Connection conn, String uri )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchLabelResourcesForUri( conn, uri );
		throw new HPOneViewApiVersionException( SrchLabelResourcesForUri.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
