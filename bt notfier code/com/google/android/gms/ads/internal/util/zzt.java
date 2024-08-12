/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebSettings
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.concurrent.Callable;

final class zzt
implements Callable {
    private final Context zza;
    private final WebSettings zzb;

    zzt(Context context, WebSettings webSettings) {
        this.zza = context;
        this.zzb = webSettings;
    }

    public final Object call() {
        Context context = this.zza;
        WebSettings webSettings = this.zzb;
        if (context.getCacheDir() != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0L);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        context = zzbjl.zzaw;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)context)).booleanValue()) {
            webSettings.setTextZoom(100);
        }
        webSettings.setAllowContentAccess(false);
        return true;
    }
}
