/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.Node
 *  com.hp.hpl.sparta.NodeListWithPosition
 *  com.hp.hpl.sparta.Text
 *  com.hp.hpl.sparta.XPathVisitor$BooleanStack
 *  com.hp.hpl.sparta.xpath.AllElementTest
 *  com.hp.hpl.sparta.xpath.AttrEqualsExpr
 *  com.hp.hpl.sparta.xpath.AttrExistsExpr
 *  com.hp.hpl.sparta.xpath.AttrGreaterExpr
 *  com.hp.hpl.sparta.xpath.AttrLessExpr
 *  com.hp.hpl.sparta.xpath.AttrNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.AttrTest
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 *  com.hp.hpl.sparta.xpath.ElementTest
 *  com.hp.hpl.sparta.xpath.ParentNodeTest
 *  com.hp.hpl.sparta.xpath.PositionEqualsExpr
 *  com.hp.hpl.sparta.xpath.Step
 *  com.hp.hpl.sparta.xpath.TextEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextExistsExpr
 *  com.hp.hpl.sparta.xpath.TextNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextTest
 *  com.hp.hpl.sparta.xpath.ThisNodeTest
 *  com.hp.hpl.sparta.xpath.TrueExpr
 *  com.hp.hpl.sparta.xpath.Visitor
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.Node;
import com.hp.hpl.sparta.NodeListWithPosition;
import com.hp.hpl.sparta.Text;
import com.hp.hpl.sparta.XPathVisitor;
import com.hp.hpl.sparta.xpath.AllElementTest;
import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.hp.hpl.sparta.xpath.AttrLessExpr;
import com.hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrTest;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.ElementTest;
import com.hp.hpl.sparta.xpath.ParentNodeTest;
import com.hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.TextEqualsExpr;
import com.hp.hpl.sparta.xpath.TextExistsExpr;
import com.hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.hp.hpl.sparta.xpath.TextTest;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
import com.hp.hpl.sparta.xpath.TrueExpr;
import com.hp.hpl.sparta.xpath.Visitor;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

