package com.melissadata;

/**
 * Verifies, standardizes, and enhances U.S. and Canadian addresses
 *
 * Provides DPV processing, CASS certification, LACSLink, SuiteLink, and RBDI capabilities
 */
public class mdAddr {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdAddr obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

	/**
	 * Programming, installation, and execution error codes returned by Initialize and InitializeDataFiles
 	*/
	public final static class ProgramStatus {
		/** No error - initialization was successful */
		public final static mdAddr.ProgramStatus ErrorNone=new mdAddr.ProgramStatus("ErrorNone",0);
		/** Could not open the mdAddr.dat file */
		public final static mdAddr.ProgramStatus ErrorOther=new mdAddr.ProgramStatus("ErrorOther",1);
		/** Out of memory */
		public final static mdAddr.ProgramStatus ErrorOutOfMemory=new mdAddr.ProgramStatus("ErrorOutOfMemory",2);
		/** A required data file could not be found */
		public final static mdAddr.ProgramStatus ErrorRequiredFileNotFound=new mdAddr.ProgramStatus("ErrorRequiredFileNotFound",3);
		/** Conflicts found between two or more data files */
		public final static mdAddr.ProgramStatus ErrorFoundOldFile=new mdAddr.ProgramStatus("ErrorFoundOldFile",4);
		/** The database has expired */
		public final static mdAddr.ProgramStatus ErrorDatabaseExpired=new mdAddr.ProgramStatus("ErrorDatabaseExpired",5);
		/** The license has expired */
		public final static mdAddr.ProgramStatus ErrorLicenseExpired=new mdAddr.ProgramStatus("ErrorLicenseExpired",6);

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
	 * Controls whether diacritic characters are returned in the standardized output, set via SetDiacritics
 	*/
	public final static class DiacriticsMode {
		/** If the input value contains diacritic characters, diacritics will be returned in the output. This is the default setting */
		public final static mdAddr.DiacriticsMode Auto=new mdAddr.DiacriticsMode("Auto",0);
		/** Diacritics will be returned in the output for all addresses, regardless of input */
		public final static mdAddr.DiacriticsMode On=new mdAddr.DiacriticsMode("On",1);
		/** Diacritics will not be returned in the output for any addresses, regardless of input */
		public final static mdAddr.DiacriticsMode Off=new mdAddr.DiacriticsMode("Off",2);

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

	/**
	 * Controls how street directionals and suffixes are abbreviated in standardized output, set via SetStandardizationType
 	*/
	public final static class StandardizeMode {
		/** The street address is returned with directionals and suffixes shortened according to postal standards. This is the default setting */
		public final static mdAddr.StandardizeMode ShortFormat=new mdAddr.StandardizeMode("ShortFormat",0);
		/** The street address is returned with directionals and suffixes spelled out rather than abbreviated */
		public final static mdAddr.StandardizeMode LongFormat=new mdAddr.StandardizeMode("LongFormat",1);
		/** The street address is returned with the abbreviation or non-abbreviation of the directionals and suffixes preserved. If any of these components need to be corrected and replaced, the replacement will preserve the original standardization */
		public final static mdAddr.StandardizeMode AutoFormat=new mdAddr.StandardizeMode("AutoFormat",2);

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

	/**
	 * Controls whether suite information is parsed into its own field or combined with the address line, set via SetSuiteParseMode
 	*/
	public final static class SuiteParseMode {
		/** The suite will be parsed out into the suite field after VerifyAddress(). This is the default setting */
		public final static mdAddr.SuiteParseMode ParseSuite=new mdAddr.SuiteParseMode("ParseSuite",0);
		/** The suite will be appended to the end of the Address1 line after VerifyAddress() */
		public final static mdAddr.SuiteParseMode CombineSuite=new mdAddr.SuiteParseMode("CombineSuite",1);

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

	/**
	 * Controls whether nickname or former street name inputs are converted to their USPS preferred name, set via SetAliasMode
 	*/
	public final static class AliasPreserveMode {
		/** Nickname or former name street inputs will be converted to their USPS preferred street name during the verification process. This is the default setting */
		public final static mdAddr.AliasPreserveMode ConvertAlias=new mdAddr.AliasPreserveMode("ConvertAlias",0);
		/** Nickname or former name street inputs will be preserved during the verification process */
		public final static mdAddr.AliasPreserveMode PreserveAlias=new mdAddr.AliasPreserveMode("PreserveAlias",1);

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

	/**
	 * Controls the verbosity of the description returned by GetResultCodeDescription
 	*/
	public final static class ResultCdDescOpt {
		/** Return long (detailed) result code descriptions. This is the default setting */
		public final static mdAddr.ResultCdDescOpt ResultCodeDescriptionLong=new mdAddr.ResultCdDescOpt("ResultCodeDescriptionLong",0);
		/** Return short (brief) result code descriptions */
		public final static mdAddr.ResultCdDescOpt ResultCodeDescriptionShort=new mdAddr.ResultCdDescOpt("ResultCodeDescriptionShort",1);

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

	/**
	 * Constructs a new AddressCheck instance
	 *
	 */
	protected mdAddr(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdAddr() {
		this(mdAddrJNI.mdAddrCreate(),true);
	}

	/**
	 * Destroys an existing AddressCheck instance
	 *
	 */
	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdAddrJNI.mdAddrDestroy(I);
			}
			I=0;
		}
	}

	/**
	 * Deprecated; use InitializeDataFiles instead. Initializes the data files using explicit file paths
	 *
	 * @deprecated Use InitializeDataFiles instead.
	 *
	 * @param DataPath Path to the mdAddr.dat file
	 * @param NationalPath Path to the mdAddr.nat file
	 * @param RegionalPath Path to a regional data file
	 * @return ProgramStatus enum - ErrorNone (0) on success; use GetInitializeErrorString to retrieve the nature of any other error
	 */
@Deprecated
	public ProgramStatus Initialize(String DataPath, String NationalPath, String RegionalPath) {
		return ProgramStatus.toEnum(mdAddrJNI.Initialize(I,DataPath,NationalPath,RegionalPath));
	}

	/**
	 * Opens the needed data files and prepares Address Object for use. Requires SetPathToUSFiles and/or SetPathToCanadaFiles to have been called first
	 *
	 * @return ProgramStatus enum - NoError (0) on success; use GetInitializeErrorString to retrieve the nature of any other error
	 */
	public ProgramStatus InitializeDataFiles() {
		return ProgramStatus.toEnum(mdAddrJNI.InitializeDataFiles(I));
	}

	/**
	 * Returns a description of the error from the last InitializeDataFiles call
	 *
	 * @return Error description string
	 */
	public String GetInitializeErrorString() {
		return mdAddrJNI.GetInitializeErrorString(I);
	}

