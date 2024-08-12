/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.ParseException
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.ParseException;

public class EncodingMismatchException
extends ParseException {
    private String declaredEncoding_;

    EncodingMismatchException(String string, String string2, String string3) {
        char c = string2.charAt(string2.length() - 1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("encoding '");
        stringBuffer.append(string2);
        stringBuffer.append("' declared instead of of ");
        stringBuffer.append(string3);
        stringBuffer.append(" as expected");
        super(string, 0, (int)c, string2, stringBuffer.toString());
        this.declaredEncoding_ = string2;
    }

    String getDeclaredEncoding() {
        return this.declaredEncoding_;
    }
}
