package AST;

public class WrapperExpression extends Expression
{
	Literal literal;
	Identifier identifier;

	
	public WrapperExpression(Literal literal){
		this.literal = literal;
	}

	public WrapperExpression(Identifier identifier){
		this.identifier = identifier;
	}	
	
	public void accept(Visitor v){
		v.visit(this);
	}
}
