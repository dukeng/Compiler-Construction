#
GNAME= ulNoActions
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC) 

compiler:
	javac *.java AST/*.java Type/*.java IR/*.java 

clean:
	rm *.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens
	rm ./AST/*.class
	rm ./Type/*.class
	rm ./IR/*.class
	rm -r ./tests/*.ir

codegen:
	/home/jcorless/csc435/codegen/codegen --file=$(file) $(to)

exec:
	java jasmin.Main $(file)

m:
	./runall.sh
run3:
	./runall3.sh

3:
	java Compiler tests/valid/a3.ul
3binary:
	java Compiler tests/valid/a3binary.ul
3e:
	vim tests/valid/a3.ul
on:
	java Compiler  tests/valid/$(file)

show:
	cat tests/valid/given/$(file)
	cat tests/valid/$(file).ir

3s:
	cat tests/valid/a3.ul
	cat tests/valid/a3.ul.ir
3binarys:
	cat tests/valid/a3binary.ul
	cat tests/valid/a3binary.ul.ir


