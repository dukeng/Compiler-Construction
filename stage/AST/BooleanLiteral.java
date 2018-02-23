package AST;

import Type.*;
public class BooleanLiteral extends Literal {

    public Boolean value;
    public int line;
    public int pos;
    public BooleanLiteral (Boolean value, int line, int pos ) {
        this.value = value;
        this.line = line;
        this.pos = pos;
    }    
    public BooleanLiteral (Boolean value) {
    	this.value = value;
    }



    public void accept (Visitor v) {
        v.visit(this);
	}
}