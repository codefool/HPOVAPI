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
*	Various utilities for use with REST calls.
*****************************************************************************/
package com.hp.hponeview.rest;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class util {
	static Logger logger = Logger.getLogger( util.class );
	
	/**
	 * Convert a string containing JSON into an object of the indicated class S.
	 * @usage ABigClass ret = util.fromJsonString( ABigClass.class, json );
	 * @param S - Class object of the return data type.
	 * @return An instant of class S, filled in by GSON.
	 */
	public static <S> S fromJsonString(Class<S> type, String json) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// see if this JSON object decodes as a RestError
			return gson.fromJson(json, type);
		}
		catch( JsonSyntaxException e) {
			logger.error( e );
		}
		catch( java.lang.NullPointerException e) {
		}
		return null;
	}
	
	public static String toJsonString( Object obj ) {
		try {
			Gson gson = new Gson();
			return gson.toJson( obj );
		}
		catch( JsonSyntaxException e) {
			logger.error( e );
		}
		catch( java.lang.NullPointerException e) {
		}
		return null;
	}
}
