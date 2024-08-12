/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagt
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzhb
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzhb;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhh;
import java.util.ArrayList;
import java.util.List;

final class zzagx
implements zzagt {
    public final zzhb zza;
    public final Object zzb;
    public final List<zzhf> zzc;
    public int zzd;
    public boolean zze;

    public zzagx(zzhh zzhh2, boolean bl) {
        this.zza = new zzhb(zzhh2, bl);
        this.zzc = new ArrayList<zzhf>();
        this.zzb = new Object();
    }

    public final void zza(int n) {
        this.zzd = n;
        this.zze = false;
        this.zzc.clear();
    }

    public final Object zzb() {
        return this.zzb;
    }

    public final zzaiq zzc() {
        return this.zza.zzy();
    }
}
