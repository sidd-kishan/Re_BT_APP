/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.measurement;

final class zzkj
extends IllegalArgumentException {
    zzkj(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(n);
        stringBuilder.append(" of ");
        stringBuilder.append(n2);
        super(stringBuilder.toString());
    }
}
