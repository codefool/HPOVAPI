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
package com.hp.hponeview.rest.settings;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.data.settings.LicenseSummaryListV100;

public class StgLicenseSummaryList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "licenses/";
	public static final Integer requiredParms() { return ReqStgLicenseSummaryList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgLicenseSummaryList.optionalParms; };
	/**
	 * Implements /rest/licenses?view=summary for summary report with high water mark. The only
	 * supported filter is "product", the only supported view is "summary" which is provided
	 * by the API, and the parameter "fields" is not supported.
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/licenses
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.LicenseSummaryListV100
	 */
	public static class ReqStgLicenseSummaryList extends HPOneViewRestRequest<ReqStgLicenseSummaryList> {
		public static final Integer requiredParms = PVIEW;
		public static final Integer optionalParms = PCOUNT | PFILTER | PSTART;
		private ReqStgLicenseSummaryList( Connection conn ) {
			super( conn, _URI, ReqStgLicenseSummaryList.class, requiredParms, optionalParms );
			try {setView("summary");} catch( Exception e ) {}
		}

		public LicenseSummaryListV100 get() throws Exception { 
			return super.get(LicenseSummaryListV100.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return LicenseSummaryListV100.class.
     */
    public static Class<LicenseSummaryListV100> retType() { return LicenseSummaryListV100.class; }

    /**
	 * Convert a string containing JSON into an instance of LicenseSummaryListV100.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.LicenseSummaryListV100.
	 */
	public static LicenseSummaryListV100 fromJsonString( String json ) {
		return util.fromJsonString( LicenseSummaryListV100.class, json );
	}

	/**
	 * Returns a new instance of ReqStgLicenseSummaryList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgLicenseSummaryList
	 */
	public static ReqStgLicenseSummaryList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgLicenseSummaryList( conn );
		throw new HPOneViewApiVersionException( StgLicenseSummaryList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
