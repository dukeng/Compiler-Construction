// $ANTLR 3.0.1 ulNoActions.g 2018-03-18 09:41:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ulNoActionsLexer extends Lexer {
    public static final int COMMENT=15;
    public static final int T21=21;
    public static final int T20=20;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T25=25;
    public static final int T24=24;
    public static final int STRINGCONSTANT=11;
    public static final int T27=27;
    public static final int ELSE=8;
    public static final int T26=26;
    public static final int T29=29;
    public static final int ID=4;
    public static final int T28=28;
    public static final int WS=14;
    public static final int EOF=-1;
    public static final int TYPE=5;
    public static final int IF=7;
    public static final int Tokens=34;
    public static final int CHARACTERCONSTANT=13;
    public static final int TRUE=9;
    public static final int FLOATCONSTANT=12;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int INTEGERCONSTANT=6;
    public static final int T33=33;
    public static final int T16=16;
    public static final int FALSE=10;
    public static final int T18=18;
    public static final int T17=17;
    public static final int T19=19;
    public ulNoActionsLexer() {;} 
    public ulNoActionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "ulNoActions.g"; }

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ulNoActions.g:3:5: ( '(' )
            // ulNoActions.g:3:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ulNoActions.g:4:5: ( ')' )
            // ulNoActions.g:4:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ulNoActions.g:5:5: ( '{' )
            // ulNoActions.g:5:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ulNoActions.g:6:5: ( '}' )
            // ulNoActions.g:6:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ulNoActions.g:7:5: ( '[' )
            // ulNoActions.g:7:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ulNoActions.g:8:5: ( ']' )
            // ulNoActions.g:8:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ulNoActions.g:9:5: ( ',' )
            // ulNoActions.g:9:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ulNoActions.g:10:5: ( ';' )
            // ulNoActions.g:10:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ulNoActions.g:11:5: ( '=' )
            // ulNoActions.g:11:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ulNoActions.g:12:5: ( 'while' )
            // ulNoActions.g:12:7: 'while'
            {
            match("while"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ulNoActions.g:13:5: ( 'println' )
            // ulNoActions.g:13:7: 'println'
            {
            match("println"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ulNoActions.g:14:5: ( 'print' )
            // ulNoActions.g:14:7: 'print'
            {
            match("print"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ulNoActions.g:15:5: ( 'return' )
            // ulNoActions.g:15:7: 'return'
            {
            match("return"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ulNoActions.g:16:5: ( '==' )
            // ulNoActions.g:16:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ulNoActions.g:17:5: ( '<' )
            // ulNoActions.g:17:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ulNoActions.g:18:5: ( '+' )
            // ulNoActions.g:18:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ulNoActions.g:19:5: ( '-' )
            // ulNoActions.g:19:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ulNoActions.g:20:5: ( '*' )
            // ulNoActions.g:20:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            // ulNoActions.g:328:7: ( 'true' )
            // ulNoActions.g:328:9: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            // ulNoActions.g:330:7: ( 'false' )
            // ulNoActions.g:330:9: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start TYPE
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            // ulNoActions.g:338:7: ( 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void' )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 'i':
                {
                alt1=1;
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            case 'c':
                {
                alt1=3;
                }
                break;
            case 's':
                {
                alt1=4;
                }
                break;
            case 'b':
                {
                alt1=5;
                }
                break;
            case 'v':
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("338:1: TYPE : ( 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void' );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ulNoActions.g:338:9: 'int'
                    {
                    match("int"); 


                    }
                    break;
                case 2 :
                    // ulNoActions.g:338:17: 'float'
                    {
                    match("float"); 


                    }
                    break;
                case 3 :
                    // ulNoActions.g:338:27: 'char'
                    {
                    match("char"); 


                    }
                    break;
                case 4 :
                    // ulNoActions.g:338:36: 'string'
                    {
                    match("string"); 


                    }
                    break;
                case 5 :
                    // ulNoActions.g:338:47: 'boolean'
                    {
                    match("boolean"); 


                    }
                    break;
                case 6 :
                    // ulNoActions.g:338:59: 'void'
                    {
                    match("void"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TYPE

    // $ANTLR start IF
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            // ulNoActions.g:342:5: ( 'if' )
            // ulNoActions.g:342:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IF

    // $ANTLR start ELSE
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            // ulNoActions.g:345:7: ( 'else' )
            // ulNoActions.g:345:9: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ELSE

    // $ANTLR start CHARACTERCONSTANT
    public final void mCHARACTERCONSTANT() throws RecognitionException {
        try {
            int _type = CHARACTERCONSTANT;
            // ulNoActions.g:348:18: ( '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\\\n' | '0' .. '9' ) '\\'' )
            // ulNoActions.g:348:20: '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\\\n' | '0' .. '9' ) '\\''
            {
            match('\''); 
            // ulNoActions.g:348:25: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\\\n' | '0' .. '9' )
            int alt2=17;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt2=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt2=2;
                }
                break;
            case '_':
                {
                alt2=3;
                }
                break;
            case ' ':
                {
                alt2=4;
                }
                break;
            case '?':
                {
                alt2=5;
                }
                break;
            case '!':
                {
                alt2=6;
                }
                break;
            case '@':
                {
                alt2=7;
                }
                break;
            case '#':
                {
                alt2=8;
                }
                break;
            case '$':
                {
                alt2=9;
                }
                break;
            case '%':
                {
                alt2=10;
                }
                break;
            case '^':
                {
                alt2=11;
                }
                break;
            case '(':
                {
                alt2=12;
                }
                break;
            case ')':
                {
                alt2=13;
                }
                break;
            case '+':
                {
                alt2=14;
                }
                break;
            case '=':
                {
                alt2=15;
                }
                break;
            case '\\':
                {
                alt2=16;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt2=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("348:25: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\\\n' | '0' .. '9' )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ulNoActions.g:348:26: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }
                    break;
                case 2 :
                    // ulNoActions.g:348:37: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }
                    break;
                case 3 :
                    // ulNoActions.g:348:48: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // ulNoActions.g:348:54: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 5 :
                    // ulNoActions.g:348:59: '?'
                    {
                    match('?'); 

                    }
                    break;
                case 6 :
                    // ulNoActions.g:348:65: '!'
                    {
                    match('!'); 

                    }
                    break;
                case 7 :
                    // ulNoActions.g:348:71: '@'
                    {
                    match('@'); 

                    }
                    break;
                case 8 :
                    // ulNoActions.g:348:77: '#'
                    {
                    match('#'); 

                    }
                    break;
                case 9 :
                    // ulNoActions.g:348:83: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 10 :
                    // ulNoActions.g:348:89: '%'
                    {
                    match('%'); 

                    }
                    break;
                case 11 :
                    // ulNoActions.g:348:95: '^'
                    {
                    match('^'); 

                    }
                    break;
                case 12 :
                    // ulNoActions.g:348:101: '('
                    {
                    match('('); 

                    }
                    break;
                case 13 :
                    // ulNoActions.g:348:107: ')'
                    {
                    match(')'); 

                    }
                    break;
                case 14 :
                    // ulNoActions.g:348:113: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 15 :
                    // ulNoActions.g:348:119: '='
                    {
                    match('='); 

                    }
                    break;
                case 16 :
                    // ulNoActions.g:348:125: '\\\\n'
                    {
                    match("\\n"); 


                    }
                    break;
                case 17 :
                    // ulNoActions.g:348:134: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }
                    break;

            }

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CHARACTERCONSTANT

    // $ANTLR start STRINGCONSTANT
    public final void mSTRINGCONSTANT() throws RecognitionException {
        try {
            int _type = STRINGCONSTANT;
            // ulNoActions.g:351:15: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' | '\\'' | '0' .. '9' )* '\"' )
            // ulNoActions.g:351:17: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' | '\\'' | '0' .. '9' )* '\"'
            {
            match('\"'); 
            // ulNoActions.g:351:21: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ' ' | '?' | '!' | '@' | '#' | '$' | '%' | '^' | '(' | ')' | '+' | '=' | '\\n' | '\\'' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\n'||(LA3_0>=' ' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='%')||(LA3_0>='\'' && LA3_0<=')')||LA3_0=='+'||(LA3_0>='0' && LA3_0<='9')||LA3_0=='='||(LA3_0>='?' && LA3_0<='Z')||(LA3_0>='^' && LA3_0<='_')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ulNoActions.g:
            	    {
            	    if ( input.LA(1)=='\n'||(input.LA(1)>=' ' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='%')||(input.LA(1)>='\'' && input.LA(1)<=')')||input.LA(1)=='+'||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='='||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRINGCONSTANT

    // $ANTLR start INTEGERCONSTANT
    public final void mINTEGERCONSTANT() throws RecognitionException {
        try {
            int _type = INTEGERCONSTANT;
            // ulNoActions.g:354:16: ( ( '0' .. '9' )+ )
            // ulNoActions.g:354:18: ( '0' .. '9' )+
            {
            // ulNoActions.g:354:18: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ulNoActions.g:354:19: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTEGERCONSTANT

    // $ANTLR start FLOATCONSTANT
    public final void mFLOATCONSTANT() throws RecognitionException {
        try {
            int _type = FLOATCONSTANT;
            // ulNoActions.g:357:14: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // ulNoActions.g:357:16: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // ulNoActions.g:357:16: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ulNoActions.g:357:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('.'); 
            // ulNoActions.g:357:30: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ulNoActions.g:357:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOATCONSTANT

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // ulNoActions.g:360:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ulNoActions.g:360:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ulNoActions.g:360:35: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ulNoActions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // ulNoActions.g:364:9: ( ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+ )
            // ulNoActions.g:364:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
            {
            // ulNoActions.g:364:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ulNoActions.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             channel = HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // ulNoActions.g:367:9: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' | EOF ) )
            // ulNoActions.g:367:11: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' | EOF )
            {
            match("//"); 

            // ulNoActions.g:367:16: (~ ( '\\r' | '\\n' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ulNoActions.g:367:16: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ulNoActions.g:367:32: ( '\\r' | '\\n' | EOF )
            int alt10=3;
            switch ( input.LA(1) ) {
            case '\r':
                {
                alt10=1;
                }
                break;
            case '\n':
                {
                alt10=2;
                }
                break;
            default:
                alt10=3;}

            switch (alt10) {
                case 1 :
                    // ulNoActions.g:367:33: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 2 :
                    // ulNoActions.g:367:40: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // ulNoActions.g:367:47: EOF
                    {
                    match(EOF); 

                    }
                    break;

            }

             channel = HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    public void mTokens() throws RecognitionException {
        // ulNoActions.g:1:8: ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | TRUE | FALSE | TYPE | IF | ELSE | CHARACTERCONSTANT | STRINGCONSTANT | INTEGERCONSTANT | FLOATCONSTANT | ID | WS | COMMENT )
        int alt11=30;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // ulNoActions.g:1:10: T16
                {
                mT16(); 

                }
                break;
            case 2 :
                // ulNoActions.g:1:14: T17
                {
                mT17(); 

                }
                break;
            case 3 :
                // ulNoActions.g:1:18: T18
                {
                mT18(); 

                }
                break;
            case 4 :
                // ulNoActions.g:1:22: T19
                {
                mT19(); 

                }
                break;
            case 5 :
                // ulNoActions.g:1:26: T20
                {
                mT20(); 

                }
                break;
            case 6 :
                // ulNoActions.g:1:30: T21
                {
                mT21(); 

                }
                break;
            case 7 :
                // ulNoActions.g:1:34: T22
                {
                mT22(); 

                }
                break;
            case 8 :
                // ulNoActions.g:1:38: T23
                {
                mT23(); 

                }
                break;
            case 9 :
                // ulNoActions.g:1:42: T24
                {
                mT24(); 

                }
                break;
            case 10 :
                // ulNoActions.g:1:46: T25
                {
                mT25(); 

                }
                break;
            case 11 :
                // ulNoActions.g:1:50: T26
                {
                mT26(); 

                }
                break;
            case 12 :
                // ulNoActions.g:1:54: T27
                {
                mT27(); 

                }
                break;
            case 13 :
                // ulNoActions.g:1:58: T28
                {
                mT28(); 

                }
                break;
            case 14 :
                // ulNoActions.g:1:62: T29
                {
                mT29(); 

                }
                break;
            case 15 :
                // ulNoActions.g:1:66: T30
                {
                mT30(); 

                }
                break;
            case 16 :
                // ulNoActions.g:1:70: T31
                {
                mT31(); 

                }
                break;
            case 17 :
                // ulNoActions.g:1:74: T32
                {
                mT32(); 

                }
                break;
            case 18 :
                // ulNoActions.g:1:78: T33
                {
                mT33(); 

                }
                break;
            case 19 :
                // ulNoActions.g:1:82: TRUE
                {
                mTRUE(); 

                }
                break;
            case 20 :
                // ulNoActions.g:1:87: FALSE
                {
                mFALSE(); 

                }
                break;
            case 21 :
                // ulNoActions.g:1:93: TYPE
                {
                mTYPE(); 

                }
                break;
            case 22 :
                // ulNoActions.g:1:98: IF
                {
                mIF(); 

                }
                break;
            case 23 :
                // ulNoActions.g:1:101: ELSE
                {
                mELSE(); 

                }
                break;
            case 24 :
                // ulNoActions.g:1:106: CHARACTERCONSTANT
                {
                mCHARACTERCONSTANT(); 

                }
                break;
            case 25 :
                // ulNoActions.g:1:124: STRINGCONSTANT
                {
                mSTRINGCONSTANT(); 

                }
                break;
            case 26 :
                // ulNoActions.g:1:139: INTEGERCONSTANT
                {
                mINTEGERCONSTANT(); 

                }
                break;
            case 27 :
                // ulNoActions.g:1:155: FLOATCONSTANT
                {
                mFLOATCONSTANT(); 

                }
                break;
            case 28 :
                // ulNoActions.g:1:169: ID
                {
                mID(); 

                }
                break;
            case 29 :
                // ulNoActions.g:1:172: WS
                {
                mWS(); 

                }
                break;
            case 30 :
                // ulNoActions.g:1:175: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\11\uffff\1\40\3\34\4\uffff\10\34\2\uffff\1\56\5\uffff\7\34\1\67"+
        "\5\34\2\uffff\6\34\1\103\1\uffff\10\34\1\114\2\34\1\uffff\1\103"+
        "\2\34\1\103\1\121\1\122\1\124\1\34\1\uffff\1\126\1\103\2\34\2\uffff"+
        "\1\34\1\uffff\1\132\1\uffff\1\103\1\34\1\134\1\uffff\1\103\1\uffff";
    static final String DFA11_eofS =
        "\135\uffff";
    static final String DFA11_minS =
        "\1\11\10\uffff\1\75\1\150\1\162\1\145\4\uffff\1\162\1\141\1\146"+
        "\1\150\1\164\2\157\1\154\2\uffff\1\56\5\uffff\2\151\1\164\1\165"+
        "\1\154\1\157\1\164\1\60\1\141\1\162\1\157\1\151\1\163\2\uffff\1"+
        "\154\1\156\1\165\1\145\1\163\1\141\1\60\1\uffff\1\162\1\151\1\154"+
        "\1\144\2\145\1\164\1\162\1\60\1\145\1\164\1\uffff\1\60\1\156\1\145"+
        "\4\60\1\156\1\uffff\2\60\1\147\1\141\2\uffff\1\156\1\uffff\1\60"+
        "\1\uffff\1\60\1\156\1\60\1\uffff\1\60\1\uffff";
    static final String DFA11_maxS =
        "\1\175\10\uffff\1\75\1\150\1\162\1\145\4\uffff\1\162\1\154\1\156"+
        "\1\150\1\164\2\157\1\154\2\uffff\1\71\5\uffff\2\151\1\164\1\165"+
        "\1\154\1\157\1\164\1\172\1\141\1\162\1\157\1\151\1\163\2\uffff\1"+
        "\154\1\156\1\165\1\145\1\163\1\141\1\172\1\uffff\1\162\1\151\1\154"+
        "\1\144\2\145\1\164\1\162\1\172\1\145\1\164\1\uffff\1\172\1\156\1"+
        "\145\4\172\1\156\1\uffff\2\172\1\147\1\141\2\uffff\1\156\1\uffff"+
        "\1\172\1\uffff\1\172\1\156\1\172\1\uffff\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\4\uffff\1\17\1\20\1\21"+
        "\1\22\10\uffff\1\30\1\31\1\uffff\1\34\1\35\1\36\1\16\1\11\15\uffff"+
        "\1\32\1\33\7\uffff\1\26\13\uffff\1\25\10\uffff\1\23\4\uffff\1\27"+
        "\1\12\1\uffff\1\14\1\uffff\1\24\3\uffff\1\15\1\uffff\1\13";
    static final String DFA11_specialS =
        "\135\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\35\2\uffff\1\35\22\uffff\1\35\1\uffff\1\32\4\uffff\1\31\1"+
            "\1\1\2\1\20\1\16\1\7\1\17\1\uffff\1\36\12\33\1\uffff\1\10\1"+
            "\15\1\11\3\uffff\32\34\1\5\1\uffff\1\6\1\uffff\1\34\1\uffff"+
            "\1\34\1\26\1\24\1\34\1\30\1\22\2\34\1\23\6\34\1\13\1\34\1\14"+
            "\1\25\1\21\1\34\1\27\1\12\3\34\1\3\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\41",
            "\1\42",
            "\1\43",
            "",
            "",
            "",
            "",
            "\1\44",
            "\1\45\12\uffff\1\46",
            "\1\50\7\uffff\1\47",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "\1\57\1\uffff\12\33",
            "",
            "",
            "",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\115",
            "\1\116",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\117",
            "\1\120",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\13\34\1\123\16\34",
            "\1\125",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\127",
            "\1\130",
            "",
            "",
            "\1\131",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\133",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | TRUE | FALSE | TYPE | IF | ELSE | CHARACTERCONSTANT | STRINGCONSTANT | INTEGERCONSTANT | FLOATCONSTANT | ID | WS | COMMENT );";
        }
    }
 

}