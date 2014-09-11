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

import com.hp.hponeview.data.storage.StorageVolume;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volumes/%s/";
	public static final Integer requiredParms() { return ReqStoVolumeForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeForId.optionalParms; };
	/**
	 * Implements /rest/storage-volumes/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-volumes
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume of interest.
	 * @return com.hp.hponeview.data.storage.StorageVolume
	 */
	public static class ReqStoVolumeForId extends HPOneViewRestRequest<ReqStoVolumeForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStoVolumeForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoVolumeForId.class, requiredParms, optionalParms );
		}

		public StorageVolume get() throws Exception { 
			return super.get(StorageVolume.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageVolume.class.
     */
    public static Class<StorageVolume> retType() { return StorageVolume.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageVolume.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolume.
	 */
	public static StorageVolume fromJsonString( String json ) {
		return util.fromJsonString( StorageVolume.class, json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage pool of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeForId
	 */
	public static ReqStoVolumeForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeForId( conn, id );
		throw new HPOneViewApiVersionException( StoVolumeForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
