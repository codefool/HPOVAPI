package com.hp.hponeview.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hp.hponeview.test.activity.*;
import com.hp.hponeview.test.network.*;
import com.hp.hponeview.test.servers.*;

@RunWith(Suite.class)
@SuiteClasses({ ReflectionTest.class, 
	TestSrvEnclosureList.class, TestSrvEnclosureForId.class,
	TestNetInterconnectList.class, TestNetInterconnectForId.class,
	TestActAlertList.class, TestActAlertById.class,
	TestActAuditLogs.class,
	TestActEventList.class, TestActEventForId.class
})

public class AllTests {

}
