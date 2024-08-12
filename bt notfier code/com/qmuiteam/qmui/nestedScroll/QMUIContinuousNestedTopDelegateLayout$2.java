/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import android.view.View;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout;

class QMUIContinuousNestedTopDelegateLayout.2
implements IQMUIContinuousNestedScrollCommon.OnScrollNotifier {
    final QMUIContinuousNestedTopDelegateLayout this$0;
    final IQMUIContinuousNestedScrollCommon.OnScrollNotifier val$notifier;

    QMUIContinuousNestedTopDelegateLayout.2(QMUIContinuousNestedTopDelegateLayout qMUIContinuousNestedTopDelegateLayout, IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.this$0 = qMUIContinuousNestedTopDelegateLayout;
        this.val$notifier = onScrollNotifier;
    }

    public void notify(int n, int n2) {
        this.val$notifier.notify(this.this$0.getCurrentScroll(), this.this$0.getScrollOffsetRange());
    }

    public void onScrollStateChange(View view, int n) {
    }
}
