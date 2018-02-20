package AST;

import Type.*;

import java.util.*;


public class TypeChecker implements Visitor{

	public int indentation = 0;
	public boolean DEBUG = false;
	private void debug(String toPrint){
		if (DEBUG){
			System.out.print(toPrint);
		}
	}
	private void print(String toPrint){
		System.out.print(toPrint  + "\n");
	}
	private String lineErr(int line, int pos){
		return " at line: " + line + " position: " + pos;
	}

    private void eprint(String toPrint){
        print(toPrint);
        System.exit(0);
    }
	private String indent(){
		String a = "";
		for(int k = 0; k < indentation*4; k ++){
			a += " ";
		}
		return a;
	}

	// private Set<String> defined_var;
	private HashMap<String, ArrayType> defined_var = new HashMap();
	
	private HashMap<String, ArrayType> defined_functions = new HashMap();

    public TypeChecker () {
       
    }
   
    public void visit(Program program){
        if (program.functionList.size() == 0){
            eprint("A program must contain at least one function"); // 2.1.1
        }
        //2.1.2
        Set<String> function_names = new HashSet<String>();
        
        Boolean mainExist = false;

        for(Function f : program.functionList){
            if (function_names.contains(f.functionDecl.identifier.name)){
                eprint("Two or more functions with the same name" + lineErr(f.functionDecl.line, f.functionDecl.pos));
			}
			function_names.add(f.functionDecl.identifier.name);			

			if (f.functionDecl.identifier.name.equals("main")){ // 2.1.2
				if (mainExist){
					eprint("Two or more main "+ lineErr(f.functionDecl.line, f.functionDecl.pos));
				}				
				mainExist = true;
                if (f.functionDecl.arrayType.subType instanceof VoidType &&
                    f.functionDecl.arrayType.compoundType == null &&
                    f.functionDecl.formalParameter.isEmpty()){
                }else{
					eprint("Main function either has non-voidType or has parameter"+ lineErr(f.functionDecl.line, f.functionDecl.pos));
				}
            }
        }

        if (!mainExist){
            eprint("No main function");
        }

    	for(Function f: program.functionList){
    		f.accept(this);
    		print("\n");
		}
		print("PASSED!");
    }

	public void visit (Function f){		
		f.functionDecl.accept(this);
		HashMap<String, ArrayType> defined_var = new HashMap();
		defined_functions.put(f.functionDecl.identifier.name, f.functionDecl.arrayType);
		//2.2.6	
		// add all parameters
		for(int i = 0; i < f.functionDecl.formalParameter.identifiers.size(); i ++){
			defined_var.put(f.functionDecl.formalParameter.identifiers.get(i).name, f.functionDecl.formalParameter.arrayTypes.get(i));
		}
		// add all defined variables
		// 2.2.2 no local var has the same naem		
        Set<String> var_names = new HashSet<String>();	
		for(VariableDeclaration varDecl : f.functionBody.variableDeclarationList.varDecList){
			if (var_names.contains(varDecl.identifier.name)){
				eprint("Duplicate name of variables" + lineErr(varDecl.line, varDecl.pos));
			}
			var_names.add(varDecl.identifier.name);
		}	
		for (VariableDeclaration varDecl : f.functionBody.variableDeclarationList.varDecList){
			if (defined_var.containsKey(varDecl.identifier.name)){
				eprint("Local variable may not hide the name of a parameter" + lineErr(varDecl.line, varDecl.pos));
			}
			defined_var.put(varDecl.identifier.name, varDecl.arrayType);
		}
		
		this.defined_var = defined_var;
		f.functionBody.accept(this);
		this.defined_var = null;
	}

	public void visit (FormalParameter f){
        Set<String> var_names = new HashSet<String>();
		//2.2.1 No two parameters of a function may have the same name 
		for(int i = 0; i < f.identifiers.size(); i ++){
			if (var_names.contains(f.identifiers.get(i).name)){
				eprint("Duplicate name of parameters" + lineErr(f.identifiers.get(i).line, f.identifiers.get(i).pos));
			}
			var_names.add(f.identifiers.get(i).name);
		}
		//2.2.3 No parameter may have a “type” of void.		

		for(int i = 0; i < f.arrayTypes.size(); i ++){
			if (f.arrayTypes.get(i).subType instanceof VoidType){
				eprint("Parameter with void type" + lineErr(f.arrayTypes.get(i).line, f.arrayTypes.get(i).pos));
			}
		}


		for(int i = 0; i < f.arrayTypes.size(); i++){
			f.arrayTypes.get(i).accept(this);
			f.identifiers.get(i).accept(this);
		
		}
	}

