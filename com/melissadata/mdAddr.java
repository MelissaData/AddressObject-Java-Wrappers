package com.melissadata;

public class mdAddr {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdAddr obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

public final static class ProgramStatus {
	public final static mdAddr.ProgramStatus ErrorNone=new mdAddr.ProgramStatus("ErrorNone",0);
	public final static mdAddr.ProgramStatus ErrorOther=new mdAddr.ProgramStatus("ErrorOther",1);
	public final static mdAddr.ProgramStatus ErrorOutOfMemory=new mdAddr.ProgramStatus("ErrorOutOfMemory",2);
	public final static mdAddr.ProgramStatus ErrorRequiredFileNotFound=new mdAddr.ProgramStatus("ErrorRequiredFileNotFound",3);
	public final static mdAddr.ProgramStatus ErrorFoundOldFile=new mdAddr.ProgramStatus("ErrorFoundOldFile",4);
	public final static mdAddr.ProgramStatus ErrorDatabaseExpired=new mdAddr.ProgramStatus("ErrorDatabaseExpired",5);
	public final static mdAddr.ProgramStatus ErrorLicenseExpired=new mdAddr.ProgramStatus("ErrorLicenseExpired",6);

	private final String enumName;
	private final int enumValue;
	private static ProgramStatus[] enumValues={ErrorNone,ErrorOther,ErrorOutOfMemory,ErrorRequiredFileNotFound,ErrorFoundOldFile,ErrorDatabaseExpired,ErrorLicenseExpired};

