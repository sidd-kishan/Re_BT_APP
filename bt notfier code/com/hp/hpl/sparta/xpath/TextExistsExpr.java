/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.XPathException;

public class TextExistsExpr
extends BooleanExpr {
    static final TextExistsExpr INSTANCE = new TextExistsExpr();

    private TextExistsExpr() {
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return "[text()]";
    }
}
