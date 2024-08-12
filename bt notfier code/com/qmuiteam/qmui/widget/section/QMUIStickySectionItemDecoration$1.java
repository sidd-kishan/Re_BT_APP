/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration
 */
package com.qmuiteam.qmui.widget.section;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIStickySectionItemDecoration.1
extends RecyclerView.AdapterDataObserver {
    final QMUIStickySectionItemDecoration this$0;

    QMUIStickySectionItemDecoration.1(QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration) {
        this.this$0 = qMUIStickySectionItemDecoration;
    }

    public void onItemRangeChanged(int n, int n2) {
        super.onItemRangeChanged(n, n2);
        if (QMUIStickySectionItemDecoration.access$000((QMUIStickySectionItemDecoration)this.this$0) < n) return;
        if (QMUIStickySectionItemDecoration.access$000((QMUIStickySectionItemDecoration)this.this$0) >= n + n2) return;
        if (QMUIStickySectionItemDecoration.access$100((QMUIStickySectionItemDecoration)this.this$0) == null) return;
        if (QMUIStickySectionItemDecoration.access$200((QMUIStickySectionItemDecoration)this.this$0).get() == null) return;
        QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration = this.this$0;
        QMUIStickySectionItemDecoration.access$300((QMUIStickySectionItemDecoration)qMUIStickySectionItemDecoration, (ViewGroup)((ViewGroup)QMUIStickySectionItemDecoration.access$200((QMUIStickySectionItemDecoration)qMUIStickySectionItemDecoration).get()), (QMUIStickySectionAdapter.ViewHolder)QMUIStickySectionItemDecoration.access$100((QMUIStickySectionItemDecoration)this.this$0), (int)QMUIStickySectionItemDecoration.access$000((QMUIStickySectionItemDecoration)this.this$0));
    }

    public void onItemRangeRemoved(int n, int n2) {
        super.onItemRangeRemoved(n, n2);
        if (QMUIStickySectionItemDecoration.access$000((QMUIStickySectionItemDecoration)this.this$0) < n) return;
        if (QMUIStickySectionItemDecoration.access$000((QMUIStickySectionItemDecoration)this.this$0) >= n + n2) return;
        QMUIStickySectionItemDecoration.access$002((QMUIStickySectionItemDecoration)this.this$0, (int)-1);
        QMUIStickySectionItemDecoration.access$400((QMUIStickySectionItemDecoration)this.this$0, (boolean)false);
    }
}
