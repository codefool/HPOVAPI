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
*	A base class that fits *most* of the collections in the OneView data
*	structure catalog, that automatically provides an iterator on its 
*	member array. In the OneView docs this is generally referred to as
*	a PaginatedCollection. A typical example can be found here: 
*	http://xmldocs.fc.hp.com/help/cic/en/content/images/api/tasks.html#TaskResourcePaginatedCollectionV2
*****************************************************************************/
package com.hp.hponeview.data;

import java.util.Iterator;

/**
 * Base class for a paginated collection that is iterable and provides an Iterator
 * on its member array.
 * 
 * @author hesterg
 *
 * @param <T> The Class for the members array.
 */
public class PaginatedCollection<T> implements Iterable<T> {
	public String  category;
	public Integer count;
	public String  created;
	public String  eTag;
	public T []    members;
	public String  modified;
	public String  nextPageUri;
	public String  prevPageUri;
	public Integer start;
	public Integer total;
	public String  type;
	public String  uri;

	public Iterator<T> iterator() {
		Iterator<T> itr = new PaginatedCollectionIterator<T>(members,count);
		return itr;
	}
}
