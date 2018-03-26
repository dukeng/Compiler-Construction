package AST;
// import Semantic.*;
import Type.*;
import IR.*;
import IR.IRInstructionAssignment.BinaryTypeOp;
import IR.IRInstructionAssignment.UnaryTypeOp;
import IR.IRType.InternalType;

import java.util.Map;

import AST.EqualityExpression;
import AST.Function;
import AST.SubtractExpression;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;




public class IRVisitor implements Visitor {
    HashMap<String, Integer> temporariesMap;
    IR ir;

    String path;

    private void eprint(String str){
        print(str);
        System.exit(-1);
    }

    private void print(String str){
        System.out.println(str);
    }

    public IRVisitor(String path){
        this.path = path;
    }
    
    public Object visit(Program p){
        ir = new IR("");
        for(int i = 0; i < p.size(); i++){
            p.elementAt(i).accept(this);
        }
        return ir;
    }
    public void visit(Function f){
        temporariesMap = new HashMap<String, Integer> (); // init anew temp map for each function cuz there's no globalscope
        f.functionDecl.accept(this);
        f.functionBody.accept(this);

        if( (IRType.convertToIRType(f.functionDecl.arrayType)).classType == IRType.InternalType.VOID){
            IRInstructionReturn returnInstruction = new IRInstructionReturn(-1);
            ir.currentFunctionAddInstruction(returnInstruction);
          }        
    }

    public void visit(FunctionDeclaration f){
        IRType returnType = IRType.convertToIRType((Type)f.arrayType.accept(this));
        ir.addNewFunction(f.identifier.name, returnType );
        f.formalParameter.accept(this);
    }

    public void visit (FormalParameter f){
        for(int i = 0; i < f.arrayTypes.size(); i ++){
            IRType paramType = IRType.convertToIRType( (Type) f.arrayTypes.get(i).accept(this) );
            int tempNum = ir.addParamToCurrentFunction(paramType);
            // save in map
            temporariesMap.put(f.identifiers.get(i).name, tempNum);

        }
    }

    public void visit (FunctionBody f){
        for(VariableDeclaration vd : f.variableDeclarationList.varDecList){
            vd.accept(this);
        }
        for(Statement st : f.statementList.stateList){
            st.accept(this);
        }
    }

    public void visit(VariableDeclaration f){
        IRType varType = IRType.convertToIRType((Type)f.arrayType.accept(this));
        print("VarDec: " + varType.toString() + ((Type)f.arrayType.accept(this)));
        int tempNum = ir.currentFunctionCreateNewTemporary(varType);
        temporariesMap.put(f.identifier.name, tempNum);
        //TODO: ArrayType
        if(f.arrayType.isArray()){
            IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
            // print("VarDecl");
            IRType realType = IRType.convertToIRType(f.arrayType.subType);
            IRInstruction instruction = instructionAssignment.arrayInitAssignment(tempNum,realType , f.arrayType.compoundType.value);
            ir.currentFunctionAddInstruction(instruction);
        }
    }

	public Object visit (ArrayType a){
        return a;
    }

	public void visit (Block b){
        for (Statement statement : b.statementList.stateList){
			statement.accept(this);
		}
    }

	public Object visit (ExpressionStatement e){
        e.e.accept(this);
        return null;
        
    }
	public Object visit (FunctionCall f){
        IRFunction irFunctionBeingCalled = ir.getIRFunctionByName(f.identifier.name); // IRFunction being called
        ArrayList<Integer> argumentTempList = new ArrayList<>();

        for(int i = 0; i < f.eList.expressionList.size(); i ++){
            Integer argumentTemp = (Integer) f.eList.expressionList.get(i).accept(this); // tempNum of argument
            IRType argumentType = ir.currentFunctionGetTempType(argumentTemp); // Type of argument
            IRType paramType = irFunctionBeingCalled.getParameterTypeByParameterIndex(i); // Type of parameter
            argumentTempList.add(argumentTemp);
        }

        IRType returnType = irFunctionBeingCalled.returnType;

        int assignedOperand = -1;
        IRInstructionCall instructionCall;
        if(returnType.classType == IRType.InternalType.VOID){
            instructionCall = new IRInstructionCall(f.identifier.name, argumentTempList);
        }else{
            assignedOperand = ir.currentFunctionCreateNewTemporary(returnType);
            instructionCall = new IRInstructionCall(f.identifier.name, argumentTempList, assignedOperand );
        }
        ir.currentFunctionAddInstruction(instructionCall);
        
        return assignedOperand;
    }

