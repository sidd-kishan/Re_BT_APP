/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbqf
 *  com.google.android.gms.internal.ads.zzbsw
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcnz
 *  com.google.android.gms.internal.ads.zzdqu
 *  com.google.android.gms.internal.ads.zzdqv
 *  com.google.android.gms.internal.ads.zzdqw
 *  com.google.android.gms.internal.ads.zzdqx
 *  com.google.android.gms.internal.ads.zzdqy
 *  com.google.android.gms.internal.ads.zzdqz
 *  com.google.android.gms.internal.ads.zzdra
 *  com.google.android.gms.internal.ads.zzdrb
 *  com.google.android.gms.internal.ads.zzdrf
 *  com.google.android.gms.internal.ads.zzdrg
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbqf;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcnz;
import com.google.android.gms.internal.ads.zzdqu;
import com.google.android.gms.internal.ads.zzdqv;
import com.google.android.gms.internal.ads.zzdqw;
import com.google.android.gms.internal.ads.zzdqx;
import com.google.android.gms.internal.ads.zzdqy;
import com.google.android.gms.internal.ads.zzdqz;
import com.google.android.gms.internal.ads.zzdra;
import com.google.android.gms.internal.ads.zzdrb;
import com.google.android.gms.internal.ads.zzdrf;
import com.google.android.gms.internal.ads.zzdrg;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdrh {
    private final zzdrb zza;
    private final zza zzb;
    private final zzcmx zzc;
    private final Context zzd;
    private final zzdvi zze;
    private final zzffc zzf;
    private final Executor zzg;
    private final zzaas zzh;
    private final zzcgz zzi;
    private final zzbqf zzj;
    private final zzedq zzk;
    private final zzffu zzl;
    private zzfsm<zzcml> zzm;

    zzdrh(zzdrf zzdrf2) {
        this.zzd = zzdrf.zzc((zzdrf)zzdrf2);
        this.zzg = zzdrf.zzg((zzdrf)zzdrf2);
        this.zzh = zzdrf.zzh((zzdrf)zzdrf2);
        this.zzi = zzdrf.zzi((zzdrf)zzdrf2);
        this.zzb = zzdrf.zza((zzdrf)zzdrf2);
        this.zza = new zzdrb(null);
        this.zzc = zzdrf.zzb((zzdrf)zzdrf2);
        this.zzj = new zzbqf();
        this.zzk = zzdrf.zzf((zzdrf)zzdrf2);
        this.zzl = zzdrf.zzj((zzdrf)zzdrf2);
        this.zze = zzdrf.zzd((zzdrf)zzdrf2);
        this.zzf = zzdrf.zze((zzdrf)zzdrf2);
    }

    static /* synthetic */ zzdrb zza(zzdrh zzdrh2) {
        return zzdrh2.zza;
    }

    public final void zzb() {
        synchronized (this) {
            Context context = this.zzd;
            zzcgz zzcgz2 = this.zzi;
            zzbjd zzbjd2 = zzbjl.zzci;
            context = zzcmx.zzb((Context)context, (zzcgz)zzcgz2, (String)((String)zzbet.zzc().zzc(zzbjd2)), (zzaas)this.zzh, (zza)this.zzb);
            zzcgz2 = new zzdqu(this);
            this.zzm = zzcgz2 = zzfsd.zzj((zzfsm)context, (zzfln)zzcgz2, (Executor)this.zzg);
            zzchj.zza((zzfsm)zzcgz2, (String)"NativeJavascriptExecutor.initializeEngine");
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc() {
        synchronized (this) {
            zzfsm<zzcml> zzfsm2 = this.zzm;
            if (zzfsm2 == null) {
                return;
            }
            zzdqw zzdqw2 = new zzdqw(this);
            zzfsd.zzp(zzfsm2, (zzfrz)zzdqw2, (Executor)this.zzg);
            this.zzm = null;
            return;
        }
    }

    public final zzfsm<JSONObject> zzd(String string, JSONObject jSONObject) {
        synchronized (this) {
            zzfsm<zzcml> zzfsm2 = this.zzm;
            if (zzfsm2 == null) {
                string = zzfsd.zza(null);
                return string;
            }
            zzdqv zzdqv2 = new zzdqv(this, string, jSONObject);
            string = zzfsd.zzi(zzfsm2, (zzfrk)zzdqv2, (Executor)this.zzg);
            return string;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zze(String string, zzbpr<Object> zzbpr2) {
        synchronized (this) {
            void var2_2;
            zzfsm<zzcml> zzfsm2 = this.zzm;
            if (zzfsm2 == null) {
                return;
            }
            zzdqx zzdqx2 = new zzdqx(this, string, (zzbpr)var2_2);
            zzfsd.zzp(zzfsm2, (zzfrz)zzdqx2, (Executor)this.zzg);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzf(String string, zzbpr<Object> zzbpr2) {
        synchronized (this) {
            void var2_2;
            zzfsm<zzcml> zzfsm2 = this.zzm;
            if (zzfsm2 == null) {
                return;
            }
            zzdqy zzdqy2 = new zzdqy(this, string, (zzbpr)var2_2);
            zzfsd.zzp(zzfsm2, (zzfrz)zzdqy2, (Executor)this.zzg);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzg(String zzfsm2, Map<String, ?> map) {
        synchronized (this) {
            void var2_2;
            zzfsm2 = this.zzm;
            if (zzfsm2 == null) {
                return;
            }
            zzdqz zzdqz2 = new zzdqz(this, "sendMessageToNativeJs", (Map)var2_2);
            zzfsd.zzp(zzfsm2, (zzfrz)zzdqz2, (Executor)this.zzg);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzh(zzezz zzezz2, zzfac zzfac2) {
        synchronized (this) {
            void var2_2;
            zzfsm<zzcml> zzfsm2 = this.zzm;
            if (zzfsm2 == null) {
                return;
            }
            zzdra zzdra2 = new zzdra(this, zzezz2, (zzfac)var2_2);
            zzfsd.zzp(zzfsm2, (zzfrz)zzdra2, (Executor)this.zzg);
            return;
        }
    }

    public final <T> void zzi(WeakReference<T> weakReference, String string, zzbpr<T> zzbpr2) {
        this.zze(string, (zzbpr<Object>)new zzdrg(this, weakReference, string, zzbpr2, null));
    }

    final /* synthetic */ zzfsm zzj(String string, JSONObject jSONObject, zzcml zzcml2) throws Exception {
        return this.zzj.zzc((zzbsw)zzcml2, string, jSONObject);
    }

    final /* synthetic */ zzcml zzk(zzcml zzcml2) {
        zzcml2.zzab("/result", (zzbpr)this.zzj);
        zzcnz zzcnz2 = zzcml2.zzR();
        zzdrb zzdrb2 = this.zza;
        zzcnz2.zzL(null, (zzbor)zzdrb2, (zzo)zzdrb2, (zzbot)zzdrb2, (zzv)zzdrb2, false, null, new zzb(this.zzd, null, null), null, null, this.zzk, this.zzl, this.zze, this.zzf, null, null);
        return zzcml2;
    }
}
