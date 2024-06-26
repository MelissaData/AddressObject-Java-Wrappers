######################### Parameters ##########################

param($license = '')

######################### Classes ##########################

class FileConfig {
  [string] $FileName;
  [string] $ReleaseVersion;
  [string] $OS;
  [string] $Compiler;
  [string] $Architecture;
  [string] $Type;
}

######################### Config ###########################

$RELEASE_VERSION = '2024.06'

$CurrentPath = $PSScriptRoot
$CmdPath = "C:\Program Files\Microsoft Visual Studio\2022\Professional\VC\Auxiliary\Build\vcvarsall.bat" # Configure the path to vcvarsall.bat if needed

$Files = @(
  [FileConfig]@{
    FileName       = "mdAddr.dll";
    ReleaseVersion = $RELEASE_VERSION;
    OS             = "WINDOWS";
    Compiler       = "DLL";
    Architecture   = "64BIT";
    Type           = "BINARY";
  },
  [FileConfig]@{
    FileName       = "mdEnums.h";
    ReleaseVersion = $RELEASE_VERSION;
    OS             = "ANY";
    Compiler       = "C";
    Architecture   = "ANY";
    Type           = "INTERFACE";  
  },
  [FileConfig]@{
    FileName       = "mdAddr.h";
    ReleaseVersion = $RELEASE_VERSION;
    OS             = "ANY";
    Compiler       = "C";
    Architecture   = "ANY";
    Type           = "INTERFACE";
  },
  [FileConfig]@{
    FileName       = "mdAddr.lib";
    ReleaseVersion = $RELEASE_VERSION;
    OS             = "WINDOWS";
    Compiler       = "C";
    Architecture   = "64BIT";
    Type           = "INTERFACE";
  },
  [FileConfig]@{
    FileName       = "mdAddrJavaWrapper.cpp";
    ReleaseVersion = $RELEASE_VERSION;
    OS             = "ANY";
    Compiler       = "JAVA";
    Architecture   = "ANY";
    Type           = "INTERFACE";
  },
  [FileConfig]@{
    FileName       = "mdAddr_JavaCode.zip";
    ReleaseVersion = $RELEASE_VERSION;
    OS             = "ANY";
    Compiler       = "JAVA";
    Architecture   = "ANY";
    Type           = "INTERFACE";
  }
)

###################### Functions ######################

# This function will download all the files needed to compile the wrapper
function DownloadFiles() {
  Write-Host "MELISSA UPDATER IS DOWNLOADING FILE(s)..."
  $FileProg = 0
  foreach ($File in $Files) {
    Write-Progress -Activity "Downloading FILE(s)" -Status "$([math]::round($FileProg / $Files.Count * 100, 2))% Complete:"  -PercentComplete ($FileProg / $Files.Count * 100)

    .\MelissaUpdater\MelissaUpdater.exe file --filename $File.FileName --release_version $File.ReleaseVersion --license $LICENSE --os $File.OS --compiler $File.Compiler --architecture $File.Architecture --type $File.Type --target_directory $CurrentPath
    
    if (($?) -eq $False) {
        Write-Host "`nCannot run Melissa Updater. Please check your license string!"
        Exit
    }

    # Check for the zip folder and extract from the zip folder if it was downloaded
    if ($File.FileName -eq "mdAddr_JavaCode.zip") {
      if (!(Test-Path ("$CurrentPath\mdAddr_JavaCode.zip"))) {
        Write-Host "mdAddr_JavaCode.zip not found." 
        
        Write-Host "`nAborting program, see above.  Press any button to exit."
        $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
        exit
      }
      else {
        if (!(Test-Path ("$CurrentPath/com"))) {
        Expand-Archive -Path "$CurrentPath\mdAddr_JavaCode.zip" -DestinationPath $CurrentPath
        }
        else {
          # Remove the com folder before extracting
          Remove-Item -Path "$CurrentPath/com" -Recurse -Force

          Expand-Archive -Path "$CurrentPath\mdAddr_JavaCode.zip" -DestinationPath $CurrentPath
        }
      }
    }
  }
      
  Remove-Item *.hash
    
  Write-Host "Melissa Updater finished downloading file(s)!"
  $FileProg++
}

# This function will check if the files exist before trying to compile the wrapper
function CheckFiles() {
  Write-Host "`nDouble checking file(s) were downloaded...`n"
  $FileMissing = $false 
  if (!(Test-Path ("mdAddr.dll"))) {
    Write-Host "mdAddr.dll not found." 
    $FileMissing = $true
  }
  if (!(Test-Path ("mdEnums.h"))) {
    Write-Host "mdEnums.h not found." 
    $FileMissing = $true
  }
  if (!(Test-Path ("mdAddr.h"))) {
    Write-Host "mdAddr.h not found." 
    $FileMissing = $true
  }
  if (!(Test-Path ("mdAddr.lib"))) {
    Write-Host "mdAddr.lib not found." 
    $FileMissing = $true
  }
  if ($FileMissing) {
    Write-Host "`nMissing the above data file(s).  Please check that your license string and directory are correct."
    return $false
  }
  else {
    return $true
  }
}

########################## Main ############################

Write-Host "`n======================= WELCOME TO MELISSA ADDRESS OBJECT JAVA WRAPPER =======================`n"

# Get license (either from parameters or user input)
if ([string]::IsNullOrEmpty($license)) {
  $License = Read-Host "Please enter your license string"
}

# Check for license from Environment Variables
if ([string]::IsNullOrEmpty($License)) {
  $License = $env:MD_LICENSE
}

if ([string]::IsNullOrEmpty($License)) {
  Write-Host "`nLicense String is invalid!"
  Exit
}

# Use MelissaUpdater to download file(s)
DownloadFiles -license $License

# Check if all file(s) have been downloaded. Exit script if missing
$FilesDownloaded = CheckFiles

if (!$FilesDownloaded) {
  Write-Host "`nAborting program, see above.  Press any button to exit."
  $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
  exit
}

Write-Host "All file(s) have been downloaded/updated! "

# Build the wrapper
Write-Host "`n========================================= BUILD WRAPPER ======================================`n"

# Compile DLL
cmd.exe /C """$CmdPath"" x86_x64 && Powershell -File Build.ps1" > $null

# Compile Jar
javac com\melissadata\*.java > $null

jar cvf mdAddr.jar com\melissadata\*.class > $null

if (Test-Path ("mdAddrJavaWrapper.dll")) {
  $filePath = Join-Path -Path (Split-Path -Parent $PSCommandPath) -ChildPath "mdAddrJavaWrapper.dll"

  Write-Host "`nmdAddrJavaWrapper.dll has been successfully generated at:`n$filePath"
}
else {
  Write-Host "`nError: was not able to create mdAddrJavaWrapper.dll"
}

if (Test-Path ("mdAddr.jar")) {
  $filePath = Join-Path -Path (Split-Path -Parent $PSCommandPath) -ChildPath "mdAddr.jar"

  Write-Host "`nmdAddr.jar has been successfully generated at:`n$filePath"
}
else {
  Write-Host "`nError: was not able to create mdAddr.jar"
}

Write-Host "`n=========================== THANK YOU FOR USING MELISSA JAVA WRAPPER =========================`n"

