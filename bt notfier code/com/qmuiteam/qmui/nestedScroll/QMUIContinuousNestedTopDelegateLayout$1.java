/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout;

class QMUIContinuousNestedTopDelegateLayout.1
implements Runnable {
    final QMUIContinuousNestedTopDelegateLayout this$0;

    QMUIContinuousNestedTopDelegateLayout.1(QMUIContinuousNestedTopDelegateLayout qMUIContinuousNestedTopDelegateLayout) {
        this.this$0 = qMUIContinuousNestedTopDelegateLayout;
    }

    @Override
    public void run() {
        this.this$0.checkLayout();
    }
}
