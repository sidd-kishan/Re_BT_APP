/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Sparta
 *  com.hp.hpl.sparta.xpath.AttrExpr
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.xpath.AttrExpr;

public abstract class AttrCompareExpr
extends AttrExpr {
    private final String attrValue_;

    AttrCompareExpr(String string, String string2) {
        super(string);
        this.attrValue_ = Sparta.intern((String)string2);
    }

    public String getAttrValue() {
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
