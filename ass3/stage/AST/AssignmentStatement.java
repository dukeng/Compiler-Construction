package AST;

public class AssignmentStatement  extends Statement
{
	VariableAssignment varAssignment;
	ArrayAssignment arrayAssignment;

	public AssignmentStatement(VariableAssignment varAssignment){
		this.varAssignment = varAssignment;
	}	

	public AssignmentStatement(ArrayAssignment arrayAssignment){
		this.arrayAssignment = arrayAssignment;
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
