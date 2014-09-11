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

import com.hp.hponeview.data.storage.StorageVolumeAttachmentList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeAttachmentList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-attachments/";
	public static final Integer requiredParms() { return ReqStoVolumeAttachmentList.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeAttachmentList.optionalParms; };
	/**
	 * Implements /rest/storage-volume-attachments
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.storage.StorageVolumeTemplateList
	 */
	public static class ReqStoVolumeAttachmentList extends HPOneViewRestRequest<ReqStoVolumeAttachmentList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoVolumeAttachmentList( Connection conn ) {
			super( conn, _URI, ReqStoVolumeAttachmentList.class, requiredParms, optionalParms );
		}

		public StorageVolumeAttachmentList get() throws Exception { 
			return super.get(StorageVolumeAttachmentList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageVolumeAttachmentList.class.
     */
    public static Class<StorageVolumeAttachmentList> retType() { return StorageVolumeAttachmentList.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageVolumeAttachmentList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolumeAttachmentList.
	 */
	public static StorageVolumeAttachmentList fromJsonString( String json ) {
		return util.fromJsonString( StorageVolumeAttachmentList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeAttachmentList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeAttachmentList
	 */
	public static ReqStoVolumeAttachmentList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeAttachmentList( conn );
		throw new HPOneViewApiVersionException( StoVolumeAttachmentList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
