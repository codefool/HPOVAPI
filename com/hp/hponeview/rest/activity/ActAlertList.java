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
package com.hp.hponeview.rest.activity;

import com.hp.hponeview.data.activity.AlertResourceCollectionV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActAlertList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActAlertList.requiredParms; };
	public static final Integer optionalParms() { return ReqActAlertList.optionalParms; };
	public static final String  _URI = "alerts/";

	/**
	 * Implements /rest/alerts
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/alerts
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.activity.AlertResourceCollectionV2.
	 */
	public static class ReqActAlertList extends HPOneViewRestRequest<ReqActAlertList> {
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PSCTQVL;
		private ReqActAlertList(Connection conn ) {
			super( conn, _URI, ReqActAlertList.class, requiredParms, optionalParms );
		}
		
		public AlertResourceCollectionV2 get() throws Exception { 
			return super.get(AlertResourceCollectionV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AlertResourceCollectionV2.class.
     */
    public static Class<AlertResourceCollectionV2> retType() { return AlertResourceCollectionV2.class; }

    /**
	 * Convert a string containing JSON into an instance of AlertResourceCollectionV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.AlertResourceCollectionV2.
	 */
	public static AlertResourceCollectionV2 fromJsonString( String json ) {
		return util.fromJsonString( AlertResourceCollectionV2.class, json );
	}

	/**
	 * Returns a new instance of ReqActAlertList
	 * @param conn Connection object to HP OneView server
	 * @return com.hp.hponeview.rest.activity.ActAlertList.ReqActAlertList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActAlertList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqActAlertList( conn );
		throw new HPOneViewApiVersionException( ActAlertList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
