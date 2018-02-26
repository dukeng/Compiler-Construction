package Type;
import AST.*;
public class FloatType extends Type {
		public float value;
		public int line;
		public int pos;
		public FloatType(float value, int line, int pos){
			this.value = value;
			this.line = line;
			this.pos = pos;
		}		
        public FloatType () {
		}

		public FloatType(float value){
			this.value = value;
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
