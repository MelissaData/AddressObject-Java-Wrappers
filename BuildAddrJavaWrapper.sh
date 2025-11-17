#!/bin/bash

######################### Parameters ##########################

license=""

while [ $# -gt 0 ] ; do
  case $1 in
    -l | --license) 
        license="$2"
        ;;
  esac
  shift
done

########################## Config ###########################
RELEASE_VERSION='2025.11'

ProjectPath=$(pwd)

#Set Path to Java JDK include directories
JavaIncludeDirectory1="/usr/lib/jvm/java-11-openjdk-amd64/include"
JavaIncludeDirectory2="/usr/lib/jvm/java-11-openjdk-amd64/include/linux"

Config_FileName1="libmdAddr.so"
Config_ReleaseVersion1=$RELEASE_VERSION
Config_OS1="LINUX"
Config_Compiler1="GCC48"
Config_Architecture1="64BIT"
Config_Type1="BINARY"

Config_FileName2="mdEnums.h"
Config_ReleaseVersion2=$RELEASE_VERSION
Config_OS2="ANY"
Config_Compiler2="C"
Config_Architecture2="ANY"
Config_Type2="INTERFACE"

Config_FileName3="mdAddr.h"
Config_ReleaseVersion3=$RELEASE_VERSION
Config_OS3="ANY"
Config_Compiler3="C"
Config_Architecture3="ANY"
Config_Type3="INTERFACE"

Config_FileName4="mdAddrJavaWrapper.cpp"
Config_ReleaseVersion4=$RELEASE_VERSION
Config_OS4="ANY"
Config_Compiler4="JAVA"
Config_Architecture4="ANY"
Config_Type4="INTERFACE"

Com_FileName="mdAddr_JavaCode.zip"
Com_ReleaseVersion=$RELEASE_VERSION
Com_OS="ANY"
Com_Compiler="JAVA"
Com_Architecture="ANY"
Com_Type="INTERFACE"

######################### Functions #########################
DownloadFiles() 
{
  printf "\nMELISSA UPDATER IS DOWNLOADING FILE(s)...\n"
  
  ./MelissaUpdater/MelissaUpdater file --filename $Config_FileName1 --release_version $Config_ReleaseVersion1 --license $1 --os $Config_OS1 --compiler $Config_Compiler1 --architecture $Config_Architecture1 --type $Config_Type1 --target_directory $ProjectPath  
  
  if [ $? -ne 0 ];
  then
      printf "\nCannot run Melissa Updater. Please check your license string!\n"
      exit 1
  fi
  
  printf "Melissa Updater finished downloading $Config_FileName1!\n"
  
  ./MelissaUpdater/MelissaUpdater file --filename $Config_FileName2 --release_version $Config_ReleaseVersion2 --license $1 --os $Config_OS2 --compiler $Config_Compiler2 --architecture $Config_Architecture2 --type $Config_Type2 --target_directory $ProjectPath  
  
  if [ $? -ne 0 ];
  then
      printf "\nCannot run Melissa Updater. Please check your license string!\n"
      exit 1
  fi

  printf "Melissa Updater finished downloading $Config_FileName2!\n"
  
  ./MelissaUpdater/MelissaUpdater file --filename $Config_FileName3 --release_version $Config_ReleaseVersion3 --license $1 --os $Config_OS3 --compiler $Config_Compiler3 --architecture $Config_Architecture3 --type $Config_Type3 --target_directory $ProjectPath

  if [ $? -ne 0 ];
  then
      printf "\nCannot run Melissa Updater. Please check your license string!\n"
      exit 1
  fi
  
  printf "Melissa Updater finished downloading $Config_FileName3!\n"

  ./MelissaUpdater/MelissaUpdater file --filename $Config_FileName4 --release_version $Config_ReleaseVersion4 --license $1 --os $Config_OS4 --compiler $Config_Compiler4 --architecture $Config_Architecture4 --type $Config_Type4 --target_directory $ProjectPath

  if [ $? -ne 0 ];
  then
      printf "\nCannot run Melissa Updater. Please check your license string!\n"
      exit 1
  fi

  printf "Melissa Updater finished downloading $Config_FileName4!\n"

  ./MelissaUpdater/MelissaUpdater file --filename $Com_FileName --release_version $Com_ReleaseVersion --license $1 --os $Com_OS --compiler $Com_Compiler --architecture $Com_Architecture --type $Com_Type --target_directory $ProjectPath

  if [ $? -ne 0 ];
  then
      printf "\nCannot run Melissa Updater. Please check your license string!\n"
      exit 1
  fi
  
  printf "Melissa Updater finished downloading $Com_FileName!\n"

  # Check for the zip folder and extract from the zip folder if it was downloaded
  if [ ! -f "$ProjectPath/mdAddr_JavaCode.zip" ];
  then
      printf "mdAddr_JavaCode.zip not found.\n"
      printf "Aborting program, see above.\n"

      exit 1
  else
      if [ ! -d "$ProjectPath/com" ];
      then
          unzip "$ProjectPath/mdAddr_JavaCode.zip" -d "$ProjectPath"
      else
          rm -r "$ProjectPath/com"

          unzip "$ProjectPath/mdAddr_JavaCode.zip" -d "$ProjectPath"
      fi
  fi
}

