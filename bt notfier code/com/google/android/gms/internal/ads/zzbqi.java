/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.http.SslError
 *  android.os.Message
 *  android.view.KeyEvent
 *  android.webkit.ClientCertRequest
 *  android.webkit.HttpAuthHandler
 *  android.webkit.RenderProcessGoneDetail
 *  android.webkit.SafeBrowsingResponse
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public abstract class zzbqi
extends WebViewClient {
    public final void doUpdateVisitedHistory(WebView webView, String string, boolean bl) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.doUpdateVisitedHistory(webView, string, bl);
    }

    protected abstract WebViewClient getDelegate();

    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onFormResubmission(webView, message, message2);
    }

    public void onLoadResource(WebView webView, String string) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onLoadResource(webView, string);
    }

    public final void onPageCommitVisible(WebView webView, String string) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onPageCommitVisible(webView, string);
    }

    public final void onPageFinished(WebView webView, String string) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onPageFinished(webView, string);
    }

    public final void onPageStarted(WebView webView, String string, Bitmap bitmap) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onPageStarted(webView, string, bitmap);
    }

    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    public final void onReceivedError(WebView webView, int n, String string, String string2) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedError(webView, n, string, string2);
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String string, String string2) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, string, string2);
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public final void onReceivedLoginRequest(WebView webView, String string, String string2, String string3) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedLoginRequest(webView, string, string2, string3);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient != null) return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
        return false;
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int n, SafeBrowsingResponse safeBrowsingResponse) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onSafeBrowsingHit(webView, webResourceRequest, n, safeBrowsingResponse);
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onScaleChanged(webView, f, f2);
    }

    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onTooManyRedirects(webView, message, message2);
    }

    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient == null) {
            return;
        }
        webViewClient.onUnhandledKeyEvent(webView, keyEvent);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient != null) return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
        return null;
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String string) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient != null) return webViewClient.shouldInterceptRequest(webView, string);
        return null;
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient != null) return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient != null) return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        WebViewClient webViewClient = this.getDelegate();
        if (webViewClient != null) return webViewClient.shouldOverrideUrlLoading(webView, string);
        return false;
    }
}
