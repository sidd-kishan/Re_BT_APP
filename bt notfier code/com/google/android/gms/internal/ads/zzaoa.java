/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzaoa
extends Exception {
    public zzaoa(int n, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder(78);
        stringBuilder.append("Unhandled format: ");
        stringBuilder.append(n);
        stringBuilder.append(" Hz, ");
        stringBuilder.append(n2);
        stringBuilder.append(" channels in encoding ");
        stringBuilder.append(n3);
        super(stringBuilder.toString());
    }
}
