/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdbx
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdvt
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfel
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdvt;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfet;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzdwf
implements zzddx,
zzbcv,
zzdbc,
zzdbw,
zzdbx,
zzdcq,
zzdbf,
zzamv,
zzfet {
    private final List<Object> zza;
    private final zzdvt zzb;
    private long zzc;

    public zzdwf(zzdvt zzdvt2, zzcoj zzcoj2) {
        this.zzb = zzdvt2;
        this.zza = Collections.singletonList(zzcoj2);
    }

    private final void zze(Class<?> object, String string, Object ... objectArray) {
        zzdvt zzdvt2 = this.zzb;
        List<Object> list = this.zza;
        object = ((String)(object = String.valueOf(((Class)object).getSimpleName()))).length() != 0 ? "Event-".concat((String)object) : new String("Event-");
        zzdvt2.zza(list, (String)object, string, objectArray);
    }

    public final void onAdClicked() {
        this.zze(zzbcv.class, "onAdClicked", new Object[0]);
    }

    public final void zza(Context context) {
        this.zze(zzdbx.class, "onPause", context);
    }

    public final void zzb(Context context) {
        this.zze(zzdbx.class, "onResume", context);
    }

    public final void zzbC(String string, String string2) {
        this.zze(zzamv.class, "onAppEvent", string, string2);
    }

    public final void zzbD(zzbcz zzbcz2) {
        this.zze(zzdbf.class, "onAdFailedToLoad", zzbcz2.zza, zzbcz2.zzb, zzbcz2.zzc);
    }

    public final void zzbE(zzfem zzfem2, String string) {
        this.zze(zzfel.class, "onTaskCreated", string);
    }

    public final void zzbF(zzfem zzfem2, String string) {
        this.zze(zzfel.class, "onTaskStarted", string);
    }

    public final void zzbG(zzcbj zzcbj2) {
        this.zzc = zzt.zzj().elapsedRealtime();
        this.zze(zzddx.class, "onAdRequest", new Object[0]);
    }

    public final void zzbo(Context context) {
        this.zze(zzdbx.class, "onDestroy", context);
    }

    public final void zzc(zzfem zzfem2, String string, Throwable throwable) {
        this.zze(zzfel.class, "onTaskFailed", string, throwable.getClass().getSimpleName());
    }

    public final void zzd(zzfem zzfem2, String string) {
        this.zze(zzfel.class, "onTaskSucceeded", string);
    }

    public final void zzf() {
        long l = zzt.zzj().elapsedRealtime();
        long l2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(41);
        stringBuilder.append("Ad Request Latency : ");
        stringBuilder.append(l - l2);
        zze.zza((String)stringBuilder.toString());
        this.zze(zzdcq.class, "onAdLoaded", new Object[0]);
    }

    public final void zzg() {
        this.zze(zzdbw.class, "onAdImpression", new Object[0]);
    }

    public final void zzh() {
        this.zze(zzdbc.class, "onAdOpened", new Object[0]);
    }

    public final void zzi() {
        this.zze(zzdbc.class, "onAdClosed", new Object[0]);
    }

    public final void zzj() {
        this.zze(zzdbc.class, "onAdLeftApplication", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzk(zzcbz zzcbz2, String string, String string2) {
        this.zze(zzdbc.class, "onRewarded", zzcbz2, string, string2);
    }

    public final void zzl() {
        this.zze(zzdbc.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzm() {
        this.zze(zzdbc.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzq(zzfal zzfal2) {
    }
}
