/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.view.MotionEvent
 *  com.google.android.gms.ads.query.ReportingInfo$Builder
 *  com.google.android.gms.ads.query.UpdateClickUrlCallback
 *  com.google.android.gms.ads.query.UpdateImpressionUrlsCallback
 *  com.google.android.gms.ads.query.zza
 *  com.google.android.gms.internal.ads.zzcal
 */
package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.query.ReportingInfo;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.ads.query.zza;
import com.google.android.gms.internal.ads.zzcal;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public final class ReportingInfo {
    private final zzcal zza;

    /* synthetic */ ReportingInfo(Builder builder, zza zza2) {
        this.zza = new zzcal(Builder.zza((Builder)builder));
    }

    public void reportTouchEvent(MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    public void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzb(uri, updateClickUrlCallback);
    }

    public void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zza(list, updateImpressionUrlsCallback);
    }
}
