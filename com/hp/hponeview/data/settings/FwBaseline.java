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

public class FwBaseline {
	public class FwComponent {
		public String  componentVersion;
		public String  fileName;
		public String  name;
		public String [] swKeyNameList;
	}
	
	public String  baselineShortName;
	public Integer bundleSize;
	public String  category;
	public String  created;
	public String  description;
	public String  eTag;
	public FwComponent [] fwComponents;
	public String  isoFileName;
	public String  lastTaskUri;
	public String  modified;
	public String  name;
	public String  releaseDate;
	public String  resourceId;
	public String  state;
	public String  status;
	public String  supportedLanguages;
	public String [] supportedOSList;
	public String  swPackagesFullPath;
	public String  type;			// 'firmware-baselines'
	public String  uri;
	public String  version;
	public String  xmlKeyName;
}
