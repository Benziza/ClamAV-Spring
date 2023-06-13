# ClamAV-Spring

How to connect to the ClamAV service from Java and scan files.

## 1-ClamAV install on windows

ClamAV, short for Clam AntiVirus, is an open-source antivirus software designed to detect and remove various types of malware, including viruses, worms, trojans, and other malicious software. It is primarily developed for Unix-like operating systems, but it is also available for Windows and macOS.

<p align="center">
  <img src="https://www.clamav.net/assets/clamav-trademark.png" />
</p>

### 1-1-Download the ClamAV

You can download the latest stable version of ClamAV from the below link.
https://www.clamav.net/downloads

### 1-2-Configure the ClamAV

Once you have installed ClamAV, navigate to the installation folder and find for conf_examples folder. You can see the clamd.conf.sample file and freshclam.conf.sample config file inside the conf_examples folder. Then copy those two files to the installation directory. (eg: C:\Programes Files\ClamAV)

- Rename the clamd.conf.sample to clamd.conf
- Rename freshclam.conf.sample to freshclam.conf

#### 1-2-1-Modify clamd.conf

- Comment/Remove the word Example in line number 8.
- Remove comment of #LogFile "C:\Program Files\ClamAV\clamd.log" to enable the logging.
- Find for TCPSocket 3310 and make sure it is not commented out.
  Also, find for TCPAddr localhost and make sure it is not commented out.
- Save the file and exit.

#### 1-2-2-Modify freshclam.conf

- Comment/Remove the word Example in line number 8.
- Remove comment of #LogFile "C:\Program Files\ClamAV\clamd.log" to enable the logging.
- Remove comment of #UpdateLogFile "C:\Program Files\ClamAV\freshclam.log".log" to enable the logging.
- Save the file and exit.

### 1-3-Install ClamAV as a windows service

Open the Windows Command Prompt in Administrator Mode and navigate to the installation directory (eg: C:\ClamAV).
Run the following command to install as a service.
**clamd.exe --install**

### 1-4-Update the ClamAV database

Open the Windows Command Prompt in Administrator Mode and navigate to the installation directory (eg: C:\ClamAV).

Run the following command to update the ClamAV database.
**freshclam.exe**

### 1-5-Running the ClamAV service

- we will start the clamd as the desktop application. Therefore, open the command prompt, navigate into the installation folder and type : **clamd**

- Open the Windows Services (execute services.msc command in the run window to open the windows services) and start the ClamAV service,
  Service name: ClamAV ClamD

## 2-Virus Scanning in Java using ClamAV
