#
GNAME= ulNoActions
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC) 

compiler:
	javac *.java

clean:
	rm *.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens

a:
	java Compiler tests/a2.ul
reject:
	java Compiler tests/initial_reject.ul
	java Compiler tests/reject_1.ul
	java Compiler tests/reject_2.ul
	java Compiler tests/reject_3.ul	
	java Compiler tests/reject_4.ul
	java Compiler tests/reject_5.ul
	java Compiler tests/reject_6.ul
	java Compiler tests/reject_7.ul
	java Compiler tests/reject_8.ul

i:	
	cat tests/a2.ul
e:
	vim tests/a2.ul

