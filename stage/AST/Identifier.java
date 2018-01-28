package AST;

import Type.*;
public class Identifier extends ASTNode {

	public String name;
    public Identifier (String name) {
    	this.name = name;
    }

    public void accept (Visitor v) {
            v.visit(this);
	}
}
