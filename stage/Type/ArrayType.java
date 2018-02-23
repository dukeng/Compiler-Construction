

package Type;
import AST.*;

public class ArrayType extends Type {

	public Type subType;
	public IntegerLiteral compoundType;
	public int line;
	public int pos;
	
    public ArrayType (Type subType) {
    	this.subType = subType;
	}
    public String toString() {
        return subType.toString();
	}
    public boolean equals (Object o) {
        if (o instanceof ArrayType)
			return true;
		else
			return false;
	}

    public void accept (Visitor v) {
        v.visit(this);
	}
	public String toShortString(){
		return null;
	}
	public int line(){
		return line;
	}
	public void setLine(int line){
		this.line = line;
	};
	
}