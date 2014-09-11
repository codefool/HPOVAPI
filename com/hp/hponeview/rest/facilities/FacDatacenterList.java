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

import com.hp.hponeview.data.facilities.DatacenterList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacDatacenterList {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacDatacenterList.requiredParms; };
	public static final Integer optionalParms() { return ReqFacDatacenterList.optionalParms; };
	public static final String  _URI = "datacenters/";

	/**
	 * Implements /rest/datacenters/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/datacenters
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.facilities.DatacenterList
	 *
	 */
	public static class ReqFacDatacenterList extends HPOneViewRestRequest<FacDatacenterList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSCTQVFL; 
		private ReqFacDatacenterList( Connection conn ) {
			super( conn, _URI, FacDatacenterList.class, requiredParms, optionalParms );
		}

		public DatacenterList get() throws Exception { 
			return super.get(DatacenterList.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return DatacenterList.class.
     */
    public static Class<DatacenterList> retType() { return DatacenterList.class; }

    /**
	 * Convert a string containing JSON into an instance of DatacenterList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.DatacenterList.
	 */
	public static DatacenterList fromJsonString( String json ) {
		return util.fromJsonString( DatacenterList.class, json );
	}

	/**
	 * Returns a new instance of ReqFacDatacenterList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return hp.oneview.rest.Facilities.ReqFacDatacenterList
	 */
	public static ReqFacDatacenterList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacDatacenterList( conn );
		throw new HPOneViewApiVersionException( FacDatacenterList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
