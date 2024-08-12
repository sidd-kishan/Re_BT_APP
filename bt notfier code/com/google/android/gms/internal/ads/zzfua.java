/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfua<P> {
    private final P zza;
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    zzfua(P p, byte[] byArray, int n, int n2, int n3) {
        this.zza = p;
        this.zzb = Arrays.copyOf(byArray, byArray.length);
        this.zzc = n;
        this.zzd = n2;
    }

    public final P zza() {
        return this.zza;
    }

    public final byte[] zzb() {
        byte[] byArray = this.zzb;
        if (byArray != null) return Arrays.copyOf(byArray, byArray.length);
        return null;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }
}
