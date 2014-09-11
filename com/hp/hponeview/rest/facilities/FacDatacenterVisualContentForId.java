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

import com.hp.hponeview.data.facilities.VisualContent;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class FacDatacenterVisualContentForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqFacDatacenterVisualContentForId.requiredParms; };
	public static final Integer optionalParms() { return ReqFacDatacenterVisualContentForId.optionalParms; };
	public static final String  _URI = "datacenters/%s/visualContent/";

  
	/**
	 * Implements /rest/datacenters/{id}/visualContent
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/datacenters.html#d4e333
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String ID of datacenter 
	 * @return com.hp.hponeview.data.facilities.VisualContent[]
	 *
	 */
	public static class ReqFacDatacenterVisualContentForId extends HPOneViewRestRequest<ReqFacDatacenterVisualContentForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PMETRIC ;
		private ReqFacDatacenterVisualContentForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqFacDatacenterVisualContentForId.class, requiredParms, optionalParms );
		}

		public VisualContent[] get() throws Exception { 
			return super.get( VisualContent[].class ); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return VisualContent.class.
     */
    public static Class<VisualContent> retType() { return VisualContent.class; }

    /**
	 * Convert a string containing JSON into an instance of VisualContent.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.facilities.VisualContent.
	 */
	public static VisualContent fromJsonString( String json ) {
		return util.fromJsonString( VisualContent.class, json );
	}

	/**
	 * Returns a new instance of ReqFacDatacenterVisualContentForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the URI of the datacenter of interest.
	 * @return hp.oneview.rest.Facilities.ReqFacDatacenterVisualContentForId
	 */
	public static ReqFacDatacenterVisualContentForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqFacDatacenterVisualContentForId( conn, id );
		throw new HPOneViewApiVersionException( FacDatacenterVisualContentForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
