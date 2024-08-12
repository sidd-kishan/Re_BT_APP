/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.NestedAdapterWrapper$Callback
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 *  androidx.recyclerview.widget.ViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
 */
package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver = new /* Unavailable Anonymous Inner Class!! */;
    int mCachedItemCount;
    final Callback mCallback;
    private final StableIdStorage.StableIdLookup mStableIdLookup;
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.adapter = adapter;
        this.mCallback = callback;
        this.mViewTypeLookup = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdLookup;
        this.mCachedItemCount = this.adapter.getItemCount();
        this.adapter.registerAdapterDataObserver(this.mAdapterObserver);
    }

    void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int n) {
        long l = this.adapter.getItemId(n);
        return this.mStableIdLookup.localToGlobal(l);
    }

    int getItemViewType(int n) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(n));
    }

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        this.adapter.bindViewHolder(viewHolder, n);
    }

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        n = this.mViewTypeLookup.globalToLocal(n);
        return this.adapter.onCreateViewHolder(viewGroup, n);
    }
}
