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
package com.hp.hponeview.data.network.interconnects;

public class PortStatistics {
	public class CommonStatistics {
		public Number portNumber;	
		public Number resetTimeEpoch;	
		public Number rfc1213IfInDiscards;	
		public Number rfc1213IfInErrors;	
		public Number rfc1213IfInNUcastPkts;	
		public Number rfc1213IfInOctets;	
		public Number rfc1213IfInUcastPkts;	
		public Number rfc1213IfInUnknownProtos;	
		public Number rfc1213IfOutDiscards;	
		public Number rfc1213IfOutErrors;	
		public Number rfc1213IfOutNUcastPkts;	
		public Number rfc1213IfOutOctets;	
		public Number rfc1213IfOutQLen;	
		public Number rfc1213IfOutUcastPkts;	
		public Number rfc1213IpForwDatagrams;	
		public Number rfc1213IpInDiscards;	
		public Number rfc1213IpInHdrErrors;	
		public Number rfc1213IpInReceives;	
		public Number rfc1493Dot1DBasePortDelayExceededDiscards;	
		public Number rfc1493Dot1DBasePortMtuExceededDiscards;	
		public Number rfc1493Dot1DPortInDiscards;	
		public Number rfc1493Dot1DTpPortInFrames;	
		public Number rfc1493Dot1DTpPortOutFrames;	
		public Number rfc1757StatsBroadcastPkts;	
		public Number rfc1757StatsCRCAlignErrors;
		public Number rfc1757StatsCollisions;	
		public Number rfc1757StatsDropEvents;	
		public Number rfc1757StatsFragments;	
		public Number rfc1757StatsJabbers;	
		public Number rfc1757StatsMulticastPkts;	
		public Number rfc1757StatsOctets;	
		public Number rfc1757StatsOversizePkts;	
		public Number rfc1757StatsPkts1024To1518Octets;	
		public Number rfc1757StatsPkts128To255Octets;	
		public Number rfc1757StatsPkts256To511Octets;	
		public Number rfc1757StatsPkts512To1023Octets;	
		public Number rfc1757StatsPkts64Octets;	
		public Number rfc1757StatsPkts65To127Octets;	
		public Number rfc1757StatsPkts;	
		public Number rfc1757StatsRXNoErrors;	
		public Number rfc1757StatsTXNoErrors;	
		public Number rfc1757StatsUndersizePkts;	
		public Number rfc2233IfHCInBroadcastPkts;	
		public Number rfc2233IfHCInMulticastPkts;	
		public Number rfc2233IfHCInOctets;	
		public Number rfc2233IfHCInUcastPkts;	
		public Number rfc2233IfHCOutBroadcastPckts;	
		public Number rfc2233IfHCOutMulticastPkts;	
		public Number rfc2233IfHCOutOctets;	
		public Number rfc2233IfHCOutUcastPkts;	
		public Number rfc2665Dot3ControlInUnknownOpcodes;	
		public Number rfc2665Dot3InPauseFrames;	
		public Number rfc2665Dot3OutPauseFrames;	
		public Number rfc2665Dot3StatsAlignmentErrors;	
		public Number rfc2665Dot3StatsCarrierSenseErrors;	
		public Number rfc2665Dot3StatsDeferredTransmissions;	
		public Number rfc2665Dot3StatsExcessiveCollisions;	
		public Number rfc2665Dot3StatsFCSErrors;	
		public Number rfc2665Dot3StatsFrameTooLongs;	
		public Number rfc2665Dot3StatsInternalMacReceiveErrors;	
		public Number rfc2665Dot3StatsInternalMacTransmitErrors;	
		public Number rfc2665Dot3StatsLateCollisions;	
		public Number rfc2665Dot3StatsMultipleCollisionFrames;	
		public Number rfc2665Dot3StatsSQETTestErrors;	
		public Number rfc2665Dot3StatsSingleCollisionFrames;	
		public Number rfc2665Dot3StatsSymbolErrors;	
		public String type; //'CommonStatistics'
	}

	public class FcStatistics {
		public Number fcBBCreditFrameFailures;	
		public Number fcTotalTxFrames;	
		public Number fcLinkFailures;	
		public Number portNumber;	
		public Number fcRxByteRate;	
		public Number fcInvalidTxWords;	
		public Number fcSmoothingOverflowErrors;	
		public Number fcInvalidCRC;	
		public Number fcRxLinkResets;	
		public Number fcTotalRxFrames;	
		public Number fcClass2TxFrames;	
		public Number fcTotalRxBytes;	
		public Number fcFBSYFrames;	
		public Number fcRxFrameRate;	
		public Number fcClass2RxFrames;	
		public Number fcTxOfflineSequences;	
		public Number fcRxOfflineSequences;	
		public Number fcTxLinkResets;	
		public Number fcNumberOfflineSequences;	
		public Number fcDecodeErrors;	
		public Number fcFRJTFrames;	
		public Number fcClass3RxFrames;	
		public Number fcClass3Discards;	
		public Number fcNumberLinkResets;	
		public Number fcTxByteRate;	
		public Number fcTxFrameRate;	
		public Number fcTotalTxBytes;	
		public Number fcAddressErrors;	
		public Number fcPrimitiveSeqProtocolErrors;	
		public Number fcFramesTruncated;	
		public Number fcBBCreditRRDYFailures;	
		public Number fcFramesTooLong;	
		public Number fcClass3TxFrames;	
		public Number fcLossOfSynchronization;	
		public String type;	// 'FcStatistics'
	}
	
	public class AdvancedStatistics {
		public Number linkChanges;
		public String transmitNonunicastPacketsPerSec;
		public String transmitPacketsPerSec;
		public String transmitKilobitsPerSec;
		public String receiveKilobytesPerSec;
		public String receivePacketsPerSec;
		public Number resetTimeEpoch;
		public Number portNumber;
		public String receiveNonunicastPacketsPerSec;
		public String receiveKilobitsPerSec;
		public String transmitKilobytesPerSec;
		public String type;	// 'AdvancedStatistics'
	}

	public AdvancedStatistics advancedStatistics;
	public CommonStatistics   commonStatistics;
	public FcStatistics 	  fcStatistics;
	public String 			  portName;
	public Number 			  portNumber;
	public SubportStatistics [] subportStatistics;
	public String			  switchId;
	public String 			  type; // 'PortStaticics'
}