	/**
	 * Sets the license string required to enable AddressCheck's complete functionality
	 *
	 * @param License The software license key
	 * @return True (1) if the specified license is correct
	 */
	public boolean SetLicenseString(String License) {
		return mdAddrJNI.SetLicenseString(I,License);
	}

	/**
	 * Returns the current development release build number of Address Object
	 *
	 * @return The current release build number of Address Object
	 */
	public String GetBuildNumber() {
		return mdAddrJNI.GetBuildNumber(I);
	}

	/**
	 * Returns the date of the US address data files
	 *
	 * @return The US address database date in the format yyyy-mm-dd
	 */
	public String GetDatabaseDate() {
		return mdAddrJNI.GetDatabaseDate(I);
	}

	/**
	 * Returns the date when the US address data files will expire
	 *
	 * @return The US address expiration date in the format yyyy-mm-dd
	 */
	public String GetExpirationDate() {
		return mdAddrJNI.GetExpirationDate(I);
	}

	/**
	 * Returns the expiration date of the current license string
	 *
	 * @return The license expiration date in the format yyyy-mm-dd
	 */
	public String GetLicenseExpirationDate() {
		return mdAddrJNI.GetLicenseExpirationDate(I);
	}

	/**
	 * Returns the date of the Canadian address data files
	 *
	 * @return The Canadian address database date in the format yyyy-mm-dd
	 */
	public String GetCanadianDatabaseDate() {
		return mdAddrJNI.GetCanadianDatabaseDate(I);
	}

	/**
	 * Returns the date when the Canadian address data files will expire
	 *
	 * @return The Canadian address expiration date in the format yyyy-mm-dd
	 */
	public String GetCanadianExpirationDate() {
		return mdAddrJNI.GetCanadianExpirationDate(I);
	}

	/**
	 * Sets the path to the US data files required for US address verification
	 *
	 * @param DataFilePath Path to directory containing mdAddr.dat, mdAddr.nat, mdAddr.str, and mdAddr.lic
	 */
	public void SetPathToUSFiles(String DataFilePath) {
		mdAddrJNI.SetPathToUSFiles(I,DataFilePath);
	}

	/**
	 * Sets the path to the Canadian data files required for Canadian address verification
	 *
	 * @param DataFilePath Path to directory containing mdCanada3.db
	 */
	public void SetPathToCanadaFiles(String DataFilePath) {
		mdAddrJNI.SetPathToCanadaFiles(I,DataFilePath);
	}

	/**
	 * Sets the path to the DPV data files required for CASS processing
	 *
	 * @param DataFilePath Path to DPV data files (dph.hsa, dph.hsx, dph.hsv, dph.hsf, dph.hsc, dph.dte, lcd)
	 */
	public void SetPathToDPVDataFiles(String DataFilePath) {
		mdAddrJNI.SetPathToDPVDataFiles(I,DataFilePath);
	}

	/**
	 * Sets the path to the LACSLink data files required for CASS processing
	 *
	 * @param DataFilePath Path to directory containing mdLACS.dat
	 */
	public void SetPathToLACSLinkDataFiles(String DataFilePath) {
		mdAddrJNI.SetPathToLACSLinkDataFiles(I,DataFilePath);
	}

	/**
	 * Sets the path to the SuiteLink data files required for CASS processing
	 *
	 * @param DataFilePath Path to directory containing mdSteLink.dat
	 */
	public void SetPathToSuiteLinkDataFiles(String DataFilePath) {
		mdAddrJNI.SetPathToSuiteLinkDataFiles(I,DataFilePath);
	}

	/**
	 * Sets the path to the AddressPlus suite finder data files
	 *
	 * @param DataFilePath Path to directory containing mdSuiteFinder.db
	 */
	public void SetPathToSuiteFinderDataFiles(String DataFilePath) {
		mdAddrJNI.SetPathToSuiteFinderDataFiles(I,DataFilePath);
	}

	/**
	 * Sets the path to the RBDI (Residential Business Delivery Indicator) data files
	 *
	 * @param DataFilePath Path to directory containing mdRBDI.dat
	 */
	public void SetPathToRBDIFiles(String DataFilePath) {
		mdAddrJNI.SetPathToRBDIFiles(I,DataFilePath);
	}

	/**
	 * Returns the date of the RBDI data files
	 *
	 * @return RBDI database date string
	 */
	public String GetRBDIDatabaseDate() {
		return mdAddrJNI.GetRBDIDatabaseDate(I);
	}

	/**
	 * Sets the path to the Melissa Address Key (MAK) data files
	 *
	 * @param DataFilePath Path to the MAK data files
	 */
	public void SetPathToAddrKeyDataFiles(String DataFilePath) {
		mdAddrJNI.SetPathToAddrKeyDataFiles(I,DataFilePath);
	}

	/**
	 * Clears all stored address input and output values before processing the next address
	 *
	 */
	public void ClearProperties() {
		mdAddrJNI.ClearProperties(I);
	}

	/**
	 * Resets internal DPV counters
	 *
	 */
	public void ResetDPV() {
		mdAddrJNI.ResetDPV(I);
	}

	/**
	 * Enables or disables full CASS Certified address verification including DPV processing
	 *
	 * @param Enable Pass 1 to enable CASS processing; 0 to disable (default is disabled)
	 */
	public void SetCASSEnable(int Enable) {
		mdAddrJNI.SetCASSEnable(I,Enable);
	}

	/**
	 * Forces VerifyAddress to always return the USPS preferred city name regardless of vanity names
	 *
	 * @param Enable Pass 1 to always return the USPS preferred city name
	 */
	public void SetUseUSPSPreferredCityNames(int Enable) {
		mdAddrJNI.SetUseUSPSPreferredCityNames(I,Enable);
	}

	/**
	 * Sets how diacritic characters are handled for Quebec addresses
	 *
	 * @param mode DiacriticsMode enum - Auto (0), On (1), or Off (2)
	 */
	public void SetDiacritics(mdAddr.DiacriticsMode mode) {
		mdAddrJNI.SetDiacritics(I,mode.toValue());
	}

	/**
	 * Returns the status code from the last VerifyAddress call
	 *
	 * @deprecated Use GetResults instead.
	 *
	 * @return Status code string
	 */
@Deprecated
	public String GetStatusCode() {
		return mdAddrJNI.GetStatusCode(I);
	}

	/**
	 * Returns the error code from the last VerifyAddress call
	 *
	 * @deprecated Use GetResults instead.
	 *
	 * @return Error code string
	 */
@Deprecated
	public String GetErrorCode() {
		return mdAddrJNI.GetErrorCode(I);
	}

	/**
	 * Returns a description of the error from the last VerifyAddress call
	 *
	 * @deprecated Use GetResults instead.
	 *
	 * @return Error description string
	 */
@Deprecated
	public String GetErrorString() {
		return mdAddrJNI.GetErrorString(I);
	}

