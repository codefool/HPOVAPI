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

import com.hp.hponeview.data.facilities.Datacenter;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacDatacenterForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacDatacenterForId.requiredParms; };
	public static final Integer optionalParms() { return ReqFacDatacenterForId.optionalParms; };
	public static final String  _URI = "datacenters/%s/";
	
	/**
	 * Implements /rest/datacenters/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/datacenters
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the datacenter of interest.
	 * @return com.hp.hponeview.data.facilities.Datacenter
	 *
	 */
	public static class ReqFacDatacenterForId extends HPOneViewRestRequest<ReqFacDatacenterForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PFIELDS | PVIEW ;
		private ReqFacDatacenterForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqFacDatacenterForId.class, requiredParms, optionalParms );
		}

		public Datacenter get() throws Exception { 
			return super.get(Datacenter.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return Datacenter.class.
     */
    public static Class<Datacenter> retType() { return Datacenter.class; }

    /**
	 * Convert a string containing JSON into an instance of Datacenter.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.Datacenter.
	 */
	public static Datacenter fromJsonString( String json ) {
		return util.fromJsonString( Datacenter.class, json );
	}

	/**
	 * Returns a new instance of ReqFacDatacenterForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the datacenter of interest.
	 * @return hp.oneview.rest.Facilities.ReqFacDatacenterForId
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqFacDatacenterForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacDatacenterForId( conn, id );
		throw new HPOneViewApiVersionException( FacDatacenterForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
