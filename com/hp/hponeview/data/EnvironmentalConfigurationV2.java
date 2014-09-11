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
package com.hp.hponeview.data;

public class EnvironmentalConfigurationV2 {
	public class PsuConfigurationData {
		public Integer capacity;
		public Integer inputVoltage;
		public String  powerType;	// AC | DC 
		public Integer psuId;
		public String  side;		// A | B
	}
	
	public Integer calibratedMaxPower;
	public Boolean capHistorySupported;
	public Integer height;
	public Integer historyBufferSize;
	public Integer historySampleIntervalSeconds;
	public Integer idleMaxPower;
	public String  licenseRequirement;	// OneView | iLOAdvanced
	public String  powerCapType;		// Electrical | None | Thermal
	public Boolean powerHistorySupported;	
	public PsuConfigurationData [] psuList;
	public String  rackId;
	public String  rackModel;
	public String  rackName;
	public String  rackUHeight;
	public Integer relativeOrder;
	public Boolean thermalHistorySupported;
	public Integer uSlot;
	public Boolean utilizationHistorySupported;
}
