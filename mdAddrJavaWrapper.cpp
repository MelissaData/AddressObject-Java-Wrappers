#include <jni.h>

#include "mdAddr.h"

class Utf8String {
	private:
		JNIEnv* env;
		const char* utf8Ptr;
		jstring jString;
	public:
		Utf8String(JNIEnv* jEnv,jstring str);
		~Utf8String();
		const char* GetUtf8Ptr();
};

Utf8String::Utf8String(JNIEnv* jEnv,jstring str) {
	env=jEnv;
	jString=str;
	if (jString!=0)
		utf8Ptr=env->GetStringUTFChars(jString,0);
	else
		utf8Ptr=0;
}

Utf8String::~Utf8String() {
	if (utf8Ptr!=0)
		env->ReleaseStringUTFChars(jString,utf8Ptr);
}

const char* Utf8String::GetUtf8Ptr() {
	if (utf8Ptr!=0)
		return utf8Ptr;
	return "";
}

jstring UnicodeString(JNIEnv* jEnv,const char* str) {
	if (str!=0)
		return jEnv->NewStringUTF(str);
	return jEnv->NewStringUTF("");
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdAddrJNI_mdAddrCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdAddr();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_mdAddrDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdAddr*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataPath,jstring NationalPath,jstring RegionalPath) {
	Utf8String _DataPath(jEnv,DataPath);
	Utf8String _NationalPath(jEnv,NationalPath);
	Utf8String _RegionalPath(jEnv,RegionalPath);
	return (jint) ((mdAddr*) I)->Initialize(_DataPath.GetUtf8Ptr(),_NationalPath.GetUtf8Ptr(),_RegionalPath.GetUtf8Ptr());
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_InitializeDataFiles(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->InitializeDataFiles();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetInitializeErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetInitializeErrorString());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring License) {
	Utf8String _License(jEnv,License);
	return (jboolean) ((mdAddr*) I)->SetLicenseString(_License.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDatabaseDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetExpirationDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCanadianDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCanadianDatabaseDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCanadianExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCanadianExpirationDate());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToUSFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToUSFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToCanadaFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToCanadaFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToDPVDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToDPVDataFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToLACSLinkDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToLACSLinkDataFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToSuiteLinkDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToSuiteLinkDataFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToSuiteFinderDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToSuiteFinderDataFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToRBDIFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToRBDIFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetRBDIDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetRBDIDatabaseDate());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToAddrKeyDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataFilePath) {
	Utf8String _DataFilePath(jEnv,DataFilePath);
	((mdAddr*) I)->SetPathToAddrKeyDataFiles(_DataFilePath.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ClearProperties(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ClearProperties();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ResetDPV(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ResetDPV();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCASSEnable(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint Enable) {
	((mdAddr*) I)->SetCASSEnable((int) Enable);
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetUseUSPSPreferredCityNames(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint Enable) {
	((mdAddr*) I)->SetUseUSPSPreferredCityNames((int) Enable);
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetDiacritics(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint mode) {
	((mdAddr*) I)->SetDiacritics((mdAddr::DiacriticsMode) mode);
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetStatusCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetStatusCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetErrorCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetErrorCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetErrorString());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetResults(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetResults());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetResultCodeDescription(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring resultCode,jint opt) {
	Utf8String _resultCode(jEnv,resultCode);
	return UnicodeString(jEnv,((mdAddr*) I)->GetResultCodeDescription(_resultCode.GetUtf8Ptr(),(mdAddr::ResultCdDescOpt) opt));
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_B1_ProcessorName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring ProcessorName) {
	Utf8String _ProcessorName(jEnv,ProcessorName);
	((mdAddr*) I)->SetPS3553_B1_ProcessorName(_ProcessorName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_B4_ListName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring ListName) {
	Utf8String _ListName(jEnv,ListName);
	((mdAddr*) I)->SetPS3553_B4_ListName(_ListName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_Name(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Name) {
	Utf8String _Name(jEnv,Name);
	((mdAddr*) I)->SetPS3553_D3_Name(_Name.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_Company(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Company) {
	Utf8String _Company(jEnv,Company);
	((mdAddr*) I)->SetPS3553_D3_Company(_Company.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_Address(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Address) {
	Utf8String _Address(jEnv,Address);
	((mdAddr*) I)->SetPS3553_D3_Address(_Address.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_City(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring City) {
	Utf8String _City(jEnv,City);
	((mdAddr*) I)->SetPS3553_D3_City(_City.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_State(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring State) {
	Utf8String _State(jEnv,State);
	((mdAddr*) I)->SetPS3553_D3_State(_State.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_ZIP(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring ZIP) {
	Utf8String _ZIP(jEnv,ZIP);
	((mdAddr*) I)->SetPS3553_D3_ZIP(_ZIP.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetFormPS3553(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetFormPS3553());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_SaveFormPS3553(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring PathAndFileName) {
	Utf8String _PathAndFileName(jEnv,PathAndFileName);
	return (jboolean) ((mdAddr*) I)->SaveFormPS3553(_PathAndFileName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ResetFormPS3553(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ResetFormPS3553();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ResetFormPS3553Counter(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ResetFormPS3553Counter();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetStandardizationType(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint mode) {
	((mdAddr*) I)->SetStandardizationType((mdAddr::StandardizeMode) mode);
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetSuiteParseMode(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint mode) {
	((mdAddr*) I)->SetSuiteParseMode((mdAddr::SuiteParseMode) mode);
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetAliasMode(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint mode) {
	((mdAddr*) I)->SetAliasMode((mdAddr::AliasPreserveMode) mode);
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetFormSOA(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetFormSOA());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SaveFormSOA(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring PathAndFileName) {
	Utf8String _PathAndFileName(jEnv,PathAndFileName);
	((mdAddr*) I)->SaveFormSOA(_PathAndFileName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ResetFormSOA(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ResetFormSOA();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetSOACustomerInfo(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring customerName,jstring customerAddress) {
	Utf8String _customerName(jEnv,customerName);
	Utf8String _customerAddress(jEnv,customerAddress);
	((mdAddr*) I)->SetSOACustomerInfo(_customerName.GetUtf8Ptr(),_customerAddress.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetSOACPCNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring CPCNumber) {
	Utf8String _CPCNumber(jEnv,CPCNumber);
	((mdAddr*) I)->SetSOACPCNumber(_CPCNumber.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSOACustomerInfo(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSOACustomerInfo());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSOACPCNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSOACPCNumber());
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdAddrJNI_GetSOATotalRecords(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jlong) ((mdAddr*) I)->GetSOATotalRecords();
}

extern "C" JNIEXPORT jfloat JNICALL Java_com_melissadata_mdAddrJNI_GetSOAAAPercentage(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jfloat) ((mdAddr*) I)->GetSOAAAPercentage();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSOAAAExpiryDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSOAAAExpiryDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSOASoftwareInfo(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSOASoftwareInfo());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSOAErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSOAErrorString());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCompany(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Company) {
	Utf8String _Company(jEnv,Company);
	((mdAddr*) I)->SetCompany(_Company.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetLastName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring LastName) {
	Utf8String _LastName(jEnv,LastName);
	((mdAddr*) I)->SetLastName(_LastName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetAddress(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Address) {
	Utf8String _Address(jEnv,Address);
	((mdAddr*) I)->SetAddress(_Address.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetAddress2(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Address2) {
	Utf8String _Address2(jEnv,Address2);
	((mdAddr*) I)->SetAddress2(_Address2.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetLastLine(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring LastLine) {
	Utf8String _LastLine(jEnv,LastLine);
	((mdAddr*) I)->SetLastLine(_LastLine.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetSuite(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Suite) {
	Utf8String _Suite(jEnv,Suite);
	((mdAddr*) I)->SetSuite(_Suite.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring City) {
	Utf8String _City(jEnv,City);
	((mdAddr*) I)->SetCity(_City.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetState(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring State) {
	Utf8String _State(jEnv,State);
	((mdAddr*) I)->SetState(_State.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Zip) {
	Utf8String _Zip(jEnv,Zip);
	((mdAddr*) I)->SetZip(_Zip.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPlus4(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Plus4) {
	Utf8String _Plus4(jEnv,Plus4);
	((mdAddr*) I)->SetPlus4(_Plus4.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetUrbanization(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Urbanization) {
	Utf8String _Urbanization(jEnv,Urbanization);
	((mdAddr*) I)->SetUrbanization(_Urbanization.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedAddressRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring AddressRange) {
	Utf8String _AddressRange(jEnv,AddressRange);
	((mdAddr*) I)->SetParsedAddressRange(_AddressRange.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedPreDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring PreDirection) {
	Utf8String _PreDirection(jEnv,PreDirection);
	((mdAddr*) I)->SetParsedPreDirection(_PreDirection.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedStreetName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring StreetName) {
	Utf8String _StreetName(jEnv,StreetName);
	((mdAddr*) I)->SetParsedStreetName(_StreetName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedSuffix(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Suffix) {
	Utf8String _Suffix(jEnv,Suffix);
	((mdAddr*) I)->SetParsedSuffix(_Suffix.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedPostDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring PostDirection) {
	Utf8String _PostDirection(jEnv,PostDirection);
	((mdAddr*) I)->SetParsedPostDirection(_PostDirection.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedSuiteName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring SuiteName) {
	Utf8String _SuiteName(jEnv,SuiteName);
	((mdAddr*) I)->SetParsedSuiteName(_SuiteName.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedSuiteRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring SuiteRange) {
	Utf8String _SuiteRange(jEnv,SuiteRange);
	((mdAddr*) I)->SetParsedSuiteRange(_SuiteRange.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedRouteService(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring RouteService) {
	Utf8String _RouteService(jEnv,RouteService);
	((mdAddr*) I)->SetParsedRouteService(_RouteService.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedLockBox(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring LockBox) {
	Utf8String _LockBox(jEnv,LockBox);
	((mdAddr*) I)->SetParsedLockBox(_LockBox.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedDeliveryInstallation(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DeliveryInstallation) {
	Utf8String _DeliveryInstallation(jEnv,DeliveryInstallation);
	((mdAddr*) I)->SetParsedDeliveryInstallation(_DeliveryInstallation.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCountryCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring CountryCode) {
	Utf8String _CountryCode(jEnv,CountryCode);
	((mdAddr*) I)->SetCountryCode(_CountryCode.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_VerifyAddress(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdAddr*) I)->VerifyAddress();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCompany(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCompany());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetLastName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetLastName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetAddress(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetAddress());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetAddress2(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetAddress2());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSuite(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSuite());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCity());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCityAbbreviation(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCityAbbreviation());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetState(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetState());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetZip());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetPlus4(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetPlus4());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCarrierRoute(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCarrierRoute());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDeliveryPointCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDeliveryPointCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDeliveryPointCheckDigit(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDeliveryPointCheckDigit());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCountyFips(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCountyFips());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCountyName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCountyName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetAddressTypeCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetAddressTypeCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetAddressTypeString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetAddressTypeString());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetUrbanization(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetUrbanization());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCongressionalDistrict(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCongressionalDistrict());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetLACS(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetLACS());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetLACSLinkIndicator(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetLACSLinkIndicator());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetPrivateMailbox(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetPrivateMailbox());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetTimeZoneCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetTimeZoneCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetTimeZone(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetTimeZone());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetMsa(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetMsa());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetPmsa(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetPmsa());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDefaultFlagIndicator(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDefaultFlagIndicator());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSuiteStatus(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSuiteStatus());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetEWSFlag(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetEWSFlag());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCMRA(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCMRA());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDsfVacant(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDsfVacant());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetCountryCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetCountryCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetZipType(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetZipType());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetFalseTable(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetFalseTable());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDPVFootnotes(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDPVFootnotes());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetLACSLinkReturnCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetLACSLinkReturnCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetSuiteLinkReturnCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetSuiteLinkReturnCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetRBDI(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetRBDI());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetELotNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetELotNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetELotOrder(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetELotOrder());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetAddressKey(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetAddressKey());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetMelissaAddressKey(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetMelissaAddressKey());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetMelissaAddressKeyBase(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetMelissaAddressKeyBase());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetOutputParameter(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring ParameterName) {
	Utf8String _ParameterName(jEnv,ParameterName);
	return UnicodeString(jEnv,((mdAddr*) I)->GetOutputParameter(_ParameterName.GetUtf8Ptr()));
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_SetInputParameter(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring ParameterName,jstring Value) {
	Utf8String _ParameterName(jEnv,ParameterName);
	Utf8String _Value(jEnv,Value);
	return (jint) ((mdAddr*) I)->SetInputParameter(_ParameterName.GetUtf8Ptr(),_Value.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_FindSuggestion(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdAddr*) I)->FindSuggestion();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_FindSuggestionNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdAddr*) I)->FindSuggestionNext();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDsfNoStats(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDsfNoStats());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetDsfDNA(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetDsfDNA());
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_B6_TotalRecords(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_B6_TotalRecords();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_C1a_ZIP4Coded(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_C1a_ZIP4Coded();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_C1c_DPBCAssigned(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_C1c_DPBCAssigned();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_C1d_FiveDigitCoded(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_C1d_FiveDigitCoded();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_C1e_CRRTCoded(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_C1e_CRRTCoded();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_C1f_eLOTAssigned(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_C1f_eLOTAssigned();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_HighRiseDefault(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_HighRiseDefault();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_HighRiseExact(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_HighRiseExact();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_RuralRouteDefault(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_RuralRouteDefault();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_RuralRouteExact(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_RuralRouteExact();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetZip4HRDefault(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetZip4HRDefault();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetZip4HRExact(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetZip4HRExact();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetZip4RRDefault(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetZip4RRDefault();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetZip4RRExact(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetZip4RRExact();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_LACSCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_LACSCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_EWSCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_EWSCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_E_DPVCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_E_DPVCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_POBoxCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_POBoxCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_HCExactCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_HCExactCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_FirmCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_FirmCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_GenDeliveryCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_GenDeliveryCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_MilitaryZipCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_MilitaryZipCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_NonDeliveryCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_NonDeliveryCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_StreetCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_StreetCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_HCDefaultCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_HCDefaultCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_OtherCount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_OtherCount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_LacsLinkCodeACount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_LacsLinkCodeACount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_LacsLinkCode00Count(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_LacsLinkCode00Count();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_LacsLinkCode14Count(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_LacsLinkCode14Count();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_LacsLinkCode92Count(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_LacsLinkCode92Count();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_LacsLinkCode09Count(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_LacsLinkCode09Count();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_SuiteLinkCodeACount(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_SuiteLinkCodeACount();
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_GetPS3553_X_SuiteLinkCode00Count(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->GetPS3553_X_SuiteLinkCode00Count();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedAddressRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedAddressRange());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedPreDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedPreDirection());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedStreetName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedStreetName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedSuffix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedSuffix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedPostDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedPostDirection());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedSuiteName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedSuiteName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedSuiteRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedSuiteRange());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedPrivateMailboxName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedPrivateMailboxName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedPrivateMailboxNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedPrivateMailboxNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedGarbage(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedGarbage());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedRouteService(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedRouteService());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedLockBox(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedLockBox());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetParsedDeliveryInstallation(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetParsedDeliveryInstallation());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetReserved(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Key,jstring Value) {
	Utf8String _Key(jEnv,Key);
	Utf8String _Value(jEnv,Value);
	((mdAddr*) I)->SetReserved(_Key.GetUtf8Ptr(),_Value.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetReserved(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Key) {
	Utf8String _Key(jEnv,Key);
	return UnicodeString(jEnv,((mdAddr*) I)->GetReserved(_Key.GetUtf8Ptr()));
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdParseJNI_mdParseCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdParse();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_mdParseDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdParse*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdParseJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataPath) {
	Utf8String _DataPath(jEnv,DataPath);
	return (jint) ((mdParse*) I)->Initialize(_DataPath.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_Parse(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring AddressToParse) {
	Utf8String _AddressToParse(jEnv,AddressToParse);
	((mdParse*) I)->Parse(_AddressToParse.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_ParseCanadian(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring AddressToParse) {
	Utf8String _AddressToParse(jEnv,AddressToParse);
	((mdParse*) I)->ParseCanadian(_AddressToParse.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdParseJNI_ParseNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdParse*) I)->ParseNext();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_LastLineParse(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring LastLine) {
	Utf8String _LastLine(jEnv,LastLine);
	((mdParse*) I)->LastLineParse(_LastLine.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetZip());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetPlus4(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetPlus4());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetCity());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetState(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetState());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetStreetName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetStreetName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetRange());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetPreDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetPreDirection());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetPostDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetPostDirection());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetSuffix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetSuffix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetSuiteName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetSuiteName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetSuiteNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetSuiteNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetPrivateMailboxNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetPrivateMailboxNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetPrivateMailboxName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetPrivateMailboxName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetGarbage(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetGarbage());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetRouteService(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetRouteService());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetLockBox(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetLockBox());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetDeliveryInstallation(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetDeliveryInstallation());
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdStreetJNI_mdStreetCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdStreet();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdStreetJNI_mdStreetDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdStreet*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdStreetJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataPath,jstring NationalPath,jstring RegionalPath) {
	Utf8String _DataPath(jEnv,DataPath);
	Utf8String _NationalPath(jEnv,NationalPath);
	Utf8String _RegionalPath(jEnv,RegionalPath);
	return (jint) ((mdStreet*) I)->Initialize(_DataPath.GetUtf8Ptr(),_NationalPath.GetUtf8Ptr(),_RegionalPath.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetInitializeErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetInitializeErrorString());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetDatabaseDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring License) {
	Utf8String _License(jEnv,License);
	return (jboolean) ((mdStreet*) I)->SetLicenseString(_License.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_FindStreet(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring StreetName,jstring ZIP,jboolean CodeOnly) {
	Utf8String _StreetName(jEnv,StreetName);
	Utf8String _ZIP(jEnv,ZIP);
	return (jboolean) ((mdStreet*) I)->FindStreet(_StreetName.GetUtf8Ptr(),_ZIP.GetUtf8Ptr(),CodeOnly!=0 ? true : false);
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_FindStreetNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdStreet*) I)->FindStreetNext();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_IsAddressInRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring InputRange,jstring LoRange,jstring HiRange) {
	Utf8String _InputRange(jEnv,InputRange);
	Utf8String _LoRange(jEnv,LoRange);
	Utf8String _HiRange(jEnv,HiRange);
	return (jboolean) ((mdStreet*) I)->IsAddressInRange(_InputRange.GetUtf8Ptr(),_LoRange.GetUtf8Ptr(),_HiRange.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_IsAddressInRange2(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring InputRange,jstring LoRange,jstring HiRange,jstring OddEvenFlag) {
	Utf8String _InputRange(jEnv,InputRange);
	Utf8String _LoRange(jEnv,LoRange);
	Utf8String _HiRange(jEnv,HiRange);
	Utf8String _OddEvenFlag(jEnv,OddEvenFlag);
	return (jboolean) ((mdStreet*) I)->IsAddressInRange2(_InputRange.GetUtf8Ptr(),_LoRange.GetUtf8Ptr(),_HiRange.GetUtf8Ptr(),_OddEvenFlag.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetAutoCompletion(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Address,jstring Zip,jint mode,jboolean DPVOnly) {
	Utf8String _Address(jEnv,Address);
	Utf8String _Zip(jEnv,Zip);
	return UnicodeString(jEnv,((mdStreet*) I)->GetAutoCompletion(_Address.GetUtf8Ptr(),_Zip.GetUtf8Ptr(),(mdStreet::AutoCompletionMode) mode,DPVOnly!=0 ? true : false));
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdStreetJNI_ResetAutoCompletion(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdStreet*) I)->ResetAutoCompletion();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetBaseAlternateIndicator(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetBaseAlternateIndicator());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetLACSIndicator(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetLACSIndicator());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetUrbanizationCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetUrbanizationCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetUrbanizationName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetUrbanizationName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetLastLineNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetLastLineNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetAddressType(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetAddressType());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetCongressionalDistrict(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetCongressionalDistrict());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetCountyFips(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetCountyFips());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetCompany(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetCompany());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetCarrierRoute(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetCarrierRoute());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetZip());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetDeliveryInstallation(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetDeliveryInstallation());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPlus4High(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPlus4High());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPlus4Low(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPlus4Low());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetSuiteRangeOddEven(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetSuiteRangeOddEven());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetSuiteRangeHigh(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetSuiteRangeHigh());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetSuiteRangeLow(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetSuiteRangeLow());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetSuiteName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetSuiteName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPostDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPostDirection());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetSuffix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetSuffix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetStreetName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetStreetName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPreDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPreDirection());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPrimaryRangeOddEven(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPrimaryRangeOddEven());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPrimaryRangeHigh(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPrimaryRangeHigh());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetPrimaryRangeLow(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetPrimaryRangeLow());
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdZipJNI_mdZipCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdZip();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdZipJNI_mdZipDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdZip*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdZipJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring DataPath,jstring NationalPath,jstring RegionalPath) {
	Utf8String _DataPath(jEnv,DataPath);
	Utf8String _NationalPath(jEnv,NationalPath);
	Utf8String _RegionalPath(jEnv,RegionalPath);
	return (jint) ((mdZip*) I)->Initialize(_DataPath.GetUtf8Ptr(),_NationalPath.GetUtf8Ptr(),_RegionalPath.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetInitializeErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetInitializeErrorString());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetDatabaseDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring License) {
	Utf8String _License(jEnv,License);
	return (jboolean) ((mdZip*) I)->SetLicenseString(_License.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring Zip,jboolean GetLastLineRecord) {
	Utf8String _Zip(jEnv,Zip);
	return (jboolean) ((mdZip*) I)->FindZip(_Zip.GetUtf8Ptr(),GetLastLineRecord!=0 ? true : false);
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZipNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdZip*) I)->FindZipNext();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZipInCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring City,jstring State) {
	Utf8String _City(jEnv,City);
	Utf8String _State(jEnv,State);
	return (jboolean) ((mdZip*) I)->FindZipInCity(_City.GetUtf8Ptr(),_State.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZipInCityNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdZip*) I)->FindZipInCityNext();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindCityInState(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring City,jstring State) {
	Utf8String _City(jEnv,City);
	Utf8String _State(jEnv,State);
	return (jboolean) ((mdZip*) I)->FindCityInState(_City.GetUtf8Ptr(),_State.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindCityInStateNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdZip*) I)->FindCityInStateNext();
}

extern "C" JNIEXPORT jdouble JNICALL Java_com_melissadata_mdZipJNI_ComputeDistance(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jdouble lat1,jdouble long1,jdouble lat2,jdouble long2) {
	return (jdouble) ((mdZip*) I)->ComputeDistance((double) lat1,(double) long1,(double) lat2,(double) long2);
}

extern "C" JNIEXPORT jdouble JNICALL Java_com_melissadata_mdZipJNI_ComputeBearing(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jdouble lat1,jdouble long1,jdouble lat2,jdouble long2) {
	return (jdouble) ((mdZip*) I)->ComputeBearing((double) lat1,(double) long1,(double) lat2,(double) long2);
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetCountyNameFromFips(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring FipsCode) {
	Utf8String _FipsCode(jEnv,FipsCode);
	return UnicodeString(jEnv,((mdZip*) I)->GetCountyNameFromFips(_FipsCode.GetUtf8Ptr()));
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetZip());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetCity());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetCityAbbreviation(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetCityAbbreviation());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetState(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetState());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetZipType(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetZipType());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetCountyName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetCountyName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetCountyFips(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetCountyFips());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetAreaCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetAreaCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetLongitude(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetLongitude());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetLatitude(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetLatitude());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetTimeZone(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetTimeZone());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetTimeZoneCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetTimeZoneCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetMsa(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetMsa());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetPmsa(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetPmsa());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetFacilityCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetFacilityCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetLastLineIndicator(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetLastLineIndicator());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetLastLineNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetLastLineNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetPreferredLastLineNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetPreferredLastLineNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetAutomation(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetAutomation());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetFinanceNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetFinanceNumber());
}

