/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.query.ReportingInfo
 *  com.google.android.gms.internal.ads.zzcak
 */
package com.google.android.gms.ads.query;

import android.view.View;
import com.google.android.gms.ads.query.ReportingInfo;
import com.google.android.gms.internal.ads.zzcak;
import java.util.Map;

public static final class ReportingInfo.Builder {
    private final zzcak zza;

    public ReportingInfo.Builder(View view) {
        zzcak zzcak2;
        this.zza = zzcak2 = new zzcak();
        zzcak2.zzc(view);
    }

    static /* synthetic */ zzcak zza(ReportingInfo.Builder builder) {
        return builder.zza;
    }

    public ReportingInfo build() {
        return new ReportingInfo(this, null);
    }

    public ReportingInfo.Builder setAssetViews(Map<String, View> map) {
        this.zza.zzd(map);
        return this;
    }
}
