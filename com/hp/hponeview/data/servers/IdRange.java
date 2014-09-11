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

public class IdRange {
	public String  allocatedFragmentUri;
	public Integer allocatedIdCount;
	public String  allocatorUri;
	public String  category;
	public String  collectorUri;
	public String  created;
	public Boolean defaultRange;
	public String  eTag;
	public Boolean enabled;
	public String  endAddress;
	public String  freeFragmentUri;
	public Integer freeIdCount;
	public String  modified;
	public String  name;
	public String  prefix;
	public String  rangeCategory;	// CUSTOM | GENERATED
	public Integer reservedIdCount;
	public String  startAddress;
	public Number  totalCount;
	public String  type; 			// 'Range'
	public String  uri;
}
