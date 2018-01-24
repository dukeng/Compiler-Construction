package AST;


public class CompoundType {


        public CompoundType () {

        }

        public void accept (Visitor v) {
                v.visit(this);
	}
}
