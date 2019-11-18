# Compile, Run, Clean

CC = javac12
J  = java12

# Default is running
r:
	cd Code && $(J) Game  

c:
	cd Code && $(CC) *.java

cr: c r

cl:
	rm Code/*.class
