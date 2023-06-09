package com.melissadata;

public class mdStreet {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdStreet obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

public final static class ProgramStatus {
	public final static mdStreet.ProgramStatus ErrorNone=new mdStreet.ProgramStatus("ErrorNone",0);
	public final static mdStreet.ProgramStatus ErrorOther=new mdStreet.ProgramStatus("ErrorOther",1);
	public final static mdStreet.ProgramStatus ErrorOutOfMemory=new mdStreet.ProgramStatus("ErrorOutOfMemory",2);
	public final static mdStreet.ProgramStatus ErrorRequiredFileNotFound=new mdStreet.ProgramStatus("ErrorRequiredFileNotFound",3);
	public final static mdStreet.ProgramStatus ErrorFoundOldFile=new mdStreet.ProgramStatus("ErrorFoundOldFile",4);
	public final static mdStreet.ProgramStatus ErrorDatabaseExpired=new mdStreet.ProgramStatus("ErrorDatabaseExpired",5);
	public final static mdStreet.ProgramStatus ErrorLicenseExpired=new mdStreet.ProgramStatus("ErrorLicenseExpired",6);

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
	public final static mdStreet.AccessType Local=new mdStreet.AccessType("Local",0);
	public final static mdStreet.AccessType Remote=new mdStreet.AccessType("Remote",1);

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
	public final static mdStreet.DiacriticsMode Auto=new mdStreet.DiacriticsMode("Auto",0);
	public final static mdStreet.DiacriticsMode On=new mdStreet.DiacriticsMode("On",1);
	public final static mdStreet.DiacriticsMode Off=new mdStreet.DiacriticsMode("Off",2);

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
	public final static mdStreet.StandardizeMode ShortFormat=new mdStreet.StandardizeMode("ShortFormat",0);
	public final static mdStreet.StandardizeMode LongFormat=new mdStreet.StandardizeMode("LongFormat",1);
	public final static mdStreet.StandardizeMode AutoFormat=new mdStreet.StandardizeMode("AutoFormat",2);

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
	public final static mdStreet.SuiteParseMode ParseSuite=new mdStreet.SuiteParseMode("ParseSuite",0);
	public final static mdStreet.SuiteParseMode CombineSuite=new mdStreet.SuiteParseMode("CombineSuite",1);

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
	public final static mdStreet.AliasPreserveMode ConvertAlias=new mdStreet.AliasPreserveMode("ConvertAlias",0);
	public final static mdStreet.AliasPreserveMode PreserveAlias=new mdStreet.AliasPreserveMode("PreserveAlias",1);

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
	public final static mdStreet.AutoCompletionMode AutoCompleteSingleSuite=new mdStreet.AutoCompletionMode("AutoCompleteSingleSuite",0);
	public final static mdStreet.AutoCompletionMode AutoCompleteRangedSuite=new mdStreet.AutoCompletionMode("AutoCompleteRangedSuite",1);
	public final static mdStreet.AutoCompletionMode AutoCompletePlaceHolderSuite=new mdStreet.AutoCompletionMode("AutoCompletePlaceHolderSuite",2);
	public final static mdStreet.AutoCompletionMode AutoCompleteNoSuite=new mdStreet.AutoCompletionMode("AutoCompleteNoSuite",3);

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
	public final static mdStreet.ResultCdDescOpt ResultCodeDescriptionLong=new mdStreet.ResultCdDescOpt("ResultCodeDescriptionLong",0);
	public final static mdStreet.ResultCdDescOpt ResultCodeDescriptionShort=new mdStreet.ResultCdDescOpt("ResultCodeDescriptionShort",1);

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
	public final static mdStreet.MailboxLookupMode MailboxNone=new mdStreet.MailboxLookupMode("MailboxNone",0);
	public final static mdStreet.MailboxLookupMode MailboxExpress=new mdStreet.MailboxLookupMode("MailboxExpress",1);
	public final static mdStreet.MailboxLookupMode MailboxPremium=new mdStreet.MailboxLookupMode("MailboxPremium",2);

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

