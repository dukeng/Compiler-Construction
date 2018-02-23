
package Type;
import AST.*;
public class StringType extends Type {
		public String value;
		public int line;
		public int pos;
		public StringType(String value, int line, int pos){
			this.value = value;
			this.line = line;
			this.pos = pos;
		}		
        public StringType () {
		}
		public StringType(String value){
			this.value = value;
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
		public int line(){
			return line;
		}
		public void setLine(int line){
			this.line = line;
		};				
}
