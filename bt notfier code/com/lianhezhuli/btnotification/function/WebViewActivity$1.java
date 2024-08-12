/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.lianhezhuli.btnotification.function.WebViewActivity
 */
package com.lianhezhuli.btnotification.function;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lianhezhuli.btnotification.function.WebViewActivity;

class WebViewActivity.1
extends WebViewClient {
    final WebViewActivity this$0;

    WebViewActivity.1(WebViewActivity webViewActivity) {
        this.this$0 = webViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        webView.loadUrl(string);
        return true;
    }
}