	protected mdStreet(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdStreet() {
		this(mdStreetJNI.mdStreetCreate(),true);
	}

	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdStreetJNI.mdStreetDestroy(I);
			}
			I=0;
		}
	}

	public ProgramStatus Initialize(String p1, String p2, String p3) {
		return ProgramStatus.toEnum(mdStreetJNI.Initialize(I,p1,p2,p3));
	}

	public String GetInitializeErrorString() {
		return mdStreetJNI.GetInitializeErrorString(I);
	}

	public String GetDatabaseDate() {
		return mdStreetJNI.GetDatabaseDate(I);
	}

	public String GetBuildNumber() {
		return mdStreetJNI.GetBuildNumber(I);
	}

	public boolean SetLicenseString(String p1) {
		return mdStreetJNI.SetLicenseString(I,p1);
	}

	public String GetLicenseExpirationDate() {
		return mdStreetJNI.GetLicenseExpirationDate(I);
	}

	public boolean FindStreet(String p1, String p2, boolean p3) {
		return mdStreetJNI.FindStreet(I,p1,p2,p3);
	}

	public boolean FindStreetNext() {
		return mdStreetJNI.FindStreetNext(I);
	}

	public boolean IsAddressInRange(String p1, String p2, String p3) {
		return mdStreetJNI.IsAddressInRange(I,p1,p2,p3);
	}

	public boolean IsAddressInRange2(String p1, String p2, String p3, String p4) {
		return mdStreetJNI.IsAddressInRange2(I,p1,p2,p3,p4);
	}

	public String GetAutoCompletion(String p1, String p2, mdStreet.AutoCompletionMode p3, boolean p4) {
		return mdStreetJNI.GetAutoCompletion(I,p1,p2,p3.toValue(),p4);
	}

	public void ResetAutoCompletion() {
		mdStreetJNI.ResetAutoCompletion(I);
	}

	public String GetBaseAlternateIndicator() {
		return mdStreetJNI.GetBaseAlternateIndicator(I);
	}

	public String GetLACSIndicator() {
		return mdStreetJNI.GetLACSIndicator(I);
	}

	public String GetUrbanizationCode() {
		return mdStreetJNI.GetUrbanizationCode(I);
	}

	public String GetUrbanizationName() {
		return mdStreetJNI.GetUrbanizationName(I);
	}

	public String GetLastLineNumber() {
		return mdStreetJNI.GetLastLineNumber(I);
	}

	public String GetAddressType() {
		return mdStreetJNI.GetAddressType(I);
	}

	public String GetCongressionalDistrict() {
		return mdStreetJNI.GetCongressionalDistrict(I);
	}

	public String GetCountyFips() {
		return mdStreetJNI.GetCountyFips(I);
	}

	public String GetCompany() {
		return mdStreetJNI.GetCompany(I);
	}

	public String GetCarrierRoute() {
		return mdStreetJNI.GetCarrierRoute(I);
	}

	public String GetZip() {
		return mdStreetJNI.GetZip(I);
	}

	public String GetDeliveryInstallation() {
		return mdStreetJNI.GetDeliveryInstallation(I);
	}

	public String GetPlus4High() {
		return mdStreetJNI.GetPlus4High(I);
	}

	public String GetPlus4Low() {
		return mdStreetJNI.GetPlus4Low(I);
	}

	public String GetSuiteRangeOddEven() {
		return mdStreetJNI.GetSuiteRangeOddEven(I);
	}

	public String GetSuiteRangeHigh() {
		return mdStreetJNI.GetSuiteRangeHigh(I);
	}

	public String GetSuiteRangeLow() {
		return mdStreetJNI.GetSuiteRangeLow(I);
	}

	public String GetSuiteName() {
		return mdStreetJNI.GetSuiteName(I);
	}

	public String GetPostDirection() {
		return mdStreetJNI.GetPostDirection(I);
	}

	public String GetSuffix() {
		return mdStreetJNI.GetSuffix(I);
	}

	public String GetStreetName() {
		return mdStreetJNI.GetStreetName(I);
	}

	public String GetPreDirection() {
		return mdStreetJNI.GetPreDirection(I);
	}

	public String GetPrimaryRangeOddEven() {
		return mdStreetJNI.GetPrimaryRangeOddEven(I);
	}

	public String GetPrimaryRangeHigh() {
		return mdStreetJNI.GetPrimaryRangeHigh(I);
	}

	public String GetPrimaryRangeLow() {
		return mdStreetJNI.GetPrimaryRangeLow(I);
	}

}
