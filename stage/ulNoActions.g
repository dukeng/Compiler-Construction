grammar ulNoActions;

@header
{
        import AST.*;
        import Type.*;
}

@members
{
protected void mismatch (IntStream input, int ttype, BitSet follow)
        throws RecognitionException
{
        throw new MismatchedTokenException(ttype, input);
}
public void recoverFromMismatchedSet (IntStream input,
                                      RecognitionException e,
                                      BitSet follow)
        throws RecognitionException
{
        reportError(e);
        throw e;
}
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}



program returns [Program prog]
@init
{
        prog = new Program();
}
: (f= function {
        prog.addElement(f);
              })+ EOF
  ;


function returns [Function f]
        :
        fd=functionDecl fb=functionBody
        {f = new Function(fd, fb);}
        ;

functionDecl returns[ FunctionDeclaration functionDecl]
        :
        compoundType identifier '(' formalParameters ')'
        {functionDecl = new FunctionDeclaration();}
        ;

functionBody returns [FunctionBody functionbody]
        :
        '{' varDecl* statement* '}'
        {functionbody = new FunctionBody();}
        ;


compoundType: TYPE ('[' INTEGERCONSTANT ']')?
  ;

formalParameters: (compoundType identifier moreFormals*)?
  ;

moreFormals: ',' compoundType identifier
  ;


statement
options {
    backtrack=true;
}
      :     ';' | 
            identifier '=' expr ';' |
            identifier '[' expr ']' '=' expr ';'  |    

            IF '(' expr ')' block ELSE block |            
            IF '(' expr ')' block |
            'while' '(' expr ')' block |
            'println' expr ';' |            
            'print' expr  ';' |

            expr ';' |
            'return' (expr)? ';'             

  ;

varDecl: compoundType identifier ';'
  ;

block: '{' statement* '}'
  ;

expr:  expr1 ('==' expr)?      
  ;

expr1: expr2 ('<' expr1)?
  ;

expr2: expr3 (('+' | '-') expr2)?
  ;

expr3: exprf ('*' expr3)?
  ;

exprf:  identifier '[' expr ']'|
        identifier '(' exprList ')' |
        identifier |
        literal |
        '(' expr ')'
  ;

literal:  stringConstant |
          integerConstant |
          floatConstant |
          characterConstant |
          'true' |
          'false'
  ;


exprList: (expr exprMore*)?
  ;

exprMore: ',' expr
  ;

characterConstant: CHARACTERCONSTANT
  ;

floatConstant: FLOATCONSTANT
  ;

stringConstant: STRINGCONSTANT
  ;

integerConstant: INTEGERCONSTANT
  ;

identifier : ID
  ;

type: TYPE
  ;

/* Lexer */

TYPE  : 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void'
  ;

IF  : 'if'
  ;

ELSE  : 'else'
  ;

CHARACTERCONSTANT: '\'' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' |  '0'..'9') '\''
  ;

STRINGCONSTANT: '"' ('a'..'z' | 'A'..'Z' | '_' | ' '| '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\n' | '\'' |  '0'..'9')* '"'
  ;

INTEGERCONSTANT: ('0'..'9')+
  ;

FLOATCONSTANT: ('0'..'9')+'.'('0'..'9')+
  ;

ID  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*  
  ;
  

WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n' | EOF) { $channel = HIDDEN;}
        ;