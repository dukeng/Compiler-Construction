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

// $ANTLR src "ulNoActions.g" 154
TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;

// $ANTLR src "ulNoActions.g" 157
IF  : 'if'
  ;

// $ANTLR src "ulNoActions.g" 160
ELSE  : 'else'
  ;

// $ANTLR src "ulNoActions.g" 163
CHARACTERCONSTANT: '\'' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' |  '0'..'9') '\''
  ;

// $ANTLR src "ulNoActions.g" 166
STRINGCONSTANT: '"' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\n' | '\'' |  '0'..'9')* '"'
  ;

// $ANTLR src "ulNoActions.g" 169
INTEGERCONSTANT: ('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 172
FLOATCONSTANT: ('0'..'9')+'.'('0'..'9')+
  ;

// $ANTLR src "ulNoActions.g" 175
ID  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*  
  ;
  

// $ANTLR src "ulNoActions.g" 179
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

// $ANTLR src "ulNoActions.g" 182
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n' | EOF) { $channel = HIDDEN;}
        ;