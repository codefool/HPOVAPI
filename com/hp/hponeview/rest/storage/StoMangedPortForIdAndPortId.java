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

import com.hp.hponeview.data.storage.StorageTargetPort;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoMangedPortForIdAndPortId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-systems/%s/managedPorts/%s/";
	public static final Integer requiredParms() { return ReqStoMangedPortForIdAndPortId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoMangedPortForIdAndPortId.optionalParms; };
	/**
	 * Implements /rest/storage-systems/{arrayId}/managedPorts/{portId}
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/restores.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param arrayId - String containing the id of the storage system of interest.
	 * @param portId - String containing the id of the managed port of interest.
	 * @return com.hp.hponeview.data.storage.StorageTargetPort
	 */
	public static class ReqStoMangedPortForIdAndPortId extends HPOneViewRestRequest<ReqStoMangedPortForIdAndPortId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStoMangedPortForIdAndPortId( Connection conn, String arrayId, String portId ) {
			super( conn, String.format( _URI, arrayId, portId ), ReqStoMangedPortForIdAndPortId.class, requiredParms, optionalParms );
		}

		public StorageTargetPort get() throws Exception { 
			return super.get(StorageTargetPort.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageTargetPort.class.
     */
    public static Class<StorageTargetPort> retType() { return StorageTargetPort.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageTargetPort.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageTargetPort.
	 */
	public static StorageTargetPort fromJsonString( String json ) {
		return util.fromJsonString( StorageTargetPort.class, json );
	}

	/**
	 * Returns a new instance of ReqStoMangedPortForIdAndPortId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param arrayId - String containing the id of the storage system of interest.
	 * @param portId - String containing the id of the managed port of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoMangedPortForIdAndPortId
	 */
	public static ReqStoMangedPortForIdAndPortId instance( Connection conn, String arrayId, String portId )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoMangedPortForIdAndPortId( conn, arrayId, portId );
		throw new HPOneViewApiVersionException( StoMangedPortForIdAndPortId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
