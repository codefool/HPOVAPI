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

import com.hp.hponeview.data.storage.AttachableStorageVolumeList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoAttachVolumeList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volumes/attachable-volumes/";
	public static final Integer requiredParms() { return ReqStoAttachVolumeList.requiredParms; };
	public static final Integer optionalParms() { return ReqStoAttachVolumeList.optionalParms; };
	/**
	 * Implements /rest/storage-volumes/attachable-volumes
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.storage.AttachableStorageVolumeList
	 */
	public static class ReqStoAttachVolumeList extends HPOneViewRestRequest<ReqStoAttachVolumeList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoAttachVolumeList( Connection conn ) {
			super( conn, _URI, ReqStoAttachVolumeList.class, requiredParms, optionalParms );
		}

		public AttachableStorageVolumeList get() throws Exception { 
			return super.get(AttachableStorageVolumeList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AttachableStorageVolumeList.class.
     */
    public static Class<AttachableStorageVolumeList> retType() { return AttachableStorageVolumeList.class; }

    /**
	 * Convert a string containing JSON into an instance of AttachableStorageVolumeList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.AttachableStorageVolumeList.
	 */
	public static AttachableStorageVolumeList fromJsonString( String json ) {
		return util.fromJsonString( AttachableStorageVolumeList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoAttachVolumeList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.storage.ReqStoAttachVolumeList
	 */
	public static ReqStoAttachVolumeList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoAttachVolumeList( conn );
		throw new HPOneViewApiVersionException( StoAttachVolumeList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
