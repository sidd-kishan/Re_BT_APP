/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdFormat
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.query.QueryInfoGenerationCallback
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbhv
 *  com.google.android.gms.internal.ads.zzcah
 */
package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzcah;

public class QueryInfo {
    private final zzbhv zza;

    public QueryInfo(zzbhv zzbhv2) {
        this.zza = zzbhv2;
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest object, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        object = object == null ? null : object.zza();
        new zzcah(context, adFormat, (zzbhj)object).zzb(queryInfoGenerationCallback);
    }

    public String getQuery() {
        return this.zza.zza();
    }

    public Bundle getQueryBundle() {
        return this.zza.zzc();
    }

    public String getRequestId() {
        return this.zza.zzb();
    }

    public final zzbhv zza() {
        return this.zza;
    }
}
