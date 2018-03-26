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
	private Set<Class> AddClasses = new HashSet<Class>(Arrays.asList(FloatType.class, IntegerType.class, StringType.class, CharType.class));
	private Set<Class> SubtractClasses = new HashSet<Class>(Arrays.asList(FloatType.class, IntegerType.class, CharType.class));
	private Set<Class> MultClasses = new HashSet<Class>(Arrays.asList(FloatType.class, IntegerType.class));
	private Set<Class> LessThanClasses = new HashSet<Class>(Arrays.asList(FloatType.class, IntegerType.class, StringType.class, CharType.class,BooleanType.class));
	private Set<Class> EqualityClasses = new HashSet<Class>(Arrays.asList(FloatType.class, IntegerType.class, StringType.class, CharType.class, BooleanType.class));
		

	private HashMap<String, ArrayType> defined_var = new HashMap();
	
	private HashMap<String, FunctionDeclaration> defined_functions = new HashMap();
	private Type current_function_type;

    public TypeChecker () {
       
    }
   
    public Object visit(Program program){
        if (program.functionList.size() == 0){
            eprint("A program must contain at least one function"); // 2.1.1
        }
        //2.1.2
        Set<String> function_names = new HashSet<String>();
        
		Boolean mainExist = false;

        for(Function f : program.functionList){
            if (function_names.contains(f.functionDecl.identifier.name)){
                eprint("Error:" + f.functionDecl.line +":Two or more functions with the same name at " + f.functionDecl.pos);
			}
			function_names.add(f.functionDecl.identifier.name);			
			defined_functions.put(f.functionDecl.identifier.name, f.functionDecl);

			if (f.functionDecl.identifier.name.equals("main")){ // 2.1.2
				if (mainExist){
					eprint("Error:" + f.functionDecl.line + ":Two or more main at "+  f.functionDecl.pos);
				}				
				mainExist = true;
                if (f.functionDecl.arrayType.subType instanceof VoidType &&
                    f.functionDecl.arrayType.compoundType == null &&
                    f.functionDecl.formalParameter.isEmpty()){
                }else{
					eprint("Error:" + f.functionDecl.line + ":Main function either has non-voidType or has parameter at "+ f.functionDecl.pos);
				}
            }
        }

        if (!mainExist){
            eprint("No main function");
        }

    	for(Function f: program.functionList){
    		f.accept(this);
		}
		print("PASSED!");
		return null;
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
				eprint("Error:" + varDecl.line + ":Duplicate name of variables at " + varDecl.pos);
			}
			var_names.add(varDecl.identifier.name);
		}	
		for (VariableDeclaration varDecl : f.functionBody.variableDeclarationList.varDecList){
			if (defined_var.containsKey(varDecl.identifier.name)){
				eprint("Error:" + varDecl.line + ":Local variable may not hide the name of a parameter at " +  varDecl.pos);
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
				eprint("Error:" + f.identifiers.get(i).line + ":Duplicate name of parameters at " +f.identifiers.get(i).pos);
			}
			var_names.add(f.identifiers.get(i).name);
		}
		//2.2.3 No parameter may have a “type” of void.		

		for(int i = 0; i < f.arrayTypes.size(); i ++){
			if (f.arrayTypes.get(i).subType instanceof VoidType){
				eprint("Error:"+ f.arrayTypes.get(i).line + "Parameter with void type" + f.arrayTypes.get(i).pos);
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
				eprint("Error:" + varDecl.line + ":Local variable with void type at pos " + varDecl.pos);
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

	public Object visit(Type f){
		return null;
	}

	public Object visit(IntegerLiteral f){
		return null;
	}

	public Object visit(StringLiteral f){
		return null;
	}

	public Object visit(FloatLiteral f){
		return null;
	}

	public Object visit(BooleanLiteral f){
		return null;
	}

	public Object visit(CharacterLiteral f){
		return null;
	}

	public Object visit (Identifier i){
		return i;
	}

	public Object visit(ArrayType f){
		return null;

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
		String typeExpression = "AddExpression";
		Type t1 = (Type) f.e1.accept(this);
		Type t2 = (Type) f.e2.accept(this);
		debug(t1.getClass().toString() + " Type in " + typeExpression);
		debug(t2.getClass().toString() + " Type in " + typeExpression);			
		if (!compareType(t1, t2)){
			eprint("Error:" + t1.line()+ ":Type is not compatible in "   + typeExpression  + " "+ t1.getClass().toString() + " and "  +t2.getClass().toString());
		}
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);
		}
		if (t1.getClass() != t2.getClass() ){
			eprint("Error:" + t1.line()+ ":Incompatible type in " + typeExpression);
		}
		if (!AddClasses.contains(t1.getClass())){
			eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);

		}
		return t1;
	}
	public Type visit(SubtractExpression f){
		String typeExpression = "SubtractExpression";
		Type t1 =(Type)  f.e1.accept(this);
		Type t2 = (Type) f.e2.accept(this);
		debug(t1.getClass().toString() + " Type in " + typeExpression);
		debug(t2.getClass().toString() + " Type in " + typeExpression);			
		if (!compareType(t1, t2)){
			eprint("Error:" + t1.line()+ ":Type is not compatible in "   + typeExpression + " "+ t1.getClass().toString() + " and "  +t2.getClass().toString());
		}
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);
		}
		if (t1.getClass() != t2.getClass() ){
			eprint("Error:" + t1.line()+ ":Incompatible type in " + typeExpression);
		}
		if (!SubtractClasses.contains(t1.getClass())){
			eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);

		}
		return t1;
	}	
	public Type visit(MultExpression f){
		String typeExpression = "MultExpression";
		Type t1 = (Type) f.e1.accept(this);
		Type t2 = (Type) f.e2.accept(this);
		debug(t1.getClass().toString() + " Type in " + typeExpression);
		debug(t2.getClass().toString() + " Type in " + typeExpression);			
		if (!compareType(t1, t2)){
			eprint("Error:" + t1.line()+ ":Type is not compatible in "   + typeExpression + " "+ t1.getClass().toString() + " and "  +t2.getClass().toString());
		}
		if(	t1 instanceof ArrayType || t1 instanceof VoidType || t1 instanceof BooleanType ||
			t2 instanceof ArrayType || t2 instanceof VoidType || t2 instanceof BooleanType ){
				eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);
		}
		if (t1.getClass() != t2.getClass() ){
			eprint("Error:" + t1.line()+ ":Incompatible type in " + typeExpression);
		}
		if (!MultClasses.contains(t1.getClass())){
			eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);

		}
		return t1;
	}
	public Type visit(LessThanExpression f){
		String typeExpression = "LessThanExpression";
		Type t1 = (Type) f.e1.accept(this);
		Type t2 = (Type) f.e2.accept(this);
		debug(t1.getClass().toString() + " Type in " + typeExpression);
		debug(t2.getClass().toString() + " Type in " + typeExpression);			
		if (!compareType(t1, t2)){
			eprint("Error:" + t1.line()+ ":Type is not compatible in "   + typeExpression + " "+ t1.getClass().toString() + " and "  +t2.getClass().toString());
		}
		if(	t1 instanceof ArrayType || t1 instanceof VoidType ||
			t2 instanceof ArrayType || t2 instanceof VoidType ){
				eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);
		}
		if (t1.getClass() != t2.getClass() ){
			eprint("Error:" + t1.line()+ ":Incompatible type in " + typeExpression);
		}
		if (!LessThanClasses.contains(t1.getClass())){
			eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);

		}
		BooleanType returnType = new BooleanType();
		returnType.line = t1.line();
		// returnType.pos = t1.pos();
		return returnType;		
	}
	public Type visit(EqualityExpression f){
		String typeExpression = "EqualityExpression";
		Type t1 = (Type) f.e1.accept(this);
		Type t2 = (Type) f.e2.accept(this);
		debug(t1.getClass().toString() + " Type in " + typeExpression);
		debug(t2.getClass().toString() + " Type in " + typeExpression);			
		if (!compareType(t1, t2)){
			eprint("Error:" + t1.line()+ ":Type is not compatible in "   + typeExpression + " "+ t1.getClass().toString() + " and "  +t2.getClass().toString());
		}
		if(	 t1 instanceof VoidType ||
			 t2 instanceof VoidType ){
				eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);
		}
		if (t1.getClass() != t2.getClass() ){
			eprint("Error:" + t1.line()+ ":Incompatible type in " + typeExpression);
		}
		if (!EqualityClasses.contains(t1.getClass())){
			eprint("Error:" + t1.line()+ ":Unallowed type in " + typeExpression);
		}
		// else if(t1.getClass() == ArrayType.class){
		// 	if (((ArrayType)t1).compoundType.value != ((ArrayType)t2).compoundType.value ){
		// 		eprint("Error:" + t1.line() + ":Incompatible array length to compare " + ((ArrayType)t1).compoundType.value + " and " + ((ArrayType)t2).compoundType.value);
		// 	}
		// }
		BooleanType returnType = new BooleanType();
		returnType.line = t1.line();
		return returnType;
	}	

	public Object visit(ExpressionStatement f){
		f.e.accept(this);
		return null;
	}

	public Type visit(WrapperExpression f){
		if(f.literal != null){
			// print(f.literal.getClass().toString());
			f.literal.accept(this);
			Type returnType;
			if (f.literal instanceof BooleanLiteral){
				returnType = new BooleanType(((BooleanLiteral) f.literal).value );
				returnType.setLine(((BooleanLiteral) f.literal).line);
				returnType.setPos(((BooleanLiteral) f.literal).pos);
				
			}else if (f.literal instanceof StringLiteral){
				returnType = new StringType(((StringLiteral) f.literal).value);
				returnType.setLine(((StringLiteral) f.literal).line);
				returnType.setPos(((StringLiteral) f.literal).pos);

			}else if (f.literal instanceof IntegerLiteral){
				returnType = new IntegerType(((IntegerLiteral) f.literal).value);
				returnType.setLine(((IntegerLiteral) f.literal).line);
				returnType.setPos(((IntegerLiteral) f.literal).pos);
				
			}else if (f.literal instanceof FloatLiteral){
				returnType = new FloatType(((FloatLiteral) f.literal).value);
				returnType.setLine(((FloatLiteral) f.literal).line);
				returnType.setPos(((FloatLiteral) f.literal).pos);
				
			}else if (f.literal instanceof CharacterLiteral){
				returnType = new CharType(((CharacterLiteral) f.literal).value);
				returnType.setLine(((CharacterLiteral) f.literal).line);
				returnType.setPos(((CharacterLiteral) f.literal).pos);
				
			}else{
				eprint("Error");
				returnType = null;
			}
			return returnType;
		}else if (f.identifier != null){
			//2.2.7
			if (!this.defined_var.containsKey(f.identifier.name)){
				eprint("Error:"+ f.identifier.line +   ":Local variable must be defined before used at position: " + f.identifier.pos);
			}
			f.identifier.accept(this);
			Type returnType = getTypeFromArrayType(this.defined_var.get(f.identifier.name));
			returnType.setLine(f.identifier.line);
			returnType.setPos(f.identifier.pos);		
			return returnType;
		}
		print("ERRROR");
		return null;
	}
	public Type visit(ParenExpression f){
		Type type = (Type) f.e.accept(this);
		return type;
	}

	public Type visit(FunctionCall f){
		if (!defined_functions.containsKey(f.identifier.name)){
			eprint("Error:" + f.identifier.line + ":Function must be defined before used at " + f.identifier.pos);
		}
		f.identifier.accept(this);
		FunctionDeclaration funcDecl = defined_functions.get(f.identifier.name);
		if(funcDecl.formalParameter.arrayTypes.size() != f.eList.expressionList.size()){
			eprint("Error:" + f.identifier.line + ":argument size is different in function call at position " + f.identifier.pos);
		}
		for(int i = 0; i <  f.eList.expressionList.size(); i ++){
			//TODO: problem here, need to check for types of functioncall. I think it's done
			Type argType = (Type) f.eList.expressionList.get(i).accept(this);
			Type paramType  = getTypeFromArrayType(funcDecl.formalParameter.arrayTypes.get(i));
			if (paramType.getClass() != argType.getClass()){
				eprint("Error:" + f.identifier.line +  ":Function Call: Type of argument at index " + String.valueOf(i) +  " is different, position: " + f.identifier.pos);
			}
		}
		Type returnType = getTypeFromArrayType(funcDecl.arrayType);
		returnType.setLine(f.identifier.line);
		returnType.setPos(f.identifier.pos);		
		
		return returnType;
	}

	public Type visit(ArrayReference f){
		//2.2.7
		if (!this.defined_var.containsKey(f.identifier.name)){
			eprint("Error:" + f.identifier.line + ":Local variable must be defined before used " + f.identifier.pos);
		}		
		f.identifier.accept(this);
		Type referenceType = (Type) f.e.accept(this);
		if (referenceType == null || !(referenceType instanceof IntegerType)){
			eprint("Error:" + f.identifier.line + ":Index must be an integer"+ f.identifier.pos);
		}
		return this.defined_var.get(f.identifier.name).subType; // returning the type of var
	}

	public Object visit(AssignmentStatement f){
		if (f.varAssignment != null){
			f.varAssignment.accept(this);
		}else if(f.arrayAssignment != null){
			f.arrayAssignment.accept(this);
		}
		return null;
	}
	public void visit(VariableAssignment f){
		if (!this.defined_var.containsKey(f.id.name)){
			eprint("Error:" + f.id.line + ":Local variable must be defined before used at pos " + f.id.pos);
		}		
		f.id.accept(this);
		Type type =  (Type) f.e.accept(this);
		ArrayType assignedType  = this.defined_var.get(f.id.name);

		if(type.getClass() == ArrayType.class){
			if ((assignedType).compoundType == null ){
				eprint("Error:" + f.id.line + ":RHS is arrayType but LHS is " +  assignedType.subType.getClass().toString()  + " at " + f.id.pos );	
			}
			if (
				((ArrayType)type).compoundType.value != assignedType.compoundType.value ||
				((ArrayType)type).subType.getClass() != assignedType.subType.getClass() ){
					eprint("Error:" + f.id.line + ":Variable ArrayAssignment is of incompatible type: " + " at pos " + + f.id.pos );
				}
		}else{
			if(type.getClass() != assignedType.subType.getClass()){
				eprint("Error:" + f.id.line + ":RHS and LHS is not compatible at pos "  + f.id.pos );							
			}					
		}
	}
	public void visit(ArrayAssignment f){
		if (!this.defined_var.containsKey(f.id.name)){
			eprint("Error:" + f.id.line + ":Local variable must be defined before used" + f.id.pos);
		}
		if (this.defined_var.get(f.id.name).compoundType == null){
			eprint("Error:" + f.id.line + ":Local variable is not an array" + f.id.pos);
		}
		f.id.accept(this);
		Type type = (Type) f.e1.accept(this);
		if (!(type instanceof IntegerType )){
			eprint("Error:" + f.id.line + ":Array index type is not an integer" + f.id.pos);
		}
		type = (Type) f.e2.accept(this);
		if (type.getClass() != this.defined_var.get(f.id.name).subType.getClass()){
			eprint("Error:" + f.id.line + ":ArrayAssignment is of incompatible type" + f.id.pos);
		}
	}



	public Object visit(IfStatement f){
		Type condition = (Type) f.e.accept(this);
		if (!(condition instanceof BooleanType)){
			eprint("Error:" + condition.line() + ":If condition is not a boolean at position " + condition.pos());
		}
		f.bl1.accept(this);
		if (f.bl2 != null){
			f.bl2.accept(this);
		}
		return null;
	}

	public void visit(Block f){
		for (Statement statement :f.statementList.stateList){
			statement.accept(this);
		}
	}

	public Object visit(WhileStatement f){	
		Type condition = (Type) f.e.accept(this);
		if (!(condition instanceof BooleanType)){
			eprint("Error:" + condition.line() + ":While condition is not a boolean at pos " +  condition.pos());
		}
		f.block.accept(this);
		return null;
	}	

	public Object visit(PrintStatement f){
		Type condition = (Type) f.e.accept(this);
		if (condition instanceof BooleanType ||
			condition instanceof IntegerType ||
			condition instanceof FloatType ||
			condition instanceof StringType ||
			condition instanceof CharType ){
		}else{
			eprint("Error:" + condition.line() + ":Print argument is not an accepted type at pos " + condition.pos() );			
		}
		return null;
		
	}

	public Object visit(PrintLnStatement f){
		Type condition = (Type) f.e.accept(this);
		if (condition instanceof BooleanType ||
			condition instanceof IntegerType ||
			condition instanceof FloatType ||
			condition instanceof StringType ||
			condition instanceof CharType ){
		}else{
			eprint("Error:" + condition.line() + ":PrintLn argument is not an accepted type at pos " + condition.pos() );			
		}		
		return null;
		
	}

	//TODO: maybe change the line to the line of the 'return' keyword instead. probably have to alter the grammar
	public Object visit(ReturnStatement f){
		if (f.e != null){
			// print(f.e.getClass().toString());
			Type condition = (Type) f.e.accept(this);
			if(current_function_type == null){
				eprint("Error:" + condition.line() + ":Return in a non-return function at pos " + condition.pos() );
			}
			if(current_function_type.getClass() != condition.getClass()){
				eprint("Error:" + condition.line() + ":Incompatible return type. Expected: " + current_function_type.getClass().toString() 
				+ " but got: " + condition.getClass().toString() + " at pos " + + condition.pos());				
			}
			if (current_function_type.getClass() == ArrayType.class){
				if( ((ArrayType)current_function_type).compoundType.value != ((ArrayType)condition).compoundType.value){
					eprint("Error:" + condition.line() + ":Length of array in return statement does not match: " 
					+ String.valueOf(((ArrayType)current_function_type).compoundType.value) + " and " 
					+ String.valueOf(((ArrayType)condition).compoundType.value) + " at pos " + + condition.pos() );
				}
			}
		}
		return null;
		
	}
}
