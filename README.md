# Melissa - Address Object Java Wrappers

## Purpose

This is the code for you to run Address Object in Java.
    
Please feel free to copy or embed this code to your own project. Happy coding!

For latest Melissa Address Object release notes, please visit: https://releasenotes.melissa.com/on-premise-api/address-object/

For further details, please visit: https://www.melissa.com/reference-guides/address-object

## Tested Environments
- Windows 10 64-bit Java 19, Microsoft Visual C++ 19.34, Powershell 5.1
- Ubuntu Linux 20.04.04 LTS 64-bit Java 20, gcc 9.4.0 
- Melissa Address Object for 2024-10
- Wrapper file(s) have not changed since 2024-02

## Getting Started
These instructions will get you a copy of the wrappers needed to run the Java Address Object on your local machine. 

### Download this project
```
git clone https://github.com/MelissaData/AddressObject-Java-Wrappers
cd AddressObject-Java-Wrappers
```

### Copy wrappers to your project folder
Import the `com` folder, and `mdAddrJavaWrapper.dll` (Windows) or `libmdAddrJavaWrapper.so` (Linux) to your project, and include the following line in your code to begin using the wrapper.

```
import com.melissadata.*;
```

If you would like to generate the wrappers yourself instead of using the provided wrappers proceed with the following instructions for either Windows or Linux.

## Windows

#### Install Java
Before starting, make sure that Java has been correctly installed on your machine. 

You can check that your environment is set up correctly by opening a command prompt window and typing the following:
`java --version`

If you see something like the following, that means that you have Java installed.

![alt text](/screenshots/java_version_windows.png)

If not, you can proceed to download Java here: 
https://www.oracle.com/java/technologies/downloads/

Once you have finished installations, you should be able to verify that Java has been correctly installed using the `java --version` command.

#### Set up Melissa Updater 
Melissa Updater is a CLI application allowing the user to update their Melissa applications/data. 

- Download Melissa Updater here: <https://releases.melissadata.net/Download/Library/WINDOWS/NET/ANY/latest/MelissaUpdater.exe>
- Create a folder within the cloned repo called `MelissaUpdater`.
- Put `MelissaUpdater.exe` in `MelissaUpdater` folder you just created.

#### Configure Scripts
If you want to generate `mdAddrJavaWrapper.dll`, you will execute the `BuildAddrJavaWrapper.ps1` script. This may require you to configure some path variables in `Build.ps1` and `BuildAddrJavaWrapper.ps1`.

BuildAddrJavaWrapper.ps1
- Check the `$CmdPath` variable and configure the path to `vcvarsall.bat` if needed

Build.ps1
- Check the `$JavaIncludeDirectory1` variable and configure the path to the `include` folder if needed
- Check the `$JavaIncludeDirectory2` variable and configure the path to the `win32` folder if needed

It is important to note that you must be able to initialize the Visual Studio Developer Command Prompt environment for `x86_x64` to generate `mdAddrJavaWrapper.dll`.
The Visual Studio Developer Command Prompt should already be downloaded if you have Microsoft Visual Studio installed.

To check if you are able to intialize the Visual Studio Developer Command Prompt for `x86_x64`, you can open the start menu and search for `x86_x64 Cross Tools Command Prompt for VS 2022`. If this program exists, then you may continue to the next steps.

Alternatively, you can check to see if the following filepath exists: `C:\Program Files\Microsoft Visual Studio\2022\Professional\VC\Auxiliary\Build\vcvarsall.bat` (with Visual Studio 2022 installed). If the filepath exists, then you may continue to the next steps.

#### Run Script
Parameter(s)
- -license (optional): a license string to run the powershell script

```
.\BuildAddrJavaWrapper.ps1
.\BuildAddrJavaWrapper.ps1 -license "<your_license_string>"
```

## Linux

#### Install Java 
You can check if Java is already installed on your environment by opening the linux terminal and using the following command:
`java --version`

If you see something like the following, that means that you have Java installed.

![alt text](/screenshots/java_version_linux.png)

If not, you can proceed with the following commands to install Java:
- `sudo apt update`
- `sudo apt install default-jdk`

Once you have finished installations, you should be able to verify that Java has been correctly installed using the `java --version` command.

#### Install GCC
You can check if GCC is already installed on your environment by opening the linux terminal and using the following command:
`gcc --version`

If you see something like the following, that means that you have GCC installed.

![alt text](/screenshots/gcc_version.png)

If not, you can proceed with the following commands to install GCC:
- `sudo apt update`
- `sudo apt install build-essential`

Once you have finished installations, you should be able to verify that GCC has been correctly installed using the `gcc --version` command.

#### Set up Melissa Updater 
Melissa Updater is a CLI application allowing the user to update their Melissa applications/data. 

- In the root directory of the project, create a folder called `MelissaUpdater` by using the command: 

  `mkdir MelissaUpdater`

- Enter the newly created folder using the command:

  `cd MelissaUpdater`

- Proceed to install the Melissa Updater using the curl command: 

  `curl -L -O https://releases.melissadata.net/Download/Library/LINUX/NET/ANY/latest/MelissaUpdater`

- After the Melissa Updater is installed, you will need to change the Melissa Updater to an executable using the command:

  `chmod +x MelissaUpdater`

- Now that the Melissa Updater is set up, you can now proceed to move back into the project folder by using the command:
  
   `cd ..`

#### Configure Script
If you want to generate `libmdAddrJavaWrapper.so`, you will execute the `BuildAddrJavaWrapper.sh` script. This may require you to configure some path variables in `BuildAddrJavaWrapper.sh`.

BuildAddrJavaWrapper.sh
- Check the `JavaIncludeDirectory1` variable and configure the path to the `include` folder if needed
- Check the `JavaIncludeDirectory2` variable and configure the path to the `win32` folder if needed

#### Run Script
Parameter(s)
- --license (optional): a license string to run the bash script

```
./BuildAddrJavaWrapper.sh
./BuildAddrJavaWrapper.sh --license "<your_license_string>"
```

----------------------------------------
## See also
- [Melissa - Address Object Windows Java](https://github.com/MelissaData/AddressObject-Java)
- [Melissa - Address Object Linux Java](https://github.com/MelissaData/AddressObject-Java-Linux)
    
## Contact Us
For free technical support, please call us at 800-MELISSA ext. 4
(800-635-4772 ext. 4) or email us at tech@melissa.com.

To purchase this product, contact Melissa sales department at
800-MELISSA ext. 3 (800-635-4772 ext. 3).
