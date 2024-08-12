/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.h5.OnH5AdsEventListener
 *  com.google.android.gms.internal.ads.zzbqt
 */
package com.google.android.gms.ads.h5;

import android.content.Context;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbqt;

public final class H5AdsRequestHandler {
    private final zzbqt zza;

    public H5AdsRequestHandler(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzbqt(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zzb();
    }

    public boolean handleH5AdsRequest(String string) {
        return this.zza.zza(string);
    }

    public boolean shouldInterceptRequest(String string) {
        return zzbqt.zzc((String)string);
    }
}
