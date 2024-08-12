/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.search.DynamicHeightSearchAdRequest$Builder
 *  com.google.android.gms.ads.search.SearchAdRequest
 *  com.google.android.gms.ads.search.zza
 *  com.google.android.gms.internal.ads.zzbhj
 */
package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.DynamicHeightSearchAdRequest;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.ads.search.zza;
import com.google.android.gms.internal.ads.zzbhj;

/*
 * Exception performing whole class analysis ignored.
 */
public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest zza;

    /* synthetic */ DynamicHeightSearchAdRequest(Builder builder, zza zza2) {
        this.zza = new SearchAdRequest(Builder.zza((Builder)builder), null);
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> clazz) {
        return this.zza.getCustomEventExtrasBundle(clazz);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> clazz) {
        return this.zza.getNetworkExtrasBundle(clazz);
    }

    public String getQuery() {
        return this.zza.getQuery();
    }

    public boolean isTestDevice(Context context) {
        return this.zza.isTestDevice(context);
    }

    final zzbhj zza() {
        return this.zza.zza();
    }
}
