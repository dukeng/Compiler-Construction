
package Type;
import AST.*;
public class VoidType extends Type {
		int value;
		
        public VoidType () {
		}
        public String toString() {
            return "void";
		}
        public boolean equals (Object o) {
            if (o instanceof VoidType)
				return true;
			else
				return false;
		}

        public void accept (Visitor v) {
            // v.visit(this);
            System.out.println("FLOATT");
		}
		public String toShortString(){
			return null;
		}
}
