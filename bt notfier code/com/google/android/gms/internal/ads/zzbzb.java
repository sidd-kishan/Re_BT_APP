/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nativead.NativeAd$UnconfirmedClickListener
 *  com.google.android.gms.internal.ads.zzboa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.internal.ads.zzboa;

public final class zzbzb
extends zzboa {
    private final NativeAd.UnconfirmedClickListener zza;

    public zzbzb(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze(String string) {
        this.zza.onUnconfirmedClickReceived(string);
    }

    public final void zzf() {
        this.zza.onUnconfirmedClickCancelled();
    }
}
