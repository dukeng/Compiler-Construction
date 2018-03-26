lexer grammar ulNoActions;

T16 : '(' ;
T17 : ')' ;
T18 : '{' ;
T19 : '}' ;
T20 : '[' ;
T21 : ']' ;
T22 : ',' ;
T23 : ';' ;
T24 : '=' ;
T25 : 'while' ;
T26 : 'println' ;
T27 : 'print' ;
T28 : 'return' ;
T29 : '==' ;
T30 : '<' ;
T31 : '+' ;
T32 : '-' ;
T33 : '*' ;

// $ANTLR src "ulNoActions.g" 328
TRUE  : 'true'
  ;
// $ANTLR src "ulNoActions.g" 330
FALSE : 'false'
  ;

// $ANTLR src "ulNoActions.g" 338
TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;


// $ANTLR src "ulNoActions.g" 342
IF  : 'if'
  ;

// $ANTLR src "ulNoActions.g" 345
ELSE  : 'else'
  ;

// $ANTLR src "ulNoActions.g" 348
CHARACTERCONSTANT: '\'' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' |  '0'..'9') '\''
  ;

// $ANTLR src "ulNoActions.g" 351
STRINGCONSTANT: '"' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\n' | '\'' |  '0'..'9')* '"'
  ;

// $ANTLR src "ulNoActions.g" 354
INTEGERCONSTANT: ('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 357
FLOATCONSTANT: ('0'..'9')+'.'('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 360
ID  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*  
  ;
  

// $ANTLR src "ulNoActions.g" 364
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

// $ANTLR src "ulNoActions.g" 367
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n' | EOF) { $channel = HIDDEN;}
        ;