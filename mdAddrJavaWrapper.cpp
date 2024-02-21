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

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jstring p3) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	Utf8String _p3(jEnv,p3);
	return (jint) ((mdAddr*) I)->Initialize(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),_p3.GetUtf8Ptr());
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_InitializeDataFiles(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jint) ((mdAddr*) I)->InitializeDataFiles();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetInitializeErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetInitializeErrorString());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdAddr*) I)->SetLicenseString(_p1.GetUtf8Ptr());
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

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToUSFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToUSFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToCanadaFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToCanadaFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToDPVDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToDPVDataFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToLACSLinkDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToLACSLinkDataFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToSuiteLinkDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToSuiteLinkDataFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToSuiteFinderDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToSuiteFinderDataFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToRBDIFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToRBDIFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetRBDIDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetRBDIDatabaseDate());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPathToAddrKeyDataFiles(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPathToAddrKeyDataFiles(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ClearProperties(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ClearProperties();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_ResetDPV(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	((mdAddr*) I)->ResetDPV();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCASSEnable(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint p1) {
	((mdAddr*) I)->SetCASSEnable((int) p1);
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetUseUSPSPreferredCityNames(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint p1) {
	((mdAddr*) I)->SetUseUSPSPreferredCityNames((int) p1);
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetDiacritics(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jint p1) {
	((mdAddr*) I)->SetDiacritics((mdAddr::DiacriticsMode) p1);
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

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_B1_ProcessorName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_B1_ProcessorName(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_B4_ListName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_B4_ListName(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_Name(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_D3_Name(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_Company(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_D3_Company(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_Address(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_D3_Address(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_City(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_D3_City(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_State(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_D3_State(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPS3553_D3_ZIP(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPS3553_D3_ZIP(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetFormPS3553(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdAddr*) I)->GetFormPS3553());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdAddrJNI_SaveFormPS3553(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdAddr*) I)->SaveFormPS3553(_p1.GetUtf8Ptr());
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

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SaveFormSOA(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SaveFormSOA(_p1.GetUtf8Ptr());
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

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCompany(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetCompany(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetLastName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetLastName(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetAddress(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetAddress(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetAddress2(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetAddress2(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetLastLine(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetLastLine(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetSuite(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetSuite(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetCity(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetState(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetState(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetZip(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetPlus4(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetPlus4(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetUrbanization(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetUrbanization(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedAddressRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedAddressRange(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedPreDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedPreDirection(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedStreetName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedStreetName(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedSuffix(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedSuffix(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedPostDirection(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedPostDirection(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedSuiteName(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedSuiteName(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedSuiteRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedSuiteRange(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedRouteService(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedRouteService(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedLockBox(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedLockBox(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetParsedDeliveryInstallation(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetParsedDeliveryInstallation(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetCountryCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdAddr*) I)->SetCountryCode(_p1.GetUtf8Ptr());
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

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetOutputParameter(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return UnicodeString(jEnv,((mdAddr*) I)->GetOutputParameter(_p1.GetUtf8Ptr()));
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdAddrJNI_SetInputParameter(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	return (jint) ((mdAddr*) I)->SetInputParameter(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr());
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

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdAddrJNI_SetReserved(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	((mdAddr*) I)->SetReserved(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdAddrJNI_GetReserved(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return UnicodeString(jEnv,((mdAddr*) I)->GetReserved(_p1.GetUtf8Ptr()));
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdParseJNI_mdParseCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdParse();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_mdParseDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdParse*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdParseJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jint) ((mdParse*) I)->Initialize(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdParseJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdParse*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_Parse(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdParse*) I)->Parse(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_ParseCanadian(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdParse*) I)->ParseCanadian(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdParseJNI_ParseNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdParse*) I)->ParseNext();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdParseJNI_LastLineParse(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	((mdParse*) I)->LastLineParse(_p1.GetUtf8Ptr());
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

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdStreetJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jstring p3) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	Utf8String _p3(jEnv,p3);
	return (jint) ((mdStreet*) I)->Initialize(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),_p3.GetUtf8Ptr());
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

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdStreet*) I)->SetLicenseString(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdStreet*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_FindStreet(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jboolean p3) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	return (jboolean) ((mdStreet*) I)->FindStreet(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),p3!=0 ? true : false);
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_FindStreetNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdStreet*) I)->FindStreetNext();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_IsAddressInRange(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jstring p3) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	Utf8String _p3(jEnv,p3);
	return (jboolean) ((mdStreet*) I)->IsAddressInRange(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),_p3.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdStreetJNI_IsAddressInRange2(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jstring p3,jstring p4) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	Utf8String _p3(jEnv,p3);
	Utf8String _p4(jEnv,p4);
	return (jboolean) ((mdStreet*) I)->IsAddressInRange2(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),_p3.GetUtf8Ptr(),_p4.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdStreetJNI_GetAutoCompletion(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jint p3,jboolean p4) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	return UnicodeString(jEnv,((mdStreet*) I)->GetAutoCompletion(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),(mdStreet::AutoCompletionMode) p3,p4!=0 ? true : false));
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

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdZipJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2,jstring p3) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	Utf8String _p3(jEnv,p3);
	return (jint) ((mdZip*) I)->Initialize(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr(),_p3.GetUtf8Ptr());
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

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdZip*) I)->SetLicenseString(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdZip*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZip(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jboolean p2) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdZip*) I)->FindZip(_p1.GetUtf8Ptr(),p2!=0 ? true : false);
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZipNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdZip*) I)->FindZipNext();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZipInCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	return (jboolean) ((mdZip*) I)->FindZipInCity(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindZipInCityNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdZip*) I)->FindZipInCityNext();
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindCityInState(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1,jstring p2) {
	Utf8String _p1(jEnv,p1);
	Utf8String _p2(jEnv,p2);
	return (jboolean) ((mdZip*) I)->FindCityInState(_p1.GetUtf8Ptr(),_p2.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdZipJNI_FindCityInStateNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdZip*) I)->FindCityInStateNext();
}

extern "C" JNIEXPORT jdouble JNICALL Java_com_melissadata_mdZipJNI_ComputeDistance(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jdouble p1,jdouble p2,jdouble p3,jdouble p4) {
	return (jdouble) ((mdZip*) I)->ComputeDistance((double) p1,(double) p2,(double) p3,(double) p4);
}

extern "C" JNIEXPORT jdouble JNICALL Java_com_melissadata_mdZipJNI_ComputeBearing(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jdouble p1,jdouble p2,jdouble p3,jdouble p4) {
	return (jdouble) ((mdZip*) I)->ComputeBearing((double) p1,(double) p2,(double) p3,(double) p4);
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdZipJNI_GetCountyNameFromFips(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return UnicodeString(jEnv,((mdZip*) I)->GetCountyNameFromFips(_p1.GetUtf8Ptr()));
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

