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

import com.hp.hponeview.data.search.Label;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class SrchLabelForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrchLabelForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrchLabelForId.optionalParms; };
	public static final String  _URI = "labels/%s/";

	/**
	 * Implements /rest/labels/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/labels
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.data.search.Label
	 */
	public static class ReqSrchLabelForId extends HPOneViewRestRequest<ReqSrchLabelForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqSrchLabelForId(Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrchLabelForId.class, requiredParms, optionalParms );
		}
		
		public Label get() throws Exception {
			return super.get( Label.class );
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Label.class.
     */
    public static Class<Label> retType() { return Label.class; }

    /**
	 * Convert a string containing JSON into an instance of Label.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.search.Label.
	 */
	public static Label fromJsonString( String json ) {
		return util.fromJsonString( Label.class, json );
	}

	/**
	 * Returns a new instance of ReqSrchLabelForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the Id of the label to retrieve
	 * @returns com.hp.hponeview.rest.Search.ReqSrchLabelForId
	 */
	public static ReqSrchLabelForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrchLabelForId( conn, id );
		throw new HPOneViewApiVersionException( SrchLabelForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
