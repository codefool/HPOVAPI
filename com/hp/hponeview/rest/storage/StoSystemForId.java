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

import com.hp.hponeview.data.storage.StorageSystem;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoSystemForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-systems/%s/";
	public static final Integer requiredParms() { return ReqStoStorageSystemForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoStorageSystemForId.optionalParms; };
	/**
	 * Implements /rest/storage-systems/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-systems
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage system of interest.
	 * @return com.hp.hponeview.data.storage.StoragePoolList
	 */
	public static class ReqStoStorageSystemForId extends HPOneViewRestRequest<ReqStoStorageSystemForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStoStorageSystemForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoStorageSystemForId.class, requiredParms, optionalParms );
		}

		public StorageSystem get() throws Exception { 
			return super.get(StorageSystem.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageSystem.class.
     */
    public static Class<StorageSystem> retType() { return StorageSystem.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageSystem.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageSystem.
	 */
	public static StorageSystem fromJsonString( String json ) {
		return util.fromJsonString( StorageSystem.class, json );
	}

	/**
	 * Returns a new instance of ReqStoStorageSystemForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage system of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoStorageSystemForId
	 */
	public static ReqStoStorageSystemForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoStorageSystemForId( conn, id );
		throw new HPOneViewApiVersionException( StoSystemForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
