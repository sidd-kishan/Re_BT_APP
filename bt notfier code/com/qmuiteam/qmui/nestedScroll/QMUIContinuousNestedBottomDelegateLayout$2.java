/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import android.view.View;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIContinuousNestedBottomDelegateLayout.2
implements IQMUIContinuousNestedScrollCommon.OnScrollNotifier {
    final QMUIContinuousNestedBottomDelegateLayout this$0;
    final IQMUIContinuousNestedScrollCommon.OnScrollNotifier val$notifier;

    QMUIContinuousNestedBottomDelegateLayout.2(QMUIContinuousNestedBottomDelegateLayout qMUIContinuousNestedBottomDelegateLayout, IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.this$0 = qMUIContinuousNestedBottomDelegateLayout;
        this.val$notifier = onScrollNotifier;
    }

    public void notify(int n, int n2) {
        this.val$notifier.notify(n - QMUIContinuousNestedBottomDelegateLayout.access$000((QMUIContinuousNestedBottomDelegateLayout)this.this$0).getTop(), n2 + QMUIContinuousNestedBottomDelegateLayout.access$000((QMUIContinuousNestedBottomDelegateLayout)this.this$0).getHeight());
    }

    public void onScrollStateChange(View view, int n) {
        this.val$notifier.onScrollStateChange(view, n);
    }
}
