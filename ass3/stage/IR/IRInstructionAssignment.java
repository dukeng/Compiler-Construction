package IR;
import AST.*;
import IR.IRInstruction;
import IR.IRType;

import java.util.*;



public class IRInstructionAssignment extends IRInstruction{
    public static enum Type {
        BINARY_OP,
        UNARY_OP,
        ARRAY_TO_OP,
        OP_TO_ARRAY,
        OP_TO_OP,
        NEWARRAY,
        CONST_TO_OP
    }

    public enum UnaryTypeOp{
        CONVERT ("2"),
        NEGATION("-"),
        INVERSION("!");

        private static final HashMap<String, UnaryTypeOp> lookup = new HashMap<String, UnaryTypeOp>();
        
        static{
            for (UnaryTypeOp unaryTypeOp : UnaryTypeOp.values()){
              lookup.put(unaryTypeOp.toString(), unaryTypeOp);
            }
          }
        private final String opName;
      
        private UnaryTypeOp(String s){
            opName = s;
        }
    
        public String toString(){
            return this.opName;
        }
    
        public static UnaryTypeOp get(String val){
            return lookup.get(val);
        }        
    }

    public enum BinaryTypeOp{
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        // DIVIDE("/"),
        // REM("rem"),
        SMALLER("<"),
        // SMALLER_EQUALS("<="),
        EQUALS("==");
        // NOT_EQUALS("!="),
        // BIGGER_EQUALS(">="),
        // BIGGER(">");
    
        private final String opName;
        private static final Map<String, BinaryTypeOp>  lookup = new HashMap<String, BinaryTypeOp>();
    
        static{
          for (BinaryTypeOp bo : BinaryTypeOp.values()){
            lookup.put(bo.toString(), bo);
          }
        }
    
        private BinaryTypeOp(String s){
          opName = s;
        }
    
        public String toString(){
          return this.opName;
        }
    
        public static BinaryTypeOp get(String val){
          return lookup.get(val);
        }
      }
    
      public IRInstructionAssignment.Type type;
      public int leftTemp;
      public int rightTemp;
      public int indexTemp;
      public int size;
      public BinaryTypeOp binaryOp;
      public UnaryTypeOp unaryOp;
      public IRType opType;
      public IRType toType;
      public Literal constant;


      public IRInstructionAssignment(){
        
      }

      public IRInstructionAssignment arrayInitAssignment(int leftTemp, IRType type, int size){
        this.leftTemp = leftTemp;
        // this.indexTemp = idxTemp;
        this.type = IRInstructionAssignment.Type.NEWARRAY;
        this.size = size;
        this.opType = type;
        return this;
      }

      public IRInstructionAssignment constantAssignment(int leftTemp, Literal constant){
        this.leftTemp = leftTemp;
        this.constant = constant;
        this.type = IRInstructionAssignment.Type.CONST_TO_OP;
        return this;
      }

      public IRInstructionAssignment opAssignment(int leftTemp, int rightTemp){
        this.type = IRInstructionAssignment.Type.OP_TO_OP;
        this.leftTemp = leftTemp;
        this.rightTemp = rightTemp;
        return this;
      }
      public IRInstructionAssignment arrayAssignment(int leftTemp, int indexTemp, int rightTemp){
        this.type = IRInstructionAssignment.Type.OP_TO_ARRAY;
        this.leftTemp = leftTemp; // idx of the left side
        this.indexTemp = indexTemp; // idx of the array assigned to
        this.rightTemp = rightTemp; // idx of the right side value
        return this;
      }

      public IRInstructionAssignment binaryOpAssignment(int tempNum, BinaryTypeOp op_name,  IRType type, int leftTemp, int rightTemp ){
        this.indexTemp = tempNum; // the new result of the op
        this.type = IRInstructionAssignment.Type.BINARY_OP; // the type of the op
        this.binaryOp =  op_name; // the name of the binary operation
        this.leftTemp = leftTemp; // left side idx of the binary ops
        this.rightTemp = rightTemp; // right side idx of the binary ops
        this.opType = type;
        return this;
      }

      public IRInstructionAssignment unaryOpAssignment(UnaryTypeOp op_name, IRType type, int leftTemp, int rightTemp){
        this.type = IRInstructionAssignment.Type.UNARY_OP;
        this.leftTemp = leftTemp;
        this.rightTemp = rightTemp;
        this.unaryOp = op_name;
        this.opType = type;
        return this;
      }

      public IRInstructionAssignment arrayReferenceAssignmnent(int leftTemp, int rightTemp, int indexTemp){
        this.type = IRInstructionAssignment.Type.ARRAY_TO_OP;
        this.leftTemp = leftTemp;
        this.rightTemp = rightTemp;
        this.indexTemp = indexTemp;
        return this;
      }

    
      public String toString(){
        String str = "  ";
        switch(this.type){
        case OP_TO_OP:
          str += "T";
          str += this.leftTemp;
          str += " := ";
          str += "T";
          str += this.rightTemp;
          break;
        case CONST_TO_OP:
          str += "T";
          str += this.leftTemp;
          str += " := ";
          str += this.constant.getValue();
          break;
        case OP_TO_ARRAY:
          str += "T";
          str += this.leftTemp;
          str += "[T";
          str += this.indexTemp;
          str += "]";
          str += " := ";
          str += "T";
          str += this.rightTemp;
          break;
        case ARRAY_TO_OP:
          str += "T";
          str += this.leftTemp;
          str += " := ";
          str += "T" + this.rightTemp + "[";
          str += "T" + this.indexTemp + "]";
          break;
        case NEWARRAY:
          str += "T";
          str += this.leftTemp;
          str += " := NEWARRAY ";
          str += this.opType.toString();
          str += " ";
          str += size;
          break;
        case BINARY_OP:
          str += "T";
          str += this.indexTemp;
          str += " := T";
          str += this.leftTemp + " " + this.opType.toString() + this.binaryOp.toString() + " ";
          str += "T" + this.rightTemp;
          break;
        case UNARY_OP:
          if(unaryOp == UnaryTypeOp.CONVERT){
            str += "T" + this.leftTemp;
            str += " := " + this.opType.toString() + "2" + this.toType.toString() + " ";
            str += "T" + this.rightTemp;
          }
          else{
            str += "T";
            str += this.leftTemp;
            str += " := ";
            str += this.opType.toString() + this.unaryOp.toString() + " ";
            str += "T" + this.rightTemp;
          }
          break;
        }
        return str;
      }
}