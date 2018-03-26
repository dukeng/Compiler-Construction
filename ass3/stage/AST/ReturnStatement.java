package AST;

public class ReturnStatement extends Statement
{
	Expression e;
	public ReturnStatement(Expression e){
		this.e = e;
	}
	public ReturnStatement(){
		
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
