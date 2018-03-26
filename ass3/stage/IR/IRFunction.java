package IR;
import java.util.List;
import IR.*;
import java.util.ArrayList;

public class IRFunction {
    public String name;
    public IRType returnType;    
    public ArrayList<IRInstruction> instructions = new ArrayList<IRInstruction>();
    public ArrayList<IRType> temps = new ArrayList<IRType>(); // temporary types in a function
    public ArrayList<Integer> parameters = new ArrayList<Integer>(); // hold the index of the parameters in the temps
    public int count;

    public IRFunction(String name, IRType returnType){
        this.returnType = returnType;
        this.name = name;
    }

    public int getNewTemp(IRType type){
        this.temps.add(type);
        return temps.size() - 1;
    }

    public void addParameter(int para){
        this.parameters.add(para);
    }

    public IRType getParameterTypeByParameterIndex(int num){
        int index = parameters.get(num);
        return temps.get(index);
    }

    public IRType getTempType(int idx){
        return this.temps.get(idx);
    }

    public void addInstruction(IRInstruction instruction){
        this.instructions.add(instruction);
    }

    public int getNewLabel(){
        // count += 1;
        return count ++;
    }

    public String toString(){
        String str = "FUNC " + name + " (";
        for(int i = 0; i < parameters.size(); i++){
            int idx = parameters.get(i);
            str += temps.get(i).toString();
        }
        str += ")" + returnType.toString();
        return str;
    }
}