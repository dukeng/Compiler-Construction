
package Type;
import AST.*;
public class CharType extends Type {
		public Character value;
		public int line;
		public int pos;
		public CharType(Character value, int line, int pos){
			this.value = value;
			this.line = line;
			this.pos = pos;
		}
        public CharType () {
		}

		public CharType(Character value){
			this.value = value;
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

        public Object accept (Visitor v) {
			// v.visit(this);
			return v.visit(this);
			
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
