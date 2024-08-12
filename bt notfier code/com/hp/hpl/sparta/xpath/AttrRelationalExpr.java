/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.AttrExpr
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.AttrExpr;

public abstract class AttrRelationalExpr
extends AttrExpr {
    private final int attrValue_;

    AttrRelationalExpr(String string, int n) {
        super(string);
        this.attrValue_ = n;
    }

    public double getAttrValue() {
        return this.attrValue_;
    }

    protected String toString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(super.toString());
        stringBuffer.append(string);
        stringBuffer.append("'");
        stringBuffer.append(this.attrValue_);
        stringBuffer.append("']");
        return stringBuffer.toString();
    }
}
