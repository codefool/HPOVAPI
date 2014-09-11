package com.hp.hponeview.test.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hponeview.data.activity.AuditLogList;
import com.hp.hponeview.rest.activity.ActAuditLogs;
import com.hp.hponeview.test.TestBase;

public class TestActAuditLogs extends TestBase {
	@Test
	public void testActAuditLogs() {
		try {
			context = "ActAuditLogs";
			AuditLogList ret = ActAuditLogs.instance(conn).get();
		}
		catch( Exception e ) {
			fail( e.toString() );
		}
	}
}
