/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzrf
 *  com.google.android.gms.internal.ads.zzrv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzrv;

final class zzrw {
    public zzrf zza;
    public long zzb;
    public long zzc;
    public int zzd;
    public int zze;
    public long[] zzf = new long[0];
    public int[] zzg = new int[0];
    public int[] zzh = new int[0];
    public int[] zzi = new int[0];
    public long[] zzj = new long[0];
    public boolean[] zzk = new boolean[0];
    public boolean zzl;
    public boolean[] zzm = new boolean[0];
    public zzrv zzn;
    public final zzamf zzo = new zzamf();
    public boolean zzp;
    public long zzq;
    public boolean zzr;

    public final void zza(int n) {
        this.zzo.zza(n);
        this.zzl = true;
        this.zzp = true;
    }

    public final long zzb(int n) {
        return this.zzj[n] + (long)this.zzi[n];
    }

    public final boolean zzc(int n) {
        if (!this.zzl) return false;
        if (!this.zzm[n]) return false;
        return true;
    }
}
