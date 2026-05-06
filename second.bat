@echo off
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_212
set PATH=%JAVA_HOME%\bin;%PATH%
cd /d %~dp0
mvn tomcat7:run
