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
*	Implementation of the activity REST calls for HP OneView.
*****************************************************************************/
package com.hp.hponeview.data.sans;

import java.util.Iterator;

import com.hp.hponeview.data.PaginatedCollectionIterator;

public class DeviceManagerResponseList implements Iterable<DeviceManagerResponse> {
	public Integer Count;
	public String  FirstPageUri;
	public String  LastPageUri;
	public DeviceManagerResponse [] Members;
	public String  NextPageUri;
	public String  PrevPageUri;
	public Integer Start;
	public Integer Total; 	

	public Iterator<DeviceManagerResponse> iterator() {
		Iterator<DeviceManagerResponse> itr = new PaginatedCollectionIterator<DeviceManagerResponse>(Members,Members.length);
		return itr;
	}
}
