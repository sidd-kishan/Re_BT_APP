/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.appopen.AppOpenAd$AppOpenAdLoadCallback
 *  com.google.android.gms.internal.ads.zzaxr
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.internal.ads.zzaxr;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzaye {
    private zzbfn zza;
    private final Context zzb;
    private final String zzc;
    private final zzbhj zzd;
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzbvd zzg = new zzbvd();
    private final zzbdk zzh;

    public zzaye(Context context, String string, zzbhj zzbhj2, int n, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = string;
        this.zzd = zzbhj2;
        this.zze = n;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzbdk.zza;
    }

    public final void zza() {
        try {
            zzbdl zzbdl2 = zzbdl.zzd();
            this.zza = zzber.zzb().zzj(this.zzb, zzbdl2, this.zzc, (zzbvg)this.zzg);
            zzbdr zzbdr2 = new zzbdr(this.zze);
            zzbdl2 = this.zza;
            if (zzbdl2 == null) return;
            zzbdl2.zzO(zzbdr2);
            zzbdr2 = this.zza;
            zzbdl2 = new zzaxr(this.zzf, this.zzc);
            zzbdr2.zzP((zzaxz)zzbdl2);
            this.zza.zzl(this.zzh.zza(this.zzb, this.zzd));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
