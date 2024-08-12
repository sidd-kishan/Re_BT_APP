/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

public static interface QMUIStickySectionItemDecoration.Callback<ViewHolder extends QMUIStickySectionAdapter.ViewHolder> {
    public void bindViewHolder(ViewHolder var1, int var2);

    public ViewHolder createViewHolder(ViewGroup var1, int var2);

    public int getItemViewType(int var1);

    public int getRelativeStickyItemPosition(int var1);

    public boolean isHeaderItem(int var1);

    public void onHeaderVisibilityChanged(boolean var1);

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver var1);
}
