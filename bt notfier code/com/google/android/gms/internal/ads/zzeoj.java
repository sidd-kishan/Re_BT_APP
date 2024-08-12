/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdtk
 *  com.google.android.gms.internal.ads.zzeoi
 *  com.google.android.gms.internal.ads.zzeok
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtk;
import com.google.android.gms.internal.ads.zzeoi;
import com.google.android.gms.internal.ads.zzeok;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzeoj
implements zzery<zzeok> {
    private final zzfsn zza;
    private final zzdtk zzb;
    private final String zzc;
    private final zzfar zzd;

    public zzeoj(zzfsn zzfsn2, zzdtk zzdtk2, zzfar zzfar2, String string) {
        this.zza = zzfsn2;
        this.zzb = zzdtk2;
        this.zzd = zzfar2;
        this.zzc = string;
    }

    public final zzfsm<zzeok> zza() {
        return this.zza.zzb((Callable)new zzeoi(this));
    }

    final /* synthetic */ zzeok zzb() throws Exception {
        return new zzeok(this.zzb.zzb(this.zzd.zzf, this.zzc), this.zzb.zzc());
    }
}
