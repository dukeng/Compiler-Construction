
package AST;

import Type.*;
public abstract class Statement {

    public abstract void accept (Visitor v);
}