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

import com.hp.hponeview.data.storage.StoragePoolList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoPoolForArrayId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-systems/%s/storage-pools/";
	public static final Integer requiredParms() { return ReqStoPoolForArrayId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoPoolForArrayId.optionalParms; };
	/**
	 * Implements /rest/storage-systems/{arrayId}/storage-pools
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-systems
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param arrayId - String containing the id of the storage system of interest.
	 * @return com.hp.hponeview.data.storage.StoragePoolList
	 */
	public static class ReqStoPoolForArrayId extends HPOneViewRestRequest<ReqStoPoolForArrayId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoPoolForArrayId( Connection conn, String arrayId ) {
			super( conn, String.format( _URI, arrayId ), ReqStoPoolForArrayId.class, requiredParms, optionalParms );
		}

		public StoragePoolList get() throws Exception { 
			return super.get(StoragePoolList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StoragePoolList.class.
     */
    public static Class<StoragePoolList> retType() { return StoragePoolList.class; }

    /**
	 * Convert a string containing JSON into an instance of StoragePoolList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StoragePoolList.
	 */
	public static StoragePoolList fromJsonString( String json ) {
		return util.fromJsonString( StoragePoolList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoPoolForArrayId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param arrayId - String containing the id of the storage system of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoPoolForArrayId
	 */
	public static ReqStoPoolForArrayId instance( Connection conn, String arrayId )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoPoolForArrayId( conn, arrayId );
		throw new HPOneViewApiVersionException( StoPoolForArrayId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
