/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.BooleanExpr;

public abstract class AttrExpr
extends BooleanExpr {
    private final String attrName_;

    AttrExpr(String string) {
        this.attrName_ = string;
    }

    public String getAttrName() {
        return this.attrName_;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(this.attrName_);
        return stringBuffer.toString();
    }
}
