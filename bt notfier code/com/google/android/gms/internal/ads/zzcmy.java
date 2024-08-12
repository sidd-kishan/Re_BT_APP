/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;

final class zzcmy
implements Runnable {
    private final IObjectWrapper zza;

    zzcmy(IObjectWrapper iObjectWrapper) {
        this.zza = iObjectWrapper;
    }

    @Override
    public final void run() {
        IObjectWrapper iObjectWrapper = this.zza;
        zzt.zzr().zzg(iObjectWrapper);
    }
}
