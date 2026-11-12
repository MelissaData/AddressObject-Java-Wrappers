package com.melissadata;

/**
 * Looks up valid address ranges for a given street name and ZIP code
 *
 * Use FindStreet and FindStreetNext to iterate over matching street records
 */
public class mdStreet {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdStreet obj) {
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
		public final static mdStreet.ProgramStatus ErrorNone=new mdStreet.ProgramStatus("ErrorNone",0);
		/** Could not open the mdAddr.dat file */
		public final static mdStreet.ProgramStatus ErrorOther=new mdStreet.ProgramStatus("ErrorOther",1);
		/** Out of memory */
		public final static mdStreet.ProgramStatus ErrorOutOfMemory=new mdStreet.ProgramStatus("ErrorOutOfMemory",2);
		/** A required data file could not be found */
		public final static mdStreet.ProgramStatus ErrorRequiredFileNotFound=new mdStreet.ProgramStatus("ErrorRequiredFileNotFound",3);
		/** Conflicts found between two or more data files */
		public final static mdStreet.ProgramStatus ErrorFoundOldFile=new mdStreet.ProgramStatus("ErrorFoundOldFile",4);
		/** The database has expired */
		public final static mdStreet.ProgramStatus ErrorDatabaseExpired=new mdStreet.ProgramStatus("ErrorDatabaseExpired",5);
		/** The license has expired */
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

	/**
	 * Controls how suite information is presented in GetAutoCompletion suggestions
 	*/
	public final static class AutoCompletionMode {
		/** Show each individual suite */
		public final static mdStreet.AutoCompletionMode AutoCompleteSingleSuite=new mdStreet.AutoCompletionMode("AutoCompleteSingleSuite",0);
		/** Show the suite ranges */
		public final static mdStreet.AutoCompletionMode AutoCompleteRangedSuite=new mdStreet.AutoCompletionMode("AutoCompleteRangedSuite",1);
		/** Use a '#' to denote where a suite should go */
		public final static mdStreet.AutoCompletionMode AutoCompletePlaceHolderSuite=new mdStreet.AutoCompletionMode("AutoCompletePlaceHolderSuite",2);
		/** Do not show suites */
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

	/**
	 * Constructs a new StreetData instance
	 *
	 */
	protected mdStreet(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdStreet() {
		this(mdStreetJNI.mdStreetCreate(),true);
	}

	/**
	 * Destroys an existing StreetData instance
	 *
	 */
	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdStreetJNI.mdStreetDestroy(I);
			}
			I=0;
		}
	}

	/**
	 * Opens the required data files and prepares the StreetData interface for use
	 *
	 * @param DataPath Path to the mdAddr.dat file
	 * @param NationalPath Path to the mdAddr.nat file
	 * @param RegionalPath Deprecated; pass an empty string if required by the language
	 * @return ProgramStatus enum - ErrorNone (0) on success; use GetInitializeErrorString to retrieve the nature of any other error
	 */
	public ProgramStatus Initialize(String DataPath, String NationalPath, String RegionalPath) {
		return ProgramStatus.toEnum(mdStreetJNI.Initialize(I,DataPath,NationalPath,RegionalPath));
	}

	/**
	 * Returns a description of the error from the last Initialize call
	 *
	 * @return Error description string
	 */
	public String GetInitializeErrorString() {
		return mdStreetJNI.GetInitializeErrorString(I);
	}

	/**
	 * Returns the date of the US address data files
	 *
	 * @return Database date string in yyyy-mm-dd format
	 */
	public String GetDatabaseDate() {
		return mdStreetJNI.GetDatabaseDate(I);
	}

	/**
	 * Returns the current build number of Address Object
	 *
	 * @return Build number string
	 */
	public String GetBuildNumber() {
		return mdStreetJNI.GetBuildNumber(I);
	}

	/**
	 * Sets the license string required to enable full StreetData functionality
	 *
	 * @param License The software license key
	 * @return True (1) if the specified license is correct
	 */
	public boolean SetLicenseString(String License) {
		return mdStreetJNI.SetLicenseString(I,License);
	}

	/**
	 * Returns the expiration date of the current license string
	 *
	 * @return License expiration date string
	 */
	public String GetLicenseExpirationDate() {
		return mdStreetJNI.GetLicenseExpirationDate(I);
	}

	/**
	 * Retrieves the first address range matching the given street name pattern and ZIP code
	 *
	 * @param StreetName Street name to search; wildcards allowed at end (e.g. "MA*")
	 * @param ZIP Five-digit ZIP code to search within
	 * @param CodeOnly If true, restricts results to the exact ZIP code; if false, includes the surrounding city
	 * @return True (1) if a matching record was found
	 */
	public boolean FindStreet(String StreetName, String ZIP, boolean CodeOnly) {
		return mdStreetJNI.FindStreet(I,StreetName,ZIP,CodeOnly);
	}

	/**
	 * Retrieves the next matching address range after a successful FindStreet call
	 *
	 * @return True (1) if another record was found, false (0) if no more records
	 */
	public boolean FindStreetNext() {
		return mdStreetJNI.FindStreetNext(I);
	}

	/**
	 * Determines if an address number falls within a street address range
	 *
	 * @deprecated Use IsAddressInRange2 instead.
	 *
	 * @param InputRange Address number to test
	 * @param LoRange Low end of the valid range
	 * @param HiRange High end of the valid range
	 * @return True (1) if the address falls within the range
	 */
