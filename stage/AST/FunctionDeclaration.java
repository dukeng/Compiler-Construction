package AST;

import Type.*;

public class FunctionDeclaration extends ASTNode {

	public ArrayType arrayType;
	public Identifier identifier;
	public FormalParameter formalParameter;
	public int line;
	public int pos;
        
        public FunctionDeclaration (ArrayType arrayType, String identifier, FormalParameter formalParameter, int line, int pos ) {
        	this.arrayType = arrayType;
	       	this.identifier = new Identifier(identifier, line, pos);
			this.formalParameter = formalParameter;
			this.line = line;
			this.pos = pos;
        }

        public void accept (Visitor v) {
                v.visit(this);
	}
}
