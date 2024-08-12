/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Sparta
 *  com.hp.hpl.sparta.xpath.NodeTest
 *  com.hp.hpl.sparta.xpath.Visitor
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.xpath.NodeTest;
import com.hp.hpl.sparta.xpath.Visitor;

public class ElementTest
extends NodeTest {
    private final String tagName_;

    ElementTest(String string) {
        this.tagName_ = Sparta.intern((String)string);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getTagName() {
        return this.tagName_;
    }

    public boolean isStringValue() {
        return false;
    }

    public String toString() {
        return this.tagName_;
    }
}
