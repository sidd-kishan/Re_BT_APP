/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzaum
extends IOException {
    public zzaum(Throwable throwable) {
        String string = throwable.getClass().getSimpleName();
        String string2 = throwable.getMessage();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 13 + String.valueOf(string2).length());
        stringBuilder.append("Unexpected ");
        stringBuilder.append(string);
        stringBuilder.append(": ");
        stringBuilder.append(string2);
        super(stringBuilder.toString(), throwable);
    }
}
