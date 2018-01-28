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
        arrayType=compoundType identifier=ID '(' fp=formalParameters ')'
        {functionDecl = new FunctionDeclaration(arrayType, $identifier.text, fp);}
        ;

functionBody returns [FunctionBody functionbody]
@init
{
        functionbody = new FunctionBody();
}
        :
        '{' (varDe=varDecl{
          functionbody.variableDeclarationList.varDecList.add(varDe);
        })* (state=statement{
          if(state != null){
            functionbody.statementList.stateList.add(state);
          }
        })* '}'

        ;

/*TODO: 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void' */

compoundType returns[ArrayType arrayType]
        :
        t=TYPE ('['  i=INTEGERCONSTANT ']')?
        {
          String theType = $t.text;
          Type subType = new IntegerType(); // boilerplate

          if(theType.equals("int")) subType = new IntegerType();
          else if (theType.equals("float")) subType = new FloatType(); 
          else if (theType.equals("char")) subType = new CharType(); 
          else if (theType.equals("string")) subType = new StringType(); 
          else if (theType.equals("boolean")) subType = new BooleanType(); 
          else if (theType.equals("void")) subType = new VoidType(); 

          arrayType = new ArrayType(subType);

          if ($i != null){ // If there is compound type
            arrayType.compoundType = new IntegerLiteral(Integer.valueOf($i.text));
          }
        }
        ;

formalParameters returns[FormalParameter fp]
@init
{
        fp = new FormalParameter();
}
        : ( ct=compoundType {
          if (ct != null){
            fp.arrayTypes.add(ct);
          }

        } identifier=ID {
          fp.identifiers.add(new Identifier($identifier.text));

        } ( mf = moreFormals {
          fp.arrayTypes.add(mf.arrayTypes.get(0));
          fp.identifiers.add(mf.identifiers.get(0));
        })*) ?

        ;

moreFormals returns[FormalParameter fp ] 
        : ',' ct=compoundType identifier=ID
        {
          fp = new FormalParameter();
          fp.arrayTypes.add(ct);
          fp.identifiers.add(new Identifier($identifier.text));
        }
  ;


statement returns [Statement statement]
options {
    backtrack=true;
}
      :     ';' {
              statement = null;

            }| 
            identifier=ID '=' e=expr ';'{
              VariableAssignment varAssignment = new VariableAssignment(new Identifier($identifier.text), e);
              statement = new AssignmentStatement(varAssignment);
            }  |
            identifier=ID '[' e1=expr ']' '=' e2=expr ';' {
               ArrayAssignment arrayAssignment = new ArrayAssignment(new Identifier($identifier.text), e1, e2);
              statement = new AssignmentStatement(arrayAssignment);
            }  |    
            IF '(' e=expr ')' bl1=block ELSE bl2=block {
              statement = new IfStatement(e,bl1,bl2);
            }  |            
            IF '(' e=expr ')' bl=block {
              statement = new IfStatement(e,bl);
            }  |
            'while' '(' e=expr ')' bl=block {
              statement = new WhileStatement(e,bl);
            }  |
            'println' e=expr ';' {
              statement = new PrintLnStatement(e);
            } |            
            'print' e=expr ';' {
              statement = new PrintStatement(e);
            }  |
            e = expr  ';'{
              statement = new ExpressionStatement(e);
            } |
            'return' ';' {
              statement = new ReturnStatement();
            } |
            'return' e=expr ';' {
              statement = new ReturnStatement(e);
            }
  ;

varDecl returns [VariableDeclaration variableDeclaration]
          : arrayType=compoundType identifier=ID ';'
          {
            variableDeclaration = new VariableDeclaration(arrayType, $identifier.text);
          }
  ;

block returns [Block block]
@init{
  StatementList statementList = new StatementList();
}
@after{
  block = new Block(statementList);
}
          : '{' 
          (stm=statement {
              statementList.add(stm);
            }
          )* '}'
  ;



expr returns [Expression e]
@init{
  Expression it = null;
} 
@after{
  e = it;
}
      : e1 = lessThanExpr { it = e1; }
        (
          '==' e1 = lessThanExpr { it = new EqualityExpression(it, e1);  }
        )*
  ;


lessThanExpr returns [Expression e]
@init{
  Expression it = null;
} 
@after{
  e = it;
}
      : e1 = addExpr { it = e1; }
        (
          '<' e1 = addExpr { it = new LessThanExpression(it, e1);  }
        )*
  ;


addExpr returns [Expression e]
@init{
  Expression it = null;
} 
@after{
  e = it;
}
      : e1 = multExpr { it = e1; }
        (
            '+' e1 = multExpr { it = new AddExpression(it, e1);  }
          | '-' e1 = multExpr { it = new SubtractExpression(it, e1);  } 
        )*
  ;


multExpr returns [Expression e]
@init{
  Expression it = null;
} 
@after{
  e = it;
}
      : e1 = exprf { it = e1; }
       (
          '*' e1 = exprf { it = new MultExpression(it, e1); }
       )*
  ;

exprf returns [Expression e]
            : identifier=ID '['  expression=expr ']' {
                e = new ArrayReference(new Identifier($identifier.text), expression);
              }|
              identifier=ID '(' eList=exprList ')' {
                e = new FunctionCall(new Identifier($identifier.text), eList);                
              } |
              lit = literal {
                e = new WrapperExpression(lit);
              } |
              identifier = ID {
                e = new WrapperExpression(new Identifier($identifier.text));
              } |
              '(' parenExpr = expr {
                e = new ParenExpression(parenExpr);
              } ')'
  ;


exprList returns [ExpressionList eList]
@init{
  ExpressionList it = new ExpressionList();
} 
@after{
  eList = it;
}
            : (newExpr=expr {
              it.add(newExpr);
            } (moreExpr=exprMore{
              it.add(moreExpr);
            })*)?
  ;

exprMore returns [Expression e]
            : ',' expression=expr{
              e = expression;
            }
  ;

literal returns [Literal lit]
        :  
          'true' {
            lit = new BooleanLiteral(new Boolean(true));
          } |
          'false' {
            lit = new BooleanLiteral(new Boolean(false));
          } |
          sC =stringConstant {
            String str = String.valueOf($sC.text);
            lit = new StringLiteral(str.substring(1,str.length()-1));
          } |
          iC = INTEGERCONSTANT {
            lit = new IntegerLiteral(Integer.valueOf($iC.text));
          } |
          fC = floatConstant {
            lit = new FloatLiteral(Float.valueOf($fC.text));
          } |
          cC = CHARACTERCONSTANT {
            lit  = new CharacterLiteral(Character.valueOf(($cC.text).charAt(1)));
          }
  ;




characterConstant: CHARACTERCONSTANT
  ;

floatConstant: FLOATCONSTANT
  ;

stringConstant: STRINGCONSTANT
  ;

integerConstant: INTEGERCONSTANT
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