/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.NodeTest
 *  com.hp.hpl.sparta.xpath.Visitor
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;
import com.hp.hpl.sparta.xpath.XPathException;

public class TextTest
extends NodeTest {
    static final TextTest INSTANCE = new TextTest();

    private TextTest() {
    }

    public void accept(Visitor visitor) throws XPathException {
        visitor.visit(this);
    }

    public boolean isStringValue() {
        return true;
    }

    public String toString() {
        return "text()";
    }
}
