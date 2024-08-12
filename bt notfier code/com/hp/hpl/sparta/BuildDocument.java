/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.DocumentSource
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.Node
 *  com.hp.hpl.sparta.ParseHandler
 *  com.hp.hpl.sparta.ParseLog
 *  com.hp.hpl.sparta.ParseSource
 *  com.hp.hpl.sparta.Text
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.DocumentSource;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import com.hp.hpl.sparta.ParseSource;
import com.hp.hpl.sparta.Text;

class BuildDocument
implements DocumentSource,
ParseHandler {
    private Element currentElement_ = null;
    private final Document doc_ = new Document();
    private final ParseLog log_;
    private ParseSource parseSource_ = null;

    public BuildDocument() {
        this(null);
    }

    public BuildDocument(ParseLog parseLog) {
        ParseLog parseLog2 = parseLog;
        if (parseLog == null) {
            parseLog2 = ParseSource.DEFAULT_LOG;
        }
        this.log_ = parseLog2;
    }

    public void characters(char[] cArray, int n, int n2) {
        Element element = this.currentElement_;
        if (element.getLastChild() instanceof Text) {
            ((Text)element.getLastChild()).appendData(cArray, n, n2);
        } else {
            element.appendChildNoChecking((Node)new Text(new String(cArray, n, n2)));
        }
    }

    public void endDocument() {
    }

    public void endElement(Element element) {
        this.currentElement_ = this.currentElement_.getParentNode();
    }

    public Document getDocument() {
        return this.doc_;
    }

    public int getLineNumber() {
        ParseSource parseSource = this.parseSource_;
        if (parseSource == null) return -1;
        return parseSource.getLineNumber();
    }

    public ParseSource getParseSource() {
        return this.parseSource_;
    }

    public String getSystemId() {
        ParseSource parseSource = this.parseSource_;
        if (parseSource == null) return null;
        return parseSource.getSystemId();
    }

    public void setParseSource(ParseSource parseSource) {
        this.parseSource_ = parseSource;
        this.doc_.setSystemId(parseSource.toString());
    }

    public void startDocument() {
    }

    public void startElement(Element element) {
        Element element2 = this.currentElement_;
        if (element2 == null) {
            this.doc_.setDocumentElement(element);
        } else {
            element2.appendChild((Node)element);
        }
        this.currentElement_ = element;
    }

    public String toString() {
        if (this.parseSource_ == null) return null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BuildDoc: ");
        stringBuffer.append(this.parseSource_.toString());
        return stringBuffer.toString();
    }
}
