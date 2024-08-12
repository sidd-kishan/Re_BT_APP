/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.NodeTest
 *  com.hp.hpl.sparta.xpath.Visitor
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;

public class AllElementTest
extends NodeTest {
    static final AllElementTest INSTANCE = new AllElementTest();

    private AllElementTest() {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean isStringValue() {
        return false;
    }

    public String toString() {
        return "*";
    }
}
