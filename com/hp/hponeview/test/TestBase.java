package com.hp.hponeview.test;

import com.hp.hponeview.rest.Connection;
import com.hp.hponeview.rest.HPOneViewException;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestBase {
	public static Logger logger = Logger.getLogger(TestBase.class);
	public static Connection conn = null;
	public String context = "";
	
	public static <T> T last(T[] array) {
		return array[ array.length - 1 ];
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		logger.setLevel(Level.INFO);
		BasicConfigurator.configure();

		conn = new Connection( "16.83.120.121", "Administrator", "Compaq123" );
		try {
			conn.open( 101 );
			logger.info( "Connected to HP OneView server");
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@AfterClass
	public static void afterClass() throws Exception {
		if( conn != null && conn.isOpen() ) {
			conn.close();
			conn = null;
		}
	}
}
