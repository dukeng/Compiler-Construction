package AST;

public class FunctionCall extends Expression
{
	Identifier identifier;
	ExpressionList eList;

	public FunctionCall(Identifier identifier, ExpressionList eList){
		this.identifier = identifier;
		this.eList = eList;
	}		

	public void accept(Visitor v){
		v.visit(this);
	}
}
