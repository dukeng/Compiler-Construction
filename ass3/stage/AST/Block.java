package AST;

import Type.*;
import java.util.*;

public class Block  extends ASTNode {

		public StatementList statementList;
        public Block (StatementList statementList) {
        	this.statementList = statementList;
        }
        public void accept(Visitor v){
        	v.visit(this);
        }


}