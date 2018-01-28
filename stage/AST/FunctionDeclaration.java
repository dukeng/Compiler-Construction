package AST;

import Type.*;

public class FunctionDeclaration extends ASTNode {

	public ArrayType arrayType;
	public Identifier identifier;
	public FormalParameter formalParameter;
        
        public FunctionDeclaration (ArrayType arrayType, String identifier, FormalParameter formalParameter ) {
        	this.arrayType = arrayType;
	       	this.identifier = new Identifier(identifier);
        	this.formalParameter = formalParameter;
        }

        public void accept (Visitor v) {
                v.visit(this);
	}
}
