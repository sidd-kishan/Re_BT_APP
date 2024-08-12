/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.SimpleStreamTokenizer
 *  com.hp.hpl.sparta.xpath.XPath
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.SimpleStreamTokenizer;
import com.hp.hpl.sparta.xpath.XPath;
import java.io.IOException;

public class XPathException
extends Exception {
    private Throwable cause_;

    XPathException(XPath xPath, Exception exception) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xPath);
        stringBuffer.append(" ");
        stringBuffer.append(exception);
        super(stringBuffer.toString());
        this.cause_ = null;
        this.cause_ = exception;
    }

    public XPathException(XPath xPath, String string) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xPath);
        stringBuffer.append(" ");
        stringBuffer.append(string);
        super(stringBuffer.toString());
        this.cause_ = null;
    }

    XPathException(XPath xPath, String string, SimpleStreamTokenizer simpleStreamTokenizer, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(" got \"");
        stringBuffer.append(XPathException.toString(simpleStreamTokenizer));
        stringBuffer.append("\" instead of expected ");
        stringBuffer.append(string2);
        this(xPath, stringBuffer.toString());
    }

    private static String toString(SimpleStreamTokenizer object) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(XPathException.tokenToString((SimpleStreamTokenizer)object));
            if (((SimpleStreamTokenizer)object).ttype != -1) {
                object.nextToken();
                stringBuffer.append(XPathException.tokenToString((SimpleStreamTokenizer)object));
                object.pushBack();
            }
            object = stringBuffer.toString();
            return object;
        }
        catch (IOException iOException) {
            object = new StringBuffer();
            ((StringBuffer)object).append("(cannot get  info: ");
            ((StringBuffer)object).append(iOException);
            ((StringBuffer)object).append(")");
            return ((StringBuffer)object).toString();
        }
    }

    private static String tokenToString(SimpleStreamTokenizer object) {
        int n = ((SimpleStreamTokenizer)object).ttype;
        if (n == -3) return ((SimpleStreamTokenizer)object).sval;
        if (n != -2) {
            if (n == -1) return "<end of expression>";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char)((SimpleStreamTokenizer)object).ttype);
            object = stringBuffer;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(((SimpleStreamTokenizer)object).nval);
            object = stringBuffer;
        }
        ((StringBuffer)object).append("");
        return ((StringBuffer)object).toString();
    }

    @Override
    public Throwable getCause() {
        return this.cause_;
    }
}
