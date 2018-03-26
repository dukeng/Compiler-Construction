package AST;
import Type.*;

public abstract class Expression extends ASTNode {
        public abstract Object accept (Visitor v );
}