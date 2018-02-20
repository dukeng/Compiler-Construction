package AST;

import Type.*;
public class IntegerLiteral extends Literal {

	public int value;
    public IntegerLiteral (Integer value) {
    	this.value = value;
    }


    public void accept (Visitor v) {
        v.visit(this);
	}
}