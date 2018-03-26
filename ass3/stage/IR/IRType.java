package IR;


import Type.*;

public class IRType{

    public enum InternalType {
        STRING ("U"), 
        VOID ("V"),
        DOUBLE ("D"), 
        FLOAT ("F"),
        LONG ("L"),
        INT ("I"),
        SHORT ("S"),
        BYTE ("B"),
        CHAR ("C"),
        BOOLEAN ("Z");
        private String name;
        private InternalType(String name){
            this.name = name;
        }
        public String toString(){
            return this.name;
        }
    }
    public int size;
    public InternalType classType;

    public IRType(InternalType type, int size){
        this.classType = type;
        this.size = size;
    }

    public String toString(){
        String str = "";
        if (size != 0){
            str += "A";
        }
        str += classType.toString();
        return str;
    }

    public static IRType convertToIRType(Type type){
        int type_size = 0;

        if(type instanceof ArrayType){
            if (((ArrayType)type).compoundType != null){
                type_size =((ArrayType)type).compoundType.value;
            }
            type = ((ArrayType)type).subType;            
        }
        
        if (type instanceof IntegerType ){
            return new IRType(IRType.InternalType.INT, type_size);
        }else if (type instanceof CharType){
            return new IRType(IRType.InternalType.CHAR, type_size);
        }else if (type instanceof StringType){
            return new IRType(IRType.InternalType.STRING, type_size);
        }else if (type instanceof VoidType){
            return new IRType(IRType.InternalType.VOID, type_size);
        }else if (type instanceof FloatType){
            return new IRType(IRType.InternalType.FLOAT, type_size);
        }else if (type instanceof BooleanType){
            return new IRType(IRType.InternalType.BOOLEAN, type_size);
        }else if (type instanceof ArrayType){
            return new IRType(IRType.InternalType.INT, type_size);
        }else{
            System.out.print("Error:cannot convert type");
            System.exit(-1);
        }
        return null;
    }

}