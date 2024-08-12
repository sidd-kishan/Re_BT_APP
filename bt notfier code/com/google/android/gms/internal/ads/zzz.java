/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public class zzz {
    private int zza;

    public void zza() {
        this.zza = 0;
    }

    public final boolean zzb() {
        return this.zzh(Integer.MIN_VALUE);
    }

    public final boolean zzc() {
        return this.zzh(4);
    }

    public final boolean zzd() {
        return this.zzh(1);
    }

    public final boolean zze() {
        return this.zzh(0x10000000);
    }

    public final void zzf(int n) {
        this.zza = n;
    }

    public final void zzg(int n) {
        this.zza |= Integer.MIN_VALUE;
    }

    protected final boolean zzh(int n) {
        if ((this.zza & n) != n) return false;
        return true;
    }
}
