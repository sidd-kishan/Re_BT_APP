/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.google.android.gms.ads.h5.OnH5AdsEventListener
 *  com.google.android.gms.internal.ads.zzbqv
 */
package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbqv;

final class zzbqu
implements OnH5AdsEventListener {
    private final WebView zza;

    zzbqu(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String string) {
        WebView webView = this.zza;
        int n = zzbqv.zza;
        webView.evaluateJavascript(string, null);
    }
}
