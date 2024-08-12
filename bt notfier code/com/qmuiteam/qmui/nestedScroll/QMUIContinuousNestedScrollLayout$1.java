/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout;

class QMUIContinuousNestedScrollLayout.1
implements Runnable {
    final QMUIContinuousNestedScrollLayout this$0;

    QMUIContinuousNestedScrollLayout.1(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout) {
        this.this$0 = qMUIContinuousNestedScrollLayout;
    }

    @Override
    public void run() {
        this.this$0.checkLayout();
    }
}
