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

import com.hp.hponeview.data.settings.DomainCollection;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgDomainList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "domains/";
	public static final Integer requiredParms() { return ReqStgDomainList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgDomainList.optionalParms; };
	/**
	 * Implements /rest/domains/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/domains
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.DomainCollection
	 */
	public static class ReqStgDomainList extends HPOneViewRestRequest<ReqStgDomainList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStgDomainList( Connection conn ) {
			super( conn, _URI, ReqStgDomainList.class, requiredParms, optionalParms );
		}

		public DomainCollection get() throws Exception { 
			return super.get(DomainCollection.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return DomainCollection.class.
     */
    public static Class<DomainCollection> retType() { return DomainCollection.class; }

    /**
	 * Convert a string containing JSON into an instance of DomainCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.DomainCollection.
	 */
	public static DomainCollection fromJsonString( String json ) {
		return util.fromJsonString( DomainCollection.class, json );
	}

	/**
	 * Returns a new instance of ReqStgDomainList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgDomainList
	 */
	public static ReqStgDomainList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgDomainList( conn );
		throw new HPOneViewApiVersionException( StgDomainList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
