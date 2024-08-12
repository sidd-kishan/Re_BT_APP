/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;

public class TrueExpr
extends BooleanExpr {
    static final TrueExpr INSTANCE = new TrueExpr();

    private TrueExpr() {
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return "";
    }
}
