/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.ads.h5.H5AdsRequestHandler
 *  com.google.android.gms.ads.h5.OnH5AdsEventListener
 *  com.google.android.gms.internal.ads.zzbqi
 *  com.google.android.gms.internal.ads.zzbqu
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzflx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.h5.H5AdsRequestHandler;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbqi;
import com.google.android.gms.internal.ads.zzbqu;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzflx;

public final class zzbqv
extends zzbqi {
    public static final int zza = 0;
    private WebViewClient zzb;
    private final H5AdsRequestHandler zzc;
    private final WebView zzd;

    public zzbqv(Context context, WebView webView) {
        if (context == null) throw null;
        if (webView == null) throw null;
        zzflx.zza((boolean)webView.getSettings().getJavaScriptEnabled(), (Object)"JavaScript must be enabled on the WebView.");
        this.zzd = webView;
        this.zzc = new H5AdsRequestHandler(context, (OnH5AdsEventListener)new zzbqu(webView));
    }

    private final boolean zzc(WebView webView) {
        if (this.zzd.equals(webView)) {
            return true;
        }
        zzcgt.zzf((String)"H5AdsWebViewClient must be attached to the same WebVew which was passed in the constructor.");
        return false;
    }

    public final WebViewClient getDelegate() {
        return this.zzb;
    }

    public final void onLoadResource(WebView webView, String string) {
        if (!this.zzc(webView)) {
            return;
        }
        if (this.zzc.handleH5AdsRequest(string)) return;
        super.onLoadResource(webView, string);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.zzc(this.zzd)) {
            return false;
        }
        String string = webResourceRequest.getUrl().toString();
        if (!this.zzc.handleH5AdsRequest(string)) return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String string) {
        if (!this.zzc(webView)) {
            return false;
        }
        if (!this.zzc.handleH5AdsRequest(string)) return super.shouldOverrideUrlLoading(webView, string);
        return true;
    }

    public final void zza() {
        this.zzc.clearAdObjects();
    }

    public final void zzb(WebViewClient webViewClient) {
        boolean bl = webViewClient != this;
        zzflx.zza((boolean)bl, (Object)"Delegate cannot be itself.");
        this.zzb = webViewClient;
    }
}
