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

import com.hp.hponeview.data.storage.StorageVolumeAttachment;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeAttachmentForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-attachments/%s/";
	public static final Integer requiredParms() { return ReqStoVolumeAttachmentForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeAttachmentForId.optionalParms; };
	/**
	 * Implements /rest/storage-volume-attachments/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume attachment of interest.
	 * @return com.hp.hponeview.data.storage.StorageVolumeAttachment
	 */
	public static class ReqStoVolumeAttachmentForId extends HPOneViewRestRequest<ReqStoVolumeAttachmentForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStoVolumeAttachmentForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoVolumeAttachmentForId.class, requiredParms, optionalParms );
		}

		public StorageVolumeAttachment get() throws Exception { 
			return super.get(StorageVolumeAttachment.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageVolumeAttachment.class.
     */
    public static Class<StorageVolumeAttachment> retType() { return StorageVolumeAttachment.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageVolumeAttachment.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolumeAttachment.
	 */
	public static StorageVolumeAttachment fromJsonString( String json ) {
		return util.fromJsonString( StorageVolumeAttachment.class, json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeAttachmentForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume attachment of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeAttachmentForId
	 */
	public static ReqStoVolumeAttachmentForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeAttachmentForId( conn, id );
		throw new HPOneViewApiVersionException( StoVolumeAttachmentForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
