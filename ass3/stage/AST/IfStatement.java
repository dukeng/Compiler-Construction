package AST;

public class IfStatement extends Statement
{
	Expression e;
	Block bl1;
	Block bl2;
	public IfStatement(Expression e, Block bl1, Block bl2){
		this.e = e;
		this.bl1 = bl1;
		this.bl2 = bl2;
	}	

	public IfStatement(Expression e, Block bl1){
		this.e = e;
		this.bl1 = bl1;
	}		
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
