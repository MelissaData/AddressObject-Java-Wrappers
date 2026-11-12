package com.melissadata;

public class mdStreetJNI {
	static {
		try {
			System.loadLibrary("mdAddrJavaWrapper");
		} catch (UnsatisfiedLinkError ule) {
			System.out.println(ule);
			System.out.println("java.library.path="+System.getProperty("java.library.path"));
		}
	}

	public final static native long mdStreetCreate();
	public final static native void mdStreetDestroy(long I);
	public final static native int Initialize(long I,String DataPath,String NationalPath,String RegionalPath);
	public final static native String GetInitializeErrorString(long I);
	public final static native String GetDatabaseDate(long I);
	public final static native String GetBuildNumber(long I);
	public final static native boolean SetLicenseString(long I,String License);
	public final static native String GetLicenseExpirationDate(long I);
	public final static native boolean FindStreet(long I,String StreetName,String ZIP,boolean CodeOnly);
	public final static native boolean FindStreetNext(long I);
	public final static native boolean IsAddressInRange(long I,String InputRange,String LoRange,String HiRange);
	public final static native boolean IsAddressInRange2(long I,String InputRange,String LoRange,String HiRange,String OddEvenFlag);
	public final static native String GetAutoCompletion(long I,String Address,String Zip,int mode,boolean DPVOnly);
	public final static native void ResetAutoCompletion(long I);
	public final static native String GetBaseAlternateIndicator(long I);
	public final static native String GetLACSIndicator(long I);
	public final static native String GetUrbanizationCode(long I);
	public final static native String GetUrbanizationName(long I);
	public final static native String GetLastLineNumber(long I);
	public final static native String GetAddressType(long I);
	public final static native String GetCongressionalDistrict(long I);
	public final static native String GetCountyFips(long I);
	public final static native String GetCompany(long I);
	public final static native String GetCarrierRoute(long I);
	public final static native String GetZip(long I);
	public final static native String GetDeliveryInstallation(long I);
	public final static native String GetPlus4High(long I);
	public final static native String GetPlus4Low(long I);
	public final static native String GetSuiteRangeOddEven(long I);
	public final static native String GetSuiteRangeHigh(long I);
	public final static native String GetSuiteRangeLow(long I);
	public final static native String GetSuiteName(long I);
	public final static native String GetPostDirection(long I);
	public final static native String GetSuffix(long I);
	public final static native String GetStreetName(long I);
	public final static native String GetPreDirection(long I);
	public final static native String GetPrimaryRangeOddEven(long I);
	public final static native String GetPrimaryRangeHigh(long I);
	public final static native String GetPrimaryRangeLow(long I);
}
