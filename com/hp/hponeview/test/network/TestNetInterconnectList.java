package com.hp.hponeview.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hponeview.data.network.interconnects.InterconnectCollectionV2;
import com.hp.hponeview.rest.HPOneViewException;
import com.hp.hponeview.rest.network.NetInterconnectList;
import com.hp.hponeview.rest.network.NetInterconnectListSchema;
import com.hp.hponeview.test.TestBase;

public class TestNetInterconnectList extends TestBase {
	@Test
	public void testNetInterconnectList() {
		try {
			context = "NetInterconnectList";
			InterconnectCollectionV2 ret = NetInterconnectList.instance(conn).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}

	@Test
	public void testNetInterconnectListSchema() {
		try {
			context = "NetInterconnectListSchema";
			String ret2 = NetInterconnectListSchema.instance(conn).getAsJsonString();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
