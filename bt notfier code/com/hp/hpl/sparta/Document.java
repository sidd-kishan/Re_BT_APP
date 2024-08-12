/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document$Index
 *  com.hp.hpl.sparta.Document$Observer
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.EmptyEnumeration
 *  com.hp.hpl.sparta.Node
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.Sparta
 *  com.hp.hpl.sparta.Sparta$Cache
 *  com.hp.hpl.sparta.XPathVisitor
 *  com.hp.hpl.sparta.xpath.Step
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.EmptyEnumeration;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.XPathVisitor;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Document
extends Node {
    private static final boolean DEBUG = false;
    static final Enumeration EMPTY;
    private static final Integer ONE;
    private final Hashtable indexible_ = null;
    private Sparta.Cache indices_ = Sparta.newCache();
    private Vector observers_ = new Vector();
    private Element rootElement_ = null;
    private String systemId_;

    static {
        ONE = new Integer(1);
        EMPTY = new EmptyEnumeration();
    }

    public Document() {
        this.systemId_ = "MEMORY";
    }

    Document(String string) {
        this.systemId_ = string;
    }

    private XPathVisitor visitor(String string, boolean bl) throws XPathException {
        CharSequence charSequence = string;
        if (string.charAt(0) == '/') return this.visitor(XPath.get((String)charSequence), bl);
        charSequence = new StringBuffer();
        ((StringBuffer)charSequence).append("/");
        ((StringBuffer)charSequence).append(string);
        charSequence = ((StringBuffer)charSequence).toString();
        return this.visitor(XPath.get((String)charSequence), bl);
    }

    public void addObserver(Observer observer) {
        this.observers_.addElement(observer);
    }

    public Object clone() {
        Document document = new Document(this.systemId_);
        document.rootElement_ = (Element)this.rootElement_.clone();
        return document;
    }

    protected int computeHashCode() {
        return this.rootElement_.hashCode();
    }

    public void deleteObserver(Observer observer) {
        this.observers_.removeElement(observer);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Document)) {
            return false;
        }
        object = (Document)((Object)object);
        return this.rootElement_.equals((Object)((Document)((Object)object)).rootElement_);
    }

    public Element getDocumentElement() {
        return this.rootElement_;
    }

    public String getSystemId() {
        return this.systemId_;
    }

    void monitor(XPath xPath) throws XPathException {
    }

    void notifyObservers() {
        Enumeration enumeration = this.observers_.elements();
        while (enumeration.hasMoreElements()) {
            ((Observer)enumeration.nextElement()).update(this);
        }
        return;
    }

    public void setDocumentElement(Element element) {
        this.rootElement_ = element;
        element.setOwnerDocument(this);
        this.notifyObservers();
    }

    public void setSystemId(String string) {
        this.systemId_ = string;
        this.notifyObservers();
    }

    public String toString() {
        return this.systemId_;
    }

    public void toString(Writer writer) throws IOException {
        this.rootElement_.toString(writer);
    }

    public void toXml(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.rootElement_.toXml(writer);
    }

    XPathVisitor visitor(XPath xPath, boolean bl) throws XPathException {
        if (xPath.isStringValue() == bl) return new XPathVisitor(this, xPath);
        String string = bl ? "evaluates to element not string" : "evaluates to string not element";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"");
        stringBuffer.append(xPath);
        stringBuffer.append("\" evaluates to ");
        stringBuffer.append(string);
        throw new XPathException(xPath, stringBuffer.toString());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean xpathEnsure(String string) throws ParseException {
        try {
            if (this.xpathSelectElement(string) != null) {
                return false;
            }
            XPath xPath = XPath.get((String)string);
            Object object = xPath.getSteps();
            int n = 0;
            while (true) {
                if (!object.hasMoreElements()) {
                    Object object2 = xPath.getSteps();
                    xPath = (Step)object2.nextElement();
                    int n2 = n - 1;
                    object = new Step[n2];
                    n = 0;
                    while (true) {
                        if (n >= n2) {
                            if (this.rootElement_ == null) {
                                this.setDocumentElement(this.makeMatching(null, (Step)xPath, string));
                            } else {
                                object2 = new StringBuffer();
                                ((StringBuffer)object2).append("/");
                                ((StringBuffer)object2).append(xPath);
                                if (this.xpathSelectElement(((StringBuffer)object2).toString()) == null) {
                                    object = new StringBuffer();
                                    ((StringBuffer)object).append("Existing root element <");
                                    ((StringBuffer)object).append(this.rootElement_.getTagName());
                                    ((StringBuffer)object).append("...> does not match first step \"");
                                    ((StringBuffer)object).append(xPath);
                                    ((StringBuffer)object).append("\" of \"");
                                    ((StringBuffer)object).append(string);
                                    object2 = new ParseException(((StringBuffer)object).toString());
                                    throw object2;
                                }
                            }
                            if (n2 != 0) return this.rootElement_.xpathEnsure(XPath.get((boolean)false, (Step[])object).toString());
                            return true;
                        }
                        object[n] = (Step)object2.nextElement();
                        ++n;
                    }
                }
                object.nextElement();
                ++n;
            }
        }
        catch (XPathException xPathException) {
            string = new ParseException(string, (Throwable)xPathException);
            throw string;
        }
    }

    public Index xpathGetIndex(String string) throws ParseException {
        try {
            Index index;
            Index index2 = index = (Index)this.indices_.get((Object)string);
            if (index != null) return index2;
            index = XPath.get((String)string);
            index2 = new Index(this, (XPath)index);
            this.indices_.put((Object)string, (Object)index2);
            return index2;
        }
        catch (XPathException xPathException) {
            throw new ParseException("XPath problem", (Throwable)xPathException);
        }
    }

    public boolean xpathHasIndex(String string) {
        boolean bl = this.indices_.get((Object)string) != null;
        return bl;
    }

    public Element xpathSelectElement(String string) throws ParseException {
        CharSequence charSequence = string;
        try {
            if (string.charAt(0) != '/') {
                charSequence = new StringBuffer();
                ((StringBuffer)charSequence).append("/");
                ((StringBuffer)charSequence).append(string);
                charSequence = ((StringBuffer)charSequence).toString();
            }
            string = XPath.get((String)charSequence);
            this.monitor((XPath)string);
            string = this.visitor((XPath)string, false).getFirstResultElement();
            return string;
        }
        catch (XPathException xPathException) {
            throw new ParseException("XPath problem", (Throwable)xPathException);
        }
    }

    public Enumeration xpathSelectElements(String object) throws ParseException {
        CharSequence charSequence = object;
        try {
            if (((String)object).charAt(0) != '/') {
                charSequence = new StringBuffer();
                ((StringBuffer)charSequence).append("/");
                ((StringBuffer)charSequence).append((String)object);
                charSequence = ((StringBuffer)charSequence).toString();
            }
            object = XPath.get((String)charSequence);
            this.monitor((XPath)object);
            object = this.visitor((XPath)object, false).getResultEnumeration();
            return object;
        }
        catch (XPathException xPathException) {
            throw new ParseException("XPath problem", (Throwable)xPathException);
        }
    }

    public String xpathSelectString(String string) throws ParseException {
        try {
            string = this.visitor(string, true).getFirstResultString();
            return string;
        }
        catch (XPathException xPathException) {
            throw new ParseException("XPath problem", (Throwable)xPathException);
        }
    }

    public Enumeration xpathSelectStrings(String object) throws ParseException {
        try {
            object = this.visitor((String)object, true).getResultEnumeration();
            return object;
        }
        catch (XPathException xPathException) {
            throw new ParseException("XPath problem", (Throwable)xPathException);
        }
    }
}
