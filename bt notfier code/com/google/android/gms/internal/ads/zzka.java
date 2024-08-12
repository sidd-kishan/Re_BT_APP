/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahx
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzjg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahx;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzjg;

public final class zzka {
    public final int zza;
    public final zzahx[] zzb;
    public final Object zzc;
    public final zzjg[] zzd;

    public zzka(zzahx[] zzahxArray, zzjg[] zzjgArray, Object object, byte[] byArray) {
        this.zzb = zzahxArray;
        this.zzd = (zzjg[])zzjgArray.clone();
        this.zzc = object;
        this.zza = zzahxArray.length;
    }

    public final boolean zza(int n) {
        if (this.zzb[n] == null) return false;
        return true;
    }

    public final boolean zzb(zzka zzka2, int n) {
        if (zzka2 == null) {
            return false;
        }
        if (!zzamq.zzc((Object)this.zzb[n], (Object)zzka2.zzb[n])) return false;
        if (!zzamq.zzc((Object)this.zzd[n], (Object)zzka2.zzd[n])) return false;
        return true;
    }
}
