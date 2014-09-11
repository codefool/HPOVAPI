package com.hp.hponeview.test.servers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.hp.hponeview.data.EnvironmentalConfiguration;
import com.hp.hponeview.data.facilities.UtilizationData;
import com.hp.hponeview.data.servers.EnclosureListV2;
import com.hp.hponeview.data.servers.EnclosureV2;
import com.hp.hponeview.data.servers.SsoUrlData;
import com.hp.hponeview.rest.HPOneViewException;
import com.hp.hponeview.rest.servers.SrvEnclosureActiveOaSsoUrlForId;
import com.hp.hponeview.rest.servers.SrvEnclosureEnvConfigForId;
import com.hp.hponeview.rest.servers.SrvEnclosureForId;
import com.hp.hponeview.rest.servers.SrvEnclosureList;
import com.hp.hponeview.rest.servers.SrvEnclosureListSchema;
import com.hp.hponeview.rest.servers.SrvEnclosureScriptForId;
import com.hp.hponeview.rest.servers.SrvEnclosureStandbyOaSsoUrlForId;
import com.hp.hponeview.rest.servers.SrvEnclosureUtilizationForId;
import com.hp.hponeview.test.TestBase;

public class TestSrvEnclosureForId extends TestBase {
	public String id;

	@Before
	public void setUp() throws Exception {
		EnclosureListV2 ret = SrvEnclosureList.instance(conn).get();
		if( ret.count > 0 ) {
			id = last(ret.members[0].uri.split("/"));
		} else {
			fail( "SrvEnclosureList returned empty list, so unable to perform *ForId tests");
		}
	}
	
	@Test
	public void testSrvEnclosureForId() {
		try {
			context = "SrvEnclosureForId";
			EnclosureV2 ret0 = SrvEnclosureForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testSrvEnclosureActiveOaSsoUrlForId() {
		try {
			context = "SrvEnclosureActiveOaSsoUrlForId";
			SsoUrlData ret1 = SrvEnclosureActiveOaSsoUrlForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testSrvEnclosureStandbyOaSsoUrlForId() {
		try {
			context = "SrvEnclosureStandbyOaSsoUrlForId";
			SsoUrlData ret2 = SrvEnclosureStandbyOaSsoUrlForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testSrvEnclosureEnvConfigForId() {
		try {
			context = "SrvEnclosureEnvConfigForId";
			EnvironmentalConfiguration ret3 = SrvEnclosureEnvConfigForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testSrvEnclosureScriptForId() {
		try {
			context = "SrvEnclosureScriptForId";
			String ret4 = SrvEnclosureScriptForId.instance(conn, id).get();					
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testSrvEnclosureUtilizationForId() {
		try {
			context = "SrvEnclosureUtilizationForId";
			UtilizationData ret5 = SrvEnclosureUtilizationForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
