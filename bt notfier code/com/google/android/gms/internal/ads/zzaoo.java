/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzaoo
extends Exception {
    public zzaoo(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder(82);
        stringBuilder.append("AudioTrack init failed: ");
        stringBuilder.append(n);
        stringBuilder.append(", Config(");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append(n4);
        stringBuilder.append(")");
        super(stringBuilder.toString());
    }
}
