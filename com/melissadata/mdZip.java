package com.melissadata;

public class mdZip {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdZip obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

public final static class ProgramStatus {
	public final static mdZip.ProgramStatus ErrorNone=new mdZip.ProgramStatus("ErrorNone",0);
	public final static mdZip.ProgramStatus ErrorOther=new mdZip.ProgramStatus("ErrorOther",1);
	public final static mdZip.ProgramStatus ErrorOutOfMemory=new mdZip.ProgramStatus("ErrorOutOfMemory",2);
	public final static mdZip.ProgramStatus ErrorRequiredFileNotFound=new mdZip.ProgramStatus("ErrorRequiredFileNotFound",3);
	public final static mdZip.ProgramStatus ErrorFoundOldFile=new mdZip.ProgramStatus("ErrorFoundOldFile",4);
	public final static mdZip.ProgramStatus ErrorDatabaseExpired=new mdZip.ProgramStatus("ErrorDatabaseExpired",5);
	public final static mdZip.ProgramStatus ErrorLicenseExpired=new mdZip.ProgramStatus("ErrorLicenseExpired",6);

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
	public final static mdZip.AccessType Local=new mdZip.AccessType("Local",0);
	public final static mdZip.AccessType Remote=new mdZip.AccessType("Remote",1);

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
	public final static mdZip.DiacriticsMode Auto=new mdZip.DiacriticsMode("Auto",0);
	public final static mdZip.DiacriticsMode On=new mdZip.DiacriticsMode("On",1);
	public final static mdZip.DiacriticsMode Off=new mdZip.DiacriticsMode("Off",2);

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
	public final static mdZip.StandardizeMode ShortFormat=new mdZip.StandardizeMode("ShortFormat",0);
	public final static mdZip.StandardizeMode LongFormat=new mdZip.StandardizeMode("LongFormat",1);
	public final static mdZip.StandardizeMode AutoFormat=new mdZip.StandardizeMode("AutoFormat",2);

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
	public final static mdZip.SuiteParseMode ParseSuite=new mdZip.SuiteParseMode("ParseSuite",0);
	public final static mdZip.SuiteParseMode CombineSuite=new mdZip.SuiteParseMode("CombineSuite",1);

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
	public final static mdZip.AliasPreserveMode ConvertAlias=new mdZip.AliasPreserveMode("ConvertAlias",0);
	public final static mdZip.AliasPreserveMode PreserveAlias=new mdZip.AliasPreserveMode("PreserveAlias",1);

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
	public final static mdZip.AutoCompletionMode AutoCompleteSingleSuite=new mdZip.AutoCompletionMode("AutoCompleteSingleSuite",0);
	public final static mdZip.AutoCompletionMode AutoCompleteRangedSuite=new mdZip.AutoCompletionMode("AutoCompleteRangedSuite",1);
	public final static mdZip.AutoCompletionMode AutoCompletePlaceHolderSuite=new mdZip.AutoCompletionMode("AutoCompletePlaceHolderSuite",2);
	public final static mdZip.AutoCompletionMode AutoCompleteNoSuite=new mdZip.AutoCompletionMode("AutoCompleteNoSuite",3);

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
	public final static mdZip.ResultCdDescOpt ResultCodeDescriptionLong=new mdZip.ResultCdDescOpt("ResultCodeDescriptionLong",0);
	public final static mdZip.ResultCdDescOpt ResultCodeDescriptionShort=new mdZip.ResultCdDescOpt("ResultCodeDescriptionShort",1);

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
	public final static mdZip.MailboxLookupMode MailboxNone=new mdZip.MailboxLookupMode("MailboxNone",0);
	public final static mdZip.MailboxLookupMode MailboxExpress=new mdZip.MailboxLookupMode("MailboxExpress",1);
	public final static mdZip.MailboxLookupMode MailboxPremium=new mdZip.MailboxLookupMode("MailboxPremium",2);

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

