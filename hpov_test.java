import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.lang.reflect.*;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.hp.hponeview.data.*;
import com.hp.hponeview.data.activity.*;
import com.hp.hponeview.data.facilities.*;
import com.hp.hponeview.data.network.*;
import com.hp.hponeview.data.network.Network;
import com.hp.hponeview.data.network.interconnects.*;
import com.hp.hponeview.data.network.logical_interconnects.*;
import com.hp.hponeview.data.sans.*;
import com.hp.hponeview.data.search.*;
import com.hp.hponeview.data.security.*;
import com.hp.hponeview.data.servers.*;
import com.hp.hponeview.data.settings.*;
import com.hp.hponeview.data.storage.*;
import com.hp.hponeview.rest.*;
import com.hp.hponeview.rest.activity.*;
import com.hp.hponeview.rest.facilities.*;
import com.hp.hponeview.rest.network.*;
import com.hp.hponeview.rest.network.NetEthernetNetworkList.ReqNetEthernetNetworkList;
import com.hp.hponeview.rest.sans.*;
import com.hp.hponeview.rest.search.*;
import com.hp.hponeview.rest.security.*;
import com.hp.hponeview.rest.servers.*;
import com.hp.hponeview.rest.settings.*;
import com.hp.hponeview.rest.storage.*;
import com.hp.hponeview.rest.uncategorized.*;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.BasicConfigurator;

