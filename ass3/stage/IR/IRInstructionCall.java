package IR;

import java.util.ArrayList;

import IR.IRInstruction;

public  class IRInstructionCall extends IRInstruction {

    String callToName;
    Integer assignedOperand = -1;
    ArrayList<Integer> operands;

    public IRInstructionCall(String functionName, ArrayList<Integer> operands){
        this.callToName = functionName;
        this.operands = operands;
      }
    
      public IRInstructionCall(String functionName, ArrayList<Integer> operands, int assignedOperand){
        this.callToName = functionName;
        this.operands = operands;
        this.assignedOperand = assignedOperand;
      }
    
      public String toString(){
        String repr = "  ";
        if(assignedOperand >= 0){
          repr += "T" + assignedOperand + " := ";
        }
        repr += "CALL " + callToName + "(";

        if (operands.size() == 1){
            repr += "T" + operands.get(0);
        }else{
            for(Integer operand : operands){
                repr += "T" + operand + " ";
              }
        }

        repr += ")";
        return repr;
      }

}