	protected mdZip(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdZip() {
		this(mdZipJNI.mdZipCreate(),true);
	}

	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdZipJNI.mdZipDestroy(I);
			}
			I=0;
		}
	}

	public ProgramStatus Initialize(String p1, String p2, String p3) {
		return ProgramStatus.toEnum(mdZipJNI.Initialize(I,p1,p2,p3));
	}

	public String GetInitializeErrorString() {
		return mdZipJNI.GetInitializeErrorString(I);
	}

	public String GetDatabaseDate() {
		return mdZipJNI.GetDatabaseDate(I);
	}

	public String GetBuildNumber() {
		return mdZipJNI.GetBuildNumber(I);
	}

	public boolean SetLicenseString(String p1) {
		return mdZipJNI.SetLicenseString(I,p1);
	}

	public String GetLicenseExpirationDate() {
		return mdZipJNI.GetLicenseExpirationDate(I);
	}

	public boolean FindZip(String p1, boolean p2) {
		return mdZipJNI.FindZip(I,p1,p2);
	}

	public boolean FindZipNext() {
		return mdZipJNI.FindZipNext(I);
	}

	public boolean FindZipInCity(String p1, String p2) {
		return mdZipJNI.FindZipInCity(I,p1,p2);
	}

	public boolean FindZipInCityNext() {
		return mdZipJNI.FindZipInCityNext(I);
	}

	public boolean FindCityInState(String p1, String p2) {
		return mdZipJNI.FindCityInState(I,p1,p2);
	}

	public boolean FindCityInStateNext() {
		return mdZipJNI.FindCityInStateNext(I);
	}

	public double ComputeDistance(double p1, double p2, double p3, double p4) {
		return mdZipJNI.ComputeDistance(I,p1,p2,p3,p4);
	}

	public double ComputeBearing(double p1, double p2, double p3, double p4) {
		return mdZipJNI.ComputeBearing(I,p1,p2,p3,p4);
	}

	public String GetCountyNameFromFips(String p1) {
		return mdZipJNI.GetCountyNameFromFips(I,p1);
	}

	public String GetZip() {
		return mdZipJNI.GetZip(I);
	}

	public String GetCity() {
		return mdZipJNI.GetCity(I);
	}

	public String GetCityAbbreviation() {
		return mdZipJNI.GetCityAbbreviation(I);
	}

	public String GetState() {
		return mdZipJNI.GetState(I);
	}

	public String GetZipType() {
		return mdZipJNI.GetZipType(I);
	}

	public String GetCountyName() {
		return mdZipJNI.GetCountyName(I);
	}

	public String GetCountyFips() {
		return mdZipJNI.GetCountyFips(I);
	}

	public String GetAreaCode() {
		return mdZipJNI.GetAreaCode(I);
	}

	public String GetLongitude() {
		return mdZipJNI.GetLongitude(I);
	}

	public String GetLatitude() {
		return mdZipJNI.GetLatitude(I);
	}

	public String GetTimeZone() {
		return mdZipJNI.GetTimeZone(I);
	}

	public String GetTimeZoneCode() {
		return mdZipJNI.GetTimeZoneCode(I);
	}

	public String GetMsa() {
		return mdZipJNI.GetMsa(I);
	}

	public String GetPmsa() {
		return mdZipJNI.GetPmsa(I);
	}

	public String GetFacilityCode() {
		return mdZipJNI.GetFacilityCode(I);
	}

	public String GetLastLineIndicator() {
		return mdZipJNI.GetLastLineIndicator(I);
	}

	public String GetLastLineNumber() {
		return mdZipJNI.GetLastLineNumber(I);
	}

	public String GetPreferredLastLineNumber() {
		return mdZipJNI.GetPreferredLastLineNumber(I);
	}

	public String GetAutomation() {
		return mdZipJNI.GetAutomation(I);
	}

	public String GetFinanceNumber() {
		return mdZipJNI.GetFinanceNumber(I);
	}

}
