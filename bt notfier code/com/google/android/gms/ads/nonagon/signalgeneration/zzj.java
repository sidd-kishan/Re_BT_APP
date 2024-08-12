/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.dynamic.IObjectWrapper
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

final class zzj
implements Callable {
    private final zzv zza;
    private final Uri zzb;
    private final IObjectWrapper zzc;

    zzj(zzv zzv2, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zza = zzv2;
        this.zzb = uri;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzC(this.zzb, this.zzc);
    }
}