    // reference on right hand side
	public Object visit (ArrayReference f){
        int arrayTemp = temporariesMap.get(f.identifier.name);
        IRType type = ir.currentFunctionGetTempType(arrayTemp);
        type.size = 0; // turn this into a single type. this is sorta a hack
        int arrayIndex = (Integer) f.e.accept(this);

        int newResultTemp = ir.currentFunctionCreateNewTemporary(type);
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.arrayReferenceAssignmnent(newResultTemp, arrayTemp, arrayIndex);
        ir.currentFunctionAddInstruction(instructionAssignment);
        return newResultTemp;
    }

	public Object visit (Identifier i){
        return temporariesMap.get(i.name);
        
    }
	public Object visit (IfStatement i){
        int conditionalTemp = (int) i.e.accept(this);
        IRType type = new IRType(IRType.InternalType.BOOLEAN, 0);
        int leftSideTemp = ir.currentFunctionCreateNewTemporary(type);
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.unaryOpAssignment(UnaryTypeOp.INVERSION, type, leftSideTemp, conditionalTemp);
        ir.currentFunctionAddInstruction(instructionAssignment);

        int elseLabel = -1;
        if(i.bl2 != null){
            elseLabel = ir.currentFunctionGetLabel();
        }
        int afterTempLabel = ir.currentFunctionGetLabel();

        IRInstructionJump instructionJump;
        if (elseLabel >= 0){
            instructionJump = new IRInstructionJump(elseLabel, leftSideTemp);
        }else{
            instructionJump = new IRInstructionJump(afterTempLabel, leftSideTemp);
        }
        ir.currentFunctionAddInstruction(instructionJump);

        // Resolve inside block

        i.bl1.accept(this);
        

        // deal with else statement
        if(i.bl2 != null){
            IRInstructionJump instructionJump_afterElse = new IRInstructionJump(afterTempLabel,-1);
            ir.currentFunctionAddInstruction(instructionJump_afterElse);
            IRInstructionLabel instructionLabel_afterElse = new IRInstructionLabel(elseLabel);
            ir.currentFunctionAddInstruction(instructionLabel_afterElse);

            i.bl2.accept(this);
        }

        IRInstructionLabel instructionLabel = new IRInstructionLabel(afterTempLabel);
        ir.currentFunctionAddInstruction(instructionLabel);
        return null;
    }

	public Object visit (WhileStatement s){
        int startLabel = ir.currentFunctionGetLabel();
        int endLabel = ir.currentFunctionGetLabel();
        IRInstructionLabel instructionLabel = new IRInstructionLabel(startLabel);
        ir.currentFunctionAddInstruction(instructionLabel);
        print("WhileStatement: Start label L" + startLabel + " End Label L" + endLabel );

        int conditionalTemp = (Integer) s.e.accept(this);
        IRType type = new IRType(InternalType.BOOLEAN, 0);
        int boolTemp = ir.currentFunctionCreateNewTemporary(type);
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.unaryOpAssignment(UnaryTypeOp.INVERSION, type, boolTemp, conditionalTemp);
        ir.currentFunctionAddInstruction(instructionAssignment);
        
        IRInstructionJump instructionJump_toEnd = new IRInstructionJump(endLabel, boolTemp);
        ir.currentFunctionAddInstruction(instructionJump_toEnd);
        
        s.block.accept(this);

        IRInstructionJump instructionJump_toStart = new IRInstructionJump(startLabel, -1);
        ir.currentFunctionAddInstruction(instructionJump_toStart);
        
        IRInstructionLabel instructionJump_endLabel = new IRInstructionLabel(endLabel);
        ir.currentFunctionAddInstruction(instructionJump_endLabel);
        return null;
    }    

