package com.hp.hponeview.test.servers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hponeview.data.servers.EnclosureListV2;
import com.hp.hponeview.rest.HPOneViewException;
import com.hp.hponeview.rest.servers.SrvEnclosureList;
import com.hp.hponeview.rest.servers.SrvEnclosureListSchema;
import com.hp.hponeview.test.TestBase;

public class TestSrvEnclosureList extends TestBase {
	@Test
	public void testSrvEnclosureList() {
		try {
			context = "SrvEnclosureList";
			EnclosureListV2 ret = SrvEnclosureList.instance(conn).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
	
	@Test
	public void testSrvEnclosureListSchema() {
		try {
			context = "SrvEnclosureForId";
			String schema = SrvEnclosureListSchema.instance(conn).getAsJsonString();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
