/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaqs
 *  com.google.android.gms.internal.ads.zzard
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzaux;

final class zzare {
    public zzaqs zza;
    public long zzb;
    public long zzc;
    public int zzd;
    public int zze;
    public long[] zzf;
    public int[] zzg;
    public int[] zzh;
    public int[] zzi;
    public long[] zzj;
    public boolean[] zzk;
    public boolean zzl;
    public boolean[] zzm;
    public zzard zzn;
    public int zzo;
    public zzaux zzp;
    public boolean zzq;
    public long zzr;

    zzare() {
    }

    public final void zza(int n) {
        zzaux zzaux2 = this.zzp;
        if (zzaux2 == null || zzaux2.zze() < n) {
            this.zzp = new zzaux(n);
        }
        this.zzo = n;
        this.zzl = true;
        this.zzq = true;
    }
}
