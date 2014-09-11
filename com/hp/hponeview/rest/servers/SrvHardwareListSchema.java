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
package com.hp.hponeview.rest.servers;

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvHardwareListSchema {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvHardwareListSchema.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvHardwareListSchema.optionalParms; };
	public static final String  _URI = "server-hardware/schema/";

	/**
	 * Implements /rest/server-hardware/schema/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/server-hardware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return Object containing schema structure.
	 */
	public static class ReqSrvHardwareListSchema extends HPOneViewRestRequest<ReqSrvHardwareListSchema> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvHardwareListSchema( Connection conn ) {
			super( conn, _URI, ReqSrvHardwareListSchema.class, requiredParms, optionalParms );
		}

		public Object get() throws Exception { 
			return super.get( Object.class ); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Object.class.
     */
    public static Class<Object> retType() { return Object.class; }

    /**
	 * Convert a schema in JSON format to an Object structure.
	 * @param json - String containing JSON.
	 * @return Object containing schema structure.
	 */
	public static Object fromJsonString( String json ) {
		return util.fromJsonString( Object.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvHardwareListSchema
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvHardwareListSchema
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvHardwareListSchema instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvHardwareListSchema( conn );
		throw new HPOneViewApiVersionException( SrvHardwareListSchema.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
