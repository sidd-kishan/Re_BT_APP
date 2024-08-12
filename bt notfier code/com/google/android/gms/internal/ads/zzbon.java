/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.admanager.AdManagerAdView
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzawr
 *  com.google.android.gms.internal.ads.zzbdb
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbnr
 *  com.google.android.gms.internal.ads.zzbom
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzbdb;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbnr;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbon
extends zzbnr {
    private final OnAdManagerAdViewLoadedListener zza;

    public zzbon(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    static /* synthetic */ OnAdManagerAdViewLoadedListener zzc(zzbon zzbon2) {
        return zzbon2.zza;
    }

    public final void zze(zzbfn zzbfn2, IObjectWrapper object) {
        if (zzbfn2 == null) return;
        if (object == null) return;
        AdManagerAdView adManagerAdView = new AdManagerAdView((Context)ObjectWrapper.unwrap((IObjectWrapper)object));
        Object var3_6 = null;
        try {
            if (zzbfn2.zzD() instanceof zzbdb) {
                object = (zzbdb)zzbfn2.zzD();
                object = object != null ? object.zzj() : null;
                adManagerAdView.setAdListener((AdListener)object);
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        try {
            if (zzbfn2.zzC() instanceof zzawr) {
                zzawr zzawr2 = (zzawr)zzbfn2.zzC();
                object = var3_6;
                if (zzawr2 != null) {
                    object = zzawr2.zzc();
                }
                adManagerAdView.setAppEventListener((AppEventListener)object);
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        zzcgm.zza.post((Runnable)new zzbom(this, adManagerAdView, zzbfn2));
    }
}
