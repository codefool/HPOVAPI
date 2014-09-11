/*****************************************************************************
*
* copyright.txt
*
* Copyright 2013 Hewlett-Packard Development Company, L.P.
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

import com.hp.hponeview.data.search.LabelList;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class SrchLabelList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchLabelList.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchLabelList.optionalParms; };
	public static final String  _URI = "labels/";

	/**
	 * Implements /rest/labels
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/labels
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.search.LabelList
	 */
	public static class ReqSrchLabelList extends HPOneViewRestRequest<ReqSrchLabelList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCATEGORY | PCOUNT | PFIELDS | PNAMEPFIX | PSORT | PSTART | PVIEW;
		private ReqSrchLabelList( Connection conn ) {
			super( conn, _URI, ReqSrchLabelList.class, requiredParms, optionalParms );
		}

		public LabelList get() throws Exception { 
			return super.get(LabelList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LabelList.class.
     */
    public static Class<LabelList> retType() { return LabelList.class; }

    /**
	 * Convert a string containing JSON into an instance of LabelList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.LabelList.
	 */
	public static LabelList fromJsonString( String json ) {
		return util.fromJsonString( LabelList.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchLabelList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqSrchLabelList
	 */
	public static ReqSrchLabelList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchLabelList( conn );
		throw new HPOneViewApiVersionException( SrchLabelList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
