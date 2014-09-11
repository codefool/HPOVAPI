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
package com.hp.hponeview.rest.facilities;

import com.hp.hponeview.data.facilities.RackList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacRackList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacRackList.requiredParms; };
	public static final Integer optionalParms() { return ReqFacRackList.optionalParms; };
	public static final String  _URI = "racks/";

	/**
	 * Implements /rest/racks/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/racks
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.facilities.RackList
	 */
	public static class ReqFacRackList extends HPOneViewRestRequest<ReqFacRackList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL; 
		private ReqFacRackList( Connection conn ) {
			super( conn, _URI, ReqFacRackList.class, requiredParms, optionalParms );
		}

		public RackList get() throws Exception { 
			return super.get(RackList.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return RackList.class.
     */
    public static Class<RackList> retType() { return RackList.class; }

    /**
	 * Convert a string containing JSON into an instance of RackList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.RackList.
	 */
	public static RackList fromJsonString( String json ) {
		return util.fromJsonString( RackList.class, json );
	}

	/**
	 * Returns a new instance of ReqFacRackList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return hp.oneview.rest.Facilities.ReqFacRackList
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqFacRackList instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacRackList( conn );
		throw new HPOneViewApiVersionException( FacRackList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
