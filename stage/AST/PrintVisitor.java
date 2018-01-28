package AST;

import Type.*;

public class PrintVisitor implements Visitor{

	public int indentation = 0;
	public boolean DEBUG = false;
	private void debug(String toPrint){
		if (DEBUG){
			System.out.print(toPrint);
		}
	}
	private void print(String toPrint){
		System.out.print(toPrint);
	}

	private String indent(){
		String a = "";
		for(int k = 0; k < indentation*4; k ++){
			a += " ";
		}
		return a;
	}

    public PrintVisitor () {
       
    }
   
    public void visit(Program program){
    	for(Function f: program.functionList){
    		f.accept(this);
    		print("\n");
    	}
    }

	public void visit (Function f){		
		f.functionDecl.accept(this);
		indentation += 1;
		f.functionBody.accept(this);
		indentation -= 1;
	}
	public void visit (FunctionBody f){
		// var declaration
		System.out.print("\n{\n");
		for(VariableDeclaration varDecl : f.variableDeclarationList.varDecList){
			System.out.print(indent());
			varDecl.accept(this);
			System.out.print(";\n");
		}
		for(Statement statement : f.statementList.stateList){
			print(indent());
			statement.accept(this);
			// System.out.print(statement instanceof IfStatement);
			// System.out.print(statement instanceof WhileStatement);
			if (!(statement instanceof IfStatement || statement instanceof WhileStatement)){
				print(";\n");
			}
		}		
		System.out.print("\n}\n");
	}

	public void visit (FunctionDeclaration f){
		
		f.arrayType.accept(this);
		f.identifier.accept(this);
		System.out.print(" ");
		f.formalParameter.accept(this);
	}

	public void visit(TypeNode f){
		print("TypeNode debug");
	}

	public void visit(Type f){
		System.out.print(f.toString());
	}

	public void visit(IntegerLiteral f){
		System.out.print(f.value);
	}

	public void visit(StringLiteral f){

		System.out.print("\"" + f.value + "\"");
	}

	public void visit(FloatLiteral f){
		System.out.print(f.value);
	}

	public void visit(BooleanLiteral f){
		System.out.print(f.value);
	}

	public void visit(CharacterLiteral f){
		System.out.print("\'" + f.value + "\'");
	}

	public void visit (Identifier i){
		System.out.print(i.name);
	}

	// has subType: int/float/... and compoundType
	public void visit(ArrayType f){
		String builder = f.subType.toString();
		if (f.compoundType != null) builder += "[" + f.compoundType.value + "]";
		print(builder);
		print(" ");
	}

	public void visit (FormalParameter f){
		System.out.print("(");
		for(int i = 0; i < f.arrayTypes.size(); i++){
			f.arrayTypes.get(i).accept(this);
			f.identifiers.get(i).accept(this);
			if(i != f.arrayTypes.size() -1 ){
				System.out.print(", ");
			}
		}
		System.out.print(")");
	}
	public void visit(VariableDeclaration f){
		
		f.arrayType.accept(this);
		f.identifier.accept(this);
		
	}
	public void visit(AddExpression f){
		f.e1.accept(this);
		print ("+");
		f.e2.accept(this);
	}
	public void visit(SubtractExpression f){
		f.e1.accept(this);
		print ("-");
		f.e2.accept(this);	
	}	
	public void visit(MultExpression f){
		f.e1.accept(this);
		print ("*");
		f.e2.accept(this);
	}
	public void visit(LessThanExpression f){
		f.e1.accept(this);
		print ("<");
		f.e2.accept(this);	
	}
	public void visit(EqualityExpression f){
		f.e1.accept(this);
		print ("==");
		f.e2.accept(this);
	}	

	public void visit(ExpressionStatement f){
		f.e.accept(this);
	}

	public void visit(WrapperExpression f){
		if(f.literal != null){
			f.literal.accept(this);
		}else if (f.identifier != null){
			f.identifier.accept(this);
		}
		
	}
	public void visit(ParenExpression f){
		print("(");
		f.e.accept(this);
		print(")");
	}
	public void visit(FunctionCall f){
		f.identifier.accept(this);
		print("(");
		for(int i = 0; i <  f.eList.expressionList.size(); i ++){
			f.eList.expressionList.get(i).accept(this);
			if(i != f.eList.expressionList.size() -1 ){
				print(",");
			}			
		}
		print(")");
	}
	public void visit(ArrayReference f){
		f.identifier.accept(this);
		print("[");
		f.e.accept(this);
		print("]");
	}


	public void visit(VariableAssignment f){
		f.id.accept(this);
		print("=");
		f.e.accept(this);
	}
	public void visit(ArrayAssignment f){
		f.id.accept(this);
		print("[");
		f.e1.accept(this);
		print("]");
		print("=");
		f.e2.accept(this);
	}

	public void visit(AssignmentStatement f){
		if (f.varAssignment != null){
			f.varAssignment.accept(this);
		}else if(f.arrayAssignment != null){
			f.arrayAssignment.accept(this);
		}
	}

	public void visit(IfStatement f){
		print("if");
		print(" (");
		f.e.accept(this);
		print(")");
		
		f.bl1.accept(this);
		if (f.bl2 != null){
			print(indent() + "else");
			f.bl2.accept(this);
		}
	}	

	public void visit(Block f){
		print("\n" + indent() + "{\n");
		indentation += 1;
		if (f.statementList.stateList.size() == 0){
			print("\n");
		}
		for (Statement statement :f.statementList.stateList){
			print(indent());
			statement.accept(this);
			if (!(statement instanceof IfStatement || statement instanceof WhileStatement)){
				print(";\n");
			}
		}
		indentation -= 1;
		print( indent() + "}\n");
	}

	public void visit(WhileStatement f){	
		print("while ");
		print("(");
		f.e.accept(this);
		print(")");
		f.block.accept(this);

	}	

	public void visit(PrintStatement f){
		print("print ");
		f.e.accept(this);
	}

	public void visit(PrintLnStatement f){
		print("printLn ");
		f.e.accept(this);		
	}
	public void visit(ReturnStatement f){
		print("return ");
		if (f.e != null){
			f.e.accept(this);
		}
	}		
}
