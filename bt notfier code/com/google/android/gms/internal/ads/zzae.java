/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzae
extends IllegalStateException {
    public zzae(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(44);
        stringBuilder.append("Buffer too small (");
        stringBuilder.append(n);
        stringBuilder.append(" < ");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        super(stringBuilder.toString());
    }
}
