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
package com.hp.hponeview.data.storage;

import com.hp.hponeview.data.storage.StoragePool;
import com.hp.hponeview.data.storage.StorageTargetPort;

public class StorageSystem {
	public class StorageSystemCredentials {
		public String ip_hostname;
		public String password;
		public String username;
	}
	public String allocatedCapacity;
	public String category;
	public String created;
	public StorageSystemCredentials credentials;
	public String description;
	public String displayname;
	public String eTag;
	public String firmware;
	public String FreeCapacity;
	public String managedDomain;
	public StoragePool [] managedPools;
	public StorageTargetPort managedPorts;
	public String model;
	public String modified;
	public String name;
	public String refreshState;
	public String serialNumber;
	public String state;
	public String stateReason;
	public String status;
	public String totalCapcity;
	public String type;
	public String [] unmanagedDomains;
	public StoragePool [] unmanagedPools;
	public StorageTargetPort [] unmanagedPorts;
	public String uri;
	public String wwn;
}
