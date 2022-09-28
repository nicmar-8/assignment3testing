@echo off
@REM set JDK_HOME=c:\PROGRA~1\Java\jdk1.8.0_45
set JDK_HOME="C:\Program Files\Eclipse Adoptium\jdk-8.0.345.1-hotspot"
@echo "Compiling code ..."
@mkdir bin
%JDK_HOME%\bin\javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImpl.java
@echo "Compiling tests ..."
set JUNIT=lib\org.junit4-4.3.1.jar
%JDK_HOME%\bin\javac.exe -d bin -cp %JUNIT%;src src/ltu/PaymentTest.java