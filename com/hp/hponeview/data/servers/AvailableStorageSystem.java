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
package com.hp.hponeview.data.servers;

public class AvailableStorageSystem {
	public class AvailableStorageVolume {
		public String  capacityBytes;
		public Boolean isShareable;
		public String  poolName;
		public String  poolUri;
		public String  provisionType;
		public String  raidLevel;
		public String  volumeName;
		public String  volumeUri;
	}
	public String [] connections;
	public String  storageSystemName;
	public String  storageSystemUri;
	public AvailableStorageVolume [] volumes;
}
