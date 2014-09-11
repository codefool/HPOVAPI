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

import com.hp.hponeview.data.storage.StorageVolumeTemplate;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeTemplateForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-templates/%s/";
	public static final Integer requiredParms() { return ReqStoVolumeTemplateForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeTemplateForId.optionalParms; };
	/**
	 * Implements /rest/storage-volume-templates/{id}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage pool of interest.
	 * @return com.hp.hponeview.data.storage.StorageVolumeTemplate
	 */
	public static class ReqStoVolumeTemplateForId extends HPOneViewRestRequest<ReqStoVolumeTemplateForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqStoVolumeTemplateForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoVolumeTemplateForId.class, requiredParms, optionalParms );
		}

		public StorageVolumeTemplate get() throws Exception { 
			return super.get(StorageVolumeTemplate.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageVolumeTemplate.class.
     */
    public static Class<StorageVolumeTemplate> retType() { return StorageVolumeTemplate.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageVolumeTemplate.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolumeTemplate.
	 */
	public static StorageVolumeTemplate fromJsonString( String json ) {
		return util.fromJsonString( StorageVolumeTemplate.class, json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeTemplateForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the id of the storage pool of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeTemplateForId
	 */
	public static ReqStoVolumeTemplateForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeTemplateForId( conn, id );
		throw new HPOneViewApiVersionException( StoVolumeTemplateForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
