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

import com.hp.hponeview.data.storage.StorageTargetPortList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StoManagedPortsListForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "storage-systems/%s/managedPorts/";
	public static final Integer requiredParms() { return ReqStoManagedPortsListForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStoManagedPortsListForId.optionalParms; };
	/**
	 * Implements /rest/storage-systems/{id}/managedPorts
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/storage-systems
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing id of the storage system of interest.
	 * @return com.hp.hponeview.data.storage.StorageTargetPortList
	 */
	public static class ReqStoManagedPortsListForId extends HPOneViewRestRequest<ReqStoManagedPortsListForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL;

		private ReqStoManagedPortsListForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStoManagedPortsListForId.class, requiredParms, optionalParms );
		}

		public StorageTargetPortList get() throws Exception { 
			return super.get( StorageTargetPortList.class ); 
		}
	}
	
    /**
     * Return the Class object for the return type for this REST call.
     * @return StorageTargetPortList.class.
     */
    public static Class<StorageTargetPortList> retType() { return StorageTargetPortList.class; }

    /**
	 * Convert a string containing JSON into an instance of StorageTargetPortList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.storage.StorageTargetPortList.
	 */
	public static StorageTargetPortList fromJsonString( String json ) {
		return util.fromJsonString( StorageTargetPortList.class, json );
	}

	/**
	 * Returns a new instance of ReqStoManagedPortsListForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing id of the storage system of interest.
	 * @returns com.hp.hponeview.rest.storage.ReqStoManagedPortsListForId
	 */
	public static ReqStoManagedPortsListForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStoManagedPortsListForId( conn, id );
		throw new HPOneViewApiVersionException( StoManagedPortsListForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
