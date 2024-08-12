/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.webview.QMUIWebViewClient
 */
package com.qmuiteam.qmui.widget.webview;

import com.qmuiteam.qmui.widget.webview.QMUIWebViewClient;

class QMUIWebViewClient.3
implements Runnable {
    final QMUIWebViewClient this$0;
    final Runnable val$finishAction;

    QMUIWebViewClient.3(QMUIWebViewClient qMUIWebViewClient, Runnable runnable) {
        this.this$0 = qMUIWebViewClient;
        this.val$finishAction = runnable;
    }

    @Override
    public void run() {
        this.val$finishAction.run();
    }
}
