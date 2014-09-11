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

public class InterconnectTypeV2 {
	public class PortInfoV2  {
		public Boolean downlinkCapable;
		public String  pairedPortName;
		public String [] portCapability;	// EnetFcoe | Ethernet | FibreChannel | Unknown
		public String  portName;
		public Integer portNumber;
		public Boolean uplinkCapable;
	}

	public String  category;
	public String  created;
	public String  description;
	public String [] downlinkCapabilities;	// Ethernet | FCoE | FibreChannel | Flex10_4SubPort | Flex20_4SubPort 
											// NotApplicable | PortExtender | Unknown
	public Integer downLinkCount;
	public String  eTag;
	public String  maximumFirmwareVersion;
	public String  minimumFirmwareVersion;
	public String  modified;
	public String  name;
	public String  partNumber;
	public PortInfoV2 [] portInfos;
	public String  state;
	public String  status;			// OK | Disabled | Warning | Critical | Unknown
	public String  type;			//	'interconnect'
	public String [] unsupportedCapabilities; // 'BladeSystem_C7000_ | Unknown | G1
	public String  uri;
}
