package com.melissadata;

/**
 * Looks up geographic data, city names, and postal information by ZIP code or city name
 *
 * Use FindZip, FindZipInCity, and FindCityInState to retrieve ZIP code and city records
 */
public class mdZip {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdZip obj) {
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
		public final static mdZip.ProgramStatus ErrorNone=new mdZip.ProgramStatus("ErrorNone",0);
		/** Could not open the mdAddr.dat file */
		public final static mdZip.ProgramStatus ErrorOther=new mdZip.ProgramStatus("ErrorOther",1);
		/** Out of memory */
		public final static mdZip.ProgramStatus ErrorOutOfMemory=new mdZip.ProgramStatus("ErrorOutOfMemory",2);
		/** A required data file could not be found */
		public final static mdZip.ProgramStatus ErrorRequiredFileNotFound=new mdZip.ProgramStatus("ErrorRequiredFileNotFound",3);
		/** Conflicts found between two or more data files */
		public final static mdZip.ProgramStatus ErrorFoundOldFile=new mdZip.ProgramStatus("ErrorFoundOldFile",4);
		/** The database has expired */
		public final static mdZip.ProgramStatus ErrorDatabaseExpired=new mdZip.ProgramStatus("ErrorDatabaseExpired",5);
		/** The license has expired */
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

