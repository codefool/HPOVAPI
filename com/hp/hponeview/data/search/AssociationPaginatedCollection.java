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
package com.hp.hponeview.data.search;

import java.util.Iterator;

import com.hp.hponeview.data.PaginatedCollectionIterator;

public class AssociationPaginatedCollection implements Iterable<IndexResourceAssociation> {
	public Integer count;
	public IndexResourceAssociation [] members;
	public String  nextPageUri;
	public String  prevPageUri;
	public Integer start;
	public Integer total;
	public Integer unFilteredTotal;

	public Iterator<IndexResourceAssociation> iterator() {
		Iterator<IndexResourceAssociation> itr = new PaginatedCollectionIterator<IndexResourceAssociation>(members,count);
		return itr;
	}
}
