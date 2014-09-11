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

public class StoPoolList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-pools/";
	public static final Integer requiredParms() { return ReqStoPoolList.requiredParms; };
	public static final Integer optionalParms() { return ReqStoPoolList.optionalParms; };
	/**
	 * Implements /rest/storage-pools
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-pools
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.storage.StoragePoolList
	 */
	public static class ReqStoPoolList extends HPOneViewRestRequest<ReqStoPoolList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoPoolList( Connection conn ) {
			super( conn, _URI, ReqStoPoolList.class, requiredParms, optionalParms );
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
	 * Returns a new instance of ReqStoPoolList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.storage.ReqStoPoolList
	 */
	public static ReqStoPoolList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoPoolList( conn );
		throw new HPOneViewApiVersionException( StoPoolList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
