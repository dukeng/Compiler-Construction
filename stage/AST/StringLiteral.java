package AST;

import Type.*;
public class StringLiteral extends Literal {

	public String value;
    public StringLiteral (String value) {
    	this.value = value;
    }


    public void accept (Visitor v) {
        v.visit(this);
	}
}