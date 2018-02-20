package AST;

import Type.*;
public class FloatLiteral extends Literal {

	public float value;
    public FloatLiteral (float value) {
    	this.value = value;
    }


    public void accept (Visitor v) {
        v.visit(this);
	}
}