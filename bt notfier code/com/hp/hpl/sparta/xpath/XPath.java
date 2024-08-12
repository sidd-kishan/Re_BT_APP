/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.AttrEqualsExpr
 *  com.hp.hpl.sparta.xpath.AttrExistsExpr
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 *  com.hp.hpl.sparta.xpath.SimpleStreamTokenizer
 *  com.hp.hpl.sparta.xpath.Step
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.SimpleStreamTokenizer;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

public class XPath {
    private static final int ASSERTION = 0;
    private static Hashtable cache_ = new Hashtable();
    private boolean absolute_;
    private Stack steps_ = new Stack();
    private String string_;

    private XPath(String string) throws XPathException {
        this(string, new InputStreamReader(new ByteArrayInputStream(string.getBytes())));
    }

    private XPath(String string, Reader object) throws XPathException {
        try {
            boolean bl;
            SimpleStreamTokenizer simpleStreamTokenizer;
            block9: {
                block8: {
                    block7: {
                        this.string_ = string;
                        simpleStreamTokenizer = new SimpleStreamTokenizer((Reader)object);
                        simpleStreamTokenizer.ordinaryChar('/');
                        simpleStreamTokenizer.ordinaryChar('.');
                        simpleStreamTokenizer.wordChars(':', ':');
                        simpleStreamTokenizer.wordChars('_', '_');
                        if (simpleStreamTokenizer.nextToken() != 47) break block7;
                        this.absolute_ = true;
                        if (simpleStreamTokenizer.nextToken() != 47) break block8;
                        simpleStreamTokenizer.nextToken();
                        bl = true;
                        break block9;
                    }
                    this.absolute_ = false;
                }
                bl = false;
            }
            object = this.steps_;
            super(this, bl, simpleStreamTokenizer);
            while (true) {
                ((Stack)object).push(string);
                if (simpleStreamTokenizer.ttype != 47) {
                    if (simpleStreamTokenizer.ttype == -1) {
                        return;
                    }
                    super(this, "at end of XPATH expression", simpleStreamTokenizer, "end of expression");
                    throw string;
                }
                if (simpleStreamTokenizer.nextToken() == 47) {
                    simpleStreamTokenizer.nextToken();
                    bl = true;
                } else {
                    bl = false;
                }
                object = this.steps_;
                string = new Step(this, bl, simpleStreamTokenizer);
            }
        }
        catch (IOException iOException) {
            XPathException xPathException = new XPathException(this, (Exception)iOException);
            throw xPathException;
        }
    }

    private XPath(boolean bl, Step[] stepArray) {
        int n = 0;
        while (true) {
            if (n >= stepArray.length) {
                this.absolute_ = bl;
                this.string_ = null;
                return;
            }
            this.steps_.addElement(stepArray[n]);
            ++n;
        }
    }

    private String generateString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration enumeration = this.steps_.elements();
        boolean bl = true;
        while (enumeration.hasMoreElements()) {
            Step step = (Step)enumeration.nextElement();
            if (!bl || this.absolute_) {
                stringBuffer.append('/');
                if (step.isMultiLevel()) {
                    stringBuffer.append('/');
                }
            }
            stringBuffer.append(step.toString());
            bl = false;
        }
        return stringBuffer.toString();
    }

    public static XPath get(String string) throws XPathException {
        Hashtable hashtable = cache_;
        synchronized (hashtable) {
            XPath xPath;
            XPath xPath2 = xPath = (XPath)cache_.get(string);
            if (xPath != null) return xPath2;
            xPath2 = new XPath(string);
            cache_.put(string, xPath2);
            return xPath2;
        }
    }

    public static XPath get(boolean bl, Step[] object) {
        XPath xPath = new XPath(bl, (Step[])object);
        String string = xPath.toString();
        object = cache_;
        synchronized (object) {
            XPath xPath2 = (XPath)cache_.get(string);
            if (xPath2 != null) return xPath2;
            cache_.put(string, xPath);
            return xPath;
        }
    }

    public static boolean isStringValue(String string) throws XPathException, IOException {
        return XPath.get(string).isStringValue();
    }

    public Object clone() {
        int n = this.steps_.size();
        Step[] stepArray = new Step[n];
        Enumeration enumeration = this.steps_.elements();
        int n2 = 0;
        while (n2 < n) {
            stepArray[n2] = (Step)enumeration.nextElement();
            ++n2;
        }
        return new XPath(this.absolute_, stepArray);
    }

    public String getIndexingAttrName() throws XPathException {
        BooleanExpr booleanExpr = ((Step)this.steps_.peek()).getPredicate();
        if (!(booleanExpr instanceof AttrExistsExpr)) throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
        return ((AttrExistsExpr)booleanExpr).getAttrName();
    }

    public String getIndexingAttrNameOfEquals() throws XPathException {
        BooleanExpr booleanExpr = ((Step)this.steps_.peek()).getPredicate();
        if (!(booleanExpr instanceof AttrEqualsExpr)) return null;
        return ((AttrEqualsExpr)booleanExpr).getAttrName();
    }

    public Enumeration getSteps() {
        return this.steps_.elements();
    }

    public boolean isAbsolute() {
        return this.absolute_;
    }

    public boolean isStringValue() {
        return ((Step)this.steps_.peek()).isStringValue();
    }

    public String toString() {
        if (this.string_ != null) return this.string_;
        this.string_ = this.generateString();
        return this.string_;
    }
}
