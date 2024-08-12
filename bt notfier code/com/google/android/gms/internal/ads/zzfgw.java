/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzfgx
 */
package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfgx;

final class zzfgw
implements Runnable {
    final WebView zza;
    final String zzb;

    zzfgw(zzfgx zzfgx2, WebView webView, String string) {
        this.zza = webView;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.loadUrl(this.zzb);
    }
}
