package AST;

public class ParenExpression extends Expression
{
	Expression e;
	
	public ParenExpression(Expression e){
		this.e = e;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}
