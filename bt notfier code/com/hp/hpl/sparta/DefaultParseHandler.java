/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.ParseHandler
 *  com.hp.hpl.sparta.ParseSource
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseSource;

public class DefaultParseHandler
implements ParseHandler {
    private ParseSource parseSource_ = null;

    public void characters(char[] cArray, int n, int n2) throws ParseException {
    }

    public void endDocument() throws ParseException {
    }

    public void endElement(Element element) throws ParseException {
    }

    public ParseSource getParseSource() {
        return this.parseSource_;
    }

    public void setParseSource(ParseSource parseSource) {
        this.parseSource_ = parseSource;
    }

    public void startDocument() throws ParseException {
    }

    public void startElement(Element element) throws ParseException {
    }
}
