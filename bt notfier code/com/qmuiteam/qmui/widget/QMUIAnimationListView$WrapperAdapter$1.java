/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$WrapperAdapter
 */
package com.qmuiteam.qmui.widget;

import android.database.DataSetObserver;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIAnimationListView.WrapperAdapter.1
extends DataSetObserver {
    final QMUIAnimationListView.WrapperAdapter this$0;

    QMUIAnimationListView.WrapperAdapter.1(QMUIAnimationListView.WrapperAdapter wrapperAdapter) {
        this.this$0 = wrapperAdapter;
    }

    public void onChanged() {
        if (!QMUIAnimationListView.WrapperAdapter.access$700((QMUIAnimationListView.WrapperAdapter)this.this$0)) return;
        this.this$0.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.this$0.notifyDataSetInvalidated();
    }
}
