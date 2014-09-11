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

import com.hp.hponeview.data.servers.IdRange;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvIdPoolVsnRangeForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvIdPoolVsnRangeForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvIdPoolVsnRangeForId.optionalParms; };
	public static final String  _URI = "id-pools/vsn/ranges/%s/";
	
	/**
	 * Implements /rest/id-pools/vsn/ranges/{range-id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/id-pools/vsn/ranges
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the range id of interest.
	 * @return com.hp.hponeview.data.servers.IdRange
	 */
	public static class ReqSrvIdPoolVsnRangeForId extends HPOneViewRestRequest<ReqSrvIdPoolVsnRangeForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PVIEW | PFIELDS;
		private ReqSrvIdPoolVsnRangeForId( Connection conn, String rangeId ) {
			super( conn, String.format( _URI, rangeId ), ReqSrvIdPoolVsnRangeForId.class, requiredParms, optionalParms );
		}

		public IdRange get() throws Exception { 
			return super.get(IdRange.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return IdRange.class.
     */
    public static Class<IdRange> retType() { return IdRange.class; }

    /**
	 * Convert a string containing JSON into an instance of IdRange.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.IdRange.
	 */
	public static IdRange fromJsonString( String json ) {
		return util.fromJsonString( IdRange.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvIdPoolVsnRangeForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param rangeId - String containing the range id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvIdPoolVsnRangeForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvIdPoolVsnRangeForId instance( Connection conn, String rangeId ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvIdPoolVsnRangeForId( conn, rangeId );
		throw new HPOneViewApiVersionException( SrvIdPoolVsnRangeForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
