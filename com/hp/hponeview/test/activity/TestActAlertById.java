package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.hp.hponeview.data.activity.AlertResourceCollectionV2;
import com.hp.hponeview.data.activity.AlertResourceV2;
import com.hp.hponeview.rest.activity.ActAlertForId;
import com.hp.hponeview.rest.activity.ActAlertList;
import com.hp.hponeview.test.TestBase;

public class TestActAlertById extends TestBase {
	public String id;
	public String portId;

	@Before
	public void setUp() throws Exception {
		AlertResourceCollectionV2 ret = ActAlertList.instance(conn).get();
		if( ret.count > 0 ) {
			id = last(ret.members[0].uri.split("/"));
		} else {
			fail( "ActAlertList returned empty list, so unable to perform *ForId tests");
		}
	}
	
	@Test
	public void testActAlertForId() {
		try {
			context = "ActAlertForId";
			AlertResourceV2 ret0 = ActAlertForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