	/**
	 * Returns a comma-delimited list of result codes describing the outcome of the last VerifyAddress call
	 *
	 * @return Comma-delimited result code string (e.g. "AS01" for a fully verified address)
	 */
	public String GetResults() {
		return mdAddrJNI.GetResults(I);
	}

	/**
	 * Returns a human-readable description for a given result code
	 *
	 * @param resultCode The four-character result code to look up
	 * @param opt ResultCdDescOpt enum specifying description format (default is long)
	 * @return Description of the result code
	 */
	public String GetResultCodeDescription(String resultCode) {
		return mdAddrJNI.GetResultCodeDescription(I,resultCode,0);
	}
	public String GetResultCodeDescription(String resultCode, mdAddr.ResultCdDescOpt opt) {
		return mdAddrJNI.GetResultCodeDescription(I,resultCode,opt.toValue());
	}

	/**
	 * Sets the name of the company that processed the address list for CASS Form 3553 item B1
	 *
	 * @param ProcessorName Company name that coded the address list
	 */
	public void SetPS3553_B1_ProcessorName(String ProcessorName) {
		mdAddrJNI.SetPS3553_B1_ProcessorName(I,ProcessorName);
	}

	/**
	 * Sets the name or ID of the address list for CASS Form 3553 item B4
	 *
	 * @param ListName List name or ID number (prefix IDs with "ID#")
	 */
	public void SetPS3553_B4_ListName(String ListName) {
		mdAddrJNI.SetPS3553_B4_ListName(I,ListName);
	}

	/**
	 * Sets the list owner's name for CASS Form 3553 item D3
	 *
	 * @param Name Name of the list owner
	 */
	public void SetPS3553_D3_Name(String Name) {
		mdAddrJNI.SetPS3553_D3_Name(I,Name);
	}

	/**
	 * Sets the list owner's company name for CASS Form 3553 item D3
	 *
	 * @param Company Company name of the list owner
	 */
	public void SetPS3553_D3_Company(String Company) {
		mdAddrJNI.SetPS3553_D3_Company(I,Company);
	}

	/**
	 * Sets the list owner's street address for CASS Form 3553 item D3
	 *
	 * @param Address Street address of the list owner
	 */
	public void SetPS3553_D3_Address(String Address) {
		mdAddrJNI.SetPS3553_D3_Address(I,Address);
	}

	/**
	 * Sets the list owner's city for CASS Form 3553 item D3
	 *
	 * @param City City of the list owner
	 */
	public void SetPS3553_D3_City(String City) {
		mdAddrJNI.SetPS3553_D3_City(I,City);
	}

	/**
	 * Sets the list owner's state for CASS Form 3553 item D3
	 *
	 * @param State State of the list owner
	 */
	public void SetPS3553_D3_State(String State) {
		mdAddrJNI.SetPS3553_D3_State(I,State);
	}

	/**
	 * Sets the list owner's ZIP code for CASS Form 3553 item D3
	 *
	 * @param ZIP ZIP code of the list owner
	 */
	public void SetPS3553_D3_ZIP(String ZIP) {
		mdAddrJNI.SetPS3553_D3_ZIP(I,ZIP);
	}

	/**
	 * Returns the CASS Form 3553 as an HTML string for display or printing
	 *
	 * @return HTML string of the CASS Form 3553
	 */
	public String GetFormPS3553() {
		return mdAddrJNI.GetFormPS3553(I);
	}

	/**
	 * Saves the CASS Form 3553 as an HTML or PDF file
	 *
	 * @param PathAndFileName Full path and filename including .html or .pdf extension
	 * @return True (1) if saved successfully
	 */
	public boolean SaveFormPS3553(String PathAndFileName) {
		return mdAddrJNI.SaveFormPS3553(I,PathAndFileName);
	}

	/**
	 * Resets all internal counters to zero, useful when producing several CASS forms in sequence for multiple jobs. Removing Address Object from memory also clears the counters
	 *
	 */
	public void ResetFormPS3553() {
		mdAddrJNI.ResetFormPS3553(I);
	}

	/**
	 * Resets only the CASS Form 3553 record counter
	 *
	 */
	public void ResetFormPS3553Counter() {
		mdAddrJNI.ResetFormPS3553Counter(I);
	}

	/**
	 * Sets how address suffixes and directionals are abbreviated in standardized output
	 *
	 * @param mode StandardizeMode enum - ShortFormat (0), LongFormat (1), or AutoFormat (2)
	 */
	public void SetStandardizationType(mdAddr.StandardizeMode mode) {
		mdAddrJNI.SetStandardizationType(I,mode.toValue());
	}

	/**
	 * Controls whether suite information is parsed into its own field or appended to the address line
	 *
	 * @param mode SuiteParseMode enum - ParseSuite (default) or CombineSuite
	 */
	public void SetSuiteParseMode(mdAddr.SuiteParseMode mode) {
		mdAddrJNI.SetSuiteParseMode(I,mode.toValue());
	}

	/**
	 * Controls whether street alias or nickname names are converted to the USPS preferred name or preserved
	 *
	 * @param mode AliasPreserveMode enum - ConvertAlias (default) or PreserveAlias
	 */
	public void SetAliasMode(mdAddr.AliasPreserveMode mode) {
		mdAddrJNI.SetAliasMode(I,mode.toValue());
	}

	/**
	 * Returns the Canada Post Summary of Addresses as an HTML string
	 *
	 * @return HTML string of the Summary of Addresses
	 */
	public String GetFormSOA() {
		return mdAddrJNI.GetFormSOA(I);
	}

	/**
	 * Saves the Canada Post Summary of Addresses to an HTML file
	 *
	 * @param PathAndFileName Full path and filename including .html extension
	 */
	public void SaveFormSOA(String PathAndFileName) {
		mdAddrJNI.SaveFormSOA(I,PathAndFileName);
	}

	/**
	 * Resets the SOA running totals for Canadian address records
	 *
	 */
	public void ResetFormSOA() {
		mdAddrJNI.ResetFormSOA(I);
	}

	/**
	 * Sets the company name and mailing address for the Canada Post Summary of Addresses
	 *
	 * @param customerName Company name as it appears on the Canada Post contract
	 * @param customerAddress Mailing address as it appears on the Canada Post contract
	 */
	public void SetSOACustomerInfo(String customerName, String customerAddress) {
		mdAddrJNI.SetSOACustomerInfo(I,customerName,customerAddress);
	}

	/**
	 * Sets the Canada Post Contract (CPC) number for the Summary of Addresses
	 *
	 * @param CPCNumber Eight-digit Canada Post contract number
	 */
	public void SetSOACPCNumber(String CPCNumber) {
		mdAddrJNI.SetSOACPCNumber(I,CPCNumber);
	}

