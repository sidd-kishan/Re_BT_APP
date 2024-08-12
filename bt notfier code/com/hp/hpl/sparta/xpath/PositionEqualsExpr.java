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

public class PositionEqualsExpr
extends BooleanExpr {
    private final int position_;

    public PositionEqualsExpr(int n) {
        this.position_ = n;
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public int getPosition() {
        return this.position_;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(this.position_);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
