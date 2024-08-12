/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbzu
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzett
 *  com.google.android.gms.internal.ads.zzetv
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzett;
import com.google.android.gms.internal.ads.zzetv;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzetu
implements zzery<zzetv> {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbzu zzc;

    public zzetu(zzbzu zzbzu2, ScheduledExecutorService scheduledExecutorService, Context context, byte[] byArray) {
        this.zzc = zzbzu2;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final zzfsm<zzetv> zza() {
        zzfsm zzfsm2 = zzfsd.zza((Object)new Bundle());
        zzbjd zzbjd2 = zzbjl.zzcy;
        return zzfsd.zzj((zzfsm)zzfsd.zzh((zzfsm)zzfsm2, (long)((Long)zzbet.zzc().zzc(zzbjd2)), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zza), (zzfln)zzett.zza, (Executor)zzchg.zza);
    }
}
