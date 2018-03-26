package AST;

public class PrintLnStatement extends Statement
{
	Expression e;
	public PrintLnStatement(Expression e){
		this.e = e;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
