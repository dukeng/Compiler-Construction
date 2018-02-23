package AST;

import Type.*;
public class FloatLiteral extends Literal {

    public float value;
    public int line;
    public int pos;
    public FloatLiteral (float value, int line, int pos ) {
        this.value = value;
        this.line = line;
        this.pos = pos;
    }    
    public FloatLiteral (float value) {
    	this.value = value;
    }
    
    public void accept (Visitor v) {
        v.visit(this);
	}
}