package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hponeview.data.activity.TaskResourcePaginatedCollectionV2;
import com.hp.hponeview.rest.activity.ActTaskList;
import com.hp.hponeview.test.TestBase;

public class TestActTaskList extends TestBase {
	@Test
	public void testActTaskList() {
		try {
			context = "ActTaskList";
			TaskResourcePaginatedCollectionV2 ret = ActTaskList.instance(conn).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
