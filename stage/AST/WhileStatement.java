package AST;

public class WhileStatement  extends Statement
{
	Expression e;
	Block block;
	public WhileStatement(Expression e, Block block){
		this.e = e;
		this.block = block;
	}	
	public void accept(Visitor v){
		v.visit(this);
	}
}
