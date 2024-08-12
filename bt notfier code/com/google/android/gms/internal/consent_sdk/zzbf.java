/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.internal.consent_sdk.zzbe
 *  com.google.android.gms.internal.consent_sdk.zzbg
 */
package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.consent_sdk.zzbe;
import com.google.android.gms.internal.consent_sdk.zzbg;

final class zzbf
extends WebViewClient {
    private final zzbe zza;

    private zzbf(zzbe zzbe2) {
        this.zza = zzbe2;
    }

    /* synthetic */ zzbf(zzbe zzbe2, zzbg zzbg2) {
        this(zzbe2);
    }

    public final void onLoadResource(WebView webView, String string) {
        if (!zzbe.zza((zzbe)this.zza, (String)string)) return;
        zzbe.zza((zzbe)this.zza).zza(string);
    }

    public final void onPageFinished(WebView webView, String string) {
        if (zzbe.zzb((zzbe)this.zza)) return;
        zzbe.zza((zzbe)this.zza);
        Log.d((String)"UserMessagingPlatform", (String)"Wall html loaded.");
        zzbe.zza((zzbe)this.zza, (boolean)true);
    }

    public final void onReceivedError(WebView webView, int n, String string, String string2) {
        zzbe.zza((zzbe)this.zza).zza(n, string, string2);
    }

    public final boolean shouldOverrideUrlLoading(WebView object, WebResourceRequest webResourceRequest) {
        object = webResourceRequest.getUrl().toString();
        if (!zzbe.zza((zzbe)this.zza, (String)object)) return false;
        zzbe.zza((zzbe)this.zza).zza((String)object);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String string) {
        if (!zzbe.zza((zzbe)this.zza, (String)string)) return false;
        zzbe.zza((zzbe)this.zza).zza(string);
        return true;
    }
}
