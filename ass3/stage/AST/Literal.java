package AST;

import Type.*;
public abstract class Literal {

    public abstract Object accept (Visitor v);
    public abstract String getValue();
}