	/**
	 * Returns the company name and mailing address set via SetSOACustomerInfo for the Summary of Addresses
	 *
	 * @return Customer name and address string
	 */
	public String GetSOACustomerInfo() {
		return mdAddrJNI.GetSOACustomerInfo(I);
	}

	/**
	 * Returns the Canada Post Contract (CPC) number set via SetSOACPCNumber for the Summary of Addresses
	 *
	 * @return CPC number string
	 */
	public String GetSOACPCNumber() {
		return mdAddrJNI.GetSOACPCNumber(I);
	}

	/**
	 * Returns the total number of Canadian address records processed since initialization or last reset
	 *
	 * @return Total record count
	 */
	public long GetSOATotalRecords() {
		return mdAddrJNI.GetSOATotalRecords(I);
	}

	/**
	 * Returns the address accuracy percentage for Canadian records processed
	 *
	 * @return Address accuracy percentage (must be 95% or higher for postage discounts)
	 */
	public float GetSOAAAPercentage() {
		return mdAddrJNI.GetSOAAAPercentage(I);
	}

	/**
	 * Returns the expiry date of the current Summary of Addresses
	 *
	 * @return SOA expiry date string
	 */
	public String GetSOAAAExpiryDate() {
		return mdAddrJNI.GetSOAAAExpiryDate(I);
	}

	/**
	 * Returns the software name and build number shown on the Summary of Addresses
	 *
	 * @return Software name and version string
	 */
	public String GetSOASoftwareInfo() {
		return mdAddrJNI.GetSOASoftwareInfo(I);
	}

	/**
	 * Returns an error description generated by any SOA function call
	 *
	 * @return SOA error description string
	 */
	public String GetSOAErrorString() {
		return mdAddrJNI.GetSOAErrorString(I);
	}

	/**
	 * Sets the company name for the address to be verified
	 *
	 * @param Company Optional company name; improves Plus4 accuracy and enables SuiteLink for firm addresses
	 */
	public void SetCompany(String Company) {
		mdAddrJNI.SetCompany(I,Company);
	}

	/**
	 * Sets the last name associated with a residential address (required for AddressPlus)
	 *
	 * @param LastName Last name associated with the address
	 */
	public void SetLastName(String LastName) {
		mdAddrJNI.SetLastName(I,LastName);
	}

	/**
	 * Sets the primary delivery address line to be verified
	 *
	 * @param Address Street address including number, name, directionals, and suffix
	 */
	public void SetAddress(String Address) {
		mdAddrJNI.SetAddress(I,Address);
	}

	/**
	 * Sets a secondary address line such as a PO Box or suite on a separate line
	 *
	 * @param Address2 Secondary address line
	 */
	public void SetAddress2(String Address2) {
		mdAddrJNI.SetAddress2(I,Address2);
	}

	/**
	 * Sets the city, state, and ZIP code as a single combined string
	 *
	 * @param LastLine Combined city, state, and ZIP string (e.g. "Rancho Santa Margarita, CA 92688")
	 */
	public void SetLastLine(String LastLine) {
		mdAddrJNI.SetLastLine(I,LastLine);
	}

	/**
	 * Sets the suite name and number for the address to be verified
	 *
	 * @param Suite Suite designation (e.g. "Apt 3" or "Ste 100")
	 */
	public void SetSuite(String Suite) {
		mdAddrJNI.SetSuite(I,Suite);
	}

	/**
	 * Sets the city or municipality name for the address to be verified
	 *
	 * @param City City or municipality name
	 */
	public void SetCity(String City) {
		mdAddrJNI.SetCity(I,City);
	}

	/**
	 * Sets the two-letter state or province abbreviation for the address to be verified
	 *
	 * @param State Two-letter state or province abbreviation
	 */
	public void SetState(String State) {
		mdAddrJNI.SetState(I,State);
	}

	/**
	 * Sets the five-digit US ZIP code or six-character Canadian postal code for the address to be verified
	 *
	 * @param Zip US ZIP code or Canadian postal code
	 */
	public void SetZip(String Zip) {
		mdAddrJNI.SetZip(I,Zip);
	}

	/**
	 * Sets the four-digit ZIP+4 add-on code for the address to be verified
	 *
	 * @param Plus4 Four-digit ZIP+4 extension
	 */
	public void SetPlus4(String Plus4) {
		mdAddrJNI.SetPlus4(I,Plus4);
	}

	/**
	 * Sets the urbanization name for Puerto Rican addresses
	 *
	 * @param Urbanization Puerto Rico urbanization (neighborhood) name
	 */
	public void SetUrbanization(String Urbanization) {
		mdAddrJNI.SetUrbanization(I,Urbanization);
	}

	/**
	 * Sets the pre-parsed delivery number portion of the street address
	 *
	 * @param AddressRange Numeric address range (max 10 characters)
	 */
	public void SetParsedAddressRange(String AddressRange) {
		mdAddrJNI.SetParsedAddressRange(I,AddressRange);
	}

	/**
	 * Sets the pre-parsed directional that precedes the street name
	 *
	 * @param PreDirection Pre-directional (e.g. "N", "NE", "SW")
	 */
	public void SetParsedPreDirection(String PreDirection) {
		mdAddrJNI.SetParsedPreDirection(I,PreDirection);
	}

	/**
	 * Sets the pre-parsed street name portion of the address
	 *
	 * @param StreetName Street name (max 28 characters)
	 */
	public void SetParsedStreetName(String StreetName) {
		mdAddrJNI.SetParsedStreetName(I,StreetName);
	}

	/**
	 * Sets the pre-parsed street suffix portion of the address
	 *
	 * @param Suffix Street suffix (e.g. "ST", "AVE", "BLVD")
	 */
	public void SetParsedSuffix(String Suffix) {
		mdAddrJNI.SetParsedSuffix(I,Suffix);
	}

	/**
	 * Sets the pre-parsed directional that follows the street name
	 *
	 * @param PostDirection Post-directional (e.g. "N", "NE", "SW")
	 */
	public void SetParsedPostDirection(String PostDirection) {
		mdAddrJNI.SetParsedPostDirection(I,PostDirection);
	}

	/**
	 * Sets the pre-parsed secondary unit designator (e.g. "APT", "STE", "UNIT")
	 *
	 * @param SuiteName Secondary unit designator
	 */
	public void SetParsedSuiteName(String SuiteName) {
		mdAddrJNI.SetParsedSuiteName(I,SuiteName);
	}

	/**
	 * Sets the pre-parsed secondary unit number
	 *
	 * @param SuiteRange Secondary unit number
	 */
	public void SetParsedSuiteRange(String SuiteRange) {
		mdAddrJNI.SetParsedSuiteRange(I,SuiteRange);
	}

