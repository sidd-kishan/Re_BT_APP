/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AdapterListUpdateCallback
 *  androidx.recyclerview.widget.AsyncDifferConfig
 *  androidx.recyclerview.widget.AsyncDifferConfig$Builder
 *  androidx.recyclerview.widget.AsyncListDiffer
 *  androidx.recyclerview.widget.AsyncListDiffer$ListListener
 *  androidx.recyclerview.widget.DiffUtil$ItemCallback
 *  androidx.recyclerview.widget.ListUpdateCallback
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener = new /* Unavailable Anonymous Inner Class!! */;

    protected ListAdapter(AsyncDifferConfig<T> asyncListDiffer) {
        this.mDiffer = asyncListDiffer = new AsyncListDiffer((ListUpdateCallback)new AdapterListUpdateCallback((RecyclerView.Adapter)this), asyncListDiffer);
        asyncListDiffer.addListListener(this.mListener);
    }

    protected ListAdapter(DiffUtil.ItemCallback<T> asyncListDiffer) {
        this.mDiffer = asyncListDiffer = new AsyncListDiffer((ListUpdateCallback)new AdapterListUpdateCallback((RecyclerView.Adapter)this), new AsyncDifferConfig.Builder(asyncListDiffer).build());
        asyncListDiffer.addListListener(this.mListener);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    protected T getItem(int n) {
        return (T)this.mDiffer.getCurrentList().get(n);
    }

    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    public void submitList(List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }
}
