/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 *  com.hp.hpl.sparta.xpath.TextCompareExpr
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.TextCompareExpr;
import com.hp.hpl.sparta.xpath.XPathException;

public class TextNotEqualsExpr
extends TextCompareExpr {
    TextNotEqualsExpr(String string) {
        super(string);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return this.toString("!=");
    }
}