	/**
	 * Sets the pre-parsed route service for Canadian addresses (equivalent to US rural route)
	 *
	 * @param RouteService Canadian route service information
	 */
	public void SetParsedRouteService(String RouteService) {
		mdAddrJNI.SetParsedRouteService(I,RouteService);
	}

	/**
	 * Sets the pre-parsed lock box for Canadian addresses (equivalent to US PO Box)
	 *
	 * @param LockBox Canadian lock box information
	 */
	public void SetParsedLockBox(String LockBox) {
		mdAddrJNI.SetParsedLockBox(I,LockBox);
	}

	/**
	 * Sets the pre-parsed delivery installation for Canadian addresses
	 *
	 * @param DeliveryInstallation Canadian delivery installation (post office facility)
	 */
	public void SetParsedDeliveryInstallation(String DeliveryInstallation) {
		mdAddrJNI.SetParsedDeliveryInstallation(I,DeliveryInstallation);
	}

	/**
	 * Sets the two-character country code for the address to be verified
	 *
	 * @param CountryCode Two-character country code ("US" or "CA")
	 */
	public void SetCountryCode(String CountryCode) {
		mdAddrJNI.SetCountryCode(I,CountryCode);
	}

	/**
	 * Verifies, standardizes, and enhances the address set via the Set functions
	 *
	 * @return True (1) if the address was successfully coded; check GetResults for match level
	 */
	public boolean VerifyAddress() {
		return mdAddrJNI.VerifyAddress(I);
	}

	/**
	 * Returns the company name associated with the verified address
	 *
	 * @return Company name string (unchanged from input)
	 */
	public String GetCompany() {
		return mdAddrJNI.GetCompany(I);
	}

	/**
	 * Returns the last name associated with the verified address
	 *
	 * @return Last name string (unchanged from input)
	 */
	public String GetLastName() {
		return mdAddrJNI.GetLastName(I);
	}

	/**
	 * Returns the standardized primary delivery address line
	 *
	 * @return Standardized street address string
	 */
	public String GetAddress() {
		return mdAddrJNI.GetAddress(I);
	}

	/**
	 * Returns the second address line associated with the verified address
	 *
	 * @return Second address line string
	 */
	public String GetAddress2() {
		return mdAddrJNI.GetAddress2(I);
	}

	/**
	 * Returns the standardized suite name and number
	 *
	 * @return Suite string (e.g. "APT 3")
	 */
	public String GetSuite() {
		return mdAddrJNI.GetSuite(I);
	}

	/**
	 * Returns the verified city or municipality name
	 *
	 * @return City name string
	 */
	public String GetCity() {
		return mdAddrJNI.GetCity(I);
	}

	/**
	 * Returns the official USPS 13-character city name abbreviation
	 *
	 * @return City abbreviation (same as city name if 13 characters or fewer)
	 */
	public String GetCityAbbreviation() {
		return mdAddrJNI.GetCityAbbreviation(I);
	}

	/**
	 * Returns the two-letter state or province abbreviation for the verified address
	 *
	 * @return Two-letter state or province code
	 */
	public String GetState() {
		return mdAddrJNI.GetState(I);
	}

	/**
	 * Returns the verified five-digit US ZIP code or six-character Canadian postal code
	 *
	 * @return ZIP or postal code string
	 */
	public String GetZip() {
		return mdAddrJNI.GetZip(I);
	}

	/**
	 * Returns the four-digit ZIP+4 add-on code for the verified address
	 *
	 * @return Four-digit Plus4 string
	 */
	public String GetPlus4() {
		return mdAddrJNI.GetPlus4(I);
	}

	/**
	 * Returns the four-character carrier route code for the verified address
	 *
	 * @return Carrier route code (e.g. "C027" or "R001")
	 */
	public String GetCarrierRoute() {
		return mdAddrJNI.GetCarrierRoute(I);
	}

	/**
	 * Returns the two-digit delivery point code used in POSTNET barcodes (positions 10-11)
	 *
	 * @return Two-digit delivery point code string
	 */
	public String GetDeliveryPointCode() {
		return mdAddrJNI.GetDeliveryPointCode(I);
	}

	/**
	 * Returns the one-digit check digit for POSTNET barcodes (position 12)
	 *
	 * @return One-digit check digit string
	 */
	public String GetDeliveryPointCheckDigit() {
		return mdAddrJNI.GetDeliveryPointCheckDigit(I);
	}

	/**
	 * Returns the five-digit county FIPS code for the verified address
	 *
	 * @return Five-digit FIPS code (e.g. "06037" for Los Angeles CA)
	 */
	public String GetCountyFips() {
		return mdAddrJNI.GetCountyFips(I);
	}

	/**
	 * Returns the county name for the verified address
	 *
	 * @return County name string (up to 25 characters)
	 */
	public String GetCountyName() {
		return mdAddrJNI.GetCountyName(I);
	}

	/**
	 * Returns a single-character code indicating the type of the verified address
	 *
	 * @return S=Street, P=PO Box, H=High Rise, R=Rural Route, F=Firm, G=General Delivery, A=Alias
	 */
	public String GetAddressTypeCode() {
		return mdAddrJNI.GetAddressTypeCode(I);
	}

	/**
	 * Returns a description of the address type code returned by GetAddressTypeCode
	 *
	 * @return Address type description string
	 */
	public String GetAddressTypeString() {
		return mdAddrJNI.GetAddressTypeString(I);
	}

	/**
	 * Returns the urbanization name for Puerto Rican addresses
	 *
	 * @return Urbanization name string
	 */
	public String GetUrbanization() {
		return mdAddrJNI.GetUrbanization(I);
	}

	/**
	 * Returns the congressional district for the verified address
	 *
	 * @return State abbreviation plus two-digit district number (e.g. "CA01")
	 */
	public String GetCongressionalDistrict() {
		return mdAddrJNI.GetCongressionalDistrict(I);
	}

	/**
	 * Returns whether the address has undergone a rural-to-city-style address conversion
	 *
	 * @return "L" if the address was converted, empty if not
	 */
	public String GetLACS() {
		return mdAddrJNI.GetLACS(I);
	}

	/**
	 * Returns whether the submitted address was corrected using LACSLink data
	 *
	 * @return "Y" if updated, "S" if updated but suite unmatched, "N" if not updated
	 */
	public String GetLACSLinkIndicator() {
		return mdAddrJNI.GetLACSLinkIndicator(I);
	}

	/**
	 * Returns the private mailbox number for CMRA addresses
	 *
	 * @return Private mailbox number string
	 */
	public String GetPrivateMailbox() {
		return mdAddrJNI.GetPrivateMailbox(I);
	}

