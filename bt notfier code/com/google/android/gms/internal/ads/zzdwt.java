/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdwh
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzdws
 *  com.google.android.gms.internal.ads.zzelq
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdwh;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzdws;
import com.google.android.gms.internal.ads.zzelq;

public final class zzdwt
implements zzdwh {
    private final long zza;
    private final zzelq zzb;

    zzdwt(long l, Context context, zzdwm zzdwm2, zzcoj zzcoj2, String string) {
        this.zza = l;
        zzcoj2 = zzcoj2.zzq();
        zzcoj2.zzd(context);
        zzcoj2.zzb(new zzbdl());
        zzcoj2.zzc(string);
        context = zzcoj2.zza().zza();
        this.zzb = context;
        context.zzo((zzbfa)new zzdws(this, zzdwm2));
    }

    static /* synthetic */ long zzd(zzdwt zzdwt2) {
        return zzdwt2.zza;
    }

    public final void zza(zzbdg zzbdg2) {
        this.zzb.zzl(zzbdg2);
    }

    public final void zzb() {
        this.zzb.zzZ(ObjectWrapper.wrap(null));
    }

    public final void zzc() {
        this.zzb.zzj();
    }
}
