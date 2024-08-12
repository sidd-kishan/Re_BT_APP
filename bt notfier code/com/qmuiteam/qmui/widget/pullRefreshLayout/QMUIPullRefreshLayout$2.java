/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

class QMUIPullRefreshLayout.2
implements Runnable {
    final QMUIPullRefreshLayout this$0;
    final long val$delay;

    QMUIPullRefreshLayout.2(QMUIPullRefreshLayout qMUIPullRefreshLayout, long l) {
        this.this$0 = qMUIPullRefreshLayout;
        this.val$delay = l;
    }

    @Override
    public void run() {
        this.this$0.setToRefreshDirectly(this.val$delay);
    }
}
