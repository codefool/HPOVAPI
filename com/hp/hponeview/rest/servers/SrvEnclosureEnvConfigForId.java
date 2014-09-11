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

import com.hp.hponeview.data.EnvironmentalConfiguration;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class SrvEnclosureEnvConfigForId {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvEnclosureEnvConfigForId.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvEnclosureEnvConfigForId.optionalParms; };
	public static final String  _URI = "enclosures/%s/environmentalConfiguration/";

	/**
	 * Implements /rest/enclosures/{id}/environmentalConfiguraton/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/enclosures.html#d4e227
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the enclosure id of interest.
	 * @return com.hp.hponeview.data.servers.EnvironmentalConfiguration
	 */
	public static class ReqSrvEnclosureEnvConfigForId extends HPOneViewRestRequest<ReqSrvEnclosureEnvConfigForId> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqSrvEnclosureEnvConfigForId( Connection conn, String id ) {
			super( conn, String.format( _URI, id ), ReqSrvEnclosureEnvConfigForId.class, requiredParms, optionalParms );
		}

		public EnvironmentalConfiguration get() throws Exception { 
			return super.get(EnvironmentalConfiguration.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return EnvironmentalConfiguration.class.
     */
    public static Class<EnvironmentalConfiguration> retType() { return EnvironmentalConfiguration.class; }

    /**
	 * Convert a string containing JSON into an instance of EnvironmentalConfiguration.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.data.EnvironmentalConfiguration.
	 */
	public static EnvironmentalConfiguration fromJsonString( String json ) {
		return util.fromJsonString( EnvironmentalConfiguration.class, json );
	}

	/**
	 * Returns a new instance of ReqEnclosureActiveOaSsoUrlForId
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param id - String containing the certificate id of interest.
	 * @returns com.hp.hponeview.rest.servers.ReqEnclosureActiveOaSsoUrlForId
	 */
	public static ReqSrvEnclosureEnvConfigForId instance( Connection conn, String id ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvEnclosureEnvConfigForId( conn, id );
		throw new HPOneViewApiVersionException( SrvEnclosureEnvConfigForId.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
