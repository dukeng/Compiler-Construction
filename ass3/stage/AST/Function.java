package AST;


public class Function extends ASTNode  {
    public FunctionDeclaration functionDecl;
    public FunctionBody functionBody;

    public Function (FunctionDeclaration functionDecl, FunctionBody functionBody) {
            this.functionDecl = functionDecl;
            this.functionBody = functionBody;
    }

    public void accept (Visitor v) {
            v.visit(this);
	}
}
