package com.hp.hponeview.data.settings;

/**
 * Returned by:
 * 		StgNetworkInterfaces
 * @author hesterg
 *
 */
public class ApplianceServerConfiguration {
	public class LocaleDto {
		public String displayName;
		public String locale;
		public String localeName;
	}
	public class ServerCertificate {
		public String postgresCertificate;
		public String postgresCertificateKey;
		public String postgresRootCACertificate;
		public String rabbitMQCertificate;
		public String rabbitMQCertificateKey;
		public String rabbitMQRootCACertificate;
	}
	public class TimeDto {
		public String dateTime;
		public String [] ntpServers;
		public String pollingInterval;
		public String timezone;
		public String timezoneString;
	}
	public NicConfiguration [] applianceNetworks;
	public String    category;
	public String    created;
	public String    eTag;
	public LocaleDto locale;
	public String    modified;
	public ServerCertificate serverCertificate;
	public TimeDto   time;
	public String    type;		// ApplianceServerConfiguration
	public String    uri;
}	
