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

import com.hp.hponeview.data.facilities.Rack;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacRackForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacRackForId.requiredParms; };
	public static final Integer optionalParms() { return ReqFacRackForId.optionalParms; };
	public static final String  _URI = "racks/%s/";

	/**
	 * Implements /rest/racks/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/racks
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String rack id
	 * @return com.hp.hponeview.data.facilities.Rack 
	 *
	 */
	public static class ReqFacRackForId extends HPOneViewRestRequest<ReqFacRackForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW;
		private ReqFacRackForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqFacRackForId.class, requiredParms, optionalParms );
		}

		public Rack get() throws Exception { 
			return super.get(Rack.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Rack.class.
     */
    public static Class<Rack> retType() { return Rack.class; }

    /**
	 * Convert a string containing JSON into an instance of Rack.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.Rack.
	 */
	public static Rack fromJsonString( String json ) {
		return util.fromJsonString( Rack.class, json );
	}

	/**
	 * Returns a new instance of ReqFacRackForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the rack of interest.
	 * @return hp.oneview.rest.Facilities.ReqFacRackForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqFacRackForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacRackForId( conn, id );
		throw new HPOneViewApiVersionException( FacRackForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
