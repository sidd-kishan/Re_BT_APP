/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcup
 *  com.google.android.gms.internal.ads.zzcve
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdak
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdao
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzddb
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzdgn
 *  com.google.android.gms.internal.ads.zzdgp
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzely
 *  com.google.android.gms.internal.ads.zzeuz
 *  com.google.android.gms.internal.ads.zzeva
 *  com.google.android.gms.internal.ads.zzevc
 *  com.google.android.gms.internal.ads.zzevd
 *  com.google.android.gms.internal.ads.zzevv
 *  com.google.android.gms.internal.ads.zzexl
 *  com.google.android.gms.internal.ads.zzexm
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcup;
import com.google.android.gms.internal.ads.zzcve;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdak;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdao;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzddb;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzdgn;
import com.google.android.gms.internal.ads.zzdgp;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzely;
import com.google.android.gms.internal.ads.zzeuz;
import com.google.android.gms.internal.ads.zzeva;
import com.google.android.gms.internal.ads.zzevc;
import com.google.android.gms.internal.ads.zzevd;
import com.google.android.gms.internal.ads.zzevv;
import com.google.android.gms.internal.ads.zzexl;
import com.google.android.gms.internal.ads.zzexm;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class zzevf<AppOpenAd extends zzcxg, AppOpenRequestComponent extends zzcup<AppOpenAd>, AppOpenRequestComponentBuilder extends zzdak<AppOpenRequestComponent>>
implements zzely<AppOpenAd> {
    protected final zzcoj zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzevv zzd;
    private final zzexo<AppOpenRequestComponent, AppOpenAd> zze;
    private final ViewGroup zzf;
    private final zzfap zzg;
    @Nullable
    private zzfsm<AppOpenAd> zzh;

    protected zzevf(Context context, Executor executor, zzcoj zzcoj2, zzexo<AppOpenRequestComponent, AppOpenAd> zzexo2, zzevv zzevv2, zzfap zzfap2) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcoj2;
        this.zze = zzexo2;
        this.zzd = zzevv2;
        this.zzg = zzfap2;
        this.zzf = new FrameLayout(context);
    }

    static /* synthetic */ Executor zzd(zzevf zzevf2) {
        return zzevf2.zzc;
    }

    static /* synthetic */ zzevv zze(zzevf zzevf2) {
        return zzevf2.zzd;
    }

    static /* synthetic */ zzexo zzf(zzevf zzevf2) {
        return zzevf2.zze;
    }

    static /* synthetic */ zzfsm zzg(zzevf zzevf2, zzfsm zzfsm2) {
        zzevf2.zzh = null;
        return null;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ zzdak zzh(zzevf zzevf2, zzexm zzexm2) {
        return zzevf2.zzl(zzexm2);
    }

    private final AppOpenRequestComponentBuilder zzl(zzexm object) {
        synchronized (this) {
            object = (zzevd)object;
            zzbjd zzbjd2 = zzbjl.zzfP;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                zzbjd2 = new zzcve(this.zzf);
                zzdam zzdam2 = new zzdam();
                zzdam2.zze(this.zzb);
                zzdam2.zzf(object.zza);
                zzdam2 = zzdam2.zzh();
                object = new zzdgn();
                object.zzs((zzdbs)this.zzd, this.zzc);
                object.zzv((zzdio)this.zzd, this.zzc);
                object = this.zzc((zzcve)zzbjd2, (zzdao)zzdam2, object.zzC());
                return (AppOpenRequestComponentBuilder)object;
            }
            zzevv zzevv2 = zzevv.zzg((zzevv)this.zzd);
            zzbjd2 = new zzdgn();
            zzbjd2.zzr((zzdbf)zzevv2, this.zzc);
            zzbjd2.zzx((zzddb)zzevv2, this.zzc);
            zzbjd2.zzy((zzo)zzevv2, this.zzc);
            zzbjd2.zzz((zzddn)zzevv2, this.zzc);
            zzbjd2.zzs((zzdbs)zzevv2, this.zzc);
            zzbjd2.zzv((zzdio)zzevv2, this.zzc);
            zzbjd2.zzA((zzexl)zzevv2);
            zzevv2 = new zzcve(this.zzf);
            zzdam zzdam3 = new zzdam();
            zzdam3.zze(this.zzb);
            zzdam3.zzf(object.zza);
            object = this.zzc((zzcve)zzevv2, zzdam3.zzh(), zzbjd2.zzC());
        }
        return (AppOpenRequestComponentBuilder)object;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final boolean zza(zzbdg object, String zzevc2, zzelw zzbjd2, zzelx<? super AppOpenAd> zzelx2) throws RemoteException {
        synchronized (this) {
            void var4_4;
            zzevc zzevc3;
            Preconditions.checkMainThread((String)"loadAd must be called on the main UI thread.");
            if (zzevc3 == null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Ad unit ID should not be null for app open ad.");
                object = this.zzc;
                zzevc3 = new zzeuz(this);
                object.execute((Runnable)zzevc3);
                return false;
            }
            zzbjd zzbjd3 = this.zzh;
            if (zzbjd3 != null) {
                return false;
            }
            zzfbh.zzb((Context)this.zzb, (boolean)((zzbdg)object).zzf);
            zzbjd3 = zzbjl.zzgp;
            if (((Boolean)zzbet.zzc().zzc(zzbjd3)).booleanValue() && ((zzbdg)object).zzf) {
                this.zza.zzz().zzc(true);
            }
            zzbjd3 = this.zzg;
            zzbjd3.zzw((String)zzevc3);
            zzbjd3.zzt(zzbdl.zzd());
            zzbjd3.zzr((zzbdg)object);
            zzevc3 = zzbjd3.zzL();
            object = new zzevd(null);
            ((zzevd)object).zza = zzevc3;
            zzevc3 = this.zze;
            zzbjd3 = new zzexp((zzexm)object, null);
            zzeva zzeva2 = new zzeva(this);
            this.zzh = zzbjd3 = zzevc3.zzc((zzexp)zzbjd3, (zzexn)zzeva2, null);
            zzevc3 = new zzevc(this, (zzelx)var4_4, (zzevd)object);
            zzfsd.zzp((zzfsm)zzbjd3, (zzfrz)zzevc3, (Executor)this.zzc);
            return true;
        }
    }

    public final boolean zzb() {
        zzfsm<AppOpenAd> zzfsm2 = this.zzh;
        if (zzfsm2 == null) return false;
        if (zzfsm2.isDone()) return false;
        return true;
    }

    protected abstract AppOpenRequestComponentBuilder zzc(zzcve var1, zzdao var2, zzdgp var3);

    public final void zzi(zzbdr zzbdr2) {
        this.zzg.zzF(zzbdr2);
    }

    final /* synthetic */ void zzj() {
        this.zzd.zzbD(zzfbm.zzd((int)6, null, null));
    }
}
