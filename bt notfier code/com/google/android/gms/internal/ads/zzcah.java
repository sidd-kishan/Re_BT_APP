/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdFormat
 *  com.google.android.gms.ads.query.QueryInfoGenerationCallback
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdh
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzbep
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcag
 *  com.google.android.gms.internal.ads.zzcfk
 *  com.google.android.gms.internal.ads.zzcfn
 *  com.google.android.gms.internal.ads.zzcfr
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdh;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcag;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcfr;

public final class zzcah {
    private static zzcfn zzd;
    private final Context zza;
    private final AdFormat zzb;
    private final zzbhj zzc;

    public zzcah(Context context, AdFormat adFormat, zzbhj zzbhj2) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = zzbhj2;
    }

    public static zzcfn zza(Context context) {
        synchronized (zzcah.class) {
            if (zzd == null) {
                zzbep zzbep2 = zzber.zzb();
                zzbvd zzbvd2 = new zzbvd();
                zzd = zzbep2.zzq(context, (zzbvg)zzbvd2);
            }
            context = zzd;
            return context;
        }
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzcfn zzcfn2 = zzcah.zza(this.zza);
        if (zzcfn2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
        zzbdg zzbdg2 = this.zzc == null ? new zzbdh().zza() : zzbdk.zza.zza(this.zza, this.zzc);
        zzbdg2 = new zzcfr(null, this.zzb.name(), null, zzbdg2);
        try {
            zzcag zzcag2 = new zzcag(this, queryInfoGenerationCallback);
            zzcfn2.zze(iObjectWrapper, (zzcfr)zzbdg2, (zzcfk)zzcag2);
            return;
        }
        catch (RemoteException remoteException) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
            return;
        }
    }
}
