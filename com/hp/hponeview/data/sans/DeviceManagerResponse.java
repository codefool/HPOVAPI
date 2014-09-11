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
package com.hp.hponeview.data.sans;

public class DeviceManagerResponse {
	public String  Category;
	public Property [] ConnectionInfo;
	public String  DeviceManagerUri;
	public String  DeviceManagerVersion;
	public String  ETag;
	public String  IsInternal;
	public String  ManagedSansUri;
	public String  Modified;
	public String  Name;
	public String  ProviderDisplayName;
	public String  ProciverUri;
	public String  RefreshState;	// RefreshFailed | RefreshPending | Refreshing | Stable
	public String  State;			// Deleting | Ready | Removing | Unknown | Zoning
	public String  Status;			// Critical | Ok | Unknown | Warning
	public String  Type;
	public String  UnimportedSansUri;
	public String  Uri;
}
