/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.view.KeyEvent
 *  android.webkit.ValueCallback
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView
 */
package com.qmuiteam.qmui.widget.webview;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

public class QMUIWebViewClient
extends WebViewClient {
    public static final int JS_FAKE_KEY_CODE_EVENT = 112;
    private boolean mDisableVideoFullscreenBtnAlways;
    private boolean mIsPageFinished = false;
    private boolean mNeedDispatchSafeAreaInset;

    public QMUIWebViewClient(boolean bl, boolean bl2) {
        this.mNeedDispatchSafeAreaInset = bl;
        this.mDisableVideoFullscreenBtnAlways = bl2;
    }

    static /* synthetic */ void access$000(QMUIWebViewClient qMUIWebViewClient, WebView webView) {
        qMUIWebViewClient.dispatchFullscreenRequestEvent(webView);
    }

    private void dispatchFullscreenRequestAction(QMUIWebView qMUIWebView) {
        if (qMUIWebView.isNotSupportChangeCssEnv()) {
            return;
        }
        if (!this.mDisableVideoFullscreenBtnAlways) {
            this.runJsCode((WebView)qMUIWebView, this.getJsCodeForDisableVideoFullscreenBtn(), null);
        }
        this.runJsCode((WebView)qMUIWebView, this.getJsCodeForFullscreenHtml(), (Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void dispatchFullscreenRequestEvent(WebView webView) {
        webView.dispatchKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 131, 0, 0, -1, 0));
    }

    private String getJsCodeForDisableVideoFullscreenBtn() {
        return "(function(){\n   var head = document.getElementsByTagName('head')[0];\n   var style = document.createElement('style');\n   style.type = 'text/css';   style.innerHTML = 'video::-webkit-media-controls-fullscreen-button{display: none !important;}'\n   head.appendChild(style);\n})()";
    }

    private String getJsCodeForFullscreenHtml() {
        return "(function(){\n   document.body.addEventListener('keydown', function(e){\n        if(e.keyCode == 112){\n             var html = document.documentElement;\n             var requestFullscreen = html.requestFullscreen || html.webkitRequestFullscreen;\n             requestFullscreen.call(html);\n        }\n    })\n})()";
    }

    private void runJsCode(WebView webView, String string, Runnable runnable) {
        if (Build.VERSION.SDK_INT > 19) {
            if (runnable == null) {
                webView.evaluateJavascript(string, null);
            } else {
                webView.evaluateJavascript(string, (ValueCallback)new /* Unavailable Anonymous Inner Class!! */);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:");
            stringBuilder.append(string);
            webView.loadUrl(stringBuilder.toString());
            if (runnable == null) return;
            webView.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, 250L);
        }
    }

    public void onPageFinished(WebView webView, String string) {
        super.onPageFinished(webView, string);
        this.mIsPageFinished = true;
        if (this.mDisableVideoFullscreenBtnAlways) {
            this.runJsCode(webView, this.getJsCodeForDisableVideoFullscreenBtn(), null);
        }
        if (!this.mNeedDispatchSafeAreaInset) return;
        if (!(webView instanceof QMUIWebView)) return;
        this.dispatchFullscreenRequestAction((QMUIWebView)webView);
    }

    public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
        this.mIsPageFinished = false;
        super.onPageStarted(webView, string, bitmap);
    }

    public void setNeedDispatchSafeAreaInset(QMUIWebView qMUIWebView) {
        if (this.mNeedDispatchSafeAreaInset) return;
        this.mNeedDispatchSafeAreaInset = true;
        if (!this.mIsPageFinished) return;
        this.dispatchFullscreenRequestAction(qMUIWebView);
    }
}
