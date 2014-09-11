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
package com.hp.hponeview.data.network.interconnects;

public class SubportStatistics {
	public class SubportCommonStatistics {
		public Integer portNumber;
		public Integer resetTimeEpoch;
		public Integer rfc1213IfInOctets;	
		public Integer rfc1213IfInUcastPkts;	
		public Integer rfc1213IfInNUcastPkts;	
		public Integer rfc1213IfOutOctets;	
		public Integer rfc1213IfOutUcastPkts;	
		public Integer rfc1213IfOutNUcastPkts;	
		public Integer rfc1757StatsOctets;	
		public Integer rfc1757StatsPkts;	
		public Integer subportNumber;
		public String  type; 	// 'SubportCommonStatistics'
	}

	public class SubportAdvancedStatistics {
		public Integer portNumber;
		public Integer subportNumber;
		public Integer resetTime;
		public Integer linkChanges;
		public String  receiveKilobitsPerSec;
		public String  transmitKilobitsPerSec;
		public String  receiveKilobytesPerSec;
		public String  transmitKilobytesPerSec;
		public String  receivePacketsPerSec;
		public String  transmitPacketsPerSec;
		public String  receiveNonunicastPacketsPerSec;
		public String  transmitNonunicastPacketsPerSec;
		public String  type; 	// 'SubportAdvancedStatistics'
	}
	
	public SubportAdvancedStatistics subportAdvancedStatistics;
	public SubportCommonStatistics   subportCommonStatistics;
	public Integer                   subportNumber;
	public String  					 type; 	// 'PortStatistics'
}
