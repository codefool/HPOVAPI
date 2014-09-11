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

import com.hp.hponeview.data.settings.Domain;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgDomainForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "domains/%s/";
	public static final Integer requiredParms() { return ReqStgDomainForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgDomainForId.optionalParms; };
	/**
	 * Implements /rest/domains/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/domains
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.Domain
	 */
	public static class ReqStgDomainForId extends HPOneViewRestRequest<ReqStgDomainForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStgDomainForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgDomainForId.class, requiredParms, optionalParms );
		}

		public Domain get() throws Exception { 
			return super.get(Domain.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Domain.class.
     */
    public static Class<Domain> retType() { return Domain.class; }

    /**
	 * Convert a string containing JSON into an instance of Domain.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.Domain.
	 */
	public static Domain fromJsonString( String json ) {
		return util.fromJsonString( Domain.class, json );
	}

	/**
	 * Returns a new instance of ReqStgDomainForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the domain id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgDomainForId
	 */
	public static ReqStgDomainForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgDomainForId( conn, id );
		throw new HPOneViewApiVersionException( StgDomainForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
