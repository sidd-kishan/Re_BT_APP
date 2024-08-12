/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.dynamic.IObjectWrapper
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

final class zzh
implements Callable {
    private final zzv zza;
    private final List zzb;
    private final IObjectWrapper zzc;

    zzh(zzv zzv2, List list, IObjectWrapper iObjectWrapper) {
        this.zza = zzv2;
        this.zzb = list;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzE(this.zzb, this.zzc);
    }
}
