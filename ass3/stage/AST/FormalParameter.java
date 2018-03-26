package AST;

import Type.*;

import java.util.*;

public class FormalParameter extends ASTNode  {

	public ArrayList<ArrayType> arrayTypes = new ArrayList<ArrayType>();
	public ArrayList<Identifier> identifiers = new ArrayList<Identifier>();
    public FormalParameter () {

    }

    public boolean isEmpty(){
        return arrayTypes.size() == 0 && identifiers.size() == 0;
    }


    public void accept (Visitor v) {
            v.visit(this);
	}
}
