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

public class SrvIdPoolVmacRangeSchema {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return RerqSrvIdPoolVmacRangeSchema.requiredParms; };
	public static final Integer optionalParms() { return RerqSrvIdPoolVmacRangeSchema.optionalParms; };
	public static final String  _URI = "id-pools/vmac/ranges/schema/";

	/**
	 * Implements /rest/id-pools/vmac/ranges/schema/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/id-pools/vmac/ranges
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return Object containing schema structure.
	 */
	public static class RerqSrvIdPoolVmacRangeSchema extends HPOneViewRestRequest<RerqSrvIdPoolVmacRangeSchema> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private RerqSrvIdPoolVmacRangeSchema( Connection conn ) {
			super( conn, _URI, RerqSrvIdPoolVmacRangeSchema.class, requiredParms, optionalParms );
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
	 * Returns a new instance of RerqSrvIdPoolVmacRangeSchema
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.RerqSrvIdPoolVmacRangeSchema
	 * @throws HPOneViewApiVersionException
	 */
	public static RerqSrvIdPoolVmacRangeSchema instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new RerqSrvIdPoolVmacRangeSchema( conn );
		throw new HPOneViewApiVersionException( SrvIdPoolVmacRangeSchema.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
