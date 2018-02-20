package Type;

import AST.*;
public abstract class Type extends ASTNode {
        public abstract void accept (Visitor v );
        public abstract String toShortString();
        public abstract boolean equals (Object o);

}