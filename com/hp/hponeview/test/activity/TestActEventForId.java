package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.hp.hponeview.data.activity.EventResourceCollectionV2;
import com.hp.hponeview.data.activity.EventResourceV2;
import com.hp.hponeview.rest.activity.ActEventForId;
import com.hp.hponeview.rest.activity.ActEventList;
import com.hp.hponeview.test.TestBase;

public class TestActEventForId extends TestBase {
	public String id;

	@Before
	public void setUp() throws Exception {
		context = "ActEventList";
		EventResourceCollectionV2 ret = ActEventList.instance(conn).get();
		if( ret.count > 0 ) {
			id = last(ret.members[0].uri.split("/"));
		} else {
			fail( context + " returned empty list, so unable to perform *ForId tests");
		}
	}
	
	@Test
	public void testActEventForId() {
		try {
			context = "ActEventForId";
			EventResourceV2 ret0 = ActEventForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
