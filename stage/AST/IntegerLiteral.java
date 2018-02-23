package AST;

import Type.*;
public class IntegerLiteral extends Literal {

    public int value;
    public int line;
    public int pos;
    public IntegerLiteral (int value, int line, int pos ) {
        this.value = value;
        this.line = line;
        this.pos = pos;
    }        
    public IntegerLiteral (Integer value) {
    	this.value = value;
    }


    public void accept (Visitor v) {
        v.visit(this);
	}
}