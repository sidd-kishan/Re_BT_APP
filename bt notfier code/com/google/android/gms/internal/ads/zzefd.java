/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zzav
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnh
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcvi
 *  com.google.android.gms.internal.ads.zzcvo
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzcwv
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdsr
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzdsv
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzeex
 *  com.google.android.gms.internal.ads.zzeey
 *  com.google.android.gms.internal.ads.zzeez
 *  com.google.android.gms.internal.ads.zzefa
 *  com.google.android.gms.internal.ads.zzefb
 *  com.google.android.gms.internal.ads.zzefc
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfae
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfav
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnh;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcvi;
import com.google.android.gms.internal.ads.zzcvo;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzcwv;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzdsv;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzeex;
import com.google.android.gms.internal.ads.zzeey;
import com.google.android.gms.internal.ads.zzeez;
import com.google.android.gms.internal.ads.zzefa;
import com.google.android.gms.internal.ads.zzefb;
import com.google.android.gms.internal.ads.zzefc;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfae;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfav;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzefd
implements zzeec<zzcvh> {
    private final zzcwe zza;
    private final Context zzb;
    private final zzdss zzc;
    private final zzfar zzd;
    private final Executor zze;
    private final zzfln<zzezz, zzav> zzf;

    public zzefd(zzcwe zzcwe2, Context context, Executor executor, zzdss zzdss2, zzfar zzfar2, zzfln<zzezz, zzav> zzfln2) {
        this.zzb = context;
        this.zza = zzcwe2;
        this.zze = executor;
        this.zzc = zzdss2;
        this.zzd = zzfar2;
        this.zzf = zzfln2;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        zzfal2 = zzezz2.zzs;
        if (zzfal2 == null) return false;
        if (zzfal2.zza == null) return false;
        return true;
    }

    public final zzfsm<zzcvh> zzb(zzfal zzfal2, zzezz zzezz2) {
        return zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzeex(this, zzfal2, zzezz2), (Executor)this.zze);
    }

    final /* synthetic */ void zzc(zzcml zzcml2) {
        zzcml2.zzL();
        zzcnh zzcnh2 = zzcml2.zzh();
        zzcml2 = this.zzd.zza;
        if (zzcml2 == null) return;
        if (zzcnh2 == null) return;
        zzcnh2.zzc((zzbis)zzcml2);
    }

    final /* synthetic */ zzfsm zzd(zzfal zzfal2, zzezz zzezz2, Object object) throws Exception {
        zzbdl zzbdl2 = zzfav.zzb((Context)this.zzb, (List)zzezz2.zzu);
        zzcml zzcml2 = this.zzc.zzb(zzbdl2, zzezz2, zzfal2.zzb.zzb);
        zzcml2.zzav(zzezz2.zzS);
        object = zzbjl.zzfB;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue() && zzezz2.zzad) {
            object = zzcwv.zza((Context)this.zzb, (View)((View)zzcml2), (zzezz)zzezz2);
        } else {
            Context context = this.zzb;
            object = (zzav)this.zzf.apply((Object)zzezz2);
            object = new zzdsv(context, (View)zzcml2, (zzav)object);
        }
        zzfal2 = this.zza.zzaa(new zzcxv(zzfal2, zzezz2, null), new zzcvo((View)object, zzcml2, zzeey.zzb((zzcml)zzcml2), zzfav.zzc((zzbdl)zzbdl2)));
        zzfal2.zzi().zzi(zzcml2, false, null);
        zzfal2.zzd().zzi((Object)new zzeez(zzcml2), (Executor)zzchg.zzf);
        zzfal2.zzi();
        object = zzezz2.zzs;
        object = zzdsr.zzj((zzcml)zzcml2, (String)((zzfae)object).zzb, (String)((zzfae)object).zza);
        if (zzezz2.zzI) {
            object.zze(zzefa.zza((zzcml)zzcml2), this.zze);
        }
        object.zze((Runnable)new zzefb(this, zzcml2), this.zze);
        return zzfsd.zzj((zzfsm)object, (zzfln)new zzefc((zzcvi)zzfal2), (Executor)zzchg.zzf);
    }
}
