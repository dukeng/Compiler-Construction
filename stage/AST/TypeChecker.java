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
	
	private HashMap<String, FunctionDeclaration> defined_functions = new HashMap();
	private Type current_function_type;

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
			defined_functions.put(f.functionDecl.identifier.name, f.functionDecl);

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
	
	private Type getTypeFromArrayType(ArrayType f){
		ArrayType type = f;
		if (type.compoundType == null){
			Type returnType  = type.subType;
			return returnType;
		}
		return type;	
	}

	public void visit (Function f){		
		f.functionDecl.accept(this);
		HashMap<String, ArrayType> defined_var = new HashMap();
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
		this.current_function_type = getTypeFromArrayType(f.functionDecl.arrayType);
		f.functionBody.accept(this);
		this.defined_var = null;
		this.current_function_type = null;
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
	}

	public void visit(IntegerLiteral f){
	}

	public void visit(StringLiteral f){
	}

	public void visit(FloatLiteral f){
	}

	public void visit(BooleanLiteral f){
	}

	public void visit(CharacterLiteral f){
	}

	public void visit (Identifier i){
	}

	public void visit(ArrayType f){

	}

	public void visit(VariableDeclaration f){
		f.arrayType.accept(this);
		f.identifier.accept(this);
	}

	private boolean compareType(Type t1, Type t2){ // Assume no ArrayType is allowed here
		// ArrayType seems to be from functioncall
		Type subType1 = t1;
		Type subType2 = t2;
		if(subType1.getClass() != subType2.getClass()){
			return false;
		}
		return true;
	}

	public Type visit(AddExpression f){
		// print(f.e1.getClass().toString() + " Addexpression");
		// print(f.e2.getClass().toString() + " Addexpression");
		Type t1 = f.e1.accept(this);
		Type t2 = f.e2.accept(this);
		print(t1.getClass().toString() + " Type in Addexpression");
		print(t2.getClass().toString() + " Type in Addexpression");			
		if (!compareType(t1, t2)){
			eprint("Error:" + t1.line()+ ":Type is not compatible in AddExpression " + t1.getClass().toString() + " and "  +t2.getClass().toString());
		}
	
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Error:" + t1.line()+ ":Unallowed type in addExpression");
		}
		Set<Class> classes = new HashSet<>(Arrays.asList(FloatType.class, IntegerType.class, StringType.class, CharType.class));
		
		if (t1.getClass() != t2.getClass() ){
			eprint("Error:" + t1.line()+ ":Incompatible type in addExpression");
		}
		if (!classes.contains(t1.getClass())){
			eprint("Error:" + t1.line()+ ":Unallowed type in addExpression");

		}
		return t1;

	}
	public Type visit(SubtractExpression f){
		Type t1 = f.e1.accept(this);
		Type t2 = f.e2.accept(this);
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Incompatible type in addExpression");
		}
		Set<String> classes = new HashSet<>(Arrays.asList("FloatType", "IntegerType", "CharType"));
		
		if (t1.getClass() != t2.getClass() || !classes.contains(t1.getClass())){
			eprint("Imcompatile type in addExpression");
		}
		return t1;
	}	
	public Type visit(MultExpression f){
		Type t1 = f.e1.accept(this);
		Type t2 = f.e2.accept(this);
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Incompatible type in addExpression");
		}
		Set<String> classes = new HashSet<>(Arrays.asList("FloatType", "IntegerType"));
		
		if (t1.getClass() != t2.getClass() || !classes.contains(t1.getClass())){
			eprint("Imcompatile type in addExpression");
		}
		return t1;
	}
	public Type visit(LessThanExpression f){
		Type t1 = f.e1.accept(this);
		Type t2 = f.e2.accept(this);
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Incompatible type in addExpression");
		}
		Set<String> classes = new HashSet<>(Arrays.asList("FloatType", "IntegerType", "StringType", "CharType","BooleanType"));
		
		if (t1.getClass() != t2.getClass() || !classes.contains(t1.getClass())){
			eprint("Imcompatile type in addExpression");
		}
		BooleanType returnType = new BooleanType();
		// returnType.value = true;
		return returnType;
	}
	public Type visit(EqualityExpression f){
		Type t1 = f.e1.accept(this);
		Type t2 = f.e2.accept(this);
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Incompatible type in addExpression");
		}
		Set<String> classes = new HashSet<>(Arrays.asList("FloatType", "IntegerType", "StringType", "CharType", "BooleanType"));
		
		if (t1.getClass() != t2.getClass() || !classes.contains(t1.getClass())){
			eprint("Imcompatile type in addExpression");
		}
		BooleanType returnType = new BooleanType();
		// returnType.value = true;
		return returnType;
	}	

	public void visit(ExpressionStatement f){
		f.e.accept(this);
	}

	public Type visit(WrapperExpression f){
		// print("Wrapper Expression");
		if(f.literal != null){
			// print(f.literal.getClass().toString());
			f.literal.accept(this);
			Type returnType;
			if (f.literal instanceof BooleanLiteral){
				returnType = new BooleanType(((BooleanLiteral) f.literal).value );
				returnType.setLine(((BooleanLiteral) f.literal).line);
			}else if (f.literal instanceof StringLiteral){
				returnType = new StringType(((StringLiteral) f.literal).value);
				returnType.setLine(((StringLiteral) f.literal).line);

			}else if (f.literal instanceof IntegerLiteral){
				returnType = new IntegerType(((IntegerLiteral) f.literal).value);
				returnType.setLine(((IntegerLiteral) f.literal).line);
				
			}else if (f.literal instanceof FloatLiteral){
				returnType = new FloatType(((FloatLiteral) f.literal).value);
				returnType.setLine(((FloatLiteral) f.literal).line);
				
			}else if (f.literal instanceof CharacterLiteral){
				returnType = new CharType(((CharacterLiteral) f.literal).value);
				returnType.setLine(((CharacterLiteral) f.literal).line);
				
			}else{
				eprint("Error");
				returnType = null;
			}
			return returnType;
		}else if (f.identifier != null){
			//2.2.7
			if (!this.defined_var.containsKey(f.identifier.name)){
				eprint("Local variable must be defined before used" + lineErr(f.identifier.line, f.identifier.pos));
			}
			f.identifier.accept(this);
			Type returnType = getTypeFromArrayType(this.defined_var.get(f.identifier.name));
			returnType.setLine(f.identifier.line);		
			return returnType;
		}
		print("ERRROR");
		return null;
	}
	public Type visit(ParenExpression f){
		print("(");
		Type type = f.e.accept(this);
		print(")");
		return type;
	}
	//TODO: 
	public Type visit(FunctionCall f){
		if (!defined_functions.containsKey(f.identifier.name)){
			eprint("Function must be defined before used" + lineErr(f.identifier.line, f.identifier.pos));
		}
		f.identifier.accept(this);
		FunctionDeclaration funcDecl = defined_functions.get(f.identifier.name);
		if(funcDecl.formalParameter.arrayTypes.size() != f.eList.expressionList.size()){
			eprint("FormalParameter size is different in function call" + lineErr(f.identifier.line, f.identifier.pos));
		}
		for(int i = 0; i <  f.eList.expressionList.size(); i ++){
			//TODO: problem here, need to check for types of functioncall. I think it's done
			Type argType = f.eList.expressionList.get(i).accept(this);
			Type paramType  = getTypeFromArrayType(funcDecl.formalParameter.arrayTypes.get(i));
			if (paramType.getClass() != argType.getClass()){
				eprint("Type of formal parameters is different" + lineErr(f.identifier.line, f.identifier.pos));
			}
		}
		Type returnType = getTypeFromArrayType(funcDecl.arrayType);
		returnType.setLine(f.identifier.line);
		return returnType;
	}

	public Type visit(ArrayReference f){
		//2.2.7
		if (!this.defined_var.containsKey(f.identifier.name)){
			eprint("Local variable must be defined before used" + lineErr(f.identifier.line, f.identifier.pos));
		}		
		f.identifier.accept(this);
		Type referenceType = f.e.accept(this);
		if (referenceType == null || !(referenceType instanceof IntegerType)){
			eprint("ArrayReference index must be an integer"+ lineErr(f.identifier.line, f.identifier.pos));
		}
		return this.defined_var.get(f.identifier.name).subType; // returning the type of var
	}

	public void visit(AssignmentStatement f){
		if (f.varAssignment != null){
			f.varAssignment.accept(this);
		}else if(f.arrayAssignment != null){
			f.arrayAssignment.accept(this);
		}
	}
	public void visit(VariableAssignment f){
		if (!this.defined_var.containsKey(f.id.name)){
			eprint("Error:" + f.id.line + "Local variable must be defined before used");
		}		
		f.id.accept(this);
		// print("varassignment" +f.e.getClass().toString());
		Type type =  f.e.accept(this);
		if(type.getClass() != this.defined_var.get(f.id.name).subType.getClass()){
			eprint("Error:" + f.id.line + ":VariableAssignment is of incompatible type: " + type.getClass().toString());
		}		
	}
	public void visit(ArrayAssignment f){
		if (!this.defined_var.containsKey(f.id.name)){
			eprint("Local variable must be defined before used" + lineErr(f.id.line, f.id.pos));
		}
		if (this.defined_var.get(f.id.name).compoundType == null){
			eprint("Local variable is not an array" + lineErr(f.id.line, f.id.pos));
		}
		f.id.accept(this);
		Type type = f.e1.accept(this);
		if (!(type instanceof IntegerType )){
			eprint("Array index type is not an integer" + lineErr(f.id.line, f.id.pos));
		}
		type = f.e2.accept(this);
		if (type.getClass() != this.defined_var.get(f.id.name).subType.getClass()){
			eprint("ArrayAssignment is of incompatible type" + lineErr(f.id.line, f.id.pos));
		}
	}



	public void visit(IfStatement f){
		Type condition = f.e.accept(this);
		if (!(condition instanceof BooleanType)){
			eprint("Error:X:" + "If condition is not a boolean");
		}
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
		Type condition = f.e.accept(this);
		if (!(condition instanceof BooleanType)){
			eprint("Error:X:" + "If condition is not a boolean");
		}
		f.block.accept(this);

	}	

	public void visit(PrintStatement f){
		Type condition = f.e.accept(this);
		if (condition instanceof BooleanType ||
			condition instanceof IntegerType ||
			condition instanceof FloatType ||
			condition instanceof StringType ||
			condition instanceof CharType ){
		}else{
			eprint("Error:X:" + "If condition is not a boolean");			
		}
	}

	public void visit(PrintLnStatement f){
		Type condition = f.e.accept(this);
		if (condition instanceof BooleanType ||
			condition instanceof IntegerType ||
			condition instanceof FloatType ||
			condition instanceof StringType ||
			condition instanceof CharType ){
		}else{
			eprint("Error:X:" + "If condition is not a boolean");			
		}		
	}

	//TODO: maybe change the line to the line of the 'return' keyword instead. probably have to alter the grammar
	public void visit(ReturnStatement f){
		if (f.e != null){
			print(f.e.getClass().toString());
			Type condition = f.e.accept(this);
			if(current_function_type == null){
				eprint("Error:" + condition.line() + ":Return in a non-return function");
			}
			if(current_function_type.getClass() != condition.getClass()){
				eprint("Error:" + condition.line() + ":Incompatible Type in return statement" + current_function_type.getClass().toString() + "and" + condition.getClass().toString());				
			}
		}
	}		
}
