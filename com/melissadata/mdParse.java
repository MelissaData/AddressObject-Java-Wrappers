package com.melissadata;

public class mdParse {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdParse obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

public final static class ProgramStatus {
	public final static mdParse.ProgramStatus ErrorNone=new mdParse.ProgramStatus("ErrorNone",0);
	public final static mdParse.ProgramStatus ErrorOther=new mdParse.ProgramStatus("ErrorOther",1);
	public final static mdParse.ProgramStatus ErrorOutOfMemory=new mdParse.ProgramStatus("ErrorOutOfMemory",2);
	public final static mdParse.ProgramStatus ErrorRequiredFileNotFound=new mdParse.ProgramStatus("ErrorRequiredFileNotFound",3);
	public final static mdParse.ProgramStatus ErrorFoundOldFile=new mdParse.ProgramStatus("ErrorFoundOldFile",4);
	public final static mdParse.ProgramStatus ErrorDatabaseExpired=new mdParse.ProgramStatus("ErrorDatabaseExpired",5);
	public final static mdParse.ProgramStatus ErrorLicenseExpired=new mdParse.ProgramStatus("ErrorLicenseExpired",6);

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
	public final static mdParse.AccessType Local=new mdParse.AccessType("Local",0);
	public final static mdParse.AccessType Remote=new mdParse.AccessType("Remote",1);

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
	public final static mdParse.DiacriticsMode Auto=new mdParse.DiacriticsMode("Auto",0);
	public final static mdParse.DiacriticsMode On=new mdParse.DiacriticsMode("On",1);
	public final static mdParse.DiacriticsMode Off=new mdParse.DiacriticsMode("Off",2);

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
	public final static mdParse.StandardizeMode ShortFormat=new mdParse.StandardizeMode("ShortFormat",0);
	public final static mdParse.StandardizeMode LongFormat=new mdParse.StandardizeMode("LongFormat",1);
	public final static mdParse.StandardizeMode AutoFormat=new mdParse.StandardizeMode("AutoFormat",2);

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
	public final static mdParse.SuiteParseMode ParseSuite=new mdParse.SuiteParseMode("ParseSuite",0);
	public final static mdParse.SuiteParseMode CombineSuite=new mdParse.SuiteParseMode("CombineSuite",1);

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
	public final static mdParse.AliasPreserveMode ConvertAlias=new mdParse.AliasPreserveMode("ConvertAlias",0);
	public final static mdParse.AliasPreserveMode PreserveAlias=new mdParse.AliasPreserveMode("PreserveAlias",1);

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
	public final static mdParse.AutoCompletionMode AutoCompleteSingleSuite=new mdParse.AutoCompletionMode("AutoCompleteSingleSuite",0);
	public final static mdParse.AutoCompletionMode AutoCompleteRangedSuite=new mdParse.AutoCompletionMode("AutoCompleteRangedSuite",1);
	public final static mdParse.AutoCompletionMode AutoCompletePlaceHolderSuite=new mdParse.AutoCompletionMode("AutoCompletePlaceHolderSuite",2);
	public final static mdParse.AutoCompletionMode AutoCompleteNoSuite=new mdParse.AutoCompletionMode("AutoCompleteNoSuite",3);

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
	public final static mdParse.ResultCdDescOpt ResultCodeDescriptionLong=new mdParse.ResultCdDescOpt("ResultCodeDescriptionLong",0);
	public final static mdParse.ResultCdDescOpt ResultCodeDescriptionShort=new mdParse.ResultCdDescOpt("ResultCodeDescriptionShort",1);

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
	public final static mdParse.MailboxLookupMode MailboxNone=new mdParse.MailboxLookupMode("MailboxNone",0);
	public final static mdParse.MailboxLookupMode MailboxExpress=new mdParse.MailboxLookupMode("MailboxExpress",1);
	public final static mdParse.MailboxLookupMode MailboxPremium=new mdParse.MailboxLookupMode("MailboxPremium",2);

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

	protected mdParse(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdParse() {
		this(mdParseJNI.mdParseCreate(),true);
	}

	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdParseJNI.mdParseDestroy(I);
			}
			I=0;
		}
	}

	public ProgramStatus Initialize(String p1) {
		return ProgramStatus.toEnum(mdParseJNI.Initialize(I,p1));
	}

	public String GetBuildNumber() {
		return mdParseJNI.GetBuildNumber(I);
	}

	public void Parse(String p1) {
		mdParseJNI.Parse(I,p1);
	}

	public void ParseCanadian(String p1) {
		mdParseJNI.ParseCanadian(I,p1);
	}

	public boolean ParseNext() {
		return mdParseJNI.ParseNext(I);
	}

	public void LastLineParse(String p1) {
		mdParseJNI.LastLineParse(I,p1);
	}

	public String GetZip() {
		return mdParseJNI.GetZip(I);
	}

	public String GetPlus4() {
		return mdParseJNI.GetPlus4(I);
	}

	public String GetCity() {
		return mdParseJNI.GetCity(I);
	}

	public String GetState() {
		return mdParseJNI.GetState(I);
	}

	public String GetStreetName() {
		return mdParseJNI.GetStreetName(I);
	}

	public String GetRange() {
		return mdParseJNI.GetRange(I);
	}

	public String GetPreDirection() {
		return mdParseJNI.GetPreDirection(I);
	}

	public String GetPostDirection() {
		return mdParseJNI.GetPostDirection(I);
	}

	public String GetSuffix() {
		return mdParseJNI.GetSuffix(I);
	}

	public String GetSuiteName() {
		return mdParseJNI.GetSuiteName(I);
	}

	public String GetSuiteNumber() {
		return mdParseJNI.GetSuiteNumber(I);
	}

	public String GetPrivateMailboxNumber() {
		return mdParseJNI.GetPrivateMailboxNumber(I);
	}

	public String GetPrivateMailboxName() {
		return mdParseJNI.GetPrivateMailboxName(I);
	}

	public String GetGarbage() {
		return mdParseJNI.GetGarbage(I);
	}

	public String GetRouteService() {
		return mdParseJNI.GetRouteService(I);
	}

	public String GetLockBox() {
		return mdParseJNI.GetLockBox(I);
	}

	public String GetDeliveryInstallation() {
		return mdParseJNI.GetDeliveryInstallation(I);
	}

}
