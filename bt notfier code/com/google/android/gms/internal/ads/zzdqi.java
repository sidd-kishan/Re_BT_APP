/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblq
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbrz
 *  com.google.android.gms.internal.ads.zzbsd
 *  com.google.android.gms.internal.ads.zzcht
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdqg
 *  com.google.android.gms.internal.ads.zzdqh
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblq;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbrz;
import com.google.android.gms.internal.ads.zzbsd;
import com.google.android.gms.internal.ads.zzcht;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdqg;
import com.google.android.gms.internal.ads.zzdqh;
import java.util.Collections;

public final class zzdqi
extends zzbrz
implements ViewTreeObserver.OnGlobalLayoutListener,
ViewTreeObserver.OnScrollChangedListener,
zzblq {
    private View zza;
    private zzbhc zzb;
    private zzdmh zzc;
    private boolean zzd;
    private boolean zze;

    public zzdqi(zzdmh zzdmh2, zzdmm zzdmm2) {
        this.zza = zzdmm2.zzH();
        this.zzb = zzdmm2.zzw();
        this.zzc = zzdmh2;
        this.zzd = false;
        this.zze = false;
        if (zzdmm2.zzR() == null) return;
        zzdmm2.zzR().zzaw((zzblq)this);
    }

    private final void zzg() {
        View view = this.zza;
        if (view == null) {
            return;
        }
        if (!((view = view.getParent()) instanceof ViewGroup)) return;
        ((ViewGroup)view).removeView(this.zza);
    }

    private final void zzh() {
        zzdmh zzdmh2 = this.zzc;
        if (zzdmh2 == null) return;
        View view = this.zza;
        if (view == null) return;
        zzdmh2.zzr(view, Collections.emptyMap(), Collections.emptyMap(), zzdmh.zzC((View)this.zza));
    }

    private static final void zzi(zzbsd zzbsd2, int n) {
        try {
            zzbsd2.zzf(n);
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onGlobalLayout() {
        this.zzh();
    }

    public final void onScrollChanged() {
        this.zzh();
    }

    public final void zza() {
        zzs.zza.post((Runnable)new zzdqg(this));
    }

    public final zzbhc zzb() throws RemoteException {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        if (!this.zzd) return this.zzb;
        com.google.android.gms.ads.internal.util.zze.zzf((String)"getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        this.zzg();
        zzdmh zzdmh2 = this.zzc;
        if (zzdmh2 != null) {
            zzdmh2.zzT();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zzd(IObjectWrapper object, zzbsd zzbsd2) throws RemoteException {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        if (this.zzd) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Instream ad can not be shown after destroy().");
            zzdqi.zzi(zzbsd2, 2);
            return;
        }
        View view = this.zza;
        if (view != null && this.zzb != null) {
            if (this.zze) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Instream ad should not be used again.");
                zzdqi.zzi(zzbsd2, 1);
                return;
            }
            this.zze = true;
            this.zzg();
            ((ViewGroup)ObjectWrapper.unwrap((IObjectWrapper)object)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzt.zzz();
            zzcht.zza((View)this.zza, (ViewTreeObserver.OnGlobalLayoutListener)this);
            zzt.zzz();
            zzcht.zzb((View)this.zza, (ViewTreeObserver.OnScrollChangedListener)this);
            this.zzh();
            try {
                zzbsd2.zze();
                return;
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
                return;
            }
        }
        object = view == null ? "can not get video view." : "can not get video controller.";
        object = ((String)object).length() != 0 ? "Instream internal error: ".concat((String)object) : new String("Instream internal error: ");
        com.google.android.gms.ads.internal.util.zze.zzf((String)object);
        zzdqi.zzi(zzbsd2, 0);
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        this.zzd(iObjectWrapper, (zzbsd)new zzdqh(this));
    }

    public final zzbme zzf() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        if (this.zzd) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdmh zzdmh2 = this.zzc;
        if (zzdmh2 == null) return null;
        if (zzdmh2.zzJ() == null) return null;
        return this.zzc.zzJ().zza();
    }
}
