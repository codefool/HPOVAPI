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

import com.hp.hponeview.data.settings.NodeVersionDto;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class StgNodeInfoVersion {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/nodeinfo/version/";
	public static final Integer requiredParms() { return ReqStgNodeInfoVersion.requiredParms; };
	public static final Integer optionalParms() { return ReqStgNodeInfoVersion.optionalParms; };
	/**
	 * Implements /rest/appliance/nodeinfo/version/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/nodeinfo
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.NodeVersion
	 */
	public static class ReqStgNodeInfoVersion extends HPOneViewRestRequest<ReqStgNodeInfoVersion> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgNodeInfoVersion( Connection conn ) {
			super( conn, _URI, ReqStgNodeInfoVersion.class, requiredParms, optionalParms );
		}

		public NodeVersionDto get() throws Exception { 
			return super.get(NodeVersionDto.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NodeVersion.class.
     */
    public static Class<NodeVersionDto> retType() { return NodeVersionDto.class; }

    /**
	 * Convert a string containing JSON into an instance of NodeVersion.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.NodeVersion.
	 */
	public static NodeVersionDto fromJsonString( String json ) {
		return util.fromJsonString( NodeVersionDto.class, json );
	}

	/**
	 * Returns a new instance of ReqStgNodeInfoVersion
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgNodeInfoVersion
	 */
	public static ReqStgNodeInfoVersion instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgNodeInfoVersion( conn );
		throw new HPOneViewApiVersionException( StgNodeInfoVersion.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
