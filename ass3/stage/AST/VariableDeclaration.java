package AST;

import javax.sound.sampled.LineListener;

import Type.*;

public class VariableDeclaration  extends ASTNode {

	public ArrayType arrayType;
	public Identifier identifier;
	public int line;
	public int pos;
        public VariableDeclaration (ArrayType arrayType, String identifier, int line, int pos) {
        	this.arrayType = arrayType;
			this.identifier = new Identifier(identifier, line, pos);
			this.line = line;
			this.pos = pos;
        }

        public void accept (Visitor v) {
            v.visit(this);
	}
}