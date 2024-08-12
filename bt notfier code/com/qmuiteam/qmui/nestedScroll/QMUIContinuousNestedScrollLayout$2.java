/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import android.view.View;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIContinuousNestedScrollLayout.2
implements IQMUIContinuousNestedScrollCommon.OnScrollNotifier {
    final QMUIContinuousNestedScrollLayout this$0;

    QMUIContinuousNestedScrollLayout.2(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout) {
        this.this$0 = qMUIContinuousNestedScrollLayout;
    }

    public void notify(int n, int n2) {
        int n3 = QMUIContinuousNestedScrollLayout.access$000((QMUIContinuousNestedScrollLayout)this.this$0) == null ? 0 : -QMUIContinuousNestedScrollLayout.access$000((QMUIContinuousNestedScrollLayout)this.this$0).getTopAndBottomOffset();
        int n4 = QMUIContinuousNestedScrollLayout.access$100((QMUIContinuousNestedScrollLayout)this.this$0) == null ? 0 : QMUIContinuousNestedScrollLayout.access$100((QMUIContinuousNestedScrollLayout)this.this$0).getCurrentScroll();
        int n5 = QMUIContinuousNestedScrollLayout.access$100((QMUIContinuousNestedScrollLayout)this.this$0) == null ? 0 : QMUIContinuousNestedScrollLayout.access$100((QMUIContinuousNestedScrollLayout)this.this$0).getScrollOffsetRange();
        QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = this.this$0;
        QMUIContinuousNestedScrollLayout.access$200((QMUIContinuousNestedScrollLayout)qMUIContinuousNestedScrollLayout, (int)n, (int)n2, (int)n3, (int)qMUIContinuousNestedScrollLayout.getOffsetRange(), (int)n4, (int)n5);
    }

    public void onScrollStateChange(View view, int n) {
    }
}
