
package Type;
import AST.*;
public class CharType extends Type {
		int value;
		
        public CharType () {
		}
        public String toString() {
            return "char";
		}
        public boolean equals (Object o) {
            if (o instanceof CharType)
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
