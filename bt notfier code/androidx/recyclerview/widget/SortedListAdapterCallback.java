/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.SortedList$Callback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2>
extends SortedList.Callback<T2> {
    final RecyclerView.Adapter mAdapter;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void onChanged(int n, int n2) {
        this.mAdapter.notifyItemRangeChanged(n, n2);
    }

    public void onChanged(int n, int n2, Object object) {
        this.mAdapter.notifyItemRangeChanged(n, n2, object);
    }

    public void onInserted(int n, int n2) {
        this.mAdapter.notifyItemRangeInserted(n, n2);
    }

    public void onMoved(int n, int n2) {
        this.mAdapter.notifyItemMoved(n, n2);
    }

    public void onRemoved(int n, int n2) {
        this.mAdapter.notifyItemRangeRemoved(n, n2);
    }
}
