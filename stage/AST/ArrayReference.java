package AST;

public class ArrayReference extends Expression
{
	Identifier identifier;
	Expression e;

	public ArrayReference(Identifier identifier, Expression e){
		this.identifier = identifier;
		this.e = e;
	}		

	public void accept(Visitor v){
		v.visit(this);
	}
}
