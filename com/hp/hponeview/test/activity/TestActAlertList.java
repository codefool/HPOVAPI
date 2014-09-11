package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hponeview.data.activity.AlertResourceCollectionV2;
import com.hp.hponeview.data.servers.EnclosureListV2;
import com.hp.hponeview.rest.HPOneViewException;
import com.hp.hponeview.rest.activity.ActAlertList;
import com.hp.hponeview.rest.servers.SrvEnclosureList;
import com.hp.hponeview.rest.servers.SrvEnclosureListSchema;
import com.hp.hponeview.test.TestBase;

public class TestActAlertList extends TestBase {
	@Test
	public void testActAlertList() {
		try {
			context = "ActAlertList";
			AlertResourceCollectionV2 ret = ActAlertList.instance(conn).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
