/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  com.lianhezhuli.btnotification.view.SwipeRecycler
 */
package com.lianhezhuli.btnotification.view;

import androidx.recyclerview.widget.RecyclerView;
import com.lianhezhuli.btnotification.view.SwipeRecycler;

/*
 * Exception performing whole class analysis ignored.
 */
class SwipeRecycler.1
extends RecyclerView.OnScrollListener {
    final SwipeRecycler this$0;

    SwipeRecycler.1(SwipeRecycler swipeRecycler) {
        this.this$0 = swipeRecycler;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int n) {
        super.onScrollStateChanged(recyclerView, n);
        if (n != 0) return;
        SwipeRecycler.access$002((SwipeRecycler)this.this$0, (boolean)false);
    }
}
