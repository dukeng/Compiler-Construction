package AST;

public class WhileStatement  extends Statement
{
	Expression e;
	Block block;
	public WhileStatement(Expression e, Block block){
		this.e = e;
		this.block = block;
	}	
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
