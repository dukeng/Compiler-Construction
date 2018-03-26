package IR;

import IR.IRInstruction;

public class IRInstructionLabel extends IRInstruction{
  public int number;

  public IRInstructionLabel(int n){
    number = n;
  }

  public String toString(){
    return "L" + number + ":";
  }
}
