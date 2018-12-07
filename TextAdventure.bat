@echo off
if not "%1" == "max" start /MAX cmd /c %0 max & exit/b

cd Code
REM Test this:
REM javac Game.java
java Game
