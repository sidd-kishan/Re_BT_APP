/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.ParseSource
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseSource;

public interface ParseHandler {
    public void characters(char[] var1, int var2, int var3) throws ParseException;

    public void endDocument() throws ParseException;

    public void endElement(Element var1) throws ParseException;

    public ParseSource getParseSource();

    public void setParseSource(ParseSource var1);

    public void startDocument() throws ParseException;

    public void startElement(Element var1) throws ParseException;
}
