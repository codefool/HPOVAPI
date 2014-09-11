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
package com.hp.hponeview.data.settings;

public class License {
	public class Nodes {
		public String appliedDate;
		public String nodeId;
		public String nodeName;
		public String nodeUri;
	}
	
	public String [] additionalKeys;
	public Integer availableCapacity;
	public String  category;
	public String  created;
	public String  eon;
	public String  eTag;
	public String  key;
	public String  licenseType;	// Evaluation | Permanent | Unknown | Unlicensed
	public String  modified;
	public Nodes [] nodes;
	public String  product;
	public String  productDescription;
	public String  productNumber;
	public String  salesOrder;
	public Integer totalCapacity;
	public String  type; //'License'
	public String  uri;
}
