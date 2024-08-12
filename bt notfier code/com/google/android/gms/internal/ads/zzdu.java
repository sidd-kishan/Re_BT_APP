/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzdu
extends Exception {
    public zzdu(long l, long l2) {
        StringBuilder stringBuilder = new StringBuilder(103);
        stringBuilder.append("Unexpected audio track timestamp discontinuity: expected ");
        stringBuilder.append(l2);
        stringBuilder.append(", got ");
        stringBuilder.append(l);
        super(stringBuilder.toString());
    }
}
