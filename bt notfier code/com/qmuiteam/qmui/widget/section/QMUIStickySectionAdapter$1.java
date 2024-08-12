/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import android.view.View;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIStickySectionAdapter.1
implements View.OnClickListener {
    final QMUIStickySectionAdapter this$0;
    final int val$stickyPosition;
    final QMUIStickySectionAdapter.ViewHolder val$vh;

    QMUIStickySectionAdapter.1(QMUIStickySectionAdapter qMUIStickySectionAdapter, QMUIStickySectionAdapter.ViewHolder viewHolder, int n) {
        this.this$0 = qMUIStickySectionAdapter;
        this.val$vh = viewHolder;
        this.val$stickyPosition = n;
    }

    public void onClick(View view) {
        int n = this.val$vh.isForStickyHeader ? this.val$stickyPosition : this.val$vh.getAdapterPosition();
        if (n == -1) return;
        if (QMUIStickySectionAdapter.access$000((QMUIStickySectionAdapter)this.this$0) == null) return;
        QMUIStickySectionAdapter.access$000((QMUIStickySectionAdapter)this.this$0).onItemClick(this.val$vh, n);
    }
}
