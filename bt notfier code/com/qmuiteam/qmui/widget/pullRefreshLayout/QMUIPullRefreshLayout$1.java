/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIPullRefreshLayout.1
implements Runnable {
    final QMUIPullRefreshLayout this$0;

    QMUIPullRefreshLayout.1(QMUIPullRefreshLayout qMUIPullRefreshLayout) {
        this.this$0 = qMUIPullRefreshLayout;
    }

    @Override
    public void run() {
        QMUIPullRefreshLayout qMUIPullRefreshLayout = this.this$0;
        qMUIPullRefreshLayout.setTargetViewToTop(QMUIPullRefreshLayout.access$000((QMUIPullRefreshLayout)qMUIPullRefreshLayout));
        this.this$0.onRefresh();
        QMUIPullRefreshLayout.access$102((QMUIPullRefreshLayout)this.this$0, (int)2);
        this.this$0.invalidate();
    }
}
