/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout;

class QMUIContinuousNestedBottomDelegateLayout.1
implements Runnable {
    final QMUIContinuousNestedBottomDelegateLayout this$0;

    QMUIContinuousNestedBottomDelegateLayout.1(QMUIContinuousNestedBottomDelegateLayout qMUIContinuousNestedBottomDelegateLayout) {
        this.this$0 = qMUIContinuousNestedBottomDelegateLayout;
    }

    @Override
    public void run() {
        this.this$0.checkLayout();
    }
}
