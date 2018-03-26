/*
 * Compiler.java
 *
 * A starting place for the unamed language compiler for CSC 435/535
 *
 */

import org.antlr.runtime.*;
import java.io.*;


import AST.*;
import IR.*;


public class Compiler {
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;

		if (args.length == 0 ) {
			System.out.println("Usage: Test filename.ul");
			return;
		}
		else {
			input = new ANTLRInputStream(new FileInputStream(args[0]));
		}

		// The name of the grammar here is "ulNoActions",
		// so ANTLR generates ulNoActionsLexer and ulNoActionsParser
		ulNoActionsLexer lexer = new ulNoActionsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulNoActionsParser parser = new ulNoActionsParser(tokens);

		try {
			Program program = parser.program();
			// PrintVisitor visitor = new PrintVisitor();
			// program.accept(visitor);
			TypeChecker typeChecker = new TypeChecker();
			program.accept(typeChecker);
			//TODO ADD CHECK after typechecker
			String filePath = new File(args[0]).getName();
			System.out.print("filePath: " + filePath + "\n");
			IRVisitor irVisitor = new IRVisitor(filePath);
			IR ir = (IR) program.accept(irVisitor);
			String path = "tests/valid/" + filePath + ".ir";
			ir.setName(path);
			ir.toFile(path);

		}
		catch (RecognitionException e )	{
			// A lexical or parsing error occured.
			// ANTLR will have already printed information on the
			// console due to code added to the grammar.  So there is
			// nothing to do here.
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
