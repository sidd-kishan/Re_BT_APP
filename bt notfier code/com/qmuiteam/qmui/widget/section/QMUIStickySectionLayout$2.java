/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration$Callback
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout
 */
package com.qmuiteam.qmui.widget.section;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionItemDecoration;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

class QMUIStickySectionLayout.2
implements QMUIStickySectionItemDecoration.Callback<VH> {
    final QMUIStickySectionLayout this$0;
    final QMUIStickySectionAdapter val$adapter;

    QMUIStickySectionLayout.2(QMUIStickySectionLayout qMUIStickySectionLayout, QMUIStickySectionAdapter qMUIStickySectionAdapter) {
        this.this$0 = qMUIStickySectionLayout;
        this.val$adapter = qMUIStickySectionAdapter;
    }

    public void bindViewHolder(VH VH, int n) {
        this.val$adapter.bindViewHolder(VH, n);
    }

    public VH createViewHolder(ViewGroup viewGroup, int n) {
        return (QMUIStickySectionAdapter.ViewHolder)this.val$adapter.createViewHolder(viewGroup, n);
    }

    public int getItemViewType(int n) {
        return this.val$adapter.getItemViewType(n);
    }

    public int getRelativeStickyItemPosition(int n) {
        return this.val$adapter.getRelativeStickyPosition(n);
    }

    public boolean isHeaderItem(int n) {
        boolean bl = this.val$adapter.getItemViewType(n) == 0;
        return bl;
    }

    public void onHeaderVisibilityChanged(boolean bl) {
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.val$adapter.registerAdapterDataObserver(adapterDataObserver);
    }
}
