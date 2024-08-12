/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.h5.OnH5AdsEventListener
 *  com.google.android.gms.internal.ads.zzbql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbql;

public final class zzbqj
extends zzbql {
    private final OnH5AdsEventListener zza;

    public zzbqj(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    public final void zzb(String string) {
        this.zza.onH5AdsEvent(string);
    }
}
