/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView
 *  com.qmuiteam.qmui.widget.webview.QMUIWebViewClient
 */
package com.qmuiteam.qmui.widget.webview;

import android.webkit.WebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebViewClient;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIWebViewClient.1
implements Runnable {
    final QMUIWebViewClient this$0;
    final QMUIWebView val$webView;

    QMUIWebViewClient.1(QMUIWebViewClient qMUIWebViewClient, QMUIWebView qMUIWebView) {
        this.this$0 = qMUIWebViewClient;
        this.val$webView = qMUIWebView;
    }

    @Override
    public void run() {
        QMUIWebViewClient.access$000((QMUIWebViewClient)this.this$0, (WebView)this.val$webView);
    }
}
