/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgp
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgp;

final class zzgm
extends zzgp {
    private final int zzc;

    zzgm(byte[] byArray, int n, int n2) {
        super(byArray);
        zzgm.zzn((int)0, (int)n2, (int)byArray.length);
        this.zzc = n2;
    }

    public final byte zza(int n) {
        int n2 = this.zzc;
        if ((n2 - (n + 1) | n) >= 0) return this.zza[n];
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder(22);
            stringBuilder.append("Index < 0: ");
            stringBuilder.append(n);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Index > length: ");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(n2);
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    final byte zzb(int n) {
        return this.zza[n];
    }

    public final int zzc() {
        return this.zzc;
    }

    protected final int zzd() {
        return 0;
    }
}
