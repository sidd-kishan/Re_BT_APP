/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.BuildDocument
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.EncodingMismatchException
 *  com.hp.hpl.sparta.ParseByteStream
 *  com.hp.hpl.sparta.ParseCharStream
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.ParseHandler
 *  com.hp.hpl.sparta.ParseLog
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.BuildDocument;
import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.EncodingMismatchException;
import com.hp.hpl.sparta.ParseByteStream;
import com.hp.hpl.sparta.ParseCharStream;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Parser {
    public static Document parse(String string) throws ParseException, IOException {
        return Parser.parse(string.toCharArray());
    }

    public static Document parse(String string, InputStream inputStream) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream(string, inputStream, null, null, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(String string, InputStream inputStream, ParseLog parseLog) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream(string, inputStream, parseLog, null, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(String string, InputStream inputStream, ParseLog parseLog, String string2) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream(string, inputStream, parseLog, string2, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(String string, Reader reader) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream(string, reader, null, null, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(String string, Reader reader, ParseLog parseLog) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream(string, reader, parseLog, null, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(String string, Reader reader, ParseLog parseLog, String string2) throws ParseException, EncodingMismatchException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream(string, reader, parseLog, string2, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(byte[] byArray) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseByteStream("file:anonymous-string", (InputStream)new ByteArrayInputStream(byArray), null, null, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static Document parse(char[] cArray) throws ParseException, IOException {
        BuildDocument buildDocument = new BuildDocument();
        new ParseCharStream("file:anonymous-string", cArray, null, null, (ParseHandler)buildDocument);
        return buildDocument.getDocument();
    }

    public static void parse(String string, ParseHandler parseHandler) throws ParseException, IOException {
        Parser.parse(string.toCharArray(), parseHandler);
    }

    public static void parse(String string, InputStream inputStream, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream(string, inputStream, null, null, parseHandler);
    }

    public static void parse(String string, InputStream inputStream, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream(string, inputStream, parseLog, null, parseHandler);
    }

    public static void parse(String string, InputStream inputStream, ParseLog parseLog, String string2, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream(string, inputStream, parseLog, string2, parseHandler);
    }

    public static void parse(String string, Reader reader, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseCharStream(string, reader, null, null, parseHandler);
    }

    public static void parse(String string, Reader reader, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseCharStream(string, reader, parseLog, null, parseHandler);
    }

    public static void parse(String string, Reader reader, ParseLog parseLog, String string2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        new ParseCharStream(string, reader, parseLog, string2, parseHandler);
    }

    public static void parse(byte[] byArray, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseByteStream("file:anonymous-string", (InputStream)new ByteArrayInputStream(byArray), null, null, parseHandler);
    }

    public static void parse(char[] cArray, ParseHandler parseHandler) throws ParseException, IOException {
        new ParseCharStream("file:anonymous-string", cArray, null, null, parseHandler);
    }
}
