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
*	Java classes that mirror HP OneView 1.10 REST API version 101. Note that in
*   this version, only the REST API calls that use a GET verb are implemented.
*   Also note that calls from earlier versions of the API (i.e, 3 and 4) are
*   NOT supported.
*   
*   Each HP OneView REST request is encapsulated within its own class. The
*   "family" of requests are grouped into their own packages. The naming 
*   conventions for each of the families are:
*   
*   Activity	Act*	ActAlertForId
*	Facilities	Fac*	FacDatacenterForId
*	Network		Net*   	NetConnectionTemplateForId
*	FC-SANS		Sans*	SansManagedSanList
*	Security	Sec*	SecActiveUserSessionList
*	Search		Srch*	SrchAggTreeForUri
*	Servers		Srv*	SrvAvailableNetworkList
*	Settings	Stg*	StgApplianceStatus
*
*	Data structures are in their packages with corresponding names (e.g.
*	com.hp.hponeview.data.activity) but the classes will mirror the data
*	structure names shown in the API documentation.
*
*	Class names that contain the word "List" return a collection of some kind.
*	Class names that end with "ForId" indicate that an id parameter is required.
*	Multiple parameters are chained with "And" as in "*ForIdAndName" which 
*	indicates that both id and name parameters are required. Required parameters
*   are specified to the class constructor.
*
*	All classes are derived from HPOneViewRestRequest, and so may be passed
*	polymorphically. The methods of HPOneViewRestRequest allow for reflection
*	and interrogation of the underlying derived class.
*
*	All request class constructors are private, and must be created via the 
*	instance() method of the wrapper class:
*
*		ReqActAlertForId obj = ActAlertForId.instance("12345");
*
*	The classes are designed to allow for chaining of calls:
*
*		AlertResourceV2 rsc = 
*			ActAlertForId.instance("12345").setParameter( "view", "expand" ).get();
*
*	The user should refer to the  HP OneView API documentation when using these
*	calls, as in many cases there are several optional parameters that can be set. 
*	These are provided by the HPOneViewRestRequest class, and can be chained:
*
*		AlertResourceV2 obj = ActAlertForId.instance("123456").setView("viewName").get();
*
*	Some API calls have optional parameters, which can be discovered programmatically
*	by interrogating the class and using methods through HPOneViewRestRequest. Each
*	API class has two static data members: optionalParms and requiredParms. By passing
*	this value (or both binary OR'd together) to the getParameterList() method of
*	HPOneViewRestRequest, the list of parameter information can be returned: 
*
* 		List<HPOneViewRestRequest.ParameterInfo> x = 
* 			HPOneViewRestRequest.getParameterList( ActAlertForId.optionalParms );
* 
*	Any REST object can return the response as a JSON string for storage and later manipulation.
*		String json = ActAlertForId.instance("12345").getAsJsonString();
*
*	The JSON string can be converted to the target data structure using the static 
*	method fromJsonString():
*		AlertResourceV2 obj = ActAlertForId.fromJsonString( json );
*
*	Alternatively, the util package contains the static method fromJsonString to convert a JSON 
*	string to a data structure:
*		AlertResourceV2 obj = util.fromJsonString( AlertResourceV2.class, json );
*
*	A data structure object can be converted to JSON using the static method 
*	rest.util.toJsonString():
*		String json = util.toJsonString( obj );
*		AlertResourceV2 obj1 = util.fromJsonString( AlertResourceV2.class, json );
*
*	Hence:
*		AlertResourceV2 obj2 = 
*			util.fromJsonString( AlertResourceV2.class, util.toJsonString( obj ) );
*	and:
*		AlertResourceV2 obj2 = ActAlertForId.fromJsonString( util.toJsonString( obj ) );
*
*	are tautological.
*
*	The return type of any call can be obtained by using the retType() method:
*
*		Class<?> xxx = ActAlertForId.retType();
*
*	The return type of a given call may be different depending on the API version.
*	This is due to the practice of the API authors changing the underlying data 
*	structures for a call, but not giving a new call. In these cases, the API
*	version must be supplied to retType():
*
*	Class<?> xxx = ActAlertForId.retType( conn.APIVersion() );
*
*	Also, these classes behave differently for the general interface. 
*	* The get() method returns Object instead of a specific type, so it will need
*	  to be casted to the specific return type:
*		AlertResourceV2 obj2 = (AlertResourceV2)ActAlertForId.instance(conn,"1").get();
*   * Additional get methods to return the specific type are provided:
*   	AlertResourceV2 obj2 = ActAlertForId.instance(conn,"1").getAsAlertResourceV2();
*   * The fromJsonString() also returns Object.
*
* Exceptions
* ==========
* The top-level exception class is HPOneViewException and is derived from 
* java.lang.Exception. It is intended as the general case exception, with more 
* specialized exceptions derived from it.
* 
*  java.lang.Exception
*  - com.hp.hponeview.rest.HPOneViewException
*    - com.hp.hponeview.rest.HPOneViewApiParmException
*    - com.hp.hponeview.rest.HPOneViewApiVersionException
*    - com.hp.hponeview.rest.HPOneViewNotConnectedException
*    - com.hp.hponeview.rest.HPOneViewRestException
*
*****************************************************************************/
package com.hp.hponeview.rest;
