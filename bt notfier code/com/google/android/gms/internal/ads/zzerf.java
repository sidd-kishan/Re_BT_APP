/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzerb
 *  com.google.android.gms.internal.ads.zzerc
 *  com.google.android.gms.internal.ads.zzerg
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzerb;
import com.google.android.gms.internal.ads.zzerc;
import com.google.android.gms.internal.ads.zzerg;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzerf
implements zzery<zzerg> {
    private final String zza;
    private final zzfsn zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfar zze;
    private final zzcoj zzf;

    zzerf(zzfsn zzfsn2, ScheduledExecutorService scheduledExecutorService, String string, Context context, zzfar zzfar2, zzcoj zzcoj2) {
        this.zzb = zzfsn2;
        this.zzc = scheduledExecutorService;
        this.zza = string;
        this.zzd = context;
        this.zze = zzfar2;
        this.zzf = zzcoj2;
    }

    public final zzfsm<zzerg> zza() {
        zzbjd zzbjd2 = zzbjl.zzfm;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return this.zzb.zzb(zzerb.zza);
        if (!"adUnitId".equals(this.zze.zzf)) return zzfsd.zze((zzfrj)new zzerc(this), (Executor)this.zzb);
        return this.zzb.zzb(zzerb.zza);
    }
}
