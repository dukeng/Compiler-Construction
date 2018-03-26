
package AST;

import Type.*;
public abstract class Statement  extends ASTNode {

    public abstract Object accept (Visitor v);
}