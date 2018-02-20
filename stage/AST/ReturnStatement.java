package AST;

public class ReturnStatement extends Statement
{
	Expression e;
	public ReturnStatement(Expression e){
		this.e = e;
	}
	public ReturnStatement(){
		
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}
