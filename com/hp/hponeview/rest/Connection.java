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
*/ 
package com.hp.hponeview.rest;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.net.URI;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.hp.hponeview.data.security.Credential;
import com.hp.hponeview.data.settings.ApiVersion;

import com.hp.hponeview.rest.settings.StgVersion;
import com.hp.hponeview.rest.HPOneViewApiVersionException;

public class Connection 
{
	static Logger logger = Logger.getLogger(Connection.class);
	static {
		logger.setLevel(Level.INFO);
	}

	private CloseableHttpClient	httpClient;
	private String 				ipAddr;
	private Integer				port;
	private Credential  		creds;
	private String 				token;
	private ApiVersion			version;
	private Integer				requestedAPIVersion;
	private String				acceptLanguage;
	private Boolean				isOpen;
	
	/**
	 * Constructor 
	 * @param ipAddr - String containing the IP address of the HP OneView server
	 * @param user - User Id
	 * @param psw - Password
	 */
	public Connection( String ipAddr, String user, String psw ) {
		this(ipAddr, -1, user, psw );
	}
	
	/**
	 * Constructor 
	 * @param ipAddr - String containing the IP address of the HP OneView server
	 * @param port - Port number of the HP OneView server
	 * @param user - User Id
	 * @param psw - Password
	 */
	public Connection( String ipAddr, Integer port, String user, String psw ) {
		this.ipAddr = ipAddr;
		this.port   = port;
		this.version = new ApiVersion( 101, 101 );
		this.requestedAPIVersion = 101;
		this.acceptLanguage = "en-US";
		this.isOpen = false;
				
		creds = new Credential( user, psw );
		httpClient  = HttpClientBuilder.create().build();
		try {
			//:FIXME this should perform actual SSL certificate authentication
			X509TrustManager trustAllCerts = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {}
				public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {}
				public X509Certificate[] getAcceptedIssuers() { return null; } 
			}; 
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[]{trustAllCerts}, null); 
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			httpClient = HttpClients.custom()
	                   .setSSLSocketFactory(sslsf)
	                   .build();
		} 
		catch (Exception ex) { 
			ex.printStackTrace(); 
		} 
	}
	
	/**
	 * Return the server address and port number
	 * @return String containing <address>:<port>
	 */
	public String serverAddr() {
		if( port == -1 )
			return ipAddr;
		return ipAddr + ":" + Integer.toString( port );
	}
	
	/**
	 * Sets the accept language code for the connection. No validation is performed.
	 * @param code - String containing the new language code. 
	 * @return String containing the prior language code.
	 */
	public String setLanguageCode( String code ) {
		String tmp = acceptLanguage;
		acceptLanguage = code;
		return tmp;
	}

	/**
	 * Open the connection to the HP OneView server
	 * @return True if connection was successful, False otherwise
	 * @throws Exception
	 * @throws HPOneViewApiVersionException
	 */
	public boolean open() throws Exception, HPOneViewApiVersionException {
		return open( -1 );
	}

	/**
	 * Open the connection to the HP OneView server
	 * @param desiredApiVersion - The desired API level of the connection.
	 * @return True if connection was successful, False otherwise
	 * @throws Exception 
	 * @throws HPOneViewApiVersionException if the desiredApiVersion is not supported by 
	 * 		   the OneView server.
	 */
	public boolean open( Integer desiredApiVersion ) throws Exception, HPOneViewApiVersionException {
		if( logger.isInfoEnabled()) logger.info("Opening HP OneView connection");
		if( isOpen )
			close();
		isOpen = true;	// lie - we need post() to complete
		JsonObject jobj = post( "login-sessions", creds);
		isOpen = false;
		if( jobj != null ) {
			isOpen = true;
	      	token = jobj.get("sessionID").toString().replace("\"", "");
			version = StgVersion.instance( this ).get();
			if( -1 == desiredApiVersion ) {
				this.requestedAPIVersion = version.currentVersion;
			} else {
				if( desiredApiVersion < version.minimumVersion || desiredApiVersion > version.currentVersion )
						throw new HPOneViewApiVersionException( desiredApiVersion, version.currentVersion );
				this.requestedAPIVersion = desiredApiVersion;
			}
		}
		return isOpen;
	}
	
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * Close the connection to the HP OneView server. 
	 */
	public void close() {
		if( logger.isInfoEnabled()) logger.info("Closing HP OneView connection");
		try{ delete( "login-sessions" ); } catch( Exception e ) { logger.info( e ); }
        token = null;
        isOpen = false;
	}
	
	/**
	 * Validate whether the API version passed in is compatible with this connection.
	 * @param ver - the current API version level desired.
	 * @return True if connection supports the API version requested, False otherwise.
	 */
	public boolean isValidAPICall( Integer ver ) {
		return ver >= version.minimumVersion && ver <= version.currentVersion && ver <= requestedAPIVersion;
	}
	
	/**
	 * Return the user-specified API level. This will be the OneView currentVersion 
	 * if not specified in open().
	 */
	public Integer APIVersion() {
		return this.requestedAPIVersion;
	}

	/**
	 * Return the HP OneView server API version information.
	 * @return Integer of the current API version support level.
	 */
	public Integer HpOneViewAPIVersion() {
		return version.currentVersion;
	}

	/**
	 * Set the HTTP 'X-API-Version' request header.
	 * @param req - An HttpRequestBase object to modify.
	 */
	public void setHPOneViewAPIVersion( HttpRequestBase req ) {
        req.setHeader("X-API-Version", requestedAPIVersion.toString() );
	}
	
	/**
	 * Set the acceptable language header
	 * @param req - An HttpRequestBase object to modify
	 */
	public void setAcceptLanguage( HttpRequestBase req ) {
		req.setHeader( "Accept-language", acceptLanguage );
	}
	
	/**
	 * Sets optional headers for the HTTP request
	 * @param headers - Map<String,String> containing the header key/value pairs.
	 * @return this.
	 */
	public Connection setHeaders( HttpRequestBase req, Map<String,String> headers ) {
		for( Map.Entry<String,String> entry : headers.entrySet() ) {
			req.setHeader( entry.getKey(), entry.getValue() );
		}
		return this;
	}
	
	/**
	 * Issue a HTTP GET request to the HP OneView server with no IfNoneMatchValue.
	 * @param path - String containing the HP OneView REST request to GET. This value is
	 * 				 appended to https://<server>:<port>/rest/ to form the full URI of the request.
	 * 				 e.q., a path of 'bogus' results in https://<server>:<port>/rest/bogus being sent
	 * 				 to the HP OneView server with a GET verb.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 * @return a JsonObject with the response.
	 */
	public JsonObject get( String path ) throws HPOneViewNotConnectedException {
		return get( path, null );
	}

	/**
	 * Issue a HTTP GET request to the HP OneView server.
	 * @param path - String containing the HP OneView REST request to GET. This value is
	 * 				 appended to https://<server>:<port>/rest/ to form the full URI of the request.
	 * 				 e.q., a path of 'bogus' results in https://<server>:<port>/rest/bogus being sent
	 * 				 to the HP OneView server with a GET verb.
	 * @param headers - Map<String,String> containing optional headers to set for this call.
	 * @return a JsonObject with the response.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonObject get( String path, Map<String,String> headers ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpGet req = new HttpGet("https://" + serverAddr() + "/rest/" + path);
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
        req.setHeader("Content-type","application/json");
		if( null != headers )
			setHeaders( req, headers );
		if( null != token )
			req.setHeader("auth", token);
        
		JsonElement jele = execute( req );
      	JsonObject jobj = jele.getAsJsonObject();	
      	return jobj;
	}

	/**
	 * Issue a HTTP GET request to the HP OneView server.
	 * @param uri - the full URI of the request to send.
	 * @return JsonElement object with the result.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonElement get( URI uri ) throws HPOneViewNotConnectedException {
		return get( uri, null );
	}

	/**
	 * Issue a HTTP GET request to the HP OneView server.
	 * @param uri - the full URI of the request to send.
	 * @param headers - Map<String,String> containing optional headers to set for this call.
	 * @return JsonElement object with the result.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonElement get( URI uri, Map<String,String> headers ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpGet req = new HttpGet( uri );
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
        req.setHeader("Content-type","application/json");
		if( null != headers )
			setHeaders( req, headers );
		if( token != null )
			req.setHeader("auth", token);

        return execute( req );
	}

	/**
	 * Issue a HTTP PUT request to the HP OneView server.
	 * @param uri - the full URI of the request to send.
	 * @param body - an Object containing the body of the request.
	 * @return JsonElement object with the result.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonElement put( URI uri, Object body ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpPut req = new HttpPut( uri );
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
        req.setHeader("Content-type","application/json");
		if( token != null )
			req.setHeader("auth", token);
        Gson gson = new Gson();
        String json = gson.toJson(body);
        req.setEntity(new StringEntity(json,Consts.UTF_8));

        return execute( req );
	}

	/**
	 * Issue a HTTP POST request to the HP OneView server.
	 * @param uri - the full URI of the request to send.
	 * @param body - an Object containing the body of the request.
	 * @return JsonElement object with the result.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonElement post( URI uri, Object body ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpPost req = new HttpPost( uri );
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
        req.setHeader("Content-type","application/json");
		if( token != null )
			req.setHeader("auth", token);
        Gson gson = new Gson();
        String json = gson.toJson(body);
        req.setEntity(new StringEntity(json,Consts.UTF_8));
        
        return execute( req );
	}

	/**
	 * Issue a HTTP DELETE request to the HP OneView server.
	 * @param uri - the full URI of the request to send.
	 * @param body - an Object containing the body of the request.
	 * @return JsonElement object with the result.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public void delete( URI uri ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpDelete req = new HttpDelete( uri );
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
	    req.setHeader("auth", token);
	    try {
			httpClient.execute(req);
		} 
	    catch (ClientProtocolException e) {}
	    catch (IOException e) {}
	}

	/**
	 * Issue an HTTP request to the HP OneView server.
	 * @param req - a HttpRequestBase object containing the request to send.
	 * @return JsonElement object with the response.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonElement execute( HttpRequestBase req ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
        HttpResponse res;
		try {
			res = httpClient.execute(req);
			HttpEntity entity = res.getEntity();
			JsonElement jele = new JsonParser().parse(EntityUtils.toString(entity));
			EntityUtils.consume(entity);
	      	return jele;
		} catch (ClientProtocolException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Issue a HTTP POST request to the HP OneView server.
	 * @param path - The REST request to send. This value is appended to the string
	 *               "https://<server>:<port>/rest/" e.g. a path of "bogus" results
	 *               in "https://<server>:<port>/rest/bogus" being sent to the HP
	 *               OneView server.
	 * @param body - an Object containing the body of the request to POST.
	 * @return JsonObject with the response.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public JsonObject post( String path, Object body ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpPost req = new HttpPost("https://" + serverAddr() + "/rest/" + path);
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
        req.setHeader("Content-type","application/json");
		if( token != null )
			req.setHeader("auth", token);
        Gson gson = new Gson();
        String json = gson.toJson(body);
        req.setEntity(new StringEntity(json,Consts.UTF_8));
        
        HttpResponse res;
		try {
			res = httpClient.execute(req);
			HttpEntity entity = res.getEntity();
			JsonElement jele = new JsonParser().parse(EntityUtils.toString(entity));
			EntityUtils.consume(entity);
	      	JsonObject jobj = jele.getAsJsonObject();	
	      	return jobj;
		} catch (ClientProtocolException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * Issue a HTTP DELETE request to the HP OneView server.
	 * @param path - The REST request to send. This value is appended to the string
	 *               "https://<server>:<port>/rest/" e.g. a path of "bogus" results
	 *               in "https://<server>:<port>/rest/bogus" being sent to the HP
	 *               OneView server.
	 * @throws HPOneViewNotConnectedException if not connected to HP OneView
	 */
	public void delete( String path ) throws HPOneViewNotConnectedException {
		if( !isOpen )
			throw new HPOneViewNotConnectedException();
		HttpDelete req = new HttpDelete("https://" + serverAddr() + "/rest/" + path);
		setHPOneViewAPIVersion( req );
		setAcceptLanguage( req );
	    req.setHeader("auth", token);
	    try {
			httpClient.execute(req);
		} 
	    catch (ClientProtocolException e) {}
	    catch (IOException e) {}
	}
}
