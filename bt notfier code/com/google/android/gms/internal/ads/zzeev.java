/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcud
 *  com.google.android.gms.internal.ads.zzcue
 *  com.google.android.gms.internal.ads.zzcuk
 *  com.google.android.gms.internal.ads.zzcuq
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdsr
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzees
 *  com.google.android.gms.internal.ads.zzeet
 *  com.google.android.gms.internal.ads.zzeeu
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfav
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcud;
import com.google.android.gms.internal.ads.zzcue;
import com.google.android.gms.internal.ads.zzcuk;
import com.google.android.gms.internal.ads.zzcuq;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzees;
import com.google.android.gms.internal.ads.zzeet;
import com.google.android.gms.internal.ads.zzeeu;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfav;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzeev
implements zzeec<zzcuq> {
    private final zzcuk zza;
    private final Context zzb;
    private final zzdss zzc;
    private final Executor zzd;

    public zzeev(zzcuk zzcuk2, Context context, Executor executor, zzdss zzdss2) {
        this.zzb = context;
        this.zza = zzcuk2;
        this.zzd = executor;
        this.zzc = zzdss2;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zza == null) return false;
        return true;
    }

    public final zzfsm<zzcuq> zzb(zzfal zzfal2, zzezz zzezz2) {
        return zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzees(this, zzfal2, zzezz2), (Executor)this.zzd);
    }

    final /* synthetic */ zzfsm zzc(zzfal zzfal2, zzezz zzezz2, Object object) throws Exception {
        zzbdl zzbdl2 = zzfav.zzb((Context)this.zzb, (List)zzezz2.zzu);
        object = this.zzc.zzb(zzbdl2, zzezz2, zzfal2.zzb.zzb);
        zzcuk zzcuk2 = this.zza;
        zzfal2 = new zzcxv(zzfal2, zzezz2, null);
        zzbdl2 = zzfav.zzc((zzbdl)zzbdl2);
        int n = zzezz2.zzW;
        boolean bl = zzezz2.zzaa;
        boolean bl2 = zzezz2.zzK;
        zzfal2 = zzcuk2.zzR((zzcxv)zzfal2, new zzcue((View)object, (zzcml)object, (zzfaa)zzbdl2, n, bl, bl2));
        zzfal2.zzi().zzi((zzcml)object, false, null);
        zzfal2.zzd().zzi((Object)new zzeet((zzcml)object), (Executor)zzchg.zzf);
        zzfal2.zzi();
        zzezz2 = zzezz2.zzs;
        return zzfsd.zzj((zzfsm)zzdsr.zzj((zzcml)object, (String)zzezz2.zzb, (String)zzezz2.zza), (zzfln)new zzeeu((zzcud)zzfal2), (Executor)zzchg.zzf);
    }
}
