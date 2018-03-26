package AST;

import Type.*;
import java.util.*;

public class StatementList {

		public ArrayList<Statement> stateList = new ArrayList<Statement>();
        public StatementList () {

        }
        public void add(Statement stm){
        	stateList.add(stm);
        }

}