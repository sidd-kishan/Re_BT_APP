/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzblc
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcve
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzcxa
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzddr
 *  com.google.android.gms.internal.ads.zzdds
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdgn
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdkw
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzejq
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzelm
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzely
 *  com.google.android.gms.internal.ads.zzewf
 *  com.google.android.gms.internal.ads.zzewi
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcve;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzcxa;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzdds;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdgn;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdkw;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzejq;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzelm;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzely;
import com.google.android.gms.internal.ads.zzewf;
import com.google.android.gms.internal.ads.zzewi;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzewj
implements zzely<zzcvh> {
    private final Context zza;
    private final Executor zzb;
    private final zzcoj zzc;
    private final zzeli zzd;
    private final zzelm zze;
    private final ViewGroup zzf;
    private zzbkg zzg;
    private final zzddr zzh;
    private final zzfap zzi;
    private zzfsm<zzcvh> zzj;

    public zzewj(Context context, Executor executor, zzbdl zzbdl2, zzcoj zzcoj2, zzeli zzeli2, zzelm zzelm2, zzfap zzfap2) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcoj2;
        this.zzd = zzeli2;
        this.zze = zzelm2;
        this.zzi = zzfap2;
        this.zzh = zzcoj2.zzh();
        this.zzf = new FrameLayout(context);
        zzfap2.zzt(zzbdl2);
    }

    static /* synthetic */ Executor zzc(zzewj zzewj2) {
        return zzewj2.zzb;
    }

    static /* synthetic */ zzeli zzd(zzewj zzewj2) {
        return zzewj2.zzd;
    }

    static /* synthetic */ zzelm zze(zzewj zzewj2) {
        return zzewj2.zze;
    }

    static /* synthetic */ ViewGroup zzf(zzewj zzewj2) {
        return zzewj2.zzf;
    }

    static /* synthetic */ zzddr zzg(zzewj zzewj2) {
        return zzewj2.zzh;
    }

    static /* synthetic */ zzfsm zzh(zzewj zzewj2, zzfsm zzfsm2) {
        zzewj2.zzj = null;
        return null;
    }

    public final boolean zza(zzbdg zzbdg2, String string, zzelw zzelw2, zzelx<? super zzcvh> zzelx2) throws RemoteException {
        if (string == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Ad unit ID should not be null for banner ad.");
            this.zzb.execute((Runnable)new zzewf(this));
            return false;
        }
        if (this.zzb()) {
            return false;
        }
        zzelw2 = zzbjl.zzgp;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)zzelw2)).booleanValue() && zzbdg2.zzf) {
            this.zzc.zzz().zzc(true);
        }
        zzelw2 = this.zzi;
        zzelw2.zzw(string);
        zzelw2.zzr(zzbdg2);
        zzbdg2 = zzelw2.zzL();
        if (((Boolean)zzblc.zzc.zze()).booleanValue() && this.zzi.zzv().zzk) {
            zzbdg2 = this.zzd;
            if (zzbdg2 == null) return false;
            zzbdg2.zzbD(zzfbm.zzd((int)7, null, null));
            return false;
        }
        string = zzbjl.zzfO;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
            string = this.zzc.zzk();
            zzelw2 = new zzdam();
            zzelw2.zze(this.zza);
            zzelw2.zzf((zzfar)zzbdg2);
            string.zzi(zzelw2.zzh());
            zzbdg2 = new zzdgn();
            zzbdg2.zzB((zzddx)this.zzd, this.zzb);
            zzbdg2.zzt((zzamv)this.zzd, this.zzb);
            string.zzj(zzbdg2.zzC());
            string.zze(new zzejq(this.zzg));
            string.zzb(new zzdkw(zzdmx.zza, null));
            string.zzd(new zzcxa(this.zzh));
            string.zzc(new zzcve(this.zzf));
            zzbdg2 = string.zza();
        } else {
            string = this.zzc.zzk();
            zzelw2 = new zzdam();
            zzelw2.zze(this.zza);
            zzelw2.zzf((zzfar)zzbdg2);
            string.zzi(zzelw2.zzh());
            zzbdg2 = new zzdgn();
            zzbdg2.zzB((zzddx)this.zzd, this.zzb);
            zzbdg2.zzu((zzbcv)this.zzd, this.zzb);
            zzbdg2.zzu((zzbcv)this.zze, this.zzb);
            zzbdg2.zzv((zzdio)this.zzd, this.zzb);
            zzbdg2.zzw((zzdbw)this.zzd, this.zzb);
            zzbdg2.zzp((zzdbc)this.zzd, this.zzb);
            zzbdg2.zzq((zzdcq)this.zzd, this.zzb);
            zzbdg2.zzr((zzdbf)this.zzd, this.zzb);
            zzbdg2.zzt((zzamv)this.zzd, this.zzb);
            zzbdg2.zzz((zzddn)this.zzd, this.zzb);
            string.zzj(zzbdg2.zzC());
            string.zze(new zzejq(this.zzg));
            string.zzb(new zzdkw(zzdmx.zza, null));
            string.zzd(new zzcxa(this.zzh));
            string.zzc(new zzcve(this.zzf));
            zzbdg2 = string.zza();
        }
        string = zzbdg2.zzY();
        string = string.zzd(string.zzc());
        this.zzj = string;
        zzfsd.zzp((zzfsm)string, (zzfrz)new zzewi(this, zzelx2, (zzcwe)zzbdg2), (Executor)this.zzb);
        return true;
    }

    public final boolean zzb() {
        zzfsm<zzcvh> zzfsm2 = this.zzj;
        if (zzfsm2 == null) return false;
        if (zzfsm2.isDone()) return false;
        return true;
    }

    public final ViewGroup zzi() {
        return this.zzf;
    }

    public final void zzj(zzbkg zzbkg2) {
        this.zzg = zzbkg2;
    }

    public final void zzk(zzbex zzbex2) {
        this.zze.zza(zzbex2);
    }

    public final zzfap zzl() {
        return this.zzi;
    }

    public final boolean zzm() {
        ViewParent viewParent = this.zzf.getParent();
        if (!(viewParent instanceof View)) {
            return false;
        }
        viewParent = (View)viewParent;
        zzt.zzc();
        return zzs.zzZ((View)viewParent, (Context)viewParent.getContext());
    }

    public final void zzn(zzdds zzdds2) {
        this.zzh.zzi((Object)zzdds2, this.zzb);
    }

    public final void zzo() {
        this.zzh.zzd(60);
    }

    final /* synthetic */ void zzp() {
        this.zzd.zzbD(zzfbm.zzd((int)6, null, null));
    }
}
