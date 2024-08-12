/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException
extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1L;
    private final int statusCode;

    public HttpException(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Http request failed with status code: ");
        stringBuilder.append(n);
        this(stringBuilder.toString(), n);
    }

    public HttpException(String string) {
        this(string, -1);
    }

    public HttpException(String string, int n) {
        this(string, n, null);
    }

    public HttpException(String string, int n, Throwable throwable) {
        super(string, throwable);
        this.statusCode = n;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
