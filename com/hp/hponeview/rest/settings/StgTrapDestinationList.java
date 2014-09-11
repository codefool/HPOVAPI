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
package com.hp.hponeview.rest.settings;

import com.hp.hponeview.data.settings.TrapDestinationCollectionDto;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgTrapDestinationList {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/trap-destinations/";
	public static final Integer requiredParms() { return ReqStgTrapDestinationList.requiredParms; };
	public static final Integer optionalParms() { return ReqStgTrapDestinationList.optionalParms; };
	/**
	 * Implements /rest/appliance/trap-destinations/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/trap-destinations
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.TrapDestinationCollectionDto
	 */
	public static class ReqStgTrapDestinationList extends HPOneViewRestRequest<ReqStgTrapDestinationList> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PSTART | PCOUNT | PSORT | PQUERY | PFIELDS;
		private ReqStgTrapDestinationList( Connection conn ) {
			super( conn, _URI, ReqStgTrapDestinationList.class, requiredParms, optionalParms );
		}

		public TrapDestinationCollectionDto get() throws Exception { 
			return super.get(TrapDestinationCollectionDto.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return TrapDestinationCollectionDto.class.
     */
    public static Class<TrapDestinationCollectionDto> retType() { return TrapDestinationCollectionDto.class; }

    /**
	 * Convert a string containing JSON into an instance of TrapDestinationList.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.TrapDestinationCollectionDto.
	 */
	public static TrapDestinationCollectionDto fromJsonString( String json ) {
		return util.fromJsonString( TrapDestinationCollectionDto.class, json );
	}

	/**
	 * Returns a new instance of ReqStgTrapDestinationList
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.settings.ReqStgTrapDestinationList
	 */
	public static ReqStgTrapDestinationList instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgTrapDestinationList( conn );
		throw new HPOneViewApiVersionException( StgTrapDestinationList.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
