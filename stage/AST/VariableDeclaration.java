package AST;

import Type.*;

public class VariableDeclaration  extends ASTNode {

	public ArrayType arrayType;
	public Identifier identifier;
        public VariableDeclaration (ArrayType arrayType, String identifier) {
        	this.arrayType = arrayType;
	       	this.identifier = new Identifier(identifier);
        }

        public void accept (Visitor v) {
                v.visit(this);
	}
}