class XPathVisitor
implements Visitor {
    private static final Boolean FALSE;
    private static final Boolean TRUE;
    private Node contextNode_;
    private final BooleanStack exprStack_;
    private boolean multiLevel_;
    private Object node_ = null;
    private Vector nodelistFiltered_;
    private final NodeListWithPosition nodelistRaw_ = new NodeListWithPosition();
    private Enumeration nodesetIterator_ = null;
    private XPath xpath_;

    static {
        TRUE = new Boolean(true);
        FALSE = new Boolean(false);
    }

    public XPathVisitor(Document document, XPath xPath) throws XPathException {
        this(xPath, (Node)document);
    }

    public XPathVisitor(Element element, XPath xPath) throws XPathException {
        this(xPath, (Node)element);
        if (xPath.isAbsolute()) throw new XPathException(xPath, "Cannot use element as context node for absolute xpath");
    }

    private XPathVisitor(XPath object, Node object2) throws XPathException {
        this.nodelistFiltered_ = new Vector();
        this.exprStack_ = new BooleanStack(null);
        this.xpath_ = object;
        this.contextNode_ = object2;
        object2 = new Vector(1);
        this.nodelistFiltered_ = object2;
        ((Vector)object2).addElement(this.contextNode_);
        object = object.getSteps();
        block0: while (object.hasMoreElements()) {
            object2 = (Step)object.nextElement();
            this.multiLevel_ = object2.isMultiLevel();
            this.nodesetIterator_ = null;
            object2.getNodeTest().accept((Visitor)this);
            this.nodesetIterator_ = this.nodelistRaw_.iterator();
            this.nodelistFiltered_.removeAllElements();
            object2 = object2.getPredicate();
            while (true) {
                if (!this.nodesetIterator_.hasMoreElements()) continue block0;
                this.node_ = this.nodesetIterator_.nextElement();
                object2.accept((BooleanExprVisitor)this);
                if (!this.exprStack_.pop().booleanValue()) continue;
                this.nodelistFiltered_.addElement(this.node_);
            }
            break;
        }
        return;
    }

    private void accumulateElements(Document document) {
        document = document.getDocumentElement();
        this.nodelistRaw_.add((Node)document, 1);
        if (!this.multiLevel_) return;
        this.accumulateElements((Element)document);
    }

    private void accumulateElements(Element element) {
        element = element.getFirstChild();
        int n = 0;
        while (element != null) {
            int n2 = n++;
            if (element instanceof Element) {
                NodeListWithPosition nodeListWithPosition = this.nodelistRaw_;
                nodeListWithPosition.add((Node)element, n);
                n2 = n;
                if (this.multiLevel_) {
                    this.accumulateElements(element);
                    n2 = n;
                }
            }
            element = element.getNextSibling();
            n = n2;
        }
        return;
    }

    private void accumulateMatchingElements(Document document, String string) {
        if ((document = document.getDocumentElement()) == null) {
            return;
        }
        if (document.getTagName() == string) {
            this.nodelistRaw_.add((Node)document, 1);
        }
        if (!this.multiLevel_) return;
        this.accumulateMatchingElements((Element)document, string);
    }

    private void accumulateMatchingElements(Element element, String string) {
        element = element.getFirstChild();
        int n = 0;
        while (element != null) {
            int n2 = n;
            if (element instanceof Element) {
                Element element2 = element;
                int n3 = n;
                if (element2.getTagName() == string) {
                    NodeListWithPosition nodeListWithPosition = this.nodelistRaw_;
                    n3 = n + 1;
                    nodeListWithPosition.add((Node)element2, n3);
                }
                n2 = n3;
                if (this.multiLevel_) {
                    this.accumulateMatchingElements(element2, string);
                    n2 = n3;
                }
            }
            element = element.getNextSibling();
            n = n2;
        }
        return;
    }

    public Element getFirstResultElement() {
        Element element = this.nodelistFiltered_.size() == 0 ? null : (Element)this.nodelistFiltered_.elementAt(0);
        return element;
    }

    public String getFirstResultString() {
        String string = this.nodelistFiltered_.size() == 0 ? null : this.nodelistFiltered_.elementAt(0).toString();
        return string;
    }

    public Enumeration getResultEnumeration() {
        return this.nodelistFiltered_.elements();
    }

    public void visit(AllElementTest object) {
        object = this.nodelistFiltered_;
        this.nodelistRaw_.removeAllElements();
        Enumeration enumeration = object.elements();
        while (enumeration.hasMoreElements()) {
            object = enumeration.nextElement();
            if (object instanceof Element) {
                this.accumulateElements((Element)object);
                continue;
            }
            if (!(object instanceof Document)) continue;
            this.accumulateElements((Document)object);
        }
        return;
    }

    public void visit(AttrEqualsExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) throw new XPathException(this.xpath_, "Cannot test attribute of document");
        object2 = ((Element)object2).getAttribute(object.getAttrName());
        boolean bl = object.getAttrValue().equals(object2);
        object2 = this.exprStack_;
        object = bl ? TRUE : FALSE;
        object2.push((Boolean)object);
    }

    public void visit(AttrExistsExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) throw new XPathException(this.xpath_, "Cannot test attribute of document");
        boolean bl = (object = ((Element)object2).getAttribute(object.getAttrName())) != null && ((String)object).length() > 0;
        object2 = this.exprStack_;
        object = bl ? TRUE : FALSE;
        object2.push((Boolean)object);
    }

    public void visit(AttrGreaterExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) throw new XPathException(this.xpath_, "Cannot test attribute of document");
        boolean bl = (double)Long.parseLong(((Element)object2).getAttribute(object.getAttrName())) > object.getAttrValue();
        object2 = this.exprStack_;
        object = bl ? TRUE : FALSE;
        object2.push((Boolean)object);
    }

    public void visit(AttrLessExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) throw new XPathException(this.xpath_, "Cannot test attribute of document");
        boolean bl = (double)Long.parseLong(((Element)object2).getAttribute(object.getAttrName())) < object.getAttrValue();
        object2 = this.exprStack_;
        object = bl ? TRUE : FALSE;
        object2.push((Boolean)object);
    }

    public void visit(AttrNotEqualsExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) throw new XPathException(this.xpath_, "Cannot test attribute of document");
        object2 = ((Element)object2).getAttribute(object.getAttrName());
        boolean bl = object.getAttrValue().equals(object2);
        object2 = this.exprStack_;
        object = bl ^ true ? TRUE : FALSE;
        object2.push((Boolean)object);
    }

    public void visit(AttrTest attrTest) {
        Object object = this.nodelistFiltered_;
        this.nodelistRaw_.removeAllElements();
        object = ((Vector)object).elements();
        while (object.hasMoreElements()) {
            Object object2 = (Node)object.nextElement();
            if (!(object2 instanceof Element) || (object2 = ((Element)object2).getAttribute(attrTest.getAttrName())) == null) continue;
            this.nodelistRaw_.add((String)object2);
        }
        return;
    }

    public void visit(ElementTest object) {
        String string = object.getTagName();
        object = this.nodelistFiltered_;
        int n = ((Vector)object).size();
        this.nodelistRaw_.removeAllElements();
        int n2 = 0;
        while (n2 < n) {
            Object e = ((Vector)object).elementAt(n2);
            if (e instanceof Element) {
                this.accumulateMatchingElements((Element)e, string);
            } else if (e instanceof Document) {
                this.accumulateMatchingElements((Document)e, string);
            }
            ++n2;
        }
        return;
    }

    public void visit(ParentNodeTest parentNodeTest) throws XPathException {
        this.nodelistRaw_.removeAllElements();
        parentNodeTest = this.contextNode_.getParentNode();
        if (parentNodeTest == null) throw new XPathException(this.xpath_, "Illegal attempt to apply \"..\" to node with no parent.");
        this.nodelistRaw_.add((Node)parentNodeTest, 1);
    }

    public void visit(PositionEqualsExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) throw new XPathException(this.xpath_, "Cannot test position of document");
        boolean bl = this.nodelistRaw_.position((Node)(object2 = (Element)object2)) == object.getPosition();
        object2 = this.exprStack_;
        object = bl ? TRUE : FALSE;
        object2.push((Boolean)object);
    }

    public void visit(TextEqualsExpr object) throws XPathException {
        Object object2 = this.node_;
        if (!(object2 instanceof Element)) {
            object = new XPathException(this.xpath_, "Cannot test attribute of document");
            throw object;
        }
        object2 = ((Element)object2).getFirstChild();
        while (true) {
            if (object2 == null) {
                object2 = this.exprStack_;
                object = FALSE;
                break;
            }
            if (object2 instanceof Text && ((Text)object2).getData().equals(object.getValue())) {
                object2 = this.exprStack_;
                object = TRUE;
                break;
            }
            object2 = object2.getNextSibling();
        }
        object2.push((Boolean)object);
    }

    public void visit(TextExistsExpr object) throws XPathException {
        BooleanStack booleanStack;
        object = this.node_;
        if (!(object instanceof Element)) {
            object = new XPathException(this.xpath_, "Cannot test attribute of document");
            throw object;
        }
        object = ((Element)object).getFirstChild();
        while (true) {
            if (object == null) {
                booleanStack = this.exprStack_;
                object = FALSE;
                break;
            }
            if (object instanceof Text) {
                booleanStack = this.exprStack_;
                object = TRUE;
                break;
            }
            object = object.getNextSibling();
        }
        booleanStack.push((Boolean)object);
    }

    public void visit(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
        Object object = this.node_;
        if (!(object instanceof Element)) {
            textNotEqualsExpr = new XPathException(this.xpath_, "Cannot test attribute of document");
            throw textNotEqualsExpr;
        }
        object = ((Element)object).getFirstChild();
        while (true) {
            if (object == null) {
                textNotEqualsExpr = this.exprStack_;
                object = FALSE;
                break;
            }
            if (object instanceof Text && !((Text)object).getData().equals(textNotEqualsExpr.getValue())) {
                textNotEqualsExpr = this.exprStack_;
                object = TRUE;
                break;
            }
            object = object.getNextSibling();
        }
        textNotEqualsExpr.push((Boolean)object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void visit(TextTest var1_1) {
        var1_1 /* !! */  = this.nodelistFiltered_;
        this.nodelistRaw_.removeAllElements();
        var2_2 = var1_1 /* !! */ .elements();
        block0: while (true) {
            if (!var2_2.hasMoreElements()) {
                return;
            }
            var1_1 /* !! */  = var2_2.nextElement();
            if (!(var1_1 /* !! */  instanceof Element)) continue;
            var1_1 /* !! */  = ((Element)var1_1 /* !! */ ).getFirstChild();
            while (true) {
                if (var1_1 /* !! */  != null) ** break;
                continue block0;
                if (var1_1 /* !! */  instanceof Text) {
                    this.nodelistRaw_.add(((Text)var1_1 /* !! */ ).getData());
                }
                var1_1 /* !! */  = var1_1 /* !! */ .getNextSibling();
            }
            break;
        }
    }

    public void visit(ThisNodeTest thisNodeTest) {
        this.nodelistRaw_.removeAllElements();
        this.nodelistRaw_.add(this.contextNode_, 1);
    }

    public void visit(TrueExpr trueExpr) {
        this.exprStack_.push(TRUE);
    }
}
