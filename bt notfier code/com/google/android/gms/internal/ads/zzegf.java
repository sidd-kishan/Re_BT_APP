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
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzdjj
 *  com.google.android.gms.internal.ads.zzdjm
 *  com.google.android.gms.internal.ads.zzdkf
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzdsr
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzdsw
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzega
 *  com.google.android.gms.internal.ads.zzegb
 *  com.google.android.gms.internal.ads.zzegc
 *  com.google.android.gms.internal.ads.zzegd
 *  com.google.android.gms.internal.ads.zzege
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
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzdjj;
import com.google.android.gms.internal.ads.zzdjm;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzdsw;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzega;
import com.google.android.gms.internal.ads.zzegb;
import com.google.android.gms.internal.ads.zzegc;
import com.google.android.gms.internal.ads.zzegd;
import com.google.android.gms.internal.ads.zzege;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzegf
implements zzeec<zzdji> {
    private final Context zza;
    private final zzdss zzb;
    private final zzdkf zzc;
    private final zzfar zzd;
    private final Executor zze;
    private final zzcgz zzf;
    private final zzbpu zzg;
    private final boolean zzh;

    public zzegf(Context context, zzcgz zzcgz2, zzfar zzfar2, Executor executor, zzdkf zzdkf2, zzdss zzdss2, zzbpu zzbpu2) {
        this.zza = context;
        this.zzd = zzfar2;
        this.zzc = zzdkf2;
        this.zze = executor;
        this.zzf = zzcgz2;
        this.zzb = zzdss2;
        this.zzg = zzbpu2;
        context = zzbjl.zzgo;
        this.zzh = (Boolean)zzbet.zzc().zzc((zzbjd)context);
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zza == null) return false;
        return true;
    }

    public final zzfsm<zzdji> zzb(zzfal zzfal2, zzezz zzezz2) {
        zzdsw zzdsw2 = new zzdsw();
        zzfal2 = zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzega(this, zzezz2, zzfal2, zzdsw2), (Executor)this.zze);
        zzfal2.zze(zzegb.zza((zzdsw)zzdsw2), this.zze);
        return zzfal2;
    }

    final /* synthetic */ zzfsm zzc(zzezz zzezz2, zzfal object, zzdsw zzdsw2, Object object2) throws Exception {
        object2 = this.zzb.zzb(this.zzd.zze, zzezz2, object.zzb.zzb);
        object2.zzav(zzezz2.zzS);
        zzdsw2.zza(this.zza, (View)object2);
        zzchl zzchl2 = new zzchl();
        zzdsw2 = this.zzc.zzQ(new zzcxv(object, zzezz2, null), new zzdjm((zzdkn)new zzege(this.zza, this.zzf, (zzfsm)zzchl2, zzezz2, (zzcml)object2, this.zzd, this.zzh, this.zzg), (zzcml)object2));
        zzchl2.zzc((Object)zzdsw2);
        zzdsw2.zzd().zzi((Object)new zzegc((zzcml)object2), (Executor)zzchg.zzf);
        zzchl2 = zzdsw2.zzk();
        object = this.zzh ? this.zzg : null;
        zzchl2.zzi((zzcml)object2, true, (zzbpu)object);
        zzdsw2.zzk();
        object = zzezz2.zzs;
        return zzfsd.zzj((zzfsm)zzdsr.zzj((zzcml)object2, (String)object.zzb, (String)object.zza), (zzfln)new zzegd(this, (zzcml)object2, zzezz2, (zzdjj)zzdsw2), (Executor)this.zze);
    }
}
