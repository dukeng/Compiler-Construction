package AST;
import Type.*;
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
	
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
