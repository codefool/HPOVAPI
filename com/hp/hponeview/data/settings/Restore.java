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

public class Restore {
	public String backupIdToRestore;
	public String category;
	public String created;
	public String errorKey;
	public String errorMessage;
	public String [] errorParms;
	public String eTag;
	public String fullyQualifiedHostName;
	public String hostName;
	public String id;
	public String modified;
	public Integer percentComplete;
	public String progressStep;	// COMPLETED | FAILED | PREPARING_TO_RESTORE | RESTORING_FILES | STARTING_SERVICES | UNKNOWN
	public String resolutionKey;
	public String resolutionMessage;
	public String [] resolutionParms;
	public String restoreStartTime;
	public String status;		// FAILED | IN_PROGRESS | NOT_STARTED | SUCCEEDED | UNKNOWN
	public String type; 		//'RESTORE'
	public String uri;
	public String uriOfBackupToRestore;
	public String userName;
}
