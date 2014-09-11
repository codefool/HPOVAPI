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
package com.hp.hponeview.rest.activity;

import com.hp.hponeview.data.activity.AuditLogList;
import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class ActAuditLogs {
	public static final Integer _MINAPIVERSION = 101;
	public static final Integer requiredParms() { return ReqActAuditLogs.requiredParms; };
	public static final Integer optionalParms() { return ReqActAuditLogs.optionalParms; };
	public static final String  _URI = "audit-logs/";

	/**
	 * Implements /rest/audit-logs
	 * @author hesterg
	 * @link http://xmldocs.fc.hp.com/help/cic/en/content/images/api/audit-logs.html#d4e1
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @return com.hp.hponeview.data.activity.AuditLogCollection
	 */
	public static class ReqActAuditLogs extends HPOneViewRestRequest<ReqActAuditLogs> {
	    public static final Integer requiredParms = PNONE;
	    public static final Integer optionalParms = PSCTL;
		private ReqActAuditLogs( Connection conn ) {
			super( conn, _URI, ReqActAuditLogs.class, requiredParms, optionalParms );
		}

		public AuditLogList get() throws Exception { 
			return super.get( AuditLogList.class ); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return AuditLogCollection.class.
     */
    public static Class<AuditLogList> retType() { return AuditLogList.class; }

    /**
	 * Convert a string containing JSON into an instance of AuditLogCollection.
	 * @param json - String containing JSON
	 * @return com.hp.hponeview.data.activity.AuditLogCollection.
	 */
	public static AuditLogList fromJsonString( String json ) {
		return util.fromJsonString( AuditLogList.class, json );
	}

	/**
	 * Returns a new instance of ReqActAuditLogs
	 * @param conn Connection object to HP OneView server
	 * @return com.hp.hponeview.rest.activity.ActAuditLogs.ReqActAuditLogs
	 * @throws HPOneViewApiVersionException
	 */
	public static ReqActAuditLogs instance( Connection conn ) throws HPOneViewApiVersionException {
		if( conn.isValidAPICall(_MINAPIVERSION))
			return new ReqActAuditLogs( conn );
		throw new HPOneViewApiVersionException( ActAuditLogs.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
