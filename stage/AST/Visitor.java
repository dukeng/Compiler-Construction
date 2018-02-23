package AST;

import Type.*;

public interface Visitor
{
	
	public void visit (ArrayType a);
	public void visit (Program p);

	public void visit (Function f);
	public void visit (FormalParameter p);	
	public void visit (FunctionBody f);
	public void visit (FunctionDeclaration f);

	public void visit (Block b);

	public void visit (ExpressionStatement e);
	public Type visit (FunctionCall f);
	public Type visit (ArrayReference f);

	public void visit (Identifier i);
	// public void visit (IdentifierValue v);
	public void visit (IfStatement i);

	public void visit (IntegerLiteral i);
	public void visit (StringLiteral s);
	public void visit (FloatLiteral f);	
	public void visit (BooleanLiteral b);
	public void visit (CharacterLiteral c);

	public Type visit (AddExpression e);
	public Type visit (LessThanExpression e);
	public Type visit (MultExpression e);
	public Type visit (EqualityExpression e);
	public Type visit (WrapperExpression e);
	public Type visit (SubtractExpression e);
	public Type visit (ParenExpression p);

	
	public void visit (PrintLnStatement s);
	public void visit (PrintStatement s);	

	public void visit (ReturnStatement s);
	public void visit (AssignmentStatement s);

	public void visit (Type t);
	
	public void visit (ArrayAssignment s);

	public void visit (VariableAssignment s);
	public void visit (VariableDeclaration v);
	public void visit (WhileStatement s);
}

