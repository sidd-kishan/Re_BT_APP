/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ListUpdateCallback
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback
implements ListUpdateCallback {
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
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
