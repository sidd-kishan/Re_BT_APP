/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnp
 */
package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnp;

public final class zzcnq
extends zzcnp {
    public zzcnq(zzcml zzcml2, zzazb zzazb2, boolean bl) {
        super(zzcml2, zzazb2, bl);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) return null;
        if (webResourceRequest.getUrl() != null) return this.zzM(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
        return null;
    }
}
