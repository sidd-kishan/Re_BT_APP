/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcbo
 *  com.google.android.gms.internal.ads.zzcbp
 *  com.google.android.gms.internal.ads.zzcbq
 *  com.google.android.gms.internal.ads.zzchg
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcbo;
import com.google.android.gms.internal.ads.zzcbp;
import com.google.android.gms.internal.ads.zzcbq;
import com.google.android.gms.internal.ads.zzchg;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public final class zzcbr {
    private final WeakHashMap<Context, zzcbq> zza = new WeakHashMap();

    static /* synthetic */ WeakHashMap zza(zzcbr zzcbr2) {
        return zzcbr2.zza;
    }

    public final Future<zzcbo> zzb(Context context) {
        return zzchg.zza.zzb((Callable)new zzcbp(this, context));
    }
}
