package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.hp.hponeview.data.activity.TaskResourceV2;
import com.hp.hponeview.data.activity.TaskResourcePaginatedCollectionV2;
import com.hp.hponeview.data.activity.TaskTreeV2;
import com.hp.hponeview.rest.activity.ActTaskForId;
import com.hp.hponeview.rest.activity.ActTaskList;
import com.hp.hponeview.rest.activity.ActTaskTreeForId;
import com.hp.hponeview.test.TestBase;

public class TestActTaskForId extends TestBase {
	public String id;

	@Before
	public void setUp() throws Exception {
		context = "ActTaskList";
		TaskResourcePaginatedCollectionV2 ret = ActTaskList.instance(conn).get();
		if( ret.count > 0 ) {
			id = last(ret.members[0].uri.split("/"));
		} else {
			fail( context + " returned empty list, so unable to perform *ForId tests");
		}
	}
	
	@Test
	public void testActTaskForId() {
		try {
			context = "ActTaskForId";
			TaskResourceV2 ret0 = ActTaskForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
	
	@Test
	public void testActTaskTreeForId() {
		try {
			context = "ActTaskTreeForId";
			TaskTreeV2 ret1 = ActTaskTreeForId.instance(conn, id).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
