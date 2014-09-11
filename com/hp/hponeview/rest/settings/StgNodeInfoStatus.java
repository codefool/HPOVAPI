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

import com.hp.hponeview.data.settings.NodeStatusDto;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;

public class StgNodeInfoStatus {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "appliance/nodeinfo/status/";
	public static final Integer requiredParms() { return ReqStgNodeInfoStatus.requiredParms; };
	public static final Integer optionalParms() { return ReqStgNodeInfoStatus.optionalParms; };
	/**
	 * Implements /rest/appliance/nodeinfo/status/
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/nodeinfo
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.settings.NodeStatus
	 */
	public static class ReqStgNodeInfoStatus extends HPOneViewRestRequest<ReqStgNodeInfoStatus> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgNodeInfoStatus( Connection conn ) {
			super( conn, _URI, ReqStgNodeInfoStatus.class, requiredParms, optionalParms );
		}

		public NodeStatusDto get() throws Exception { 
			return super.get(NodeStatusDto.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return NodeStatus.class.
     */
    public static Class<NodeStatusDto> retType() { return NodeStatusDto.class; }

    /**
	 * Convert a string containing JSON into an instance of NodeStatus.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.settings.NodeStatus.
	 */
	public static NodeStatusDto fromJsonString( String json ) {
		return util.fromJsonString( NodeStatusDto.class, json );
	}

	/**
	 * Returns a new instance of ReqStgNodeInfoStatus
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.Settings.ReqStgNodeInfoStatus
	 */
	public static ReqStgNodeInfoStatus instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgNodeInfoStatus( conn );
		throw new HPOneViewApiVersionException( StgNodeInfoStatus.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
