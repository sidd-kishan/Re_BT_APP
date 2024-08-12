/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.DOMException
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.Node$1
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.Text
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 *  com.hp.hpl.sparta.xpath.ElementTest
 *  com.hp.hpl.sparta.xpath.Step
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.DOMException;
import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Text;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.ElementTest;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

public abstract class Node {
    private Object annotation_ = null;
    private Document doc_ = null;
    private int hash_ = 0;
    private Node nextSibling_ = null;
    private Element parentNode_ = null;
    private Node previousSibling_ = null;

    protected static void htmlEncode(Writer writer, String string) throws IOException {
        int n = string.length();
        int n2 = 0;
        int n3 = 0;
        while (true) {
            Object object;
            if (n2 >= n) {
                if (n3 >= n) return;
                writer.write(string, n3, n - n3);
                return;
            }
            int n4 = string.charAt(n2);
            if (n4 >= 128) {
                object = new StringBuffer();
                ((StringBuffer)object).append("&#");
                ((StringBuffer)object).append(n4);
                ((StringBuffer)object).append(";");
                object = ((StringBuffer)object).toString();
            } else {
                object = n4 != 34 ? (n4 != 60 ? (n4 != 62 ? (n4 != 38 ? (n4 != 39 ? null : "&#39;") : "&amp;") : "&gt;") : "&lt;") : "&quot;";
            }
            n4 = n3;
            if (object != null) {
                writer.write(string, n3, n2 - n3);
                writer.write((String)object);
                n4 = n2 + 1;
            }
            ++n2;
            n3 = n4;
        }
    }

    public abstract Object clone();

    protected abstract int computeHashCode();

    public Object getAnnotation() {
        return this.annotation_;
    }

    public Node getNextSibling() {
        return this.nextSibling_;
    }

    public Document getOwnerDocument() {
        return this.doc_;
    }

    public Element getParentNode() {
        return this.parentNode_;
    }

    public Node getPreviousSibling() {
        return this.previousSibling_;
    }

    public int hashCode() {
        if (this.hash_ != 0) return this.hash_;
        this.hash_ = this.computeHashCode();
        return this.hash_;
    }

    void insertAtEndOfLinkedList(Node node) {
        this.previousSibling_ = node;
        if (node == null) return;
        node.nextSibling_ = this;
    }

    Element makeMatching(Element object, Step step, String string) throws ParseException, XPathException {
        Object object2 = step.getNodeTest();
        if (object2 instanceof ElementTest) {
            object2 = ((ElementTest)object2).getTagName();
            Element element = new Element((String)object2);
            step.getPredicate().accept((BooleanExprVisitor)new 1(this, element, (Element)object, string, (String)object2));
            return element;
        }
        object = new StringBuffer();
        ((StringBuffer)object).append("\"");
        ((StringBuffer)object).append(object2);
        ((StringBuffer)object).append("\" in \"");
        ((StringBuffer)object).append(string);
        ((StringBuffer)object).append("\" is not an element test");
        throw new ParseException(((StringBuffer)object).toString());
    }

    void notifyObservers() {
        this.hash_ = 0;
        Document document = this.doc_;
        if (document == null) return;
        document.notifyObservers();
    }

    void removeFromLinkedList() {
        Node node = this.previousSibling_;
        if (node != null) {
            node.nextSibling_ = this.nextSibling_;
        }
        if ((node = this.nextSibling_) != null) {
            node.previousSibling_ = this.previousSibling_;
        }
        this.nextSibling_ = null;
        this.previousSibling_ = null;
    }

    void replaceInLinkedList(Node node) {
        Node node2 = this.previousSibling_;
        if (node2 != null) {
            node2.nextSibling_ = node;
        }
        if ((node2 = this.nextSibling_) != null) {
            node2.previousSibling_ = node;
        }
        node.nextSibling_ = this.nextSibling_;
        node.previousSibling_ = this.previousSibling_;
        this.nextSibling_ = null;
        this.previousSibling_ = null;
    }

    public void setAnnotation(Object object) {
        this.annotation_ = object;
    }

    void setOwnerDocument(Document document) {
        this.doc_ = document;
    }

    void setParentNode(Element element) {
        this.parentNode_ = element;
    }

