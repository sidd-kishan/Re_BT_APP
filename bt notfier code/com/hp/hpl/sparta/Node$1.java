/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.Node
 *  com.hp.hpl.sparta.Text
 *  com.hp.hpl.sparta.xpath.AttrEqualsExpr
 *  com.hp.hpl.sparta.xpath.AttrExistsExpr
 *  com.hp.hpl.sparta.xpath.AttrGreaterExpr
 *  com.hp.hpl.sparta.xpath.AttrLessExpr
 *  com.hp.hpl.sparta.xpath.AttrNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 *  com.hp.hpl.sparta.xpath.PositionEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextExistsExpr
 *  com.hp.hpl.sparta.xpath.TextNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.TrueExpr
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.Text;
import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.hp.hpl.sparta.xpath.AttrLessExpr;
import com.hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.hp.hpl.sparta.xpath.TextEqualsExpr;
import com.hp.hpl.sparta.xpath.TextExistsExpr;
import com.hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.hp.hpl.sparta.xpath.TrueExpr;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;

class Node$1
implements BooleanExprVisitor {
    private final Node this$0;
    private final String val$msgContext;
    private final Element val$newChild;
    private final Element val$parent;
    private final String val$tagName;

    Node$1(Node node, Element element, Element element2, String string, String string2) throws XPathException {
        this.this$0 = node;
        this.val$newChild = element;
        this.val$parent = element2;
        this.val$msgContext = string;
        this.val$tagName = string2;
    }

    public void visit(AttrEqualsExpr attrEqualsExpr) throws XPathException {
        this.val$newChild.setAttribute(attrEqualsExpr.getAttrName(), attrEqualsExpr.getAttrValue());
    }

    public void visit(AttrExistsExpr attrExistsExpr) throws XPathException {
        this.val$newChild.setAttribute(attrExistsExpr.getAttrName(), "something");
    }

    public void visit(AttrGreaterExpr attrGreaterExpr) throws XPathException {
        this.val$newChild.setAttribute(attrGreaterExpr.getAttrName(), Long.toString(Long.MAX_VALUE));
    }

    public void visit(AttrLessExpr attrLessExpr) throws XPathException {
        this.val$newChild.setAttribute(attrLessExpr.getAttrName(), Long.toString(Long.MIN_VALUE));
    }

    public void visit(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException {
        Element element = this.val$newChild;
        String string = attrNotEqualsExpr.getAttrName();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("not ");
        stringBuffer.append(attrNotEqualsExpr.getAttrValue());
        element.setAttribute(string, stringBuffer.toString());
    }

    public void visit(PositionEqualsExpr positionEqualsExpr) throws XPathException {
        int n;
        int n2 = positionEqualsExpr.getPosition();
        positionEqualsExpr = this.val$parent;
        int n3 = n = 1;
        if (positionEqualsExpr == null) {
            if (n2 != 1) throw new XPathException(XPath.get((String)this.val$msgContext), "Position of root node must be 1");
            n3 = n;
        }
        while (n3 < n2) {
            this.val$parent.appendChild((Node)new Element(this.val$tagName));
            ++n3;
        }
        return;
    }

    public void visit(TextEqualsExpr textEqualsExpr) throws XPathException {
        this.val$newChild.appendChild((Node)new Text(textEqualsExpr.getValue()));
    }

    public void visit(TextExistsExpr textExistsExpr) throws XPathException {
        this.val$newChild.appendChild((Node)new Text("something"));
    }

    public void visit(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
        Element element = this.val$newChild;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("not ");
        stringBuffer.append(textNotEqualsExpr.getValue());
        element.appendChild((Node)new Text(stringBuffer.toString()));
    }

    public void visit(TrueExpr trueExpr) {
    }
}
