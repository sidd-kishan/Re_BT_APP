/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcbo
 *  com.google.android.gms.internal.ads.zzcbr
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcbo;
import com.google.android.gms.internal.ads.zzcbr;
import java.util.concurrent.Callable;

final class zzcbp
implements Callable<zzcbo> {
    final Context zza;
    final zzcbr zzb;

    zzcbp(zzcbr zzcbr2, Context context) {
        this.zzb = zzcbr2;
        this.zza = context;
    }
}
