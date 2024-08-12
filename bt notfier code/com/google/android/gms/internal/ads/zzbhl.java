/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.ads.zza
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzawr
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbcw
 *  com.google.android.gms.internal.ads.zzbdb
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbec
 *  com.google.android.gms.internal.ads.zzbee
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbes
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbhk
 *  com.google.android.gms.internal.ads.zzbil
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbcw;
import com.google.android.gms.internal.ads.zzbdb;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbec;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zzbhl {
    final zzbes zza;
    private final zzbvd zzb;
    private final zzbdk zzc;
    private final AtomicBoolean zzd;
    private final VideoController zze;
    private zzbcv zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzbfn zzj;
    private VideoOptions zzk;
    private String zzl;
    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;

    public zzbhl(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzbdk.zza, null, 0);
    }

    public zzbhl(ViewGroup viewGroup, int n) {
        this(viewGroup, null, false, zzbdk.zza, null, n);
    }

    public zzbhl(ViewGroup viewGroup, AttributeSet attributeSet, boolean bl) {
        this(viewGroup, attributeSet, bl, zzbdk.zza, null, 0);
    }

    public zzbhl(ViewGroup viewGroup, AttributeSet attributeSet, boolean bl, int n) {
        this(viewGroup, attributeSet, bl, zzbdk.zza, null, n);
    }

    zzbhl(ViewGroup viewGroup, AttributeSet attributeSet, boolean bl, zzbdk zzbdk2, zzbfn zzbfn2, int n) {
        block4: {
            this.zzb = new zzbvd();
            this.zze = new VideoController();
            this.zza = new zzbhk(this);
            this.zzm = viewGroup;
            this.zzc = zzbdk2;
            this.zzj = null;
            this.zzd = new AtomicBoolean(false);
            this.zzn = n;
            if (attributeSet == null) return;
            zzbfn2 = viewGroup.getContext();
            try {
                super((Context)zzbfn2, attributeSet);
                this.zzh = zzbdk2.zza(bl);
                this.zzl = zzbdk2.zzb();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                zzber.zza().zzb(viewGroup, new zzbdl((Context)zzbfn2, AdSize.BANNER), illegalArgumentException.getMessage(), illegalArgumentException.getMessage());
                break block4;
            }
            if (!viewGroup.isInEditMode()) return;
            zzbdk2 = zzber.zza();
            attributeSet = this.zzh[0];
            n = this.zzn;
            if (attributeSet.equals(AdSize.INVALID)) {
                attributeSet = zzbdl.zze();
            } else {
                attributeSet = new zzbdl((Context)zzbfn2, (AdSize)attributeSet);
                ((zzbdl)attributeSet).zzj = zzbhl.zzC(n);
            }
            zzbdk2.zzc(viewGroup, (zzbdl)attributeSet, "Ads by Google");
            return;
        }
    }

    private static zzbdl zzB(Context context, AdSize[] adSizeArray, int n) {
        int n2 = adSizeArray.length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                context = new zzbdl(context, adSizeArray);
                context.zzj = zzbhl.zzC(n);
                return context;
            }
            if (adSizeArray[n3].equals((Object)AdSize.INVALID)) {
                return zzbdl.zze();
            }
            ++n3;
        }
    }

    private static boolean zzC(int n) {
        if (n != 1) return false;
        return true;
    }

    static /* synthetic */ VideoController zza(zzbhl zzbhl2) {
        return zzbhl2.zze;
    }

    public final boolean zzA(zzbfn zzbfn2) {
        IObjectWrapper iObjectWrapper;
        try {
            iObjectWrapper = zzbfn2.zzi();
            if (iObjectWrapper == null) {
                return false;
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return false;
        }
        if (((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)).getParent() != null) {
            return false;
        }
        this.zzm.addView((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
        this.zzj = zzbfn2;
        return true;
    }

    public final void zzb() {
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            zzbfn2.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final AdListener zzc() {
        return this.zzg;
    }

    public final AdSize zzd() {
        AdSize adSize;
        try {
            adSize = this.zzj;
            if (adSize != null && (adSize = adSize.zzu()) != null) {
                adSize = com.google.android.gms.ads.zza.zza((int)adSize.zze, (int)adSize.zzb, (String)adSize.zza);
                return adSize;
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        if ((adSize = this.zzh) == null) return null;
        return adSize[0];
    }

    public final AdSize[] zze() {
        return this.zzh;
    }

    public final String zzf() {
        if (this.zzl != null) return this.zzl;
        zzbfn zzbfn2 = this.zzj;
        if (zzbfn2 == null) return this.zzl;
        try {
            this.zzl = zzbfn2.zzB();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        return this.zzl;
    }

    public final AppEventListener zzg() {
        return this.zzi;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzh(zzbhj var1_1) {
        if (this.zzj != null) ** GOTO lbl54
        if (this.zzh == null || this.zzl == null) ** GOTO lbl52
        var3_3 = this.zzm.getContext();
        var2_4 = zzbhl.zzB(var3_3, this.zzh, this.zzn);
        if ("search_v2".equals(var2_4.zza)) {
            var5_6 = zzber.zzb();
            var6_8 = this.zzl;
            var4_10 = new zzbee(var5_6, var3_3, (zzbdl)var2_4, var6_8);
            var2_4 = (zzbfn)var4_10.zzd(var3_3, false);
        } else {
            var7_11 = zzber.zzb();
            var5_7 = this.zzl;
            var6_9 = this.zzb;
            var4_10 = new zzbec(var7_11, var3_3, (zzbdl)var2_4, var5_7, (zzbvg)var6_9);
            var2_4 = (zzbfn)var4_10.zzd(var3_3, false);
        }
        this.zzj = var2_4;
        var3_3 = new zzbdb((AdListener)this.zza);
        var2_4.zzo((zzbfa)var3_3);
        var2_4 = this.zzf;
        if (var2_4 != null) {
            var4_10 = this.zzj;
            var3_3 = new zzbcw((zzbcv)var2_4);
            var4_10.zzF((zzbex)var3_3);
        }
        if ((var3_3 = this.zzi) != null) {
            var2_4 = this.zzj;
            var4_10 = new zzawr((AppEventListener)var3_3);
            var2_4.zzp((zzbfu)var4_10);
        }
        if ((var2_4 = this.zzk) != null) {
            var3_3 = this.zzj;
            var4_10 = new zzbis((VideoOptions)var2_4);
            var3_3.zzM((zzbis)var4_10);
        }
        var3_3 = this.zzj;
        var2_4 = new zzbil(this.zzp);
        var3_3.zzX((zzbgw)var2_4);
        this.zzj.zzG(this.zzo);
        var2_4 = this.zzj;
        if (var2_4 != null) ** GOTO lbl43
        ** GOTO lbl54
        {
            catch (RemoteException var1_2) {
                zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_2);
                return;
            }
lbl43:
            // 1 sources

            try {
                var2_4 = var2_4.zzi();
                if (var2_4 != null) {
                    this.zzm.addView((View)ObjectWrapper.unwrap((IObjectWrapper)var2_4));
                }
                ** GOTO lbl54
            }
            catch (RemoteException var2_5) {}
            {
                block11: {
                    zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var2_5);
                    break block11;
lbl52:
                    // 1 sources

                    var1_1 /* !! */  = new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                    throw var1_1 /* !! */ ;
                }
                if ((var2_4 = this.zzj) == null) throw null;
                if (var2_4.zzl(this.zzc.zza(this.zzm.getContext(), var1_1 /* !! */ )) == false) return;
                this.zzb.zze(var1_1 /* !! */ .zzn());
                return;
            }
        }
    }

    public final void zzi() {
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            zzbfn2.zzm();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzj() {
        if (this.zzd.getAndSet(true)) {
            return;
        }
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            zzbfn2.zzt();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzk() {
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            zzbfn2.zzn();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzl(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzm(zzbcv zzbcv2) {
        try {
            this.zzf = zzbcv2;
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            if (zzbcv2 != null) {
                zzbcw zzbcw2 = new zzbcw(zzbcv2);
                zzbcv2 = zzbcw2;
            } else {
                zzbcv2 = null;
            }
            zzbfn2.zzF((zzbex)zzbcv2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzn(AdSize ... adSizeArray) {
        if (this.zzh != null) throw new IllegalStateException("The ad size can only be set once on AdView.");
        this.zzo(adSizeArray);
    }

    public final void zzo(AdSize ... zzbfn2) {
        this.zzh = zzbfn2;
        try {
            zzbfn2 = this.zzj;
            if (zzbfn2 != null) {
                zzbfn2.zzv(zzbhl.zzB(this.zzm.getContext(), this.zzh, this.zzn));
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        this.zzm.requestLayout();
    }

    public final void zzp(String string) {
        if (this.zzl != null) throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        this.zzl = string;
    }

    public final void zzq(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            if (appEventListener != null) {
                zzawr zzawr2 = new zzawr(appEventListener);
                appEventListener = zzawr2;
            } else {
                appEventListener = null;
            }
            zzbfn2.zzp((zzbfu)appEventListener);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzr(boolean bl) {
        this.zzo = bl;
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            zzbfn2.zzG(bl);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final boolean zzs() {
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return false;
            boolean bl = zzbfn2.zzH();
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        return false;
    }

    public final ResponseInfo zzt() {
        zzbgz zzbgz2;
        zzbgz zzbgz3 = null;
        try {
            zzbfn zzbfn2 = this.zzj;
            zzbgz2 = zzbgz3;
            if (zzbfn2 == null) return ResponseInfo.zzb(zzbgz2);
            zzbgz2 = zzbfn2.zzA();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            zzbgz2 = zzbgz3;
        }
        return ResponseInfo.zzb(zzbgz2);
    }

    public final void zzu(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            zzbil zzbil2 = new zzbil(onPaidEventListener);
            zzbfn2.zzX((zzbgw)zzbil2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", (Throwable)remoteException);
            return;
        }
    }

    public final OnPaidEventListener zzv() {
        return this.zzp;
    }

    public final VideoController zzw() {
        return this.zze;
    }

    public final zzbhc zzx() {
        zzbfn zzbfn2 = this.zzj;
        if (zzbfn2 == null) return null;
        try {
            zzbfn2 = zzbfn2.zzL();
            return zzbfn2;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        return null;
    }

    public final void zzy(VideoOptions object) {
        this.zzk = object;
        try {
            zzbfn zzbfn2 = this.zzj;
            if (zzbfn2 == null) return;
            object = object == null ? null : new zzbis(object);
            zzbfn2.zzM((zzbis)object);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final VideoOptions zzz() {
        return this.zzk;
    }
}
