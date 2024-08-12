/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdyq
 *  com.google.android.gms.internal.ads.zzdzm
 *  com.google.android.gms.internal.ads.zzdzn
 *  com.google.android.gms.internal.ads.zzdzo
 *  com.google.android.gms.internal.ads.zzeao
 *  com.google.android.gms.internal.ads.zzecu
 *  com.google.android.gms.internal.ads.zzfai
 *  com.google.android.gms.internal.ads.zzfak
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzdzm;
import com.google.android.gms.internal.ads.zzdzn;
import com.google.android.gms.internal.ads.zzdzo;
import com.google.android.gms.internal.ads.zzeao;
import com.google.android.gms.internal.ads.zzecu;
import com.google.android.gms.internal.ads.zzfai;
import com.google.android.gms.internal.ads.zzfak;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzdzp
implements zzeao {
    private static final Pattern zzf = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdyq zza;
    private final zzfsn zzb;
    private final zzfar zzc;
    private final ScheduledExecutorService zzd;
    private final zzecu zze;

    zzdzp(zzfar zzfar2, zzdyq zzdyq2, zzfsn zzfsn2, ScheduledExecutorService scheduledExecutorService, zzecu zzecu2) {
        this.zzc = zzfar2;
        this.zza = zzdyq2;
        this.zzb = zzfsn2;
        this.zzd = scheduledExecutorService;
        this.zze = zzecu2;
    }

    static /* synthetic */ zzecu zza(zzdzp zzdzp2) {
        return zzdzp2.zze;
    }

    static /* synthetic */ Pattern zzb() {
        return zzf;
    }

    public final zzfsm<zzfal> zzc(zzcbj zzcbj2) {
        zzfsm zzfsm2 = zzfsd.zzi((zzfsm)this.zza.zza(zzcbj2), (zzfrk)new zzdzm(this), (Executor)this.zzb);
        zzbjd zzbjd2 = zzbjl.zzdO;
        zzcbj2 = zzfsm2;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzcbj2 = zzbjl.zzdP;
            zzcbj2 = zzfsd.zzg((zzfsm)zzfsd.zzh((zzfsm)zzfsm2, (long)((Integer)zzbet.zzc().zzc((zzbjd)zzcbj2)).intValue(), (TimeUnit)TimeUnit.SECONDS, (ScheduledExecutorService)this.zzd), TimeoutException.class, (zzfrk)zzdzn.zza, (Executor)zzchg.zzf);
        }
        zzfsd.zzp((zzfsm)zzcbj2, (zzfrz)new zzdzo(this), (Executor)zzchg.zzf);
        return zzcbj2;
    }

    final /* synthetic */ zzfsm zzd(InputStream inputStream) throws Exception {
        return zzfsd.zza((Object)new zzfal(new zzfai(this.zzc), zzfak.zza((Reader)new InputStreamReader(inputStream))));
    }
}
