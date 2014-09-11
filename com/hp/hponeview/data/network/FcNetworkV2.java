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
package com.hp.hponeview.data.network;

public class FcNetworkV2 {
	public Boolean autoLoginRedistribution;
	public String  category;
	public String  connectionTemplateUri;
	public String  created;
	public String  description;
	public String  eTag;
	public String  fabricType;	// DirectAttach | FabricAttach
	public Integer linkStabilityTime;
	public String  managedSanUri;
	public String  modified;
	public String  name;
	public String  state;
	public String  status;		// OK | Disabled | Warning | Critical | Unknown
	public String  type; 		//'fc-networkV2'
	public String  uri;
}
