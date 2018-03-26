package IR;

import IR.IRInstruction;

public  class IRInstructionJump extends IRInstruction {

    int ifOpTemp;
    int gotoOpLabel;


    // pass -1 to ifOpTemp if it is optional. i.e: if it's just a jump instruction and not an if statement
    public IRInstructionJump(int gotoOpLabel, int ifOpTemp){
        this.ifOpTemp = ifOpTemp;
        this.gotoOpLabel = gotoOpLabel;
    }

    public String toString(){
        String str = "  ";
        if(this.ifOpTemp != -1){
            str += "IF T" + this.ifOpTemp + " ";
        }
        str += "GOTO L" + this.gotoOpLabel;
        return str;
    }
}