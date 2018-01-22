grammar ul;
@header
{
        import AST.*;
        import Type.*;
}
program returns [Program prog]
@init
{
        prog = new Program();
}
;
: (f=function { prog.addElement(f);})+ EOF
function returns [Function f]
        :
        fd=functionDecl fb=functionBody
        { f = new Function(fd,fb); }
        ;

package AST;
import java.util.Vector;
public class Program {
        public Vector functionList;
        public Program () {
                functionList = new Vector();
		}
        public void addElement (Function f) {
                functionList.addElement(f);
		}
        public Function elementAt (int index) {
                return (Function)functionList.elementAt(index);
		}
        public int size () {
                return functionList.size();
		}
        public void accept (Visitor v) {
                v.visit(this);
		}
}

package Type;
public abstract class Type {
        public abstract void accept (Visitor v );
        public abstract String toShortString();
        public abstract boolean equals (Object o);
}
public class IntegerType extends Type {
        public IntegerType () {
		}
        public String toString() {
                return "int";
		}
        public boolean equals (Object o) {
                if (o instanceof IntegerType)
					return true;
				else
					return false;
		}

        public void accept (Visitor v) {
                v.visit(this);
		}
}
