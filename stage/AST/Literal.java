package AST;

import Type.*;
public abstract class Literal {

    public abstract void accept (Visitor v);
}