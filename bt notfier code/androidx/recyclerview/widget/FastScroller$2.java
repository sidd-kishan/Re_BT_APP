/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.FastScroller
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.FastScroller;
import androidx.recyclerview.widget.RecyclerView;

class FastScroller.2
extends RecyclerView.OnScrollListener {
    final FastScroller this$0;

    FastScroller.2(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void onScrolled(RecyclerView recyclerView, int n, int n2) {
        this.this$0.updateScrollPosition(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
