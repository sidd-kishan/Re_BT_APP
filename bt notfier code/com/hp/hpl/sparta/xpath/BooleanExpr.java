/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.BooleanExprVisitor
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.XPathException;

public abstract class BooleanExpr {
    public abstract void accept(BooleanExprVisitor var1) throws XPathException;
}
