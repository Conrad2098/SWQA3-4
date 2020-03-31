JFLAGS = -g
JCC = javac

default: Assignment2.class

Assignment2.class: Assignment2.java
	$(JCC) $(JFLAGS) Assignment2.java

clean:
	$(RM) Assignment2.class