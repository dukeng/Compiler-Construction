package IR;

public class IRInstructionReturn extends IRInstruction{
    public int returnTemp;

    public IRInstructionReturn(int returnTemp){
        this.returnTemp = returnTemp;
    }

    public String toString(){
        String str = "  " + "RETURN";
        if(returnTemp >= 0){
            str += " " + "T" + returnTemp;
        }
        return str;
    }
}