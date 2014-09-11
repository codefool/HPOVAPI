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

import com.hp.hponeview.data.storage.ConnectableStorageVolumeTemplateList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoConnectableVolumeTemplateList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-volume-templates/connectable-volume-templates/";
	public static final Integer requiredParms() { return ReqStoConnectableVolumeTemplateList.requiredParms; };
	public static final Integer optionalParms() { return ReqStoConnectableVolumeTemplateList.optionalParms; };
	/**
	 * Implements /rest/storage-volume-templates/connectable-volume-templates
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.storage.ConnectableStorageVolumeTemplateList
	 */
	public static class ReqStoConnectableVolumeTemplateList extends HPOneViewRestRequest<ReqStoConnectableVolumeTemplateList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;
		private ReqStoConnectableVolumeTemplateList( Connection conn ) {
			super( conn, _URI, ReqStoConnectableVolumeTemplateList.class, requiredParms, optionalParms );
		}

		public ConnectableStorageVolumeTemplateList get() throws Exception { 
			return super.get(ConnectableStorageVolumeTemplateList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return ConnectableStorageVolumeTemplateList.class.
     */
    public static Class<ConnectableStorageVolumeTemplateList> retType() { return ConnectableStorageVolumeTemplateList.class; }

    /**
	 * Convert a string containing JSON into an instance of ConnectableStorageVolumeTemplateList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.ConnectableStorageVolumeTemplateList.
	 */
	public static ConnectableStorageVolumeTemplateList fromJsonString( String json ) {
		return util.fromJsonString( ConnectableStorageVolumeTemplateList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoConnectableVolumeTemplateList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.storage.ReqStoConnectableVolumeTemplateList
	 */
	public static ReqStoConnectableVolumeTemplateList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoConnectableVolumeTemplateList( conn );
		throw new HPOneViewApiVersionException( StoConnectableVolumeTemplateList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
