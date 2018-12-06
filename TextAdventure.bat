@echo off
if not "%1" == "max" start /MAX cmd /c %0 max & exit/b

cd Code
java.exe Game
