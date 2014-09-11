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

import com.hp.hponeview.data.settings.TrapDestinationDto;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgTrapDestinationForId {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/trap-destinations/%s/";
	public static final Integer requiredParms() { return ReqStgTrapDestinationForId.requiredParms; };
	public static final Integer optionalParms() { return ReqStgTrapDestinationForId.optionalParms; };
	/**
	 * Implements /rest/appliance/trap-destinations/{id}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/trap-destinations
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the trap destination id.
	 * @return com.hp.hponeview.data.settings.TrapDestinationDto
	 */
	public static class ReqStgTrapDestinationForId extends HPOneViewRestRequest<ReqStgTrapDestinationForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgTrapDestinationForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqStgTrapDestinationForId.class, requiredParms, optionalParms );
		}

		public TrapDestinationDto get() throws Exception { 
			return super.get(TrapDestinationDto.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return TrapDestinationDto.class.
     */
    public static Class<TrapDestinationDto> retType() { return TrapDestinationDto.class; }

    /**
	 * Convert a string containing JSON into an instance of TrapDestination.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.TrapDestinationDto.
	 */
	public static TrapDestinationDto fromJsonString( String json ) {
		return util.fromJsonString( TrapDestinationDto.class, json );
	}

	/**
	 * Returns a new instance of ReqStgTrapDestinationForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the trap destination of interest.
	 * @returns com.hp.hponeview.rest.Settings.ApplianceTrapDestinationForId
	 */
	public static ReqStgTrapDestinationForId instance( Connection conn, String id )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgTrapDestinationForId( conn, id );
		throw new HPOneViewApiVersionException( StgTrapDestinationForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
