/* Generated By:JavaCC: Do not edit this line. CommandParser.java */
package com.chord.console.parser;

import java.io.StringReader;

/**
 * @author sven
 * @version 1.0.5
 */
public class CommandParser implements CommandParserConstants {

    static private int[] jj_la1_0;

    static {
        jj_la1_0();
    }

    final private int[] jj_la1 = new int[0];
    final private JJCalls[] jj_2_rtns = new JJCalls[10];
    final private LookaheadSuccess jj_ls = new LookaheadSuccess();
    public CommandParserTokenManager token_source;
    public Token token;
    public Token jj_nt;
    public boolean lookingAhead = false;
    SimpleCharStream jj_input_stream;
    private Token jj_scanpos;
    private Token jj_lastpos;
    private int jj_la;
    private int jj_gen;
    private boolean jj_rescan = false;
    private int jj_gc = 0;
    private final java.util.Vector jj_expentries = new java.util.Vector();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private final int[] jj_lasttokens = new int[100];
    private int jj_endpos;

    public CommandParser(java.io.InputStream stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new CommandParserTokenManager(jj_input_stream);
        token = new Token();
        //jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++)
            jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();
    }

    public CommandParser(java.io.Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new CommandParserTokenManager(jj_input_stream);
        token = new Token();
        //jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++)
            jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();
    }

    public CommandParser(CommandParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        //jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++)
            jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();
    }

    public static String parse(String toParse) throws ParseException {
        StringReader reader = new StringReader(toParse);
        CommandParser parser = new CommandParser(reader);
        String command = parser.command();
        return command;
    }

    public static java.util.Map<String, String> parseParams(String toParse)
            throws ParseException {
        StringReader reader = new StringReader(toParse);
        CommandParser parser = new CommandParser(reader);
        return parser.parameters();
    }

    private static void jj_la1_0() {
        jj_la1_0 = new int[]{};
    }

    final public String command() throws ParseException {
        String commandName = "";
        Token token;
        if (jj_2_4(3)) {
            token = jj_consume_token(WORD);
            label_1:
            while (true) {
                if (jj_2_1(3)) {
                    jj_consume_token(PARAMSTART);
                    jj_consume_token(WORD);
                    jj_consume_token(WORD);
                } else if (jj_2_2(3)) {
                    jj_consume_token(PARAMSTART);
                    jj_consume_token(WORD);
                } else {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                if (jj_2_3(3)) {
                    // nothing to do
                } else {
                    break label_1;
                }
            }
            commandName = token.image;
            {
                if (true)
                    return commandName;
            }
        } else if (jj_2_5(3)) {
            token = jj_consume_token(WORD);
            commandName = token.image;
            {
                if (true)
                    return commandName;
            }
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
        throw new Error("Missing return statement in function");
    }

    //private int jj_ntk;

    final public java.util.Map<String, String> parameters()
            throws ParseException {
        java.util.Map<String, String> p = new java.util.HashMap<String, String>();
        int index = 0;
        String[][] ps = new String[100][2];
        Token t;
        if (jj_2_9(3)) {
            t = jj_consume_token(WORD);
            label_2:
            while (true) {
                if (jj_2_6(3)) {
                    jj_consume_token(PARAMSTART);
                    t = jj_consume_token(WORD);
                    ps[index][0] = t.image;
                    t = jj_consume_token(WORD);
                    ps[index++][1] = t.image;
                } else if (jj_2_7(3)) {
                    jj_consume_token(PARAMSTART);
                    t = jj_consume_token(WORD);
                    ps[index++][0] = t.image;
                } else {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                if (jj_2_8(3)) {
                    //nothing to do;
                } else {
                    break label_2;
                }
            }
            for (int i = 0; i < index; i++) {
                String pn = ps[i][0];
                String pv = "";
                if (ps[i][1] != null) {
                    pv = ps[i][1];
                }
                p.put(pn, pv);
            }
            {
                if (true)
                    return p;
            }
        } else if (jj_2_10(3)) {
            t = jj_consume_token(WORD);
            {
                if (true)
                    return p;
            }
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
        throw new Error("Missing return statement in function");
    }

    final private boolean jj_2_1(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_1();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(0, xla);
        }
    }

    final private boolean jj_2_2(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(1, xla);
        }
    }

    final private boolean jj_2_3(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_3();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(2, xla);
        }
    }

    //private boolean jj_semLA;

    final private boolean jj_2_4(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_4();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(3, xla);
        }
    }

