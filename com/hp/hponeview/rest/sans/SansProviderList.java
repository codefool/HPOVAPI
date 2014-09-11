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
package com.hp.hponeview.rest.sans;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.data.sans.SanProviderResponseList;

public class SansProviderList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSansProviderList.requiredParms; };
	public static final Integer optionalParms() { return ReqSansProviderList.optionalParms; };
	public static final String  _URI = "fc-sans/providers/";

	/**
	 * Implements /rest/fc-sans/providers
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-sans/providers
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.sans.SanProviderResponseList
	 *
	 */
	public static class ReqSansProviderList extends HPOneViewRestRequest<ReqSansProviderList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCOUNT | PQUERY | PSORT | PSTART;
		private ReqSansProviderList( Connection conn ) {
			super( conn, _URI, ReqSansProviderList.class, requiredParms, optionalParms  );
		}

		public SanProviderResponseList get() throws Exception { 
			return super.get(SanProviderResponseList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SanProviderResponseList.class.
     */
    public static Class<SanProviderResponseList> retType() { return SanProviderResponseList.class; }

    /**
	 * Convert a string containing JSON into an instance of SanProviderResponseList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.sans.SanProviderResponseList.
	 */
	public static SanProviderResponseList fromJsonString( String json ) {
		return util.fromJsonString( SanProviderResponseList.class, json );
	}

	/**
	 * Returns a new instance of ReqSansProviderList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.sans.ReqSansProviderList
	 */
	public static ReqSansProviderList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqSansProviderList( conn );
		throw new HPOneViewApiVersionException( SansProviderList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
