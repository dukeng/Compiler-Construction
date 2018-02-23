package Type;
import AST.*;
public class BooleanType extends Type {
		public Boolean value;
		public int line;
		public int pos;
		public BooleanType(boolean value, int line, int pos){
			this.value = value;
			this.line = line;
			this.pos = pos;
		}
        public BooleanType () {
		}
		

		public BooleanType(boolean value){
			this.value = value;
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
		public int line(){
			return line;
		}		
		public void setLine(int line){
			this.line = line;
		};		
}
