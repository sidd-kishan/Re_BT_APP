/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzfhe
 */
package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfhe;

public final class zzfhf
extends zzfhe {
    public zzfhf(WebView webView) {
        if (!webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        this.zzc(webView);
    }
}
