package AST;

import javax.sound.sampled.LineListener;

import Type.*;
public class StringLiteral extends Literal {

    public String value;
    public int line;
    public int pos;
    public StringLiteral (String value) {
    	this.value = value;
    }

    public StringLiteral (String value, int line, int pos) {
        this.value = value;
        this.line = line;
        this.pos = pos;
    }
    public Object accept (Visitor v) {
        return v.visit(this);
    }
    
    public String getValue(){
        return "\"" + String.valueOf(value) + "\"";
    }
}