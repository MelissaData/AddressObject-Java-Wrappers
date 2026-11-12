package com.melissadata;

/**
 * Parses a street address string into its component parts without requiring data file initialization
 *
 * Lighter-weight alternative to AddressCheck when full verification is not needed
 */
public class mdParse {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdParse obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

	/**
	 * Programming, installation, and execution error codes returned by Initialize
 	*/
	public final static class ProgramStatus {
		/** No error - initialization was successful */
		public final static mdParse.ProgramStatus ErrorNone=new mdParse.ProgramStatus("ErrorNone",0);
		/** Could not open the required data file */
		public final static mdParse.ProgramStatus ErrorOther=new mdParse.ProgramStatus("ErrorOther",1);
		/** Out of memory */
		public final static mdParse.ProgramStatus ErrorOutOfMemory=new mdParse.ProgramStatus("ErrorOutOfMemory",2);
		/** A required data file could not be found */
		public final static mdParse.ProgramStatus ErrorRequiredFileNotFound=new mdParse.ProgramStatus("ErrorRequiredFileNotFound",3);
		/** Conflicts found between two or more data files */
		public final static mdParse.ProgramStatus ErrorFoundOldFile=new mdParse.ProgramStatus("ErrorFoundOldFile",4);
		/** The database has expired */
		public final static mdParse.ProgramStatus ErrorDatabaseExpired=new mdParse.ProgramStatus("ErrorDatabaseExpired",5);
		/** The license has expired */
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

	/**
	 * Constructs a new Parse instance
	 *
	 */
	protected mdParse(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdParse() {
		this(mdParseJNI.mdParseCreate(),true);
	}

	/**
	 * Destroys an existing Parse instance
	 *
	 */
	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdParseJNI.mdParseDestroy(I);
			}
			I=0;
		}
	}

	/**
	 * Initializes the Parse interface
	 *
	 * @param DataPath Path to data files (optional for basic parsing)
	 * @return ProgramStatus enum - ErrorNone (0) on success
	 */
	public ProgramStatus Initialize(String DataPath) {
		return ProgramStatus.toEnum(mdParseJNI.Initialize(I,DataPath));
	}

	/**
	 * Returns the current build number of Address Object
	 *
	 * @return Build number string
	 */
	public String GetBuildNumber() {
		return mdParseJNI.GetBuildNumber(I);
	}

	/**
	 * Parses a US street address string into its individual components
	 *
	 * @param AddressToParse Full street address string to parse (e.g. "123 N Main St E Apt 3")
	 */
	public void Parse(String AddressToParse) {
		mdParseJNI.Parse(I,AddressToParse);
	}

	/**
	 * Parses a Canadian street address string into its individual components
	 *
	 * @param AddressToParse Full Canadian street address string to parse
	 */
	public void ParseCanadian(String AddressToParse) {
		mdParseJNI.ParseCanadian(I,AddressToParse);
	}

	/**
	 * Returns an alternate parsing of the address previously submitted to Parse or ParseCanadian
	 *
	 * @return True (1) if another parse variant was found, false (0) if no more variants
	 */
	public boolean ParseNext() {
		return mdParseJNI.ParseNext(I);
	}

	/**
	 * Parses a combined city, state, and ZIP code string into separate components
	 *
	 * @param LastLine Combined last line string (e.g. "Rancho Santa Margarita, CA 92688-2112")
	 */
	public void LastLineParse(String LastLine) {
		mdParseJNI.LastLineParse(I,LastLine);
	}

	/**
	 * Returns the ZIP code from the parsed address
	 *
	 * @return Five-digit ZIP code or Canadian postal code string
	 */
	public String GetZip() {
		return mdParseJNI.GetZip(I);
	}

	/**
	 * Returns the four-digit ZIP+4 extension from the parsed last line
	 *
	 * @return Plus4 string
	 */
	public String GetPlus4() {
		return mdParseJNI.GetPlus4(I);
	}

	/**
	 * Returns the city name from the parsed last line
	 *
	 * @return City name string
	 */
	public String GetCity() {
		return mdParseJNI.GetCity(I);
	}

	/**
	 * Returns the two-letter state or province abbreviation from the parsed last line
	 *
	 * @return State abbreviation string
	 */
	public String GetState() {
		return mdParseJNI.GetState(I);
	}

	/**
	 * Returns the street name from the parsed address
	 *
	 * @return Street name string (max 28 characters)
	 */
	public String GetStreetName() {
		return mdParseJNI.GetStreetName(I);
	}

	/**
	 * Returns the delivery number from the parsed address
	 *
	 * @return Address range string (max 10 characters)
	 */
	public String GetRange() {
		return mdParseJNI.GetRange(I);
	}

	/**
	 * Returns the directional preceding the street name from the parsed address
	 *
	 * @return Pre-directional string (e.g. "N", "NE", "SW")
	 */
	public String GetPreDirection() {
		return mdParseJNI.GetPreDirection(I);
	}

	/**
	 * Returns the directional following the street name from the parsed address
	 *
	 * @return Post-directional string (e.g. "N", "NE", "SW")
	 */
	public String GetPostDirection() {
		return mdParseJNI.GetPostDirection(I);
	}

	/**
	 * Returns the street suffix from the parsed address
	 *
	 * @return Street suffix string (e.g. "ST", "AVE", "BLVD")
	 */
	public String GetSuffix() {
		return mdParseJNI.GetSuffix(I);
	}

	/**
	 * Returns the secondary unit designator from the parsed address
	 *
	 * @return Suite designator string (e.g. "APT", "STE", "UNIT")
	 */
	public String GetSuiteName() {
		return mdParseJNI.GetSuiteName(I);
	}

	/**
	 * Returns the secondary unit number from the parsed address
	 *
	 * @return Suite number string (max 6 characters)
	 */
	public String GetSuiteNumber() {
		return mdParseJNI.GetSuiteNumber(I);
	}

	/**
	 * Returns the private mailbox number from the parsed address
	 *
	 * @return PMB number string
	 */
	public String GetPrivateMailboxNumber() {
		return mdParseJNI.GetPrivateMailboxNumber(I);
	}

	/**
	 * Returns the private mailbox designator from the parsed address
	 *
	 * @return PMB designator string ("PMB" or "#")
	 */
	public String GetPrivateMailboxName() {
		return mdParseJNI.GetPrivateMailboxName(I);
	}

	/**
	 * Returns any unrecognized characters remaining after parsing
	 *
	 * @return Garbage string (max 50 characters)
	 */
	public String GetGarbage() {
		return mdParseJNI.GetGarbage(I);
	}

	/**
	 * Returns the route service information from the parsed Canadian address
	 *
	 * @return Route service string
	 */
	public String GetRouteService() {
		return mdParseJNI.GetRouteService(I);
	}

	/**
	 * Returns the lock box information from the parsed Canadian address
	 *
	 * @return Lock box string
	 */
	public String GetLockBox() {
		return mdParseJNI.GetLockBox(I);
	}

	/**
	 * Returns the delivery installation information from the parsed Canadian address
	 *
	 * @return Delivery installation string
	 */
	public String GetDeliveryInstallation() {
		return mdParseJNI.GetDeliveryInstallation(I);
	}

}
