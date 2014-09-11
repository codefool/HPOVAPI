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

import com.hp.hponeview.data.servers.FragmentList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvIdPoolVwwnRangeFreeFragListForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvIdPoolVwwnRangeFreeFragListForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvIdPoolVwwnRangeFreeFragListForId.optionalParms; };
	public static final String  _URI = "id-pools/vwwn/ranges/%s/free-fragments/";
	
	/**
	 * Implements /rest/id-pools/vwwn/ranges/{id}/free-fragments/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/id-pools/vwwn/ranges
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the range id of interest.
	 * @return com.hp.hponeview.data.servers.FragmentList
	 */
	public static class ReqSrvIdPoolVwwnRangeFreeFragListForId extends HPOneViewRestRequest<ReqSrvIdPoolVwwnRangeFreeFragListForId>	{
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSTART | PCOUNT;
		private ReqSrvIdPoolVwwnRangeFreeFragListForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvIdPoolVwwnRangeFreeFragListForId.class, requiredParms, optionalParms );
		}

		public FragmentList get() throws Exception { 
			return super.get(FragmentList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return FragmentList.class.
     */
    public static Class<FragmentList> retType() { return FragmentList.class; }

    /**
	 * Convert a string containing JSON into an instance of FragmentList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.FragmentList.
	 */
	public static FragmentList fromJsonString( String json ) {
		return util.fromJsonString( FragmentList.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvIdPoolVwwnRangeFreeFragListForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param rangeId - String containing the range id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqSrvIdPoolVwwnRangeFreeFragListForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvIdPoolVwwnRangeFreeFragListForId instance( Connection conn, String rangeId ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvIdPoolVwwnRangeFreeFragListForId( conn, rangeId );
		throw new HPOneViewApiVersionException( SrvIdPoolVwwnRangeFreeFragListForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
