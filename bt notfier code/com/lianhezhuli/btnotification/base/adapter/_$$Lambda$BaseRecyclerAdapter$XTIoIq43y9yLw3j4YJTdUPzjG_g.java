/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter
 */
package com.lianhezhuli.btnotification.base.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter;

public final class _$$Lambda$BaseRecyclerAdapter$XTIoIq43y9yLw3j4YJTdUPzjG_g
implements View.OnClickListener {
    private final BaseRecyclerAdapter f$0;
    private final RecyclerView.ViewHolder f$1;
    private final int f$2;

    public /* synthetic */ _$$Lambda$BaseRecyclerAdapter$XTIoIq43y9yLw3j4YJTdUPzjG_g(BaseRecyclerAdapter baseRecyclerAdapter, RecyclerView.ViewHolder viewHolder, int n) {
        this.f$0 = baseRecyclerAdapter;
        this.f$1 = viewHolder;
        this.f$2 = n;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$0$BaseRecyclerAdapter(this.f$1, this.f$2, view);
    }
}
