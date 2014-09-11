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

import com.hp.hponeview.data.storage.StorageVolumeTemplateList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoVolumeTemplateList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-templates/";
	public static final Integer requiredParms() { return ReqStoVolumeTemplateList.requiredParms; };
	public static final Integer optionalParms() { return ReqStoVolumeTemplateList.optionalParms; };
	/**
	 * Implements /rest/storage-volume-templates
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.storage.StorageVolumeTemplateList
	 */
	public static class ReqStoVolumeTemplateList extends HPOneViewRestRequest<ReqStoVolumeTemplateList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoVolumeTemplateList( Connection conn ) {
			super( conn, _URI, ReqStoVolumeTemplateList.class, requiredParms, optionalParms );
		}

		public StorageVolumeTemplateList get() throws Exception { 
			return super.get(StorageVolumeTemplateList.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageVolumeTemplateList.class.
     */
    public static Class<StorageVolumeTemplateList> retType() { return StorageVolumeTemplateList.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageVolumeTemplateList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageVolumeTemplateList.
	 */
	public static StorageVolumeTemplateList fromJsonString( String json ) {
		return util.fromJsonString( StorageVolumeTemplateList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoVolumeTemplateList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.storage.ReqStoVolumeTemplateList
	 */
	public static ReqStoVolumeTemplateList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoVolumeTemplateList( conn );
		throw new HPOneViewApiVersionException( StoVolumeTemplateList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
