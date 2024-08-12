/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView
 */
package com.qmuiteam.qmui.nestedScroll;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIContinuousNestedBottomRecyclerView.1
extends RecyclerView.OnScrollListener {
    final QMUIContinuousNestedBottomRecyclerView this$0;

    QMUIContinuousNestedBottomRecyclerView.1(QMUIContinuousNestedBottomRecyclerView qMUIContinuousNestedBottomRecyclerView) {
        this.this$0 = qMUIContinuousNestedBottomRecyclerView;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int n) {
        if (QMUIContinuousNestedBottomRecyclerView.access$000((QMUIContinuousNestedBottomRecyclerView)this.this$0) == null) return;
        if (n == 0) {
            QMUIContinuousNestedBottomRecyclerView.access$000((QMUIContinuousNestedBottomRecyclerView)this.this$0).onScrollStateChange((View)recyclerView, 0);
        } else if (n == 2) {
            QMUIContinuousNestedBottomRecyclerView.access$000((QMUIContinuousNestedBottomRecyclerView)this.this$0).onScrollStateChange((View)recyclerView, 2);
        } else {
            if (n != 1) return;
            QMUIContinuousNestedBottomRecyclerView.access$000((QMUIContinuousNestedBottomRecyclerView)this.this$0).onScrollStateChange((View)recyclerView, 1);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int n, int n2) {
        if (QMUIContinuousNestedBottomRecyclerView.access$000((QMUIContinuousNestedBottomRecyclerView)this.this$0) == null) return;
        QMUIContinuousNestedBottomRecyclerView.access$000((QMUIContinuousNestedBottomRecyclerView)this.this$0).notify(recyclerView.computeVerticalScrollOffset(), Math.max(0, recyclerView.computeVerticalScrollRange() - recyclerView.getHeight()));
    }
}
