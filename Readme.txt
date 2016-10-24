This is a VMCS implementation of OODP_CA_PT05.

The following software packages are required:
1) JDK
2) Apache Ant

Perform the following steps to build and run the system.
1) Configure the paths for JAVA_HOME and ANT_HOME in setenv.bat.
2) Execute compile.bat to build the system and generate the documentation.
3) Execute run.bat to run the system.
4) If necessary, execute clean.bat to purge the class files and documentation.
5) Set desired database(MySQL or PostgreSQL or File) in "vmcs.properties".
6) Run vmcs.sql in MySQL to create database.