	public Object visit (IntegerLiteral i){
        int tempNum = ir.currentFunctionCreateNewTemporary(new IRType(IRType.InternalType.INT,0));
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.constantAssignment(tempNum, i);
        ir.currentFunctionAddInstruction(instructionAssignment);
        return tempNum;
    }

	public Object visit (StringLiteral s){   
        int tempNum = ir.currentFunctionCreateNewTemporary(new IRType(IRType.InternalType.STRING,0));
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.constantAssignment(tempNum, s);
        ir.currentFunctionAddInstruction(instructionAssignment);
        
        return tempNum;        
    }
	public Object visit (FloatLiteral f){
        int tempNum = ir.currentFunctionCreateNewTemporary(new IRType(IRType.InternalType.FLOAT,0));
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.constantAssignment(tempNum, f);
        ir.currentFunctionAddInstruction(instructionAssignment);
        
        return tempNum;                
    }	
	public Object visit (BooleanLiteral b){
        int tempNum = ir.currentFunctionCreateNewTemporary(new IRType(IRType.InternalType.BOOLEAN,0));
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.constantAssignment(tempNum, b);
        ir.currentFunctionAddInstruction(instructionAssignment);
        
        return tempNum;                
    }
	public Object visit (CharacterLiteral c){
        int tempNum = ir.currentFunctionCreateNewTemporary(new IRType(IRType.InternalType.CHAR,0));
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.constantAssignment(tempNum, c);
        ir.currentFunctionAddInstruction(instructionAssignment);
        
        return tempNum;                
    }

    public Object visitMutualBinaryTypeOp(BinaryTypeOp binaryTypeOp, int leftSideTemp, int rightSideTemp){

       // Assume that left and right have the same type, mutualType is the same
        
       IRType mutualType;
       if (binaryTypeOp != IRInstructionAssignment.BinaryTypeOp.EQUALS && binaryTypeOp != IRInstructionAssignment.BinaryTypeOp.SMALLER){
            mutualType = ir.currentFunctionGetTempType(leftSideTemp);
       }else{
           mutualType = new IRType(IRType.InternalType.BOOLEAN, 0);
       }
        int mutualTemp = ir.currentFunctionCreateNewTemporary(mutualType);
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.binaryOpAssignment(mutualTemp, binaryTypeOp , mutualType, leftSideTemp, rightSideTemp);
        ir.currentFunctionAddInstruction(instructionAssignment);
        return mutualTemp;        

    }

	public Object visit (AddExpression e){
        // get a temp from both side and create a new temp          
        int leftSideTemp = (Integer)e.e1.accept(this);
        int rightSideTemp = (Integer)e.e2.accept(this); // return the int value of the temp holding the value of the right side
        // Assume that left and right have the same type, mutualType is the same
        return visitMutualBinaryTypeOp(BinaryTypeOp.PLUS, leftSideTemp, rightSideTemp);
    }
	public Object visit (LessThanExpression e){
                // get a temp from both side and create a new temp          
                int leftSideTemp = (Integer)e.e1.accept(this);
                int rightSideTemp = (Integer)e.e2.accept(this); // return the int value of the temp holding the value of the right side
                // Assume that left and right have the same type, mutualType is the same
        return visitMutualBinaryTypeOp(BinaryTypeOp.SMALLER, leftSideTemp, rightSideTemp);
        
    }
	public Object visit (MultExpression e){
        // get a temp from both side and create a new temp          
        int leftSideTemp = (Integer)e.e1.accept(this);
        int rightSideTemp = (Integer)e.e2.accept(this); // return the int value of the temp holding the value of the right side
        // Assume that left and right have the same type, mutualType is the same
        return visitMutualBinaryTypeOp(BinaryTypeOp.MULTIPLY, leftSideTemp, rightSideTemp);

        
    }
	public Object visit (EqualityExpression e){
         // get a temp from both side and create a new temp          
         int leftSideTemp = (Integer)e.e1.accept(this);
         int rightSideTemp = (Integer)e.e2.accept(this); // return the int value of the temp holding the value of the right side
         // Assume that left and right have the same type, mutualType is the same
         return visitMutualBinaryTypeOp(BinaryTypeOp.EQUALS, leftSideTemp, rightSideTemp);
       
    }

