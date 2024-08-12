/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.DOMException
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.Node
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.Sparta
 *  com.hp.hpl.sparta.Text
 *  com.hp.hpl.sparta.XPathVisitor
 *  com.hp.hpl.sparta.xpath.Step
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.DOMException;
import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.Text;
import com.hp.hpl.sparta.XPathVisitor;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Element
extends Node {
    private static final boolean DEBUG = false;
    private Vector attributeNames_ = null;
    private Hashtable attributes_ = null;
    private Node firstChild_ = null;
    private Node lastChild_ = null;
    private String tagName_ = null;

    Element() {
    }

    public Element(String string) {
        this.tagName_ = Sparta.intern((String)string);
    }

    private void checkInvariant() {
    }

    private boolean removeChildNoChecking(Node node) {
        Node node2 = this.firstChild_;
        while (node2 != null) {
            if (node2.equals(node)) {
                if (this.firstChild_ == node2) {
                    this.firstChild_ = node2.getNextSibling();
                }
                if (this.lastChild_ == node2) {
                    this.lastChild_ = node2.getPreviousSibling();
                }
                node2.removeFromLinkedList();
                node2.setParentNode(null);
                node2.setOwnerDocument(null);
                return true;
            }
            node2 = node2.getNextSibling();
        }
        return false;
    }

    private void replaceChild_(Node object, Node node) throws DOMException {
        Node node2 = this.firstChild_;
        while (true) {
            if (node2 == null) {
                object = new StringBuffer();
                ((StringBuffer)object).append("Cannot find ");
                ((StringBuffer)object).append(node);
                ((StringBuffer)object).append(" in ");
                ((StringBuffer)object).append((Object)this);
                object = new DOMException(8, ((StringBuffer)object).toString());
                throw object;
            }
            if (node2 == node) {
                if (this.firstChild_ == node) {
                    this.firstChild_ = object;
                }
                if (this.lastChild_ == node) {
                    this.lastChild_ = object;
                }
                node.replaceInLinkedList((Node)object);
                object.setParentNode(this);
                node.setParentNode(null);
                return;
            }
            node2 = node2.getNextSibling();
        }
    }

    private XPathVisitor visitor(String string, boolean bl) throws XPathException {
        XPath xPath = XPath.get((String)string);
        if (xPath.isStringValue() == bl) return new XPathVisitor(this, xPath);
        string = bl ? "evaluates to element not string" : "evaluates to string not element";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"");
        stringBuffer.append(xPath);
        stringBuffer.append("\" evaluates to ");
        stringBuffer.append(string);
        throw new XPathException(xPath, stringBuffer.toString());
    }

    public void appendChild(Node node) {
        Node node2 = node;
        if (!this.canHaveAsDescendent(node)) {
            node2 = (Element)((Object)node.clone());
        }
        this.appendChildNoChecking(node2);
        this.notifyObservers();
    }

    void appendChildNoChecking(Node node) {
        Element element = node.getParentNode();
        if (element != null) {
            element.removeChildNoChecking(node);
        }
        node.insertAtEndOfLinkedList(this.lastChild_);
        if (this.firstChild_ == null) {
            this.firstChild_ = node;
        }
        node.setParentNode(this);
        this.lastChild_ = node;
        node.setOwnerDocument(this.getOwnerDocument());
    }

    boolean canHaveAsDescendent(Node node) {
        if (node == this) {
            return false;
        }
        Element element = this.getParentNode();
        if (element != null) return element.canHaveAsDescendent(node);
        return true;
    }

    public Object clone() {
        return this.cloneElement(true);
    }

    public Element cloneElement(boolean bl) {
        Element element = new Element(this.tagName_);
        Object object = this.attributeNames_;
        if (object != null) {
            object = ((Vector)object).elements();
            while (object.hasMoreElements()) {
                String string = (String)object.nextElement();
                element.setAttribute(string, (String)this.attributes_.get(string));
            }
        }
        if (!bl) return element;
        object = this.firstChild_;
        while (object != null) {
            element.appendChild((Node)object.clone());
            object = object.getNextSibling();
        }
        return element;
    }

    public Element cloneShallow() {
        return this.cloneElement(false);
    }

    protected int computeHashCode() {
        int n = this.tagName_.hashCode();
        Object object = this.attributes_;
        int n2 = n;
        if (object != null) {
            object = ((Hashtable)object).keys();
            n2 = n;
            while (object.hasMoreElements()) {
                String string = (String)object.nextElement();
                n2 = (n2 * 31 + string.hashCode()) * 31 + ((String)this.attributes_.get(string)).hashCode();
            }
        }
        object = this.firstChild_;
        while (object != null) {
            n2 = n2 * 31 + object.hashCode();
            object = object.getNextSibling();
        }
        return n2;
    }

    public boolean equals(Object object) {
        int n;
        if (this == object) {
            return true;
        }
        if (!(object instanceof Element)) {
            return false;
        }
        object = (Element)((Object)object);
        if (!this.tagName_.equals(((Element)((Object)object)).tagName_)) {
            return false;
        }
        Object object2 = this.attributes_;
        int n2 = object2 == null ? 0 : ((Hashtable)object2).size();
        if (n2 != (n = (object2 = ((Element)((Object)object)).attributes_) == null ? 0 : ((Hashtable)object2).size())) {
            return false;
        }
        object2 = this.attributes_;
        if (object2 != null) {
            Enumeration enumeration = ((Hashtable)object2).keys();
            while (enumeration.hasMoreElements()) {
                object2 = (String)enumeration.nextElement();
                if (((String)this.attributes_.get(object2)).equals((String)((Element)((Object)object)).attributes_.get(object2))) continue;
                return false;
            }
        }
        object2 = this.firstChild_;
        object = ((Element)((Object)object)).firstChild_;
        while (object2 != null) {
            if (!object2.equals(object)) {
                return false;
            }
            object2 = object2.getNextSibling();
            object = object.getNextSibling();
        }
        return true;
    }

    public String getAttribute(String string) {
        Hashtable hashtable = this.attributes_;
        string = hashtable == null ? null : (String)hashtable.get(string);
        return string;
    }

    public Enumeration getAttributeNames() {
        Vector vector = this.attributeNames_;
        if (vector != null) return vector.elements();
        return Document.EMPTY;
    }

    public Node getFirstChild() {
        return this.firstChild_;
    }

    public Node getLastChild() {
        return this.lastChild_;
    }

    public String getTagName() {
        return this.tagName_;
    }

    public void removeAttribute(String string) {
        Hashtable hashtable = this.attributes_;
        if (hashtable == null) {
            return;
        }
        hashtable.remove(string);
        this.attributeNames_.removeElement(string);
        this.notifyObservers();
    }

    public void removeChild(Node node) throws DOMException {
        if (this.removeChildNoChecking(node)) {
            this.notifyObservers();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot find ");
        stringBuffer.append(node);
        stringBuffer.append(" in ");
        stringBuffer.append((Object)this);
        throw new DOMException(8, stringBuffer.toString());
    }

    public void replaceChild(Element element, Node node) throws DOMException {
        this.replaceChild_(element, node);
        this.notifyObservers();
    }

    public void replaceChild(Text text, Node node) throws DOMException {
        this.replaceChild_((Node)text, node);
        this.notifyObservers();
    }

    public void setAttribute(String string, String string2) {
        if (this.attributes_ == null) {
            this.attributes_ = new Hashtable();
            this.attributeNames_ = new Vector();
        }
        if (this.attributes_.get(string) == null) {
            this.attributeNames_.addElement(string);
        }
        this.attributes_.put(string, string2);
        this.notifyObservers();
    }

    public void setTagName(String string) {
        this.tagName_ = Sparta.intern((String)string);
        this.notifyObservers();
    }

    void toString(Writer writer) throws IOException {
        Node node = this.firstChild_;
        while (node != null) {
            node.toString(writer);
            node = node.getNextSibling();
        }
        return;
    }

    /*
     * Unable to fully structure code
     */
    public void toXml(Writer var1_1) throws IOException {
        var2_2 = new StringBuffer();
        var2_2.append("<");
        var2_2.append(this.tagName_);
        var1_1.write(var2_2.toString());
        var2_2 = this.attributeNames_;
        if (var2_2 != null) {
            var3_3 = var2_2.elements();
            while (var3_3.hasMoreElements()) {
                var2_2 = (String)var3_3.nextElement();
                var5_5 = (String)this.attributes_.get(var2_2);
                var4_4 = new StringBuffer();
                var4_4.append(" ");
                var4_4.append((String)var2_2);
                var4_4.append("=\"");
                var1_1.write(var4_4.toString());
                Node.htmlEncode((Writer)var1_1, (String)var5_5);
                var1_1.write("\"");
            }
        }
        if (this.firstChild_ == null) {
            var2_2 = "/>";
lbl26:
            // 2 sources

            while (true) {
                var1_1.write((String)var2_2);
                return;
            }
        }
        var1_1.write(">");
        var2_2 = this.firstChild_;
        while (true) {
            if (var2_2 == null) {
                var2_2 = new StringBuffer();
                var2_2.append("</");
                var2_2.append(this.tagName_);
                var2_2.append(">");
                var2_2 = var2_2.toString();
                ** continue;
            }
            var2_2.toXml(var1_1);
            var2_2 = var2_2.getNextSibling();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public boolean xpathEnsure(String string) throws ParseException {
        try {
            Element element = this.xpathSelectElement(string);
            int n = 0;
            if (element != null) {
                return false;
            }
            XPath xPath = XPath.get((String)string);
            Enumeration enumeration = xPath.getSteps();
            int n2 = 0;
            while (true) {
                if (!enumeration.hasMoreElements()) {
                    int n3 = n2 - 1;
                    Step[] stepArray = new Step[n3];
                    enumeration = xPath.getSteps();
                    n2 = n;
                    while (true) {
                        if (n2 >= n3) {
                            void var5_7;
                            enumeration = (Step)enumeration.nextElement();
                            if (n3 == 0) {
                                Element element2 = this;
                            } else {
                                String string2 = XPath.get((boolean)xPath.isAbsolute(), (Step[])stepArray).toString();
                                this.xpathEnsure(string2.toString());
                                Element element3 = this.xpathSelectElement(string2);
                            }
                            var5_7.appendChildNoChecking(this.makeMatching((Element)var5_7, (Step)enumeration, string));
                            return true;
                        }
                        stepArray[n2] = (Step)enumeration.nextElement();
                        ++n2;
                    }
                }
                enumeration.nextElement();
                ++n2;
            }
        }
        catch (XPathException xPathException) {
            string = new ParseException(string, (Throwable)xPathException);
            throw string;
        }
    }

    public Element xpathSelectElement(String object) throws ParseException {
        try {
            object = this.visitor((String)object, false).getFirstResultElement();
            return object;
        }
        catch (XPathException xPathException) {
            throw new ParseException("XPath problem", (Throwable)xPathException);
        }
    }

    public Enumeration xpathSelectElements(String object) throws ParseException {
        try {
            object = this.visitor((String)object, false).getResultEnumeration();
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
