

package Type;
import AST.*;

public class ArrayType extends Type {

	public Type subType;
	public IntegerLiteral compoundType;
	
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
}