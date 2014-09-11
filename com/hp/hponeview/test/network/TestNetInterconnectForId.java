package com.hp.hponeview.test.network;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.hp.hponeview.data.EnvironmentalConfiguration;
import com.hp.hponeview.data.facilities.UtilizationData;
import com.hp.hponeview.data.network.interconnects.InterconnectCollectionV2;
import com.hp.hponeview.data.network.interconnects.InterconnectV2;
import com.hp.hponeview.data.network.interconnects.InterconnectsStatistics;
import com.hp.hponeview.data.network.interconnects.NameServer;
import com.hp.hponeview.data.network.interconnects.PortStatistics;
import com.hp.hponeview.data.servers.EnclosureListV2;
import com.hp.hponeview.data.servers.EnclosureV2;
import com.hp.hponeview.data.servers.SsoUrlData;
import com.hp.hponeview.rest.HPOneViewException;
import com.hp.hponeview.rest.network.NetInterconnectForId;
import com.hp.hponeview.rest.network.NetInterconnectList;
import com.hp.hponeview.rest.network.NetInterconnectListSchema;
import com.hp.hponeview.rest.network.NetInterconnectNameServerListForId;
import com.hp.hponeview.rest.network.NetInterconnectStatisticsForId;
import com.hp.hponeview.rest.network.NetInterconnectStatisticsForIdAndPortName;
import com.hp.hponeview.rest.servers.SrvEnclosureActiveOaSsoUrlForId;
import com.hp.hponeview.rest.servers.SrvEnclosureEnvConfigForId;
import com.hp.hponeview.rest.servers.SrvEnclosureForId;
import com.hp.hponeview.rest.servers.SrvEnclosureList;
import com.hp.hponeview.rest.servers.SrvEnclosureListSchema;
import com.hp.hponeview.rest.servers.SrvEnclosureScriptForId;
import com.hp.hponeview.rest.servers.SrvEnclosureStandbyOaSsoUrlForId;
import com.hp.hponeview.rest.servers.SrvEnclosureUtilizationForId;
import com.hp.hponeview.test.TestBase;

public class TestNetInterconnectForId extends TestBase {
	public String id;
	public String portId;

	@Before
	public void setUp() throws Exception {
		context = "NetInterconnectList";
		InterconnectCollectionV2 ret = NetInterconnectList.instance(conn).get();
		if( ret.count > 0 ) {
			id = last(ret.members[0].uri.split("/"));
			portId = ret.members[0].ports[0].portName;
		} else {
			fail( "NetInterconnectList returned empty list, so unable to perform *ForId tests");
		}
	}
	
	@Test
	public void testNetInterconnectForId() {
		try {
			context = "NetInterconnectForId";
			InterconnectV2 ret0 = NetInterconnectForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testNetInterconnectNameServerListForId() {
		try {
			context = "NetInterconnectNameServerListForId";
			NameServer[] ret3 = NetInterconnectNameServerListForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testNetInterconnectStatisticsForId() {
		try {
			context = "NetInterconnectStatisticsForId";
			InterconnectsStatistics ret4 = NetInterconnectStatisticsForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testNetInterconnectStatisticsForIdAndPortName() {
		try {
			context = "NetInterconnectStatisticsForIdAndPortName";
			PortStatistics ret5 = NetInterconnectStatisticsForIdAndPortName.instance(conn, id, portId).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
