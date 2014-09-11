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

import com.hp.hponeview.data.settings.Restore;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgRestoreForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "restores/%s/";
	public static final Integer requiredParms() { return ReqStgRestoreForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgRestoreForId.optionalParms; };
	/**
	 * Implements /rest/restores/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/restores
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing restore id of interest.
	 * @return com.hp.hponeview.data.settings.Restore
	 */
	public static class ReqStgRestoreForId extends HPOneViewRestRequest<ReqStgRestoreForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqStgRestoreForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgRestoreForId.class, requiredParms, optionalParms );
		}

		public Restore get() throws Exception { 
			return super.get(Restore.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Restore.class.
     */
    public static Class<Restore> retType() { return Restore.class; }

    /**
	 * Convert a string containing JSON into an instance of RestoreResource.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.Restore.
	 */
	public static Restore fromJsonString( String json ) {
		return util.fromJsonString( Restore.class, json );
	}

	/**
	 * Returns a new instance of ReqStgRestoreForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the restore id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgRestoreForId
	 */
	public static ReqStgRestoreForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgRestoreForId( conn, id );
		throw new HPOneViewApiVersionException( StgRestoreForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
