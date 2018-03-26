package AST;

public class ExpressionStatement extends Statement
{
	Expression e;
	public ExpressionStatement(Expression e){
		this.e = e;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
