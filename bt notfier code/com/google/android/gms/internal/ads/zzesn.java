/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings$Secure
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcfw
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesl
 *  com.google.android.gms.internal.ads.zzesm
 *  com.google.android.gms.internal.ads.zzeso
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcfw;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesl;
import com.google.android.gms.internal.ads.zzesm;
import com.google.android.gms.internal.ads.zzeso;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzesn
implements zzery<zzeso> {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final zzcfw zze;

    public zzesn(zzcfw zzcfw2, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int n, byte[] byArray) {
        this.zze = zzcfw2;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = n;
    }

    public final zzfsm<zzeso> zza() {
        zzbjd zzbjd2 = zzbjl.zzaF;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return zzfsd.zzc((Throwable)new Exception("Did not ad Ad ID into query param."));
        zzfsm zzfsm2 = zzfsd.zzj((zzfsm)zzfru.zzw((zzfsm)this.zze.zza(this.zza, this.zzd)), (zzfln)zzesl.zza, (Executor)this.zzc);
        zzbjd2 = zzbjl.zzaG;
        return zzfsd.zzf((zzfsm)((zzfru)zzfsd.zzh((zzfsm)zzfsm2, (long)((Long)zzbet.zzc().zzc(zzbjd2)), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzb)), Throwable.class, (zzfln)new zzesm(this), (Executor)this.zzc);
    }

    final /* synthetic */ zzeso zzb(Throwable object) {
        zzber.zza();
        object = this.zza.getContentResolver();
        object = object == null ? null : Settings.Secure.getString((ContentResolver)object, (String)"android_id");
        return new zzeso(null, (String)object);
    }
}
