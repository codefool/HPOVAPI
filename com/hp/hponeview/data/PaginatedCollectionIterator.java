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
*	An implementation of Iterator for an array.
*****************************************************************************/
package com.hp.hponeview.data;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic iterator for an array.
 * 
 * @author hesterg
 *
 * @param <T> The class of the array members.
 */
public class PaginatedCollectionIterator<T> implements Iterator<T> {
	private Integer __idx = 0;
	private T    [] __data;
	private Integer __size;
	
	/**
	 * Ctor for the iterator. Provide a reference to the array, and its size.
	 * @param data reference to the start of the array.
	 * @param size the number of members in the array.
	 */
	public PaginatedCollectionIterator(T [] data, Integer size)	{
		__data = data;
		__size = size;
	}

	/**
	 * Implementation of Iterator.hasNext
	 * @return true if Iterator.next will succeed, false otherwise.
	 */
	public final boolean hasNext() {
		return __idx < __size;
	}

	/**
	 * Implementation of Iterator.next
	 * @return the next member of the array.
	 * @throws NoSuchElementException if at the end of the array (use hasNext() to avoid this.)
	 */
	public final T next() throws NoSuchElementException {
		if( __idx >= __size )
			throw new NoSuchElementException();
		return __data[__idx++];
	}

	/**
	 * Implementation of Iterator.remove()
	 * @throws UnsupportedOperationException as this is not supported.
	 */
	public final void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
