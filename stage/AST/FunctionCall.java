package AST;
import Type.*;


public class FunctionCall extends Expression
{
	Identifier identifier;
	ExpressionList eList;

	public FunctionCall(Identifier identifier, ExpressionList eList){
		this.identifier = identifier;
		this.eList = eList;
	}		

	public Type accept(Visitor v){
		return v.visit(this);
	}
}