	private ProgramStatus(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static ProgramStatus toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+ProgramStatus.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class AccessType {
	public final static mdAddr.AccessType Local=new mdAddr.AccessType("Local",0);
	public final static mdAddr.AccessType Remote=new mdAddr.AccessType("Remote",1);

	private final String enumName;
	private final int enumValue;
	private static AccessType[] enumValues={Local,Remote};

	private AccessType(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static AccessType toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+AccessType.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class DiacriticsMode {
	public final static mdAddr.DiacriticsMode Auto=new mdAddr.DiacriticsMode("Auto",0);
	public final static mdAddr.DiacriticsMode On=new mdAddr.DiacriticsMode("On",1);
	public final static mdAddr.DiacriticsMode Off=new mdAddr.DiacriticsMode("Off",2);

	private final String enumName;
	private final int enumValue;
	private static DiacriticsMode[] enumValues={Auto,On,Off};

	private DiacriticsMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static DiacriticsMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+DiacriticsMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class StandardizeMode {
	public final static mdAddr.StandardizeMode ShortFormat=new mdAddr.StandardizeMode("ShortFormat",0);
	public final static mdAddr.StandardizeMode LongFormat=new mdAddr.StandardizeMode("LongFormat",1);
	public final static mdAddr.StandardizeMode AutoFormat=new mdAddr.StandardizeMode("AutoFormat",2);

	private final String enumName;
	private final int enumValue;
	private static StandardizeMode[] enumValues={ShortFormat,LongFormat,AutoFormat};

	private StandardizeMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static StandardizeMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+StandardizeMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class SuiteParseMode {
	public final static mdAddr.SuiteParseMode ParseSuite=new mdAddr.SuiteParseMode("ParseSuite",0);
	public final static mdAddr.SuiteParseMode CombineSuite=new mdAddr.SuiteParseMode("CombineSuite",1);

	private final String enumName;
	private final int enumValue;
	private static SuiteParseMode[] enumValues={ParseSuite,CombineSuite};

	private SuiteParseMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static SuiteParseMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+SuiteParseMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class AliasPreserveMode {
	public final static mdAddr.AliasPreserveMode ConvertAlias=new mdAddr.AliasPreserveMode("ConvertAlias",0);
	public final static mdAddr.AliasPreserveMode PreserveAlias=new mdAddr.AliasPreserveMode("PreserveAlias",1);

	private final String enumName;
	private final int enumValue;
	private static AliasPreserveMode[] enumValues={ConvertAlias,PreserveAlias};

	private AliasPreserveMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static AliasPreserveMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+AliasPreserveMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class AutoCompletionMode {
	public final static mdAddr.AutoCompletionMode AutoCompleteSingleSuite=new mdAddr.AutoCompletionMode("AutoCompleteSingleSuite",0);
	public final static mdAddr.AutoCompletionMode AutoCompleteRangedSuite=new mdAddr.AutoCompletionMode("AutoCompleteRangedSuite",1);
	public final static mdAddr.AutoCompletionMode AutoCompletePlaceHolderSuite=new mdAddr.AutoCompletionMode("AutoCompletePlaceHolderSuite",2);
	public final static mdAddr.AutoCompletionMode AutoCompleteNoSuite=new mdAddr.AutoCompletionMode("AutoCompleteNoSuite",3);

	private final String enumName;
	private final int enumValue;
	private static AutoCompletionMode[] enumValues={AutoCompleteSingleSuite,AutoCompleteRangedSuite,AutoCompletePlaceHolderSuite,AutoCompleteNoSuite};

	private AutoCompletionMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static AutoCompletionMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+AutoCompletionMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class ResultCdDescOpt {
	public final static mdAddr.ResultCdDescOpt ResultCodeDescriptionLong=new mdAddr.ResultCdDescOpt("ResultCodeDescriptionLong",0);
	public final static mdAddr.ResultCdDescOpt ResultCodeDescriptionShort=new mdAddr.ResultCdDescOpt("ResultCodeDescriptionShort",1);

	private final String enumName;
	private final int enumValue;
	private static ResultCdDescOpt[] enumValues={ResultCodeDescriptionLong,ResultCodeDescriptionShort};

	private ResultCdDescOpt(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static ResultCdDescOpt toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+ResultCdDescOpt.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class MailboxLookupMode {
	public final static mdAddr.MailboxLookupMode MailboxNone=new mdAddr.MailboxLookupMode("MailboxNone",0);
	public final static mdAddr.MailboxLookupMode MailboxExpress=new mdAddr.MailboxLookupMode("MailboxExpress",1);
	public final static mdAddr.MailboxLookupMode MailboxPremium=new mdAddr.MailboxLookupMode("MailboxPremium",2);

	private final String enumName;
	private final int enumValue;
	private static MailboxLookupMode[] enumValues={MailboxNone,MailboxExpress,MailboxPremium};

	private MailboxLookupMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static MailboxLookupMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+MailboxLookupMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

	protected mdAddr(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdAddr() {
		this(mdAddrJNI.mdAddrCreate(),true);
	}

	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdAddrJNI.mdAddrDestroy(I);
			}
			I=0;
		}
	}

	public ProgramStatus Initialize(String p1, String p2, String p3) {
		return ProgramStatus.toEnum(mdAddrJNI.Initialize(I,p1,p2,p3));
	}

	public ProgramStatus InitializeDataFiles() {
		return ProgramStatus.toEnum(mdAddrJNI.InitializeDataFiles(I));
	}

	public String GetInitializeErrorString() {
		return mdAddrJNI.GetInitializeErrorString(I);
	}

	public boolean SetLicenseString(String p1) {
		return mdAddrJNI.SetLicenseString(I,p1);
	}

	public String GetBuildNumber() {
		return mdAddrJNI.GetBuildNumber(I);
	}

	public String GetDatabaseDate() {
		return mdAddrJNI.GetDatabaseDate(I);
	}

	public String GetExpirationDate() {
		return mdAddrJNI.GetExpirationDate(I);
	}

	public String GetLicenseExpirationDate() {
		return mdAddrJNI.GetLicenseExpirationDate(I);
	}

	public String GetCanadianDatabaseDate() {
		return mdAddrJNI.GetCanadianDatabaseDate(I);
	}

	public String GetCanadianExpirationDate() {
		return mdAddrJNI.GetCanadianExpirationDate(I);
	}

	public void SetPathToUSFiles(String p1) {
		mdAddrJNI.SetPathToUSFiles(I,p1);
	}

	public void SetPathToCanadaFiles(String p1) {
		mdAddrJNI.SetPathToCanadaFiles(I,p1);
	}

	public void SetPathToDPVDataFiles(String p1) {
		mdAddrJNI.SetPathToDPVDataFiles(I,p1);
	}

	public void SetPathToLACSLinkDataFiles(String p1) {
		mdAddrJNI.SetPathToLACSLinkDataFiles(I,p1);
	}

	public void SetPathToSuiteLinkDataFiles(String p1) {
		mdAddrJNI.SetPathToSuiteLinkDataFiles(I,p1);
	}

	public void SetPathToSuiteFinderDataFiles(String p1) {
		mdAddrJNI.SetPathToSuiteFinderDataFiles(I,p1);
	}

	public void SetPathToRBDIFiles(String p1) {
		mdAddrJNI.SetPathToRBDIFiles(I,p1);
	}

	public String GetRBDIDatabaseDate() {
		return mdAddrJNI.GetRBDIDatabaseDate(I);
	}

	public void SetPathToAddrKeyDataFiles(String p1) {
		mdAddrJNI.SetPathToAddrKeyDataFiles(I,p1);
	}

	public void ClearProperties() {
		mdAddrJNI.ClearProperties(I);
	}

	public void ResetDPV() {
		mdAddrJNI.ResetDPV(I);
	}

	public void SetCASSEnable(int p1) {
		mdAddrJNI.SetCASSEnable(I,p1);
	}

	public void SetUseUSPSPreferredCityNames(int p1) {
		mdAddrJNI.SetUseUSPSPreferredCityNames(I,p1);
	}

	public void SetDiacritics(mdAddr.DiacriticsMode p1) {
		mdAddrJNI.SetDiacritics(I,p1.toValue());
	}

	public String GetStatusCode() {
		return mdAddrJNI.GetStatusCode(I);
	}

	public String GetErrorCode() {
		return mdAddrJNI.GetErrorCode(I);
	}

	public String GetErrorString() {
		return mdAddrJNI.GetErrorString(I);
	}

	public String GetResults() {
		return mdAddrJNI.GetResults(I);
	}

	public String GetResultCodeDescription(String resultCode) {
		return mdAddrJNI.GetResultCodeDescription(I,resultCode,0);
	}
	public String GetResultCodeDescription(String resultCode, mdAddr.ResultCdDescOpt opt) {
		return mdAddrJNI.GetResultCodeDescription(I,resultCode,opt.toValue());
	}

	public void SetPS3553_B1_ProcessorName(String p1) {
		mdAddrJNI.SetPS3553_B1_ProcessorName(I,p1);
	}

	public void SetPS3553_B4_ListName(String p1) {
		mdAddrJNI.SetPS3553_B4_ListName(I,p1);
	}

	public void SetPS3553_D3_Name(String p1) {
		mdAddrJNI.SetPS3553_D3_Name(I,p1);
	}

	public void SetPS3553_D3_Company(String p1) {
		mdAddrJNI.SetPS3553_D3_Company(I,p1);
	}

	public void SetPS3553_D3_Address(String p1) {
		mdAddrJNI.SetPS3553_D3_Address(I,p1);
	}

	public void SetPS3553_D3_City(String p1) {
		mdAddrJNI.SetPS3553_D3_City(I,p1);
	}

	public void SetPS3553_D3_State(String p1) {
		mdAddrJNI.SetPS3553_D3_State(I,p1);
	}

	public void SetPS3553_D3_ZIP(String p1) {
		mdAddrJNI.SetPS3553_D3_ZIP(I,p1);
	}

	public String GetFormPS3553() {
		return mdAddrJNI.GetFormPS3553(I);
	}

	public boolean SaveFormPS3553(String p1) {
		return mdAddrJNI.SaveFormPS3553(I,p1);
	}

	public void ResetFormPS3553() {
		mdAddrJNI.ResetFormPS3553(I);
	}

	public void ResetFormPS3553Counter() {
		mdAddrJNI.ResetFormPS3553Counter(I);
	}

	public void SetStandardizationType(mdAddr.StandardizeMode mode) {
		mdAddrJNI.SetStandardizationType(I,mode.toValue());
	}

	public void SetSuiteParseMode(mdAddr.SuiteParseMode mode) {
		mdAddrJNI.SetSuiteParseMode(I,mode.toValue());
	}

	public void SetAliasMode(mdAddr.AliasPreserveMode mode) {
		mdAddrJNI.SetAliasMode(I,mode.toValue());
	}

	public String GetFormSOA() {
		return mdAddrJNI.GetFormSOA(I);
	}

	public void SaveFormSOA(String p1) {
		mdAddrJNI.SaveFormSOA(I,p1);
	}

	public void ResetFormSOA() {
		mdAddrJNI.ResetFormSOA(I);
	}

	public void SetSOACustomerInfo(String customerName, String customerAddress) {
		mdAddrJNI.SetSOACustomerInfo(I,customerName,customerAddress);
	}

	public void SetSOACPCNumber(String CPCNumber) {
		mdAddrJNI.SetSOACPCNumber(I,CPCNumber);
	}

	public String GetSOACustomerInfo() {
		return mdAddrJNI.GetSOACustomerInfo(I);
	}

	public String GetSOACPCNumber() {
		return mdAddrJNI.GetSOACPCNumber(I);
	}

	public long GetSOATotalRecords() {
		return mdAddrJNI.GetSOATotalRecords(I);
	}

	public float GetSOAAAPercentage() {
		return mdAddrJNI.GetSOAAAPercentage(I);
	}

	public String GetSOAAAExpiryDate() {
		return mdAddrJNI.GetSOAAAExpiryDate(I);
	}

	public String GetSOASoftwareInfo() {
		return mdAddrJNI.GetSOASoftwareInfo(I);
	}

	public String GetSOAErrorString() {
		return mdAddrJNI.GetSOAErrorString(I);
	}

	public void SetCompany(String p1) {
		mdAddrJNI.SetCompany(I,p1);
	}

	public void SetLastName(String p1) {
		mdAddrJNI.SetLastName(I,p1);
	}

	public void SetAddress(String p1) {
		mdAddrJNI.SetAddress(I,p1);
	}

	public void SetAddress2(String p1) {
		mdAddrJNI.SetAddress2(I,p1);
	}

	public void SetLastLine(String p1) {
		mdAddrJNI.SetLastLine(I,p1);
	}

	public void SetSuite(String p1) {
		mdAddrJNI.SetSuite(I,p1);
	}

	public void SetCity(String p1) {
		mdAddrJNI.SetCity(I,p1);
	}

	public void SetState(String p1) {
		mdAddrJNI.SetState(I,p1);
	}

	public void SetZip(String p1) {
		mdAddrJNI.SetZip(I,p1);
	}

	public void SetPlus4(String p1) {
		mdAddrJNI.SetPlus4(I,p1);
	}

	public void SetUrbanization(String p1) {
		mdAddrJNI.SetUrbanization(I,p1);
	}

	public void SetParsedAddressRange(String p1) {
		mdAddrJNI.SetParsedAddressRange(I,p1);
	}

	public void SetParsedPreDirection(String p1) {
		mdAddrJNI.SetParsedPreDirection(I,p1);
	}

	public void SetParsedStreetName(String p1) {
		mdAddrJNI.SetParsedStreetName(I,p1);
	}

	public void SetParsedSuffix(String p1) {
		mdAddrJNI.SetParsedSuffix(I,p1);
	}

	public void SetParsedPostDirection(String p1) {
		mdAddrJNI.SetParsedPostDirection(I,p1);
	}

	public void SetParsedSuiteName(String p1) {
		mdAddrJNI.SetParsedSuiteName(I,p1);
	}

	public void SetParsedSuiteRange(String p1) {
		mdAddrJNI.SetParsedSuiteRange(I,p1);
	}

	public void SetParsedRouteService(String p1) {
		mdAddrJNI.SetParsedRouteService(I,p1);
	}

	public void SetParsedLockBox(String p1) {
		mdAddrJNI.SetParsedLockBox(I,p1);
	}

	public void SetParsedDeliveryInstallation(String p1) {
		mdAddrJNI.SetParsedDeliveryInstallation(I,p1);
	}

	public void SetCountryCode(String p1) {
		mdAddrJNI.SetCountryCode(I,p1);
	}

	public boolean VerifyAddress() {
		return mdAddrJNI.VerifyAddress(I);
	}

	public String GetCompany() {
		return mdAddrJNI.GetCompany(I);
	}

	public String GetLastName() {
		return mdAddrJNI.GetLastName(I);
	}

	public String GetAddress() {
		return mdAddrJNI.GetAddress(I);
	}

	public String GetAddress2() {
		return mdAddrJNI.GetAddress2(I);
	}

	public String GetSuite() {
		return mdAddrJNI.GetSuite(I);
	}

	public String GetCity() {
		return mdAddrJNI.GetCity(I);
	}

	public String GetCityAbbreviation() {
		return mdAddrJNI.GetCityAbbreviation(I);
	}

	public String GetState() {
		return mdAddrJNI.GetState(I);
	}

	public String GetZip() {
		return mdAddrJNI.GetZip(I);
	}

	public String GetPlus4() {
		return mdAddrJNI.GetPlus4(I);
	}

	public String GetCarrierRoute() {
		return mdAddrJNI.GetCarrierRoute(I);
	}

	public String GetDeliveryPointCode() {
		return mdAddrJNI.GetDeliveryPointCode(I);
	}

	public String GetDeliveryPointCheckDigit() {
		return mdAddrJNI.GetDeliveryPointCheckDigit(I);
	}

	public String GetCountyFips() {
		return mdAddrJNI.GetCountyFips(I);
	}

	public String GetCountyName() {
		return mdAddrJNI.GetCountyName(I);
	}

	public String GetAddressTypeCode() {
		return mdAddrJNI.GetAddressTypeCode(I);
	}

	public String GetAddressTypeString() {
		return mdAddrJNI.GetAddressTypeString(I);
	}

	public String GetUrbanization() {
		return mdAddrJNI.GetUrbanization(I);
	}

	public String GetCongressionalDistrict() {
		return mdAddrJNI.GetCongressionalDistrict(I);
	}

	public String GetLACS() {
		return mdAddrJNI.GetLACS(I);
	}

	public String GetLACSLinkIndicator() {
		return mdAddrJNI.GetLACSLinkIndicator(I);
	}

	public String GetPrivateMailbox() {
		return mdAddrJNI.GetPrivateMailbox(I);
	}

	public String GetTimeZoneCode() {
		return mdAddrJNI.GetTimeZoneCode(I);
	}

	public String GetTimeZone() {
		return mdAddrJNI.GetTimeZone(I);
	}

	public String GetMsa() {
		return mdAddrJNI.GetMsa(I);
	}

	public String GetPmsa() {
		return mdAddrJNI.GetPmsa(I);
	}

	public String GetDefaultFlagIndicator() {
		return mdAddrJNI.GetDefaultFlagIndicator(I);
	}

	public String GetSuiteStatus() {
		return mdAddrJNI.GetSuiteStatus(I);
	}

	public String GetEWSFlag() {
		return mdAddrJNI.GetEWSFlag(I);
	}

	public String GetCMRA() {
		return mdAddrJNI.GetCMRA(I);
	}

	public String GetDsfVacant() {
		return mdAddrJNI.GetDsfVacant(I);
	}

	public String GetCountryCode() {
		return mdAddrJNI.GetCountryCode(I);
	}

	public String GetZipType() {
		return mdAddrJNI.GetZipType(I);
	}

	public String GetFalseTable() {
		return mdAddrJNI.GetFalseTable(I);
	}

	public String GetDPVFootnotes() {
		return mdAddrJNI.GetDPVFootnotes(I);
	}

	public String GetLACSLinkReturnCode() {
		return mdAddrJNI.GetLACSLinkReturnCode(I);
	}

	public String GetSuiteLinkReturnCode() {
		return mdAddrJNI.GetSuiteLinkReturnCode(I);
	}

	public String GetRBDI() {
		return mdAddrJNI.GetRBDI(I);
	}

	public String GetELotNumber() {
		return mdAddrJNI.GetELotNumber(I);
	}

	public String GetELotOrder() {
		return mdAddrJNI.GetELotOrder(I);
	}

	public String GetAddressKey() {
		return mdAddrJNI.GetAddressKey(I);
	}

	public String GetMelissaAddressKey() {
		return mdAddrJNI.GetMelissaAddressKey(I);
	}

	public String GetMelissaAddressKeyBase() {
		return mdAddrJNI.GetMelissaAddressKeyBase(I);
	}

	public String GetOutputParameter(String p1) {
		return mdAddrJNI.GetOutputParameter(I,p1);
	}

	public int SetInputParameter(String p1, String p2) {
		return mdAddrJNI.SetInputParameter(I,p1,p2);
	}

	public boolean FindSuggestion() {
		return mdAddrJNI.FindSuggestion(I);
	}

	public boolean FindSuggestionNext() {
		return mdAddrJNI.FindSuggestionNext(I);
	}

	public String GetDsfNoStats() {
		return mdAddrJNI.GetDsfNoStats(I);
	}

	public String GetDsfDNA() {
		return mdAddrJNI.GetDsfDNA(I);
	}

	public int GetPS3553_B6_TotalRecords() {
		return mdAddrJNI.GetPS3553_B6_TotalRecords(I);
	}

	public int GetPS3553_C1a_ZIP4Coded() {
		return mdAddrJNI.GetPS3553_C1a_ZIP4Coded(I);
	}

	public int GetPS3553_C1c_DPBCAssigned() {
		return mdAddrJNI.GetPS3553_C1c_DPBCAssigned(I);
	}

	public int GetPS3553_C1d_FiveDigitCoded() {
		return mdAddrJNI.GetPS3553_C1d_FiveDigitCoded(I);
	}

	public int GetPS3553_C1e_CRRTCoded() {
		return mdAddrJNI.GetPS3553_C1e_CRRTCoded(I);
	}

	public int GetPS3553_C1f_eLOTAssigned() {
		return mdAddrJNI.GetPS3553_C1f_eLOTAssigned(I);
	}

	public int GetPS3553_E_HighRiseDefault() {
		return mdAddrJNI.GetPS3553_E_HighRiseDefault(I);
	}

	public int GetPS3553_E_HighRiseExact() {
		return mdAddrJNI.GetPS3553_E_HighRiseExact(I);
	}

	public int GetPS3553_E_RuralRouteDefault() {
		return mdAddrJNI.GetPS3553_E_RuralRouteDefault(I);
	}

	public int GetPS3553_E_RuralRouteExact() {
		return mdAddrJNI.GetPS3553_E_RuralRouteExact(I);
	}

	public int GetZip4HRDefault() {
		return mdAddrJNI.GetZip4HRDefault(I);
	}

	public int GetZip4HRExact() {
		return mdAddrJNI.GetZip4HRExact(I);
	}

	public int GetZip4RRDefault() {
		return mdAddrJNI.GetZip4RRDefault(I);
	}

	public int GetZip4RRExact() {
		return mdAddrJNI.GetZip4RRExact(I);
	}

	public int GetPS3553_E_LACSCount() {
		return mdAddrJNI.GetPS3553_E_LACSCount(I);
	}

	public int GetPS3553_E_EWSCount() {
		return mdAddrJNI.GetPS3553_E_EWSCount(I);
	}

	public int GetPS3553_E_DPVCount() {
		return mdAddrJNI.GetPS3553_E_DPVCount(I);
	}

	public int GetPS3553_X_POBoxCount() {
		return mdAddrJNI.GetPS3553_X_POBoxCount(I);
	}

	public int GetPS3553_X_HCExactCount() {
		return mdAddrJNI.GetPS3553_X_HCExactCount(I);
	}

	public int GetPS3553_X_FirmCount() {
		return mdAddrJNI.GetPS3553_X_FirmCount(I);
	}

	public int GetPS3553_X_GenDeliveryCount() {
		return mdAddrJNI.GetPS3553_X_GenDeliveryCount(I);
	}

	public int GetPS3553_X_MilitaryZipCount() {
		return mdAddrJNI.GetPS3553_X_MilitaryZipCount(I);
	}

	public int GetPS3553_X_NonDeliveryCount() {
		return mdAddrJNI.GetPS3553_X_NonDeliveryCount(I);
	}

	public int GetPS3553_X_StreetCount() {
		return mdAddrJNI.GetPS3553_X_StreetCount(I);
	}

	public int GetPS3553_X_HCDefaultCount() {
		return mdAddrJNI.GetPS3553_X_HCDefaultCount(I);
	}

	public int GetPS3553_X_OtherCount() {
		return mdAddrJNI.GetPS3553_X_OtherCount(I);
	}

	public int GetPS3553_X_LacsLinkCodeACount() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCodeACount(I);
	}

	public int GetPS3553_X_LacsLinkCode00Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode00Count(I);
	}

	public int GetPS3553_X_LacsLinkCode14Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode14Count(I);
	}

	public int GetPS3553_X_LacsLinkCode92Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode92Count(I);
	}

	public int GetPS3553_X_LacsLinkCode09Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode09Count(I);
	}

	public int GetPS3553_X_SuiteLinkCodeACount() {
		return mdAddrJNI.GetPS3553_X_SuiteLinkCodeACount(I);
	}

	public int GetPS3553_X_SuiteLinkCode00Count() {
		return mdAddrJNI.GetPS3553_X_SuiteLinkCode00Count(I);
	}

	public String GetParsedAddressRange() {
		return mdAddrJNI.GetParsedAddressRange(I);
	}

	public String GetParsedPreDirection() {
		return mdAddrJNI.GetParsedPreDirection(I);
	}

	public String GetParsedStreetName() {
		return mdAddrJNI.GetParsedStreetName(I);
	}

	public String GetParsedSuffix() {
		return mdAddrJNI.GetParsedSuffix(I);
	}

	public String GetParsedPostDirection() {
		return mdAddrJNI.GetParsedPostDirection(I);
	}

	public String GetParsedSuiteName() {
		return mdAddrJNI.GetParsedSuiteName(I);
	}

	public String GetParsedSuiteRange() {
		return mdAddrJNI.GetParsedSuiteRange(I);
	}

	public String GetParsedPrivateMailboxName() {
		return mdAddrJNI.GetParsedPrivateMailboxName(I);
	}

	public String GetParsedPrivateMailboxNumber() {
		return mdAddrJNI.GetParsedPrivateMailboxNumber(I);
	}

	public String GetParsedGarbage() {
		return mdAddrJNI.GetParsedGarbage(I);
	}

	public String GetParsedRouteService() {
		return mdAddrJNI.GetParsedRouteService(I);
	}

	public String GetParsedLockBox() {
		return mdAddrJNI.GetParsedLockBox(I);
	}

	public String GetParsedDeliveryInstallation() {
		return mdAddrJNI.GetParsedDeliveryInstallation(I);
	}

	public void SetReserved(String p1, String p2) {
		mdAddrJNI.SetReserved(I,p1,p2);
	}

	public String GetReserved(String p1) {
		return mdAddrJNI.GetReserved(I,p1);
	}

}
