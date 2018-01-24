package AST;

import Type.*;
public class Identifier {

	public String name;
    public Identifier (String name) {
    	this.name = name;
    }

    public void accept (Visitor v) {
            v.visit(this);
	}
}
