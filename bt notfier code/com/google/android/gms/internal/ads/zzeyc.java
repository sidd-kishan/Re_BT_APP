/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdgn
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzdkf
 *  com.google.android.gms.internal.ads.zzejq
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzely
 *  com.google.android.gms.internal.ads.zzexv
 *  com.google.android.gms.internal.ads.zzexw
 *  com.google.android.gms.internal.ads.zzeyb
 *  com.google.android.gms.internal.ads.zzezc
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdgn;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzejq;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzely;
import com.google.android.gms.internal.ads.zzexv;
import com.google.android.gms.internal.ads.zzexw;
import com.google.android.gms.internal.ads.zzeyb;
import com.google.android.gms.internal.ads.zzezc;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzeyc
implements zzely<zzdji> {
    private final Context zza;
    private final Executor zzb;
    private final zzcoj zzc;
    private final zzeli zzd;
    private final zzezc zze;
    private zzbkg zzf;
    private final zzfap zzg;
    private zzfsm<zzdji> zzh;

    public zzeyc(Context context, Executor executor, zzcoj zzcoj2, zzeli zzeli2, zzezc zzezc2, zzfap zzfap2) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcoj2;
        this.zzd = zzeli2;
        this.zzg = zzfap2;
        this.zze = zzezc2;
    }

    static /* synthetic */ Executor zzc(zzeyc zzeyc2) {
        return zzeyc2.zzb;
    }

    static /* synthetic */ zzeli zzd(zzeyc zzeyc2) {
        return zzeyc2.zzd;
    }

    static /* synthetic */ zzezc zze(zzeyc zzeyc2) {
        return zzeyc2.zze;
    }

    static /* synthetic */ zzfsm zzf(zzeyc zzeyc2, zzfsm zzfsm2) {
        zzeyc2.zzh = null;
        return null;
    }

    public final boolean zza(zzbdg zzbdg2, String string, zzelw zzelw2, zzelx<? super zzdji> zzelx2) {
        if (string == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute((Runnable)new zzexw(this));
            return false;
        }
        if (this.zzb()) {
            return false;
        }
        zzbjd zzbjd2 = zzbjl.zzgp;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && zzbdg2.zzf) {
            this.zzc.zzz().zzc(true);
        }
        zzbjd2 = ((zzexv)zzelw2).zza;
        zzelw2 = this.zzg;
        zzelw2.zzw(string);
        zzelw2.zzt((zzbdl)zzbjd2);
        zzelw2.zzr(zzbdg2);
        zzbdg2 = zzelw2.zzL();
        string = zzbjl.zzfQ;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
            string = this.zzc.zzp();
            zzelw2 = new zzdam();
            zzelw2.zze(this.zza);
            zzelw2.zzf((zzfar)zzbdg2);
            string.zzc(zzelw2.zzh());
            zzbdg2 = new zzdgn();
            zzbdg2.zzB((zzddx)this.zzd, this.zzb);
            zzbdg2.zzt((zzamv)this.zzd, this.zzb);
            string.zzd(zzbdg2.zzC());
            string.zzb(new zzejq(this.zzf));
            zzbdg2 = string.zza();
        } else {
            string = new zzdgn();
            zzelw2 = this.zze;
            if (zzelw2 != null) {
                string.zzp((zzdbc)zzelw2, this.zzb);
                string.zzq((zzdcq)this.zze, this.zzb);
                string.zzr((zzdbf)this.zze, this.zzb);
            }
            zzbjd2 = this.zzc.zzp();
            zzelw2 = new zzdam();
            zzelw2.zze(this.zza);
            zzelw2.zzf((zzfar)zzbdg2);
            zzbjd2.zzc(zzelw2.zzh());
            string.zzB((zzddx)this.zzd, this.zzb);
            string.zzp((zzdbc)this.zzd, this.zzb);
            string.zzq((zzdcq)this.zzd, this.zzb);
            string.zzr((zzdbf)this.zzd, this.zzb);
            string.zzu((zzbcv)this.zzd, this.zzb);
            string.zzv((zzdio)this.zzd, this.zzb);
            string.zzt((zzamv)this.zzd, this.zzb);
            string.zzz((zzddn)this.zzd, this.zzb);
            string.zzs((zzdbs)this.zzd, this.zzb);
            zzbjd2.zzd(string.zzC());
            zzbjd2.zzb(new zzejq(this.zzf));
            zzbdg2 = zzbjd2.zza();
        }
        string = zzbdg2.zzP();
        string = string.zzd(string.zzc());
        this.zzh = string;
        zzfsd.zzp((zzfsm)string, (zzfrz)new zzeyb(this, zzelx2, (zzdkf)zzbdg2), (Executor)this.zzb);
        return true;
    }

    public final boolean zzb() {
        zzfsm<zzdji> zzfsm2 = this.zzh;
        if (zzfsm2 == null) return false;
        if (zzfsm2.isDone()) return false;
        return true;
    }

    public final void zzg(zzbkg zzbkg2) {
        this.zzf = zzbkg2;
    }

    final /* synthetic */ void zzh() {
        this.zzd.zzbD(zzfbm.zzd((int)6, null, null));
    }
}
