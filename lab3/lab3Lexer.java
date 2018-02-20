// $ANTLR 3.0.1 lab3.g 2018-01-20 13:01:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class lab3Lexer extends Lexer {
    public static final int WS=6;
    public static final int T10=10;
    public static final int T11=11;
    public static final int INT=5;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T8=8;
    public static final int T14=14;
    public static final int T9=9;
    public static final int T15=15;
    public static final int ID=4;
    public static final int COMMENT=7;
    public static final int Tokens=16;
    public static final int EOF=-1;
    public lab3Lexer() {;} 
    public lab3Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "lab3.g"; }

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // lab3.g:3:4: ( '=' )
            // lab3.g:3:6: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T8

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // lab3.g:4:4: ( ';' )
            // lab3.g:4:6: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // lab3.g:5:5: ( 'output' )
            // lab3.g:5:7: 'output'
            {
            match("output"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // lab3.g:6:5: ( '+' )
            // lab3.g:6:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // lab3.g:7:5: ( '-' )
            // lab3.g:7:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // lab3.g:8:5: ( '*' )
            // lab3.g:8:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // lab3.g:9:5: ( '(' )
            // lab3.g:9:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // lab3.g:10:5: ( ')' )
            // lab3.g:10:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // lab3.g:63:9: ( ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )+ )
            // lab3.g:63:11: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )+
            {
            // lab3.g:63:11: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='A' && LA1_0<='Z')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // lab3.g:63:12: ( 'a' .. 'z' )
            	    {
            	    // lab3.g:63:12: ( 'a' .. 'z' )
            	    // lab3.g:63:13: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // lab3.g:63:23: ( 'A' .. 'Z' )
            	    {
            	    // lab3.g:63:23: ( 'A' .. 'Z' )
            	    // lab3.g:63:24: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // lab3.g:65:9: ( ( '-' )? ( '0' | ( '1' .. '9' ( '0' .. '9' )* ) ) )
            // lab3.g:65:11: ( '-' )? ( '0' | ( '1' .. '9' ( '0' .. '9' )* ) )
            {
            // lab3.g:65:11: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // lab3.g:65:11: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // lab3.g:65:16: ( '0' | ( '1' .. '9' ( '0' .. '9' )* ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("65:16: ( '0' | ( '1' .. '9' ( '0' .. '9' )* ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // lab3.g:65:17: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // lab3.g:65:23: ( '1' .. '9' ( '0' .. '9' )* )
                    {
                    // lab3.g:65:23: ( '1' .. '9' ( '0' .. '9' )* )
                    // lab3.g:65:24: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // lab3.g:65:32: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // lab3.g:65:33: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // lab3.g:67:9: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
            // lab3.g:67:11: ( '\\t' | ' ' | '\\r' | '\\n' )+
            {
            // lab3.g:67:11: ( '\\t' | ' ' | '\\r' | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // lab3.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

             channel = HIDDEN; skip();

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
            // lab3.g:69:9: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' ) )
            // lab3.g:69:11: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' )
            {
            match("//"); 

            // lab3.g:69:16: (~ ( '\\r' | '\\n' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // lab3.g:69:16: ~ ( '\\r' | '\\n' )
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
            	    break loop6;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
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
        // lab3.g:1:8: ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | ID | INT | WS | COMMENT )
        int alt7=12;
        switch ( input.LA(1) ) {
        case '=':
            {
            alt7=1;
            }
            break;
        case ';':
            {
            alt7=2;
            }
            break;
        case 'o':
            {
            int LA7_3 = input.LA(2);

            if ( (LA7_3=='u') ) {
                int LA7_13 = input.LA(3);

                if ( (LA7_13=='t') ) {
                    int LA7_15 = input.LA(4);

                    if ( (LA7_15=='p') ) {
                        int LA7_16 = input.LA(5);

                        if ( (LA7_16=='u') ) {
                            int LA7_17 = input.LA(6);

                            if ( (LA7_17=='t') ) {
                                int LA7_18 = input.LA(7);

                                if ( ((LA7_18>='A' && LA7_18<='Z')||(LA7_18>='a' && LA7_18<='z')) ) {
                                    alt7=9;
                                }
                                else {
                                    alt7=3;}
                            }
                            else {
                                alt7=9;}
                        }
                        else {
                            alt7=9;}
                    }
                    else {
                        alt7=9;}
                }
                else {
                    alt7=9;}
            }
            else {
                alt7=9;}
            }
            break;
        case '+':
            {
            alt7=4;
            }
            break;
        case '-':
            {
            int LA7_5 = input.LA(2);

            if ( ((LA7_5>='0' && LA7_5<='9')) ) {
                alt7=10;
            }
            else {
                alt7=5;}
            }
            break;
        case '*':
            {
            alt7=6;
            }
            break;
        case '(':
            {
            alt7=7;
            }
            break;
        case ')':
            {
            alt7=8;
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
            alt7=9;
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
            alt7=10;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt7=11;
            }
            break;
        case '/':
            {
            alt7=12;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | ID | INT | WS | COMMENT );", 7, 0, input);

            throw nvae;
        }

        switch (alt7) {
            case 1 :
                // lab3.g:1:10: T8
                {
                mT8(); 

                }
                break;
            case 2 :
                // lab3.g:1:13: T9
                {
                mT9(); 

                }
                break;
            case 3 :
                // lab3.g:1:16: T10
                {
                mT10(); 

                }
                break;
            case 4 :
                // lab3.g:1:20: T11
                {
                mT11(); 

                }
                break;
            case 5 :
                // lab3.g:1:24: T12
                {
                mT12(); 

                }
                break;
            case 6 :
                // lab3.g:1:28: T13
                {
                mT13(); 

                }
                break;
            case 7 :
                // lab3.g:1:32: T14
                {
                mT14(); 

                }
                break;
            case 8 :
                // lab3.g:1:36: T15
                {
                mT15(); 

                }
                break;
            case 9 :
                // lab3.g:1:40: ID
                {
                mID(); 

                }
                break;
            case 10 :
                // lab3.g:1:43: INT
                {
                mINT(); 

                }
                break;
            case 11 :
                // lab3.g:1:47: WS
                {
                mWS(); 

                }
                break;
            case 12 :
                // lab3.g:1:50: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


 

}