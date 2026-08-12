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
