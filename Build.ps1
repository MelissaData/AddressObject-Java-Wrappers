# Set Java Includes and Address Object Library Path
$JavaIncludeDirectory1 = "C:\Program Files\Java\jdk-20\include"
$JavaIncludeDirectory2 = "C:\Program Files\Java\jdk-20\include\win32"
$AddrLibraryPath = $PSScriptRoot

# Run cl command
& 'cl' -I"$AddrLibraryPath" -I"$JavaIncludeDirectory1" -I"$JavaIncludeDirectory2" -Fe'mdAddrJavaWrapper.dll' 'mdAddrJavaWrapper.cpp' -link -DLL -LIBPATH:"$AddrLibraryPath" -DEFAULTLIB:'mdAddr.lib'

# Remove files
Remove-Item 'mdAddrJavaWrapper.exp' -ErrorAction SilentlyContinue
Remove-Item 'mdAddrJavaWrapper.obj' -ErrorAction SilentlyContinue
Remove-Item 'mdAddrJavaWrapper.lib' -ErrorAction SilentlyContinue

