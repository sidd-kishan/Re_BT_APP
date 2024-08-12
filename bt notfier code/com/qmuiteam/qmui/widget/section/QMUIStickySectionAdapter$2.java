/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import android.view.View;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIStickySectionAdapter.2
implements View.OnLongClickListener {
    final QMUIStickySectionAdapter this$0;
    final int val$stickyPosition;
    final QMUIStickySectionAdapter.ViewHolder val$vh;

    QMUIStickySectionAdapter.2(QMUIStickySectionAdapter qMUIStickySectionAdapter, QMUIStickySectionAdapter.ViewHolder viewHolder, int n) {
        this.this$0 = qMUIStickySectionAdapter;
        this.val$vh = viewHolder;
        this.val$stickyPosition = n;
    }

    public boolean onLongClick(View view) {
        int n = this.val$vh.isForStickyHeader ? this.val$stickyPosition : this.val$vh.getAdapterPosition();
        if (n == -1) return false;
        if (QMUIStickySectionAdapter.access$000((QMUIStickySectionAdapter)this.this$0) == null) return false;
        return QMUIStickySectionAdapter.access$000((QMUIStickySectionAdapter)this.this$0).onItemLongClick(this.val$vh, n);
    }
}
