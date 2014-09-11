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

import com.hp.hponeview.data.settings.Backup;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgBackupForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqStgBackupForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgBackupForId.optionalParms; };
	public static final String  _URI = "backups/%s/";
	
	/**
	 * Implements /rest/backups/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/backups.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the backup of interest
	 * @return com.hp.hponeview.data.settings.Backup
	 */
	public static class ReqStgBackupForId extends HPOneViewRestRequest<ReqStgBackupForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgBackupForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgBackupForId.class, requiredParms, optionalParms );
		}

		public Backup get() throws Exception { 
			return super.get(Backup.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Backup.class.
     */
    public static Class<Backup> retType() { return Backup.class; }

    /**
	 * Convert a string containing JSON into an instance of BackupDetail.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.BackupDetail.
	 */
	public static Backup fromJsonString( String json ) {
		return util.fromJsonString( Backup.class, json );
	}

	/**
	 * Returns a new instance of ReqStgBackupForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the backup id of interest.
	 * @returns com.hp.hponeview.rest.Settings.ReqStgBackupForId
	 */
	public static ReqStgBackupForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgBackupForId( conn, id );
		throw new HPOneViewApiVersionException( StgBackupForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
