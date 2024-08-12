/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.google.android.gms.ads.internal.overlay.zzp
 *  com.google.android.gms.ads.internal.overlay.zzq
 *  com.google.android.gms.ads.internal.overlay.zzz
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfm
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzbzz
 *  com.google.android.gms.internal.ads.zzcac
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcuc
 *  com.google.android.gms.internal.ads.zzcuq
 *  com.google.android.gms.internal.ads.zzddb
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzeup
 *  com.google.android.gms.internal.ads.zzeur
 *  com.google.android.gms.internal.ads.zzeus
 *  com.google.android.gms.internal.ads.zzeut
 *  com.google.android.gms.internal.ads.zzeuu
 *  com.google.android.gms.internal.ads.zzevv
 *  com.google.android.gms.internal.ads.zzfav
 *  com.google.android.gms.internal.ads.zzfbm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbzz;
import com.google.android.gms.internal.ads.zzcac;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcuc;
import com.google.android.gms.internal.ads.zzcuq;
import com.google.android.gms.internal.ads.zzddb;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzeup;
import com.google.android.gms.internal.ads.zzeur;
import com.google.android.gms.internal.ads.zzeus;
import com.google.android.gms.internal.ads.zzeut;
import com.google.android.gms.internal.ads.zzeuu;
import com.google.android.gms.internal.ads.zzevv;
import com.google.android.gms.internal.ads.zzfav;
import com.google.android.gms.internal.ads.zzfbm;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzeuv
extends zzbfm
implements zzz,
zzaxq,
zzddb {
    protected zzcuq zza;
    private final zzcoj zzb;
    private final Context zzc;
    private final ViewGroup zzd;
    private AtomicBoolean zze = new AtomicBoolean();
    private final String zzf;
    private final zzeup zzg;
    private final zzevv zzh;
    private final zzcgz zzi;
    private long zzj = -1L;
    private zzcuc zzk;

    public zzeuv(zzcoj zzcoj2, Context context, String string, zzeup zzeup2, zzevv zzevv2, zzcgz zzcgz2) {
        this.zzd = new FrameLayout(context);
        this.zzb = zzcoj2;
        this.zzc = context;
        this.zzf = string;
        this.zzg = zzeup2;
        this.zzh = zzevv2;
        zzevv2.zzj((zzddb)this);
        this.zzi = zzcgz2;
    }

    private final void zzT(int n) {
        synchronized (this) {
            if (!this.zze.compareAndSet(false, true)) return;
            zzcuq zzcuq2 = this.zza;
            if (zzcuq2 != null && zzcuq2.zzk() != null) {
                this.zzh.zzr(this.zza.zzk());
            }
            this.zzh.zzp();
            this.zzd.removeAllViews();
            zzcuq2 = this.zzk;
            if (zzcuq2 != null) {
                zzt.zzf().zzc((zzaww)zzcuq2);
            }
            if (this.zza != null) {
                long l = this.zzj;
                long l2 = -1L;
                if (l != -1L) {
                    l2 = zzt.zzj().elapsedRealtime() - this.zzj;
                }
                this.zza.zzi(l2, n);
            }
            this.zzj();
            return;
        }
    }

    static /* synthetic */ ViewGroup zzb(zzeuv zzeuv2) {
        return zzeuv2.zzd;
    }

    static /* synthetic */ zzevv zzc(zzeuv zzeuv2) {
        return zzeuv2.zzh;
    }

    static /* synthetic */ zzcgz zze(zzeuv zzeuv2) {
        return zzeuv2.zzi;
    }

    static /* synthetic */ zzq zzf(zzeuv zzeuv2, zzcuq zzcuq2) {
        boolean bl = zzcuq2.zzf();
        zzcuq2 = zzbjl.zzdn;
        int n = (Integer)zzbet.zzc().zzc((zzbjd)zzcuq2);
        zzcuq2 = new zzp();
        zzcuq2.zzd = 50;
        int n2 = 0;
        int n3 = true != bl ? 0 : n;
        zzcuq2.zza = n3;
        n3 = n2;
        if (!bl) {
            n3 = n;
        }
        zzcuq2.zzb = n3;
        zzcuq2.zzc = n;
        return new zzq(zzeuv2.zzc, (zzp)zzcuq2, (zzz)zzeuv2);
    }

    static /* synthetic */ zzbdl zzh(zzeuv zzeuv2) {
        return zzfav.zzb((Context)zzeuv2.zzc, Collections.singletonList(zzeuv2.zza.zza()));
    }

    /*
     * Converted monitor instructions to comments
     */
    public final zzbgz zzA() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    public final String zzB() {
        synchronized (this) {
            String string = this.zzf;
            return string;
        }
    }

    public final zzbfu zzC() {
        return null;
    }

    public final zzbfa zzD() {
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzE(zzbkg zzbkg2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzF(zzbex zzbex2) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzG(boolean bl) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final boolean zzH() {
        synchronized (this) {
            boolean bl = this.zzg.zzb();
            return bl;
        }
    }

    public final void zzI(zzccf zzccf2) {
    }

    public final void zzJ(String string) {
    }

    public final void zzK(String string) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final zzbhc zzL() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzM(zzbis zzbis2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzN(zzbhg zzbhg2) {
    }

    public final void zzO(zzbdr zzbdr2) {
        this.zzg.zzi(zzbdr2);
    }

    public final void zzP(zzaxz zzaxz2) {
        this.zzh.zzh(zzaxz2);
    }

    public final void zzQ(boolean bl) {
    }

    public final void zzR() {
        zzcuc zzcuc2;
        if (this.zza == null) {
            return;
        }
        this.zzj = zzt.zzj().elapsedRealtime();
        int n = this.zza.zzc();
        if (n <= 0) {
            return;
        }
        this.zzk = zzcuc2 = new zzcuc(this.zzb.zzf(), zzt.zzj());
        zzcuc2.zzb(n, (Runnable)new zzeus(this));
    }

    final /* synthetic */ void zzS() {
        this.zzT(5);
    }

    public final void zzX(zzbgw zzbgw2) {
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) {
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) {
    }

    public final void zza() {
        this.zzT(3);
    }

    public final void zzaa(zzbgb zzbgb2) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzab(zzbfy zzbfy2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzd() {
        this.zzT(4);
    }

    public final void zzg() {
        zzber.zza();
        if (zzcgm.zzp()) {
            this.zzT(5);
            return;
        }
        this.zzb.zze().execute((Runnable)new zzeur(this));
    }

    public final IObjectWrapper zzi() {
        Preconditions.checkMainThread((String)"getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap((Object)this.zzd);
    }

    public final void zzj() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
            zzcuq zzcuq2 = this.zza;
            if (zzcuq2 == null) return;
            zzcuq2.zzT();
            return;
        }
    }

    public final boolean zzk() {
        return false;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzl(zzbdg zzbdg2) throws RemoteException {
        synchronized (this) {
            Preconditions.checkMainThread((String)"loadAd must be called on the main UI thread.");
            zzt.zzc();
            if (zzs.zzK((Context)this.zzc) && zzbdg2.zzs == null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to load the ad because app ID is missing.");
                this.zzh.zzbD(zzfbm.zzd((int)4, null, null));
                return false;
            }
            boolean bl = this.zzH();
            if (bl) {
                return false;
            }
            Object object = new AtomicBoolean();
            this.zze = object;
            zzeut zzeut2 = new zzeut(this);
            zzeup zzeup2 = this.zzg;
            object = this.zzf;
            zzeuu zzeuu2 = new zzeuu(this);
            return zzeup2.zza(zzbdg2, (String)object, (zzelw)zzeut2, (zzelx)zzeuu2);
        }
    }

    public final void zzm() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"pause must be called on the main UI thread.");
            return;
        }
    }

    public final void zzn() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"resume must be called on the main UI thread.");
            return;
        }
    }

    public final void zzo(zzbfa zzbfa2) {
    }

    public final void zzp(zzbfu zzbfu2) {
    }

    public final void zzq(zzbfr zzbfr2) {
    }

    public final Bundle zzr() {
        return new Bundle();
    }

    public final void zzs() {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzt() {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final zzbdl zzu() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"getAdSize must be called on the main UI thread.");
            zzcuq zzcuq2 = this.zza;
            if (zzcuq2 == null) return null;
            zzcuq2 = zzfav.zzb((Context)this.zzc, Collections.singletonList(zzcuq2.zza()));
            return zzcuq2;
        }
    }

    public final void zzv(zzbdl zzbdl2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setAdSize must be called on the main UI thread.");
            return;
        }
    }

    public final void zzw(zzbzz zzbzz2) {
    }

    public final void zzx(zzcac zzcac2, String string) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final String zzy() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final String zzz() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }
}
