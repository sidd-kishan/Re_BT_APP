/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.ValueCallback
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzaws
 *  com.google.android.gms.internal.ads.zzawz
 *  com.google.android.gms.internal.ads.zzaxc
 */
package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzaws;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxc;

final class zzaxa
implements Runnable {
    final ValueCallback<String> zza;
    final zzaws zzb;
    final WebView zzc;
    final boolean zzd;
    final zzaxc zze;

    zzaxa(zzaxc zzaxc2, zzaws zzaws2, WebView webView, boolean bl) {
        this.zze = zzaxc2;
        this.zzb = zzaws2;
        this.zzc = webView;
        this.zzd = bl;
        this.zza = new zzawz(this);
    }

    @Override
    public final void run() {
        if (!this.zzc.getSettings().getJavaScriptEnabled()) return;
        try {
            this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            return;
        }
        catch (Throwable throwable) {
            ((zzawz)this.zza).zza("");
        }
    }
}
