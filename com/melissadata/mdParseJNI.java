package com.melissadata;

public class mdParseJNI {
	static {
		try {
			System.loadLibrary("mdAddrJavaWrapper");
		} catch (UnsatisfiedLinkError ule) {
			System.out.println(ule);
			System.out.println("java.library.path="+System.getProperty("java.library.path"));
		}
	}

	public final static native long mdParseCreate();
	public final static native void mdParseDestroy(long I);
	public final static native int Initialize(long I,String p1);
	public final static native String GetBuildNumber(long I);
	public final static native void Parse(long I,String p1);
	public final static native void ParseCanadian(long I,String p1);
	public final static native boolean ParseNext(long I);
	public final static native void LastLineParse(long I,String p1);
	public final static native String GetZip(long I);
	public final static native String GetPlus4(long I);
	public final static native String GetCity(long I);
	public final static native String GetState(long I);
	public final static native String GetStreetName(long I);
	public final static native String GetRange(long I);
	public final static native String GetPreDirection(long I);
	public final static native String GetPostDirection(long I);
	public final static native String GetSuffix(long I);
	public final static native String GetSuiteName(long I);
	public final static native String GetSuiteNumber(long I);
	public final static native String GetPrivateMailboxNumber(long I);
	public final static native String GetPrivateMailboxName(long I);
	public final static native String GetGarbage(long I);
	public final static native String GetRouteService(long I);
	public final static native String GetLockBox(long I);
	public final static native String GetDeliveryInstallation(long I);
}
