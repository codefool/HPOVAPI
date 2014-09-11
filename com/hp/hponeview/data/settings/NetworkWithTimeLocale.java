/*****************************************************************************
*
* copyright.txt
*
* Copyright 2013 Hewlett-Packard Development Company, L.P.
*
* Hewlett-Packard and the Hewlett-Packard logo are trademarks of
* Hewlett-Packard Development Company, L.P. in the U.S. and/or other countries.
*
* Confidential computer software. Valid license from Hewlett-Packard required
* for possession, use or copying. Consistent with FAR 12.211 and 12.212,
* Commercial Computer Software, Computer Software Documentation, and Technical
* Data for Commercial Items are licensed to the U.S. Government under
* vendor's standard commercial license.
*
* Author:
* 	Gary Hester
* 
* Description:
*
*****************************************************************************/
package com.hp.hponeview.data.settings;

public class NetworkWithTimeLocale {
	public class Locale {
		public String locale;
		public String localeName;
		public String displayName;
	}

	public class TimeInfo {
		public String [] ntpServers;
		public String timezone;
		public String pollingInterval;
		public String timesoneString;
		public String dateTime;
	}
	
	public Locale locale;
	public ApplianceNicConfiguration [] applianceNetworks;
	public TimeInfo time;
}
