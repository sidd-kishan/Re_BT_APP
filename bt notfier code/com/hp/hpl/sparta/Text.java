/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.Node
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.Node;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

public class Text
extends Node {
    private StringBuffer text_;

    public Text(char c) {
        StringBuffer stringBuffer;
        this.text_ = stringBuffer = new StringBuffer();
        stringBuffer.append(c);
    }

    public Text(String string) {
        this.text_ = new StringBuffer(string);
    }

    public void appendData(char c) {
        this.text_.append(c);
        this.notifyObservers();
    }

    public void appendData(String string) {
        this.text_.append(string);
        this.notifyObservers();
    }

    public void appendData(char[] cArray, int n, int n2) {
        this.text_.append(cArray, n, n2);
        this.notifyObservers();
    }

    public Object clone() {
        return new Text(this.text_.toString());
    }

    protected int computeHashCode() {
        return this.text_.toString().hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Text)) {
            return false;
        }
        object = (Text)((Object)object);
        return this.text_.toString().equals(((Text)((Object)object)).text_.toString());
    }

    public String getData() {
        return this.text_.toString();
    }

    public void setData(String string) {
        this.text_ = new StringBuffer(string);
        this.notifyObservers();
    }

    void toString(Writer writer) throws IOException {
        writer.write(this.text_.toString());
    }

    void toXml(Writer writer) throws IOException {
        String string = this.text_.toString();
        if (string.length() < 50) {
            Node.htmlEncode((Writer)writer, (String)string);
        } else {
            writer.write("<![CDATA[");
            writer.write(string);
            writer.write("]]>");
        }
    }

    public Element xpathSelectElement(String string) {
        throw new Error("Sorry, not implemented");
    }

    public Enumeration xpathSelectElements(String string) {
        throw new Error("Sorry, not implemented");
    }

    public String xpathSelectString(String string) {
        throw new Error("Sorry, not implemented");
    }

    public Enumeration xpathSelectStrings(String string) {
        throw new Error("Sorry, not implemented");
    }
}
