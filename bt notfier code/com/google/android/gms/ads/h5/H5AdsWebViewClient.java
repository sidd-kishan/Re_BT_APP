/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.internal.ads.zzbqi
 *  com.google.android.gms.internal.ads.zzbqv
 */
package com.google.android.gms.ads.h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbqi;
import com.google.android.gms.internal.ads.zzbqv;

public final class H5AdsWebViewClient
extends zzbqi {
    private final zzbqv zza;

    public H5AdsWebViewClient(Context context, WebView webView) {
        this.zza = new zzbqv(context, webView);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    protected WebViewClient getDelegate() {
        return this.zza;
    }

    public WebViewClient getDelegateWebViewClient() {
        return this.zza.getDelegate();
    }

    public void setDelegateWebViewClient(WebViewClient webViewClient) {
        this.zza.zzb(webViewClient);
    }
}
