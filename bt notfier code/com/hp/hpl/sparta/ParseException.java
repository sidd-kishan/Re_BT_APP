/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.ParseCharStream
 *  com.hp.hpl.sparta.ParseLog
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.ParseCharStream;
import com.hp.hpl.sparta.ParseLog;

public class ParseException
extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    public ParseException(ParseCharStream parseCharStream, char c, char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("got '");
        stringBuffer.append(c);
        stringBuffer.append("' instead of expected '");
        stringBuffer.append(c2);
        stringBuffer.append("'");
        this(parseCharStream, stringBuffer.toString());
    }

    public ParseException(ParseCharStream parseCharStream, char c, String string) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("got '");
        stringBuffer.append(c);
        stringBuffer.append("' instead of ");
        stringBuffer.append(string);
        stringBuffer.append(" as expected");
        this(parseCharStream, stringBuffer.toString());
    }

    public ParseException(ParseCharStream parseCharStream, char c, char[] cArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("got '");
        stringBuffer.append(c);
        stringBuffer.append("' instead of ");
        stringBuffer.append(ParseException.toString(cArray));
        this(parseCharStream, stringBuffer.toString());
    }

    public ParseException(ParseCharStream parseCharStream, String string) {
        this(parseCharStream.getLog(), parseCharStream.getSystemId(), parseCharStream.getLineNumber(), parseCharStream.getLastCharRead(), parseCharStream.getHistory(), string);
    }

    public ParseException(ParseCharStream parseCharStream, String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("got \"");
        stringBuffer.append(string);
        stringBuffer.append("\" instead of \"");
        stringBuffer.append(string2);
        stringBuffer.append("\" as expected");
        this(parseCharStream, stringBuffer.toString());
    }

    public ParseException(ParseCharStream parseCharStream, String string, char[] cArray) {
        this(parseCharStream, string, new String(cArray));
    }

    public ParseException(ParseLog parseLog, String string, int n, int n2, String string2, String string3) {
        this(string, n, n2, string2, string3);
        parseLog.error(string3, string, n);
    }

    public ParseException(String string) {
        super(string);
        this.lineNumber_ = -1;
        this.cause_ = null;
    }

    public ParseException(String string, int n, int n2, String string2, String string3) {
        super(ParseException.toMessage(string, n, n2, string2, string3));
        this.lineNumber_ = -1;
        this.cause_ = null;
        this.lineNumber_ = n;
    }

    public ParseException(String string, Throwable throwable) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(" ");
        stringBuffer.append(throwable);
        super(stringBuffer.toString());
        this.lineNumber_ = -1;
        this.cause_ = null;
        this.cause_ = throwable;
    }

    static String charRepr(int n) {
        CharSequence charSequence;
        if (n == -1) {
            charSequence = "EOF";
        } else {
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("");
            ((StringBuffer)charSequence).append((char)n);
            charSequence = ((StringBuffer)charSequence).toString();
        }
        return charSequence;
    }

    private static String toMessage(String string, int n, int n2, String string2, String string3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append("(");
        stringBuffer.append(n);
        stringBuffer.append("): \n");
        stringBuffer.append(string2);
        stringBuffer.append("\nLast character read was '");
        stringBuffer.append(ParseException.charRepr(n2));
        stringBuffer.append("'\n");
        stringBuffer.append(string3);
        return stringBuffer.toString();
    }

    private static String toString(char[] cArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArray[0]);
        int n = 1;
        while (n < cArray.length) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("or ");
            stringBuffer2.append(cArray[n]);
            stringBuffer.append(stringBuffer2.toString());
            ++n;
        }
        return stringBuffer.toString();
    }

    @Override
    public Throwable getCause() {
        return this.cause_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }
}
