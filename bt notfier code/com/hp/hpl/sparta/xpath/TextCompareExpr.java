/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.BooleanExpr;

public abstract class TextCompareExpr
extends BooleanExpr {
    private final String value_;

    TextCompareExpr(String string) {
        this.value_ = string;
    }

    public String getValue() {
        return this.value_;
    }

    protected String toString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[text()");
        stringBuffer.append(string);
        stringBuffer.append("'");
        stringBuffer.append(this.value_);
        stringBuffer.append("']");
        return stringBuffer.toString();
    }
}
