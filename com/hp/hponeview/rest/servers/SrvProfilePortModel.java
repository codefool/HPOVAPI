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

import com.hp.hponeview.data.servers.ProfilePortModelV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

/**
 * Implements /rest/server-profiles/profile-ports/
 * @author hesterg
 * @link http://xmldocs.fc.hp.com/rest/api/server-profiles.html#d4e317
 * @return com.hp.hponeview.data.servers.ProfilePortModelV2
 * 
 * methods:
 * setServerHardwareUri		String	Optional
 * setServerHardwareTypeUri	String	Optional
 * setEnclosureGroupUri		String	Optional
 *
 */
public class SrvProfilePortModel {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqSrvProfilePortModel.requiredParms; };
	public static final Integer optionalParms() { return ReqSrvProfilePortModel.optionalParms; };
	public static final String  _URI = "server-profiles/profile-ports/";

	/**
	 * Implements /rest/server-profiles/profile-ports/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/server-profiles.html#d4e317
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.servers.ProfilePortModelV2
	 */
	public static class ReqSrvProfilePortModel extends HPOneViewRestRequest<ReqSrvProfilePortModel> {
		public static final Integer requiredParms = PSRVHWURI | PSRVHWTYPURI | PENCGRPURI;
		public static final Integer optionalParms = PNONE;
		private ReqSrvProfilePortModel( Connection conn ) {
			super( conn, _URI, ReqSrvProfilePortModel.class, requiredParms, optionalParms );
		}

		public ProfilePortModelV2 get() throws Exception { 
			return super.get(ProfilePortModelV2.class); 
		}
	}

    /**
     * Return the Class object for the return type for this REST call.
     * @return ProfilePortModelV2.class.
     */
    public static Class<ProfilePortModelV2> retType() { return ProfilePortModelV2.class; }

    /**
	 * Convert a string containing JSON into an instance of ProfilePortModelV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.servers.ProfilePortModelV2.
	 */
	public static ProfilePortModelV2 fromJsonString( String json ) {
		return util.fromJsonString( ProfilePortModelV2.class, json );
	}

	/**
	 * Returns a new instance of ReqSrvProfilePortModel
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.servers.ReqSrvProfilePortModel
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqSrvProfilePortModel instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqSrvProfilePortModel( conn );
		throw new HPOneViewApiVersionException( SrvProfilePortModel.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