	/**
	 * Returns the numeric time zone code for the verified address
	 *
	 * @return Time zone code (e.g. "5" for Eastern, "8" for Pacific)
	 */
	public String GetTimeZoneCode() {
		return mdAddrJNI.GetTimeZoneCode(I);
	}

	/**
	 * Returns the time zone name for the verified address
	 *
	 * @return Time zone name string (e.g. "Eastern Time", "Pacific Time")
	 */
	public String GetTimeZone() {
		return mdAddrJNI.GetTimeZone(I);
	}

	/**
	 * Returns the Metropolitan Statistical Area (MSA) code for the verified address
	 *
	 * @return MSA code string
	 */
	public String GetMsa() {
		return mdAddrJNI.GetMsa(I);
	}

	/**
	 * Returns the Primary Metropolitan Statistical Area (PMSA) code for the verified address
	 *
	 * @return PMSA code string
	 */
	public String GetPmsa() {
		return mdAddrJNI.GetPmsa(I);
	}

	/**
	 * Returns whether a default Plus4 code was assigned during address verification
	 *
	 * @return Default flag indicator string
	 */
	public String GetDefaultFlagIndicator() {
		return mdAddrJNI.GetDefaultFlagIndicator(I);
	}

	/**
	 * Returns the SuiteLink suite status indicator for the verified address
	 *
	 * @return Suite status string
	 */
	public String GetSuiteStatus() {
		return mdAddrJNI.GetSuiteStatus(I);
	}

	/**
	 * Returns whether the address was found in the Early Warning System (EWS) database. Only returns a value if EnableEarlyWarningSystem was set to true and ews.txt is present in the data files folder
	 *
	 * @return "Y" if found in EWS (GetResults also returns "AE06"), empty otherwise
	 */
	public String GetEWSFlag() {
		return mdAddrJNI.GetEWSFlag(I);
	}

	/**
	 * Returns whether the address is a private mailbox at a Commercial Mail Receiving Agency (e.g. UPS Store). Does not return data when GetResults returns "AS03" (non-USPS address)
	 *
	 * @return "N" if not a CMRA, "Y" if a CMRA, empty if not populated (e.g. certain DPV footnote codes)
	 */
	public String GetCMRA() {
		return mdAddrJNI.GetCMRA(I);
	}

	/**
	 * Returns whether the delivery point is currently vacant
	 *
	 * @return "Y" if vacant (unoccupied over 90 days), "N" if not vacant
	 */
	public String GetDsfVacant() {
		return mdAddrJNI.GetDsfVacant(I);
	}

	/**
	 * Returns the two-character country code for the verified address
	 *
	 * @return "US" for United States, "CA" for Canada
	 */
	public String GetCountryCode() {
		return mdAddrJNI.GetCountryCode(I);
	}

	/**
	 * Returns the ZIP code type for the verified address
	 *
	 * @return "P" for PO Box only, "U" for unique/institutional, "M" for military, empty for standard
	 */
	public String GetZipType() {
		return mdAddrJNI.GetZipType(I);
	}

	/**
	 * Returns whether the address appears in the DPV false positive table
	 *
	 * @return False positive table indicator string
	 */
	public String GetFalseTable() {
		return mdAddrJNI.GetFalseTable(I);
	}

	/**
	 * Returns the USPS standard DPV footnote codes for the verified address
	 *
	 * @return String of up to 6 DPV footnote codes
	 */
	public String GetDPVFootnotes() {
		return mdAddrJNI.GetDPVFootnotes(I);
	}

	/**
	 * Returns the LACSLink match result code
	 *
	 * @return "A" for match, "00" for no match, "14" for unconvertible, "92" for secondary dropped
	 */
	public String GetLACSLinkReturnCode() {
		return mdAddrJNI.GetLACSLinkReturnCode(I);
	}

	/**
	 * Returns the SuiteLink match result code indicating whether suite information was appended
	 *
	 * @return "A" if suite matched and appended, "00" if no match
	 */
	public String GetSuiteLinkReturnCode() {
		return mdAddrJNI.GetSuiteLinkReturnCode(I);
	}

	/**
	 * Returns the Residential Business Delivery Indicator for the verified address
	 *
	 * @return "R" for residential, "B" for business, "U" for unknown
	 */
	public String GetRBDI() {
		return mdAddrJNI.GetRBDI(I);
	}

	/**
	 * Returns the enhanced Line-of-Travel (eLOT) sequence number for the verified address
	 *
	 * @return eLOT number string, or "-1" if eLOT data is unavailable
	 */
	public String GetELotNumber() {
		return mdAddrJNI.GetELotNumber(I);
	}

	/**
	 * Returns the eLOT delivery direction indicator
	 *
	 * @return "A" for ascending delivery order, "D" for descending, "X" if unavailable
	 */
	public String GetELotOrder() {
		return mdAddrJNI.GetELotOrder(I);
	}

	/**
	 * Returns the unique 11-digit USPS address key for the verified address
	 *
	 * @return 11-digit address key string
	 */
	public String GetAddressKey() {
		return mdAddrJNI.GetAddressKey(I);
	}

	/**
	 * Returns the Melissa Address Key (MAK), a persistent 10-digit unique identifier for the address
	 *
	 * @return 10-digit MAK string
	 */
	public String GetMelissaAddressKey() {
		return mdAddrJNI.GetMelissaAddressKey(I);
	}

	/**
	 * Returns the Melissa Address Key Base (BaseMAK), linking suite addresses to their parent building
	 *
	 * @return 10-digit BaseMAK string
	 */
	public String GetMelissaAddressKeyBase() {
		return mdAddrJNI.GetMelissaAddressKeyBase(I);
	}

	/**
	 * Returns the value of a named output parameter after a call to VerifyAddress
	 *
	 * @param ParameterName Parameter name defined by header macros: "CMRA", "PBSA", "Vacant", "ZipIncludedIn3553", "DropIndicator", "ThrowBack", "DeliveryDays", "NoStatIndicator", "NoStatReasonCode", "DPVConfirmationCode", "EnhancedDPVCode", "NoSecureLocation", "DoorNotAccessible", "FalseTable", "RDI", "CongressionalDistrict"
	 * @return Parameter value string
	 */
	public String GetOutputParameter(String ParameterName) {
		return mdAddrJNI.GetOutputParameter(I,ParameterName);
	}

	/**
	 * Sets a named input parameter before calling VerifyAddress
	 *
	 * @param ParameterName Parameter name defined by header macros: "EnableRDI", "CASSTest", "TotalDPS", "UsePostalCongressionalDistricts"
	 * @param Value Parameter value string
	 * @return 0 on success
	 */
	public int SetInputParameter(String ParameterName, String Value) {
		return mdAddrJNI.SetInputParameter(I,ParameterName,Value);
	}

