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

// $ANTLR src "ulNoActions.g" 332
TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;

// $ANTLR src "ulNoActions.g" 335
IF  : 'if'
  ;

// $ANTLR src "ulNoActions.g" 338
ELSE  : 'else'
  ;

// $ANTLR src "ulNoActions.g" 341
CHARACTERCONSTANT: '\'' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' |  '0'..'9') '\''
  ;

// $ANTLR src "ulNoActions.g" 344
STRINGCONSTANT: '"' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\n' | '\'' |  '0'..'9')* '"'
  ;

// $ANTLR src "ulNoActions.g" 347
INTEGERCONSTANT: ('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 350
FLOATCONSTANT: ('0'..'9')+'.'('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 353
ID  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*  
  ;
  

// $ANTLR src "ulNoActions.g" 357
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

// $ANTLR src "ulNoActions.g" 360
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n' | EOF) { $channel = HIDDEN;}
        ;