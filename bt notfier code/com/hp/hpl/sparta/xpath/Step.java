/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.AllElementTest
 *  com.hp.hpl.sparta.xpath.AttrTest
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 *  com.hp.hpl.sparta.xpath.ElementTest
 *  com.hp.hpl.sparta.xpath.ExprFactory
 *  com.hp.hpl.sparta.xpath.NodeTest
 *  com.hp.hpl.sparta.xpath.ParentNodeTest
 *  com.hp.hpl.sparta.xpath.SimpleStreamTokenizer
 *  com.hp.hpl.sparta.xpath.TextTest
 *  com.hp.hpl.sparta.xpath.ThisNodeTest
 *  com.hp.hpl.sparta.xpath.TrueExpr
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.AllElementTest;
import com.hp.hpl.sparta.xpath.AttrTest;
import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.ElementTest;
import com.hp.hpl.sparta.xpath.ExprFactory;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.ParentNodeTest;
import com.hp.hpl.sparta.xpath.SimpleStreamTokenizer;
import com.hp.hpl.sparta.xpath.TextTest;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
import com.hp.hpl.sparta.xpath.TrueExpr;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;

public class Step {
    public static Step DOT = new Step((NodeTest)ThisNodeTest.INSTANCE, (BooleanExpr)TrueExpr.INSTANCE);
    private final boolean multiLevel_;
    private final NodeTest nodeTest_;
    private final BooleanExpr predicate_;

    Step(NodeTest nodeTest, BooleanExpr booleanExpr) {
        this.nodeTest_ = nodeTest;
        this.predicate_ = booleanExpr;
        this.multiLevel_ = false;
    }

    Step(XPath xPath, boolean bl, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        AllElementTest allElementTest;
        this.multiLevel_ = bl;
        int n = simpleStreamTokenizer.ttype;
        if (n != -3) {
            if (n != 42) {
                if (n != 46) {
                    if (n != 64) throw new XPathException(xPath, "at begininning of step", simpleStreamTokenizer, "'.' or '*' or name");
                    if (simpleStreamTokenizer.nextToken() != -3) throw new XPathException(xPath, "after @ in node test", simpleStreamTokenizer, "name");
                    allElementTest = new AttrTest(simpleStreamTokenizer.sval);
                } else if (simpleStreamTokenizer.nextToken() == 46) {
                    allElementTest = ParentNodeTest.INSTANCE;
                } else {
                    simpleStreamTokenizer.pushBack();
                    allElementTest = ThisNodeTest.INSTANCE;
                }
            } else {
                allElementTest = AllElementTest.INSTANCE;
            }
        } else if (simpleStreamTokenizer.sval.equals("text")) {
            if (simpleStreamTokenizer.nextToken() != 40) throw new XPathException(xPath, "after text", simpleStreamTokenizer, "()");
            if (simpleStreamTokenizer.nextToken() != 41) throw new XPathException(xPath, "after text", simpleStreamTokenizer, "()");
            allElementTest = TextTest.INSTANCE;
        } else {
            allElementTest = new ElementTest(simpleStreamTokenizer.sval);
        }
        this.nodeTest_ = allElementTest;
        if (simpleStreamTokenizer.nextToken() == 91) {
            simpleStreamTokenizer.nextToken();
            this.predicate_ = ExprFactory.createExpr((XPath)xPath, (SimpleStreamTokenizer)simpleStreamTokenizer);
            if (simpleStreamTokenizer.ttype != 93) throw new XPathException(xPath, "after predicate expression", simpleStreamTokenizer, "]");
            simpleStreamTokenizer.nextToken();
        } else {
            this.predicate_ = TrueExpr.INSTANCE;
        }
    }

    public NodeTest getNodeTest() {
        return this.nodeTest_;
    }

    public BooleanExpr getPredicate() {
        return this.predicate_;
    }

    public boolean isMultiLevel() {
        return this.multiLevel_;
    }

    public boolean isStringValue() {
        return this.nodeTest_.isStringValue();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.nodeTest_.toString());
        stringBuffer.append(this.predicate_.toString());
        return stringBuffer.toString();
    }
}
