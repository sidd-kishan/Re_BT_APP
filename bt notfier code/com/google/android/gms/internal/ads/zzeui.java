/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzblk
 *  com.google.android.gms.internal.ads.zzcfu
 *  com.google.android.gms.internal.ads.zzcge
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzeug
 *  com.google.android.gms.internal.ads.zzeuh
 *  com.google.android.gms.internal.ads.zzeuj
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblk;
import com.google.android.gms.internal.ads.zzcfu;
import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzeug;
import com.google.android.gms.internal.ads.zzeuh;
import com.google.android.gms.internal.ads.zzeuj;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzeui
implements zzery<zzeuj> {
    private final zzcge zza;
    private final boolean zzb;
    private final ScheduledExecutorService zzc;
    private final zzfsn zzd;
    private final String zze;
    private final zzcfu zzf;

    zzeui(zzcge zzcge2, boolean bl, zzcfu zzcfu2, zzfsn zzfsn2, String string, ScheduledExecutorService scheduledExecutorService, byte[] byArray) {
        this.zza = zzcge2;
        this.zzb = bl;
        this.zzf = zzcfu2;
        this.zzd = zzfsn2;
        this.zze = string;
        this.zzc = scheduledExecutorService;
    }

    public final zzfsm<zzeuj> zza() {
        if ((Boolean)zzblk.zza.zze() != false) return zzfsd.zzf((zzfsm)zzfsd.zzh((zzfsm)zzfsd.zzj((zzfsm)zzfsd.zza(null), (zzfln)zzeug.zza, (Executor)this.zzd), (long)((Long)zzblk.zzc.zze()), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzc), Exception.class, (zzfln)new zzeuh(this), (Executor)this.zzd);
        if (this.zzb) return zzfsd.zzf((zzfsm)zzfsd.zzh((zzfsm)zzfsd.zzj((zzfsm)zzfsd.zza(null), (zzfln)zzeug.zza, (Executor)this.zzd), (long)((Long)zzblk.zzc.zze()), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzc), Exception.class, (zzfln)new zzeuh(this), (Executor)this.zzd);
        return zzfsd.zza(null);
    }

    final /* synthetic */ zzeuj zzb(Exception exception) {
        this.zza.zzk((Throwable)exception, "TrustlessTokenSignal");
        return null;
    }
}
