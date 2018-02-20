package AST;

import Type.*;
public class BooleanLiteral extends Literal {

	public Boolean value;
    public BooleanLiteral (Boolean value) {
    	this.value = value;
    }


    public void accept (Visitor v) {
        v.visit(this);
	}
}