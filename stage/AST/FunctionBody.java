package AST;



import java.util.*;
public class FunctionBody {


		public VariableDeclarationList variableDeclarationList = new VariableDeclarationList();
		public StatementList statementList = new StatementList();
		
        public FunctionBody () {
       
        }

        public void accept (Visitor v) {
                v.visit(this);
		}
}
