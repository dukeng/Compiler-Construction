package AST;

import Type.*;

public interface Visitor
{
	
	public Object visit (Program p);

	public void visit (Function f);
	public void visit (FormalParameter p);	
	public void visit (FunctionBody f);
	public void visit (FunctionDeclaration f);

	public void visit (Block b);

	public Object visit (ExpressionStatement e);
	public Object visit (FunctionCall f);
	public Object visit (ArrayReference f);

	public Object visit (Identifier i);
	// public void visit (IdentifierValue v);
	public Object visit (IfStatement i);

	public Object visit (IntegerLiteral i);
	public Object visit (StringLiteral s);
	public Object visit (FloatLiteral f);	
	public Object visit (BooleanLiteral b);
	public Object visit (CharacterLiteral c);

	public Object visit (AddExpression e);
	public Object visit (LessThanExpression e);
	public Object visit (MultExpression e);
	public Object visit (EqualityExpression e);
	public Object visit (WrapperExpression e);
	public Object visit (SubtractExpression e);
	public Object visit (ParenExpression p);

	
	public Object visit (PrintLnStatement s);
	public Object visit (PrintStatement s);	

	public Object visit (ReturnStatement s);
	public Object visit (AssignmentStatement s);

	public Object visit (Type t);
	public Object visit (ArrayType a);
	
	public void visit (ArrayAssignment s);

	public void visit (VariableAssignment s);
	public void visit (VariableDeclaration v);
	public Object visit (WhileStatement s);
}

