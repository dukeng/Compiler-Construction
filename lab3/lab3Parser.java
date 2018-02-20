// $ANTLR 3.0.1 lab3.g 2018-01-20 13:01:59

        import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class lab3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "COMMENT", "'='", "';'", "'output'", "'+'", "'-'", "'*'", "'('", "')'"
    };
    public static final int WS=6;
    public static final int INT=5;
    public static final int COMMENT=7;
    public static final int ID=4;
    public static final int EOF=-1;

        public lab3Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "lab3.g"; }


            HashMap memory = new HashMap();



    // $ANTLR start program
    // lab3.g:11:1: program : ( statement )+ EOF ;
    public final void program() throws RecognitionException {
        try {
            // lab3.g:11:9: ( ( statement )+ EOF )
            // lab3.g:12:9: ( statement )+ EOF
            {
            // lab3.g:12:9: ( statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // lab3.g:12:9: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program30);
            	    statement();
            	    _fsp--;


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

            match(input,EOF,FOLLOW_EOF_in_program33); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end program


    // $ANTLR start statement
    // lab3.g:15:1: statement : ( id '=' expr ';' | 'output' expr ';' );
    public final void statement() throws RecognitionException {
        id_return id1 = null;

        int expr2 = 0;

        int expr3 = 0;


        try {
            // lab3.g:15:11: ( id '=' expr ';' | 'output' expr ';' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==10) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("15:1: statement : ( id '=' expr ';' | 'output' expr ';' );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // lab3.g:16:9: id '=' expr ';'
                    {
                    pushFollow(FOLLOW_id_in_statement58);
                    id1=id();
                    _fsp--;

                    match(input,8,FOLLOW_8_in_statement60); 
                    pushFollow(FOLLOW_expr_in_statement62);
                    expr2=expr();
                    _fsp--;

                    match(input,9,FOLLOW_9_in_statement64); 

                                    memory.put(input.toString(id1.start,id1.stop), new Integer(expr2));
                            

                    }
                    break;
                case 2 :
                    // lab3.g:19:11: 'output' expr ';'
                    {
                    match(input,10,FOLLOW_10_in_statement78); 
                    pushFollow(FOLLOW_expr_in_statement80);
                    expr3=expr();
                    _fsp--;

                    match(input,9,FOLLOW_9_in_statement82); 

                                    System.out.println("Our expression is "+expr3);
                                    System.out.println("Uh, Houston, we've had an expression");
                            

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end statement


    // $ANTLR start expr
    // lab3.g:25:1: expr returns [int value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
    public final int expr() throws RecognitionException {
        int value = 0;

        int e = 0;


        try {
            // lab3.g:25:25: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
            // lab3.g:26:9: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_expr116);
            e=multExpr();
            _fsp--;

             value = e; 
            // lab3.g:27:17: ( '+' e= multExpr | '-' e= multExpr )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }
                else if ( (LA3_0==12) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // lab3.g:28:25: '+' e= multExpr
            	    {
            	    match(input,11,FOLLOW_11_in_expr162); 
            	    pushFollow(FOLLOW_multExpr_in_expr168);
            	    e=multExpr();
            	    _fsp--;

            	     value += e; 

            	    }
            	    break;
            	case 2 :
            	    // lab3.g:29:25: '-' e= multExpr
            	    {
            	    match(input,12,FOLLOW_12_in_expr196); 
            	    pushFollow(FOLLOW_multExpr_in_expr202);
            	    e=multExpr();
            	    _fsp--;

            	     value += e; 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end expr


    // $ANTLR start multExpr
    // lab3.g:33:1: multExpr returns [int value] : e= atom ( '*' atom )* ;
    public final int multExpr() throws RecognitionException {
        int value = 0;

        int e = 0;


        try {
            // lab3.g:33:30: (e= atom ( '*' atom )* )
            // lab3.g:34:9: e= atom ( '*' atom )*
            {
            pushFollow(FOLLOW_atom_in_multExpr256);
            e=atom();
            _fsp--;


                            value = e;
                    
            // lab3.g:36:11: ( '*' atom )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // lab3.g:36:12: '*' atom
            	    {
            	    match(input,13,FOLLOW_13_in_multExpr261); 
            	    pushFollow(FOLLOW_atom_in_multExpr263);
            	    atom();
            	    _fsp--;


            	                    value *= e;
            	            

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end multExpr


    // $ANTLR start atom
    // lab3.g:41:1: atom returns [int value] : ( id | intLit | '(' expr ')' );
    public final int atom() throws RecognitionException {
        int value = 0;

        id_return id4 = null;

        int intLit5 = 0;

        int expr6 = 0;


        try {
            // lab3.g:41:26: ( id | intLit | '(' expr ')' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt5=1;
                }
                break;
            case INT:
                {
                alt5=2;
                }
                break;
            case 14:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("41:1: atom returns [int value] : ( id | intLit | '(' expr ')' );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // lab3.g:42:9: id
                    {
                    pushFollow(FOLLOW_id_in_atom296);
                    id4=id();
                    _fsp--;


                                    Integer v = (Integer)memory.get(input.toString(id4.start,id4.stop));
                                    if (v!=null) value = v.intValue();
                                    else System.err.println("undefined variable "+input.toString(id4.start,id4.stop));
                            

                    }
                    break;
                case 2 :
                    // lab3.g:47:11: intLit
                    {
                    pushFollow(FOLLOW_intLit_in_atom310);
                    intLit5=intLit();
                    _fsp--;


                                    value = intLit5;
                            

                    }
                    break;
                case 3 :
                    // lab3.g:50:11: '(' expr ')'
                    {
                    match(input,14,FOLLOW_14_in_atom324); 
                    pushFollow(FOLLOW_expr_in_atom326);
                    expr6=expr();
                    _fsp--;

                    match(input,15,FOLLOW_15_in_atom328); 

                                    value = expr6;
                            

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end atom

    public static class id_return extends ParserRuleReturnScope {
    };

    // $ANTLR start id
    // lab3.g:55:1: id : ID ;
    public final id_return id() throws RecognitionException {
        id_return retval = new id_return();
        retval.start = input.LT(1);

        try {
            // lab3.g:55:9: ( ID )
            // lab3.g:55:11: ID
            {
            match(input,ID,FOLLOW_ID_in_id352); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end id


    // $ANTLR start intLit
    // lab3.g:57:1: intLit returns [int value] : INT ;
    public final int intLit() throws RecognitionException {
        int value = 0;

        Token INT7=null;

        try {
            // lab3.g:57:28: ( INT )
            // lab3.g:58:9: INT
            {
            INT7=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_intLit373); 
             value = Integer.parseInt(INT7.getText()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end intLit


 

    public static final BitSet FOLLOW_statement_in_program30 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_EOF_in_program33 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_statement58 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_statement60 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_expr_in_statement62 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_statement64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_statement78 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_expr_in_statement80 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_statement82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr116 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_expr162 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_multExpr_in_expr168 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_12_in_expr196 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_multExpr_in_expr202 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_atom_in_multExpr256 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_multExpr261 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_atom_in_multExpr263 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_id_in_atom296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intLit_in_atom310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_atom324 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_expr_in_atom326 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_atom328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_id352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_intLit373 = new BitSet(new long[]{0x0000000000000002L});

}