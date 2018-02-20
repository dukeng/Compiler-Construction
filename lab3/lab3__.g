lexer grammar lab3;

T8 : '=' ;
T9 : ';' ;
T10 : 'output' ;
T11 : '+' ;
T12 : '-' ;
T13 : '*' ;
T14 : '(' ;
T15 : ')' ;

// $ANTLR src "lab3.g" 63
ID      : (('a'..'z')|('A'..'Z'))+ ;

// $ANTLR src "lab3.g" 65
INT     : '-'? ('0' | ('1'..'9'('0'..'9')*)) ;

// $ANTLR src "lab3.g" 67
WS      : ( '\t' | ' ' | '\r' | '\n')+ { $channel = HIDDEN; skip();} ;

// $ANTLR src "lab3.g" 69
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN; } ;