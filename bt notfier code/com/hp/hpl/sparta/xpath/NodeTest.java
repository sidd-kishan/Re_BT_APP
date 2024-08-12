/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.Visitor
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.Visitor;
import com.hp.hpl.sparta.xpath.XPathException;

public abstract class NodeTest {
    public abstract void accept(Visitor var1) throws XPathException;

    public abstract boolean isStringValue();
}
