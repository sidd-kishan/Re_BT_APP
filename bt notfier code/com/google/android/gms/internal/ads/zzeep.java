/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbpu
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcus
 *  com.google.android.gms.internal.ads.zzcut
 *  com.google.android.gms.internal.ads.zzcuv
 *  com.google.android.gms.internal.ads.zzcva
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdjm
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzdsr
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzdsw
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzeel
 *  com.google.android.gms.internal.ads.zzeem
 *  com.google.android.gms.internal.ads.zzeen
 *  com.google.android.gms.internal.ads.zzeeo
 *  com.google.android.gms.internal.ads.zzeer
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbpu;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcus;
import com.google.android.gms.internal.ads.zzcut;
import com.google.android.gms.internal.ads.zzcuv;
import com.google.android.gms.internal.ads.zzcva;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdjm;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzdsw;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzeel;
import com.google.android.gms.internal.ads.zzeem;
import com.google.android.gms.internal.ads.zzeen;
import com.google.android.gms.internal.ads.zzeeo;
import com.google.android.gms.internal.ads.zzeer;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzeep
implements zzeec<zzcva> {
    private final zzcuv zza;
    private final Context zzb;
    private final zzdss zzc;
    private final zzfar zzd;
    private final Executor zze;
    private final zzcgz zzf;
    private final zzbpu zzg;
    private final boolean zzh;

    public zzeep(zzcuv zzcuv2, Context context, Executor executor, zzdss zzdss2, zzfar zzfar2, zzcgz zzcgz2, zzbpu zzbpu2) {
        this.zzb = context;
        this.zza = zzcuv2;
        this.zze = executor;
        this.zzc = zzdss2;
        this.zzd = zzfar2;
        this.zzf = zzcgz2;
        this.zzg = zzbpu2;
        zzcuv2 = zzbjl.zzgo;
        this.zzh = (Boolean)zzbet.zzc().zzc((zzbjd)zzcuv2);
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zza == null) return false;
        return true;
    }

    public final zzfsm<zzcva> zzb(zzfal zzfal2, zzezz zzezz2) {
        zzdsw zzdsw2 = new zzdsw();
        zzfal2 = zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzeel(this, zzezz2, zzfal2, zzdsw2), (Executor)this.zze);
        zzfal2.zze(zzeem.zza((zzdsw)zzdsw2), this.zze);
        return zzfal2;
    }

    final /* synthetic */ zzfsm zzc(zzezz zzezz2, zzfal object, zzdsw zzdsw2, Object object2) throws Exception {
        object2 = this.zzc.zzb(this.zzd.zze, zzezz2, object.zzb.zzb);
        object2.zzav(zzezz2.zzS);
        zzdsw2.zza(this.zzb, (View)object2);
        zzchl zzchl2 = new zzchl();
        zzdsw2 = this.zza.zzR(new zzcxv(object, zzezz2, null), new zzdjm((zzdkn)new zzeer(this.zzf, (zzfsm)zzchl2, zzezz2, (zzcml)object2, this.zzd, this.zzh, this.zzg), (zzcml)object2), new zzcut(zzezz2.zzW));
        zzdsr zzdsr2 = zzdsw2.zzi();
        object = this.zzh ? this.zzg : null;
        zzdsr2.zzi((zzcml)object2, false, (zzbpu)object);
        zzchl2.zzc((Object)zzdsw2);
        zzdsw2.zzd().zzi((Object)new zzeen((zzcml)object2), (Executor)zzchg.zzf);
        zzdsw2.zzi();
        object = zzezz2.zzs;
        return zzfsd.zzj((zzfsm)zzdsr.zzj((zzcml)object2, (String)object.zzb, (String)object.zza), (zzfln)new zzeeo(this, (zzcml)object2, zzezz2, (zzcus)zzdsw2), (Executor)this.zze);
    }
}