    final private boolean jj_2_5(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_5();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(4, xla);
        }
    }

    final private boolean jj_2_6(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_6();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(5, xla);
        }
    }

    final private boolean jj_2_7(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_7();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(6, xla);
        }
    }

    final private boolean jj_2_8(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_8();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(7, xla);
        }
    }

    final private boolean jj_2_9(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_9();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(8, xla);
        }
    }

    final private boolean jj_2_10(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_10();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(9, xla);
        }
    }

    final private boolean jj_3_7() {
        if (jj_scan_token(PARAMSTART))
            return true;
        return jj_scan_token(WORD);
    }

    final private boolean jj_3_5() {
        return jj_scan_token(WORD);
    }

    final private boolean jj_3_4() {
        if (jj_scan_token(WORD))
            return true;
        Token xsp;
        if (jj_3_3())
            return true;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_3()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    final private boolean jj_3_6() {
        if (jj_scan_token(PARAMSTART))
            return true;
        if (jj_scan_token(WORD))
            return true;
        return jj_scan_token(WORD);
    }

    final private boolean jj_3_8() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_6()) {
            jj_scanpos = xsp;
            return jj_3_7();
        }
        return false;
    }

    final private boolean jj_3_2() {
        if (jj_scan_token(PARAMSTART))
            return true;
        return jj_scan_token(WORD);
    }

    final private boolean jj_3_10() {
        return jj_scan_token(WORD);
    }

    final private boolean jj_3_9() {
        if (jj_scan_token(WORD))
            return true;
        Token xsp;
        if (jj_3_8())
            return true;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_8()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

    final private boolean jj_3_1() {
        if (jj_scan_token(PARAMSTART))
            return true;
        if (jj_scan_token(WORD))
            return true;
        return jj_scan_token(WORD);
    }

    final private boolean jj_3_3() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_1()) {
            jj_scanpos = xsp;
            return jj_3_2();
        }
        return false;
    }

    public void ReInit(java.io.InputStream stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        //jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++)
            jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();
    }

    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        //jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++)
            jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();
    }

    public void ReInit(CommandParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        //jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++)
            jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();
    }

//	final private int jj_ntk() {
//		if ((jj_nt = token.next) == null)
//			return (jj_ntk = (token.next = token_source.getNextToken()).kind);
//		else
//			return (jj_ntk = jj_nt.kind);
//	}

    final private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        //jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            if (++jj_gc > 100) {
                jj_gc = 0;
                for (int i = 0; i < jj_2_rtns.length; i++) {
                    JJCalls c = jj_2_rtns[i];
                    while (c != null) {
                        if (c.gen < jj_gen)
                            c.first = null;
                        c = c.next;
                    }
                }
            }
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    final private boolean jj_scan_token(int kind) {
        if (jj_scanpos == jj_lastpos) {
            jj_la--;
            if (jj_scanpos.next == null) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source
                        .getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if (jj_rescan) {
            int i = 0;
            Token tok = token;
            while (tok != null && tok != jj_scanpos) {
                i++;
                tok = tok.next;
            }
            if (tok != null)
                jj_add_error_token(kind, i);
        }
        if (jj_scanpos.kind != kind)
            return true;
        if (jj_la == 0 && jj_scanpos == jj_lastpos)
            throw jj_ls;
        return false;
    }

    final public Token getNextToken() {
        if (token.next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        //jj_ntk = -1;
        jj_gen++;
        return token;
    }

    final public Token getToken(int index) {
        Token t = lookingAhead ? jj_scanpos : token;
        for (int i = 0; i < index; i++) {
            if (t.next != null)
                t = t.next;
            else
                t = t.next = token_source.getNextToken();
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    private void jj_add_error_token(int kind, int pos) {
        if (pos >= 100)
            return;
        if (pos == jj_endpos + 1) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if (jj_endpos != 0) {
            jj_expentry = new int[jj_endpos];
            for (int i = 0; i < jj_endpos; i++) {
                jj_expentry[i] = jj_lasttokens[i];
            }
            boolean exists = false;
            for (java.util.Enumeration e = jj_expentries.elements(); e
                    .hasMoreElements(); ) {
                int[] oldentry = (int[]) (e.nextElement());
                if (oldentry.length == jj_expentry.length) {
                    exists = true;
                    for (int i = 0; i < jj_expentry.length; i++) {
                        if (oldentry[i] != jj_expentry[i]) {
                            exists = false;
                            break;
                        }
                    }
                    if (exists)
                        break;
                }
            }
            if (!exists)
                jj_expentries.addElement(jj_expentry);
            if (pos != 0)
                jj_lasttokens[(jj_endpos = pos) - 1] = kind;
        }
    }

    @SuppressWarnings("unchecked")
    public ParseException generateParseException() {
        jj_expentries.removeAllElements();
        boolean[] la1tokens = new boolean[8];
        for (int i = 0; i < 8; i++) {
            la1tokens[i] = false;
        }
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 0; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.addElement(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = (int[]) jj_expentries.elementAt(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    final public void enable_tracing() {
    }

    final public void disable_tracing() {
    }

    final private void jj_rescan_token() {
        jj_rescan = true;
        for (int i = 0; i < 10; i++) {
            JJCalls p = jj_2_rtns[i];
            do {
                if (p.gen > jj_gen) {
                    jj_la = p.arg;
                    jj_lastpos = jj_scanpos = p.first;
                    switch (i) {
                        case 0:
                            jj_3_1();
                            break;
                        case 1:
                            jj_3_2();
                            break;
                        case 2:
                            jj_3_3();
                            break;
                        case 3:
                            jj_3_4();
                            break;
                        case 4:
                            jj_3_5();
                            break;
                        case 5:
                            jj_3_6();
                            break;
                        case 6:
                            jj_3_7();
                            break;
                        case 7:
                            jj_3_8();
                            break;
                        case 8:
                            jj_3_9();
                            break;
                        case 9:
                            jj_3_10();
                            break;
                    }
                }
                p = p.next;
            } while (p != null);
        }
        jj_rescan = false;
    }

    final private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while (p.gen > jj_gen) {
            if (p.next == null) {
                p = p.next = new JJCalls();
                break;
            }
            p = p.next;
        }
        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

    static private final class LookaheadSuccess extends java.lang.Error {

        /**
         *
         */
        private static final long serialVersionUID = 3684319387114139017L;
    }

    /**
     * @author karsten
     */
    static final class JJCalls {
        int gen;

        Token first;

        int arg;

        JJCalls next;
    }

}