@Deprecated
	public boolean IsAddressInRange(String InputRange, String LoRange, String HiRange) {
		return mdStreetJNI.IsAddressInRange(I,InputRange,LoRange,HiRange);
	}

	/**
	 * Determines if an address number falls within a street address range and matches the odd/even indicator. Supersedes the older IsAddressInRange function, which did not account for odd/even ranges
	 *
	 * @param InputRange Address number to test (from input address)
	 * @param LoRange Low end of the valid range (from GetPrimaryRangeLow)
	 * @param HiRange High end of the valid range (from GetPrimaryRangeHigh)
	 * @param OddEvenFlag Odd/even indicator from GetPrimaryRangeOddEven
	 * @return True (1) if the address is within range and matches the odd/even indicator
	 */
	public boolean IsAddressInRange2(String InputRange, String LoRange, String HiRange, String OddEvenFlag) {
		return mdStreetJNI.IsAddressInRange2(I,InputRange,LoRange,HiRange,OddEvenFlag);
	}

	/**
	 * Returns one possible street address suggestion for auto-complete based on partial address and ZIP code
	 *
	 * @param Address Full or partial street address input
	 * @param Zip Five-digit US ZIP code
	 * @param mode AutoCompletionMode enum controlling suite display (SingleSuite, RangedSuite, PlaceHolderSuite, NoSuite)
	 * @param DPVOnly If true, returns only DPV-confirmed addresses
	 * @return Suggested address string, or empty string when no more suggestions remain
	 */
	public String GetAutoCompletion(String Address, String Zip, mdStreet.AutoCompletionMode mode, boolean DPVOnly) {
		return mdStreetJNI.GetAutoCompletion(I,Address,Zip,mode.toValue(),DPVOnly);
	}

	/**
	 * Resets the auto-completion state to prepare for a new address lookup
	 *
	 */
	public void ResetAutoCompletion() {
		mdStreetJNI.ResetAutoCompletion(I);
	}

	/**
	 * Returns whether the matched street record is a base or alternate record
	 *
	 * @return "B" for base (preferred) record, "A" for alternate record
	 */
	public String GetBaseAlternateIndicator() {
		return mdStreetJNI.GetBaseAlternateIndicator(I);
	}

	/**
	 * Returns whether the street address has undergone a rural-to-city-style conversion
	 *
	 * @return "L" if converted, empty if not
	 */
	public String GetLACSIndicator() {
		return mdStreetJNI.GetLACSIndicator(I);
	}

	/**
	 * Returns the urbanization code for Puerto Rican street records
	 *
	 * @return Urbanization code string (max 6 characters)
	 */
	public String GetUrbanizationCode() {
		return mdStreetJNI.GetUrbanizationCode(I);
	}

	/**
	 * Returns the urbanization name for Puerto Rican street records
	 *
	 * @return Urbanization name string
	 */
	public String GetUrbanizationName() {
		return mdStreetJNI.GetUrbanizationName(I);
	}

	/**
	 * Returns the last line number used for advanced address matching tie-breaking
	 *
	 * @return Last line number string (max 6 characters)
	 */
	public String GetLastLineNumber() {
		return mdStreetJNI.GetLastLineNumber(I);
	}

	/**
	 * Returns the address type code for the matched street record
	 *
	 * @return S=Street, P=PO Box, H=High Rise, R=Rural Route, F=Firm, G=General Delivery
	 */
	public String GetAddressType() {
		return mdStreetJNI.GetAddressType(I);
	}

	/**
	 * Returns the congressional district for the matched street record
	 *
	 * @return State abbreviation plus two-digit district number (e.g. "CA01")
	 */
	public String GetCongressionalDistrict() {
		return mdStreetJNI.GetCongressionalDistrict(I);
	}

	/**
	 * Returns the five-digit county FIPS code for the matched street record
	 *
	 * @return Five-digit FIPS code (e.g. "06037" for Los Angeles CA)
	 */
	public String GetCountyFips() {
		return mdStreetJNI.GetCountyFips(I);
	}

	/**
	 * Returns the company or building name associated with the matched street record
	 *
	 * @return Company name string (max 40 characters)
	 */
	public String GetCompany() {
		return mdStreetJNI.GetCompany(I);
	}

	/**
	 * Returns the carrier route code for the matched street record
	 *
	 * @return Four-character carrier route code (e.g. "C027")
	 */
	public String GetCarrierRoute() {
		return mdStreetJNI.GetCarrierRoute(I);
	}

	/**
	 * Returns the five-digit ZIP code for the matched street record
	 *
	 * @return Five-digit ZIP code string
	 */
	public String GetZip() {
		return mdStreetJNI.GetZip(I);
	}

	/**
	 * Returns the delivery installation for matched Canadian street records
	 *
	 * @return Delivery installation string
	 */
	public String GetDeliveryInstallation() {
		return mdStreetJNI.GetDeliveryInstallation(I);
	}

	/**
	 * Returns the highest Plus4 code in the range for the matched street record
	 *
	 * @return Four-digit Plus4 high value string
	 */
	public String GetPlus4High() {
		return mdStreetJNI.GetPlus4High(I);
	}

	/**
	 * Returns the lowest Plus4 code in the range for the matched street record
	 *
	 * @return Four-digit Plus4 low value string
	 */
	public String GetPlus4Low() {
		return mdStreetJNI.GetPlus4Low(I);
	}

	/**
	 * Returns the odd/even indicator for the suite range of the matched street record
	 *
	 * @return "O" for odd only, "E" for even only, "B" for both
	 */
	public String GetSuiteRangeOddEven() {
		return mdStreetJNI.GetSuiteRangeOddEven(I);
	}

	/**
	 * Returns the highest suite number in the range for the matched street record
	 *
	 * @return Suite range high value string (max 8 characters)
	 */
	public String GetSuiteRangeHigh() {
		return mdStreetJNI.GetSuiteRangeHigh(I);
	}

	/**
	 * Returns the lowest suite number in the range for the matched street record
	 *
	 * @return Suite range low value string (max 8 characters)
	 */
	public String GetSuiteRangeLow() {
		return mdStreetJNI.GetSuiteRangeLow(I);
	}

	/**
	 * Returns the suite designator for the matched street record
	 *
	 * @return Suite designator string (e.g. "APT", "STE", "UNIT")
	 */
	public String GetSuiteName() {
		return mdStreetJNI.GetSuiteName(I);
	}

	/**
	 * Returns the directional following the street name for the matched street record
	 *
	 * @return Post-directional string (e.g. "N", "NE", "SW")
	 */
	public String GetPostDirection() {
		return mdStreetJNI.GetPostDirection(I);
	}

	/**
	 * Returns the street suffix for the matched street record
	 *
	 * @return Street suffix string (e.g. "ST", "AVE", "BLVD")
	 */
	public String GetSuffix() {
		return mdStreetJNI.GetSuffix(I);
	}

	/**
	 * Returns the street name for the matched street record
	 *
	 * @return Street name string (max 28 characters)
	 */
	public String GetStreetName() {
		return mdStreetJNI.GetStreetName(I);
	}

	/**
	 * Returns the directional preceding the street name for the matched street record
	 *
	 * @return Pre-directional string (e.g. "N", "NE", "SW")
	 */
	public String GetPreDirection() {
		return mdStreetJNI.GetPreDirection(I);
	}

	/**
	 * Returns the odd/even indicator for the primary address range of the matched street record
	 *
	 * @return "O" for odd only, "E" for even only, "B" for both
	 */
	public String GetPrimaryRangeOddEven() {
		return mdStreetJNI.GetPrimaryRangeOddEven(I);
	}

	/**
	 * Returns the highest street number in the primary address range of the matched record
	 *
	 * @return Primary range high value string (10 digits, zero-padded)
	 */
	public String GetPrimaryRangeHigh() {
		return mdStreetJNI.GetPrimaryRangeHigh(I);
	}

	/**
	 * Returns the lowest street number in the primary address range of the matched record
	 *
	 * @return Primary range low value string (10 digits, zero-padded)
	 */
	public String GetPrimaryRangeLow() {
		return mdStreetJNI.GetPrimaryRangeLow(I);
	}

}
