package AST;

import java.util.*;
public class Program extends ASTNode {
        public ArrayList<Function> functionList;
        public Program () {
                functionList = new ArrayList();
	}
        public void addElement (Function f) {
                functionList.add(f);
	}
        public Function elementAt (int index) {
                return functionList.get(index);
        }
        public int size () {
                return functionList.size();
	}
        public Object accept (Visitor v) {
                return v.visit(this);
	}
}
