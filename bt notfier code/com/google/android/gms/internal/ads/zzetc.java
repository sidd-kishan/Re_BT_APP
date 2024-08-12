/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcfw
 *  com.google.android.gms.internal.ads.zzcge
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesz
 *  com.google.android.gms.internal.ads.zzeta
 *  com.google.android.gms.internal.ads.zzetb
 *  com.google.android.gms.internal.ads.zzetd
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfst
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcfw;
import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesz;
import com.google.android.gms.internal.ads.zzeta;
import com.google.android.gms.internal.ads.zzetb;
import com.google.android.gms.internal.ads.zzetd;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfst;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzetc
implements zzery<zzetd> {
    private final Context zza;
    private final zzcge zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final String zze;
    private final zzcfw zzf;

    public zzetc(zzcfw zzcfw2, int n, Context context, zzcge zzcge2, ScheduledExecutorService scheduledExecutorService, Executor executor, String string, byte[] byArray) {
        this.zzf = zzcfw2;
        this.zza = context;
        this.zzb = zzcge2;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zze = string;
    }

    public final zzfsm<zzetd> zza() {
        zzfsm zzfsm2 = zzfsd.zzj((zzfsm)zzfru.zzw((zzfsm)zzfsd.zze((zzfrj)new zzesz(this), (Executor)this.zzd)), (zzfln)zzeta.zza, (Executor)this.zzd);
        zzbjd zzbjd2 = zzbjl.zzaG;
        return zzfsd.zzf((zzfsm)((zzfru)zzfsd.zzh((zzfsm)zzfsm2, (long)((Long)zzbet.zzc().zzc(zzbjd2)), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzc)), Exception.class, (zzfln)new zzetb(this), (Executor)zzfst.zza());
    }

    final /* synthetic */ zzetd zzb(Exception exception) {
        this.zzb.zzk((Throwable)exception, "AttestationTokenSignal");
        return null;
    }
}
