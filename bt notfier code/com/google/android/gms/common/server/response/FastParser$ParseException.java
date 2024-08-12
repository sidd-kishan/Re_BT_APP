/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.server.response;

public static class FastParser.ParseException
extends Exception {
    public FastParser.ParseException(String string) {
        super(string);
    }

    public FastParser.ParseException(String string, Throwable throwable) {
        super("Error instantiating inner object", throwable);
    }

    public FastParser.ParseException(Throwable throwable) {
        super(throwable);
    }
}
