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
import com.hp.hponeview.data.sans.SanResponseList;

public class SansManagedSanList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSansManagedSansList.requiredParms; };
	public static final Integer optionalParms() { return ReqSansManagedSansList.optionalParms; };
	public static final String  _URI = "fc-sans/managed-sans/";

	/**
	 * Implements /rest/fc-sans/managed-sans
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/fc-sans/managed-sans
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.sans.SansResponseList
	 *
	 */
	public static class ReqSansManagedSansList extends HPOneViewRestRequest<ReqSansManagedSansList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PCOUNT | PQUERY | PSORT | PSTART;
		private ReqSansManagedSansList( Connection conn ) {
			super( conn, _URI, ReqSansManagedSansList.class, requiredParms, optionalParms  );
		}

		public SanResponseList get() throws Exception { 
			return super.get(SanResponseList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return SansResponseList.class.
     */
    public static Class<SanResponseList> retType() { return SanResponseList.class; }

    /**
	 * Convert a string containing JSON into an instance of SansResponseList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.sans.SansResponseList.
	 */
	public static SanResponseList fromJsonString( String json ) {
		return util.fromJsonString( SanResponseList.class, json );
	}

	/**
	 * Returns a new instance of ReqSansManagedSansList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.sans.ReqSansManagedSansList
	 */
	public static ReqSansManagedSansList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqSansManagedSansList( conn );
		throw new HPOneViewApiVersionException( SansManagedSanList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