	/**
	 * Returns the first suggested address when VerifyAddress could not verify the submitted address
	 *
	 * @return True (1) if a suggestion was found
	 */
	public boolean FindSuggestion() {
		return mdAddrJNI.FindSuggestion(I);
	}

	/**
	 * Returns the next suggested address after a successful call to FindSuggestion
	 *
	 * @return True (1) if another suggestion was found, false (0) if no more suggestions
	 */
	public boolean FindSuggestionNext() {
		return mdAddrJNI.FindSuggestionNext(I);
	}

	/**
	 * Returns the DSF (Delivery Sequence File) no-stats indicator for the verified address
	 *
	 * @return DSF no-stats indicator string
	 */
	public String GetDsfNoStats() {
		return mdAddrJNI.GetDsfNoStats(I);
	}

	/**
	 * Returns the DSF Do Not Address indicator for the verified address
	 *
	 * @return DSF DNA indicator string
	 */
	public String GetDsfDNA() {
		return mdAddrJNI.GetDsfDNA(I);
	}

	/**
	 * Returns the total number of address records verified since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 item B6)
	 *
	 * @return Total verified record count (integer)
	 */
	public int GetPS3553_B6_TotalRecords() {
		return mdAddrJNI.GetPS3553_B6_TotalRecords(I);
	}

	/**
	 * Returns the count of records matched to the ZIP+4 level since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 item C1a)
	 *
	 * @return ZIP+4 coded record count (integer)
	 */
	public int GetPS3553_C1a_ZIP4Coded() {
		return mdAddrJNI.GetPS3553_C1a_ZIP4Coded(I);
	}

	/**
	 * Returns the count of records assigned a Delivery Point Bar Code since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 item C1c)
	 *
	 * @return DPBC assigned record count (integer)
	 */
	public int GetPS3553_C1c_DPBCAssigned() {
		return mdAddrJNI.GetPS3553_C1c_DPBCAssigned(I);
	}

	/**
	 * Returns the count of records verified to the five-digit carrier route level since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 item C1d)
	 *
	 * @return Five-digit coded record count (integer)
	 */
	public int GetPS3553_C1d_FiveDigitCoded() {
		return mdAddrJNI.GetPS3553_C1d_FiveDigitCoded(I);
	}

	/**
	 * Returns the count of records verified to the carrier route level since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 item C1e)
	 *
	 * @return Carrier route coded record count (integer)
	 */
	public int GetPS3553_C1e_CRRTCoded() {
		return mdAddrJNI.GetPS3553_C1e_CRRTCoded(I);
	}

	/**
	 * Returns the count of records assigned an enhanced Line of Travel (eLOT) sequence number since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 item C1f)
	 *
	 * @return eLOT assigned record count (integer)
	 */
	public int GetPS3553_C1f_eLOTAssigned() {
		return mdAddrJNI.GetPS3553_C1f_eLOTAssigned(I);
	}

	/**
	 * Returns the count of high-rise records default matched (matched at the street address level but not to a valid secondary address) since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return High-rise default match count (integer)
	 */
	public int GetPS3553_E_HighRiseDefault() {
		return mdAddrJNI.GetPS3553_E_HighRiseDefault(I);
	}

	/**
	 * Returns the count of high-rise records exactly matched to both a primary and secondary address since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return High-rise exact match count (integer)
	 */
	public int GetPS3553_E_HighRiseExact() {
		return mdAddrJNI.GetPS3553_E_HighRiseExact(I);
	}

	/**
	 * Returns the count of rural route records default matched (verified at the route number level but not to a valid primary range) since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return Rural route default match count (integer)
	 */
	public int GetPS3553_E_RuralRouteDefault() {
		return mdAddrJNI.GetPS3553_E_RuralRouteDefault(I);
	}

	/**
	 * Returns the count of rural route records verified at the route number level and matched to a valid primary range, since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return Rural route exact match count (integer)
	 */
	public int GetPS3553_E_RuralRouteExact() {
		return mdAddrJNI.GetPS3553_E_RuralRouteExact(I);
	}

	/**
	 * Returns the count of high-rise records default matched at the ZIP+4 level, since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return ZIP+4 high-rise default match count (integer)
	 */
	public int GetZip4HRDefault() {
		return mdAddrJNI.GetZip4HRDefault(I);
	}

	/**
	 * Returns the count of high-rise records exactly matched at the ZIP+4 level, since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return ZIP+4 high-rise exact match count (integer)
	 */
	public int GetZip4HRExact() {
		return mdAddrJNI.GetZip4HRExact(I);
	}

	/**
	 * Returns the count of rural route records default matched at the ZIP+4 level, since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return ZIP+4 rural route default match count (integer)
	 */
	public int GetZip4RRDefault() {
		return mdAddrJNI.GetZip4RRDefault(I);
	}

	/**
	 * Returns the count of rural route records exactly matched at the ZIP+4 level, since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return ZIP+4 rural route exact match count (integer)
	 */
	public int GetZip4RRExact() {
		return mdAddrJNI.GetZip4RRExact(I);
	}

	/**
	 * Returns the count of records flagged as having undergone a rural-to-city-style address conversion since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return LACS record count (integer)
	 */
	public int GetPS3553_E_LACSCount() {
		return mdAddrJNI.GetPS3553_E_LACSCount(I);
	}

	/**
	 * Returns the count of records that did not appear in the current USPS ZIP+4 file but were valid addresses, since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return EWS record count (integer)
	 */
	public int GetPS3553_E_EWSCount() {
		return mdAddrJNI.GetPS3553_E_EWSCount(I);
	}

	/**
	 * Returns the count of records confirmed via DPV since the current instance was created or the last ResetFormPS3553 call (CASS Form 3553 section E)
	 *
	 * @return DPV confirmed record count (integer)
	 */
	public int GetPS3553_E_DPVCount() {
		return mdAddrJNI.GetPS3553_E_DPVCount(I);
	}

	/**
	 * Returns the count of PO Box address records verified since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return PO Box record count (integer)
	 */
	public int GetPS3553_X_POBoxCount() {
		return mdAddrJNI.GetPS3553_X_POBoxCount(I);
	}

	/**
	 * Returns the count of Highway Contract route records exactly matched since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Highway Contract exact match count (integer)
	 */
	public int GetPS3553_X_HCExactCount() {
		return mdAddrJNI.GetPS3553_X_HCExactCount(I);
	}

	/**
	 * Returns the count of firm/company address records verified since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Firm record count (integer)
	 */
	public int GetPS3553_X_FirmCount() {
		return mdAddrJNI.GetPS3553_X_FirmCount(I);
	}

	/**
	 * Returns the count of General Delivery address records verified since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return General Delivery record count (integer)
	 */
	public int GetPS3553_X_GenDeliveryCount() {
		return mdAddrJNI.GetPS3553_X_GenDeliveryCount(I);
	}

