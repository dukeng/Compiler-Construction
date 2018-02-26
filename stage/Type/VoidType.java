
package Type;
import AST.*;
public class VoidType extends Type {
		public int line;
		public int pos;
		public VoidType(int line, int pos){
			this.line = line;
			this.pos = pos;
		}		
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
