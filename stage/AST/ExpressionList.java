package AST;
import java.util.*;


public class ExpressionList{
	public ArrayList<Expression> expressionList = new ArrayList<Expression>();
	public ExpressionList(){
	}
	
	public void add(Expression e){
		expressionList.add(e);
	}
	public int getSize(){
		return expressionList.size();
	}
}