	/**
	 * Constructs a new ZipData instance
	 *
	 */
	protected mdZip(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdZip() {
		this(mdZipJNI.mdZipCreate(),true);
	}

	/**
	 * Destroys an existing ZipData instance
	 *
	 */
	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdZipJNI.mdZipDestroy(I);
			}
			I=0;
		}
	}

	/**
	 * Opens the required data files and prepares the ZipData interface for use
	 *
	 * @param DataPath Path to the mdAddr.dat file
	 * @param NationalPath Path to the mdAddr.nat file
	 * @param RegionalPath Deprecated; pass an empty string if required by the language
	 * @return ProgramStatus enum - ErrorNone (0) on success; use GetInitializeErrorString to retrieve the nature of any other error
	 */
	public ProgramStatus Initialize(String DataPath, String NationalPath, String RegionalPath) {
		return ProgramStatus.toEnum(mdZipJNI.Initialize(I,DataPath,NationalPath,RegionalPath));
	}

	/**
	 * Returns a description of the error from the last Initialize call
	 *
	 * @return Error description string
	 */
	public String GetInitializeErrorString() {
		return mdZipJNI.GetInitializeErrorString(I);
	}

	/**
	 * Returns the date of the US address data files
	 *
	 * @return Database date string in yyyy-mm-dd format
	 */
	public String GetDatabaseDate() {
		return mdZipJNI.GetDatabaseDate(I);
	}

	/**
	 * Returns the current build number of Address Object
	 *
	 * @return Build number string
	 */
	public String GetBuildNumber() {
		return mdZipJNI.GetBuildNumber(I);
	}

	/**
	 * Sets the license string required to enable full ZipData functionality
	 *
	 * @param License The software license key
	 * @return True (1) if the specified license is correct
	 */
	public boolean SetLicenseString(String License) {
		return mdZipJNI.SetLicenseString(I,License);
	}

	/**
	 * Returns the expiration date of the current license string
	 *
	 * @return License expiration date string
	 */
	public String GetLicenseExpirationDate() {
		return mdZipJNI.GetLicenseExpirationDate(I);
	}

	/**
	 * Retrieves the first city record for the specified ZIP code
	 *
	 * @param Zip Five-digit ZIP code to look up
	 * @param GetLastLineRecord If true, returns only the official preferred city name record; disables FindZipNext
	 * @return True (1) if a record was found
	 */
	public boolean FindZip(String Zip, boolean GetLastLineRecord) {
		return mdZipJNI.FindZip(I,Zip,GetLastLineRecord);
	}

	/**
	 * Retrieves the next city record for the ZIP code passed to FindZip
	 *
	 * @return True (1) if another record was found, false (0) if no more records
	 */
	public boolean FindZipNext() {
		return mdZipJNI.FindZipNext(I);
	}

	/**
	 * Retrieves the first ZIP code record for the specified city and state
	 *
	 * @param City City name to look up (max 28 characters; wildcards allowed with *)
	 * @param State Two-character state abbreviation
	 * @return True (1) if a record was found
	 */
	public boolean FindZipInCity(String City, String State) {
		return mdZipJNI.FindZipInCity(I,City,State);
	}

	/**
	 * Retrieves the next ZIP code record for the city and state passed to FindZipInCity
	 *
	 * @return True (1) if another record was found, false (0) if no more records
	 */
	public boolean FindZipInCityNext() {
		return mdZipJNI.FindZipInCityNext(I);
	}

	/**
	 * Retrieves the first city record matching the given city name and state
	 *
	 * @param City City name to search (max 28 characters; wildcards allowed with *)
	 * @param State Two-character state abbreviation
	 * @return True (1) if a match was found
	 */
	public boolean FindCityInState(String City, String State) {
		return mdZipJNI.FindCityInState(I,City,State);
	}

	/**
	 * Retrieves the next matching city record after a successful FindCityInState call
	 *
	 * @return True (1) if another match was found, false (0) if no more records
	 */
	public boolean FindCityInStateNext() {
		return mdZipJNI.FindCityInStateNext(I);
	}

	/**
	 * Computes the distance in miles between two geographic coordinates
	 *
	 * @param lat1 Latitude of point 1 in degrees
	 * @param long1 Longitude of point 1 in degrees (negative for US)
	 * @param lat2 Latitude of point 2 in degrees
	 * @param long2 Longitude of point 2 in degrees (negative for US)
	 * @return Distance in miles, or 9999 if coordinates are invalid
	 */
	public double ComputeDistance(double lat1, double long1, double lat2, double long2) {
		return mdZipJNI.ComputeDistance(I,lat1,long1,lat2,long2);
	}

	/**
	 * Computes the compass bearing in degrees from point 1 to point 2
	 *
	 * @param lat1 Latitude of point 1 in degrees
	 * @param long1 Longitude of point 1 in degrees (negative for US)
	 * @param lat2 Latitude of point 2 in degrees
	 * @param long2 Longitude of point 2 in degrees (negative for US)
	 * @return Bearing in degrees (0=North, 90=East, 180=South, 270=West), or 999 if coordinates are invalid
	 */
	public double ComputeBearing(double lat1, double long1, double lat2, double long2) {
		return mdZipJNI.ComputeBearing(I,lat1,long1,lat2,long2);
	}

	/**
	 * Returns the county name for a given county FIPS code
	 *
	 * @param FipsCode Five-digit county FIPS code
	 * @return County name string
	 */
	public String GetCountyNameFromFips(String FipsCode) {
		return mdZipJNI.GetCountyNameFromFips(I,FipsCode);
	}

	/**
	 * Returns the five-digit ZIP code from the current ZipData record
	 *
	 * @return Five-digit ZIP code string
	 */
	public String GetZip() {
		return mdZipJNI.GetZip(I);
	}

	/**
	 * Returns the city name from the current ZipData record
	 *
	 * @return City name string (max 28 characters)
	 */
	public String GetCity() {
		return mdZipJNI.GetCity(I);
	}

	/**
	 * Returns the official USPS 13-character city name abbreviation from the current record
	 *
	 * @return City abbreviation (full city name if 13 characters or fewer)
	 */
	public String GetCityAbbreviation() {
		return mdZipJNI.GetCityAbbreviation(I);
	}

	/**
	 * Returns the two-letter state abbreviation from the current ZipData record
	 *
	 * @return Two-letter state abbreviation string
	 */
	public String GetState() {
		return mdZipJNI.GetState(I);
	}

	/**
	 * Returns the ZIP code type for the current record
	 *
	 * @return "P" for PO Box only, "U" for unique/institutional, "M" for military, empty for standard
	 */
	public String GetZipType() {
		return mdZipJNI.GetZipType(I);
	}

	/**
	 * Returns the county name for the current ZipData record
	 *
	 * @return County name string (max 25 characters)
	 */
	public String GetCountyName() {
		return mdZipJNI.GetCountyName(I);
	}

	/**
	 * Returns the five-digit county FIPS code for the current ZipData record
	 *
	 * @return Five-digit FIPS code string
	 */
	public String GetCountyFips() {
		return mdZipJNI.GetCountyFips(I);
	}

	/**
	 * Returns the dominant telephone area code for the ZIP code
	 *
	 * @return Three-digit area code string
	 */
	public String GetAreaCode() {
		return mdZipJNI.GetAreaCode(I);
	}

	/**
	 * Returns the longitude of the geographic center of the ZIP code
	 *
	 * @return Longitude string accurate to 6 decimal places (negative for US)
	 */
	public String GetLongitude() {
		return mdZipJNI.GetLongitude(I);
	}

	/**
	 * Returns the latitude of the geographic center of the ZIP code
	 *
	 * @return Latitude string accurate to 4 decimal places
	 */
	public String GetLatitude() {
		return mdZipJNI.GetLatitude(I);
	}

	/**
	 * Returns the time zone name for the ZIP code
	 *
	 * @return Time zone name string (e.g. "Eastern Time", "Pacific Time")
	 */
	public String GetTimeZone() {
		return mdZipJNI.GetTimeZone(I);
	}

	/**
	 * Returns the numeric time zone code for the ZIP code
	 *
	 * @return Time zone code (e.g. "5" for Eastern, "8" for Pacific)
	 */
	public String GetTimeZoneCode() {
		return mdZipJNI.GetTimeZoneCode(I);
	}

	/**
	 * Returns the Metropolitan Statistical Area (MSA) code for the ZIP code
	 *
	 * @return MSA code string
	 */
	public String GetMsa() {
		return mdZipJNI.GetMsa(I);
	}

	/**
	 * Returns the Primary Metropolitan Statistical Area (PMSA) code for the ZIP code
	 *
	 * @return PMSA code string
	 */
	public String GetPmsa() {
		return mdZipJNI.GetPmsa(I);
	}

	/**
	 * Returns the USPS postal facility type code for the ZIP code
	 *
	 * @return A=Airport Mail Facility, B=Branch, C=Community Post Office, D=Area Distribution Center, E=Sectional Center Facility, F=Delivery Distribution Center, G=General Mail Facility, K=Bulk Mail Facility, M=Money Order Unit, N=Community or Place name, P=Post Office, S=Station, U=Urbanization (Puerto Rico), X=Vanity name (should not be used). Not returned for Canadian postal codes
	 */
	public String GetFacilityCode() {
		return mdZipJNI.GetFacilityCode(I);
	}

	/**
	 * Returns whether the current city name is the official USPS last-line name for the ZIP code. Not returned for Canadian postal codes
	 *
	 * @return "L" if this is the official last-line city (only one record per ZIP Code is coded with "L"), empty otherwise
	 */
	public String GetLastLineIndicator() {
		return mdZipJNI.GetLastLineIndicator(I);
	}

	/**
	 * Returns the last line number used for advanced address matching tie-breaking. Not returned for Canadian postal codes
	 *
	 * @return Six-character last line number string
	 */
	public String GetLastLineNumber() {
		return mdZipJNI.GetLastLineNumber(I);
	}

	/**
	 * Returns the preferred last line number for the current city record
	 *
	 * @return Six-character preferred last line number string
	 */
	public String GetPreferredLastLineNumber() {
		return mdZipJNI.GetPreferredLastLineNumber(I);
	}

	/**
	 * Returns the carrier route rate mail indicator for letter-size mail in the ZIP code. Not returned for Canadian postal codes
	 *
	 * @return "A" carrier route rates apply and merging is permitted, "B" carrier route rates apply and merging is not permitted, "C" carrier route rates do not apply and merging is permitted, "D" carrier route rates do not apply and merging is not permitted
	 */
	public String GetAutomation() {
		return mdZipJNI.GetAutomation(I);
	}

	/**
	 * Returns the USPS finance number for the postal facility associated with the ZIP code
	 *
	 * @return Finance number string
	 */
	public String GetFinanceNumber() {
		return mdZipJNI.GetFinanceNumber(I);
	}

}
