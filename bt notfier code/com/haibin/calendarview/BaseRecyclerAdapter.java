/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.haibin.calendarview.BaseRecyclerAdapter$OnClickListener
 *  com.haibin.calendarview.BaseRecyclerAdapter$OnItemClickListener
 */
package com.haibin.calendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.haibin.calendarview.BaseRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;

abstract class BaseRecyclerAdapter<T>
extends RecyclerView.Adapter {
    Context mContext;
    LayoutInflater mInflater;
    private List<T> mItems;
    private OnClickListener onClickListener;
    private OnItemClickListener onItemClickListener;

    BaseRecyclerAdapter(Context context) {
        this.mContext = context;
        this.mItems = new ArrayList<T>();
        this.mInflater = LayoutInflater.from((Context)context);
        this.onClickListener = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ OnItemClickListener access$000(BaseRecyclerAdapter baseRecyclerAdapter) {
        return baseRecyclerAdapter.onItemClickListener;
    }

    void addAll(List<T> list) {
        if (list == null) return;
        if (list.size() <= 0) return;
        this.mItems.addAll(list);
        this.notifyItemRangeInserted(this.mItems.size(), list.size());
    }

    final void addItem(T t) {
        if (t == null) return;
        this.mItems.add(t);
        this.notifyItemChanged(this.mItems.size());
    }

    final T getItem(int n) {
        if (n < 0) return null;
        if (n < this.mItems.size()) return this.mItems.get(n);
        return null;
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    final List<T> getItems() {
        return this.mItems;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        this.onBindViewHolder(viewHolder, this.mItems.get(n), n);
    }

    abstract void onBindViewHolder(RecyclerView.ViewHolder var1, T var2, int var3);

    abstract RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup var1, int var2);

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        if ((viewGroup = this.onCreateDefaultViewHolder(viewGroup, n)) == null) return viewGroup;
        viewGroup.itemView.setTag((Object)viewGroup);
        viewGroup.itemView.setOnClickListener((View.OnClickListener)this.onClickListener);
        return viewGroup;
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
