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
package com.hp.hponeview.data.network.logical_interconnects;

public class TelemetryConfiguration 
{
	public String  category;
	public String  created;
	public String  description;
	public Boolean enableTelemetry;
	public String  eTag;
	public String  modified;
	public String  name;
	public Integer sampleCount;
	public Integer sampleInterval;
	public String  state;
	public String  status;	// OK | Disabled | Warning | Critical | Unknown
	public String  type;	// 'telemetry-configuration'
	public String  uri;
}
