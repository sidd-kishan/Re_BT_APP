/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.h5.OnH5AdsEventListener
 *  com.google.android.gms.internal.ads.zzbep
 *  com.google.android.gms.internal.ads.zzbeq
 *  com.google.android.gms.internal.ads.zzbqp
 *  com.google.android.gms.internal.ads.zzbvg
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbvg;

final class zzbeb
extends zzbeq<zzbqp> {
    final Context zza;
    final zzbvg zzb;
    final OnH5AdsEventListener zzc;

    zzbeb(zzbep zzbep2, Context context, zzbvg zzbvg2, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbvg2;
        this.zzc = onH5AdsEventListener;
    }
}
