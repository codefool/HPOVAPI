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

import com.hp.hponeview.data.search.Suggestions;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrchSuggestions {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchSuggestions.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchSuggestions.optionalParms; };
	public static final String  _URI = "index/search-suggestions/";

	/**
	 * Implements /rest/index/search-suggestions
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/rest/api/index-search-suggestions.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.Suggestions
	 */
	public static class ReqSrchSuggestions extends HPOneViewRestRequest<ReqSrchSuggestions> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVL | PUSERQUERY | PCATEGORY;
		private ReqSrchSuggestions( Connection conn ) {
			super( conn, _URI, ReqSrchSuggestions.class, requiredParms, optionalParms );
		}
		
		public Suggestions get() throws Exception {
			return super.get( Suggestions.class );
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Suggestions.class.
     */
    public static Class<Suggestions> retType() { return Suggestions.class; }

    /**
	 * Convert a string containing JSON into an instance of Suggestions.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.Suggestions.
	 */
	public static Suggestions fromJsonString( String json ) {
		return util.fromJsonString( Suggestions.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchSuggestions
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Search.ReqSrchSuggestions
	 */
	public static ReqSrchSuggestions instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchSuggestions( conn );
		throw new HPOneViewApiVersionException( SrchSuggestions.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
