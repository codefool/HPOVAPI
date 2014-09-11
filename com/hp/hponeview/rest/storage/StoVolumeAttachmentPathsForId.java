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

import java.util.List;
import java.util.Vector;

import com.hp.hponeview.data.storage.StorageVolumeAttachmentPath;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeAttachmentPathsForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-attachments/%s/paths/";
	public static final Integer requiredParms() { return ReqStoVolumeAttachmentPathsForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeAttachmentPathsForId.optionalParms; };
	/**
	 * Implements /rest/storage-volume-attachments/{id}/paths
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume attachment of interest.
	 * @return List<com.hp.hponeview.data.storage.StorageVolumeAttachmentPath>
	 */
	public static class ReqStoVolumeAttachmentPathsForId extends HPOneViewRestRequest<ReqStoVolumeAttachmentPathsForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private static final List<StorageVolumeAttachmentPath> retType = new Vector<StorageVolumeAttachmentPath>();
		private ReqStoVolumeAttachmentPathsForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoVolumeAttachmentPathsForId.class, requiredParms, optionalParms );
		}

		@SuppressWarnings("unchecked")
		public List<StorageVolumeAttachmentPath> get() throws Exception { 
			return super.get(retType.getClass()); 
		}
	}
	
    /**
     * Return the Class object for the return type for this REST call.
     * @return Vector<StorageVolumeAttachmentPath>.class.
     */
    public static Class<?> retType() { return ReqStoVolumeAttachmentPathsForId.retType.getClass(); }

    /**
	 * Convert a string containing JSON into an instance of StorageVolumeAttachmentPath.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolumeAttachmentPath.
	 */
	@SuppressWarnings("unchecked")
	public static List<StorageVolumeAttachmentPath> fromJsonString( String json ) {
		return util.fromJsonString( ReqStoVolumeAttachmentPathsForId.retType.getClass(), json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeAttachmentPathsForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage volume attachment of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeAttachmentPathsForId
	 */
	public static ReqStoVolumeAttachmentPathsForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeAttachmentPathsForId( conn, id );
		throw new HPOneViewApiVersionException( StoVolumeAttachmentPathsForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
