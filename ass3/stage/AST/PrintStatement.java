package AST;

public class PrintStatement  extends Statement
{
	Expression e;
	public PrintStatement(Expression e){
		this.e = e;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
