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
*
*****************************************************************************/
package com.hp.hponeview.data.activity;

import com.hp.hponeview.data.PaginatedCollection;

public class AlertResourceCollectionV2 extends PaginatedCollection<AlertResourceV2> {
	public class AlertCountsV2 {
		public Integer criticalCount;
		public Integer disabledCount;
		public Integer okCount;
		public Integer unknownCount;
		public Integer warningCount;
	}
	
	public AlertCountsV2 alertSeverityCounts;
}

