/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbpx
 *  com.google.android.gms.internal.ads.zzbqc
 *  com.google.android.gms.internal.ads.zzchk
 *  com.google.android.gms.internal.ads.zzclb
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcny
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdps
 *  com.google.android.gms.internal.ads.zzdpt
 *  com.google.android.gms.internal.ads.zzdpu
 *  com.google.android.gms.internal.ads.zzdpv
 *  com.google.android.gms.internal.ads.zzdpw
 *  com.google.android.gms.internal.ads.zzdpx
 *  com.google.android.gms.internal.ads.zzdrn
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzehs
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbpx;
import com.google.android.gms.internal.ads.zzbqc;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzclb;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcny;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdps;
import com.google.android.gms.internal.ads.zzdpt;
import com.google.android.gms.internal.ads.zzdpu;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdpw;
import com.google.android.gms.internal.ads.zzdpx;
import com.google.android.gms.internal.ads.zzdrn;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzehs;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdqd {
    private final zzfar zza;
    private final Executor zzb;
    private final zzdss zzc;
    private final zzdrn zzd;
    private final Context zze;
    private final zzdvi zzf;
    private final zzffc zzg;
    private final zzffu zzh;
    private final zzedq zzi;

    public zzdqd(zzfar zzfar2, Executor executor, zzdss zzdss2, Context context, zzdvi zzdvi2, zzffc zzffc2, zzffu zzffu2, zzedq zzedq2, zzdrn zzdrn2) {
        this.zza = zzfar2;
        this.zzb = executor;
        this.zzc = zzdss2;
        this.zze = context;
        this.zzf = zzdvi2;
        this.zzg = zzffc2;
        this.zzh = zzffu2;
        this.zzi = zzedq2;
        this.zzd = zzdrn2;
    }

    private final void zzh(zzcml zzcml2) {
        zzdqd.zzi(zzcml2);
        zzcml2.zzab("/video", zzbpq.zzl);
        zzcml2.zzab("/videoMeta", zzbpq.zzm);
        zzcml2.zzab("/precache", (zzbpr)new zzclb());
        zzcml2.zzab("/delayPageLoaded", zzbpq.zzp);
        zzcml2.zzab("/instrument", zzbpq.zzn);
        zzcml2.zzab("/log", zzbpq.zzg);
        zzcml2.zzab("/click", zzbpq.zzb(null));
        if (this.zza.zzb != null) {
            zzcml2.zzR().zzI(true);
            zzcml2.zzab("/open", (zzbpr)new zzbqc(null, null, null, null, null));
        } else {
            zzcml2.zzR().zzI(false);
        }
        if (!zzt.zzA().zzb(zzcml2.getContext())) return;
        zzcml2.zzab("/logScionEvent", (zzbpr)new zzbpx(zzcml2.getContext()));
    }

    private static final void zzi(zzcml zzcml2) {
        zzcml2.zzab("/videoClicked", zzbpq.zzh);
        zzcml2.zzR().zzH(true);
        zzbjd zzbjd2 = zzbjl.zzck;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzcml2.zzab("/getNativeAdViewSignals", zzbpq.zzs);
        }
        zzcml2.zzab("/getNativeClickMeta", zzbpq.zzt);
    }

    public final zzfsm<zzcml> zza(JSONObject jSONObject) {
        return zzfsd.zzi((zzfsm)zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzdpu(this), (Executor)this.zzb), (zzfrk)new zzdps(this, jSONObject), (Executor)this.zzb);
    }

    public final zzfsm<zzcml> zzb(String string, String string2, zzezz zzezz2, zzfac zzfac2, zzbdl zzbdl2) {
        return zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzdpt(this, zzbdl2, zzezz2, zzfac2, string, string2), (Executor)this.zzb);
    }

    final /* synthetic */ zzfsm zzc(Object object) throws Exception {
        zzcml zzcml2 = this.zzc.zzb(zzbdl.zzb(), null, null);
        zzchk zzchk2 = zzchk.zza((Object)zzcml2);
        this.zzh(zzcml2);
        zzcml2.zzR().zzz((zzcny)new zzdpv(zzchk2));
        object = zzbjl.zzcj;
        zzcml2.loadUrl((String)zzbet.zzc().zzc((zzbjd)object));
        return zzchk2;
    }

    final /* synthetic */ zzfsm zzd(zzbdl zzbdl2, zzezz zzezz2, zzfac zzfac2, String string, String string2, Object object) throws Exception {
        zzezz2 = this.zzc.zzb(zzbdl2, zzezz2, zzfac2);
        zzfac2 = zzchk.zza((Object)zzezz2);
        if (this.zza.zzb != null) {
            this.zzh((zzcml)zzezz2);
            zzezz2.zzaf(zzcob.zze());
        } else {
            zzbdl2 = this.zzd.zzb();
            zzezz2.zzR().zzL((zzbcv)zzbdl2, (zzbor)zzbdl2, (zzo)zzbdl2, (zzbot)zzbdl2, (zzv)zzbdl2, false, null, new zzb(this.zze, null, null), null, null, this.zzi, this.zzh, this.zzf, this.zzg, null, (zzdio)zzbdl2);
            zzdqd.zzi((zzcml)zzezz2);
        }
        zzezz2.zzR().zzy((zzcnx)new zzdpw(this, (zzcml)zzezz2, (zzchk)zzfac2));
        zzezz2.zzat(string, string2, null);
        return zzfac2;
    }

    final /* synthetic */ void zze(zzcml zzcml2, zzchk zzchk2, boolean bl) {
        if (!bl) {
            zzchk2.zzd((Throwable)new zzehs(1, "Html video Web View failed to load."));
            return;
        }
        if (this.zza.zza != null && zzcml2.zzh() != null) {
            zzcml2.zzh().zzc(this.zza.zza);
        }
        zzchk2.zzb();
    }

    final /* synthetic */ zzfsm zzf(JSONObject jSONObject, zzcml zzcml2) throws Exception {
        zzchk zzchk2 = zzchk.zza((Object)zzcml2);
        if (this.zza.zzb != null) {
            zzcml2.zzaf(zzcob.zze());
        } else {
            zzcml2.zzaf(zzcob.zzd());
        }
        zzcml2.zzR().zzy((zzcnx)new zzdpx(this, zzcml2, zzchk2));
        zzcml2.zzr("google.afma.nativeAds.renderVideo", jSONObject);
        return zzchk2;
    }

    final /* synthetic */ void zzg(zzcml zzcml2, zzchk zzchk2, boolean bl) {
        if (this.zza.zza != null && zzcml2.zzh() != null) {
            zzcml2.zzh().zzc(this.zza.zza);
        }
        zzchk2.zzb();
    }
}
