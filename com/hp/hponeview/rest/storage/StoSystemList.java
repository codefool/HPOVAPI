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
package com.hp.hponeview.rest.storage;

import com.hp.hponeview.data.storage.StorageSystemList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoSystemList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-systems/";
	public static final Integer requiredParms() { return ReqStoStorageSystemList.requiredParms; };
	public static final Integer optionalParms() { return ReqStoStorageSystemList.optionalParms; };
	/**
	 * Implements /rest/storage-systems
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-systems
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.storage.StorageSystemList
	 */
	public static class ReqStoStorageSystemList extends HPOneViewRestRequest<ReqStoStorageSystemList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoStorageSystemList( Connection conn ) {
			super( conn, _URI, ReqStoStorageSystemList.class, requiredParms, optionalParms );
		}

		public StorageSystemList get() throws Exception { 
			return super.get(StorageSystemList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageSystemList.class.
     */
    public static Class<StorageSystemList> retType() { return StorageSystemList.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageSystemList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageSystemList.
	 */
	public static StorageSystemList fromJsonString( String json ) {
		return util.fromJsonString( StorageSystemList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoStorageSystemList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.storage.ReqStoStorageSystemList
	 */
	public static ReqStoStorageSystemList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoStorageSystemList( conn );
		throw new HPOneViewApiVersionException( StoSystemList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
