/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package com.haibin.calendarview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

static abstract class BaseRecyclerAdapter.OnClickListener
implements View.OnClickListener {
    BaseRecyclerAdapter.OnClickListener() {
    }

    public abstract void onClick(int var1, long var2);

    public void onClick(View view) {
        view = (RecyclerView.ViewHolder)view.getTag();
        this.onClick(view.getAdapterPosition(), view.getItemId());
    }
}
