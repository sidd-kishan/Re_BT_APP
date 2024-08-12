/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public class zzapb {
    private int zza;

    public void zza() {
        this.zza = 0;
    }

    public final boolean zzb() {
        return this.zzg(Integer.MIN_VALUE);
    }

    public final boolean zzc() {
        return this.zzg(4);
    }

    public final boolean zzd() {
        return this.zzg(1);
    }

    public final void zze(int n) {
        this.zza = n;
    }

    public final void zzf(int n) {
        this.zza |= Integer.MIN_VALUE;
    }

    protected final boolean zzg(int n) {
        if ((this.zza & n) != n) return false;
        return true;
    }
}
