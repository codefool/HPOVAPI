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

import com.hp.hponeview.data.storage.StoragePool;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoPoolForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-pools/%s/";
	public static final Integer requiredParms() { return ReqStoPoolForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoPoolForId.optionalParms; };
	/**
	 * Implements /rest/storage-pools/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-pools
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage pool of interest.
	 * @return com.hp.hponeview.data.storage.StoragePool
	 */
	public static class ReqStoPoolForId extends HPOneViewRestRequest<ReqStoPoolForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStoPoolForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoPoolForId.class, requiredParms, optionalParms );
		}

		public StoragePool get() throws Exception { 
			return super.get(StoragePool.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StoragePool.class.
     */
    public static Class<StoragePool> retType() { return StoragePool.class; }

    /**
	 * Convert a string containing JSON into an instance of StoragePool.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StoragePool.
	 */
	public static StoragePool fromJsonString( String json ) {
		return util.fromJsonString( StoragePool.class, json );
	}

	/**
	 * Returns a new instance of ReqStoPoolForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage pool of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoPoolForId
	 */
	public static ReqStoPoolForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoPoolForId( conn, id );
		throw new HPOneViewApiVersionException( StoPoolForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
