/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzget
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzget;

final class zzgeq
extends zzget {
    private final int zzc;
    private final int zzd;

    zzgeq(byte[] byArray, int n, int n2) {
        super(byArray);
        zzgeq.zzE((int)n, (int)(n + n2), (int)byArray.length);
        this.zzc = n;
        this.zzd = n2;
    }

    public final byte zza(int n) {
        zzgeq.zzD((int)n, (int)this.zzd);
        return this.zza[this.zzc + n];
    }

    final byte zzb(int n) {
        return this.zza[this.zzc + n];
    }

    public final int zzc() {
        return this.zzd;
    }

    protected final int zzd() {
        return this.zzc;
    }

    protected final void zze(byte[] byArray, int n, int n2, int n3) {
        System.arraycopy(this.zza, this.zzc + n, byArray, n2, n3);
    }
}
