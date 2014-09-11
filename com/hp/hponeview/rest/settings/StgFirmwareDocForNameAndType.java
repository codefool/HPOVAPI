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

import com.hp.hponeview.rest.HPOneViewApiVersionException;
import com.hp.hponeview.rest.HPOneViewRestRequest;
import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.util;

public class StgFirmwareDocForNameAndType {
	public static final Integer _MINAPIVERSION = 101;
    public static final String  _URI =  "firmware/document-content/%s/%s/";
	public static final Integer requiredParms() { return ReqStgFirmwareDocumentForNameAndType.requiredParms; };
	public static final Integer optionalParms() { return ReqStgFirmwareDocumentForNameAndType.optionalParms; };
	/**
	 * Implements /rest/firmware/document-content/{tarfile}.{suffix}/{documentType}
	 * @author hesterg
	 * @link http://apidocs.vse.adapps.hp.com/fusion/101/public/#rest/appliance/firmware
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param fileName - String containing the name of the TAR file.
	 * @param docType - String containing the document type (e.g. release)
	 * @return String
	 */
	public static class ReqStgFirmwareDocumentForNameAndType extends HPOneViewRestRequest<ReqStgFirmwareDocumentForNameAndType> {
		public static final Integer requiredParms = PNONE;
		public static final Integer optionalParms = PNONE;
		private ReqStgFirmwareDocumentForNameAndType( Connection conn, String fileName, String docType ) {
			super( conn, String.format( _URI, fileName, docType ), ReqStgFirmwareDocumentForNameAndType.class, requiredParms, optionalParms );
		}

		public String get() throws Exception { 
			return super.get(String.class); 
		}
	}
    /**
     * Return the Class object for the return type for this REST call.
     * @return String.class.
     */
    public static Class<String> retType() { return String.class; }

    /**
	 * Convert a string containing JSON into an instance of String.
	 * @param json - String containing JSON
	 * @return String.
	 */
	public static String fromJsonString( String json ) {
		return util.fromJsonString( String.class, json );
	}

	/**
	 * Returns a new instance of ReqStgFirmwareDocumentForNameAndType
	 * @param conn - com.hp.hponeview.rest.Connection object for the HP OneView server
	 * @param fileName - String containing the name of the TAR file.
	 * @param docType - String containing the document type (e.g. release)
	 * @returns com.hp.hponeview.rest.Settings.ReqStgFirmwareDocumentForNameAndType
	 */
	public static ReqStgFirmwareDocumentForNameAndType instance( Connection conn, String fileName, String docType )  throws HPOneViewApiVersionException {
		if( conn.isValidAPICall( _MINAPIVERSION ) )
			return new ReqStgFirmwareDocumentForNameAndType( conn, fileName, docType );
		throw new HPOneViewApiVersionException( StgFirmwareDocForNameAndType.class.getName(), _MINAPIVERSION, conn.HpOneViewAPIVersion() );
	}
}
