/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder
 *  com.google.android.gms.ads.admanager.zza
 *  com.google.android.gms.internal.ads.zzbhj
 */
package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.zza;
import com.google.android.gms.internal.ads.zzbhj;

public final class AdManagerAdRequest
extends AdRequest {
    /* synthetic */ AdManagerAdRequest(Builder builder, zza zza2) {
        super((AdRequest.Builder)builder);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zzq();
    }

    public String getPublisherProvidedId() {
        return this.zza.zzj();
    }

    public final zzbhj zza() {
        return this.zza;
    }
}
