/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.net;

public class ParseException
extends RuntimeException {
    public final String response;

    ParseException(String string) {
        super(string);
        this.response = string;
    }
}
