package AST;

import javax.sound.sampled.LineListener;

import Type.*;
public class Identifier extends ASTNode {

    public String name;
    public int line;
    public int pos;
    public Identifier (String name, int line, int pos) {
        this.name = name;
        this.line = line;
        this.pos = pos;
    }

    public void accept (Visitor v) {
            v.visit(this);
	}
}
