/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter$OnItemClickListener
 *  com.lianhezhuli.btnotification.base.adapter._$$Lambda$BaseRecyclerAdapter$XTIoIq43y9yLw3j4YJTdUPzjG_g
 */
package com.lianhezhuli.btnotification.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter;
import com.lianhezhuli.btnotification.base.adapter._$;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T>
extends RecyclerView.Adapter {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<T> mList;
    public OnItemClickListener mOnItemClickListener;

    public BaseRecyclerAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from((Context)context);
    }

    public void addItem(T t) {
        if (this.mList == null) {
            this.mList = new ArrayList<T>();
        }
        this.mList.add(t);
        this.notifyDataSetChanged();
    }

    public void addItem(List<T> list) {
        if (this.mList == null) {
            this.mList = new ArrayList<T>();
        }
        this.mList.addAll(list);
        this.notifyDataSetChanged();
    }

    public void clear() {
        if (this.mList == null) {
            this.mList = new ArrayList<T>();
        }
        this.mList.clear();
        this.notifyDataSetChanged();
    }

    protected View createView(ViewGroup viewGroup, int n) {
        return this.mInflater.inflate(n, viewGroup, false);
    }

    public int getItemCount() {
        List<T> list = this.mList;
        int n = list == null ? 0 : list.size();
        return n;
    }

    public List<T> getList() {
        if (this.mList != null) return this.mList;
        this.mList = new ArrayList<T>();
        return this.mList;
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$BaseRecyclerAdapter(RecyclerView.ViewHolder viewHolder, int n, View view) {
        this.mOnItemClickListener.onItemClick(viewHolder.itemView, this.mList.get(n), n);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        if (this.mOnItemClickListener == null) return;
        viewHolder.itemView.setOnClickListener((View.OnClickListener)new _$.Lambda.BaseRecyclerAdapter.XTIoIq43y9yLw3j4YJTdUPzjG_g(this, viewHolder, n));
    }

    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2);

    public void setFormatText(TextView textView, int n, String string) {
        textView.setText((CharSequence)String.format(this.mContext.getString(n), string));
    }

    public void setList(List<T> list) {
        if (this.mList == null) {
            this.mList = new ArrayList<T>();
        }
        if (list != null) {
            this.mList.clear();
            this.mList.addAll(list);
        } else {
            this.mList = new ArrayList<T>();
        }
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