    public String toString() {
        try {
            Object object = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)object);
            this.toString(outputStreamWriter);
            ((Writer)outputStreamWriter).flush();
            object = new String(((ByteArrayOutputStream)object).toByteArray());
            return object;
        }
        catch (IOException iOException) {
            return super.toString();
        }
    }

    abstract void toString(Writer var1) throws IOException;

    public String toXml() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        this.toXml(outputStreamWriter);
        ((Writer)outputStreamWriter).flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    abstract void toXml(Writer var1) throws IOException;

    public abstract Element xpathSelectElement(String var1) throws ParseException;

    public abstract Enumeration xpathSelectElements(String var1) throws ParseException;

    public abstract String xpathSelectString(String var1) throws ParseException;

    public abstract Enumeration xpathSelectStrings(String var1) throws ParseException;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public boolean xpathSetStrings(String var1_1, String var2_2) throws ParseException {
        try {
            block15: {
                var4_6 = var1_1.lastIndexOf(47);
                var3_7 = var4_6 + 1;
                if (!var1_1.substring(var3_7).equals("text()") && var1_1.charAt(var3_7) != '@') {
                    var6_8 = new StringBuffer();
                    var6_8.append("Last step of Xpath expression \"");
                    var6_8.append((String)var1_1);
                    var6_8.append("\" is not \"text()\" and does not start with a '@'. It starts with a '");
                    var6_8.append(var1_1.charAt(var3_7));
                    var6_8.append("'");
                    var2_2 = new ParseException(var6_8.toString());
                    throw var2_2;
                }
                var5_11 = false;
                var7_12 = var1_1.substring(0, var4_6);
                if (var1_1.charAt(var3_7) == '@') {
                    var6_9 = var1_1.substring(var4_6 + 2);
                    if (var6_9.length() == 0) {
                        var2_2 = new StringBuffer();
                        var2_2.append("Xpath expression \"");
                        var2_2.append((String)var1_1);
                        var2_2.append("\" specifies zero-length attribute name\"");
                        var6_9 = new ParseException(var2_2.toString());
                        throw var6_9;
                    }
                    var7_12 = this.xpathSelectElements((String)var7_12);
                    while (var7_12.hasMoreElements()) {
                        var8_13 = (Element)var7_12.nextElement();
                        if (var2_2.equals(var8_13.getAttribute(var6_9))) continue;
                        var8_13.setAttribute(var6_9, (String)var2_2);
                        var5_11 = true;
                    }
                } else {
                    var8_14 = this.xpathSelectElements((String)var7_12);
                    var5_11 = var8_14.hasMoreElements();
lbl42:
                    // 3 sources

                    while (true) {
                        if (var8_14.hasMoreElements()) break block15;
                        break;
                    }
                }
                return var5_11;
            }
            var7_12 = (Element)var8_14.nextElement();
            var9_15 = new Vector<Text>();
            var6_10 = var7_12.getFirstChild();
lbl49:
            // 2 sources

            while (true) {
                block16: {
                    if (var6_10 != null) break;
                    if (var9_15.size() != 0) break block16;
                    var6_10 = new Text((String)var2_2);
                    if (var6_10.getData().length() > 0) {
                        var7_12.appendChild(var6_10);
                        var5_11 = true;
                    }
                    ** GOTO lbl42
                }
                var6_10 = (Text)var9_15.elementAt(0);
                if (!var6_10.getData().equals(var2_2)) {
                    var9_15.removeElementAt(0);
                    var6_10.setData((String)var2_2);
                    var5_11 = true;
                }
                var3_7 = 0;
                while (true) {
                    if (var3_7 < var9_15.size()) ** break;
                    ** continue;
                    var7_12.removeChild((Node)((Text)var9_15.elementAt(var3_7)));
                    ++var3_7;
                    var5_11 = true;
                }
                break;
            }
        }
        catch (IndexOutOfBoundsException var2_3) {
            var2_4 = new StringBuffer();
            var2_4.append("Xpath expression \"");
            var2_4.append((String)var1_1);
            var2_4.append("\" is not in the form \"xpathExpression/@attributeName\"");
            throw new ParseException(var2_4.toString());
        }
        catch (DOMException var2_5) {
            var1_1 = new StringBuffer();
            var1_1.append("Assertion failed ");
            var1_1.append((Object)var2_5);
            var1_1 = new Error(var1_1.toString());
            throw var1_1;
        }
        {
            if (var6_10 instanceof Text) {
                var9_15.addElement((Text)var6_10);
            }
            var6_10 = var6_10.getNextSibling();
            ** continue;
        }
    }
}
