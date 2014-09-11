/*****************************************************************************
*
* copyright.txt
*
* Copyright 2013 Hewlett-Packard Development Company, L.P.
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
*
*****************************************************************************/
package com.hp.hponeview.data.settings;

public class Backup {
	public Number backupSize;
	public String backupStartTime;
	public String backupType;			// ON_DEMAND | UPLOADED
	public String category;
	public String compatibilityVersion;
	public String created;
	public String downloadStatus;		// DOWNLOAD_REQUESTED | NOT_DOWNLOADED
	public String downloadTime;
	public String downloadUri;
	public String downloadUserName;
	public String errorKey;
	public String errorMessage;
	public String [] errorParms;
	public String eTag;
	public String firmwareVersionMajor;
	public String firmwareVersionMinor;
	public String fullyQualifiedHostName;
	public String hardwareModel;
	public String hostName;
	public String id;
	public String modified;
	public Integer percentComplete;
	public String platformType;
	public String resolutionKey;
	public String resolutionMessage;
	public String [] resolutionParms;
	public String softwareVersion;
	public String status;		// CANCELED | CANCEL_IN_PROGRESS | FAILED | IN_PROGRESS | SUCCEEDED
	public String taskUri;
	public String type; 		// 'backup'
	public String uri;
	public String userName;
}
