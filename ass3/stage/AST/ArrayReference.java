package AST;

import Type.*;

public class ArrayReference extends Expression
{
	Identifier identifier;
	Expression e;

	public ArrayReference(Identifier identifier, Expression e){
		this.identifier = identifier;
		this.e = e;
	}		

	public Object accept(Visitor v){
		return v.visit(this);
	}
}
