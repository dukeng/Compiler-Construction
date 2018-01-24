package Type;
import AST.*;
public class FloatType extends Type {
		int value;
		
        public FloatType () {
		}
        public String toString() {
            return "float";
		}
        public boolean equals (Object o) {
            if (o instanceof FloatType)
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