	public void visit (FunctionBody f){
		// var declaration
		for(VariableDeclaration varDecl : f.variableDeclarationList.varDecList){
			// 2.2.4 no local var has type void
			if (varDecl.arrayType.subType instanceof VoidType){
				eprint("Local variable with void type" + lineErr(varDecl.line, varDecl.pos));
			}			
		}

		for(VariableDeclaration varDecl : f.variableDeclarationList.varDecList){
			varDecl.accept(this);
		}
		
		// STATEMENT

		//2.2.7
		for(Statement statement : f.statementList.stateList){
			statement.accept(this);
		}		
	}

	public void visit (FunctionDeclaration f){		

		f.arrayType.accept(this);
		f.identifier.accept(this);		
		f.formalParameter.accept(this);
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
		// System.out.print(i.name);
	}

	// has subType: int/float/... and compoundType
	public void visit(ArrayType f){
		// String builder = f.subType.toString();
		// if (f.compoundType != null) builder += "[" + f.compoundType.value + "]";
		// print(builder);
		// print(" ");
	}


	public void visit(VariableDeclaration f){
		f.arrayType.accept(this);
		f.identifier.accept(this);
	}
	public Type visit(AddExpression f){
		Type t1 = f.e1.accept(this);
		// print ("+");
		Type t2 = f.e2.accept(this);
		if(t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType){
				
			}
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
			//2.2.7
			if (!this.defined_var.containsKey(f.identifier.name)){
				eprint("Local variable must be defined before used" + lineErr(f.identifier.line, f.identifier.pos));
			}
			f.identifier.accept(this);
		}
	}
	public void visit(ParenExpression f){
		print("(");
		f.e.accept(this);
		print(")");
	}
	public void visit(FunctionCall f){
		if (!defined_functions.containsKey(f.identifier.name)){
			eprint("Function must be defined before used" + lineErr(f.identifier.line, f.identifier.pos));

		}
		f.identifier.accept(this);
		for(int i = 0; i <  f.eList.expressionList.size(); i ++){
			f.eList.expressionList.get(i).accept(this);
		}
	}
	public void visit(ArrayReference f){
		//2.2.7		
		if (!this.defined_var.containsKey(f.identifier.name)){
			eprint("Local variable must be defined before used" + lineErr(f.identifier.line, f.identifier.pos));
		}
		// print("REACH");
		
		f.identifier.accept(this);
		f.e.accept(this);
	}


	public Type visit(VariableAssignment f){
		if (!this.defined_var.containsKey(f.id.name)){
			eprint("Local variable must be defined before used" + lineErr(f.id.line, f.id.pos));
		}		
		f.id.accept(this);
		Expression exp =  f.e.accept(this);

		ArrayType arrayType = this.defined_var.get(f.id.name);
		
		

	}
	public Type visit(ArrayAssignment f){
		if (!this.defined_var.containsKey(f.id.name)){
			eprint("Local variable must be defined before used" + lineErr(f.id.line, f.id.pos));
		}				
		f.id.accept(this);
		Expression exp = f.e1.accept(this);
		if (exp instanceof WrapperExpression &&
			exp.literal != null &&
			exp.literal instanceof IntegerLiteral){
				// checking for int in array reference
			}else{
				eprint("Array index expression is not an integer" + lineErr(f.id.line, f.id.pos));
			}
		exp = f.e2.accept(this);
	}

	public void visit(AssignmentStatement f){
		if (f.varAssignment != null){
			f.varAssignment.accept(this);
		}else if(f.arrayAssignment != null){
			f.arrayAssignment.accept(this);
		}
	}

	public void visit(IfStatement f){
		f.e.accept(this);
		
		f.bl1.accept(this);
		if (f.bl2 != null){
			f.bl2.accept(this);
		}
	}

	public void visit(Block f){
		for (Statement statement :f.statementList.stateList){
			statement.accept(this);
		}
	}

	public void visit(WhileStatement f){	
		f.e.accept(this);
		f.block.accept(this);

	}	

	public void visit(PrintStatement f){
		f.e.accept(this);
	}

	public void visit(PrintLnStatement f){
		f.e.accept(this);		
	}
	public void visit(ReturnStatement f){
		if (f.e != null){
			f.e.accept(this);
		}
	}		
}
