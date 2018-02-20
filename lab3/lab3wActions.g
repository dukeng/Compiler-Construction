grammar lab3;

@header {
        import java.util.HashMap;
}

@members {
        HashMap memory = new HashMap();
}

program :
        statement+ EOF
	;

statement :
        id '=' expr ';' {
                memory.put($id.text, new Integer($expr.value));
        }
        | 'output' expr ';' {
                System.out.println("Our expression is "+$expr.value);
                System.out.println("Uh, Houston, we've had an expression");
        }
        ;

expr returns [int value]:
        e = multExpr { $value = $e.value; }
                (
                        '+' e = multExpr { $value += $e.value; }
                |       '-' e = multExpr { $value += $e.value; }
                )*
        ;

multExpr returns [int value] :
        e = atom {
                $value = $e.value;
        } ('*' atom {
                $value *= $e.value;
        })*
        ;

atom returns [int value] :
        id {
                Integer v = (Integer)memory.get($id.text);
                if (v!=null) $value = v.intValue();
                else System.err.println("undefined variable "+$id.text);
        }
        | intLit {
                $value = $intLit.value;
        }
        | '(' expr ')' {
                $value = $expr.value;
        }
        ;

id      : ID ;

intLit returns [int value] :
        INT { $value = Integer.parseInt($INT.text); }
        ;

/* Lexer */

ID	: (('a'..'z')|('A'..'Z'))+ ;

INT     : '-'? ('0' | ('1'..'9'('0'..'9')*)) ;

WS      : ( '\t' | ' ' | '\r' | '\n')+ { $channel = HIDDEN; skip();} ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN; } ;