public class hpov_test 
{
	static Logger logger = Logger.getLogger(hpov_test.class);
	static public Class<?> [] classList = {
		    ActAlertForId.class,
		    ActAlertList.class,
		    ActAuditLogs.class,
		    ActEventForId.class,
		    ActEventList.class,
		    ActTaskForId.class,
		    ActTaskList.class,
		    ActTaskTreeForId.class,
		    FacDatacenterForId.class,
		    FacDatacenterList.class,
		    FacDatacenterVisualContentForId.class,
		    FacPowerDeviceForId.class,
		    FacPowerDeviceList.class,
		    FacPowerDevicePowerStateForId.class,
		    FacPowerDeviceUidStateForId.class,
		    FacPowerDeviceUtilizationForId.class,
		    FacRackDeviceTopologyForId.class,
		    FacRackForId.class,
		    FacRackList.class,
		    NetConnectionTemplateForId.class,
		    NetConnectionTemplateList.class,
		    NetConnectionTemplateListSchema.class,
		    NetDccVlanForIdAndPort.class,
		    NetDefaultConnectionTemplate.class,
		    NetEthernetNetworkForId.class,
		    NetEthernetNetworkList.class,
		    NetEthernetNetworkListSchema.class,
		    NetFcNetworkForId.class,
		    NetFcNetworkList.class,
		    NetFcNetworkListSchema.class,
		    NetInterconnectForId.class,
		    NetInterconnectList.class,
		    NetInterconnectListSchema.class,
		    NetInterconnectNameServerListForId.class,
		    NetInterconnectPortForIdAndPortId.class,
		    NetInterconnectPortListForId.class,
		    NetInterconnectStatisticsForId.class,
		    NetInterconnectStatisticsForIdAndPortName.class,
		    NetInterconnectStatisticsForIdAndPortNameAndSubPort.class,
		    NetInterconnectTypeForId.class,
		    NetInterconnectTypeList.class,
		    NetInterconnectTypeListSchema.class,
		    NetLogicalDownlinkForId.class,
		    NetLogicalDownlinkList.class,
		    NetLogicalDownlinkListSchema.class,
		    NetLogicalDownlinkWithoutEthernetForId.class,
		    NetLogicalDownlinkWithoutEthernetList.class,
		    NetLogicalInterconnectFibListForId.class,
		    NetLogicalInterconnectFirmwareForId.class,
		    NetLogicalInterconnectForId.class,
		    NetLogicalInterconnectGroupDefaultSettings.class,
		    NetLogicalInterconnectGroupForId.class,
		    NetLogicalInterconnectGroupList.class,
		    NetLogicalInterconnectGroupListSchema.class,
		    NetLogicalInterconnectGroupSettingsForIdAndSettingsId.class,
		    NetLogicalInterconnectList.class,
		    NetLogicalInterconnectListSchema.class,
		    NetLogicalInterconnectPortMonitorForId.class,
		    NetLogicalInterconnectSnmpConfigForId.class,
		    NetLogicalInterconnectTelemetryConfigForIdAndTcid.class,
		    NetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId.class,
		    NetNetworkSetForId.class,
		    NetNetworkSetList.class,
		    NetNetworkSetListSchema.class,
		    NetNetworkSetWithoutEthernetForId.class,
		    NetNetworkSetWithoutEthernetList.class,
		    NetSwitchEnvConfigForId.class,
		    NetSwitchForId.class,
		    NetSwitchList.class,
		    NetSwitchListSchema.class,
		    NetUplinkSetForId.class,
		    NetUplinkSetList.class,
		    NetUplinkSetListSchema.class,
		    SansDeviceManagerForId.class,
		    SansDeviceManagerList.class,
		    SansManagedSanForId.class,
		    SansManagedSanList.class,
		    SansProviderList.class,
		    SrchAggTreeForUri.class,
		    SrchAssociationResourceList.class,
		    SrchAssociationsList.class,
		    SrchLabelForId.class,
		    SrchLabelList.class,
		    SrchLabelResourcesForUri.class,
		    SrchResourceForUri.class,
		    SrchResourcesList.class,
		    SrchSuggestions.class,
		    SrchTreeForUri.class,
		    SrchTreeList.class,
		    SrchTreeMinified.class,
		    SrchTreeMinifiedForUri.class,
		    SecActiveUserSessionList.class,
		    SecCaRootCertificate.class,
		    SecCategoryActionsList.class,
		    SecCertificateCaCRL.class,
		    SecGroupToRoleMappingList.class,
		    SecGroupToRoleMappingListForDomain.class,
		    SecGroupToRoleMappingListForDomainAndGroup.class,
		    SecHttpsCertificate.class,
		    SecHttpsRemoteCertForAddress.class,
		    SecLoginDomainAllowLocalLogin.class,
		    SecLoginDomainConfigForDomainName.class,
		    SecLoginDomainDefault.class,
		    SecLoginDomainGlobalSettings.class,
		    SecLoginDomainList.class,
		    SecRabbitMqCertForAlias.class,
		    SecRabbitMqKeypairForAlias.class,
		    SecRabbitMqKeysForAlias.class,
		    SecRoleCategoryActionsList.class,
		    SecRoleForRoleName.class,
		    SecRoleList.class,
		    SecRoleListForUser.class,
		    SecSessionIdleTimeout.class,
		    SecSessionUserList.class,
		    SecSslCertificateForId.class,
		    SecSslCertificatesList.class,
		    SecUserForUserName.class,
		    SecUserList.class,
		    SecUserListForRole.class,
		    SecUserSessionList.class,
		    SrvAvailableNetworkList.class,
		    SrvAvailableNetworkListSchema.class,
		    SrvAvailableServerList.class,
		    SrvAvailableServerListSchema.class,
		    SrvAvailableStorageSystemList.class,
		    SrvAvailableTargetList.class,
		    SrvConnectionForId.class,
		    SrvConnectionList.class,
		    SrvConnectionListSchema.class,
		    SrvEnclosureActiveOaSsoUrlForId.class,
		    SrvEnclosureEnvConfigForId.class,
		    SrvEnclosureForId.class,
		    SrvEnclosureGroupForId.class,
		    SrvEnclosureGroupList.class,
		    SrvEnclosureGroupListSchema.class,
		    SrvEnclosureGroupScriptForId.class,
		    SrvEnclosureList.class,
		    SrvEnclosureListSchema.class,
		    SrvEnclosureScriptForId.class,
		    SrvEnclosureStandbyOaSsoUrlForId.class,
		    SrvEnclosureUtilizationForId.class,
		    SrvHardwareEnvConfigForId.class,
		    SrvHardwareForId.class,
		    SrvHardwareIloSsoUrlForId.class,
		    SrvHardwareJavaRemoteConsoleUrlForId.class,
		    SrvHardwareList.class,
		    SrvHardwareListSchema.class,
		    SrvHardwareRemoteConsoleUrlForId.class,
		    SrvHardwareTypeForId.class,
		    SrvHardwareTypeList.class,
		    SrvHardwareTypeListSchema.class,
		    SrvHardwareUtilizationForId.class,
		    SrvIdPoolForId.class,
		    SrvIdPoolGenerateForId.class,
		    SrvIdPoolSchema.class,
		    SrvIdPoolVmacRangeAllocFragListForId.class,
		    SrvIdPoolVmacRangeForId.class,
		    SrvIdPoolVmacRangeFreeFragListForId.class,
		    SrvIdPoolVmacRangeSchema.class,
		    SrvIdPoolVsnRangeAllocFragListForId.class,
		    SrvIdPoolVsnRangeForId.class,
		    SrvIdPoolVsnRangeFreeFragListForId.class,
		    SrvIdPoolVsnRangeSchema.class,
		    SrvIdPoolVwwnRangeAllocFragListForId.class,
		    SrvIdPoolVwwnRangeForId.class,
		    SrvIdPoolVwwnRangeFreeFragListForId.class,
		    SrvIdPoolVwwnRangeSchema.class,
		    SrvProfileForId.class,
		    SrvProfileList.class,
		    SrvProfileListSchema.class,
		    SrvProfileMessagesForId.class,
		    SrvProfileMessagesSchema.class,
		    SrvProfilePortModel.class,
		    SrvProfilePortModelSchema.class,
		    StgBackupForId.class,
		    StgBackupList.class,
		    StgDomainForId.class,
		    StgDomainList.class,
		    StgDomainListSchema.class,
		    StgEthernetNetworkLimitsForId.class,
		    StgEulaStatus.class,
		    StgFcNetworkLimitsForId.class,
		    StgFirmwareDocForNameAndType.class,
		    StgFirmwareDriverForId.class,
		    StgFirmwareDriverList.class,
		    StgFirmwareDriverListSchema.class,
		    StgFirmwareNotification.class,
		    StgFirmwarePending.class,
		    StgFirmwareVerificationKey.class,
		    StgGlobalSettingsForId.class,
		    StgGlobalSettingsList.class,
		    StgHealthStatus.class,
		    StgLicenseForId.class,
		    StgLicenseList.class,
		    StgLicenseSummaryList.class,
		    StgNetworkInterfaceForMacAddress.class,
		    StgNetworkInterfaceMacAddressList.class,
		    StgNetworkInterfaces.class,
		    StgNetworkSetLimitsForId.class,
		    StgNodeInfoStatus.class,
		    StgNodeInfoVersion.class,
		    StgReadCommunityString.class,
		    StgRestoreFailure.class,
		    StgRestoreForId.class,
		    StgRestoreList.class,
		    StgServiceAccess.class,
		    StgStartupProgress.class,
		    StgTrapDestinationForId.class,
		    StgTrapDestinationList.class,
		    StgVersion.class,
		    StoAttachVolumeList.class,
		    StoConnectableVolumeTemplateList.class,
		    StoHostTypeList.class,
		    StoManagedPortsListForId.class,
		    StoMangedPortForIdAndPortId.class,
		    StoPoolForArrayId.class,
		    StoPoolForId.class,
		    StoPoolList.class,
		    StoSystemForId.class,
		    StoSystemList.class,
		    StoVolumeAttachmentForId.class,
		    StoVolumeAttachmentList.class,
		    StoVolumeAttachmentPathForIdAndPathId.class,
		    StoVolumeAttachmentPathsForId.class,
		    StoVolumeForId.class,
		    StoVolumeList.class,
		    StoVolumeTemplateForId.class,
		    StoVolumeTemplateList.class,
		    UncUnmanagedDeviceEnvConfigForId.class,
		    UncUnmanagedDeviceForId.class,
		    UncUnmanagedDeviceList.class
		};    

	
	public static <T> T last(T[] array) {
		return array[ array.length - 1 ];
	}

