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

public class StorageVolume {
	public String allocatedCapacity;
	public String category;
	public String created;
	public String description;
	public String deviceType;
	public String deviceVolumeName;
	public String eTag;
	public String modified;
	public String name;
	public String provisionType;
	public String provisionedCapacity;
	public String raidLevel;
	public String refreshState;
	public Boolean shareable;
	public String state;
	public String stateReason;
	public String status;
	public String storagePoolUri;
	public String storageSystemUri;
	public String type; // "StorageVolume"
	public String uri;
	public String uuid;
	public String wwn;
}
