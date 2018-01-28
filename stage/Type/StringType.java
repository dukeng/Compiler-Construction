
package Type;
import AST.*;
public class StringType extends Type {
		int value;
		
        public StringType () {
		}
        public String toString() {
            return "string";
		}
        public boolean equals (Object o) {
            if (o instanceof StringType)
				return true;
			else
				return false;
		}

        public void accept (Visitor v) {
            // v.visit(this);
            // System.out.println("String");
		}
		public String toShortString(){
			return null;
		}
}