	public static void main(String[] args) {
		logger.setLevel(Level.INFO);
		BasicConfigurator.configure();
		logger.info("Entering application");
		
		for( Class<?> c : classList ) {
			try {
				Object obj = c.newInstance();
				String className = c.toString();
				Method m0 = c.getDeclaredMethod( "retType" );
				Class<?> retType = (Class<?>)m0.invoke(obj);
				String rt  = retType.toString();
				Field f0 = c.getDeclaredField("_URI");
				String uri = (String)f0.get(obj);
				System.out.format( "\"%s\",\"%s\",\"%s\"\n", className, rt, uri );
			} catch( Exception e ) {
			}
		}
		
		
		//Connection conn = new Connection( "16.83.121.61", "Administrator", "Compaq123" );
		//Connection conn = new Connection( "16.84.101.88", "Administrator", "hpvse123" );	// API 101 object
		//Connection conn = new Connection( "16.83.122.159", "Administrator", "Compaq123" );
		Connection conn = new Connection( "16.83.120.121", "Administrator", "Compaq123" );
		try {
			conn.open(101);
			{
				EnclosureListV2 ret = SrvEnclosureList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String uri = ret.members[0].uri;
					EnclosureV2 retx = (EnclosureV2)HPOneViewUriRequest.instance( conn, uri, EnclosureV2.class ).get();
					System.out.println( "OK\n" );
					String id = last(ret.members[0].uri.split("/"));
					EnclosureV2 ret0 = SrvEnclosureForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					SsoUrlData ret1 = SrvEnclosureActiveOaSsoUrlForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					try {
						SsoUrlData ret2 = SrvEnclosureStandbyOaSsoUrlForId.instance(conn, id).get();
						System.out.println( "OK\n" );
					} catch( Exception e ) {
						System.out.println( e );
					}
					EnvironmentalConfiguration ret3 = SrvEnclosureEnvConfigForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret4 = SrvEnclosureScriptForId.instance(conn, id).get();					
					System.out.println( "OK\n" );
					UtilizationData ret5 = SrvEnclosureUtilizationForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				String schema = SrvEnclosureListSchema.instance(conn).getAsJsonString();
				System.out.println( "OK\n" );
			}
			{
				InterconnectCollectionV2 ret = NetInterconnectList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					InterconnectV2 ret0 = NetInterconnectForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetInterconnectListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
					NameServer[] ret3 = NetInterconnectNameServerListForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					InterconnectsStatistics ret4 = NetInterconnectStatisticsForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String portId = ret.members[0].ports[0].portName;
					PortStatistics ret5 = NetInterconnectStatisticsForIdAndPortName.instance(conn, id, portId).get();
					System.out.println( "OK\n" );
					//SubportStatistics ret6 = NetInterconnectStatisticsForIdAndPortNameAndSubPort.instance(conn, id, portId, subPortNumber).get();
					//System.out.println( "OK\n" );
				}
			}
			{
				AlertResourceCollectionV2 ret = ActAlertList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					AlertResourceV2 ret0 = ActAlertForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				NetEthernetNetworkList.ReqNetEthernetNetworkList obj = NetEthernetNetworkList.instance(conn);
				String zzz = NetEthernetNetworkList.class.toString();
				String xxx = obj.getBuilder().toString();
				String yyy = NetEthernetNetworkList.retType().toString();
				NetworkCollectionV2 ret = NetEthernetNetworkList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					NetworkV2 ret0 = NetEthernetNetworkForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetEthernetNetworkListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
			}
			{
				LabelList ret = SrchLabelList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				PowerDeliveryDeviceList ret = FacPowerDeviceList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				SanResponseList ret = SansManagedSanList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				StorageVolumeList ret = StoVolumeList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					StorageVolume ret0 = StoVolumeForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				AttachableStorageVolumeList ret1 = StoAttachVolumeList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				StorageVolumeTemplateList ret = StoVolumeTemplateList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					StorageVolumeTemplate ret0 = StoVolumeTemplateForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				ConnectableStorageVolumeTemplateList ret1 = StoConnectableVolumeTemplateList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				StorageVolumeAttachmentList ret = StoVolumeAttachmentList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					StorageVolumeAttachment ret0 = StoVolumeAttachmentForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				StorageSystemList ret = StoSystemList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					StorageSystem ret0 = StoSystemForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					StorageTargetPortList ret1 = StoManagedPortsListForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				List<String> ret = StoHostTypeList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				StoragePoolList ret = StoPoolList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					StoragePool ret0 = StoPoolForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				RestoreList ret = StgRestoreList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					Restore ret1 = StgRestoreForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				RestoreResult ret2 = StgRestoreFailure.instance(conn).get();
				System.out.println( "OK\n" );
				Boolean ret3 = StgServiceAccess.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				LicenseList ret = StgLicenseList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					License ret1 = StgLicenseForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				LicenseSummaryListV100 ret0 = StgLicenseSummaryList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret0.count > 0 ) {
					String id = last(ret0.members[0].uri.split("/"));
					//License ret3 = StgLicenseForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				SettingsPaginatedCollection ret = StgGlobalSettingsList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					Setting ret0 = StgGlobalSettingsForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				FwBaselineCollection ret = StgFirmwareDriverList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					FwBaseline ret0 = StgFirmwareDriverForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				DomainCollection ret = StgDomainList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					Domain ret0 = StgDomainForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					NetworkLimits ret1 = StgEthernetNetworkLimitsForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					NetworkLimits ret2 = StgFcNetworkLimitsForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					NetworkLimits ret3 = StgNetworkSetLimitsForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				BackupList ret = StgBackupList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					Backup ret0 = StgBackupForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				TrapDestinationCollectionDto ret = StgTrapDestinationList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					TrapDestinationDto ret0 = StgTrapDestinationForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				NodeStatusDto ret = StgNodeInfoStatus.instance(conn).get();
				System.out.println( "OK\n" );
				NodeVersionDto ret0 = StgNodeInfoVersion.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				DeviceCommunityStringDto ret = StgReadCommunityString.instance(conn).get();
				System.out.println( "OK\n" );
				Boolean ret0 = StgEulaStatus.instance(conn).get();
				System.out.println( "OK\n" );
				UpgradeNotification ret1 = StgFirmwareNotification.instance(conn).get();
				System.out.println( "OK\n" );
				UpgradeInfo ret2 = StgFirmwarePending.instance(conn).get();
				System.out.println( "OK\n" );
				VerificationKeyInfo ret3 = StgFirmwareVerificationKey.instance(conn).get();
				System.out.println( "OK\n" );
				ApplianceHealthStatus ret4 = StgHealthStatus.instance(conn).get();
				System.out.println( "OK\n" );
				ApplianceServerConfiguration ret6 = StgNetworkInterfaces.instance(conn).get();
				System.out.println( "OK\n" );
				MacInterfaceCollection ret5 = StgNetworkInterfaceMacAddressList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret5.count > 0 ) {
					String id = ret5.members[0].macAddress;
					ApplianceNicConfiguration ret7 = StgNetworkInterfaceForMacAddress.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				CategoryActionList ret = SecCategoryActionsList.instance(conn).get();
				System.out.println( "OK\n" );
				Map<String,Map<String,List<String>>> ret0 = SecRoleCategoryActionsList.instance(conn).get();
				System.out.println( "OK\n" );
				CertificateV2 ret1 = SecHttpsCertificate.instance(conn).get();
				System.out.println( "OK\n" );
				CertificateInfo ret2 = SecHttpsRemoteCertForAddress.instance(conn, "16.83.121.61").setHeader("Requestername","AUTHN").get();
				System.out.println( "OK\n" );
			}
			{
				GlobalSettings ret = SecLoginDomainGlobalSettings.instance(conn).get();
				System.out.println( "OK\n" );
				LoginDomainConfigVersion2 ret0 = SecLoginDomainConfigForDomainName.instance(conn, "0").get();
				System.out.println( "OK\n" );
			}
			{
				LoginDomainConfigInfo[] ret = SecLoginDomainList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.length > 0 )
				{
					LoginDomainConfigVersion2 ret0 = SecLoginDomainConfigForDomainName.instance(conn, ret[0].name).get();
					System.out.println( "OK\n" );
				}
			}
			{
				SSLCertificatesList ret = SecSslCertificatesList.instance(conn).setHeader("Requestername","DEFAULT").setCount(2).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					SSLCertificate ret0 = SecSslCertificateForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				SessionUserListV2 ret  = SecActiveUserSessionList.instance(conn).get();
				System.out.println( "OK\n" );
				String            ret0 = SecCertificateCaCRL.instance(conn).get();
				System.out.println( "OK\n" );
				String			  ret1 = SecCaRootCertificate.instance(conn).get();
				System.out.println( "OK\n" );
				RabbitMqClientCertV2 ret2 = SecRabbitMqKeysForAlias.instance(conn, "default" ).setFormat("base64").get();
				System.out.println( "OK\n" );
				RabbitMqClientCertV2 ret3 = SecRabbitMqKeypairForAlias.instance(conn, "default" ).get();
				System.out.println( "OK\n" );
				RabbitMqClientCertV2 ret4 = SecRabbitMqCertForAlias.instance(conn, "default" ).get();
				System.out.println( "OK\n" );
			}
			{
				SwitchCollection ret = NetSwitchList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					Switch ret0 = NetSwitchForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret1 = NetSwitchListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
					EnvironmentalConfigurationV2 ret2 = NetSwitchEnvConfigForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				UplinkSetCollectionV2 ret = NetUplinkSetList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					UplinkSetV2 ret0 = NetUplinkSetForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetUplinkSetListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
			}
			{
				NetworkSetCollection ret = NetNetworkSetList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					NetworkSet ret0 = NetNetworkSetForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetNetworkSetListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
				NetworkSetCollection ret3 = NetNetworkSetWithoutEthernetList.instance(conn).get();
				if( ret3.count > 0 )
				{
					String id = last(ret3.members[0].uri.split("/"));
					NetworkSet ret0 = NetNetworkSetWithoutEthernetForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				LogicalInterconnectCollectionV2 ret = NetLogicalInterconnectList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					String settingId = ret.members[0].ethernetSettings.id;
					String tcid = last(ret.members[0].telemetryConfiguration.uri.split("/"));
					LogicalInterconnectV2 ret0 = NetLogicalInterconnectForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetLogicalInterconnectListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
					InterconnectFibData ret3 = NetLogicalInterconnectFibListForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					LIFirmware ret4 = NetLogicalInterconnectFirmwareForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					PortMonitor ret5 = NetLogicalInterconnectPortMonitorForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					SnmpConfiguration ret6 = NetLogicalInterconnectSnmpConfigForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					TelemetryConfiguration ret7 = NetLogicalInterconnectTelemetryConfigForIdAndTcid.instance(conn, id, tcid).get();
					System.out.println( "OK\n" );
					PortMonitorUplinkPortCollection ret8 = NetLogicalInterconnectUnassignedPortMonitorUplinkPortsForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				InterconnectSettingsV2 ret4 = NetLogicalInterconnectGroupDefaultSettings.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				LogicalInterconnectGroupCollectionV2 ret = NetLogicalInterconnectGroupList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					String settingId = ret.members[0].ethernetSettings.id;
					LogicalInterconnectGroupV2 ret0 = NetLogicalInterconnectGroupForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetLogicalInterconnectGroupListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
					InterconnectSettingsV2 ret3 = NetLogicalInterconnectGroupSettingsForIdAndSettingsId.instance(conn, id, settingId).get();
					System.out.println( "OK\n" );
				}
				InterconnectSettingsV2 ret4 = NetLogicalInterconnectGroupDefaultSettings.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				LogicalDownlinkCollection ret = NetLogicalDownlinkList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					LogicalDownlink ret0 = NetLogicalDownlinkForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetLogicalDownlinkListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
				LogicalDownlinkCollection ret3 = NetLogicalDownlinkWithoutEthernetList.instance(conn).get();
				if( ret3.count > 0 )
				{
					String id = last(ret3.members[0].uri.split("/"));
					LogicalDownlink ret0 = NetLogicalDownlinkWithoutEthernetForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				InterconnectTypeCollectionV2 ret = NetInterconnectTypeList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					InterconnectTypeV2 ret0 = NetInterconnectTypeForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetInterconnectTypeListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
			}
			{
				FcNetworkCollectionV2 ret = NetFcNetworkList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					FcNetworkV2 ret0 = NetFcNetworkForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetFcNetworkListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
			}
			{
				NetworkCollectionV2 ret = NetEthernetNetworkList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					NetworkV2 ret0 = NetEthernetNetworkForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret2 = NetEthernetNetworkListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
			}
			{
				ConnectionTemplateCollection ret = NetConnectionTemplateList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					ConnectionTemplate ret0 = NetConnectionTemplateForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					ConnectionTemplate ret1 = NetDefaultConnectionTemplate.instance(conn).get();
					System.out.println( "OK\n" );
					String ret2 = NetConnectionTemplateListSchema.instance(conn).getAsJsonString();
					System.out.println( "OK\n" );
				}
			}
			{
				RackList ret = FacRackList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					Rack ret0 = FacRackForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					EnvironmentalAnalysis ret1 = FacRackDeviceTopologyForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				DatacenterList ret = FacDatacenterList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					Datacenter ret0 = FacDatacenterForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					VisualContent[] ret1 = FacDatacenterVisualContentForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				EventResourceCollectionV2 ret = ActEventList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					EventResourceV2 ret0 = ActEventForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				AuditLogList ret = ActAuditLogs.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				TaskResourcePaginatedCollectionV2 ret = ActTaskList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					TaskResourceV2 ret0 = ActTaskForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					TaskTreeV2 ret1 = ActTaskTreeForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				AvailableServer[] ret = SrvAvailableServerList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.length > 0 )
				{
					AvailableNetworksV2 ret0 = SrvAvailableNetworkList.instance(conn)
											 .setServerHardwareUri( ret[0].serverHardwareUri )
											 .setServerHardwareTypeUri( ret[0].serverHardwareTypeUri )
											 .setEnclosureGroupUri( ret[0].enclosureGroupUri )
											 .get();
					System.out.println( "OK\n" );
					AvailableStorageSystems ret1 = SrvAvailableStorageSystemList.instance(conn)
											     .setServerHardwareTypeUri( ret[0].serverHardwareTypeUri )
											     .setEnclosureGroupUri( ret[0].enclosureGroupUri )
											     .get();
					System.out.println( "OK\n" );
					//AvailableTargetsV1 ret2 = SrvAvailableTargetList.instance(conn)
					//					     .setServerHardwareTypeUri( ret[0].serverHardwareTypeUri )
					//					     .setEnclosureGroupUri( ret[0].enclosureGroupUri )
					//					     .get();
					//System.out.println( "OK\n" );
					ProfilePortModelV2 ret2 = SrvProfilePortModel.instance(conn)
											 .setServerHardwareUri( ret[0].serverHardwareUri )
											 .setServerHardwareTypeUri( ret[0].serverHardwareTypeUri )
											 .setEnclosureGroupUri( ret[0].enclosureGroupUri )
											 .get();
					System.out.println( "OK\n" );
				}
			}
			{
				ServerProfileListV3 ret = SrvProfileList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					ServerProfileV3 ret0 = SrvProfileForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					ServerProfileHealth ret1 = SrvProfileMessagesForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				ServerHardwareTypeList ret = SrvHardwareTypeList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					ServerHardwareType ret0 = SrvHardwareTypeForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				ServerHardwareList ret = SrvHardwareList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					String id = last(ret.members[0].uri.split("/"));
					ServerHardware ret0 = SrvHardwareForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					//EnvironmentalConfiguration ret1 = SrvHardwareEnvConfigForId.instance(conn, id).get();
					//System.out.println( "OK\n" );
					UtilizationData ret2 = SrvHardwareUtilizationForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				String schema = SrvIdPoolSchema.instance(conn).getAsJsonString();
				System.out.println( "OK\n" );
				schema = SrvIdPoolVmacRangeSchema.instance(conn).getAsJsonString();
				System.out.println( "OK\n" );
				{
					//Pool ret6 = SrvIdPoolForId.instance(conn, id).get();
					//System.out.println( "OK\n" );
				}
			}
			{
				EnclosureGroupListV2 ret = SrvEnclosureGroupList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					EnclosureGroupV2 ret0 = SrvEnclosureGroupForId.instance(conn, id).get();
					System.out.println( "OK\n" );
					String ret1 = SrvEnclosureGroupScriptForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
				String schema = SrvEnclosureGroupListSchema.instance(conn).getAsJsonString();
				System.out.println( "OK\n" );
			}
			{
				String schema = SrvConnectionListSchema.instance(conn).getAsJsonString();
				System.out.println( "OK\n" );
			}
			{
				ConnectionInformationCollection ret = SrvConnectionList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 ) {
					String id = last(ret.members[0].uri.split("/"));
					ConnectionInstance ret0 = SrvConnectionForId.instance(conn, id).get();
					System.out.println( "OK\n" );
				}
			}
			{
				UriTrees ret = SrchTreeMinified.instance(conn).setChildDepth(3).setParentDepth(3).get();
				System.out.println( "OK\n" );
				if( ret.total > 0 )
				{
					UriTrees ret0 = SrchTreeMinifiedForUri.instance(conn, ret.uriTrees[0].treeUri).get();
					System.out.println( "OK\n" );
				}
			}
			{
				TreesPaginatedCollectionV4 ret = SrchTreeList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					Tree ret0 = SrchTreeForUri.instance(conn, ret.members[0].resource.uri).get();
					System.out.println( "OK\n" );
					AggregatedTree ret1 = SrchAggTreeForUri.instance(conn, ret.members[0].resource.uri).get();
					System.out.println( "OK\n" );
				}
			}
			{
				Suggestions ret = SrchSuggestions.instance(conn).setUserQuery("ad").get();
				System.out.println( "OK\n" );
			}
			{
				IndexPaginatedCollectionV4 ret = SrchResourcesList.instance(conn).get();
				System.out.println( "OK\n" );
				if( ret.count > 0 )
				{
					IndexResource ret0 = SrchResourceForUri.instance(conn, ret.members[0].uri).get();
					System.out.println( "OK\n" );
				}
			}
			{
				AssociationPaginatedCollectionV4 ret = SrchAssociationResourceList.instance(conn).get();
				System.out.println( "OK\n" );
			}
			{
				Associations ret = SrchAssociationsList.instance(conn).get();
				System.out.println( "OK\n" );
			}
		} catch ( HPOneViewRestException e ) {
			logger.error( e );
		} catch ( HPOneViewException e ) {
			logger.error( e );
		} catch ( Exception e ) {
			logger.error(e);
		} finally {
			conn.close();
		}

		logger.info("Exiting application");
	}
}
