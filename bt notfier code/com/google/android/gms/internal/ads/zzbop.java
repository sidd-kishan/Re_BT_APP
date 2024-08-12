/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.formats.UnifiedNativeAd$UnconfirmedClickListener
 *  com.google.android.gms.internal.ads.zzboa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.internal.ads.zzboa;

public final class zzbop
extends zzboa {
    private final UnifiedNativeAd.UnconfirmedClickListener zza;

    public zzbop(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze(String string) {
        this.zza.onUnconfirmedClickReceived(string);
    }

    public final void zzf() {
        this.zza.onUnconfirmedClickCancelled();
    }
}
