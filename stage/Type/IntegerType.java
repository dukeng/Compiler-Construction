package Type;
import AST.*;
public class IntegerType extends Type {
		public int value;
		public int line;
		public int pos;
		public IntegerType(int value, int line, int pos){
			this.value = value;
			this.line = line;
			this.pos = pos;
		}		
        public IntegerType () {
		}
		public IntegerType(int value){
			this.value = value;
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
		public String toShortString(){
			return null;
		}
		public int line(){
			return line;
		}
		public void setLine(int line){
			this.line = line;
		}
		public int pos(){
			return pos;
		}		
		public void setPos(int pos){
			this.pos = pos;
		}					
}