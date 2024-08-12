/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzaos
extends Exception {
    public zzaos(int n) {
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("AudioTrack write failed: ");
        stringBuilder.append(n);
        super(stringBuilder.toString());
    }
}
