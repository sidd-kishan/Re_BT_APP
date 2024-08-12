/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbnx
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbnx;

public final class zzbiq
extends zzbnx {
    private final ShouldDelayBannerRenderingListener zza;

    public zzbiq(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zza = shouldDelayBannerRenderingListener;
    }

    public final boolean zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.zza.shouldDelayBannerRendering((Runnable)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
    }
}
