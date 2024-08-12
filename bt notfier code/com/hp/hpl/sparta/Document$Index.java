/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.Document$Observer
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.Sparta
 *  com.hp.hpl.sparta.Sparta$Cache
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

public class Document.Index
implements Document.Observer {
    private final String attrName_;
    private transient Sparta.Cache dict_;
    private final Document this$0;
    private final XPath xpath_;

    Document.Index(Document document, XPath xPath) throws XPathException {
        this.this$0 = document;
        this.dict_ = null;
        this.attrName_ = xPath.getIndexingAttrName();
        this.xpath_ = xPath;
        document.addObserver((Document.Observer)this);
    }

    private void regenerate() throws ParseException {
        try {
            this.dict_ = Sparta.newCache();
            Enumeration enumeration = this.this$0.visitor(this.xpath_, false).getResultEnumeration();
            while (true) {
                Vector<Element> vector;
                if (!enumeration.hasMoreElements()) {
                    return;
                }
                Element element = (Element)enumeration.nextElement();
                String string = element.getAttribute(this.attrName_);
                Vector<Element> vector2 = vector = (Vector<Element>)this.dict_.get((Object)string);
                if (vector == null) {
                    vector2 = new Vector<Element>(1);
                    this.dict_.put((Object)string, vector2);
                }
                vector2.addElement(element);
            }
        }
        catch (XPathException xPathException) {
            ParseException parseException = new ParseException("XPath problem", (Throwable)xPathException);
            throw parseException;
        }
    }

    public Enumeration get(String enumeration) throws ParseException {
        synchronized (this) {
            if (this.dict_ == null) {
                this.regenerate();
            }
            enumeration = (enumeration = (Vector)this.dict_.get((Object)enumeration)) == null ? Document.EMPTY : ((Vector)((Object)enumeration)).elements();
            return enumeration;
        }
    }

    public int size() throws ParseException {
        synchronized (this) {
            if (this.dict_ == null) {
                this.regenerate();
            }
            int n = this.dict_.size();
            return n;
        }
    }

    public void update(Document document) {
        synchronized (this) {
            this.dict_ = null;
            return;
        }
    }
}
