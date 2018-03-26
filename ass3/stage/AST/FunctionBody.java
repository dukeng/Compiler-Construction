package AST;



import java.util.*;
public class FunctionBody extends ASTNode {


        public VariableDeclarationList variableDeclarationList = new VariableDeclarationList();
        public StatementList statementList = new StatementList();
		
        public FunctionBody () {
       
        }

        public void accept (Visitor v) {
                v.visit(this);
        }
}
