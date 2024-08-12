/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.ValueCallback
 *  com.qmuiteam.qmui.widget.webview.QMUIWebViewClient
 */
package com.qmuiteam.qmui.widget.webview;

import android.webkit.ValueCallback;
import com.qmuiteam.qmui.widget.webview.QMUIWebViewClient;

class QMUIWebViewClient.2
implements ValueCallback<String> {
    final QMUIWebViewClient this$0;
    final Runnable val$finishAction;

    QMUIWebViewClient.2(QMUIWebViewClient qMUIWebViewClient, Runnable runnable) {
        this.this$0 = qMUIWebViewClient;
        this.val$finishAction = runnable;
    }

    public void onReceiveValue(String string) {
        this.val$finishAction.run();
    }
}
