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

import com.hp.hponeview.data.storage.StorageVolumeAttachmentPath;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeAttachmentPathForIdAndPathId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-attachments/%s/paths/%s/";
	public static final Integer requiredParms() { return ReqStoVolumeAttachmentPathForIdAndPathId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeAttachmentPathForIdAndPathId.optionalParms; };
	/**
	 * Implements /rest/storage-volume-attachments/{id}/paths/{pathId}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume attachment of interest.
	 * @param pathId - String containing the id of the attachment path of interest
	 * @return com.hp.hponeview.data.storage.StorageVolumeAttachmentPath
	 */
	public static class ReqStoVolumeAttachmentPathForIdAndPathId extends HPOneViewRestRequest<ReqStoVolumeAttachmentPathForIdAndPathId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStoVolumeAttachmentPathForIdAndPathId( Connection conn, String id, String pathId ) {
			super( conn, String.format( _URI, id, pathId ), ReqStoVolumeAttachmentPathForIdAndPathId.class, requiredParms, optionalParms );
		}

		public StorageVolumeAttachmentPath get() throws Exception { 
			return super.get(StorageVolumeAttachmentPath.class);
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageVolumeAttachmentPath.class.
     */
    public static Class<StorageVolumeAttachmentPath> retType() { return StorageVolumeAttachmentPath.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageVolumeAttachmentPath.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolumeAttachmentPath.
	 */
	public static StorageVolumeAttachmentPath fromJsonString( String json ) {
		return util.fromJsonString( StorageVolumeAttachmentPath.class, json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeAttachmentPathForIdAndPathId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume attachment of interest.
	 * @param pathId - String containing the id of the attachment path of interest
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeAttachmentPathForIdAndPathId
	 */
	public static ReqStoVolumeAttachmentPathForIdAndPathId instance( Connection conn, String id, String pathId )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeAttachmentPathForIdAndPathId( conn, id, pathId );
		throw new HPOneViewApiVersionException( StoVolumeAttachmentPathForIdAndPathId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