    public Object visit (SubtractExpression e){
        // get a temp from both side and create a new temp          
        int leftSideTemp = (Integer)e.e1.accept(this);
        int rightSideTemp = (Integer)e.e2.accept(this); // return the int value of the temp holding the value of the right side
        // Assume that left and right have the same type, mutualType is the same
        return visitMutualBinaryTypeOp(BinaryTypeOp.MINUS, leftSideTemp, rightSideTemp);
        
    }
	public Object visit (WrapperExpression e){
        if(e.literal != null){ // it is a constant. return a consant
            return e.literal.accept(this);
        }else if (e.identifier != null){ // it is a reference, call map
            // return this.temporariesMap.get(e.identifier.name);
            return e.identifier.accept(this);
        }else{
            eprint("Error: neither literal nor identifier was set");
        }
        return null;
        
    }

	public Object visit (ParenExpression p){
        return p.e.accept(this);
    }

	
	public Object visit (PrintLnStatement s){
        int printTemp = (Integer) s.e.accept(this);
        IRType type = ir.currentFunctionGetTempType(printTemp);
        IRInstructionPrint instructionPrint = new IRInstructionPrint(true, type, printTemp);
        ir.currentFunctionAddInstruction(instructionPrint);
        return null;
    }
	public Object visit (PrintStatement s){
        int printTemp = (Integer) s.e.accept(this);
        IRType type = ir.currentFunctionGetTempType(printTemp);
        IRInstructionPrint instructionPrint = new IRInstructionPrint(false, type, printTemp);
        ir.currentFunctionAddInstruction(instructionPrint);
        return null;
    }	

	public Object visit (ReturnStatement s){
        int returnTemp = -1;
        if(s.e != null){
          returnTemp = (Integer)s.e.accept(this);
        }
        IRInstructionReturn returnInstruction = new IRInstructionReturn(returnTemp);
        ir.currentFunctionAddInstruction(returnInstruction);
        return null;
    }
	public Object visit (AssignmentStatement s){
        if (s.varAssignment != null){
            s.varAssignment.accept(this);
        }else if(s.arrayAssignment != null){
            s.arrayAssignment.accept(this);
        }else{
            eprint("Error in assignmnentStatement");
        }
        return s;
        
    }
    public void visit (VariableAssignment s){
        int leftSideTemp = temporariesMap.get(s.id.name);
        int rightSideTemp = (Integer)s.e.accept(this); // return the int value of the temp holding the value of the right side
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.opAssignment(leftSideTemp, rightSideTemp);
        ir.currentFunctionAddInstruction(instructionAssignment);
        return;
    }       

    public void visit (ArrayAssignment s){
        int leftSideTemp = temporariesMap.get(s.id.name);
        int rightSideTemp = (Integer)s.e2.accept(this); // return the int value of the temp holding the value of the right side. Need to cast though
        int array_index = (Integer)s.e1.accept(this);
        IRInstructionAssignment instructionAssignment = new IRInstructionAssignment();
        instructionAssignment.arrayAssignment(leftSideTemp, array_index, rightSideTemp);
        ir.currentFunctionAddInstruction(instructionAssignment);
        return;        
    }
        
	public Object visit (Type t){
        return t;
    }
	





}