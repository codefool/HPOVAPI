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

import com.hp.hponeview.data.settings.BackupList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgBackupList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqStgBackupList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgBackupList.optionalParms; };
	public static final String  _URI = "backups/";
	
	/**
	 * Implements /rest/backups/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/backups.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.BackupList
	 */
	public static class ReqStgBackupList extends HPOneViewRestRequest<ReqStgBackupList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSTART | PCOUNT | PSORT | PQUERY | PVIEW | PFIELDS | PFILTER;
		private ReqStgBackupList( Connection conn ) {
			super( conn, _URI, ReqStgBackupList.class, requiredParms, optionalParms );
		}

		public BackupList get() throws Exception { 
			return super.get(BackupList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return BackupList.class.
     */
    public static Class<BackupList> retType() { return BackupList.class; }

    /**
	 * Convert a string containing JSON into an instance of BackupDetailList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.BackupList.
	 */
	public static BackupList fromJsonString( String json ) {
		return util.fromJsonString( BackupList.class, json );
	}

	/**
	 * Returns a new instance of ReqStgBackupList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgBackupList
	 */
	public static ReqStgBackupList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgBackupList( conn );
		throw new HPOneViewApiVersionException( StgBackupList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
