package AST;


public class PrintVisitor implements Visitor{

		String builder = "";
        public PrintVisitor () {
	       
        }
       
        public void visit(Program program){
        	System.out.println(this);
        	for(Function f: program.functionList){
        		f.accept(this);
        	}
        }

		public void visit (Function f){
			System.out.println(f);
			f.functionBody.accept(this);
			f.functionDecl.accept(this);
		}
		public void visit (FunctionBody f){
			System.out.println(f);
		}

		public void visit (FunctionDeclaration f){
			System.out.println(f);
		}

}
