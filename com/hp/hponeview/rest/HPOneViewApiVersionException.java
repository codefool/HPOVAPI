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
* 	Exception thrown when when an API call is attempted against an HP OneView 
* 	server that does not support the API level required.
*/ 
package com.hp.hponeview.rest;

public class HPOneViewApiVersionException extends HPOneViewException {
	static final long serialVersionUID = 1;
	public String  apiCallName;
	public Integer apiLevelRequired;
	public Integer apiLevelSupported;

	public HPOneViewApiVersionException( Integer apiLevelRequired, Integer apiLevelSupported ) {
		super( "This HP OneView server does not support the requested API Level " 
				+ "- Level requested:" + apiLevelRequired.toString() 
				+ " Level supported:" + apiLevelSupported.toString() );
		this.apiCallName 	   = "";
		this.apiLevelRequired  = apiLevelRequired;
		this.apiLevelSupported = apiLevelSupported;
	}

	public HPOneViewApiVersionException( String APICallName, Integer apiLevelRequired, Integer apiLevelSupported ) {
		super( "Level not supported for HP OneView API call '" + APICallName 
				+ "' - Level requested:" + apiLevelRequired.toString() 
				+ " Level supported:" + apiLevelSupported.toString() );
		this.apiCallName 	   = APICallName;
		this.apiLevelRequired  = apiLevelRequired;
		this.apiLevelSupported = apiLevelSupported;
	}
}
