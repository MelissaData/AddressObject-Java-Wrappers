package com.melissadata;

public class mdZipJNI {
	static {
		try {
			System.loadLibrary("mdAddrJavaWrapper");
		} catch (UnsatisfiedLinkError ule) {
			System.out.println(ule);
			System.out.println("java.library.path="+System.getProperty("java.library.path"));
		}
	}

	public final static native long mdZipCreate();
	public final static native void mdZipDestroy(long I);
	public final static native int Initialize(long I,String p1,String p2,String p3);
	public final static native String GetInitializeErrorString(long I);
	public final static native String GetDatabaseDate(long I);
	public final static native String GetBuildNumber(long I);
	public final static native boolean SetLicenseString(long I,String p1);
	public final static native String GetLicenseExpirationDate(long I);
	public final static native boolean FindZip(long I,String p1,boolean p2);
	public final static native boolean FindZipNext(long I);
	public final static native boolean FindZipInCity(long I,String p1,String p2);
	public final static native boolean FindZipInCityNext(long I);
	public final static native boolean FindCityInState(long I,String p1,String p2);
	public final static native boolean FindCityInStateNext(long I);
	public final static native double ComputeDistance(long I,double p1,double p2,double p3,double p4);
	public final static native double ComputeBearing(long I,double p1,double p2,double p3,double p4);
	public final static native String GetCountyNameFromFips(long I,String p1);
	public final static native String GetZip(long I);
	public final static native String GetCity(long I);
	public final static native String GetCityAbbreviation(long I);
	public final static native String GetState(long I);
	public final static native String GetZipType(long I);
	public final static native String GetCountyName(long I);
	public final static native String GetCountyFips(long I);
	public final static native String GetAreaCode(long I);
	public final static native String GetLongitude(long I);
	public final static native String GetLatitude(long I);
	public final static native String GetTimeZone(long I);
	public final static native String GetTimeZoneCode(long I);
	public final static native String GetMsa(long I);
	public final static native String GetPmsa(long I);
	public final static native String GetFacilityCode(long I);
	public final static native String GetLastLineIndicator(long I);
	public final static native String GetLastLineNumber(long I);
	public final static native String GetPreferredLastLineNumber(long I);
	public final static native String GetAutomation(long I);
	public final static native String GetFinanceNumber(long I);
}