CheckFiles() 
{
  printf "\nDouble checking file(s) were downloaded...\n"
  FileMissing=0
  if [ ! -f $Config_FileName1 ];
  then
      printf "\n$Config_FileName1 not found\n"
      FileMissing=1
  fi
  if [ ! -f $Config_FileName2 ];
  then
      printf "\n$Config_FileName2 not found\n"
      FileMissing=1
  fi
  if [ ! -f $Config_FileName3 ];
  then
      printf "\n$Config_FileName3 not found\n"
      FileMissing=1
  fi

  if [ $FileMissing -eq 1 ];
  then
      printf "\nMissing the above data file(s).  Please check that your license string and directory are correct."
      echo 0
  else
      echo 1
  fi
}

########################## Main ############################
printf "\n======================= WELCOME TO MELISSA ADDRESS OBJECT JAVA WRAPPER =======================\n"

# Get license (either from parameters or user input)
if [ -z "$license" ];
then
  printf "Please enter your license string: "
  read license
fi

# Check license from Environment Variables 
if [ -z "$license" ];
then
  license=`echo $MD_LICENSE` 
fi

if [ -z "$license" ];
then
  printf "\nLicense String is invalid!\n"
  exit 1
fi

# Use Melissa Updater to download file(s)
DownloadFiles $license

# Check if all file(s) have been downloaded. Exit script if missing
FilesDownloaded=$(CheckFiles)

if echo "$FilesDownloaded" | grep -q "0";
then
  echo "$FilesDownloaded" | sed 's/0$//'
  printf "\nAborting program, see above.\n"
  exit 1
fi

printf "\nAll file(s) have been downloaded/updated!\n"

rm *.hash

# Build the wrapper
printf "\n========================================= BUILD WRAPPER ======================================\n"

# Compile SO
gcc -fpic -c -I$ProjectPath -I$JavaIncludeDirectory1 -I$JavaIncludeDirectory2 mdAddrJavaWrapper.cpp
gcc -g -shared mdAddrJavaWrapper.o -o libmdAddrJavaWrapper.so -L$ProjectPath -lmdAddr -pthread

rm mdAddrJavaWrapper.o

# Compile Jar
javac com/melissadata/*.java &> /dev/null

jar cvf mdAddr.jar com/melissadata/*.class &> /dev/null

if [ -f "libmdAddrJavaWrapper.so" ];
then
  script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
  file_path="$script_dir/libmdAddrJavaWrapper.so"

  printf "\nlibmdAddrJavaWrapper.so has been successfully generated at:\n$file_path\n"
else
  printf "\nError: was not able to create libmdAddrJavaWrapper.so\n"
fi

if [ -f "mdAddr.jar" ];
then
  script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
  file_path="$script_dir/mdAddr.jar"

  printf "\nmdAddr.jar has been successfully generated at:\n$file_path\n"
else
  printf "\nError: was not able to create mdAddr.jar\n"
fi

printf "\n=========================== THANK YOU FOR USING MELISSA JAVA WRAPPER =========================\n"
