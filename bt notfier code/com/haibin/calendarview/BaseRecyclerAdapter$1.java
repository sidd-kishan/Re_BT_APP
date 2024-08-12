/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.BaseRecyclerAdapter
 *  com.haibin.calendarview.BaseRecyclerAdapter$OnClickListener
 */
package com.haibin.calendarview;

import com.haibin.calendarview.BaseRecyclerAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
class BaseRecyclerAdapter.1
extends BaseRecyclerAdapter.OnClickListener {
    final BaseRecyclerAdapter this$0;

    BaseRecyclerAdapter.1(BaseRecyclerAdapter baseRecyclerAdapter) {
        this.this$0 = baseRecyclerAdapter;
    }

    public void onClick(int n, long l) {
        if (BaseRecyclerAdapter.access$000((BaseRecyclerAdapter)this.this$0) == null) return;
        BaseRecyclerAdapter.access$000((BaseRecyclerAdapter)this.this$0).onItemClick(n, l);
    }
}
