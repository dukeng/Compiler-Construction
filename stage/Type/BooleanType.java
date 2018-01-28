package Type;
import AST.*;
public class BooleanType extends Type {
		int value;
		
        public BooleanType () {
		}
        public String toString() {
            return "boolean";
		}
        public boolean equals (Object o) {
            if (o instanceof BooleanType)
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
