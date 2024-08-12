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

public class AttrTest
extends NodeTest {
    private final String attrName_;

    AttrTest(String string) {
        this.attrName_ = string;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getAttrName() {
        return this.attrName_;
    }

    public boolean isStringValue() {
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(this.attrName_);
        return stringBuffer.toString();
    }
}
