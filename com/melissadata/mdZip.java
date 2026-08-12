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
