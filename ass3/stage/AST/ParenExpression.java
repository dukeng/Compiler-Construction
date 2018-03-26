package AST;

import Type.*;

public class ParenExpression extends Expression
{
	Expression e;
	
	public ParenExpression(Expression e){
		this.e = e;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
