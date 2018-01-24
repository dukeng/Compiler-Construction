package AST;

public class VariableAssignment
{
	Identifier id;
	Expression e;
	public VariableAssignment(Identifier id, Expression e){
		this.id = id;
		this.e = e;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}
