package IR;


import java.util.List;

import IR.IRFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.*;


public class IR{
    String name;
    private ArrayList<IRFunction> functions = new ArrayList<IRFunction>();
    private HashMap<String, Integer> functionsMap = new HashMap<String, Integer>();

    public IR(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public IRFunction getIRFunctionByName(String name){
        Integer idx = functionsMap.get(name);
        return functions.get(idx);
    }

    public void addNewFunction(String name, IRType type){
        functions.add(new IRFunction(name, type));
        functionsMap.put(name, functions.size() - 1);
    }

    public int addParamToCurrentFunction(IRType type){
        IRFunction f = functions.get(functions.size() - 1);
        int newTemp = f.getNewTemp(type);
        f.addParameter(newTemp);
        return newTemp;
    }
    public int currentFunctionCreateNewTemporary(IRType type){
        return functions.get(functions.size() - 1).getNewTemp(type);
    }

    public int currentFunctionGetLabel(){
        return functions.get(functions.size() - 1).getNewLabel();
    }

    public IRType currentFunctionGetTempType(int tempNum){
        return functions.get(functions.size() - 1).getTempType(tempNum);
    }

    public void currentFunctionAddInstruction(IRInstruction instruction){
        functions.get(functions.size() - 1).addInstruction(instruction);
    }

    public void toFile(String path){
        try{
            PrintWriter p = new PrintWriter(new FileWriter(path));
            p.println("PROG " + this.name);
            for(IRFunction f : this.functions){
                p.println(f);
                p.println("{");
                for(int i = 0; i < f.temps.size(); i++){
                    p.println("  TEMP " + i+ ":" + f.temps.get(i).toString() + ";");
                }
                for(int i = 0;i < f.instructions.size(); i++){
                    p.println(f.instructions.get(i).toString() + ";");
                }
                p.println("}");
            }
            p.flush();
        }catch(IOException e){
            System.out.println(e);
            System.exit(-1);
        }        
    }

}

