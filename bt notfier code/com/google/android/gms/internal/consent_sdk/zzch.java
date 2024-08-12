/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.webkit.WebView
 */
package com.google.android.gms.internal.consent_sdk;

import android.os.Build;
import android.webkit.WebView;

public class zzch {
    private static Boolean zza;

    private zzch() {
    }

    public static void zza(WebView webView, String string) {
        if (Build.VERSION.SDK_INT >= 19 && zzch.zza(webView)) {
            webView.evaluateJavascript(string, null);
            return;
        }
        string = (string = String.valueOf(string)).length() != 0 ? "javascript:".concat(string) : new String("javascript:");
        webView.loadUrl(string);
    }

    private static boolean zza(WebView webView) {
        synchronized (zzch.class) {
            Boolean bl = zza;
            if (bl == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zza = true;
                }
                catch (IllegalStateException illegalStateException) {
                    zza = false;
                }
            }
            boolean bl2 = zza;
            return bl2;
        }
    }
}
