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
package com.hp.hponeview.rest.network;

import com.hp.hponeview.data.network.logical_interconnects.InterconnectSettingsV2;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class NetLogicalInterconnectGroupDefaultSettings {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqNetLogicalInterconnectGroupDefaultSettings.requiredParms; };
	public static final Integer optionalParms() { return ReqNetLogicalInterconnectGroupDefaultSettings.optionalParms; };
	public static final String  _URI = "logical-interconnect-groups/defaultSettings/";

	/**
	 * Implements /rest/logical-interconnect-groups/defaultSettings/
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/logical-interconnect-groups.html#d4e110
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.network.logical_interconnects.InterconnectSettingsV2
	 *
	 */
	public static class ReqNetLogicalInterconnectGroupDefaultSettings extends HPOneViewRestRequest<ReqNetLogicalInterconnectGroupDefaultSettings> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqNetLogicalInterconnectGroupDefaultSettings( Connection conn ) {
			super( conn, _URI, ReqNetLogicalInterconnectGroupDefaultSettings.class, requiredParms, optionalParms  );
		}

		public InterconnectSettingsV2 get() throws Exception { 
			return super.get(InterconnectSettingsV2.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return InterconnectSettingsV2.class.
     */
    public static Class<InterconnectSettingsV2> retType() { return InterconnectSettingsV2.class; }

    /**
	 * Convert a string containing JSON into an instance of InterconnectSettingsV2.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.logical_interconnects.InterconnectSettingsV2.
	 */
	public static InterconnectSettingsV2 fromJsonString( String json ) {
		return util.fromJsonString( InterconnectSettingsV2.class, json );
	}

	/**
	 * Returns a new instance of ReqNetLogicalInterconnectGroupDefaultSettings
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @returns com.hp.hponeview.rest.network.ReqNetLogicalInterconnectGroupDefaultSettings
	 */
	public static ReqNetLogicalInterconnectGroupDefaultSettings instance( Connection conn )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqNetLogicalInterconnectGroupDefaultSettings( conn );
		throw new HPOneViewApiVersionException( NetLogicalInterconnectGroupDefaultSettings.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
