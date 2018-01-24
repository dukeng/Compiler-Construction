package AST;

import Type.*;
public class CharacterLiteral extends Literal {

	public char value;
    public CharacterLiteral (char value) {
    	this.value = value;
    }


    public void accept (Visitor v) {
        v.visit(this);
	}
}