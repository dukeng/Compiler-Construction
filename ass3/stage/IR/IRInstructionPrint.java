package IR;

import IR.IRType;

public class IRInstructionPrint extends IRInstruction{
  boolean isLn;
  IRType type;
  int printTemp;

  public IRInstructionPrint(boolean isLn, IRType type, int printTemp){
    this.isLn = isLn;
    this.type = type;
    this.printTemp = printTemp;
  }

  public String toString(){
    String repr = "  PRINT";
    if(isLn){
      repr += "LN";
    }
    repr += type.toString() + " T" + printTemp;
    return repr;
  }
}
