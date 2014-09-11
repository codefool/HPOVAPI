package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hponeview.data.activity.EventResourceCollectionV2;
import com.hp.hponeview.rest.activity.ActEventList;
import com.hp.hponeview.test.TestBase;

public class TestActEventList extends TestBase {
	@Test
	public void testActEventList() {
		try {
			context = "ActEventList";
			EventResourceCollectionV2 ret = ActEventList.instance(conn).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
