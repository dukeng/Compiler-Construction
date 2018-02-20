/* This file was generated by SableCC (http://www.sablecc.org/). */

package soot.jimple.parser.node;

import soot.jimple.parser.analysis.*;

public final class TDiv extends Token
{
    public TDiv()
    {
        super.setText("/");
    }

    public TDiv(int line, int pos)
    {
        super.setText("/");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TDiv(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDiv(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TDiv text.");
    }
}
