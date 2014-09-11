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
* Description:
* 	Base class for all HPOneViewApi exceptions.
*/ 
package com.hp.hponeview.rest;
public class HPOneViewException extends Exception {
	static final long serialVersionUID = 1;
	
	public HPOneViewException() {
		super();
	}

	public HPOneViewException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public HPOneViewException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public HPOneViewException(String arg0) {
		super(arg0);
	}

	public HPOneViewException(Throwable arg0) {
		super(arg0);
	}
}
