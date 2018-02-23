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
	rm ./AST/*.class
	rm ./Type/*.class
accept:
	java Compiler tests/a2.ul
	java Compiler tests/statement.ul
	java Compiler tests/functions.ul
	java Compiler tests/expression.ul
	java Compiler tests/assignment.ul
	
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
m:
	./runall.sh

r:
	
	java Compiler tests/no_func.ul
	java Compiler tests/two_main.ul
	java Compiler tests/no_main.ul
	java Compiler tests/same_func_name.ul
	java Compiler tests/main_with_param.ul
	java Compiler tests/main_with_non_voidtype.ul
i:	
	cat tests/a2.ul
e:
	vim tests/a2.ul
ii:
	cat tests/a22.ul

ee:
	vim tests/a22.ul

aa:
	java Compiler tests/a22.ul


