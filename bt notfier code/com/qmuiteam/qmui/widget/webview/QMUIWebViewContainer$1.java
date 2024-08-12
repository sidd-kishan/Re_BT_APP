/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView$OnScrollChangeListener
 *  com.qmuiteam.qmui.widget.webview.QMUIWebViewContainer
 */
package com.qmuiteam.qmui.widget.webview;

import android.webkit.WebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebViewContainer;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIWebViewContainer.1
implements QMUIWebView.OnScrollChangeListener {
    final QMUIWebViewContainer this$0;

    QMUIWebViewContainer.1(QMUIWebViewContainer qMUIWebViewContainer) {
        this.this$0 = qMUIWebViewContainer;
    }

    public void onScrollChange(WebView webView, int n, int n2, int n3, int n4) {
        if (QMUIWebViewContainer.access$000((QMUIWebViewContainer)this.this$0) == null) return;
        QMUIWebViewContainer.access$000((QMUIWebViewContainer)this.this$0).onScrollChange(webView, n, n2, n3, n4);
    }
}
