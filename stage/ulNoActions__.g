lexer grammar ulNoActions;

T14 : '(' ;
T15 : ')' ;
T16 : '{' ;
T17 : '}' ;
T18 : '[' ;
T19 : ']' ;
T20 : ',' ;
T21 : ';' ;
T22 : '=' ;
T23 : 'while' ;
T24 : 'println' ;
T25 : 'print' ;
T26 : 'return' ;
T27 : '==' ;
T28 : '<' ;
T29 : '+' ;
T30 : '-' ;
T31 : '*' ;
T32 : 'true' ;
T33 : 'false' ;

// $ANTLR src "ulNoActions.g" 321
TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;

// $ANTLR src "ulNoActions.g" 324
IF  : 'if'
  ;

// $ANTLR src "ulNoActions.g" 327
ELSE  : 'else'
  ;

// $ANTLR src "ulNoActions.g" 330
CHARACTERCONSTANT: '\'' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' |  '0'..'9') '\''
  ;

// $ANTLR src "ulNoActions.g" 333
STRINGCONSTANT: '"' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\n' | '\'' |  '0'..'9')* '"'
  ;

// $ANTLR src "ulNoActions.g" 336
INTEGERCONSTANT: ('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 339
FLOATCONSTANT: ('0'..'9')+'.'('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 342
ID  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*  
  ;
  

// $ANTLR src "ulNoActions.g" 346
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

// $ANTLR src "ulNoActions.g" 349
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n' | EOF) { $channel = HIDDEN;}
        ;