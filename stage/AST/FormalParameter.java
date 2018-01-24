package AST;

import Type.*;

import java.util.*;

public class FormalParameter {

	public ArrayList<ArrayType> arrayTypes = new ArrayList<ArrayType>();
	public ArrayList<Identifier> identifiers = new ArrayList<Identifier>();
    public FormalParameter () {

    }


    public void accept (Visitor v) {
            v.visit(this);
	}
}
