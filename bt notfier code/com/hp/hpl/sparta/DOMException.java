/*
 * Decompiled with CFR 0.152.
 */
package com.hp.hpl.sparta;

public class DOMException
extends Exception {
    public static final short DOMSTRING_SIZE_ERR = 2;
    public static final short HIERARCHY_REQUEST_ERR = 3;
    public static final short NOT_FOUND_ERR = 8;
    public short code;

    public DOMException(short s, String string) {
        super(string);
        this.code = s;
    }
}