	/**
	 * Returns the count of military ZIP code address records verified since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Military ZIP record count (integer)
	 */
	public int GetPS3553_X_MilitaryZipCount() {
		return mdAddrJNI.GetPS3553_X_MilitaryZipCount(I);
	}

	/**
	 * Returns the count of non-deliverable address records since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Non-delivery record count (integer)
	 */
	public int GetPS3553_X_NonDeliveryCount() {
		return mdAddrJNI.GetPS3553_X_NonDeliveryCount(I);
	}

	/**
	 * Returns the count of street-level address records verified since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Street record count (integer)
	 */
	public int GetPS3553_X_StreetCount() {
		return mdAddrJNI.GetPS3553_X_StreetCount(I);
	}

	/**
	 * Returns the count of Highway Contract route records default matched since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Highway Contract default match count (integer)
	 */
	public int GetPS3553_X_HCDefaultCount() {
		return mdAddrJNI.GetPS3553_X_HCDefaultCount(I);
	}

	/**
	 * Returns the count of address records not falling into any standard category, since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return Other record count (integer)
	 */
	public int GetPS3553_X_OtherCount() {
		return mdAddrJNI.GetPS3553_X_OtherCount(I);
	}

	/**
	 * Returns the count of records with LACSLink Code A (successful match and conversion), since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return LACSLink Code A count (integer)
	 */
	public int GetPS3553_X_LacsLinkCodeACount() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCodeACount(I);
	}

	/**
	 * Returns the count of records with LACSLink Code 00 (no match found), since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return LACSLink Code 00 count (integer)
	 */
	public int GetPS3553_X_LacsLinkCode00Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode00Count(I);
	}

	/**
	 * Returns the count of records with LACSLink Code 14 (new address would not convert), since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return LACSLink Code 14 count (integer)
	 */
	public int GetPS3553_X_LacsLinkCode14Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode14Count(I);
	}

	/**
	 * Returns the count of records with LACSLink Code 92 (secondary number dropped during conversion), since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return LACSLink Code 92 count (integer)
	 */
	public int GetPS3553_X_LacsLinkCode92Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode92Count(I);
	}

	/**
	 * Returns the count of records with LACSLink Code 09, since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return LACSLink Code 09 count (integer)
	 */
	public int GetPS3553_X_LacsLinkCode09Count() {
		return mdAddrJNI.GetPS3553_X_LacsLinkCode09Count(I);
	}

	/**
	 * Returns the count of address records with suite information appended via SuiteLink (Code A), since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return SuiteLink Code A record count (integer)
	 */
	public int GetPS3553_X_SuiteLinkCodeACount() {
		return mdAddrJNI.GetPS3553_X_SuiteLinkCodeACount(I);
	}

	/**
	 * Returns the count of records with SuiteLink Code 00 (no suite match), since the current instance was created or the last ResetFormPS3553 call
	 *
	 * @return SuiteLink Code 00 count (integer)
	 */
	public int GetPS3553_X_SuiteLinkCode00Count() {
		return mdAddrJNI.GetPS3553_X_SuiteLinkCode00Count(I);
	}

	/**
	 * Returns the numeric delivery number from the verified street address
	 *
	 * @return Address range string (max 10 characters)
	 */
	public String GetParsedAddressRange() {
		return mdAddrJNI.GetParsedAddressRange(I);
	}

	/**
	 * Returns the directional preceding the street name from the verified address
	 *
	 * @return Pre-directional string (e.g. "N", "SW")
	 */
	public String GetParsedPreDirection() {
		return mdAddrJNI.GetParsedPreDirection(I);
	}

	/**
	 * Returns the street name from the verified address
	 *
	 * @return Street name string (max 28 characters)
	 */
	public String GetParsedStreetName() {
		return mdAddrJNI.GetParsedStreetName(I);
	}

	/**
	 * Returns the street suffix from the verified address
	 *
	 * @return Street suffix string (e.g. "ST", "AVE", "BLVD")
	 */
	public String GetParsedSuffix() {
		return mdAddrJNI.GetParsedSuffix(I);
	}

	/**
	 * Returns the directional following the street name from the verified address
	 *
	 * @return Post-directional string (e.g. "N", "SW")
	 */
	public String GetParsedPostDirection() {
		return mdAddrJNI.GetParsedPostDirection(I);
	}

	/**
	 * Returns the secondary unit designator from the verified address
	 *
	 * @return Suite designator string (e.g. "APT", "STE", "UNIT")
	 */
	public String GetParsedSuiteName() {
		return mdAddrJNI.GetParsedSuiteName(I);
	}

	/**
	 * Returns the secondary unit number from the verified address
	 *
	 * @return Suite number string
	 */
	public String GetParsedSuiteRange() {
		return mdAddrJNI.GetParsedSuiteRange(I);
	}

	/**
	 * Returns the private mailbox designator from the verified address
	 *
	 * @return Private mailbox name string ("PMB" or "#")
	 */
	public String GetParsedPrivateMailboxName() {
		return mdAddrJNI.GetParsedPrivateMailboxName(I);
	}

	/**
	 * Returns the private mailbox number from the verified address
	 *
	 * @return Private mailbox number string (max 10 characters)
	 */
	public String GetParsedPrivateMailboxNumber() {
		return mdAddrJNI.GetParsedPrivateMailboxNumber(I);
	}

	/**
	 * Returns any unrecognized characters left over after parsing the verified address
	 *
	 * @return Garbage string (max 50 characters)
	 */
	public String GetParsedGarbage() {
		return mdAddrJNI.GetParsedGarbage(I);
	}

	/**
	 * Returns the route service information from the verified Canadian address
	 *
	 * @return Route service string
	 */
	public String GetParsedRouteService() {
		return mdAddrJNI.GetParsedRouteService(I);
	}

	/**
	 * Returns the lock box information from the verified Canadian address
	 *
	 * @return Lock box string
	 */
	public String GetParsedLockBox() {
		return mdAddrJNI.GetParsedLockBox(I);
	}

	/**
	 * Returns the delivery installation information from the verified Canadian address
	 *
	 * @return Delivery installation string
	 */
	public String GetParsedDeliveryInstallation() {
		return mdAddrJNI.GetParsedDeliveryInstallation(I);
	}

	/**
	 * Reserved for Melissa Data internal use
	 *
	 * @param Key Reserved parameter name
	 * @param Value Reserved parameter value
	 */
	public void SetReserved(String Key, String Value) {
		mdAddrJNI.SetReserved(I,Key,Value);
	}

	/**
	 * Reserved for Melissa Data internal use
	 *
	 * @param Key Reserved parameter name
	 * @return Reserved parameter value
	 */
	public String GetReserved(String Key) {
		return mdAddrJNI.GetReserved(I,Key);
	}

}
