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
package com.hp.hponeview.data.sans;

public class SanResponse {
	public String  Category;
	public String  Created;
	public String  DeviceManagerUri;
	public String  DeviceManagersUri;
	public String  DisplayName;
	public String  ETag;
	public String  EndpointsUri;
	public Boolean Imported;
	public Boolean IsInternal;
	public String  Modified;
	public String  Name;
	public Integer PortsFreeCount;
	public Integer PortsTotalCount;
	public String  PortsUri;
	public Integer PortsUsedCount;
	public String  PrincipleSwitch;
	public String  ProviderName;
	public Property [] PublicAttributes;
	public String  RefreshState;	// RefreshFailed | RefreshPending | Refreshing | Stable
	public String  RoutingId;
	public String  SanType;		// Fabric | Flat SAN
	public String  State;		// Deleting | Ready | Removing | Unknown | Zoning
	public String  Status;		// Critical | Ok | Unknown | Warning
	public Integer SwitchCount;
	public String  SwitchesUri;
	public String  Type;
	public String  Uri;
	public String  ZoneCount;
	public String  ZonesUri;
	public String  ZoningState;	// Open | Unknown | Zoned
}
