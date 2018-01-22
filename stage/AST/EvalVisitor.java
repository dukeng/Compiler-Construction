import java.util.HashMap;

public class EvalVisitor extends Visitor
{
	HashMap	vals;
	
	public EvalVisitor()
	{
		vals = new HashMap();	
	}
	
	public	Object visit(AssignmentStatement a)
	{
		Integer val = (Integer)a.e.accept(this);
		vals.put(a.i.name, val);
		return null;
	}
	
	public	Object visit(Identifier i)
	{
		System.out.println("hmmm...");
		return null;
	}
	
	public  Object visit(IdentifierValue v)
	{
		if (!vals.containsKey(v.id.name))
		{
			System.out.println("Use before definition:" + v.id.name);
			System.exit(1);
			return null;
		}
		else
		{
			return vals.get(v.id.name);
		}
	}
	
	public  Object visit(IntegerLiteral i)
	{
		return i.value;	
	}
	
	public	Object visit(MultExpression m)
	{
		Integer v1 = (Integer)m.e1.accept(this);
		Integer v2 = (Integer)m.e2.accept(this);
		return v1 * v2;
		
	}
	public	Object visit(OutputStatement o)
	{
		if (!vals.containsKey(o.i.name))
		{
			System.out.println("Use before definition: " + o.i.name);
			System.exit(1);
		}
		System.out.println(vals.get(o.i.name));
		return null;
	}
	
	public	Object visit(PlusExpression p)
	{
		Integer v1 = (Integer)p.e1.accept(this);
		Integer v2 = (Integer)p.e2.accept(this);
		return v1 + v2;		
	}
	
	public	Object visit(Program p)
	{
		int statementCount = p.getStatementCount();
		
		for (int i=0;i<statementCount;i++)
		{
			Statement s = p.getStatement(i);
			s.accept(this);
		}	
		return null;
	}
}
