package AST;

import Type.*;
public class TypeNode extends ASTNode  {

	public Type subType;
	public IntegerLiteral compoundType;
    public TypeNode (Type subType) {
    	this.subType = subType;
    }


    public void accept (Visitor v) {
            v.visit(this);
	}
}
