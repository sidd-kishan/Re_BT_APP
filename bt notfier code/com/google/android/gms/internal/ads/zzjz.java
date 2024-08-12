/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzahw
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzjy
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzahw;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzjy;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzs;

public abstract class zzjz {
    private zzjy zza;
    private zzki zzb;

    public abstract void zzi(Object var1);

    public abstract zzka zzj(zzahw[] var1, zzs var2, zzhf var3, zzaiq var4) throws zzaeg;

    public final void zzk(zzjy zzjy2, zzki zzki2) {
        this.zza = zzjy2;
        this.zzb = zzki2;
    }

    protected final void zzl() {
        zzjy zzjy2 = this.zza;
        if (zzjy2 == null) return;
        zzjy2.zza();
    }

    protected final zzki zzm() {
        zzki zzki2 = this.zzb;
        if (zzki2 == null) throw null;
        return zzki2;
    }
}
